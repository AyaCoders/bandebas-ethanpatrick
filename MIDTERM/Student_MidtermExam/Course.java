class Course {
   private String[] courseNameArr = {"Bachelor of Science and Information Technology", "Bachelor of Science in Computer Science",
                                  "Associate of Computer Technology", "Bachelor of Science in Mechanical Engineering", 
                                  "Bachelor of Science in Civil Engineering"};
   private String[] courseCodeArr = {"BSIT", "BSCS", "BSME", "BSCE"};
   private String[] departmentArr = {"College of Computer Studies Department", "College of Engineering Department"};
   
   private String courseName;
   private String courseCode;
   private String department;
      
   public Course(int courseIndex, int courseCodeIndex, int departmentIndex) {
      this.courseName = courseNameArr[courseIndex];
      this.courseCode = courseCodeArr[courseCodeIndex];
      this.department = departmentArr[departmentIndex];
   }
   
   public static void DisplayCourses () {
   int i = 1;
      System.out.println("----------------------------------");
      for (String eachCourse : courseNameArr) {
         System.out.println(++i +". " + eachCourse + "(" + courseCodeArr[i]+ ")");
      }
      System.out.println("----------------------------------");
   }
}