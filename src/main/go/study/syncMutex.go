package main

import (
	"sync"
)

//共享的资源

var sum = 0
var  mutex sync.RWMutex
//
//func main() {
//
//	//开启100个协程让sum+10
//
//	for i := 0; i < 100; i++ {
//
//		go addTen(10)
//
//	}
//
//	for i := 0; i < 100; i++ {
//
//		fmt.Print("当前sum的值是",readSum())
//
//	}
//
//	//防止提前退出
//
//	time.Sleep(2 * time.Second)
//
//	fmt.Println("和为:",sum)
//
//}

func readSum() int {
	mutex.RLock()
	defer mutex.RUnlock()
	b:=sum
	return b

}

func addTen(i int) {
	mutex.Lock()
	defer mutex.Unlock()
	sum += i
}
