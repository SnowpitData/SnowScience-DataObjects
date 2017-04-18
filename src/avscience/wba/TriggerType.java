package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class TriggerType extends Hashtable implements DataTable
{
    private static final TriggerType instance = new TriggerType();
    private String codes[];
    private Hashtable indices;
    private Hashtable ntriggers;
    private Hashtable atriggers;
    private Hashtable htriggers;

    public static TriggerType getInstance()
    {
        return instance;
    }

    private TriggerType()
    {
        indices = new Hashtable();
        ntriggers = new Hashtable();
        atriggers = new Hashtable();
        htriggers = new Hashtable();
        init();
    }

    private void init()
    {
        put(" ", " ");
        put("N", "Natural");
        put("A", "Artificial - Explosives");
        put("H", "Artificial - Human");
        put("U", "Unknown");
        codes = buildCodes();
        buildTriggers();
    }

    private void buildTriggers()
    {
        ntriggers.put("N", "Natural, results of weather etc.");
        ntriggers.put("NC", "Cornice fall, natural.");
        ntriggers.put("NE", "Earthquakes.");
        ntriggers.put("NI", "Ice Fall.");
        ntriggers.put("NR", "Rock Fall.");
        ntriggers.put("NL", "Triggered by loose snow avalanche");
        ntriggers.put("NS", "Triggered by slab avalanche");
        atriggers.put("AA", "Artillery");
        atriggers.put("AE", "Hand charge");
        atriggers.put("AL", "Avalauncher");
        atriggers.put("AB", "Air blast");
        atriggers.put("AC", "Cornice");
        atriggers.put("AX", "Gas exploder");
        atriggers.put("AH", "Helicopter-delivered");
        atriggers.put("AP", "Pre-placed");
        htriggers.put("AS", "Skier");
        htriggers.put("AR", "Snowboarder");
        htriggers.put("AI", "Snowshoer");
        htriggers.put("AF", "Foot");
        htriggers.put("AC", "Cornice fall");
        htriggers.put("AM", "Snowmobile");
        htriggers.put("AK", "Snowcat");
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getCodes(String s)
    {
        s = s.trim();
        Hashtable hashtable = new Hashtable();
        if(s.equals("Natural"))
            hashtable = ntriggers;
        if(s.equals("Artificial - Human"))
            hashtable = htriggers;
        if(s.equals("Artificial - Explosives"))
            hashtable = atriggers;
        String as[] = new String[hashtable.size()];
        int i = 0;
        for(Enumeration enumeration = hashtable.elements(); enumeration.hasMoreElements();)
        {
            String s1 = (String)enumeration.nextElement();
            as[i] = s1;
            i++;
        }

        return as;
    }

    private String[] buildCodes()
    {
        Enumeration enumeration = keys();
        String as[] = new String[size()];
        for(int i = 0; enumeration.hasMoreElements(); i++)
        {
            String s = (String)enumeration.nextElement();
            indices.put(s, new Integer(i));
            as[i] = s;
        }

        return as;
    }

    public String[] getDescriptions()
    {
        String as[] = new String[5];
        as[0] = " ";
        as[1] = "Natural";
        as[2] = "Artificial - Explosives";
        as[3] = "Artificial - Human";
        as[4] = "Unknown";
        return as;
    }

    public String[] getDescriptions(String s)
    {
        if(s == null)
            s = "Natural";
        s = s.trim();
        Hashtable hashtable = new Hashtable();
        if(s.equals("Natural"))
            hashtable = ntriggers;
        if(s.equals("Artificial - Explosives"))
            hashtable = atriggers;
        if(s.equals("Artificial - Human"))
            hashtable = htriggers;
        String as[] = new String[1];
        as[0] = "";
        if(hashtable.size() > 0)
        {
            as = new String[hashtable.size()];
            int i = 0;
            for(Enumeration enumeration = hashtable.elements(); enumeration.hasMoreElements();)
            {
                String s1 = (String)enumeration.nextElement();
                as[i] = s1;
                i++;
            }

        }
        return as;
    }

    public String getDescription(String s)
    {
        return (String)get(s);
    }

    public String getDescription(String s, String s1)
    {
        s = s.trim();
        Hashtable hashtable = new Hashtable();
        if(s.equals("Natural"))
            hashtable = ntriggers;
        if(s.equals("Artificial - Human"))
            hashtable = htriggers;
        if(s.equals("Artificial - Explosives"))
            hashtable = atriggers;
        return (String)hashtable.get(s1);
    }
}
