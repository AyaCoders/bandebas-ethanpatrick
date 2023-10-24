public class Student {
   private String first_name, middle_name, last_name, suffix; 
   
   Student (String firstName, String middleName, String lastName, String suffix) {
      first_name = firstName;
      middle_name = middleName;
      last_name = lastName;
      this.suffix = suffix;
   }
   
   public void setFirstName (String newName) {
      first_name = newName;
   }

   public void setMiddleName (String newName) {
      middle_name = newName;
   }

   public void setLastName (String newName) {
      last_name = newName;
   }

   public void setSuffix (String newName) {
      suffix = newName;
   }

   
   public String getFirstName () {
      return first_name;
   }
   
   public String getMiddleName () {
      return middle_name;
   }

   public String getLastName () {
      return last_name;
   }

   public String getSuffix () {
      return suffix;
   }
   
   public String getFullName () {
      return first_name + " " + middle_name + " " + last_name + " " + suffix;
   }

}