package main

import "fmt"

type A interface {
	ShowA() int
	ShowB() int
}

type Work struct {
	i int
}

func (w Work) ShowA() int {
	return w.i + 10
}

func (w Work) ShowB() int {
	return w.i + 20
}

func main() {
	c := Work{3}
	var a A = c
	fmt.Println(a.ShowA())
	fmt.Println(a.ShowB())
}
