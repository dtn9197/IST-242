package Model;

import java.util.ArrayList;

public interface TableData
{

    public void loadTable();

   // public ArrayList getTable();// not required in A03B assignment

    public ArrayList<String> getHeaders();

    public ArrayList<String> getLine(int line);    

    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine);

}
