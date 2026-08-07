
import java.util.ArrayList;
import java.util.Scanner;

public class FacultyManagementSystem{
    // Scanner scanner =new Scanner(System.in); //why global thing not accessed in faculty serivces class 

    public static void main(String[] args){
        FacultyServices services =new FacultyServices();


        Scanner scanner=new Scanner(System.in);
        int choice;
        boolean keepRuning=true;
        do { 
            System.out.println("Choose your option ");
            System.out.println(" 1. Add New Faculty ");
            System.out.println(" 2. View All Faculty ");
            System.out.println(" 3. Search Faculty  ");
            System.out.println(" 4. Update Faculty Profile  ");
            System.out.println(" 5. remove Faculty  ");
            System.out.println(" 6. Exit ");
            
            choice =scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    services.addNewFaculty();
                    break;

                case 2:
                    services.viewFaculty();
                    break;

                case 3:
                    services.searchFaculty();   
                    break; 

                case 4: 
                    services.updateFacultyProfile();
                    break; 
                case 5:
                    services.removeFaculty();
                    break;
                case 6:
                    keepRuning=false;
                    System.out.println("Thank you ");    
                    break; 
                default:
                    System.out.println("Please Choose Correct Opetions :");
                    break;                 
            }

            
        } while (keepRuning);



    }
}


class FacultyServices{
        Scanner scanner=new Scanner(System.in);
        ArrayList<Faculty> FacultyList= new ArrayList<>();



    void addNewFaculty(){
        int numberOfFaculty;
        System.out.println("Enter Number Of Faculty You Want to Add...");
        numberOfFaculty=scanner.nextInt();
        scanner.nextLine();

        for(int i=1; i<=numberOfFaculty;i++){
            System.out.println("Enter Faculty "+ i+ " Detailed ..");
            System.out.println("Enter Faculty Id : ");
            String FacultyID=scanner.nextLine();

            System.out.println("Enter Faculty Name : ");
            String facultyName=scanner.nextLine();

            System.out.println("Enter Department : ");
            String department=scanner.nextLine();
            
            System.out.println("Enter Subject : " );
            String subject=scanner.nextLine();

            System.out.println("Enter Email Id :");
            String emailId=scanner.nextLine();

            System.out.println("Enter Experince : ");
            int experience=scanner.nextInt();
            scanner.nextLine();
            
            //Adding into ArrayList 

            FacultyList.add( new Faculty(FacultyID,facultyName,department,subject,emailId,experience));




        }


    }

    void viewFaculty(){
        for(Faculty f:FacultyList){
            System.out.println(f);
        }

    }

    void searchFaculty(){


    }

    void updateFacultyProfile(){

    }

    void removeFaculty(){

    }
}

class Faculty{
    

    private String  facultyID;
    private  String facultyName;
    private  String department;
    private  String subject;
    private  String  emailId;
    private  int  experience;

    public Faculty(String facultyID,String facultyName, String department, String subject, String emialId,int experince) {
        this.facultyID=facultyID;
        this.facultyName=facultyName;
        this.department=department;
        this.subject=subject;
        this.emailId=emialId;
        this.experience=experince;

    }
    //empty constructor 
    public Faculty(){

    }

    //get facultyID
    public String getFacultyId(){
        return  this.facultyID;

    }
    //set FacultyId 
    public void setFacultyId(String facultyId){
        this.facultyID=facultyID;
    }
    
    //get Faculty name 
    public String getFacultyName(){
        return this.facultyName;
    }

    //set faculty name 
    public void setFacultyName(String facultyName){
        this.facultyName=facultyName;

    }
    //get departments

    public String getDepartments(){
        return  this.department;

    }
    //set departments

    public void setDepartments(String department){
        this.department=department;
    }

    // get subject
    public String getSubject(){
        return  this.subject;
    }
    //set Subject

    public void setSubject(String subject){
        this.subject=subject;

    }

    //get EmailID 
    public String getEmailId(){
        return  this.emailId;
    }
    //set emailId 
    public void setEmailId(String emailId){
        this.emailId=emailId;
    }

    //get faculty Experinece 
    public int  getExperience(){
        return  this.experience;
    }
    
    //set Faculty Experince 

    public void setExperience(int experience){
        this.experience=experience;

    }


    @Override
    public  String toString(){
        return  "Facult Id :  "+this.facultyID+ " - Faculty Name : "+this.facultyName +"-  Department : "+this.department+ " - Subject :"+this.subject+" - Email ID : "+this.emailId +" - Experience :"+ this.experience;

    }

    
    

}

