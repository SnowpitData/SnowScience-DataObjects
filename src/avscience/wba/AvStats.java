// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AvStats.java

package avscience.wba;


// Referenced classes of package avscience.wba:
//            DataTable

public final class AvStats
    implements DataTable
{

    public static AvStats getInstance()
    {
        return instance;
    }

    private AvStats()
    {
    }

    public String[] getCodes()
    {
        String as[] = new String[27];
        as[0] = " ";
        as[1] = "1";
        as[2] = "2";
        as[3] = "3";
        as[4] = "4";
        as[5] = "5";
        as[6] = "6";
        as[7] = "7";
        as[8] = "8";
        as[9] = "9";
        as[10] = "10";
        as[11] = "11";
        as[12] = "12 - 15";
        as[13] = "16 - 20";
        as[14] = "21 - 25";
        as[15] = "26 - 30";
        as[16] = "31 - 35";
        as[17] = "36 - 40";
        as[18] = "41 - 50";
        as[19] = "51 - 75";
        as[20] = "76 - 100";
        as[21] = "100 - 150";
        as[22] = "151 - 200";
        as[23] = "201 -  300";
        as[24] = "301 -  500";
        as[25] = "501 -  1000";
        as[26] = "1000+";
        return as;
    }

    public String[] getSmallCodes()
    {
        String as[] = new String[11];
        as[0] = " ";
        as[1] = "1";
        as[2] = "2";
        as[3] = "3";
        as[4] = "4";
        as[5] = "5";
        as[6] = "6";
        as[7] = "7";
        as[8] = "8";
        as[9] = "9";
        as[10] = "10";
        return as;
    }

    public String[] getDescriptions()
    {
        return null;
    }

    private static final AvStats instance = new AvStats();

}
