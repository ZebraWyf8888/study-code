package main

import "fmt"

func deferTest() {
	// 1. 声明 fish=0
	fish := 0

	// 直接引用(闭包)
	//
	defer func() {
		// 8. 打印 fish=3
		fmt.Println("d1: ", fish) // 3
	}()

	// 参数传递
	// 2. 传递 fish=0
	// 7. 打印内部 fish 0
	defer fmt.Println("d2: ", fish) // 0

	// 参数传递(闭包)
	// 3. 传递 fish=0
	defer func(fish int) {
		// 6. 内部 fish 0 + 2 =2
		fish += 2 // fish 只作用于内部
		// 7. 打印内部 fish
		fmt.Println("d3: ", fish) // 2
	}(fish) // 声明时传递, fish = 0

	// 直接引用(闭包)
	defer func() {
		// 4. 打印 fish = 1
		fmt.Println("d4: ", fish) // 1
		// 5. fish = 3
		fish += 2 // fish = 3, 作用域与外部的相同
	}()

	// 3. fish=1
	fish++
}

func main() {
	deferTest()
}
