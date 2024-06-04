package main

func sumTwo(arr []int, tar int) []int {
	m := map[int]int{}
	//m[arr[0]] = 0
	for i, x := range arr {
		if i3, ok := m[tar-x]; ok {
			return []int{i3, i}
		}
		m[arr[i]] = i
	}
	return []int{0, 0}
}

func main() {
	arr := []int{3, 3}
	tar := 6
	ans := sumTwo(arr, tar)
	println(ans[0])
	println(ans[1])
}
