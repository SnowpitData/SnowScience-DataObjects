package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class StuffblockTest extends AbstractShearTest
{

    public static StuffblockTest getInstance()
    {
        return instance;
    }

    private StuffblockTest()
    {
        type = "Stuffblock Test";
        description = "Stuffblock test, 10lb (4.5 kg) stuff bag on 30cm x 30cm, section greater than 30 deg incline.";
        code = "SB";
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
        put("SBV", "");
        put("SB0", "fails on drop from 0 cm.");
        put("SB10", "fails on drop from 10 cm.");
        put("SB20", "fails on drop from 20 cm.");
        put("SB30", "fails on drop from 30 cm.");
        put("SB40", "fails on drop from 40 cm.");
        put("SB50", "fails on drop from 50 cm.");
        put("SB60", "fails on drop from 60 cm.");
        put("SB70", "fails on drop from 70 cm.");
        put("SB80", "fails on drop from 80 cm.");
        put("SBN", "No failure");
        scores = new String[size()];
        scores[0] = "SBV";
        scores[1] = "SB0";
        scores[2] = "SB10";
        scores[3] = "SB20";
        scores[4] = "SB30";
        scores[5] = "SB40";
        scores[6] = "SB50";
        scores[7] = "SB60";
        scores[8] = "SB70";
        scores[9] = "SB80";
        scores[10] = "SBN";
        stability.put("SBV", "");
        stability.put("SB0", "poor");
        stability.put("SB10", "poor");
        stability.put("SB20", "poor");
        stability.put("SB30", "fair");
        stability.put("SB40", "fair");
        stability.put("SB50", "fair");
        stability.put("SB60", "good");
        stability.put("SB70", "good");
        stability.put("SB80", "good");
        stability.put("SBN", "good");
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

    private static final StuffblockTest instance = new StuffblockTest();
    private String type;
    private String description;
    private String code;
    private Hashtable stability;
    private String scores[];

}
