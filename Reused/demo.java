public class demo{
    public static void main(String[] args) {
        
    }
}
//We use a base user because of this indicator. This is not defined completely, but we need to implement further. 
abstract class  BaseUser{
    String name;
    String Department;
    String emailId;
    String phoneNumber;


}

interface  CrudOperation{

    
    void Add();
    void View();
    void Search();
    void Update();
    void Remove();

    //getID 
    // void getId();

    //set Id
    void setId();

}
class  Student extends  BaseUser implements  CrudOperation{
    
    @Override
    public void  Add(){

    }
    @Override
    public void View(){

    }
     @Override
    public void Search(){

    }
     @Override
    public void Update(){

    }
     @Override
    public void Remove(){


    }
    @Override
    public  void  setId(){

    }

}

class  Faculty  extends  BaseUser implements  CrudOperation{
    
     @Override
    public void  Add(){

    }
 @Override
    public void View(){

    }

 @Override
    public void Search(){

    }

     @Override
    public void Update(){

    }
     @Override
    public void Remove(){
        
    }
    @Override
   public  void setId(){

    }

}


class UserManager<T extends CrudOperation>{

}