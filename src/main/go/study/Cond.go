package main

import (
	"fmt"
	"sync"
	"time"
)

func main() {
	//10个人赛跑，1个裁判发号施令
	race()
}

//在 Go 语言中，sync.WaitGroup 用于最终完成的场景，关键点在于一定要等待所有协程都执行完毕。
//
//而 sync.Cond 可以用于发号施令，一声令下所有协程都可以开始执行，关键点在于协程开始的时候是等待的，要等待 sync.Cond 唤醒才能执行。
//
//sync.Cond 从字面意思看是条件变量，它具有阻塞协程和唤醒协程的功能，所以可以在满足一定条件的情况下唤醒协程，但条件变量只是它的一种使用场景。
//
//下面我以 10 个人赛跑为例来演示 sync.Cond 的用法。在这个示例中有一个裁判，裁判要先等这 10 个人准备就绪，
//
//然后一声发令枪响，这 10 个人就可以开始跑了，如下所示：

func race() {

	cond := sync.NewCond(&sync.Mutex{})

	var wg sync.WaitGroup

	wg.Add(11)

	for i := 0; i < 10; i++ {

		go func(num int) {

			defer wg.Done()

			fmt.Println(num, "号已经就位")

			cond.L.Lock()

			cond.Wait() //等待发令枪响

			fmt.Println(num, "号开始跑……")

			cond.L.Unlock()

		}(i)

	}

	//等待所有goroutine都进入wait状态

	time.Sleep(2 * time.Second)

	go func() {

		defer wg.Done()

		fmt.Println("裁判已经就位，准备发令枪")

		fmt.Println("比赛开始，大家准备跑")

		cond.Broadcast() //发令枪响

	}()

	//防止函数提前返回退出

	wg.Wait()

}

//以上示例中有注释说明，已经很好理解，我这里再大概讲解一下步骤：
//
//通过 sync.NewCond 函数生成一个 *sync.Cond，用于阻塞和唤醒协程；
//
//然后启动 10 个协程模拟 10 个人，准备就位后调用 cond.Wait() 方法阻塞当前协程等待发令枪响，这里需要注意的是调用 cond.Wait() 方法时要加锁；
//
//time.Sleep 用于等待所有人都进入 wait 阻塞状态，这样裁判才能调用 cond.Broadcast() 发号施令；
//
//裁判准备完毕后，就可以调用 cond.Broadcast() 通知所有人开始跑了。
//
//sync.Cond 有三个方法，它们分别是：
//
//Wait，阻塞当前协程，直到被其他协程调用 Broadcast 或者 Signal 方法唤醒，使用的时候需要加锁，使用 sync.Cond 中的锁即可，也就是 L 字段。
//
//Signal，唤醒一个等待时间最长的协程。
//
//Broadcast，唤醒所有等待的协程。
//
//注意：在调用 Signal 或者 Broadcast 之前，要确保目标协程处于 Wait 阻塞状态，不然会出现死锁问题。
//
//如果你以前学过 Java，会发现 sync.Cond 和 Java 的等待唤醒机制很像，它的三个方法 Wait、Signal、Broadcast 就分别对应 Java 中的 wait、notify、notifyAll。
//
//总结
//这节课主要讲解 Go 语言的同步原语使用，通过它们可以更灵活地控制多协程的并发。从使用上讲，Go 语言还是更推荐 channel 这种更高级别的并发控制方式，因为它更简洁，也更容易理解和使用。
//
//当然本节课讲的这些比较基础的同步原语也很有用。同步原语通常用于更复杂的并发控制，如果追求更灵活的控制方式和性能，你可以使用它们。
//
//本节课到这里就要结束了，sync 包里还有一个同步原语我没有讲，它就是 sync.Map。sync.Map 的使用和内置的 map 类型一样，只不过它是并发安全的