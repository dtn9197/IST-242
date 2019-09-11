
package View;

import Model.FootballPlayer;
import java.util.ArrayList;

public class View
{
    private InitialFrame myFrame;
    public View()
    {
        myFrame = new InitialFrame();
         
    }
    
    public void CenterInitialSetup(int row, int column)
    {
        myFrame.getInitialPanel().getCenterPanel().SetUpGrid(row, column);
        
        
    }
    
    public void CenterUpdate(ArrayList<ArrayList<String>> list, ArrayList<String> headers)
    {
        myFrame.getInitialPanel().getCenterPanel().loadHeaders(headers);
        myFrame.getInitialPanel().getCenterPanel().loadPlayersTable(list);
        
    }
    
    public void scrollingTable(ArrayList<ArrayList<String>> stringList)
    {
      myFrame.getInitialPanel().getCenterPanel().modifyPlayersTable(stringList);
       
        
    }
    public void hightlightPlayers(ArrayList<ArrayList<String>> stringList, ArrayList<FootballPlayer> playersList)
    {
        myFrame.getInitialPanel().getCenterPanel().highlightPlayers(stringList, playersList);   
    }
    
    
  
    
    /**
     * @return the myFrame
     */
    public InitialFrame getMyFrame() {
        return myFrame;
    }

    /**
     * @param myFrame the myFrame to set
     */
    public void setMyFrame(InitialFrame myFrame) {
        this.myFrame = myFrame;
    }
    
    
    
    
   
}
