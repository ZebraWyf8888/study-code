package main

import "fmt"

type A2 interface {
	ShowA() int
}

type B2 interface {
	ShowB() int
}

type Work2 struct {
	i int
}

func (w Work2) ShowA() int {
	return w.i + 10
}

func (w Work2) ShowB() int {
	return w.i + 20
}

func main() {
	c := Work2{3}
	var a A2 = c
	//var b B2 = c
	fmt.Println(a.(B2).ShowB())
	//fmt.Println(b.ShowB())
}