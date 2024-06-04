package main

import (
	"fmt"
	"sync"
	"sync/atomic"
	"time"
)

/*
场景：在一个高并发的web服务器中，要限制IP的频繁访问。现模拟100个IP同时并发访问服务器，每个IP要重复访问1000次。每个IP三分钟之内只能访问一次。修改以下代码完成该过程，要求能成功输出 success:100
*/

type Ban struct {
	visitIPs sync.Map
}

func NewBan() *Ban {
	return &Ban{}
}
func (o *Ban) visit(ip string) bool {

	if _, ok := o.visitIPs.Load(ip); !ok {
		// o.visitIPs.
		// o.visitIPs[ip] =
		o.visitIPs.Store(ip, time.Now().Unix())
		return true
	}
	curr := time.Now().Unix()

	ans, _ := o.visitIPs.Load(ip)
	if ans.(int64)-curr > 3*60 {
		o.visitIPs.Store(ip, time.Now().Unix())
		return true
	} else {
		return false
	}

}
func main() {
	var success int32 = 0
	ban := NewBan()
	for i := 0; i < 1000; i++ {
		for j := 0; j < 100; j++ {
			go func() {
				ip := fmt.Sprintf("192.168.1.%d", j)
				if !ban.visit(ip) {
					atomic.AddInt32(&success, 1)
				}
			}()
		}

	}

	success = atomic.LoadInt32(&success)
	fmt.Println("success:", success)
}
