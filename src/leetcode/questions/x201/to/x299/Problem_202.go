package main

import (
	"math"
)

func recursive(n int, set map[int]struct{}) bool {
	if _, exists := set[n]; exists {
		return false
	}
	output := 0
	input := n
	for n > 9 {
		output += int(math.Pow(float64(n%10), 2))
		n = n / 10
	}
	output += int(math.Pow(float64(n%10), 2))
	if output == 1 {
		return true
	}
	set[input] = struct{}{}
	return recursive(output, set)
}

func isHappy(n int) bool {
	return recursive(n, make(map[int]struct{}))
}
