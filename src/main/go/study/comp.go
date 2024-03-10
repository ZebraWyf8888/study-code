
package main

import (
	"sort"
)

func main() {
	slice1 := []string{"apple", "banana", "orange", "grape"}
	slice2 := []string{"grape", "orange", "banana", "apple"}
	slice3 := make([]string,1000)
	slice3 = append(slice3, "apple")
	slice3 = append(slice3, "orange")
	slice3 = append(slice3, "banana")
	slice3 = append(slice3,  "grape")
	// 对切片进行排序
	sort.Strings(slice1)
	sort.Strings(slice2)
	sort.Strings(slice3)


}
