package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class DeepTapTest extends AbstractShearTest
{
    private static final DeepTapTest instance = new DeepTapTest();
    private String type;
    private String description;
    private String code;
    private Hashtable stability = new Hashtable(5);
    private String scores[];

    public static DeepTapTest getInstance()
    {
        return instance;
    }

    private DeepTapTest()
    {
        type = "Deep Tap Test";
        description = "Deep tap test on 30cm x 30cm block.";
        code = "DT";
        init();
    }

    public String getType()
    {
        return type;
    }

    public String getTypeDescription()
    {
        return description;
    }

    public String getTypeCode()
    {
        return code;
    }
    
    private void init()
    {
        put("DTV", "Fractures during cutting.");
        put("DTE", "Fractures within 10 light taps using finger tips only.");
        put("DTM", "Fractures within 10 moderate taps from the elbow using finger tips.");
        put("DTH", "Fractures within 10 firm taps from whole arm using palm or fist.");
        put("DTN", "Does not fracture.");
        scores = new String[size()];
        scores[0] = "DTV";
        scores[1] = "DTE";
        scores[2] = "DTM";
        scores[3] = "DTH";
        scores[4] = "DTN";
        stability.put("DTV", "poor");
        stability.put("DTE", "poor");
        stability.put("DTM", "fair");
        stability.put("DTH", "good");
        stability.put("DTN", "good");
    }

    public String[] getDescriptions()
    {
        String as[] = new String[size()];
        Enumeration enumeration = elements();
        for(int i = 0; enumeration.hasMoreElements(); i++)
        {
            String s = (String)enumeration.nextElement();
            as[i] = s;
        }

        return as;
    }

    public String[] getScores()
    {
        return scores;
    }

    public String getDescription(String s)
    {
        s = s.trim();
        return (String)get(s);
    }

    public String getStability(String s)
    {
        s = s.trim();
        return (String)stability.get(s);
    }
}
