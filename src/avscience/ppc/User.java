package avscience.ppc;

import java.security.MessageDigest;

public class User extends AvScienceDataObject
{
    public String fractureCat="Shear Quality";
    public String hardnessScaling="linear";
    
    private String userName = "";
    private String name = "";
    private String email = "";
    private String last = "";
    private String first = "";
    private String phone = "";
    private String affil= "";
    private String state ="MT";
    private String prof = "false";
    private String share = "true";
    private String hash = null;
    
    private Preferences prefs = new Preferences();
    public Preferences getPrefernces(){ return prefs; }
    
    public User(){}
    
    public User(String data) throws Exception
    {
    	super(data);
        popAttributes();
        if ( hash == null) hash = generateHash();
     }
    
    public User(String userName, String name, String email, String last, String first, String phone, String prof, String affil, String share)
    {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.last = last;
        this.first = first;
        this.phone = phone;
        this.prof = prof;
        this.affil = affil;
        this.share = share;
        hash = generateHash();
    }
    
    private String generateHash()
    {
        String s = "|"+last+":~"+first+"!";
        byte[] bts = s.getBytes();
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] res = md.digest(bts);
            return new String(res);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return s;
        }
    }
    
    public String getHash()
    {
        return hash;
    }
    
    public void writeAttributes()
    {
        //System.out.println("User:writeAttributes()");
        try
        {
                put("share", share);
                put("affil", affil);
                put("prof", prof);
                put("name", name);
                put("email", email);
                put("last", last);
                put("first", first);
                put("phone", phone);
                put("state", state);
                put("fractureCat", fractureCat);
                put("hardnessScaling", hardnessScaling);
                put("userName", userName);
                put("hash", hash);
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
            share = getString("share");
            affil = getString("affil");
            prof =  getString("prof");
            name = getString("name");
            email = getString("email");
            last = getString("last");
            first = getString("first");
            phone = getString("phone");
            state = getString("state");
            fractureCat = getString("fractureCat");
            hardnessScaling = getString("hardnessScaling");
            userName = getString("userName");
            hash = getString("hash");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
     }
     
     public String getState()
     {
     	return state;
     }
     
     public void setState(String state)
     {
     	this.state=state;
     }
     
     public void setFractureCategory(String cat)
     {
     	fractureCat=cat;
     }
     
    public boolean getProf()
    { 
    	if ( prof==null ) return false;
    	if (prof.equals("true")) return true;
    	else return false;
    }
    
    public boolean getShare()
    { 
    	if ( prof==null ) return true;
    	if (share.equals("true")) return true;
    	else return false;
    }
    
    public String getAffil()
    { 
    	if ( affil==null ) affil="";
    	return affil;
    }
    
    public String getName() { return name; }
    
    public String getEmail() { return email; }
    
    public String getLast() 
    { 
        if (last == null) last = "";
        return last; 
    }
    
    public String getFirst() 
    { 
        if ( first == null) first ="";
        return first; 
    }
    
    public String getPhone() { return phone ; }
    
    public String getDepthUnits() 
    { 
        return prefs.getDepthUnits();
    }
    
    public String getTempUnits() { return prefs.getTempUnits(); }
    
    public String getElvUnits() { return prefs.getElvUnits(); }
    
    public String getRhoUnits() { return prefs.getRhoUnits(); }
    
    public String getMeasureFrom(){ return prefs.getMeasureFrom(); }
   
    public String getLatType(){ return prefs.getLatType(); }
    
    public String getLongType(){ return prefs.getLongType(); }
    
    public void setProf(String prof)
    {
    	this.prof = prof;
    }
    
    public void setAffil(String affil)
    {
    	this.affil = affil;
    }
    
    public void setShare(String share)
    {
    	this.share = share;
    }
    
    public void setName(String name)
    {
        this.name =name;
    }
    
    public void setEmail(String email)
    {
        this.email =email;
    }
    
    public void setFirst(String first)
    {
        this.first =first;
    }
    
    public void setLast(String last)
    {
        this.last =last;
    }
    
    public void setPhone(String phone)
    {
        this.phone =phone;
    }
    
    public void setDepthUnits(String depthUnits)
    {
        prefs.setDepthUnits(depthUnits);
    }
    
    public void setTempUnits(String tempUnits)
    {
        prefs.setTempUnits(tempUnits);
    }
    
    public void setElvUnits(String elvUnits)
    {
        prefs.setElvUnits(elvUnits);
    }
    
    public void setRhoUnits(String rhoUnits)
    {
        prefs.setRhoUnits(rhoUnits);
    }
    
    public void setMeasureFrom(String measureFrom)
    {
        prefs.setMeasureFrom(measureFrom);
    }
    
    public void setLatType(String latType)
    {
        prefs.setLatType(latType);
    }
    
    public void setLongType(String longType)
    {
        prefs.setLongType(longType);
    }
    
    public void setCoordType(String ctype)
    {
        prefs.setCoordType(ctype);
    }
    
    public String getCoordType()
    {
        return prefs.getCoordType();
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}    
