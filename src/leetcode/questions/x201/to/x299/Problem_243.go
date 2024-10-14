package main

import (
	"fmt"
	"math"
)

// https://leetcode.com/problems/shortest-word-distance/description/
func main() {
	fmt.Println(shortestDistance([]string{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"))
}

func Abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
func shortestDistance(wordsDict []string, word1 string, word2 string) int {
	//set min distance to max possible value
	minDistannce := math.MaxInt

	word1Index := -1
	word2Index := -1

	for index, value := range wordsDict {
		if value == word1 {
			word1Index = index
		}
		if value == word2 {
			word2Index = index
		}

		if word1Index != -1 && word2Index != -1 {
			if Abs(word1Index-word2Index) <= minDistannce {
				minDistannce = Abs(word1Index - word2Index)
			}
		}
	}

	return minDistannce

}
