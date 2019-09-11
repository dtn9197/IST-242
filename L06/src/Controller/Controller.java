
package Controller;
import Model.FootballPlayer;
import Model.Model;
import View.NorthPanel;
import View.View;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


       

public class Controller
{
    Model model;
    View view;
    
    public Controller(Model model,View view)
    {
        this.model = model;
        this.view = view; 
      System.out.println(model.getFpDataTable().getPlayers().get(0).getPlayerInfo());
        
        
        
    }
    public void addSearchListener()
    {
        view.getMyFrame().getNorthPanel().getSearchBox().getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent de) 
            {
                String pattern = view.getMyFrame().getNorthPanel().getSearchBox().getText();
                model.search(pattern, view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted());
                
                ArrayList<ArrayList<String>> stringList = model.getFpDataTable().getLines(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());
                ArrayList<FootballPlayer> playersList = model.getFpDataTable().getPlayersList(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());
                view.hightlightPlayers(stringList, playersList);
                
            }

            @Override
            public void removeUpdate(DocumentEvent de) 
            {
                String pattern = view.getMyFrame().getNorthPanel().getSearchBox().getText();
                model.search(pattern,view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted());
                
                ArrayList<ArrayList<String>> stringList = model.getFpDataTable().getLines(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());
                ArrayList<FootballPlayer> playersList = model.getFpDataTable().getPlayersList(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());
                view.hightlightPlayers(stringList, playersList);
            }

            @Override
            public void changedUpdate(DocumentEvent de) 
            {
                
            }
        }
        );
                {
                    
                }
        
        
        
    }
    
    public void DisplayDataTable()
    {
        view.CenterInitialSetup(model.getFpDataTable().getLinesBeingDisplayed(), model.getFpDataTable().getHeaders().size());
        view.CenterUpdate(model.getFpDataTable().getLines(model.getFpDataTable().getFirstLineToDisplay(), 
              model.getFpDataTable().getLastLineToDisplay()), model.getFpDataTable().getHeaders());
         
    }
    public void setParameters(int firstLine, int lastLine)  //this method defines the size of the table based on user inputs
    {
        model.getFpDataTable().setFirstLineToDisplay(firstLine);    //these parameters are the input variables, chosen by users.
        model.getFpDataTable().setLastLineToDisplay(lastLine);    //the range should not be too large or else buttons will be very small.
        
        model.getFpDataTable().setLineToHighlight(5);
        
        int lastLineDisplayed = model.getFpDataTable().getLastLineToDisplay();
        int firstLineDisplayed = model.getFpDataTable().getFirstLineToDisplay();
        model.getFpDataTable().setLinesBeingDisplayed((lastLineDisplayed - firstLineDisplayed) + 1);  
        
    }
    public void addScrolling()
    {
        view.getMyFrame().getInitialPanel().getCenterPanel().addMouseWheelListener
        (
            new MouseWheelListener()
            {
                    
                public void mouseWheelMoved(MouseWheelEvent e)      //this listener updates the table by incrementing
                {                                                   //firstLineBeingDisplayed and lastLineBeingDisplayed when scrolled
                     int units = e.getUnitsToScroll();
                  
                     if (units > 0)  // scrolls down, firstLine and lastLine both increase by 1
                    {
                         
                        if (model.getFpDataTable().getLastLineToDisplay() < 121)
                        {
                            model.getFpDataTable().setFirstLineToDisplay(model.getFpDataTable().getFirstLineToDisplay() + 1);
                            model.getFpDataTable().setLastLineToDisplay(model.getFpDataTable().getLastLineToDisplay() + 1);
                        }
                        
       

                    }
                     else if (units < 0)  // scrolls up, firstLine and lastLine both decrease by 1
                     { 
                            if (model.getFpDataTable().getFirstLineToDisplay() > 0)
                            {
                                model.getFpDataTable().setFirstLineToDisplay(model.getFpDataTable().getFirstLineToDisplay() - 1);
                                model.getFpDataTable().setLastLineToDisplay(model.getFpDataTable().getLastLineToDisplay() - 1);
                            }
                         
                     }
                     
                    ArrayList<ArrayList<String>> stringList = model.getFpDataTable().getLines(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());
                    ArrayList<FootballPlayer> playersList = model.getFpDataTable().getPlayersList(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());
//                  view.scrollingTable(stringList); //updates the table using the new firstLine and lastLine
                  view.hightlightPlayers(stringList, playersList);
                }
                
            }
                  
                
        );
   
    }
    
    public void addHeadersListener()  //adds listener to header buttons
    {
       
        ArrayList<JButton> headerButtons = view.getMyFrame().getInitialPanel().getCenterPanel().getHeaderButtons();
        int headersSize = model.getFpDataTable().getHeaders().size();
        
        
        for(int i = 0; i < headersSize; i++)
        {
            int index = i;
            headerButtons.get(i).addActionListener
        (
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if (headerButtons.get(index).getBackground() == Color.DARK_GRAY)
                        {
                            
                            headerButtons.get(view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted()).setBackground(Color.lightGray);  //reset curent highlighted button to default color
                            view.getMyFrame().getInitialPanel().getCenterPanel().setCurrentHeaderButtonHighlighted(8); //resets to default state which is 8
                            Collections.shuffle(model.getFpDataTable().getPlayers()); //sort
                            
                            ArrayList<ArrayList<String>> stringList = model.getFpDataTable().getLines(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());
                            ArrayList<FootballPlayer> playersList = model.getFpDataTable().getPlayersList(model.getFpDataTable().getFirstLineToDisplay(), model.getFpDataTable().getLastLineToDisplay());  //update table
                            view.hightlightPlayers(stringList, playersList); //updates table
                            System.out.println("Current highlighted header index(in controller: " + view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted());
                        }
                        else
                        {
                            model.getFpDataTable().setFirstLineToDisplay(0);
                            model.getFpDataTable().setLastLineToDisplay(view.getMyFrame().getInitialPanel().getCenterPanel().getLinesDisplayed() - 1);
                            view.hightlightPlayers(model.getFpDataTable().getLines(0, view.getMyFrame().getInitialPanel().getCenterPanel().getLinesDisplayed() - 1), model.getFpDataTable().getPlayersList(0, view.getMyFrame().getInitialPanel().getCenterPanel().getLinesDisplayed() - 1));
                            
                            if (view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted() < 8)
                            {
                                headerButtons.get(view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted()).setBackground(Color.lightGray);
                            } //sets currentHighlight button to default
                            
                        headerButtons.get(index).setBackground(Color.DARK_GRAY);        //add highlighted color to the new clicked button
                        view.getMyFrame().getInitialPanel().getCenterPanel().setCurrentHeaderButtonHighlighted(index);  //keeps track of the highlighted headerButton
                        
                        model.sortFootballPlayerTable(view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted());  //this method sorts FootballPlayerData based on the column clicked
                        model.search(NorthPanel.getSearchBox().getText(), view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted());
                            ArrayList<ArrayList<String>> stringList = model.getFpDataTable().getLines(0, view.getMyFrame().getInitialPanel().getCenterPanel().getLinesDisplayed() - 1);
                            ArrayList<FootballPlayer> playersList = model.getFpDataTable().getPlayersList(0, view.getMyFrame().getInitialPanel().getCenterPanel().getLinesDisplayed() - 1);
                            view.hightlightPlayers(stringList, playersList); 
                        System.out.println("Current hightlighted header index(in controller): " + view.getMyFrame().getInitialPanel().getCenterPanel().getCurrentHeaderButtonHighlighted());

                        }
                            

                    }
                }
                
        );
         
        }
        
    }
    
    
        
    
    
    
    
    
    
}
