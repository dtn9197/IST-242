
package View;

import Model.FootballPlayer;
import Model.FootballPlayerData;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import View.NorthPanel;

public class CenterPanel extends JPanel
{
    private GridLayout myLayout;
    private ArrayList<JButton> headerButtons = new ArrayList<JButton>();
    private ArrayList<JButton> attributeButtons = new ArrayList<JButton>();
    private int currentHeaderButtonHighlighted = 8;
    private int linesDisplayed;
    
   
    
   
    public CenterPanel()
    {
        this.setBackground(Color.BLACK);
        
        
    }
    
    public void SetUpGrid(int row, int column)
    {
        setLinesDisplayed(row);
        myLayout = new GridLayout(getLinesDisplayed() + 1, column, 7, 7);   //the last 2 parameters are arbitrary
        this.setLayout(myLayout);
       
        
        
        
        
        
    }
    public void loadHeaders(ArrayList<String> headers)
    {
        for (int i = 0; i < headers.size(); i++)
        {
            JButton button = new JButton(headers.get(i));
            button.setBackground(Color.lightGray);
            button.setForeground(Color.RED);
            
            headerButtons.add(button);
            add(button);
        }
        
    }
    
    public void loadPlayersTable(ArrayList<ArrayList<String>> list)
    {
        
        for (int row = 2,footballPlayerIndex = 0; row <= getLinesDisplayed() + 1; row++, footballPlayerIndex++)          //row starts at 2 because first row is for headers
        {
            for(int attributeIndex = 0; attributeIndex < list.get(0).size(); attributeIndex++)      //get(0) is chosen at random. It does not matter because the purpose
                                                                                                        // is to get access to the inner ArrayList<String> of any object in order to 
                                                                                                        // get the size of the String arraylist [name, postion, weight,.... etc]
            {
                JButton button = new JButton(list.get(footballPlayerIndex).get(attributeIndex));   
                getAttributeButtons().add(button);
                add (button);
               
            }
            
        }
        
        validate();
        repaint();
        
    }
    
    public void modifyPlayersTable(ArrayList<ArrayList<String>> list)
    {
        int attributeButtonsIndex = 0;
        
        
        for (int row = 2,footballPlayerIndex = 0; row <= getLinesDisplayed() + 1; row++, footballPlayerIndex++)          //row starts at 2 because first row is for headers
        {
          
            for(int attributeIndex = 0; attributeIndex < list.get(0).size(); attributeIndex++)      //get(0) is chosen at random. It does not matter because the purpose
                                                                                                        // is to get access to the inner ArrayList<String> of any object in order to 
                                                                                                        // get the size of the headers.
            {
                attributeButtons.get(attributeButtonsIndex).setText(list.get(footballPlayerIndex).get(attributeIndex));
                attributeButtonsIndex++;
                
               
               
            }
            
            
        }
        
        
        validate();
        repaint();
        
    }
    public void highlightPlayers(ArrayList<ArrayList<String>> stringList, ArrayList<FootballPlayer> playersList)
    {
        int attributeButtonsIndex = 0;
        
        
        for (int row = 2,footballPlayerIndex = 0; row <= getLinesDisplayed() + 1; row++, footballPlayerIndex++)          //row starts at 2 because first row is for headers
        {
          
            for(int attributeIndex = 0; attributeIndex < stringList.get(footballPlayerIndex).size(); attributeIndex++)      
            {
                attributeButtons.get(attributeButtonsIndex).setText(stringList.get(footballPlayerIndex).get(attributeIndex));
                if (playersList.get(footballPlayerIndex).isHightlight())
                {
                    attributeButtons.get(attributeButtonsIndex).setBackground(Color.PINK);
                    
                }
                else
                {
                    attributeButtons.get(attributeButtonsIndex).setBackground(new JButton().getBackground());
                }
                attributeButtonsIndex++;
                
            }
            
            
        }
        if (!NorthPanel.getSearchBox().getText().isEmpty() && FootballPlayerData.getNumberOfPlayersHightlighted() == 0)
        {
            NorthPanel.getSearchBox().setBackground(Color.RED);
            
        }
        else
        {
            NorthPanel.getSearchBox().setBackground(new JTextField().getBackground());
        }
        
        
        validate();
        repaint();
        
        
        
        
    }
    
    
    
    
    
    /**
     * @return the attributeButtons
     */
    public ArrayList<JButton> getAttributeButtons() {
        return attributeButtons;
    }

    /**
     * @param attributeButtons the attributeButtons to set
     */
    public void setAttributeButtons(ArrayList<JButton> attributeButtons) {
        this.attributeButtons = attributeButtons;
    }
    
    /**
     * @return the headerButtons
     */
    public ArrayList<JButton> getHeaderButtons() {
        return headerButtons;
    }

    /**
     * @param headerButtons the headerButtons to set
     */
    public void setHeaderButtons(ArrayList<JButton> headerButtons) {
        this.headerButtons = headerButtons;
    }
   
     /**
     * @return the myLayout
     */
    public GridLayout getMyLayout() {
        return myLayout;
    }

    /**
     * @param myLayout the myLayout to set
     */
    public void setMyLayout(GridLayout myLayout) {
        this.myLayout = myLayout;
    }
     /**
     * @return the currentHeaderButtonHighlighted
     */
    public int getCurrentHeaderButtonHighlighted() {
        return currentHeaderButtonHighlighted;
    }

    /**
     * @param currentHeaderButtonHighlighted the currentHeaderButtonHighlighted to set
     */
    public void setCurrentHeaderButtonHighlighted(int currentHeaderButtonHighlighted) {
        this.currentHeaderButtonHighlighted = currentHeaderButtonHighlighted;
    }
    /**
     * @return the linesDisplayed
     */
    public int getLinesDisplayed() {
        return linesDisplayed;
    }

    /**
     * @param linesDisplayed the linesDisplayed to set
     */
    public void setLinesDisplayed(int linesDisplayed) {
        this.linesDisplayed = linesDisplayed;
    }
}
