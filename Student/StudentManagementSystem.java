
    //Student Module 
    
import java.util.ArrayList;
import java.util.Scanner;



public class StudentManagementSystem{
    public static void main(String[] args){
     Scanner scanner= new Scanner(System.in);


    StudentServices service= new StudentServices();

        boolean keepruning=true;
        int choice;
        do { 
            System.out.println("Choose your option");
            System.out.println("1. Add Student ");  //done 
            System.out.println("2. View Student");  //done 
            System.out.println("3. Search Student");  //done 
            System.out.println("4. Update Student Profile  "); 
            System.out.println("5. Delete ");
            System.out.println("6. Exit ");
            choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    service.AddStudent();
                    break;
                case 2:
                    service.viewStudent();
                    break;
                case 3:
                    service.SearchStudent();
                    break;
                case 4:
                    service.UpdateStudentProfile();
                    break;
                case 5:
                    service.Delete();
                    break;
                case 6:
                    keepruning=false;
                    System.out.println("Thank you");
                    break;                
                default:
                    System.out.println("Please choose correct option");
                    break; 
            }



        } while (keepruning);


    }
}

class StudentServices  {
    Scanner scanner= new Scanner(System.in); 
     ArrayList<Student> StudentList=new ArrayList<>();


     // // ADD new Student  .................

   void AddStudent(){
     System.err.println("Enter Number Of Student You Want To Add ");
     int numberOfStudent=scanner.nextInt();
     scanner.nextLine();
     for (int i=1; i<=numberOfStudent;i++){
    System.out.println("Enter Student "+ i  +" Data ");
    System.out.println("Enter Student name ");
    String name=scanner.nextLine();
    System.out.println("Enter Student ID");
    String studentID=scanner.nextLine();
    if (isDublicateStudent(studentID)==true){
        System.out.println("This Id alredy exist Please varify your student ID  ...");
        continue;
    }
//  


    System.out.println("Enter Department :");
    String department= scanner .nextLine();
    System.out.println("Enter Semster ( 1 - 8 )");

    int semster=scanner.nextInt();
    scanner.nextLine();
   
    System.out.println("Enter Student Email ID :");
    String emailId =scanner.nextLine();
    System.out.println("Enter Phone number ");
    String phoneNumber=scanner.nextLine();
    


    StudentList.add(new Student(name,studentID,department,semster,emailId,phoneNumber));   

     }


   } 
    //prevent from Dublicated Student Id
    boolean isDublicateStudent(String studentId){
        for(Student s:StudentList){
            if (s.getStudentID().equals(studentId)){
                return true;
            }
        }
        return false;
    }
   void viewStudent(){
    for( Student s: StudentList){
        System.out.println(s);
    }
   

   }
//Search Student .............................

   void SearchStudent(){
    boolean found=false;
   // Search Student through Name  
  System.out.println("Enter Student Enrollment ID : ");
  String enroll= scanner.nextLine();
  for (int i=0; i<StudentList.size();i++){
        if (StudentList.get(i).getStudentID().equalsIgnoreCase(enroll)){
            found=true;
                 System.out.println(StudentList.get(i));
             }
    
  }
   if(found !=true){
        System.out.println("Student not Found !!lol");
    }

 
   }
//Update Student Profile .........................
   void UpdateStudentProfile(){
     
     System.out.println("Enter Student ID :");
     String enroll=scanner.nextLine();
     boolean found=false;
     for (int i=0; i<StudentList.size();i++){
           if ( StudentList.get(i).getStudentID().equalsIgnoreCase(enroll)){
        boolean keepruning=true;
        found=true;
        int choice;

        do {
            System.out.println("Choose Field you want to Update ");
            System.out.println("1. Semester");
            System.out.println("2. Email Address");
            System.out.println("3. phone number");
            System.out.println("4. Back to main menu");
            choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Your Current Semster");
                    int semester= scanner.nextByte();
                    scanner.nextLine();
                    StudentList.get(i).setSemester(semester);
                    System.out.println("Your Updated Semster is :"+StudentList.get(i).getSemester());
                    break;

                case 2:
                    System.out.println("Enter Your New Email :");
                    String email=scanner.nextLine();
                    StudentList.get(i).setEmail(email);
                    System.out.println("Your Updated Email-ID : "+StudentList.get(i).getEmail());
                    break;
                case 3:
                    System.out.println("Enter Your New Phone Number: ");
                    String pNumber= scanner.nextLine();
                    StudentList.get(i).setPhoneNumber(pNumber);
                    System.out.println("You Updated Phone Numebr : "+StudentList.get(i).getPhoneNumber());
                    break;  

                case 4:
                    keepruning =false;
                    break;

                

            }



            
        } while (keepruning);

           }
         
     }
        if (found !=true){
            System.out.println("Please varify you detailed ");
        }
   }

   //Delete particualr Field......
   void Delete(){
    System.out.println("Enter Student ID : ");
    String enroll  = scanner.nextLine();
    boolean found=false;

    for(int i=0; i<StudentList.size();i++){
         if(StudentList.get(i).getStudentID().equals(enroll)){
            found=true;
            StudentList.remove(i);
            System.out.println("Field is Deleated .....");
         }

    }
    if(found !=true){
        System.out.println("Student not Found !!lol");
    }

   }

}




class Student{

        private String name;
    private String studentID;
    private String department;
    private int semester;
    private String emailId;
    private String phoneNumber;

    public Student(String name,String studentID,String department,int semester,String emailId,String phoneNumber) {
        this.name=name;
        this.studentID=studentID;
        this.department=department;
        this.semester=semester;
        this.emailId=emailId;
        this.phoneNumber=phoneNumber;


    }

    public Student(){

    }
    //get name 
    public String  getName(){
        return this.name;
    }
   //set name 
    public void  setName(String name ){
         this.name =name ;
    }
    // get Student Id 
    public String  getStudentID(){
        return this.studentID;

    }
    //set Student ID;
    public void setStudentID(String studentID){
         this.studentID=studentID;
    }
    //get Departments 
    public String getDepartments(){
        return this.department;

    }
    //set departments 
    public void setdepartments(String departments){
        this.department=departments;

    }
    //get semester
    public int getSemester(){
        return this.semester;

    }
    //set Semester
    public void setSemester(int semester){
         this.semester=semester;

    }
    //get Email Id
    public String getEmail(){
        
        return this.emailId;
    
    }
    //set Email ID
    public void setEmail(String email){
        
           this.emailId=email;

    }

//note ---> Usually setter do not return anything they just set value 

      

    

    //get Phone Number 
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    //set Phone number 
    public void setPhoneNumber(String number){
         this.phoneNumber=number;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + studentID + ", Dept: " + department + 
               ", Semester: " + semester + ", Email: " + emailId + ", Phone: " + phoneNumber;
    }


}





