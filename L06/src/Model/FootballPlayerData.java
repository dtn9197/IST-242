package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FootballPlayerData  implements TableData, Displayable, Sortable
{

  
    private ArrayList<FootballPlayer> players;
    private int firstLineToDisplay;
    private int lastLineToDisplay;
    private int lineToHighlight;
    private int linesBeingDisplayed;
    private int sortType;
    private int sortField;
    private static int numberOfPlayersHightlighted = 0;
  

    public FootballPlayerData()
    {
        players = new ArrayList<>();
        loadTable();   
    }
    public void loadTable()
    {
        ReadPlayersFromXML();
    }
    public ArrayList<String> getHeaders()
    {
        ArrayList<String> attributeNameArray = new ArrayList<String>();
        attributeNameArray.add(players.get(0).getAttributeName(0));
        attributeNameArray.add(players.get(0).getAttributeName(1));
        attributeNameArray.add(players.get(0).getAttributeName(2));
        attributeNameArray.add(players.get(0).getAttributeName(3));
        attributeNameArray.add(players.get(0).getAttributeName(4));
        attributeNameArray.add(players.get(0).getAttributeName(5));
        attributeNameArray.add(players.get(0).getAttributeName(6));
        attributeNameArray.add(players.get(0).getAttributeName(7));
        
        return attributeNameArray;
         
    }
    public ArrayList<String> getLine(int line)
    {
       return  getPlayers().get(line).getAttribute();
    }
    
    
     public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine)
     {
         ArrayList<ArrayList<String>> dummyArrayList = new ArrayList<>();
         
         for (int i = firstLine; i <= lastLine; i++)
         {
             dummyArrayList.add(getLine(i));
             
         }
         return dummyArrayList;
         
     }
     
     public ArrayList<FootballPlayer> getPlayersList(int firstLine, int lastLine)
     {
         ArrayList<FootballPlayer> dummyArrayList = new ArrayList<>();
         for (int i = firstLine; i <= lastLine; i++)
         {
             dummyArrayList.add(this.getPlayers().get(i));
         }
         return dummyArrayList;
         
     }
     
     public void sortFootballPlayerTable(int attributeIndex)     //this methods creates 8 comparator for 8 attributes
    {                                                            //then picks one comparator depending on the attributeIndex
        Comparator<FootballPlayer>sortByPosition = new Comparator<FootballPlayer>()
        {
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2)
            {
                return player1.getPosition().compareTo(player2.getPosition());
            } 
        };
        
        Comparator<FootballPlayer>sortByNumber = new Comparator<FootballPlayer>()
        {
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2) 
            {
                if (player1.getNumber() < player2.getNumber()) { return -1;}
                if (player1.getNumber() > player2.getNumber()) {return 1;}
                return 0; 
            } 
        };
        
        Comparator<FootballPlayer>sortByState = new Comparator<FootballPlayer>()
        {
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2)
            {
                return player1.getState().compareTo(player2.getState());
            } 
        };
        
        Comparator<FootballPlayer>sortByHighschool = new Comparator<FootballPlayer>()
        {
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2)
            {
                return player1.getHighSchool().compareTo(player2.getHighSchool());
            } 
        };
        
        Comparator<FootballPlayer>sortByHometown = new Comparator<FootballPlayer>()
        {
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2)
            {
                return player1.getHomeTown().compareTo(player2.getHomeTown());
            } 
        };
       
        Comparator<FootballPlayer>sortByWeight = new Comparator<FootballPlayer>()
        {
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2) 
            {
                if (player1.getWeight() < player2.getWeight()) { return -1;}
                if (player1.getWeight() > player2.getWeight()) {return 1;}
                return 0; 
            } 
        };
       
        Comparator<FootballPlayer> sortByName = new Comparator<FootballPlayer>()
        {
            
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2)
            {
                return player1.getName().compareTo(player2.getName());
            }
            
        };
        
        Comparator<FootballPlayer> sortByHeight = new Comparator<FootballPlayer>()
        {
            
            @Override
            public int compare(FootballPlayer player1, FootballPlayer player2)
            {
                if (player1.getHeight().getFeet() < player2.getHeight().getFeet()) {return -1;}
                if (player1.getHeight().getFeet() > player2.getHeight().getFeet()) {return 1;}
                if (player1.getHeight().getFeet() == player2.getHeight().getFeet())
                {
                    if (player1.getHeight().getInches() < player2.getHeight().getInches()) {return -1;}
                    if (player1.getHeight().getInches() > player2.getHeight().getInches()) {return 1;}
                }
                return 0;
            }
            
        };
        
        switch(attributeIndex)
        {
            case 0: Collections.sort(players,sortByHeight);break;
            case 1: Collections.sort(players,sortByWeight);break;
            case 2: Collections.sort(players,sortByName);break;
            case 3: Collections.sort(players,sortByHometown);break;
            case 4: Collections.sort(players,sortByHighschool);break;
            case 5: Collections.sort(players,sortByState);break;
            case 6: Collections.sort(players,sortByNumber);break;
            case 7: Collections.sort(players,sortByPosition);break;
        }
     
    }
     
     
    public int getFirstLineToDisplay() {return firstLineToDisplay;}
    public int getLineToHighlight(){ return lineToHighlight;}
    public int getLastLineToDisplay(){return lastLineToDisplay;}
    public int getLinesBeingDisplayed(){return linesBeingDisplayed;}
    
    public void setFirstLineToDisplay(int firstLine) {firstLineToDisplay = firstLine;} 
    public void setLineToHighlight(int highlightedLine){lineToHighlight = highlightedLine;}
    public void setLastLineToDisplay(int lastLine){lastLineToDisplay= lastLine;}
    public void setLinesBeingDisplayed(int numberOfLines){linesBeingDisplayed = numberOfLines;}
    
    public int getSortType() {return sortType;}
    public void SetSortType(int sortType) {this.sortType = sortType;}
    public int getSortField() {return sortField;}
    public void SetSortField(int sortField) { this.sortField = sortField;}
    
    

    public void ReadPlayersFromXML()
    {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    players.add(fp);

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx) {xx.printStackTrace();}
    }
    
                    /* below are the get/set method for instance variable*/
    
    public ArrayList<FootballPlayer> getPlayers() {
        return players;
    }

    
    public void setPlayers(ArrayList<FootballPlayer> players) {
        this.players = players;
    }
      /**
     * @return the numberOfPlayersHightlighted
     */
    public static int getNumberOfPlayersHightlighted() {
        return numberOfPlayersHightlighted;
    }

    /**
     * @param aNumberOfPlayersHightlighted the numberOfPlayersHightlighted to set
     */
    public static void setNumberOfPlayersHightlighted(int aNumberOfPlayersHightlighted) {
        numberOfPlayersHightlighted = aNumberOfPlayersHightlighted;
    }
}
