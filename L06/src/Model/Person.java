
package Model;

public class Person 
{
    private Height height;
    private int weight;
    private String name;
    private String hometown;
    private String highSchool;
    private String state;
    
    public Person() {}
    public Person(Height height, int weight, String name,
String hometown, String highSchool, String state)
    {
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.hometown = hometown;
        this.highSchool = highSchool;
        this.state = state;
        
        
    }
    
    public String toString()
    {
        return "Name: " + getName() + ", weight: " + getWeight() + ", height: " + getHeight() +
     ", hometown: " + getHomeTown() + ", High School: " + getHighSchool() + ", State: " + getState();
    }
    
    
    
    
    /**               below is all get/set methods for instance variables 
     * @return the height
     */
    public Height getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Height height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the homeTown
     */
    public String getHomeTown() {
        return hometown;
    }

    /**
     * @param homeTown the homeTown to set
     */
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * @return the highSchool
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    
}
