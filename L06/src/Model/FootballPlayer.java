package Model;

import java.util.ArrayList;

public class FootballPlayer extends Person implements TableMember
{
    private int number;
    private String position;
    private boolean hightlight;
    private ArrayList<String> playerInfo;
    
   
    
    public FootballPlayer(){ System.out.println("the number is " + this.position); }
    public FootballPlayer(Height height,int weight,
String name,String hometown, String highSchool, String state,
int number, String position)
    {
        super(height,weight,name,hometown,highSchool,state);
        this.number = number;
        this.position = position;
        initializePlayerInfo();
    }
    
    public String toString()
    {
         return "Name: " + getName() + ", Position: " + getPosition() + ", Number: " + getNumber();
    }
    
                      /*Below is all 4 interface methods implementation */
    
    public String getAttribute(int index)
    {
        String attributeValue = " ";
        switch (index)
        {
            case 0: attributeValue = super.getHeight().toString();break;
            case 1: attributeValue = Integer.toString(super.getWeight());break;
            case 2: attributeValue = super.getName();break;
            case 3: attributeValue = super.getHomeTown();break;
            case 4: attributeValue = super.getHighSchool();break;
            case 5: attributeValue = super.getState();break;
            case 6: attributeValue = Integer.toString(getNumber());break;
            case 7: attributeValue = getPosition();break;
        }
        return attributeValue;
        
    }
       public ArrayList<String> getAttribute()
       {
        ArrayList<String> attributeValueArray = new ArrayList<String>();
        
        attributeValueArray.add(super.getHeight().toString());
        attributeValueArray.add(Integer.toString(super.getWeight()));
        attributeValueArray.add(super.getName());
        attributeValueArray.add(super.getHomeTown());
        attributeValueArray.add(super.getHighSchool());
        attributeValueArray.add(super.getState());
        attributeValueArray.add(Integer.toString(getNumber()));
        attributeValueArray.add(getPosition());
        
        return attributeValueArray;
           
       }
   
    public String getAttributeName(int index)
    {
        String attributeName = "";
        switch (index)
        {
            case 0: attributeName = "height";break;
            case 1: attributeName = "weight";break;
            case 2: attributeName = "name";break;
            case 3: attributeName = "hometown";break;
            case 4: attributeName = "high school";break;
            case 5: attributeName = "state";break;
            case 6: attributeName = "number";break;
            case 7: attributeName = "position";break;
        }
        return attributeName;
        
    }
    public ArrayList<String> getAttributeNames()
    {
        ArrayList<String> attributeNameArray = new ArrayList<String>();
        attributeNameArray.add("height");
        attributeNameArray.add("weight");
        attributeNameArray.add("name");
        attributeNameArray.add("home town");
        attributeNameArray.add("high school");
        attributeNameArray.add("state");
        attributeNameArray.add("number");
        attributeNameArray.add("position");
        
        return attributeNameArray;
        
    }
    public void initializePlayerInfo()
    {
        playerInfo.add(super.getHeight().toString());
        playerInfo.add(Integer.toString(super.getWeight()));
        playerInfo.add(super.getName());
        playerInfo.add(super.getHomeTown());
        playerInfo.add(super.getHighSchool());
        playerInfo.add(super.getState());
        playerInfo.add(Integer.toString(getNumber()));
        playerInfo.add(getPosition());
        
    }
    
   
    /**                below is get/set methods for instance variables
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
     /**
     * @return the hightlight
     */
    public boolean isHightlight() {
        return hightlight;
    }

    /**
     * @param hightlight the hightlight to set
     */
    public void setHightlight(boolean hightlight) {
        this.hightlight = hightlight;
    }
    /**
     * @return the playerInfo
     */
    public ArrayList<String> getPlayerInfo() {
        return playerInfo;
    }

    /**
     * @param playerInfo the playerInfo to set
     */
    public void setPlayerInfo(ArrayList<String> playerInfo) {
        this.playerInfo = playerInfo;
    }
    
}
