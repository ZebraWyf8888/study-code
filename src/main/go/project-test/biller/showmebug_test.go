package biller

//// 说明：
////一、小的测试
//// 先确保小的方法没问题，在时机测试总可以免去很多问题，如TestBillService_BillCurrentPeriodSubscriptionFee1
////二、大的测试
//// 1、7种计费类型都各需要一个或者多个测试用例，以此作为命名，如monthly_1、one-off_1
//// 2、时间问题，代码涉及大量时间加减，有可能存在边界值问题，按照每月一次,31天一个月的 和30天为一个月的，各需要一个用例。
////三、测试的覆盖问题
//// go test -cover 可以使用go工具去查看代码测试覆盖率
////
//
//package biller
//
//import (
//	"reflect"
//	"testing"
//	"time"
//
//	"cloud.google.com/go/civil"
//)
//
//func TestBillService_BillCurrentPeriodSubscriptionFee(t *testing.T) {
//	type args struct {
//		SO SalesOrder
//	}
//	tests := []struct {
//		name    string
//		args    args
//		want    SubscriptionFeeBill
//		wantErr bool
//	}{
//
//		{
//			name: "one-off",
//			args: args{
//				SO: SalesOrder{
//					StartDate:       civil.Date{},
//					ContractType:    "",
//					CreatedAt:       time.Time{},
//					UpdatedAt:       time.Time{},
//					Customer:        nil,
//					ChargeType:      "",
//					VoidedAt:        time.Time{},
//					ID:              "",
//					Status:          "",
//					ContractSubType: "",
//				},
//			},
//		},
//		{
//			name: "per-order",
//			args: args{
//				SO: SalesOrder{
//					StartDate:       civil.Date{},
//					ContractType:    "",
//					CreatedAt:       time.Time{},
//					UpdatedAt:       time.Time{},
//					Customer:        nil,
//					ChargeType:      "",
//					VoidedAt:        time.Time{},
//					ID:              "",
//					Status:          "",
//					ContractSubType: "",
//				},
//			},
//		}, {
//			name: "calendar-month",
//			args: args{
//				SO: SalesOrder{
//					StartDate:       civil.Date{},
//					ContractType:    "",
//					CreatedAt:       time.Time{},
//					UpdatedAt:       time.Time{},
//					Customer:        nil,
//					ChargeType:      "",
//					VoidedAt:        time.Time{},
//					ID:              "",
//					Status:          "",
//					ContractSubType: "",
//				},
//			},
//		},
//		{
//			name: "monthly",
//			args: args{
//				SO: SalesOrder{
//					StartDate:       civil.Date{},
//					ContractType:    "",
//					CreatedAt:       time.Time{},
//					UpdatedAt:       time.Time{},
//					Customer:        nil,
//					ChargeType:      "",
//					VoidedAt:        time.Time{},
//					ID:              "",
//					Status:          "",
//					ContractSubType: "",
//				},
//			},
//		},
//		{
//			name: "quarterly",
//			args: args{
//				SO: SalesOrder{
//					StartDate:       civil.Date{},
//					ContractType:    "",
//					CreatedAt:       time.Time{},
//					UpdatedAt:       time.Time{},
//					Customer:        nil,
//					ChargeType:      "",
//					VoidedAt:        time.Time{},
//					ID:              "",
//					Status:          "",
//					ContractSubType: "",
//				},
//			},
//		},
//		{
//			name: "bi-annually",
//			args: args{
//				SO: SalesOrder{
//					StartDate:       civil.Date{},
//					ContractType:    "",
//					CreatedAt:       time.Time{},
//					UpdatedAt:       time.Time{},
//					Customer:        nil,
//					ChargeType:      "",
//					VoidedAt:        time.Time{},
//					ID:              "",
//					Status:          "",
//					ContractSubType: "",
//				},
//			},
//		},
//		{
//			name: "annually",
//			args: args{
//				SO: SalesOrder{
//					StartDate:       civil.Date{},
//					ContractType:    "",
//					CreatedAt:       time.Time{},
//					UpdatedAt:       time.Time{},
//					Customer:        nil,
//					ChargeType:      "",
//					VoidedAt:        time.Time{},
//					ID:              "",
//					Status:          "",
//					ContractSubType: "",
//				},
//			},
//		},
//	}
//	for _, tt := range tests {
//		t.Run(tt.name, func(t *testing.T) {
//			s := &BillService{}
//			got, err := s.BillCurrentPeriodSubscriptionFee(tt.args.SO)
//			if (err != nil) != tt.wantErr {
//				t.Errorf("BillCurrentPeriodSubscriptionFee() error = %v, wantErr %v", err, tt.wantErr)
//				return
//			}
//			if !reflect.DeepEqual(got, tt.want) {
//				t.Errorf("BillCurrentPeriodSubscriptionFee() got = %v, want %v", got, tt.want)
//			}
//		})
//	}
//}
//
//func TestBillService_BillCurrentPeriodSubscriptionFee1(t *testing.T) {
//	type args struct {
//		SO SalesOrder
//	}
//	tests := []struct {
//		name    string
//		args    args
//		want    SubscriptionFeeBill
//		wantErr bool
//	}{
//		{args: args{
//			SO: SalesOrder{
//				StartDate:       civil.Date{},
//				ContractType:    "",
//				CreatedAt:       time.Time{},
//				UpdatedAt:       time.Time{},
//				Customer:        nil,
//				ChargeType:      "",
//				VoidedAt:        time.Time{},
//				ID:              "",
//				Status:          "",
//				ContractSubType: "",
//			},
//		},
//		},
//	}
//	for _, tt := range tests {
//		t.Run(tt.name, func(t *testing.T) {
//			s := &BillService{}
//			got, err := s.BillCurrentPeriodSubscriptionFee(tt.args.SO)
//			if (err != nil) != tt.wantErr {
//				t.Errorf("BillCurrentPeriodSubscriptionFee() error = %v, wantErr %v", err, tt.wantErr)
//				return
//			}
//			if !reflect.DeepEqual(got, tt.want) {
//				t.Errorf("BillCurrentPeriodSubscriptionFee() got = %v, want %v", got, tt.want)
//			}
//		})
//	}
//}
