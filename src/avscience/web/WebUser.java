package avscience.web;

import java.util.Hashtable;
import avscience.ppc.AvScienceDataObject;

public class WebUser extends AvScienceDataObject
{
    String username;
    String email;
    String realName;
    String prof;
    String afil;
    String share;
    
    public WebUser(String s, String s1, String s2, String s3, boolean flag, boolean flag1)
    {
        prof = "false";
        share = "false";
        username = s;
        email = s1;
        realName = s2;
        afil = s3;
        if(flag)
            prof = "true";
        else
            prof = "false";
        if(flag1)
            share = "true";
        else
            share = "false";
    }

    public WebUser()
    {
        prof = "false";
        share = "false";
    }

    public WebUser(String s) throws Exception
    {
        super(s);
    }

    public String getName()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getRealName()
    {
        return realName;
    }

    public String getAffil()
    {
        return afil;
    }

    public boolean getProf()
    {
        return prof.equals("true");
    }

    public boolean getShare()
    {
        return share.equals("true");
    }

    @Override
    public void writeAttributes()
    {
        try
        {
            put("afil", afil);
            put("email", email);
            put("prof", prof);
            put("realName", realName);
            put("share", share);
            put("username", username);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    @Override
    public void popAttributes()
    {
        try
        {
            afil = (String)get("afil");
            email = (String)get("email");
            prof = (String)get("prof");
            realName = (String)get("realName");
            share = (String)get("share");
            username = (String)get("username");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

}
