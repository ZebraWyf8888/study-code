package main

import "fmt"


func main() {
	testMapRand()
}
//https://juejin.cn/post/7244736003738239033
func testMapRand() {
	services := map[string]string{}
	services["IP1"] = "client1"
	services["IP2"] = "client2"
	services["IP3"] = "client3"

	// 计数用的
	count := map[string]int{}

	for i := 0; i < 2000; i++ {
		for k, _ := range services {
			count[k]++
			break
		}
	}
	fmt.Println(count)
}


