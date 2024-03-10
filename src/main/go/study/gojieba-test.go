package main

import (
	"fmt"
	"regexp"
)

func splitTextIntoSentences(text string) []string {
	re := regexp.MustCompile(`[。？！,：；:\s]+`)
	sentences := re.Split(text, -1)
	return sentences
}

func main() {
	text := "这是一个句子:这是第七个句子。"
	sentences := splitTextIntoSentences(text)
	for _, sentence := range sentences {
		fmt.Println(sentence)
	}
}
