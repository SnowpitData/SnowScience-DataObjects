package avscience.ppc;

public class WebUser extends AvScienceDataObject
{
    String username;
    String email;
    String realName;
    String prof = "false";
    String affil;
    String share = "false";
    
    public WebUser(String username, String email, String realName, String affil, boolean prof, boolean share)
    {
        this.username = username;
        this.email = email;
        this.realName = realName;
        this.affil = affil;
        if(prof)
            this.prof = "true";
        else
            this.prof = "false";
        if(share)
            this.share = "true";
        else
            this.share = "false";
    }

    public WebUser()
    {
        prof = "false";
        share = "false";
    }

    public WebUser(String s) throws Exception
    {
        super(s);
        popAttributes();
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
        return affil;
    }

    public boolean getProf()
    {
        return prof.equals("true");
    }

    public boolean getShare()
    {
        return share.equals("true");
    }

    public void writeAttributes()
    {
        try
        {
            put("affil", affil);
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

    public void popAttributes()
    {
        try
        {
            affil = getString("affil");
            email = getString("email");
            prof = getString("prof");
            realName = getString("realName");
            share = getString("share");
            username = getString("username");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
