package avscience.wba;

public final class AvActivity
    implements DataTable
{
    private static final AvActivity instance = new AvActivity();
    private String codes[];
    private int size;
    
    public static AvActivity getInstance()
    {
        return instance;
    }

    private AvActivity()
    {
        size = 11;
        init();
    }

    private void init()
    {
        codes = new String[size];
        codes[0] = "Collapsing, widespread.";
        codes[1] = "Collapsing, localized.";
        codes[2] = "Cracking.";
        codes[3] = "Recent act on sim slopes.";
        codes[4] = "Recent act on diff slopes.";
        codes[5] = "Instability rapidly rising.";
        codes[6] = "We skied slope.";
        codes[7] = "Ski tracks on slope.";
        codes[8] = "Snowmobile tracks on slope.";
        codes[9] = "Poor pit location.";
        codes[10] = "Supportable crust.";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getDescriptions()
    {
        return null;
    }
}
