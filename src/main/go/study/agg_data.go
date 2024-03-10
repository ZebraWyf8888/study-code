package main

import (
	"fmt"
)

func mergeArrays(keys [][]string) [][]string {
	// 使用一个映射表来记录每个元素所属的集合
	set := make(map[string][]string)
	result := make([][]string, 0)

	for _, keySet := range keys {
		// 查找当前元素所属的集合
		sets := make([][]string, len(keySet))
		for i, key := range keySet {
			set1, exists := set[key]
			if exists {
				sets[i] = set1
			} else {
				sets[i] = []string{key}
			}
		}

		// 合并所有集合
		newSet := mergeSets(sets...)

		// 更新映射表和结果集
		for _, key := range newSet {
			set[key] = newSet
		}
		result = removeSets(result, sets...)
		result = append(result, newSet)
	}

	return result
}

// 合并多个集合
func mergeSets(sets ...[]string) []string {
	result := make([]string, 0)
	setMap := make(map[string]bool)

	for _, set := range sets {
		for _, key := range set {
			if _, exists := setMap[key]; !exists {
				result = append(result, key)
				setMap[key] = true
			}
		}
	}

	return result
}

// 从结果中移除指定的集合
func removeSets(result [][]string, sets ...[]string) [][]string {
	// 遍历结果集，移除指定的集合
	for _, setToRemove := range sets {
		var updatedResult [][]string
		for _, s := range result {
			if !equalSlice(s, setToRemove) {
				updatedResult = append(updatedResult, s)
			}
		}
		result = updatedResult
	}

	return result
}

// 判断两个切片是否相等
func equalSlice(slice1, slice2 []string) bool {
	if len(slice1) != len(slice2) {
		return false
	}
	for i, v := range slice1 {
		if v != slice2[i] {
			return false
		}
	}
	return true
}

func main() {
	keys := [][]string{{"1", "2", "3", "5"}, {"2", "3", "453", "789"}, {"4", "5"}, {"6", "7"}, {"7", "8"}}

	result := mergeArrays(keys)

	fmt.Println(result)
}
