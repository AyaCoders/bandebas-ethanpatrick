import java.util.Scanner;
import java.util.ArrayList;

public class InterfaceStudent {

   public static Student getStudentDetails (Scanner in) {
      System.out.print("Enter Student Details\nEnter Student UD No.: ");
      String studentID = in.nextLine();
      System.out.print("Enter Student First Name: ");
      String firstName = in.nextLine();
      System.out.print("Enter Student Middle Name: ");
      String middleName = in.nextLine();
      System.out.print("Enter Student Last Name: ");
      String lastName = in.nextLine();
               
      System.out.print("Does student have suffix? (Y/N): ");
      String ans = in.nextLine();
      
      String suffix = "None";
      if (ans.toUpperCase().equals("YES") || ans.toUpperCase().equals("Y")) {
         System.out.print("Enter Student suffix: ");
         suffix = in.nextLine();
      }
      
      System.out.print("Enter age: ");
      String age = in.nextLine();
      System.out.print("Enter Year Level: ");
      String yearLevel = in.nextLine();
      System.out.print("Enter Phone Number: ");
      String pNumber = in.nextLine();
      System.out.print("Enter email: ");
      String email = in.nextLine();
      
      if (ans.toUpperCase().equals("YES") || ans.toUpperCase().equals("Y"))
         return new Student(studentID, firstName, middleName, lastName, suffix, age, yearLevel, pNumber, email);
      else
         return new Student(studentID, firstName, middleName, lastName, age, yearLevel, pNumber, email);
   }

   public static void main (String[] args) {
      Scanner in = new Scanner(System.in);
      ArrayList<Student> studentsRecord = new ArrayList<>();
      
      int choice = 0;
      do {
         if (studentsRecord.isEmpty()) {
            System.out.println("Selection Menu: ");
            System.out.println("----------------------------------");
            System.out.print("[1] Create Student Record\n[0] Exit\nChoice: ");
            choice = in.nextInt();
            in.nextLine();
            System.out.println("----------------------------------");
            
            switch(choice) {
               case 1:
                  Student newStudent = getStudentDetails(in);
                  studentsRecord.add(newStudent);
               break;
            }
         } else if (!studentsRecord.isEmpty()) {
            System.out.println("Student Record Selection Menu: ");
            System.out.println("----------------------------------");
            System.out.print("[1] Update Student Profile details\n[2] Update Student Course details\n" + 
                               "[3] Display Student Record\n[0] Exit\nChoice:   ");
            choice = in.nextInt();
            in.nextLine();
            System.out.println("----------------------------------");
            
            switch(choice) {
            case 1:
               System.out.print("Enter Index of Student to Update: ");
               int index = in.nextInt();
               
               studentsRecord.get(index);
            break;
            case 3:
               System.out.println("----------------------------------");
                for (Student eachStudent: studentsRecord) {
                  System.out.println("StudentID: " + eachStudent.getStudentID());
                  System.out.println("First Name: " + eachStudent.getFirstName() );
                  System.out.println("Middle Name: " + eachStudent.getMiddleName());
                  System.out.println("Last Name: " + eachStudent.getLastName());
                  System.out.println("Suffix: " + eachStudent.getSuffix());
                  System.out.println("Age: " + eachStudent.getAge());
                  System.out.println("Year Level: " + eachStudent.getYearLevel());
                  System.out.println("Phone Number: " + eachStudent.getPNumber());
                  System.out.println("Email: " + eachStudent.getEmail());
                }
               System.out.println("----------------------------------");
            break;
         }

         }
      } while(choice != 0);
   }
}
