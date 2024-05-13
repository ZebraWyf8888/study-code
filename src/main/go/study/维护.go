package main

import "fmt"

func checkProfitOpportunity(ratioAB, ratioBC, ratioAC float64) {
	// 计算使用每个交易对交易时的盈利情况
	profitAB := ratioAB - 1/(ratioBC*ratioAC)
	profitBC := 1/ratioBC - ratioAB*ratioAC
	profitAC := ratioAC - 1/(ratioAB*ratioBC)

	// 判断是否有盈利机会
	if profitAB > 0 {
		fmt.Println("有盈利机会：通过交易对 A-B 赚取利润")
		return
	}
	if profitBC > 0 {
		fmt.Println("有盈利机会：通过交易对 B-C 赚取利润")
		return
	}
	if profitAC > 0 {
		fmt.Println("有盈利机会：通过交易对 A-C 赚取利润")
		return
	}
	fmt.Println("当前情况下没有盈利机会")
}

func main() {
	// 测试用例
	checkProfitOpportunity(10, 100, 1000) // 示例：A-B: 1:10, B-C: 1:100, A-C: 1:1000
	checkProfitOpportunity(1, 100, 1000)  // A-B: 1:1, B-C: 1:100, A-C: 1:1000
	checkProfitOpportunity(1, 10, 100)    // A-B: 1:1, B-C: 1:10, A-C: 1:100
	checkProfitOpportunity(1, 1, 10)      // A-B: 1:1, B-C: 1:1, A-C: 1:10
}
