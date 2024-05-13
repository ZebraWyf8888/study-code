package main

import "fmt"

func topKFrequent(nums []int, k int) []int {
	occurrences := map[int]int{}
	for _, num := range nums {
		occurrences[num]++
	}

	minHeap := NewMinHeap()
	for key, value := range occurrences {
		minHeap.Push([2]int{key, value})
		if minHeap.Size() > k {
			minHeap.Pop()
		}
	}

	ret := make([]int, k)
	for i := k - 1; i >= 0; i-- {
		ret[i] = minHeap.Pop()[0]
	}
	return ret
}

type MinHeap struct {
	array [][2]int
}

func NewMinHeap() *MinHeap {
	return &MinHeap{}
}

func (h *MinHeap) Push(val [2]int) {
	h.array = append(h.array, val)
	h.heapifyUp(len(h.array) - 1)
}

func (h *MinHeap) Pop() [2]int {
	if len(h.array) == 0 {
		panic("heap is empty")
	}
	min := h.array[0]
	lastIndex := len(h.array) - 1
	h.array[0] = h.array[lastIndex]
	h.array = h.array[:lastIndex]
	h.heapifyDown(0)
	return min
}

func (h *MinHeap) heapifyUp(index int) {
	parentIndex := (index - 1) / 2
	for index > 0 && h.array[index][1] < h.array[parentIndex][1] {
		h.array[index], h.array[parentIndex] = h.array[parentIndex], h.array[index]
		index = parentIndex
		parentIndex = (index - 1) / 2
	}
}

func (h *MinHeap) heapifyDown(index int) {
	for {
		leftIndex := 2*index + 1
		rightIndex := 2*index + 2
		smallestIndex := index

		if leftIndex < len(h.array) && h.array[leftIndex][1] < h.array[smallestIndex][1] {
			smallestIndex = leftIndex
		}

		if rightIndex < len(h.array) && h.array[rightIndex][1] < h.array[smallestIndex][1] {
			smallestIndex = rightIndex
		}

		if smallestIndex == index {
			break
		}

		h.array[index], h.array[smallestIndex] = h.array[smallestIndex], h.array[index]
		index = smallestIndex
	}
}

func (h *MinHeap) Size() int {
	return len(h.array)
}

func main() {
	nums := []int{1, 1, 1, 2, 2, 3}
	k := 2
	fmt.Println("Top k frequent elements:", topKFrequent(nums, k)) // Output: [1, 2]
}
