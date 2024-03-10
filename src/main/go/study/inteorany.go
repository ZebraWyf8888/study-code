package main

import "fmt"

//type any

func main() {
	var map1 map[string]any
	map1 = make(map[string]any)
	map1["a"] = 1
	map1["b"] = "2"
	value := map1["a"]
	fmt.Println(value)
	//var map2 map[string]interface{]map2 = make(map[string]interface{})map2["a"] = 1map2["b"] = "2"value2 := map2["b"]fmt.PrintIn(value2)
}
