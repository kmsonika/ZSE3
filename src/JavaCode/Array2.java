package JavaCode;

import java.util.ArrayList;
import java.util.Collection;

public class Array2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Student s1=new Student("Sonika", 29);
	 Student s2=new Student("Monika", 28);
	 Student s3=new Student("Barkha", 25);
	 Student s4=new Student("Bhavana", 27);
	 Student s5=new Student("Sanjana", 26);
	 
	 Collection<Student> StudentRecord=new ArrayList<>();
	 StudentRecord.add(s1);
	 StudentRecord.add(s2);
	 StudentRecord.add(s3);
	 StudentRecord.add(s4);
	 StudentRecord.add(new Student("Enaya",10));
	 System.out.println("Size-->" + StudentRecord.size());
	 
	 for(Student st:StudentRecord)
	 {
		 st.showDetails();
	 }

	}

}
