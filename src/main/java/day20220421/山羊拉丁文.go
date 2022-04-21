package day20220421

import "strings"

//824. 山羊拉丁文

var vowels = map[byte]struct{}{'a': {}, 'e': {}, 'i': {}, 'o': {}, 'u': {}, 'A': {}, 'E': {}, 'I': {}, 'O': {}, 'U': {}}

func toGoatLatin(sentence string) string {
	ans := &strings.Builder{}
	for i, cnt, n := 0, 1, len(sentence); i < n; i++ {
		//第一位不用接空格
		if cnt > 1 {
			ans.WriteByte(' ')
		}
		start := i
		for i++; i < n && sentence[i] != ' '; i++ {}
		cnt ++
		if _,ok:= vowels[sentence[start]];ok {
			ans.WriteString(sentence[start : i])
		}else{
			ans.WriteString(sentence[start+1 : i])
			ans.WriteByte(sentence[start])
		}
		ans.WriteByte('m')
		ans.WriteString(strings.Repeat("a",cnt))
	}
	return ans.String()
}
