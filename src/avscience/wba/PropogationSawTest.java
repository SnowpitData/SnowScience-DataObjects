package avscience.wba;

public final class PropogationSawTest extends AbstractShearTest
{

    public static PropogationSawTest getInstance()
    {
        return instance;
    }

    private PropogationSawTest()
    {
        type = "Propogation Saw Test";
        description = "Propogation Saw Test";
        code = "PST";
    }

    public String getTypeDescription()
    {
        return description;
    }

    public String getDescription(String s)
    {
        return description;
    }

    public String getStability(String s)
    {
        return "";
    }

    public String[] getScores()
    {
        return scores;
    }

    public String getTypeCode()
    {
        return code;
    }

    public String getType()
    {
        return type;
    }

    public String[] getDescriptions()
    {
        return descs;
    }

    private static final PropogationSawTest instance = new PropogationSawTest();
    private String type;
    private String description;
    private String code;
    String scores[] = {
        "End", "SF", "Arr"
    };
    String descs[] = {
        "Popogation to end", "Slab fracture", "Self-arrest"
    };

}
