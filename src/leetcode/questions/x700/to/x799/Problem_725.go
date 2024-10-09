/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
package x700_to_x799

type ListNode struct {
	Val  int
	Next *ListNode
}

//https://leetcode.com/problems/split-linked-list-in-parts/?envType=problem-list-v2&envId=linked-list
func splitListToParts(head *ListNode, k int) []*ListNode {
	len := 0
	start := head

	for start != nil {
		start = start.Next
		len += 1
	}

	minSize := len / k
	modSize := len % k
	start = head

	arr := make([]*ListNode, k)

	for i := 0; i < k; i++ {
		arr[i] = start
		old := start
		for j := 0; j < minSize; j++ {
			if start != nil {
				old = start
				start = start.Next
			}
		}

		if modSize > 0 {
			if start != nil {
				old = start
				start = start.Next
			}
			modSize -= 1
		}
		if old != nil {
			old.Next = nil
		}
	}

	return arr

}
