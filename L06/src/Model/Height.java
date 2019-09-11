package Model;

public class Height
{
    private int feet;                   /*instance variables */
    private int inches;
    
    public Height() {}
    public Height(int inf_feet, int inf_inches)       /* Constructors */
    {
        feet = inf_feet;
        inches = inf_inches;
    }
    
     public String toString()
    {
        return getFeet() + "\"" + getInches() + "'";
    }
     
     
    
    /**            BELOW IS ALL GET/SET METHODS FOR INSTANCE VARIABLES                                                  
     * @return the feet
     */
    public int getFeet() {                         
        return feet;
    }

    /**
     * @param feet the feet to set
     */
    public void setFeet(int feet) {
        this.feet = feet;
    }

    /**
     * @return the inches
     */
    public int getInches() {
        return inches;
    }

    /**
     * @param inches the inches to set
     */
    public void setInches(int inches) {
        this.inches = inches;
    }
}
