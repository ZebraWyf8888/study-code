package main

import "fmt"

//868. 二进制间距
func main() {
	fmt.Print(binaryGap(22))
}


func binaryGap(n int) int {
	last := -1
	ans := 0
	for i:=0 ; n!=0 ;i++ {
		if n&1 == 1 {
			if last != -1 {
				ans = maxValue(ans,i - last)
			}
			last = i
		}
		n >>= 1
	}
	return ans
}

func maxValue(n,k int) int {
	if n>k {
		return n
	}else {
		return k
	}
}