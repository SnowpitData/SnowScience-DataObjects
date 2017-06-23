package avscience.wba;

public final class Stability
    implements DataTable
{

    public static Stability getInstance()
    {
        return instance;
    }

    private Stability()
    {
        init();
    }

    private void init()
    {
        codes = new String[6];
        codes[0] = " ";
        codes[1] = "Very Good";
        codes[2] = "Good";
        codes[3] = "Fair";
        codes[4] = "Poor";
        codes[5] = "Very Poor";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getDescriptions()
    {
        return null;
    }

    private static final Stability instance = new Stability();
    private String codes[];
    private final int size = 6;

}
