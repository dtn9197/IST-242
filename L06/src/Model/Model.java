package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Model
{
    private FootballPlayerData fpDataTable;
    private ArrayList<Row> rows = new ArrayList<>();

    public Model()
    {
        FootballPlayerData fpData = new FootballPlayerData();
        fpDataTable = fpData;
        
        
       
    }
    
    public void sortFootballPlayerTable(int attributeIndex)
    {
        fpDataTable.sortFootballPlayerTable(attributeIndex);
    }
    
    public void search(String pattern, int columnIndex)
    {
        if (columnIndex == 8)   // 8 is the flag to indicate that the search is not specific to any attribute column
        {
            FootballPlayerData.setNumberOfPlayersHightlighted(0);
            for (FootballPlayer player: fpDataTable.getPlayers())
            {
                for (String attribute : player.getAttribute())
                {
                    if (!pattern.isEmpty() && attribute.toLowerCase().contains(pattern.toLowerCase()))
                    {
                        player.setHightlight(true);
                        FootballPlayerData.setNumberOfPlayersHightlighted(FootballPlayerData.getNumberOfPlayersHightlighted() + 1);
                        break; 
                    }
                    else 
                    {
                        player.setHightlight(false);
                    }

                } 
            }
            System.out.println("Current lines flagged(in model): " + FootballPlayerData.getNumberOfPlayersHightlighted()); 

        }
        else
        {
            searchSingleAttribute(pattern,columnIndex);
        }
          
    }
    
    public void searchSingleAttribute(String pattern, int columnIndex)
    {
        FootballPlayerData.setNumberOfPlayersHightlighted(0);
        for (FootballPlayer player: fpDataTable.getPlayers())
        {
                if (!pattern.isEmpty() && player.getAttribute(columnIndex).toLowerCase().contains(pattern.toLowerCase()))
                {
                    player.setHightlight(true);
                    FootballPlayerData.setNumberOfPlayersHightlighted(FootballPlayerData.getNumberOfPlayersHightlighted() + 1);
                }
                else 
                {
                    player.setHightlight(false);
                }
                
        }
           System.out.println("Current lines flagged(in model): " + FootballPlayerData.getNumberOfPlayersHightlighted()); 
        
    }
    
    
    
    
    /**
     * @return the fpDataTable
     */
    public FootballPlayerData getFpDataTable() {
        return fpDataTable;
    }

    /**
     * @param fpDataTable the fpDataTable to set
     */
    public void setFpDataTable(FootballPlayerData fpDataTable) {
        this.fpDataTable = fpDataTable;
    }
}
