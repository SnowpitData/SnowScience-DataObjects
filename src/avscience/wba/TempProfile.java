package avscience.wba;

import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Vector;
import avscience.ppc.ValueProfile;

public class TempProfile extends avscience.ppc.AvScienceDataObject implements ValueProfile
{
    public static void main(String[] args)
    {
        TempProfile tp = new TempProfile("C", "cm");
        tp.addPoint(1, "0.5");
        tp.addPoint(5, "1.5");
        tp.addPoint(10, "2.5");
        
        String data = tp.toString();
        System.out.println("TP: "+data);
        
        try
        {
            TempProfile tpp = new TempProfile(data);
            System.out.println("TPP Number of points: "+tpp.getPoints().length);
            data = tpp.toString();
            System.out.println("TPP: "+data);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
       
        
    }
    public TempProfile(){}

    public TempProfile(String data) throws Exception
    {
        super(data);
    }

    public Hashtable getProfile()
    {
        return profile;
    }
    
    public void writeAttributes()
    {
        System.out.println("TempProfile:writeAttributes()");
        if (tempUnits==null) tempUnits="";
        if (depthUnits==null) depthUnits="";
        try
        {
            put("tempUnits", tempUnits);
            put("depthUnits", depthUnits);
            String profile_data = this.getProfileFromTable(profile);
            if ( profile_data == null ) profile_data="";
            System.out.println("profile: "+profile_data);
            put("profile", profile_data);
        }
        catch(Exception e)
        {
            System.out.println("Temp profile:writeAtts: "+e.toString());
        }
       
    }

    public void popAttributes()
    {
        depths = new Hashtable();
        profile = new Hashtable();
        try
        {
            tempUnits = getString("tempUnits");
            depthUnits = getString("depthUnits");
            this.writeProfileToTable(this, getString("profile"));
        }
        catch(Exception e)
        {
            System.out.println("TempProfile:popAtts: "+e.toString());
        }
       
    }

    public String[] getPoints()
    {
        String points[] = new String[profile.size()];
        Enumeration depths = getDepths().elements();
        for(int i = 0; depths.hasMoreElements(); i++)
        {
            Integer D = (Integer)depths.nextElement();
            String s = (new StringBuilder()).append("Depth ").append(D.toString()).append(" Temp ").append(TempList.getInstance().getTempString(tempUnits, getTemp(D))).toString();
            points[i] = s;
        }

        return points;
    }

    public TempProfile(String tempUnits, String depthUnits)
    {
        depths = new Hashtable();
        profile = new Hashtable();
        this.tempUnits = tempUnits;
        this.depthUnits = depthUnits;
    }

    public boolean addPoint(int depth, String temp)
    {
        System.out.println("Temp profile:addPoint: depth: "+depth+" temp: "+temp);
        Integer I = new Integer(depth);
        System.out.println("I depth: "+I);
        if ( depths == null) System.out.println("Depth is NULL!");
        depths.put(I.toString(), I);
        if ( profile == null) System.out.println("Profile is NULL!");
        Object o = profile.put(I, temp);
        return o == null;
    }

    public int getTemp(Integer depth)
    {
        TempList tl = TempList.getInstance();
        String s = (String)profile.get(depth);
        int i = tl.getTemp(tempUnits, s);
        return i;
    }

    public Vector getTemps()
    {
        TempList tl = TempList.getInstance();
        Vector v = new Vector();
        Enumeration e = profile.elements();
        do
        {
            if(!e.hasMoreElements())
                break;
            Integer I = new Integer(tl.getTemp(tempUnits, (String)e.nextElement()));
            if(I != null)
                v.addElement(I);
        } while(true);
        return v;
    }

    public Vector getDepths()
    {
        Vector v = new Vector();
        Integer I;
        if (profile == null ) return v;
        for(Enumeration e = profile.keys(); e.hasMoreElements(); v.addElement(I))
            I = (Integer)e.nextElement();

        return v;
    }

    public void removePoint(String depth)
    {
        Integer I = (Integer)depths.get(depth);
        profile.remove(I);
    }

    public boolean hasPoints()
    {
        if ( profile == null ) return false;
        return profile.size() > 0;
    }

    public String getTempUnits()
    {
        return tempUnits;
    }

    public String getDepthUnits()
    {
        return depthUnits;
    }

    private String tempUnits;//="";
    private String depthUnits;//="";
    private Hashtable depths;// = new Hashtable();
    private Hashtable profile;// = new Hashtable();
}
