
package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class AvalancheType extends Hashtable
    implements DataTable
{
    private static final AvalancheType instance = new AvalancheType();

    public static AvalancheType getInstance()
    {
        return instance;
    }

    private AvalancheType()
    {
        init();
    }

    private void init()
    {
        put("L", "Loose.");
        put("SS", "Soft slab.");
        put("HS", "Hard slab.");
        put("WL", "Wet loose.");
        put("WS", "Wet slab.");
    }

    public String[] getDescriptions()
    {
        Enumeration enumeration = elements();
        String as[] = new String[size()];
        for(int i = 0; enumeration.hasMoreElements(); i++)
            as[i] = (String)enumeration.nextElement();

        return as;
    }

    public String[] getCodes()
    {
        String as[] = new String[5];
        as[0] = "L";
        as[1] = "SS";
        as[2] = "HS";
        as[3] = "WL";
        as[4] = "WS";
        return as;
    }

    public String getDescription(String s)
    {
        return (String)get(s);
    }
}
