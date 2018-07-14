package avscience.ppc;

import java.util.Date;

public class ShearTestResult extends avscience.ppc.AvScienceDataObject
{
    public String code="";
    private String score = "";
    private String quality = "";
    public String character = "";
    public String fractureCat="";
    private String sdepth = "";
    private String depthUnits= "";
    private String comments = " ";
    private String dateString = "";
    private String ctScore = "";
    private String dtScore = "";
    private String ecScore="";
    public String numberOfTaps="0";
    public String releaseType="";
    /// PST
    public String lengthOfCut="0";
    public String lengthOfColumn="0";
    
    private String s="";
    private int mult=1;
    
    public ShearTestResult(String data) throws Exception
    {
    	super(data);
        popAttributes();
    }
    
    public ShearTestResult(String[] atts) ///throws Exception
    {
        ///if (atts.length != 18 ) throw new Exception("Attribute set length incorrect");
        code = atts[0];
        score = atts[1];
        quality = atts[2];
        character = atts[3];
        fractureCat = atts[4];
        sdepth = atts[5];
        depthUnits = atts[6];
        comments = atts[7];
        dateString = atts[8];
        ctScore = atts[9];
        dtScore = atts[10];
        ecScore = atts[11];
        numberOfTaps = atts[12];
        releaseType = atts[13];
        lengthOfCut = atts[14];
        lengthOfColumn = atts[15];
        s = atts[16];
        
    }
    
    public boolean isNoFail()
    {
    	boolean is = false;
    	if ( score==null) return false;
    	if ( score.equals("SBN") || score.equals("CTN") || score.equals("DTN") || score.equals("RB7") || score.equals("STN") || score.equals("ECTNR")) is=true;
    	return is;
    }
    
    public void setComments(String comments)
    {
    	this.comments=comments;
    }
    
    public ShearTestResult() {super();}
    
    public ShearTestResult(String code, String score, String quality, String sdepth, String depthUnits, String comments, String ctScore, String dtScore, String ecScore, String fractureChar, String cat)
    {
    	if ( code.equals("PST")) this.code=code;
        else this.code = score.substring(0, 2);
        this.score = score;
        this.quality = quality;
        this.sdepth = sdepth;
        this.depthUnits = depthUnits;
        this.comments = comments;
        this.ctScore = ctScore;
        this.ecScore=ecScore;
        this.dtScore=dtScore;
        this.character=fractureChar;
        this.fractureCat=cat;
        
        Date date = new Date(System.currentTimeMillis());
        dateString = date.toString();
        s = score + " " + quality + " " + sdepth + " " + dateString;
        if ( code.equals("PST"))  s=code+" "+s;
    }
    
    public String getComments()
    {
        if ( comments != null ) return comments;
        else return " ";
    }
    
    public double getDepthSI()
    {
	if ( isNoFail() ) return 0.0;
	double dsi = getDepthValue();
	if ( depthUnits.equals("inches") ) dsi = (dsi/2.54);
	return dsi;
    }
    
    public String getDepth()
    {
    	if ( isNoFail() ) return "0";
    	if (getDepthValueInt()<0) return "0";
    	if ( sdepth==null) sdepth="";
        return sdepth;
    }
    
    public int getDepthValueInt()
    {
    	if ( isNoFail() ) return 0;
    	return (int) (10*getDepthValue());
    }
    
    public int getCTScoreAsInt()
    {
        Integer I = null;
        try
        {
            I = new java.lang.Integer(ctScore);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return 0;
        }
        return I.intValue();
    }
    
    public int getDTScoreAsInt()
    {
        Integer I = null;
        try
        {
            I = new java.lang.Integer(dtScore);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return 0;
        }
        return I.intValue();
    }
    
    public int getECScoreAsInt()
    {
        Integer I = null;
        try
        {
            I = new java.lang.Integer(ecScore);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return 0;
        }
        return I.intValue();
    }
    
    public String getDateString()
    {
        return dateString;
    }
    
    public double getDepthValue()
    {
    	if ( isNoFail() ) return 0.0;
    	try
    	{
    		return new Double(sdepth).doubleValue();
    	}
    	catch(Exception e)
    	{
    	    return 0.0;	
    	}
    	
    }
    
    public String getDepthUnits()
    {
    	if ( depthUnits==null) return "";
        return depthUnits;
    }
    
    public String getQuality()
    {
    	if ( quality==null ) quality="";
        return quality;
    }
    
    public String getReleaseType()
    {
    	if ( releaseType==null )return "";
    	return releaseType;
    }
    
    public String getScore()
    {
    	if ( score==null) score="";
        return score;
    }
    
    public void setMult(int mult)
    {
    	this.mult = mult;
    }
    
    public int getMult()
    {
    	return mult;
    }
    
    public String toUIString()
    {
    	return s;
    }
    
    public String getCode()
    {
    	if (code==null) code="";
        return code;
    }
    
    public String getCTScore()
    {
    	if ( ctScore==null ) ctScore="";
    	return ctScore;
    }
    
    public String getDTScore()
    {
    	if ( dtScore==null ) dtScore="";
    	return dtScore;
    }
    
    public String getECScore()
    {
    	if ( ecScore==null ) ecScore="";
    	return ecScore;
    }
    
    public int getNumberOfTaps()
    {
        if (numberOfTaps == null) return 0;
        if (numberOfTaps.trim().length()<1) return 0;
        return new Integer(numberOfTaps).intValue();
    }
    
    public int getLengthOfColumn()
    {
        if (lengthOfColumn == null) return 0;
        if (lengthOfColumn.trim().length()<1) return 0;
        return new Integer(lengthOfColumn).intValue();
    }
    
    public int getLengthOfCut()
    {
        if (lengthOfCut == null) return 0;
        if (lengthOfCut.trim().length()<1) return 0;
        return new Integer(lengthOfCut).intValue();
    }
    
    public void writeAttributes()
    {
        try
        {
            put("s", s);
            put("code", code);
            put("score", score);
            put("ctScore", ctScore);
            put("dtScore", dtScore);
            put("ecScore", ecScore);
            put("quality", quality);
            put("sdepth", sdepth);
            put("depthUnits", depthUnits);
            put("comments", comments);
            put("dateString", dateString);
            put("releaseType", releaseType);
            put("lengthOfCut", lengthOfCut);
            put("lengthOfColumn", lengthOfColumn);
            put("character", character);
            put("fractureCat", fractureCat);
            put("numberOfTaps", numberOfTaps);
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
            s = getString("s");
            code = getString("code");
            score = getString("score");
            ctScore = getString("ctScore");
            dtScore = getString("dtScore");
            ecScore = getString("ecScore");
            quality = getString("quality");
            sdepth = getString("sdepth");
            depthUnits = getString("depthUnits");
            comments = getString("comments");
            dateString = getString("dateString");
            releaseType = getString("releaseType");
            if ( releaseType==null) releaseType="";
            lengthOfColumn = getString("lengthOfColumn");
            if ( lengthOfColumn==null) lengthOfColumn="";
            lengthOfCut = getString("lengthOfCut");
            if ( lengthOfCut==null) lengthOfCut="";
            character = getString("character");
            if ( character==null) character="";
            fractureCat = getString("fractureCat");
            if ( fractureCat==null) fractureCat="";
            numberOfTaps= getString("numberOfTaps");
            if (numberOfTaps==null)numberOfTaps="";
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
}