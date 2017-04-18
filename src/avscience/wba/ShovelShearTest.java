package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class ShovelShearTest extends AbstractShearTest
{

    public static ShovelShearTest getInstance()
    {
        return instance;
    }

    private ShovelShearTest()
    {
        type = "Shovel Shear Test";
        description = "Shovel shear test on 30cm x 30cm block.";
        code = "ST";
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
        put("STC", "Collapses during cutting. collapse.");
        put("STV", "Fails during shovel insertion. very easy");
        put("STE", "Fails with minimum pressure. easy");
        put("STM", "Fails with moderate pressure. moderate");
        put("STH", "Fails with firm sustained pressure. hard");
        put("STN", "No shear failure. no shear");
        scores = new String[size()];
        scores[0] = "STC";
        scores[1] = "STV";
        scores[2] = "STE";
        scores[3] = "STM";
        scores[4] = "STH";
        scores[5] = "STN";
        stability = new Hashtable();
        stability.put("STC", "poor");
        stability.put("STV", "poor");
        stability.put("STE", "fair");
        stability.put("STM", "fair");
        stability.put("STH", "good");
        stability.put("STN", "good");
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

    private static final ShovelShearTest instance = new ShovelShearTest();
    private String type;
    private String description;
    private String code;
    private Hashtable stability;
    private String scores[];

}
