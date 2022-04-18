package main

import "fmt"

type address struct {
	province string
	city     string
}
func (addr *address) String() string {
	return fmt.Sprintf("the addr is %s%s", addr.province, addr.city)
}
func printString(s fmt.Stringer) {
	fmt.Println(s.String())
}

type person struct {
	name string
	age  uint
	addr address
}
func (p *person) String() string {
	return fmt.Sprintf("the name is %s,age is %d", p.name, p.age)
}
func (p *person) Walk(){
	fmt.Printf("%s能走\n",p.name)
}
func (p *person) Run(){
	fmt.Printf("%s能跑\n",p.name)
}
func NewPerson(name string) *person {
	return &person{name:name}
}

type WalkRun interface {
	Walk()
	Run()
}

//工厂函数，返回一个error接口，其实具体实现是*errorString
func New(text string) error {
	return &errorString{text}
}

//结构体，内部一个字段s，存储错误信息
type errorString struct {
	s string
}

//用于实现error接口
func (e *errorString) Error() string {
	return e.s
}

func main() {
	p3:=person{
		addr:address{province:"gd",city:"sz"},
		age:1,
		name:"zhangSan",
	}
	printString(&(&p3).addr)

	p1 := NewPerson("张三")
	fmt.Println(p1)
	var s fmt.Stringer
	s = p1
	p2 := s.(*person)
	fmt.Println(p2)
	a,ok :=s.(*address)
	if ok {
		fmt.Print(a)
	}else{
		fmt.Print("s不是一个address")
	}
	fmt.Println(a)
}
