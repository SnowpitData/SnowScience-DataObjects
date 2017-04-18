package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class ExtendedColumnTest extends AbstractShearTest
{
    public static ExtendedColumnTest getInstance()
    {
        return instance;
    }

    private ExtendedColumnTest()
    {
        type = "Extended Column Test";
        description = "Extended Column Test";
        code = "EC";
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
        put("ECTPV", "");
        put("ECTP", "");
        put("ECTN", "");
        put("ECTX", "");
        scores = new String[size()];
        scores[0] = "ECTPV";
        scores[1] = "ECTP";
        scores[2] = "ECTN";
        scores[3] = "ECTX";
        stability.put("ECTPV", "");
        stability.put("ECTP", "");
        stability.put("ECTN", "");
        stability.put("ECTX", "");
    }

    public String[] getDescriptions()
    {
        String descriptions[] = new String[size()];
        Enumeration Descs = elements();
        for(int i = 0; Descs.hasMoreElements(); i++)
        {
            String s = (String)Descs.nextElement();
            descriptions[i] = s;
        }

        return descriptions;
    }

    public String[] getScores()
    {
        return scores;
    }

    public String getDescription(String score)
    {
        score = score.trim();
        return (String)get(score);
    }

    public String getStability(String score)
    {
        score = score.trim();
        return (String)stability.get(score);
    }

    private static final ExtendedColumnTest instance = new ExtendedColumnTest();
    private String type;
    private String description;
    private String code;
    private Hashtable stability;
    private String scores[];

}
