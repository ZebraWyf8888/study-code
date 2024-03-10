package main

import (
	"fmt"
	"sort"
	"time"
)


// hitIdToMsgMap的 key是id，value的 AssociatedID是关联的id集合
func remDupCase2(hitIdToMsgMap map[string]OpinionCaseMSg) []string {
	// 提取最早发布时间的关联ID，并进行排序
	var earliestIDs []string
	timeMap := make(map[string]int64)

	for _, msg := range hitIdToMsgMap {
		if len(msg.AssociatedID) > 0 {
			// Sort AssociatedID based on ReleaseTime
			sort.Slice(msg.AssociatedID, func(i, j int) bool {
				return hitIdToMsgMap[msg.AssociatedID[i]].ReleaseTime < hitIdToMsgMap[msg.AssociatedID[j]].ReleaseTime
			})
			earliestID := msg.AssociatedID[0]
			if releaseTime, ok := timeMap[earliestID]; !ok || msg.ReleaseTime < releaseTime {
				timeMap[earliestID] = msg.ReleaseTime
			}
		}
	}

	for id, releaseTime := range timeMap {
		earliestIDs = append(earliestIDs, id)
		// You can print the releaseTime if needed
		fmt.Printf("ID: %s, Earliest Release Time: %s\n", id, time.Unix(releaseTime, 0))
	}

	sort.Strings(earliestIDs)
	return earliestIDs
}

func main() {
	// 创建测试数据
	testData := map[string]OpinionCaseMSg{
		"1": {AssociatedID: []string{"2", "3"}, ReleaseTime: time.Date(2023, time.November, 1, 12, 0, 0, 0, time.UTC).Unix()},
		"2": {AssociatedID: []string{}, ReleaseTime: time.Date(2023, time.November, 1, 10, 0, 0, 0, time.UTC).Unix()},
		"3": {AssociatedID: []string{}, ReleaseTime: time.Date(2023, time.November, 1, 11, 0, 0, 0, time.UTC).Unix()},
		// 根据需要添加更多的测试用例
	}

	// 调用函数
	result := remDupCase2(testData)

	// 打印结果
	fmt.Println("Result:", result)
}
