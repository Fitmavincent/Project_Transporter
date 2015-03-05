package pt.projecttransporter;

/**
 * Created by JuLIANG on 5/03/15.
 */
public class uq9db_volatile {
     //Enum objects
    public enum Drive{D, _;}
    public enum GoCard{St,Ad;}

    // private variables
    private int id;
    private Drive drive;
    private int carspace;
    private GoCard gocard;

    // Empty constructor
    public uq9db_volatile(){}

    // constructor
    public uq9db_volatile(int id, Drive drive, int carspace, GoCard gocard){
        this.id = id;
        this.drive = drive;
        this.carspace = carspace;
        this.gocard = gocard;
    }

    // Getters
    public int getID(){return this.id;}
    public Drive getDrive(){return this.drive;}
    public int getCarspace(){return this.carspace;}
    public GoCard getGoCard(){return this.gocard;}

    // Setters
    public void setID(int id){this.id = id;}
    public void setDrive(Drive drive){this.drive = drive;}
    public void setCarspace(int carspace){this.carspace = carspace;}
    public void setGoCard(GoCard gocard){this.gocard = gocard;}
}
