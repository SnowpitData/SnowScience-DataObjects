package avscience.wba;

public final class BedSurface
    implements DataTable
{

    public static BedSurface getInstance()
    {
        return instance;
    }

    private BedSurface()
    {
        size = 5;
        init();
    }

    private void init()
    {
        descriptions = new String[size];
        codes = new String[size];
        codes[0] = "S";
        codes[1] = "I";
        codes[2] = "O";
        codes[3] = "G";
        codes[4] = "U";
        descriptions[0] = "Within recent storm snow.";
        descriptions[1] = "New/old snow interface";
        descriptions[2] = "Within old snow.";
        descriptions[3] = "released at ground.";
        descriptions[4] = "Unknown";
    }

    public String[] getDescriptions()
    {
        return descriptions;
    }

    public String[] getCodes()
    {
        return codes;
    }

    private static final BedSurface instance = new BedSurface();
    private String descriptions[];
    private int size;
    private String codes[];

}
