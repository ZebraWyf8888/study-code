package main

import "fmt"

type Animal interface {
	Move() string
}

type Dog struct{}

func (d Dog) Move() string {
	return "Dog is moving"
}

func (d Dog) Eat() string {
	return "Dog is eating"
}

func main() {
	var animal Animal
	animal = Dog{}
	fmt.Println(animal.Move())
}
