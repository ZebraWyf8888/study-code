package main

import (
	"strings"
)



func MaskEmail(email string) string {
	if len(email) < 6 || len(email) > 255 {
		// 邮箱长度不合法，抛出错误或返回原始邮箱
		return email
	}
	// 获取@符号前的部分
	atIndex := strings.Index(email, "@")
	if atIndex == -1 || atIndex <3{
		// 没有找到@符号，抛出错误或返回原始邮箱
		return email
	}

	// 获取@符号前的部分并截取前三位
	username := email[:atIndex]
	// 将前三位信息转换为小写，以便统一处理
	username = strings.ToLower(username)

	// 将前三位信息转换为星号(*)并拼接后三位信息，然后与@符号后的部分拼接起来
	maskedUsername := username[:3] + "****"
	maskedEmail := maskedUsername + email[atIndex:]

	return maskedEmail
}

func MaskPhoneNumber(phoneNumber string) string {
	if len(phoneNumber) != 11 {
		// 手机号长度不是11位，抛出错误或返回原始号码
		return phoneNumber
	}

	// 将中间四位数字替换为星号(*)
	maskedNumber := phoneNumber[:3] + "****" + phoneNumber[7:]
	return maskedNumber
}

func main() {

	a :=strings.TrimSpace("")
	println(a)
	//email := MaskEmail("liyiyun@xunlei.com")
	////resp.Tel = utils.MaskPhoneNumber("18154316001")
	//print(email)
}