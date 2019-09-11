
package View;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
public class InitialPanel extends JPanel
{
     private CenterPanel centerPanel;
    
    public InitialPanel()
    {
        BorderLayout myBorder = new BorderLayout();
     
        setLayout(myBorder);
        
        centerPanel = new CenterPanel();
        add(centerPanel,"Center");
        
       
        
    }
    
    
    
    /**
     * @return the centerPanel
     */
    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    /**
     * @param centerPanel the centerPanel to set
     */
    public void setCenterPanel(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }
}
