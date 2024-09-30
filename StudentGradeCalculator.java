import java.util.Scanner;
public class StudentGradeCalculator
{
    public static void main(String[]args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Student Grade Calculator");
            System.out.println("Enter no of Subject");
            int rs=sc.nextInt();
            int total=0;
            for(int i=0;i<rs;i++){
             System.out.println("Enter marks obtained in "+(i+1)+":");
             int marks=sc.nextInt();
             total+=marks;   
            }
            double averP=(double)total/rs;
            char Grade;
            if(averP>=90){
                Grade='O';
            }
            else if(averP>=80){
                Grade='A';
            }
            else if(averP>=70){
                Grade='B';
            }
            else if(averP>=60){
                Grade='C';
            }
            else if(averP>=50){
                Grade='D';

            }
            else if(averP>=40){
                Grade='E';
            }
            else{
                Grade='F';
            }
            System.out.println("Total Marks Scored is "+total);
            System.out.println("Average Percentage Gained is "+averP+"%");
            System.out.println("Grade"+Grade);
        }
    }
}