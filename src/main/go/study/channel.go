package main

import (
	"fmt"
	"time"
)

func main() {

	//声明三个存放结果的channel

	firstCh := make(chan string)

	secondCh := make(chan string)

	threeCh := make(chan string)

	//同时开启3个goroutine下载

	go func() {

		firstCh <- downloadFile("firstCh")

	}()

	go func() {

		secondCh <- downloadFile("secondCh")

	}()

	go func() {

		threeCh <- downloadFile("threeCh")

	}()

	//开始select多路复用，哪个channel能获取到值，

	//就说明哪个最先下载好，就用哪个。

	select {
	case filePath := <-firstCh:
		fmt.Println(filePath)
	case filePath := <-secondCh:
		fmt.Println(filePath)
	case filePath := <-threeCh:
		fmt.Println(filePath)
	}

}

func downloadFile(chanName string) string {

	//模拟下载文件,可以自己随机time.Sleep点时间试试

	time.Sleep(time.Second)

	return chanName + ":filePath"

}
