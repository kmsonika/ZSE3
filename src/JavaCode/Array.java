package JavaCode;
import java.util.ArrayList;

public class Array {
static Student s1=new Student("Sonika", 29);
static Student s2=new Student("Monika", 28);
static Student s3=new Student("Barkha", 25);
static Student s4=new Student("Bhavana", 27);
static Student s5=new Student("Sanjana", 26);

	public static void main(String[] args) 
	{
		Student [] record=new Student[5];
		record[0]=s1;
		record[1]=s2;
		record[2]=s3;
		record[3]=s4;
		record[4]=s5;
		
		 for(int i=0; i<=4; i++)
		 {
			 //System.out.println(record[i]);
			 record[i].showDetails();
		 }
		
	}

}
