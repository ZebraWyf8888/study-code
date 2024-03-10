
package main

import (
"fmt"
"strings"
)

func main() {
	str := "[上|这|下]道题有点[难|简单]"
	combinations := getCombinations(str)
	for _, combination := range combinations {
		fmt.Println(combination)
	}

	solution(str)
}

func getCombinations(str string) []string {
	var combinations []string
	startIndex := strings.Index(str, "[")
	endIndex := strings.Index(str, "]")

	if startIndex == -1 || endIndex == -1 {
		combinations = append(combinations, str)
		return combinations
	}

	contentStr := str[startIndex+1 : endIndex]
	contentArr := strings.Split(contentStr, "|")

	for _, content := range contentArr {
		newStr := str[:startIndex] + content + str[endIndex+1:]
		subCombinations := getCombinations(newStr)
		combinations = append(combinations, subCombinations...)
	}

	return combinations
}


func getCombinations_feidigui(str string) []string {
	var combinations []string
	stack := make([]string, 0)
	stack = append(stack, str)

	for len(stack) > 0 {
		currentStr := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		startIndex := strings.Index(currentStr, "[")
		endIndex := strings.Index(currentStr, "]")

		if startIndex == -1 || endIndex == -1 {
			combinations = append(combinations, currentStr)
			continue
		}

		contentStr := currentStr[startIndex+1 : endIndex]
		contentArr := strings.Split(contentStr, "|")

		for _, content := range contentArr {
			newStr := currentStr[:startIndex] + content + currentStr[endIndex+1:]
			stack = append(stack, newStr)
		}
	}

	return combinations
}


func getCombinations_feidigui2(str string) []string {
	var combinations []string
	//先遍历一次，找到里面有多少个"["符号就就确定有几次循环：
	//然后每次循环，再去找里面“|”的数量
	//就是写两次for循环

	count := strings.Count(str, "[")
	fmt.Println("count =", count)


	return combinations
}

func solution(exp string) []string {
	// 请在此处书写代码
	var normalStr []string
	var multiExps [][]string

	var multiExp []string
	splitExp := strings.Split(exp, "]")
	for _, v := range splitExp {
		index := strings.Index(v, "[")
		if index == -1 {
			normalStr = append(normalStr, v)
			continue
		}
		left, multi := strings.Split(v, "[")[0], strings.Split(v, "[")[1]
		multiExp = append(multiExp, multi)
		normalStr = append(normalStr, left)
	}

	for _, v := range multiExp {
		multiExps = append(multiExps, strings.Split(v, "|"))
	}

	// TODO
	result := []string{}
	// result = append(result, normalStr)
	// for i, _ := range multiExps {
	//  for j, _ := range multiExps[i] {
	//   newResult := [][]string{}
	//   for row, _ := range result {
	//    tempStr := result[row][0] + multiExps[i][j] + result[row][1]
	//    var newResult []string
	//    newResult = append(newResult, tempStr)
	//    if len(result[row]) > 2 {
	//     newResult = append(newResult, result[row][2:]...)
	//    }
	//    result[row] = newResult
	//   }

	//  }
	//  result = newResult
	// }
	// TODO

	return result
}