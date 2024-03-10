package main

import (
	"fmt"
	"time"
)

type OpinionCaseMSg struct {
	AssociatedID []string // 关联的id集合
	ReleaseTime  int64 // 将 ReleaseTime 改为 int64 时间戳表示
}

// hitIdToMsgMap的 key是id，value的 AssociatedID是关联的id集合
func remDupCase(hitIdToMsgMap map[string]OpinionCaseMSg) []string {
	// 提取最早发布时间的关联ID，并进行排序
	var earliestIDs []string


	return earliestIDs
}

func main() {
	// 创建测试数据
	testData := map[string]OpinionCaseMSg{
		"1": {AssociatedID: []string{ "2", "3"}, ReleaseTime: time.Date(2023, time.November, 1, 12, 0, 0, 0, time.UTC).Unix()},
		"2": {AssociatedID: []string{}, ReleaseTime: time.Date(2023, time.November, 1, 10, 0, 0, 0, time.UTC).Unix()},
		"3": {AssociatedID: []string{}, ReleaseTime: time.Date(2023, time.November, 1, 11, 0, 0, 0, time.UTC).Unix()},
		// 根据需要添加更多的测试用例
	}

	// 调用函数
	result := remDupCase(testData)

	// 打印结果
	fmt.Println("Result:", result)
}
