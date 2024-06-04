package main

import (
	"fmt"
	"strconv"
)

// findValidNumbers 找到所有满足 num % 13 == 5 的替换问号的组合
func findValidNumbers(s string) []int {
	var results []int
	questionMarks := []int{}

	// 找到问号的位置
	for i, char := range s {
		if char == '?' {
			questionMarks = append(questionMarks, i)
		}
	}

	// 生成所有可能的替换方案
	totalReplacements := 1
	for range questionMarks {
		totalReplacements *= 9
	}

	for i := 0; i < totalReplacements; i++ {
		replacement := i
		tempS := []rune(s)

		// 替换问号
		for _, pos := range questionMarks {
			tempS[pos] = rune('1' + replacement%9)
			replacement /= 9
		}

		// 转换为整数并检查条件
		numStr := string(tempS)
		num, err := strconv.Atoi(numStr)
		if err != nil {
			continue
		}
		if num%13 == 5 {
			results = append(results, num)
		}
	}

	return results
}

func main() {
	s := "123?123?"
	validNumbers := findValidNumbers(s)
	fmt.Println(validNumbers)
}
