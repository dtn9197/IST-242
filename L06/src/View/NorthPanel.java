
package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


public class NorthPanel extends JPanel
{
    private static JTextField searchBox = new JTextField(16);
    public NorthPanel()
    {
        super();
        setBackground(Color.GREEN);
        searchBox.setFont(new Font("Dialog",Font.PLAIN,24));
        add(searchBox);
        
    }
    

    /**
     * @return the searchBox
     */
    public static JTextField getSearchBox() {
        return searchBox;
    }

    /**
     * @param aSearchBox the searchBox to set
     */
    public static void setSearchBox(JTextField aSearchBox) {
        searchBox = aSearchBox;
    }
    
    
}
