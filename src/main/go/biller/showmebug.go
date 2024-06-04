package biller

import (
	"fmt"
	"time"

	"cloud.google.com/go/civil"
)

// BillService
// Provide the ability to bill enterprise subscription fee.
type BillService struct {
}

func NewBillService() *BillService {
	return &BillService{}
}

// comment: 1、命名不规范问题 ，SO 应该改为小写，s应该做到见名知意，最少也要和下面的BillService名字统一 叫 svc
// comment: 2、方法注释都要写在前面，如 ：BillCurrentPeriodSubscriptionFee

// BillCurrentPeriodSubscriptionFee 	bill current period subscription fee.
func (s *BillService) BillCurrentPeriodSubscriptionFee(SO SalesOrder) (SubscriptionFeeBill, error) {
	// validate sales order
	// comment: 3、这里都error没有处理
	err := s.validateSalesOrder(&SO)

	// find all billing period of this sales order.
	periods := RetrieveAllBillingPeriodsOfSalesOrder(Period{
		StartDate: SO.StartDate,
		EndDate:   SO.EndDate,
	}, SO.BillingCycle)
	// get current billing period.
	currentPeriod, err := s.getCurrentPeriod(periods)
	if err != nil {
		return SubscriptionFeeBill{}, err
	}

	// calculate subscription fee for current period.
	subscriptionFeeBill, err := s.CalculateSubscriptionFee(currentPeriod, SO)
	if err != nil {
		return SubscriptionFeeBill{}, err
	}
	return subscriptionFeeBill, nil
}

// comment: 4、接受者BillService如果是大的类型，建议使用指针，validateSalesOrder方法没有使用指针，使用指针可以减少内存拷贝
// comment: 5、方法名字叫validateSalesOrder，但在实际中却把订单状态“suspended”改为"void"
func (svc BillService) validateSalesOrder(SO *SalesOrder) error {
	if SO.SalesOrderNo == "" {
		// comment: 6、应该使用 errors.Errorf()，并且打日志的时候最好要带个id，这样方便排查问题，否则出现一堆invalid sales order no，不知道从哪来的
		return fmt.Errorf("invalid sales order no")
	}
	// comment: 7、订单的状态流转应该有一个类似状态机的东西表示，不应该上魔法值，或者应该用枚举，同时这个转换一个说明缘由，加注释
	if SO.Status == "suspended" {
		SO.Status = "void"
	}
	return nil
}

func (svc *BillService) getCurrentPeriod(periods []Period) (Period, error) {
	var filteredPeriods []Period
	// get periods include today
	for _, period := range periods {
		// comment: 8、这里没循环一次就要 time.Now().UTC() 如果不严格要求时间精确到毫秒，可以提前考虑init一个时间变量
		if period.Include(civil.DateOf(time.Now().UTC())) {
			filteredPeriods = append(filteredPeriods, period)
		}
	}

	//  comment:  9、应该使用 errors.Errorf() ，同时打的error内容要带上一些关键信息
	// comment:  10、filteredPeriods[0] 考虑一下，如果长度为0，要处理一下
	if len(filteredPeriods) == 0 || len(filteredPeriods) > 1 {
		return Period{}, fmt.Errorf("today is not in periods" + "or" +
			"" + "\"periods overlapped: multilple periods include today\"")
	}
	return filteredPeriods[0], nil

}

// comment：11、这个方法名字太长了，适当缩短
func RetrieveAllBillingPeriodsOfSalesOrder(salesOrderPeriod Period, billingCycle string) []Period {
	// Sales Order start date must be earlier than end date
	if salesOrderPeriod.StartDate.After(salesOrderPeriod.EndDate) || salesOrderPeriod.StartDate == salesOrderPeriod.EndDate {
		// comment：12、这里应该有返回error或者打日志提示
		return nil
	}
	// comment：13、订单的状态流转应该有一个类似状态机的东西表示，不应该上魔法值，或者应该用枚举
	// Only one billing period for 'one-off' & 'per-order' billing cycle type.
	if billingCycle == "one-off" ||
		billingCycle == "per-order" {
		return []Period{{
			StartDate: salesOrderPeriod.StartDate,
			EndDate:   salesOrderPeriod.EndDate,
		}}
	}
	// find the first period
	currentPeriod := Period{}
	currentPeriod.StartDate = salesOrderPeriod.StartDate
	start := salesOrderPeriod.StartDate.In(time.UTC)
	end := time.Time{}
	switch billingCycle {
	case "calendar-month":
		y, m, _ := start.Date()
		end = time.Date(y, m, 1, 0, 0, 0, 0, start.Location()).
			AddDate(0, 1, 0).
			Add(-time.Second)
	case "monthly":
		end = start.AddDate(0, 1, 0).Add(-time.Hour * 24)
	case "quarterly":
		end = start.AddDate(0, 3, 0).Add(-time.Hour * 24)
	case "bi-annually":
		end = start.AddDate(0, 6, 0).Add(-time.Hour * 24)
	case "annually":
		end = start.AddDate(1, 0, 0).Add(-time.Hour * 24)
	}
	currentPeriod.EndDate = civil.DateOf(end)

	// no more period after the first one.
	if currentPeriod.EndDate.After(salesOrderPeriod.EndDate) {
		currentPeriod.EndDate = salesOrderPeriod.EndDate
		return []Period{currentPeriod}
	}

	var allPeriods []Period
	// put the first period in.
	allPeriods = append(allPeriods, currentPeriod)

	// use current period as a cursor to iterate & find all periods
	// for range until current period end date greater than sales order end date.
	// comment：14、代码封装，与上面的逻辑重复 可以抽象成一个方法
	for currentPeriod.EndDate.Before(salesOrderPeriod.EndDate) {
		// find next billing period
		var nextBillingPeriod Period

		nextStart := currentPeriod.EndDate.AddDays(1)
		nextBillingPeriod.StartDate = nextStart
		var nextEnd time.Time

		switch billingCycle {
		case "calendar-month":
			y, m, _ := nextStart.In(time.UTC).Date()
			nextEnd = time.Date(y, m, 1, 0, 0, 0, 0, nextStart.In(time.UTC).Location()).
				AddDate(0, 1, 0).
				Add(-time.Second)
		case "monthly":
			nextEnd = nextStart.In(time.UTC).AddDate(0, 1, 0).Add(-time.Hour * 24)
		case "quarterly":
			nextEnd = nextStart.In(time.UTC).AddDate(0, 3, 0).Add(-time.Hour * 24)
		case "bi-annually":
			nextEnd = nextStart.In(time.UTC).AddDate(0, 6, 0).Add(-time.Hour * 24)
		case "annually":
			nextEnd = nextStart.In(time.UTC).AddDate(1, 0, 0).Add(-time.Hour * 24)
		}
		nextBillingPeriod.EndDate = civil.DateOf(nextEnd)

		// it's the last period if next period end date greater than sales order end date
		if nextBillingPeriod.EndDate.After(salesOrderPeriod.EndDate) {
			nextBillingPeriod.EndDate = salesOrderPeriod.EndDate
		}
		allPeriods = append(allPeriods, nextBillingPeriod)
		// cursor ++
		currentPeriod = nextBillingPeriod
	}
	return allPeriods
}

func (svc *BillService) CalculateSubscriptionFee(currentPeriod Period, SO SalesOrder) (SubscriptionFeeBill, error) {
	panic("not implemented") // This PR does not involve implementing the method.
}

type Period struct {
	StartDate civil.Date
	EndDate   civil.Date
}

func (p Period) Include(date civil.Date) bool {
	start := p.StartDate.In(time.UTC).Unix()
	end := p.EndDate.In(time.UTC).Unix()
	specifiedDate := date.In(time.UTC).Unix()
	return start <= specivfiedDate && specifiedDate <= end
}

type SalesOrder struct {
	ID              string
	Customer        any // comment：15、不应该使用 any，应该是明确的类型
	SalesOrderNo    string
	BillingCycle    string // comment：16、 建议使用枚举 enum: calendar-month, monthly, quarterly, bi-annually, annually, one-off, per-order
	ChargeType      string
	Status          string
	StartDate       civil.Date // comment：17、Period存在StartDate+EndDate，建议替换
	EndDate         civil.Date // comment：18、这里的日期用civil.Date ，下面的时间用 time.Time，建议统一且使用 time包 ，若出现对外对接的情况，会更方便对接
	ContractType    string
	ContractSubType string
	CreatedAt       time.Time
	UpdatedAt       time.Time
	VoidedAt        time.Time
}

// comment:19、 BillCurrentPeriodSubscriptionFee方法涉及对订单的多个操作环节，若中间环节失败，可能有不一致场景，需要考虑

type SubscriptionFeeBill struct{} // This PR does not involve defining the model.
