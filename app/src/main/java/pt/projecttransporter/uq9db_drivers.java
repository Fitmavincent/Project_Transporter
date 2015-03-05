package pt.projecttransporter;

/**
 * Created by JuLIANG on 5/03/15.
 */
public class uq9db_drivers {
        //Enum objects
        public enum Drive{
            D, _;
        }

        // private variables
        private int id;
        private Drive drive;
        private int carspace;


        // Empty constructor
        public uq9db_drivers(){
        }

        // constructor
        public uq9db_drivers(int id, Drive drive, int carspace){
        this.id = id;
        this.drive = drive;
        this.carspace = carspace;
        }

    // Getters
    public int getID(){
        return this.id;
    }

    public Drive getDrive(){
        return this.drive;
    }

    public int getCarspace(){
        return this.carspace;
    }

    // Setters
    public void setID(int id){this.id = id;}
    public void setDrive(Drive drive){this.drive = drive;}
    public void setCarspace(int carspace){this.carspace = carspace;}


}
