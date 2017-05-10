package avscience.wba;

import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Vector;

import avscience.ppc.AvScienceDataObject;
import avscience.ppc.ValueProfile;

public class DensityProfile extends avscience.ppc.AvScienceDataObject implements ValueProfile
{
    public DensityProfile()
    {
    }

    public DensityProfile(String s) throws Exception
    {
        super(s);
    }

    public void writeAttributes()
    {
        if (densityUnits == null) densityUnits="";
        if (depthUnits == null) depthUnits="";
        try
        {
            put("densityUnits", densityUnits);
            put("depthUnits", depthUnits);
            String profile_data = this.getProfileFromTable(profile);
            if ( profile_data == null ) profile_data="";
            put("profile_data", profile_data);
        }
        catch(Exception e)
        {
            System.out.println("RhoProfile:writeAtts: "+e.toString());
        }
       
    }

    public void popAttributes()
    {   
        if (depths==null) depths = new Hashtable();
        if (profile==null) profile = new Hashtable();
        try
        {
            densityUnits = getString("densityUnits");
            depthUnits = getString("depthUnits");
            this.writeProfileToTable(this, getString("profile_data"));
        }
        catch(Exception e)
        {
            System.out.println("RhoProfile:popAtts: "+e.toString());
        }
       
    }

    public String[] getPoints()
    {
        String as[] = new String[profile.size()];
        Enumeration enumeration = getDepths().elements();
        for(int i = 0; enumeration.hasMoreElements(); i++)
        {
            Integer integer = (Integer)enumeration.nextElement();
            String s = "Depth " + integer.toString() + " Density " + (String)profile.get(integer) + " " + densityUnits;
            as[i] = s;
        }

        return as;
    }

    public DensityProfile(String s, String s1)
    {
        depths = new Hashtable();
        profile = new Hashtable();
        densityUnits = s;
        depthUnits = s1;
    }

    public boolean addPoint(int i, String s)
    {
        Integer integer = new Integer(i);
        depths.put(integer.toString(), integer);
        Object obj = profile.put(integer, s);
        return obj == null;
    }

    public String getDensity(Integer integer)
    {
        String s = (String)profile.get(integer);
        return s;
    }

    public Vector getDensities()
    {
        Vector vector = new Vector();
        Enumeration enumeration = profile.elements();
        do
        {
            if(!enumeration.hasMoreElements())
                break;
            String s = (String)enumeration.nextElement();
            if(s != null)
                vector.addElement(s);
        } while(true);
        return vector;
    }

    public Vector getDepths()
    {
        Vector vector = new Vector();
        if (profile==null) profile = new Hashtable();
        Enumeration enumeration = profile.keys();
        if(enumeration != null)
        {
            Integer integer;
            for(; enumeration.hasMoreElements(); vector.addElement(integer))
                integer = (Integer)enumeration.nextElement();

        }
        return vector;
    }

    public void removePoint(String s)
    {
        Integer integer = (Integer)depths.get(s);
        profile.remove(integer);
    }

    public boolean hasPoints()
    {
        return profile.size() > 0;
    }

    public String getDensityUnits()
    {
        return densityUnits;
    }

    public String getDepthUnits()
    {
        return depthUnits;
    }
    
    public Hashtable getProfile()
    {
        return profile;
    }

    
    private String densityUnits = "";
    private String depthUnits = "";
    private Hashtable depths;// = new Hashtable();
    private Hashtable profile;// = new Hashtable();
}
