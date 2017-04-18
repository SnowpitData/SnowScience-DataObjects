package avscience.wba;

import java.util.Enumeration;
import java.util.Hashtable;

public final class RBReleaseTypes
{
    private RBReleaseTypes()
    {
        descs = new Hashtable(codes.length - 1);
        names = new Hashtable(codes.length - 1);
        dnames = new Hashtable(codes.length);
        init();
    }

    void init()
    {
        descs.put(codes[1], "Whole block (WB) 90-100% of block");
        descs.put(codes[2], "Most of block (MB) 50-80% of block");
        descs.put(codes[3], "Edge of Block (EB) 10-40% of block");
        dnames.put(" ", codes[0]);
        dnames.put("Whole block (WB) 90-100% of block", codes[1]);
        dnames.put("Most of block (MB) 50-80% of block", codes[2]);
        dnames.put("Edge of Block (EB) 10-40% of block", codes[3]);
        names.put(codes[1], "Whole Block");
        names.put(codes[2], "Most of Block");
        names.put(codes[3], "Edge of Block");
    }

    public static RBReleaseTypes getInstance()
    {
        return instance;
    }

    public String[] getDisplayNames()
    {
        String nms[] = new String[codes.length];
        nms[0] = " ";
        for(int i = 1; i < codes.length; i++)
        nms[i] = descs.get(codes[i]).toString();
        return nms;
    }

    public String getCode(String displayName)
    {
        String s = (String)dnames.get(displayName);
        if(s == null)
        s = "";
        return s;
    }

    public String[] getDescriptions()
    {
        String dsc[] = new String[codes.length - 1];
        Enumeration e = descs.elements();
        for(int i = 0; e.hasMoreElements(); i++)
        dsc[i] = e.nextElement().toString();
        return dsc;
    }

    public String[] getCodes()
    {
        return codes;
    }

    public String[] getNames()
    {
        String dsc[] = new String[codes.length - 1];
        Enumeration e = names.elements();
        for(int i = 0; e.hasMoreElements(); i++)
        dsc[i] = e.nextElement().toString();

        return dsc;
    }

    public String getDescription(String code)
    {
        return descs.get(code).toString();
    }

    public String getName(String code)
    {
        return names.get(code).toString();
    }

    static final RBReleaseTypes instance = new RBReleaseTypes();
    String codes[] = { " ", "WB", "MB", "EB"};
    Hashtable descs;
    Hashtable names;
    Hashtable dnames;

}
