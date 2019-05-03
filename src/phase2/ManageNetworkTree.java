package phase2;

//import static org.junit.Assert.assertNotNull;

//import phase1.DNode;
import phase1.StudentsList;
//import phase1.Student;
//import phase1.ManageNetworkList;

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
	
	/*
	public StudentsList getOrderedList(StudentsTree tree) {
		
		StudentsList sL = new StudentsList();
		for (int contador = 0; contador < sL.getSize(); contador++) {
			inOrder(null, sL, null, null);
		}
		return sL;
		
        StudentsList sL = new StudentsList();
        
        BSTNode root = tree.root;
		preorderlist(root, null);
        
        
        return sL;
    }

	public void preorderlist(BSTNode node, StudentsList orderedlist) {
		if (node != null) {
			System.out.println(node.oStudent.email);
			preorderlist(node.left, orderedlist);
			preorderlist(node.right, orderedlist);
		}
	}
	
	public StudentsList inOrder(BSTNode node, StudentsList lst, DNode node1, Student newStudent) {

		if (!(lst.isEmpty()) || !(lst == null)) {
			int i = 0;
			for (int contador = 0; contador < lst.getSize(); contador++) {
				if (lst.isEmpty() || node1.prev == null && node1.elem.email.compareTo(newStudent.email) >= 0) {
					lst.addFirst(newStudent);
					break;
				} else if (!(node1.prev == null || node1.next == null)
						&& node1.prev.elem.email.compareTo(newStudent.email) < 0
						&& node1.elem.email.compareTo(newStudent.email) >= 0) {
					lst.insertAt(i, newStudent);
					break;
				} else if (node1.next == null && node1.elem.email.compareTo(newStudent.email) < 0) {
					lst.addLast(newStudent);
					break;
				}
				contador++;
			}
		}
		return lst;
	}
	*/
	
	
	public StudentsList getOrderedList(StudentsTree tree){
		
        StudentsList sL = new StudentsList();
       
        //To complete
        return sL;
    }
	
	
	/**
	 * This class has a parameter n as input and removes all students having a number of blocks equal or greater than n.
	 * @param num
	 */

	public void deleteByNumberOfBlocks(StudentsTree tree, int num) {
		BSTNode root = tree.root;
		preorder(root, num, tree);
	}

	public void preorder(BSTNode node, int n, StudentsTree tree) {
		if (node != null) {
			preorder(node.left, n, tree);
			preorder(node.right, n, tree);
			if (node.oStudent.blocks >= n) {
				tree.removeStudent(node.oStudent.email);
			}
		}
	}
	
}
