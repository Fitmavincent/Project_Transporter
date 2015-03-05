package pt.projecttransporter;

/**
 * Created by JuLIANG on 5/03/15.
 */
public class uq9db_gocard {
        //Enum objects
        public enum GoCard{St,Ad;}

        // private variables
        private int id;
        private GoCard gocard;

        // Empty constructor
        public uq9db_gocard() {
        }

        // constructor
        public uq9db_gocard(int id, GoCard gocard, int carspace)
        {
            this.id = id;
            this.gocard = gocard;
        }

            // Getters
        public int getID(){
            return this.id;
        }

        public GoCard getGoCard()
        {
            return this.gocard;
        }

        // Setters
        public void setID(int id){this.id = id;}
        public void setGoCard(GoCard gocard){this.gocard = gocard;}
    }



