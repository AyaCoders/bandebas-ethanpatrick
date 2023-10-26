public class Student {
   private String studentID, firstName, middleName, lastName, suffix;
   private String age, yearLevel, pNumber, email; 
   
   public Student (String studentID, String firstName, String middlename, String lastName, String suffix, String age, String yearLevel, String pNumber, String email) {
      this.studentID = studentID;
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.suffix = suffix;
      this.age = age;
      this.yearLevel = yearLevel;
      this.pNumber = pNumber;
      this.email = email;
   }
   
   public Student (String studentID, String firstName, String middlename, String lastName, String age, String yearLevel, String pNumber, String email) {
      this.studentID = studentID;
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.suffix = "None";
      this.age = age;
      this.yearLevel = yearLevel;
      this.pNumber = pNumber;
      this.email = email;
   }
   
   public String getStudentID () {
      return studentID;
   }
   
   public String getFirstName () {
      return firstName;
   }
   
   public String getMiddleName () {
      return middleName;
   }
   
   public String getLastName () {
      return lastName;
   }
   
   public String getSuffix () {
      return suffix;
   }
   
   public String getAge () {
      return age;
   }
   
   public String getYearLevel () {
      return yearLevel;
   }
   
    public String getPNumber () {
      return pNumber;
   }
   
    public String getEmail () {
      return email;
   }

   public void setFirstName (String firstName) {
      this.firstName = firstName;
   }
   
   public void setMiddleName (String middleName) {
      this.middleName = middleName;
   }

   public void setLastName (String lastName) {
      this.lastName = lastName;
   }
   
   public void setSuffix (String suffx) {
      this.suffix = suffix;
   }

   public void setAge (String age) {
      this.age = age;
   }

   public void setYearLevel (String yearLevel) {
      this.yearLevel = yearLevel;
   }

   public void setPNumber (String pNumber) {
      this.pNumber = pNumber;
   }
   
   public void setEmail (String email) {
      this.email = email;
   }


}