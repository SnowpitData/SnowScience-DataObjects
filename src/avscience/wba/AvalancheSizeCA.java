
package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class AvalancheSizeCA extends Hashtable
    implements DataTable
{

    public static AvalancheSizeCA getInstance()
    {
        return instance;
    }

    private AvalancheSizeCA()
    {
        indices = new Hashtable();
        init();
    }

    private void init()
    {
        put("D1", "Relatively harmless to people        < 10 ton     , 10m path, 1 kPA impact presssure.");
        put("D2", "Could bury, injure, or kill a person  , 100 ton, 100m path, 10kPa impact pressure.");
        put("D3", "Could bury car, destroy building    , or break trees, 1000 ton, 1000m path, 100kPa impact pressure.");
        put("D4", "Could destroy a railway car, truck , several buildings, or a forest to 4 hectares, 10,000 ton, 2000m path, 500kPa impact pressure.");
        put("D5", "Largest snow avalanches known     , could destroy a village, or a forest to 40 hectares, 100,000 ton, 3000m path, 1,000kPa impact pressure.");
        buildDesc();
    }

    public String[] getCodes()
    {
        codes = new String[10];
        codes[0] = "D0.5";
        codes[1] = "D1";
        codes[2] = "D1.5";
        codes[3] = "D2";
        codes[4] = "D2.5";
        codes[5] = "D3";
        codes[6] = "D3.5";
        codes[7] = "D4";
        codes[8] = "D4.5";
        codes[9] = "D5";
        return codes;
    }

    public int getIndex(String s)
    {
        Integer integer = (Integer)indices.get(s);
        int i = -1;
        if(integer != null)
            i = integer.intValue();
        return i;
    }

    public String[] getDescriptions()
    {
        return descs;
    }

    void buildDesc()
    {
        Enumeration enumeration = elements();
        descs = new String[size()];
        for(int i = 0; enumeration.hasMoreElements(); i++)
            descs[i] = (String)enumeration.nextElement();

    }

    public String getDescription(String s)
    {
        return (String)get(s);
    }

    private static final AvalancheSizeCA instance = new AvalancheSizeCA();
    private String codes[];
    private String descs[];
    private Hashtable indices;

}
