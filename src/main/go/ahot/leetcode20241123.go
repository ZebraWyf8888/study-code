package main

func winningPlayerCount(n int, pick [][]int) int {
	cnt := make([][11]int, 11)
	for _, p := range pick {
		cnt[p[0]][p[1]]++
	}

	ans := 0
	for i := 0; i < 11; i++ {
		for j := 0; j < 11; j++ {
			if cnt[i][j] > i {
				ans++
				break
			}
		}
	}

	return ans
}

func mergeAlternately(word1 string, word2 string) string {
	ans := make([]byte, 0, len(word1)+len(word2))
	word1len, word2len := len(word1), len(word2)
	for i := 0; i < word2len || i < word1len; i++ {
		if i < len(word1) {
			ans = append(ans, word1[i])
		}

		if i < len(word2) {
			ans = append(ans, word2[i])
		}

	}
	return string(ans)
}
