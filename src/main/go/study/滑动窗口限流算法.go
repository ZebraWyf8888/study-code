package main

import (
	"sync"
	"time"
)

// 10s 一个格子
var subCycle int64 = 10

var threshold int64 = 100

var mapC = make(map[int64]int64)

var mu2 sync.Mutex

func 滑动窗口限流算法() bool {

	mu2.Lock()
	defer mu2.Unlock()

	curr := time.Now().Unix()
	//  找到当前时间所在的10秒窗口
	key := curr / subCycle

	// 这个小周期窗口的开始时间
	key = key * subCycle

	value := countValue(key)

	//超过阀值限流
	if value >= threshold {
		return false
	}

	//计数器+1
	curC := mapC[key]
	mapC[key] = curC + 1
	return true
}

func countValue(key int64) int64 {
	//计算窗口开始位置
	startTime := key - subCycle*(60/subCycle-1)
	var countNow int64

	for mkey, value := range mapC {
		if mkey < startTime {
			delete(mapC, mkey)
		} else {
			countNow = countNow + value
		}

	}
	return countNow
}
func main() {
	for {
		println(滑动窗口限流算法())
	}
}
