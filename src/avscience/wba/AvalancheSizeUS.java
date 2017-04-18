
package avscience.wba;

public final class AvalancheSizeUS
    implements DataTable
{

    public static AvalancheSizeUS getInstance()
    {
        return instance;
    }

    private AvalancheSizeUS()
    {
        size = 5;
        init();
    }

    private void init()
    {
        codes = new String[size];
        descriptions = new String[size];
        codes[0] = "R1";
        codes[1] = "R2";
        codes[2] = "R3";
        codes[3] = "R4";
        codes[4] = "R5";
        descriptions[0] = "Any slide less than 50m.";
        descriptions[1] = "Small relative to path.";
        descriptions[2] = "Medium relative to path.";
        descriptions[3] = "Large relative to path.";
        descriptions[4] = "Major relative to path.";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getDescriptions()
    {
        return descriptions;
    }

    private static final AvalancheSizeUS instance = new AvalancheSizeUS();
    private String codes[];
    private String descriptions[];
    private int size;

}
