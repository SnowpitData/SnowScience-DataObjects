package avscience.wba;

public final class WindDir implements DataTable
{

    public static WindDir getInstance()
    {
        return instance;
    }

    private WindDir()
    {
        codes = new String[9];
        descs = new String[9];
        init();
    }

    private void init()
    {
        codes[0] = " ";
        codes[1] = "N";
        codes[2] = "NE";
        codes[3] = "E";
        codes[4] = "SE";
        codes[5] = "S";
        codes[6] = "SW";
        codes[7] = "W";
        codes[8] = "NW";
    }

    public String[] getCodes()
    {
        return codes;
    }
    
    public String getCode(int i)
    {
        return codes[i];
    }

    public String[] getDescriptions()
    {
        return null;
    }

    private static final WindDir instance = new WindDir();
    private final int size = 9;
    private String codes[];
    private String descs[];

}
