package main

import (
	"fmt"
	"math"
	"math/rand"
	"time"
)

const DARTS = 1000 * 1000

func main() {
	hits := 0
	start := time.Now()

	for i := 0; i < DARTS; i++ {
		x, y := rand.Float64(), rand.Float64()
		// x^2 + y^2 <= 1, 则点(x, y)在圆内
		dist := math.Sqrt(x*x + y*y)
		if dist <= 1.0 {
			hits++
		}
	}

	//  取的是1/4圆的面积，所以要乘以4
	pi := 4 * (float64(hits) / float64(DARTS))
	fmt.Printf("圆周率值是：%f\n", pi)
	fmt.Printf("运行时间是：%.5fs\n", time.Since(start).Seconds())
}
