package leetcode.questions.x300.to.x400;

//https://leetcode.com/problems/additive-number/
public class Problem_306 {

	public static boolean isAdditiveNumber(String num) {
		if (num.length() < 3)
			return false;
		return rec(num, 0, 0, 1, 0, 2);

	}

	// i is starting index on num1
	// iAdd is number of index infront of 1 for num1
	// int k is starting index of sum

	
	private static boolean rec(String num, int i, int iAdd, int j, int jAdd, int k) {

		if (k >= num.length() || j >= num.length() || i >= num.length())
			return false;

		int num1 = 0, num2 = 0;
		if (iAdd == 0) {
			num1 = Character.getNumericValue(num.charAt(i));
		} else {
			num1 = Integer.parseInt(num.substring(i, i + iAdd + 1));
		}
		if (jAdd == 0) {
			num2 = Character.getNumericValue(num.charAt(j));
		} else {
			num2 = Integer.parseInt(num.substring(j, j + jAdd + 1));
		}

		int sum = num1 + num2;

		int kAdd = 0;
		int tem = sum;
		while (tem > 0) {
			tem /= 10;
			kAdd++;
		}
		int target = 0;
		if (kAdd == 0 || kAdd == 1) {
			target = Character.getNumericValue(num.charAt(k));
		} else {
			if (k + kAdd < num.length())
				target = Integer.parseInt(num.substring(k, k + kAdd));
			if (k + kAdd == num.length())
				target = Integer.parseInt(num.substring(k));
		}
		//TODO:
		//handle leading zeros when calling functions, need to do those shennaningins
		//if num2 is zero, 0 to be appended to num1 and num2 moves over
		//if num3 is zero, 0 to be appended to num2 and num2 moves over
		//if num1 is zero invalid
		boolean valid = false;
		if (sum != target) {
			valid = rec(num, i, iAdd, j, jAdd + 1, k + 1);
		} else {
			if (kAdd == 0)
				kAdd++;
			if (k + kAdd == num.length())
				return true; // we have reached end here
			valid = rec(num, j, jAdd, k, kAdd - 1, k + kAdd);
		}

		if (!valid) {
			valid = rec(num, i, iAdd + 1, j + 1, 0, k + 1);
		}

		return valid;
	}

	// 199100199
}
