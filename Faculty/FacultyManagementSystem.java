
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
            String facultyID=scanner.nextLine();
            // isInputEmpty(FacultyID);

            //check unique faculty ID :
            while(  isDublicateFacultyId(facultyID)){
                System.out.println("This Faculty Id is alredy exist ");
                System.out.println("Re Entered faculty Id : ");
                facultyID=scanner.nextLine();
                
            }
            
            System.out.println("Enter Faculty Name : ");
            String facultyName=scanner.nextLine();
            // isInputEmpty(facultyName);

            System.out.println("Enter Department : ");
            String department=scanner.nextLine();
            // isInputEmpty(department);
            
            System.out.println("Enter Subject : " );
            String subject=scanner.nextLine();
            // isInputEmpty(subject);

            System.out.println("Enter Email Id :");
            String emailId=scanner.nextLine();
            // isInputEmpty(emailId);

            System.out.println("Enter Experince : ");
            int experience=scanner.nextInt();
            scanner.nextLine();
            
            while (!experienceValidation(experience)){
                System.out.println("Not Valid Experince ");
                System.out.println("Please Re-Enter Valid Experience ");
                experience=scanner.nextInt();
                scanner.nextLine();

            }
            
            //Adding into ArrayList 

            FacultyList.add( new Faculty(facultyID,facultyName,department,subject,emailId,experience));




        }


    }
    //check inpus is empty 
    boolean isInputEmpty(String input){
        if (input==null ||input.trim().isEmpty()){
            return  true;
        }

        return  false;

    }
    // check unieq Faculty id 
    boolean isDublicateFacultyId(String facultyID){
         for(Faculty f:FacultyList){
            if (f.getFacultyId().equalsIgnoreCase(facultyID)){
                return true;
            }

         }
         return false;
    }
      //experience Validation 
    boolean experienceValidation(int experience){
        if (experience>0 ){

            return true; 
        }

        return false;
    }

    void viewFaculty(){
        boolean found=false;
        for(Faculty f:FacultyList){
            found =true;
            System.out.println(f);
        }
        if (found !=true){
            System.out.println(" NO faculty Record Found !!");
        }

    }
    //search Faculty By Faculty ID :
    void searchFaculty(){
    System.out.println("Enter Faculty ID :");
    String facultyID=scanner.nextLine();
    boolean found=false;
    for(Faculty f:FacultyList){
        if (f.getFacultyId().equalsIgnoreCase(facultyID)){
            System.out.println(f);
            found=true;
        }
    }
    if (found !=true){
        System.out.println(" Faculty is not found please varify faculty ID");

    }
        


    }

    void updateFacultyProfile(){
        System.out.println("Enter Faculty Id :");
        String facultyId=scanner.nextLine();
        boolean found =false;
        for (Faculty f:FacultyList){
            if (f.getFacultyId().equalsIgnoreCase(facultyId)){
                 boolean keepRuning=true;
                found=true;
                int choice ;
                do{
                  System.out.println("Choose you Options.......");
                  System.out.println("1.Update Departments ");
                  System.out.println("2.Update Subject ");
                  System.out.println("3.Update Email ID ");
                  System.out.println("4. Update Experience ");
                  System.out.println("5. Back To Main Menu ");
                  choice=scanner.nextInt();
                  scanner.nextLine();

                  switch(choice){
                    case 1:
                        System.out.println("Enter New Department  :");
                        String department=scanner.nextLine();
                        f.setDepartments(department);
                        System.out.println("Your current Department is :"+f.getDepartments());
                        break;

                    case 2:
                        System.out.println("Enter New Subject  : ");
                        String subject =scanner.nextLine();
                        f.setSubject(subject);
                        System.out.println("Your Current Subject Is : "+f.getSubject());
                        break;

                    case 3:
                        System.out.println("Enter New Email-ID  :");
                        String email=scanner.nextLine();
                        f.setEmailId(email);
                        System.err.println("Your Preasent Email Is : "+f.getEmailId());
                          break;

                    case 4 :
                        System.out.println("Enter New Experience  : ");
                        int experience = scanner.nextInt();
                        scanner.nextLine();
                        f.setExperience(experience);
                        System.out.println("Your Current Experince Is : "+f.getExperience());
                        break;
                    case 5:
                        keepRuning=false;
                        break;    

                    default:
                          System.out.println("Please choose your currect options :");
                          keepRuning=false;
                            break;

                  }

                }while(keepRuning);

            }
        }
        if(found !=true){
            System.out.println("Faculty is not Found  Please varify Faculty if ");
        }

    }

    void removeFaculty(){
        System.out.println("Enter Faculty Id :");
        String facultyID=scanner.nextLine();
        boolean remove =FacultyList.removeIf(f ->f.getFacultyId().equalsIgnoreCase(facultyID)); //using removeIf
        if (remove){
            System.out.println("faculty is remove from datasets");

        }else{
            System.out.println("Faculty is not found please Varify deatiles ....");
        }
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
    public void setFacultyId(String facultyID){
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
        return  "Facult Id :  "+this.facultyID+ " ,  Faculty Name : "+this.facultyName +",   Department : "+this.department+ " ,  Subject :"+this.subject+" ,  Email ID : "+this.emailId +" ,  Experience :"+ this.experience;

    }

    
    

}

