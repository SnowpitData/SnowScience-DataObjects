package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;


public final class RutschblockTest extends AbstractShearTest
{

    public static RutschblockTest getInstance()
    {
        return instance;
    }

    private RutschblockTest()
    {
        type = "Rutschblock Test";
        description = "Rutschblock test,  2.0m x 1.5m, greater than 30 deg incline.";
        code = "RB";
        stability = new Hashtable();
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
        put("RB1", "fails during cutting or approach");
        put("RB2", "fails under body weight.");
        put("RB3", "fails with knee flex.");
        put("RB4", "fails on first jump.");
        put("RB5", "fails on second jump.");
        put("RB6", "fails on three jumps.");
        put("RB7", "no failure.");
        scores = new String[size()];
        scores[0] = "RB1";
        scores[1] = "RB2";
        scores[2] = "RB3";
        scores[3] = "RB4";
        scores[4] = "RB5";
        scores[5] = "RB6";
        scores[6] = "RB7";
        stability.put("RB1", "poor");
        stability.put("RB2", "poor");
        stability.put("RB3", "poor");
        stability.put("RB4", "fair");
        stability.put("RB5", "fair");
        stability.put("RB6", "good");
        stability.put("RB7", "good");
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

    private static final RutschblockTest instance = new RutschblockTest();
    private String type;
    private String description;
    private String code;
    private Hashtable stability;
    private String scores[];

}
