// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WaterContentSnow.java

package avscience.wba;


// Referenced classes of package avscience.wba:
//            DataTable

public final class WaterContentSnow
    implements DataTable
{

    public static WaterContentSnow getInstance()
    {
        return instance;
    }

    private WaterContentSnow()
    {
        size = 5;
        init();
    }

    private void init()
    {
        codes = new String[size];
        descriptions = new String[size];
        codes[0] = " ";
        codes[1] = "D";
        codes[2] = "M";
        codes[3] = "W";
        codes[4] = "U";
        descriptions[0] = " ";
        descriptions[1] = "Dry";
        descriptions[2] = "Moist";
        descriptions[3] = "Wet";
        descriptions[4] = "Unknown";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String getCode(String desc)
    {
        desc.trim();
        if(desc.equals("Dry"))
            return "D";
        if(desc.equals("Mosit"))
            return "M";
        if(desc.equals("Wet"))
            return "W";
        if(desc.equals("Unknown"))
            return "U";
        else
            return "";
    }

    public String[] getDescriptions()
    {
        return descriptions;
    }

    private static final WaterContentSnow instance = new WaterContentSnow();
    private String codes[];
    private String descriptions[];
    private int size;

}
