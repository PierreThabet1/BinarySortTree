

/**
 * This is the main class for creating a Binary tree and using methods
 * to control the insertion operation. 
 * The class include other methods for measuring the depth, and counting
 * the leaves of the tree.
 * @author Pierre
 *
 */

public class BinarySortTree { // BinarySortTree class begin.

	/**
	 * This is the root variable of the TreeNode class.
	 */

	public static TreeNode root;

	public static void main(String[] args) { // main begin.

		int i = 0;
		while (i < 1023) {

			treeInsert((int) (1023 * Math.random()));
			i++;

		}

		System.out.println("Leaves Count: " + countLeaves(root));
		System.out.println("Sum of Depth: " + sumOfDepths(root, 0));
		System.out.println("Maximum Depth: " + maximumDepth(root, 0));
		int depthsum = sumOfDepths(root, 0);
		int leavesCount = countLeaves(root);
		System.out.println("Average Depth: " + depthsum/leavesCount);

	} // End of main.

	/**
	 * This is the class that create the tree with the root.
	 * @author Pierre
	 *
	 */

	private static class TreeNode { // TreeNode class.

		int item; // value of the TreeNode obj.
		TreeNode left; // left of the TreeNode obj.
		TreeNode right; // right of the TreeNode obj.

		TreeNode (int number){ // Begin of constructor.

			item = number;

		} // End of constructor.

	} // End of TreeNode class.

	/**
	 * This method controls the way of inserting ints into the TreeNode.
	 * Convention is, left side holds values less than the root, right side
	 * holds values more than or equal to the root. 
	 * 
	 * @param int num.
	 */

	private static void treeInsert(int num) { // Begin of treeInsert.

		if ( root == null ) { // base case.

			root = new TreeNode(num);
			return;

		} // End of if.

		TreeNode runner;
		runner = root;

		while (true) { // Begin of while.

			if (num < runner.item) { // Begin of 1st if.

				if (runner.left == null) { // Begin of 2nd if.

					runner.left = new TreeNode(num);
					return;

				} // End of second if.

				else { // Begin of else.

					runner = runner.left;

				} // End of else.

			} // End of 1st if.

			else { // Begin of 1st outer else.

				if (runner.right == null) { // Begin of inner if.

					runner.right = new TreeNode(num);
					return;

				} // End of inner if.

				else { // Begin of inner else.

					runner = runner.right;

				} // End of inner else.

			} // End of outer else.

		} // End of while.


	} // End of treeInsert.

	/**
	 * This method counts the leaves of the TreeNode obj. 
	 * 
	 * @param TreeNode root.
	 * @return int.
	 */

	private static int countLeaves(TreeNode root) {

		TreeNode runner = root;
		int leavesCounter = 0;

		if (runner == null) { // Basecase.

			return 0;

		}
		else {

			if (runner.left == null && runner.right == null) {

				return 1;

			}

		}

		return leavesCounter += countLeaves(runner.left) + 
				countLeaves(runner.right);


	} // End of countLeaves.
	
	/**
	 * This method sums the counts of the steps it takes to reach 
	 * the leaves, startingfrom the root. Normaly depth param starts with 0.
	 * 
	 * @param TreeNode root.
	 * @param int depth.
	 * @return int.
	 */

	private static int sumOfDepths(TreeNode root, int depth) {

		TreeNode runner = root;

		if (runner == null) {

			return 0;

		}

		else if (runner.left == null && runner.right == null) {

			return depth;

		}

		else {

			return sumOfDepths(runner.left, depth + 1) + 
					sumOfDepths(runner.right, depth + 1);

		}

	} // End of sumOfDepths.
	
	/**
	 * This method checks, which one of the both sides, left or ride, has 
	 * a bigger depth. Normally the depth param starts with 0.
	 * 
	 * @param TreeNode root.
	 * @param int depth.
	 * @return int.
	 */

	private static int maximumDepth(TreeNode root, int depth) {

		TreeNode runner = root;
		int leftMax = 0;
		int rightMax = 0;

		if(runner == null) {

			return 0;

		}

		else if(runner.left == null && runner.right == null) {

			return depth;

		}

		else {

			leftMax = sumOfDepths(runner.left, depth + 1);
			System.out.println("Left Max: " + leftMax);
			rightMax = sumOfDepths(runner.right, depth + 1);
			System.out.println("Right Max: " + rightMax);

			if (leftMax > rightMax) {

				return leftMax;

			}

			else {

				return rightMax;

			}

		}

	} // End of maximumDepth.

} // End of BinarySortTree class.
