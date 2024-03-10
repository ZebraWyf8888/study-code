package main

import (
	"sync"
	"time"
)

var cap int64 = 10

// 速率 每秒的请求个数
var rate int64 = 1

var water int64 = 0

var lastReqTime1 int64 = 0

var mu3 sync.Mutex

func 漏斗限流算法(reqc int64) bool {

	mu3.Lock()
	defer mu3.Unlock()

	leak()
	if water <= cap {
		water = water + reqc
		return true
	}
	return false
}

func leak() {
	now := time.Now().Unix()
	elapedTime := now - lastReqTime1
	leakedwate := elapedTime * rate
	if leakedwate > 0 {
		water = Max(0, water-leakedwate)
		lastReqTime1 = now
	}
}

func Max(i int64, i2 int64) int64 {
	if i > i2 {
		return i
	}
	return i2

}

func main() {
	for {
		println(漏斗限流算法(1))
	}

}
