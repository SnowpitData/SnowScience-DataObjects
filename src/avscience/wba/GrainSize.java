// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GrainSize.java

package avscience.wba;


// Referenced classes of package avscience.wba:
//            DataTable

public final class GrainSize
    implements DataTable
{

    public static GrainSize getInstance()
    {
        return instance;
    }

    private GrainSize()
    {
        size = 24;
        units = new String[2];
        init();
    }

    private void init()
    {
        codes = new String[size];
        codes[0] = " ";
        codes[1] = "0.1";
        codes[2] = "0.3";
        codes[3] = "0.5";
        codes[4] = "1.0";
        codes[5] = "1.5";
        codes[6] = "2.0";
        codes[7] = "2.5";
        codes[8] = "3.0";
        codes[9] = "3.5";
        codes[10] = "4.0";
        codes[11] = "4.5";
        codes[12] = "5.0";
        codes[13] = "6.0";
        codes[14] = "7.0";
        codes[15] = "8.0";
        codes[16] = "9.0";
        codes[17] = "10";
        codes[18] = "15";
        codes[19] = "20";
        codes[20] = "30";
        codes[21] = "40";
        codes[22] = "50";
        codes[23] = "50+";
        units[0] = "mm";
        units[1] = "cm";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getUnits()
    {
        return units;
    }

    public String[] getDescriptions()
    {
        return null;
    }

    private static final GrainSize instance = new GrainSize();
    private String codes[];
    private int size;
    private String units[];

}
