// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WindSpeed.java

package avscience.wba;


// Referenced classes of package avscience.wba:
//            DataTable

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

    private static final WindSpeed instance = new WindSpeed();
    private String codes[];
    private String descriptions[];
    private int size;

}
