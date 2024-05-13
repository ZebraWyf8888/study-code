package main

import (
	"fmt"
)

// TradePair 表示一个交易对
type TradePair struct {
	Asset string  // 资产
	Ratio float64 // 交易比例
}

// Graph 表示交易对图
type Graph map[string][]TradePair

// TradeLoop 表示一个交易回环
type TradeLoop struct {
	Path   []string // 交易回环路径
	Profit float64  // 交易回环利润
}

// FindAllLoops 函数用于查找所有交易回环
func FindAllLoops(graph Graph, startAsset string, visited map[string]bool, currentPath []string, loops *[]TradeLoop) {
	if visited[startAsset] {
		// 找到了一个交易回环
		loop := make([]string, len(currentPath))
		copy(loop, currentPath)
		*loops = append(*loops, TradeLoop{Path: loop, Profit: 1.0})
		return
	}

	visited[startAsset] = true
	currentPath = append(currentPath, startAsset)

	for _, pair := range graph[startAsset] {
		FindAllLoops(graph, pair.Asset, visited, currentPath, loops)
	}

	// 回溯
	visited[startAsset] = false
}

func main() {
	// 测试数据，构建交易对图
	graph := Graph{
		"A": []TradePair{{"B", 1.2}},
		"B": []TradePair{{"C", 1.3}, {"A", 0.8}},
		"C": []TradePair{{"D", 1.5}, {"B", 0.8}},
		"D": []TradePair{{"E", 1.6}, {"C", 0.8}},
		"E": []TradePair{{"A", 1.7}, {"D", 0.8}},
	}

	// 查找所有交易回环
	var loops []TradeLoop
	for asset := range graph {
		FindAllLoops(graph, asset, make(map[string]bool), nil, &loops)
	}

	// 输出所有交易回环
	for _, loop := range loops {
		fmt.Println("交易回环路径:", loop.Path)
	}
}
