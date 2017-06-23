package avscience.wba;

public final class WaterContent
    implements DataTable
{

    public static WaterContent getInstance()
    {
        return instance;
    }

    private WaterContent()
    {
        size = 6;
        init();
    }

    private void init()
    {
        codes = new String[size];
        codes[0] = " ";
        codes[1] = "Dry";
        codes[2] = "Moist";
        codes[3] = "Wet";
        codes[4] = "Very Wet";
        codes[5] = "Slush";
    }

    public String getCode(String desc)
    {
        desc.trim();
        if(desc.equals("Dry"))
            return "D";
        if(desc.equals("Moist"))
            return "M";
        if(desc.equals("Wet"))
            return "W";
        if(desc.equals("Very Wet"))
            return "VW";
        if(desc.equals("Slush"))
            return "S";
        else
            return "";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getDescriptions()
    {
        return null;
    }

    private static final WaterContent instance = new WaterContent();
    private String codes[];
    private int size;

}
