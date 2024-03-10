package main

import (
	"sync"
	"time"
)

var cap2 int64 = 10

// 速率 每秒的请求个数
var rate2 int64 = 1

var token int64 = 0

var lastReqTime2 int64 = 0

var mu4 sync.Mutex

func 令牌桶算法(reqc int64) bool {

	mu4.Lock()
	defer mu4.Unlock()

	refill()
	if token > 0 {
		token--
		return true
	}
	return false
}

func refill() {
	now := time.Now().Unix()

	if now > lastReqTime2 {
		elapedTime := now - lastReqTime2
		tokenNum := elapedTime * rate2
		token = Min(token+tokenNum, cap2)
		lastReqTime2 = now
	}

}

func Min(i int64, i2 int64) int64 {
	if i < i2 {
		return i
	}
	return i2
}

func main() {
	for {
		println(令牌桶算法(1))
	}

}
