package main

import (
	"sync"
	"time"
)

// 调用次数的统计
var count = 1

// 窗口大小, 单位毫秒
var windowSize int64 = 1000

// 最大调用次数 ,结合windowSize，表示没1000ms最多请求10次
var maxCount = 10
var mu sync.Mutex

// 上次请求时间
var lastReqTime int64

func 固定窗口时间算法() bool {

	curr := time.Now().Unix()

	mu.Lock()
	defer mu.Unlock()
	if curr > lastReqTime+windowSize {
		lastReqTime = curr
		count = 0
	}
	// 3. 其他情况
	count++
	println(count)
	if maxCount < count {
		return false
	}
	return true
}

func main() {

	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())
	println(固定窗口时间算法())

	println(固定窗口时间算法())
	println(固定窗口时间算法())

}
