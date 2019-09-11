
package View;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;


public class InitialFrame extends JFrame
{
    private InitialPanel initialPanel;
    private WestPanel westPanel;
    private NorthPanel northPanel;
   
    
    public InitialFrame()
    {
        this.setSize(1200,800);
        this.setName("Players Data Table");
        this.setBackground(Color.green);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        initialPanel = new InitialPanel();
        add(initialPanel);
        
        
       
        
        northPanel = new NorthPanel();
        add(northPanel,"North");
        
        
        this.setVisible(true); 
    }
    
    /**
     * @return the initialPanel
     */
    public InitialPanel getInitialPanel() {
        return initialPanel;
    }

    /**
     * @param initialPanel the initialPanel to set
     */
    public void setInitialPanel(InitialPanel initialPanel) {
        this.initialPanel = initialPanel;
    }
    
    public NorthPanel getNorthPanel() {
        return northPanel;
    }

    
    public void setNorthPanel(NorthPanel northPanel) {
        this.northPanel = northPanel;
    }
}
