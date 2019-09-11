
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;



public class WestPanel extends JPanel
{
    private JRadioButton quickButton;
    private JRadioButton mergeButton;
    private JRadioButton selectionButton;
    private JLabel message;
    
    
    public WestPanel()
    {
        
        this.setLayout(new GridLayout(4,1));
        this.setPreferredSize(new Dimension(300,100));
        message = new JLabel("Select sort type here");
        message.setOpaque(true);
        message.setBackground(Color.GRAY);
       
        add(message);
        quickButton = new JRadioButton("Quick/Arrays[]");
        quickButton.setOpaque(true);
        quickButton.setBackground(Color.lightGray);
        mergeButton = new JRadioButton("Merge/ArrayList[]");
        mergeButton.setOpaque(true);
        mergeButton.setBackground(Color.lightGray);
        selectionButton = new JRadioButton("Selection/Write yourself");
        selectionButton.setOpaque(true);
        selectionButton.setBackground(Color.LIGHT_GRAY);
        ButtonGroup group = new ButtonGroup();
        group.add(selectionButton);
        group.add(mergeButton);
        group.add(selectionButton);
        
        add(selectionButton);
        add(mergeButton);
        add(quickButton);
    }
    
}
