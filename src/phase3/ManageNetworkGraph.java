package phase3;

import java.util.LinkedList;



public class ManageNetworkGraph implements IManageNetworkGraph {
	
	
	
	public LinkedList<String> students;
	LinkedList<LinkedList<Integer>> lst_of_lstAdjacents;
	
	public ManageNetworkGraph(String[] students) {
			this.students=new LinkedList<String>();
			for(int k=0; k < students.length; k++) {
				this.students.add(students[k]);
			}
			
			//we must initialize each Integer list
			//each index i corresponds to a student, the function
			//getIndex is used to obtain the correspondence
			lst_of_lstAdjacents=new LinkedList<LinkedList<Integer>>();
			int num=this.students.size();
			for (int i=0; i<num; i++) {
				lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
			}
			
	}
	
	//searches the student and returns its index
	public int getIndex(String student) {
		int index=-1;
		if (student != null) {
			return this.students.indexOf(student);
		}
		return index;
	}
	
	//checks if index is right and returns its associated city
	public String checkVertex(int index) {
		if (index >= 0 && index < students.size()) {
			return students.get(index);
		} else return null;
	}
	
	/**
	 * It takes taking two students (emails) as input and 
	 * creates a friendship relation between them. 
	 * Keep in mind that friendship relation is a symmetric relationship.
	 */
	
	public void addStudent(String student) {
		if (!(student == null)) {
			students.add(student);
		}
	}
	
	/**
	 * It takes two students (emails) as input and creates a friendship 
	 * relation between them. Keep in mind that friendship relation is a symmetric relationship.
	 * @param studentA
	 * @param studentB
	 */
	
	public void areFriends(String studentA, String studentB) {
		if(students.contains(studentA) && students.contains(studentB)) {
			int x = students.indexOf(studentA);
			int y = students.indexOf(studentB);
			lst_of_lstAdjacents.get(x).add(y);
			lst_of_lstAdjacents.get(y).add(x);
		}
	}
	
	/**
	 * This takes a student (email), and returns an object of LinkedList<String>, 
	 * which contains the emails of his/her direct friends.
	 * @param studentA
	 * @return
	 */
	
	public LinkedList<String> getDirectFriends(String studentA){
		
		LinkedList<String> lDirectFriends = new LinkedList<String>();
		//to complete
		
		
		return lDirectFriends;
	}
	
	
	public int[] getAdjacents(int position){
		int[] adjacents = new int[lst_of_lstAdjacents.get(position).size()]; //creamos una matriz del tamaño del numero de amigos que tenga una persona
		for (int counter = 0; counter < adjacents.length; counter++){
			adjacents[counter] = lst_of_lstAdjacents.get(position).get(counter);
		}
		return adjacents;
	}

	
	public LinkedList<String> suggestedFriends(String studentA){
		LinkedList<String> lSuggestedFriends = new LinkedList<String>();
		if (students.contains(studentA) && studentA != null) {
			LinkedList<Integer> SuggestedFriendsIds;
			boolean[] visited = new boolean[students.size()];
			SuggestedFriendsIds = depth(students.indexOf(studentA), visited);
			if(SuggestedFriendsIds != null && SuggestedFriendsIds.size() >0) {
				for (int counter = 0; counter < SuggestedFriendsIds.size(); counter++) {
					lSuggestedFriends.add(counter, (students.get(SuggestedFriendsIds.get(counter))));
				}
			}
			int[] adjacents = getAdjacents(students.indexOf(studentA));
			lSuggestedFriends.remove(lSuggestedFriends.indexOf((students.get(students.indexOf(studentA)))));
			for (int positions : adjacents) {
				lSuggestedFriends.remove(lSuggestedFriends.indexOf((students.get(positions))));
			}
		}
		return lSuggestedFriends;
	}
	
	
	public LinkedList<Integer> depth(int i, boolean[] visited) {
		LinkedList<Integer> path=new LinkedList<Integer>();
		return depth(i,visited, path);
	}
	

	protected LinkedList<Integer> depth(int i,boolean[] visited, LinkedList<Integer> path) { //path es las personas
		if (!visited[i]){
			path.add(i);
			visited[i] = true;
			for (int positions : getAdjacents(i)) {
				depth(positions, visited, path);
			}
		}
		return path;
	}
	
	
	public void show() {
		//to complete
	}
	
	public static void main(String args[]) {
		
	}	
}
