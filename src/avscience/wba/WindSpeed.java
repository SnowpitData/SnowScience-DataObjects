package avscience.wba;

public final class WindSpeed
    implements DataTable
{

    public static WindSpeed getInstance()
    {
        return instance;
    }

    private WindSpeed()
    {
        size = 6;
        init();
    }

    private void init()
    {
        codes = new String[size];
        descriptions = new String[size];
        codes[0] = " ";
        descriptions[0] = " ";
        codes[1] = "C";
        descriptions[1] = "Calm";
        codes[2] = "L";
        descriptions[2] = "Light Breeze";
        codes[3] = "M";
        descriptions[3] = "Moderate";
        codes[4] = "S";
        descriptions[4] = "Strong";
        codes[5] = "X";
        descriptions[5] = "gale force winds";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getDescriptions()
    {
        return descriptions;
    }
    
    public String getDescription(String code)
    {
        code = code.trim();
        for (int i=0; i<codes.length; i++)
        {
            if (codes[i].equals(code)) return descriptions[i];
        }
        return "";
    }
    
    public String getCode(int i)
    {
        return codes[i];
    }

    private static final WindSpeed instance = new WindSpeed();
    private String codes[];
    private String descriptions[];
    private int size;

}
