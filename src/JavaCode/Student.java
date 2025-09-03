package JavaCode;

public class Student 
{
String Sname;
int Sage;

public Student(String Sname, int Sage)
{
	super();
	this.Sname=Sname;
	this.Sage=Sage;
}
public void showDetails()
{
	System.out.println("Name : " +this.Sname+",\t Age : \t"+this.Sage);
}
}
