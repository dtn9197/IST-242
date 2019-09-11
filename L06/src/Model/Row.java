
package Model;

import java.util.ArrayList;


public class Row 
{
    private ArrayList<Integer> data;
    private boolean highligh = false;
    
    public Row() 
    {
        
    }
    
    
    
    
    public ArrayList<Integer> getData() {
        return data;
    }

    
    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }

    
    public boolean isHighligh() {
        return highligh;
    }

    
    public void setHighligh(boolean highligh) {
        this.highligh = highligh;
    }
    
}
