package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class CompressionTest extends AbstractShearTest
{

    public static CompressionTest getInstance()
    {
        return instance;
    }

    private CompressionTest()
    {
        type = "Compression Test";
        description = "Compression shear test on 30cm x 30cm block, greater than 30 deg. incline";
        code = "CT";
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
        put("CTV", "Fails during cutting, very easy.");
        put("CTE", "Fails within ten taps of wrist, easy.");
        put("CTM", "Fails within ten moderate taps from elbow, moderate.");
        put("CTH", "Fails within ten firm taps from the shoulder. moderate");
        put("CTN", "No shear failure, no shear.");
        scores = new String[size()];
        scores[0] = "CTV";
        scores[1] = "CTE";
        scores[2] = "CTM";
        scores[3] = "CTH";
        scores[4] = "CTN";
        stability.put("CTV", "poor");
        stability.put("CTE", "poor");
        stability.put("CTM", "fair");
        stability.put("CTH", "good");
        stability.put("CTN", "good");
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

    private static final CompressionTest instance = new CompressionTest();
    private String type;
    private String description;
    private String code;
    private Hashtable stability;
    private String scores[];

}
