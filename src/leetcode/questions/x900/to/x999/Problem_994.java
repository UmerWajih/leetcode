package leetcode.questions.x900.to.x999;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_994 {

	public static int orangesRotting(int[][] grid) {

		Queue<Integer[]> q = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					Integer[] val = new Integer[] { i, j };
					q.offer(val);
				}
			}
		}
		int min = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				// check all 4
				Integer[] val = q.poll();
				if (val[0] - 1 >= 0 && grid[val[0] - 1][val[1]] == 1) {
					q.offer(new Integer[] { val[0] - 1, val[1] });
					grid[val[0] - 1][val[1]] = 2;
				}
				if (val[0] + 1 < grid.length && grid[val[0] + 1][val[1]] == 1) {
					q.offer(new Integer[] { val[0] + 1, val[1] });
					grid[val[0] + 1][val[1]] = 2;
				}
				if (val[1] - 1 >= 0 && grid[val[0]][val[1] - 1] == 1) {
					q.offer(new Integer[] { val[0], val[1] - 1 });
					grid[val[0]][val[1] - 1] = 2;
				}
				if (val[1] + 1 < grid[0].length && grid[val[0]][val[1] + 1] == 1) {
					q.offer(new Integer[] { val[0], val[1] + 1 });
					grid[val[0]][val[1] + 1] = 2;
				}
			}
			min++;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return min == 0 ? 0 : min - 1;
	}
}
