import java.util.*;

class student{
int roll;
String name;
static String clg="ITS";
  student(String name,int roll)
{name=name;
roll=roll;
 
}
void print()
{System.out.println(name+" "+roll+" "+clg);

}
public static void main(String[] args)
{student s1=new student("aman",44);
  student s2=new student("aman1",444);

   s1.print();
    s2.print();
}
}