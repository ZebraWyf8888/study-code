//package main
//
//import (
//	"fmt"
//	"sync"
//)

//	func increase() int {
//		var i = 1
//		defer func() {
//			i++
//			fmt.Println("defer: ", i)
//		}()
//		i += 2
//		fmt.Println("increase: ", i)
//		return i
//	}
//
//	func main() {
//		fmt.Println("main:", increase())
//	}
//var days = 0
//
//func work() func(days *int) int {
//	return func(days *int) int {
//		*days++
//		return *days
//	}
//}
//
//func main() {
//
//	closure := work()
//	fmt.Println(closure(&days))
//	fmt.Println(closure(&days))
//}

//func func1() (i int) {
//	i = 100
//	defer func() {
//		i += 1
//	}()
//	return 5
//}
//
//func func2() int {
//	var i int
//	defer func() {
//		i += 1
//
//	}()
//	i += 100
//
//	return i
//}
//
//func main() {
//	fmt.Println(func1())
//	fmt.Println(func2())
//}

package main

import (
	"fmt"
	"sync"
)

func main() {
	myMap := make(map[string]string)
	var wg sync.WaitGroup

	// 两个goroutine并发地修改map，没有同步机制
	for i := 0; i < 2; i++ {
		wg.Add(1)
		go func(id int) {
			defer wg.Done()

			key := fmt.Sprintf("key%d", id)
			value := fmt.Sprintf("value%d", id)

			// 并发写操作，可能导致数据竞争
			myMap[key] = value
		}(i)
	}

	wg.Wait()

	// 输出最终的map内容
	fmt.Println("Final Map:")
	for key, value := range myMap {
		fmt.Printf("Key: %s, Value: %s\n", key, value)
	}
}
