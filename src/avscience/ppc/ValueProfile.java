package avscience.ppc;

import java.util.Hashtable;


public interface ValueProfile 
{
    public String[] getPoints();
    public boolean addPoint(int i, String s);
    public void removePoint(String s);
    public boolean hasPoints();
    public Hashtable getProfile();
}
