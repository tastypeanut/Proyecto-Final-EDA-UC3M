package phase1;

import java.time.LocalDate;

public class ManageNetworkList implements IManageNetworkList {

	/**
	 * The methods must join two social networks into a single social network. The
	 * method takes two objects of the StudentsList and returns a new list
	 * containing first the s tudents from the first list followed by the students
	 * from the second list.
	 * 
	 * @param lst1
	 * @param lst2
	 * @return
	 */
	
	public StudentsList union(StudentsList lst1, StudentsList lst2) {
		StudentsList resultList = new StudentsList();
		if (lst1 != null) {
			for (DNode node = lst1.header.next; node != lst1.trailer; node = node.next) {
				resultList.addLast(node.elem);
			}
		}
		if (lst2 != null) {
			for (DNode node = lst2.header.next; node != lst2.trailer; node = node.next) {
				resultList.addLast(node.elem);
			}
		}
		return resultList;
	}

	/**
	 * 3. This methods takes a social network as input and an integer parameter opc
	 * so that: - If opc =1: the method must return a StudentsList containing all
	 * the students residing in the same city that the campus where they are
	 * studying. - If opc =2: the method must return a StudentsList containing all
	 * the students residing in cities different that the one where their campus is
	 * located.
	 * 
	 * @param lst1
	 * @param lst2
	 * @param opc
	 * @return
	 */
	
	public StudentsList getCampusCity(StudentsList lst, int opc) {
		StudentsList l = new StudentsList();
		if (opc == 1) {
			for (DNode node = lst.header.next; node != lst.trailer; node = node.next) {
				if (node.elem.city.equalsIgnoreCase(node.elem.campus.name())) {
					l.addLast(node.elem);
				}
			}
		} else if (opc == 2) {
			for (DNode node = lst.header.next; node != lst.trailer; node = node.next) {
				if (!(node.elem.city.equalsIgnoreCase(node.elem.campus.name()))) {
					l.addLast(node.elem);
				}
			}
		}
		return l;
	}

	/**
	 * 4. This method takes a social network as input and a integer parameter opc so
	 * that: - If opc=1, the method returns a list of students sorted by ascending
	 * order according to their full name. - If opc=2, the method returns a lit of
	 * students sorted by descending order according to their full name. Note 1. You
	 * must implement your own sort method based on some of the sorted algorithms
	 * (such as bubble, sort). Note 2: Remember that you cannot modify or extend the
	 * StudentsList class. Therefore, if you need an auxiliary method that help you
	 * to sort the list, please include this method into the ManageNetwork class.
	 * Note 3. The input list cannot be modified. The method must return a new list
	 * where the students are sorted.
	 * 
	 * @param lst
	 * @param opc
	 * @return
	 */
	
	public StudentsList orderBy(StudentsList lst, int opc) {
		StudentsList sortedList = new StudentsList();
			for (DNode node1 = lst.header.next; node1 != lst.trailer; node1 = node1.next) {
				sortedInsert(sortedList, node1.elem, opc);
			}
		return sortedList;
	}

	/**
	 * auxiliary method to insert student in a sorted way
	 * 
	 * @param lst
	 * @param newStudent
	 * @param opc
	 */
	
	public static void sortedInsert(StudentsList lst, Student newStudent, int opc) {
		switch (opc){
			case 1:
				int contador=0;
				for (DNode node1 = lst.header.next; node1 != lst.trailer; node1 = node1.next) {
					if (lst.isEmpty() || node1.prev == lst.header && node1.elem.email.compareTo(newStudent.email) >= 0) {
						lst.addFirst(newStudent);
						break;
					} 
					if(!(node1.prev == lst.header || node1.next == lst.trailer) && node1.prev.elem.email.compareTo(newStudent.email) < 0 && node1.elem.email.compareTo(newStudent.email) >= 0){
						lst.insertAt(contador, newStudent);
						break;
					}
					if (node1.next == lst.trailer && node1.elem.email.compareTo(newStudent.email) < 0) {
						lst.addLast(newStudent);
						break;
					}
					contador++;
				}
			break;
			case 2:
				int contador1=0;
				for (DNode node1 = lst.header.next; node1 != lst.trailer; node1 = node1.next) {
					if (lst.isEmpty() || node1.prev == lst.header && node1.elem.email.compareTo(newStudent.email) <= 0) {
						lst.addFirst(newStudent);
						break;
					}
					if(!(node1.prev == lst.header || node1.next == lst.trailer) && node1.prev.elem.email.compareTo(newStudent.email) > 0 
							&& node1.elem.email.compareTo(newStudent.email) <= 0){
						lst.insertAt(contador1, newStudent);
						break;
					}
					if (node1.next == lst.trailer && node1.elem.email.compareTo(newStudent.email) > 0) {
						lst.addLast(newStudent);
						break;
					}
					contador1++;
				}
			break;
		}
	}

	/**
	 * This methods takes a social network (that is an object of StudentsList class)
	 * and a city name as input and returns a list containing all the students (that
	 * is, an object of the StudentsList class) who live in that city.
	 * 
	 * @param lst
	 * @param city
	 * @return
	 */
	
	public StudentsList locateByCity(StudentsList lst, String city) {
		StudentsList l = new StudentsList();
		for (DNode node = lst.header.next; node != lst.trailer; node = node.next) {
			if (node.elem.city.equalsIgnoreCase(city)) {
				l.addLast(node.elem);
			}
		}
		return l;
	}

	/**
	 * This takes a social network (an object of the StudentsList class) and two
	 * dates and returns the list of all students from the input list whose
	 * registration dates are in the interval of input dates. Please, take into
	 * account the following comments: - start <= end. - Both dates are included
	 * into the interval. - The order in the resulting list must be the same that in
	 * the input list.
	 * 
	 * @param lst
	 * @param start
	 * @param end
	 * @return
	 */
	
	public StudentsList getStudentsByDateInterval(StudentsList lst, LocalDate start, LocalDate end) {
		StudentsList resultList = new StudentsList();
		for (DNode node = lst.header.next; node != lst.trailer; node = node.next) {
			if (node.elem.date_sign_in.equals(start) || node.elem.date_sign_in.equals(end)) {
				resultList.addLast(node.elem);
			} else if (node.elem.date_sign_in.isAfter(start) && node.elem.date_sign_in.isBefore(end)) {
				resultList.addLast(node.elem); // Hemos utilizado el metodo .isBefore para comparar las fechas.
			}
		}
		return resultList;
	}
	
	public static void main(String[] args) {
	}
	
}
