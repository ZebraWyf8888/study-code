package main

import "fmt"

type jack int

func main() {
	var x jack = 1
	y := x.a
	z := y(123)
	fmt.Print(z)
}
//方法可以作为表达式赋值给一个变量
func (b jack) a(num int) int {
	fmt.Println(num)
	return num + 1
}
