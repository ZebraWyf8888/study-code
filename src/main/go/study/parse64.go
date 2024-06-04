package main

import (
	"fmt"
	"strconv"
)

func convertAndPadDecimalToHex(decimalInput int, length int) (string, error) {
	// 将十进制转为十六进制
	hexString := strconv.FormatInt(int64(decimalInput), 16)

	// 补全为指定长度的十六进制字符串
	paddedHex := fmt.Sprintf("%0*s", length, hexString)

	return paddedHex, nil
}

func main() {
	// 输入的十进制数字
	decimalInput := 34556
	//00000000000086fc
	// 补全为长度为 16 的十六进制字符串
	paddedHex, err := convertAndPadDecimalToHex(decimalInput, 16)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	// 输出结果
	fmt.Println(paddedHex)
}
