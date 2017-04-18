// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Hardness.java

package avscience.wba;


// Referenced classes of package avscience.wba:
//            DataTable

public final class Hardness
    implements DataTable
{

    public static Hardness getInstance()
    {
        return instance;
    }

    private Hardness()
    {
        size = 7;
        init();
    }

    private void init()
    {
        codes = new String[size];
        descriptions = new String[size - 1];
        codes[0] = " ";
        codes[1] = "F";
        codes[2] = "4F";
        codes[3] = "1F";
        codes[4] = "P";
        codes[5] = "K";
        codes[6] = "I";
        descriptions[0] = "fist";
        descriptions[1] = "4 fingers";
        descriptions[2] = "1 finger";
        descriptions[3] = "pencil";
        descriptions[4] = "knife";
        descriptions[5] = "ice";
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getDescriptions()
    {
        return descriptions;
    }

    private static final Hardness instance = new Hardness();
    private String codes[];
    private String descriptions[];
    private int size;

}
