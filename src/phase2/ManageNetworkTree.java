package phase2;

import phase1.StudentsList;

public class ManageNetworkTree implements IManageNetworkTree {

	/**
	 * It takes an object of the StudentsTree class and an object of the
	 * StudentsList class (phase 1), and inserts each student from the list into the
	 * tree. The method does not return anything.
	 * 
	 * @param tree
	 * @param list
	 */

	public void copySocialNetwork(StudentsTree tree, StudentsList list) {
		if (!(list.isEmpty()) || !(list == null)) {
			for (int contador = 0; contador < list.getSize(); contador++) {
				tree.insertStudent(list.getAt(contador));
			}
		}
	}

	/**
	 * This takes an object of the StudentsTree class and returns an object of the
	 * StudentsList class containing all the students in the tree ordered by their
	 * email. Hint: You can develop an auxiliary and recursive method which takes a
	 * BSTNode object and a StudentsList object. You cannot use any sort algorithm
	 * to sort the resulting list. To obtain the list, you must traverse the tree
	 * (or subtree) in a recursive way.
	 * 
	 * @return
	 */
	
	public StudentsList getOrderedList(StudentsTree tree){
		StudentsList sL = new StudentsList();
		if (tree != null) {
			auxmethod(tree.root, sL);
        }
        return sL;
    }
	
	protected void auxmethod(BSTNode node, StudentsList list) {
		if (node != null) {
			auxmethod(node.left, list);
			list.addLast(node.oStudent);
			auxmethod(node.right, list);
		}
	}
	
	/**
	 * This class has a parameter n as input and removes all students having a number of blocks equal or greater than n.
	 * @param num
	 */

	public void deleteByNumberOfBlocks(StudentsTree tree, int num) {
		BSTNode root = tree.root;
		preorder(root, num, tree);
	}

	protected void preorder(BSTNode node, int n, StudentsTree tree) {
		if (node != null) {
			preorder(node.left, n, tree);
			preorder(node.right, n, tree);
			if (node.oStudent.blocks >= n) {
				tree.removeStudent(node.oStudent.email);
			}
		}
	}
	
}
