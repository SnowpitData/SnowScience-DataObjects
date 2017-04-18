package avscience.ppc;

public class User extends AvScienceDataObject
{
    public String fractureCat="Shear Quality";
    public String hardnessScaling="linear";
    private String name = "";
    private String email = "";
    private String last = "";
    private String first = "";
    private String phone = "";
    private String prof = "false";
    private String affil= "";
    private String share = "true";
    private String tempUnits = "C";
    private String depthUnits = "cm";
    private String elvUnits = "m";
    private String rhoUnits = "kg/cubic_m";
    private String measureFrom = "top";
    private String longType = "W";
    private String latType = "N";
    private String state ="MT";
    private String coordType="Lat/Lon";
    
    public User(){super();}
    
    public User(String data) throws Exception
    {
    	super(data);
        popAttributes();
     }
    
    public User(String name, String email, String last, String first, String phone, String prof, String affil, String share)
    {
    	this();
        this.name = name;
        this.email = email;
        this.last = last;
        this.first = first;
        this.phone = phone;
        this.prof = prof;
        this.affil = affil;
        this.share = share;
    }
    
    public void writeAttributes()
    {
        System.out.println("User:writeAttributes()");
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
                put("tempUnits", tempUnits);
                put("depthUnits", depthUnits);
                put("elvUnits", elvUnits);
                put("rhoUnits", rhoUnits);
                put("measureFrom", measureFrom);
                put("latType", latType);
                put("longType", longType);
                put("state", state);
                put("coordType", coordType);
                put("fractureCat", fractureCat);
                put("hardnessScaling", hardnessScaling);
                
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
            tempUnits = getString("tempUnits");
            depthUnits = getString("depthUnits");
            elvUnits = getString("elvUnits");
            rhoUnits = getString("rhoUnits");
            measureFrom = getString("measureFrom");
            latType = getString("latType");
            longType = getString("longType");
            state = getString("state");
            coordType = getString("coordType");
            fractureCat = getString("fractureCat");
            hardnessScaling = getString("hardnessScaling");
            
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
        if ( depthUnits == null ) depthUnits="";
        return depthUnits; 
    }
    
    public String getTempUnits() { return tempUnits; }
    
    public String getElvUnits() { return elvUnits; }
    
    public String getRhoUnits() { return rhoUnits; }
    
    public String getMeasureFrom(){ return measureFrom; }
   
    public String getLatType(){ return latType; }
    
    public String getLongType(){ return longType; }
    
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
        this.depthUnits = depthUnits;
    }
    
    public void setTempUnits(String tempUnits)
    {
        this.tempUnits = tempUnits;
    }
    
    public void setElvUnits(String elvUnits)
    {
        this.elvUnits = elvUnits;
    }
    
    public void setRhoUnits(String rhoUnits)
    {
        this.rhoUnits = rhoUnits;
    }
    
    public void setMeasureFrom(String measureFrom)
    {
        this.measureFrom = measureFrom;
    }
    
    public void setLatType(String latType)
    {
        this.latType = latType;
    }
    
    public void setLongType(String longType)
    {
        this.longType = longType;
    }
    
    public void setCoordType(String ctype)
    {
        coordType = ctype;
    }
    
    public String getCoordType()
    {
        return coordType;
    }
    
}    
