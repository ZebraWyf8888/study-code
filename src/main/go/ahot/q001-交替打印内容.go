//package main
//
//func main() {
//	// 创建一个整型通道
//	ch := make(chan int)
//	// 尝试将0通过通道发送
//	ch <- 0
//
//	data := <-ch
//	print(data)
//}

//报错的意思是：运行时发现所有的 goroutine（包括main）都处于等待 goroutine。
//也就是说所有 goroutine 中的 channel 并没有形成发送和接收对应的代码。
//
//package main
//
//import (
//	"fmt"
//)
//
//func main() {
//
//	// 构建一个通道
//	ch := make(chan int)
//
//	// 开启一个并发匿名函数
//	go func() {
//
//		fmt.Println("start goroutine")
//
//		// 通过通道通知main的goroutine
//		ch <- 0
//
//		fmt.Println("exit goroutine")
//
//	}()
//
//	fmt.Println("wait goroutine")
//
//	// 等待匿名goroutine
//	<-ch
//
//	fmt.Println("all done")
//
//}

//package main
//
//func main() {
//	c0 := make(chan struct{})
//	c1 := make(chan int, 100)
//	for {
//		select {
//		case <-c0:
//			return
//		case <-c1:
//			return
//		}
//	}
//}
//
//package main
//
//import (
//	"fmt"
//	"sync"
//)
//
//func main() {
//	wg := sync.WaitGroup{}
//	wg.Add(100)
//	for i := 0; i < 100; i++ {
//		go func(i int) {
//			fmt.Println(i)
//			wg.Done()
//		}(i)
//	}
//	wg.Wait()
//}

//
//import (
//	"fmt"
//	"sync"
//)
//
//var counter int
//var wg sync.WaitGroup
//
//func main() {
//	wg.Add(2)
//
//	go incrementCounter()
//	go printCounter()
//
//	wg.Wait()
//}
//
//func incrementCounter() {
//	defer wg.Done()
//
//	for i := 0; i < 5; i++ {
//		// 模拟对共享变量的写操作
//		counter++
//	}
//}
//
//func printCounter() {
//	defer wg.Done()
//
//	// 模拟在另一个 goroutine 中读取共享变量
//	for i := 0; i < 5; i++ {
//		// 可能读取到一个不一致或不正确的值
//		fmt.Println(counter)
//	}
//}

//package main
//
//import (
//	"fmt"
//	"sync"
//)
//
//// 交替打印数字和字母
//func main() {
//
//	letter, number := make(chan bool), make(chan bool)
//	wait := sync.WaitGroup{}
//
//	go func() {
//		i := 1
//		for {
//			select {
//			case <-number:
//				fmt.Print(i)
//				i++
//				fmt.Print(i)
//				i++
//				letter <- true
//			}
//		}
//	}()
//	wait.Add(1)
//	go func(wait *sync.WaitGroup) {
//		i := 'A'
//		for {
//			select {
//			case <-letter:
//				if i >= 'Z' {
//					wait.Done()
//					return
//				}
//
//				fmt.Print(string(i))
//				i++
//				fmt.Print(string(i))
//				i++
//				number <- true
//			}
//
//		}
//	}(&wait)
//	number <- true
//	wait.Wait()
//
//}

package main

import (
	"fmt"
	"sync"
)

func main() {

	letterA, letterB, letterC := make(chan bool), make(chan bool), make(chan bool)
	wait := sync.WaitGroup{}
	wait.Add(1)
	go func(wait *sync.WaitGroup) {
		i := 'A'
		time := 0
		for {
			select {

			case <-letterA:
				if time >= 100 {
					wait.Done()
					return
				}
				time++
				fmt.Print(string(i))
				letterB <- true
			}
		}
	}(&wait)

	go func() {
		i := 'B'

		for {
			select {
			case <-letterB:

				fmt.Print(string(i))
				letterC <- true
			}

		}
	}()

	go func() {
		i := 'C'
		for {
			select {
			case <-letterC:
				fmt.Println(string(i))
				letterA <- true
			}
		}
	}()

	letterA <- true
	wait.Wait()

}
