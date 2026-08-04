//Student Module 
import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem{

    public static void main(String[] args){
     Scanner scanner= new Scanner(System.in);


Student obj= new Student();
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
                    obj.AddStudent();
                    break;
                case 2:
                    obj.viewStudent();
                    break;
                case 3:
                    obj.SearchStudent();
                    break;
                case 4:
                    obj.UpdateStudentProfile();
                    break;
                case 5:
                    obj.Delete();
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

class Student{
     Scanner scanner= new Scanner(System.in); 
     ArrayList<Student> StudentList=new ArrayList<>();


    private String name;
    private String studentID;
    private String department;
    private int semster;
    private String emailId;
    private String phoneNumber;

    public Student(String name,String studentID,String department,int semster,String emailID,String phoneNumber) {
        this.name=name;
        this.studentID=studentID;
        this.department=department;
        this.semster=semster;
        this.emailId=emailID;
        this.phoneNumber=phoneNumber;


    }

    public Student(){

    }

    
// ADD new Student  .................

   void AddStudent(){
     System.err.println("Enter Number Of Student You Want To Add ");
     int numberOfStudent=scanner.nextInt();
     scanner.nextLine();
     for (int i=0; i<numberOfStudent;i++){
            System.out.println("Enter Student name ");
    String name=scanner.nextLine();
    System.out.println("Enter Student ID");
    String studentID=scanner.nextLine();
    System.out.println("Enter Department :");
    String department= scanner .nextLine();
    System.out.println("Enter Semster");

    int semster=scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter Student Email ID :");
    String emailId =scanner.nextLine();
    System.out.println("Enter Phone number ");
    String phoneNumber=scanner.nextLine();

    StudentList.add(new Student(name,studentID,department,semster,emailId,phoneNumber));   

     }


   } 

   void viewStudent(){
    for( Student s: StudentList){
        System.out.println(s);
    }
   

   }
//Search Student .............................

   void SearchStudent(){
   // Search Student through Name  
  System.out.println("Enter Student Name : ");
  String name= scanner.nextLine();
  for (int i=0; i<StudentList.size();i++){
        if (StudentList.get(i).name.equals(name)){
                 System.out.println(StudentList.get(i));
             }
    
  }
 
   }
//Update Student Profile .........................
   void UpdateStudentProfile(){
     System.out.println("Enter Student Name : ");
     String name =scanner.nextLine();
     for (int i=0; i<StudentList.size();i++){
           if (StudentList.get(i).name.equals(name)){
        boolean keepruning=true;
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
                    int semster= scanner.nextByte();
                    scanner.nextLine();
                    StudentList.get(i).semster= semster;
                    System.out.println("Your Updated Semster is :"+StudentList.get(i).semster);
                    break;

                case 2:
                    System.out.println("Enter Your New Email :");
                    String email=scanner.nextLine();
                    StudentList.get(i).emailId=email;
                    System.out.println("Your Updated Email-ID : "+StudentList.get(i).emailId);
                    break;
                case 3:
                    System.out.println("Enter Your New Phone Number: ");
                    String pNumber= scanner.nextLine();
                    StudentList.get(i).phoneNumber=pNumber;
                    System.out.println("You Updated Phone Numebr : "+StudentList.get(i).phoneNumber);
                    break;  

                case 4:
                    keepruning =false;
                    return;

                

            }

            
        } while (true);
           }
     }

   }

   //Delete particualr Field......
   void Delete(){
    System.out.println("Enter Student Name You want to Deleate from DataSets :");
    String name = scanner.nextLine();
    for(int i=0; i<StudentList.size();i++){
         if(StudentList.get(i).name.equals(name)){
            StudentList.remove(i);
            System.out.println("Field is Deleated .....");
         }
    }

   }

@Override  
public String toString(){
 return ("Name  :"+this.name+" Student ID : "+ this.studentID+" , Department :  " +this.department+" , Semester :  " +this.semster+" , Email ID :  "+this.emailId+" , Phone Number : "+this.phoneNumber);

}

}

