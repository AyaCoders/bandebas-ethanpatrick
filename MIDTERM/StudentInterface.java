import java.util.Scanner;

public class StudentInterface {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      
      System.out.print("First Name: ");
      String firstName = in.nextLine();
      System.out.print("Middle Name: ");
      String middleName = in.nextLine();
      System.out.print("Last Name: ");
      String lastName = in.nextLine();
      System.out.print("Suffix: ");
      String suffix = in.nextLine();
    
      
      Student s1 = new Student(firstName, middleName, lastName, suffix);
      
      System.out.println("First Name: " + s1.getFirstName());
      System.out.println("Middle Name: " + s1.getMiddleName());
      System.out.println("Last Name: " + s1.getLastName());
      System.out.println("Suffix: " + s1.getSuffix());
      System.out.println("Full Name: " + s1.getFullName());

      
   }
}