package avscience.ppc;

public class Layer extends avscience.ppc.AvScienceDataObject
{
    private String startDepth = "";
    private String endDepth = "";
    public String hardness1 = "";// avg if one, top if 2
    public String hardness2 = "";// bottom if 2
    public String hsuffix1 = "";
    public String hsuffix2 = "";
    private String grainType = "";
    private String grainType1 = "";
    private String grainSize = "";
    private String grainSize1 = "";
    private String grainSizeUnits1 = "";
    private String grainSizeUnits2 = "";
    private String grainSuffix = "";
    private String grainSuffix1 = "";
    private String waterContent = "";
    private String density1 = "";
    private String density2 = "";
    private String multipleHardness = "false";
    private String multipleGrainSize = "false";
    private String multipleDensity = "false";
    private String multipleGrainType = "false";
    private String fromTop="false";
    private String layerNumber = "";
    private String comments = "";
    
    public Layer()
    {
        super();
    }
    
    public Layer(String data) throws Exception
    {
    	super(data);
        popAttributes();
    }
    
    public static void main(String[] args)
    {
        Layer l = new Layer("1", "11", "4F", "1F", "", "", "DFxc", "DFsf", "mm", "mm", "1.5", "", "2.0", "", "moist", "123.2", "231.1", "Blah blah", "1", true );
        System.out.println("Layer: "+l.toUIString());
        
        String json = l.toString();
        System.out.println("JSON: "+json);
        try
        {
            Layer ll = new Layer(json);
            System.out.println("LLayer: "+ll.toUIString());
            System.out.println("LL JSON: "+ll.toString());
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
   
    public Layer(String startDepth, String endDepth, String hardness1, String hsuffix1, String hardness2, String hsuffix2, String grainType, String grainType1, String grainSizeUnits1, String grainSizeUnits2, String grainSize, String grainSuffix, String grainSize1, String grainSuffix1, String waterContent, String density1, String density2, String comments, String layerNumber, boolean fromTop)
    {
        this.startDepth = startDepth;
        this.endDepth = endDepth;
        this.hardness1 = hardness1;
        this.hsuffix1 = hsuffix1;
        this.hardness2 = hardness2;
        this.hsuffix2 = hsuffix2;
        this.grainType = grainType;
        this.grainType1 = grainType1;
        this.grainSizeUnits1 = grainSizeUnits1;
        this.grainSizeUnits2 = grainSizeUnits2;
        this.grainSize = grainSize;
        this.grainSize1 = grainSize1;
        this.grainSuffix = grainSuffix;
        this.grainSuffix1 = grainSuffix1;
        this.waterContent = waterContent;
        this.density1 = density1;
        this.density2 = density2;
        this.comments = comments;
        this.layerNumber = layerNumber;
        if ( hardness2.trim().length() > 0 ) multipleHardness = "true";
        if ( density2.trim().length() > 0 ) multipleDensity = "true";
        if ( grainSize1.trim().length() > 0 ) multipleGrainSize = "true";
        if ( grainType1.trim().length() > 1 ) multipleGrainType = "true";
        if ( fromTop )this.fromTop="true";
        else this.fromTop="false";
    }
    
    public String getStartDepthString()
    {
    	if (startDepth==null) return "";
    	return startDepth;
    }
    
    public void setFromTop(boolean fromTop)
    {
    	if ( fromTop )this.fromTop="true";
        else this.fromTop="false";
    }
    
    public boolean getFromTop()
    {
    	if ( fromTop==null ) fromTop="true";
    	if (fromTop.equals("true")) return true;
    	else return false;
    
    }
    ////////////////////////////////////////////////////
    public double getTopDepth()
    {
    	return getEndDepth();
    }
    
    public double getBottomDepth()
    {
    	return getStartDepth();
    }
    
    public String getHardnessTop()
    {
    	if (getFromTop()) return getHardness2();
    	else return getHardness1();
    }
    
    public String getHSuffixTop()
    {
    	if (getFromTop()) return getHSuffix2();
    	else return getHSuffix1();
    }
    
    public String getGrainSizeTop()
    {
    	return getGrainSize1();
    }
    
    public String getGrainSuffixTop()
    {
        return getGrainSuffix();
    }
 	
    public String getGrainUnitsTop()
    {
        return getGrainUnits1();
    }
 	
    public String getGrainTypeTop()
    {
        return getGrainType1();
    }
 	
    public String getDensityTop()
    {
        return getDensity1();
    }
   
    public String getHardnessBottom()
    {
    	if (getFromTop()) return getHardness1();
    	else return getHardness2();
    }
    
    public String getHSuffixBottom()
    {
    	if (getFromTop()) return getHSuffix1();
    	else return getHSuffix2();
    }
    
    public String getGrainSizeBottom()
    {
    	return getGrainSize2();
    }
    
    public String getGrainSuffixBottom()
    {
        return getGrainSuffix1();
    }
 	
    public String getGrainUnitsBottom()
    {
        return getGrainUnits2();
    }
 	
    public String getGrainTypeBottom()
    {
        return getGrainType2();
    }
 	
    public String getDensityBottom()
    {
        return getDensity2();
    }
 	
 	
    public void swapHardness()
    {
 	String h1 = hardness1;
 	String h2 = hardness2;
 	hardness1 = h2;
 	hardness2 = h1;
 	String hsf1 = hsuffix1;
 	String hsf2 = hsuffix2;
 	hsuffix1=hsf2;
 	hsuffix2=hsf1;
    }
 	
    public String getEndDepthString()
    {
    	if (endDepth==null) return "";
    	return endDepth;
    }
    
    public double getStartDepth()
    {
    	if ( startDepth == null ) return 0;
    	if ( startDepth.equals("null")) return 0;
    	if ( startDepth.trim().length()<1) return 0;
    	return new Double(startDepth).doubleValue();
    }
    
    public String getLayerNumberString()
    {
    	return layerNumber;
    }
    
    public int getLayerNumber()
    {
    	if (layerNumber==null) return 0;
        layerNumber = layerNumber.trim();
        if ( layerNumber.length() < 1 ) return 0;
        int ln = new Integer(layerNumber).intValue();
        if ( ln < 1 ) ln = 1;
        return ln;
    }
    
    public double getGrainSize1_Dbl()
    {
        if ( grainSize == null ) return 0;
    	if ( grainSize.equals("null")) return 0;
    	if ( grainSize.trim().length()<1) return 0;
    	return new Double(grainSize).doubleValue();
    }
    
    public double getGrainSize2_Dbl()
    {
        if ( grainSize1 == null ) return 0;
    	if ( grainSize1.equals("null")) return 0;
    	if ( grainSize1.trim().length()<1) return 0;
    	return new Double(grainSize1).doubleValue();
    }
    
    public double getDensity1_Dbl()
    {
        if ( density1 == null ) return 0;
    	if ( density1.equals("null")) return 0;
    	if ( density1.trim().length()<1) return 0;
    	return new Double(density1).doubleValue();
    }
    
    public double getDensity2__Dbl()
    {
        if ( density2 == null ) return 0;
    	if ( density2.equals("null")) return 0;
    	if ( density2.trim().length()<1) return 0;
    	return new Double(density2).doubleValue();
    }
    
    public boolean getMultDensityBool()
    {
        if ( multipleDensity==null ) return false;
        if (multipleDensity.equals("true")) return true;
        else return false;
    }
        
    public boolean getMultGrainSizeBool()
    {
        if ( multipleGrainSize==null ) return false;
        if ( multipleGrainSize.equals("true")) return true;
        else return false;
    }
        
    public boolean getMultGrainTypeBool()
    {
        if ( multipleGrainType==null ) return false;
        if ( multipleGrainType.equals("true")) return true;
        else return false;
    }
        
    public boolean getMultHardnessBool()
     {
        if ( multipleHardness==null ) return false;
        if ( multipleHardness.equals("true")) return true;
        else return false;
    }
    
    public double getEndDepth()
    {
    	if ( endDepth == null ) return 0;
    	if ( endDepth.equals("null")) return 0;
    	if ( endDepth.trim().length()<1) return 0;
    	return new Double(endDepth).doubleValue();
    }
    
    public double getThickness()
    {
    	double thck=getStartDepth()-getEndDepth();
    	if ( thck<0 ) thck=-thck;
    	return thck;
    }
    
    public int getStartDepthInt()
    {
    	if ( startDepth == null ) return 0;
    	if ( startDepth.equals("null")) return 0;
    	try
    	{
    		return (int) (new Double(startDepth).doubleValue()*10);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    		return 0;
    	}
    	
    }
    
    public int getEndDepthInt()
    {
    	System.out.println("end depth: "+endDepth);
    	if ( endDepth == null ) return 0;
    	if ( endDepth.equals("null")) return 0;
    	try
    	{
    		return (int) (new Double(endDepth).doubleValue()*10);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    		return 0;
    	}
    }
    	
    
    public String getComments()
    {
	if ( comments==null) comments= "";
        return comments;
    }
    
    public void setComments(String comments)
    {
        this.comments = comments;
    }
    
    public void swapDepths()
    {
    	swapParams(startDepth, endDepth);
    	swapParams(density1, density2);
    	swapParams(grainSize, grainSize1);
    	swapParams(grainSizeUnits1, grainSizeUnits2);
    	swapParams(grainSuffix, grainSuffix1);
    	swapParams(grainType, grainType1);
    	swapParams(hardness1, hardness2);
    	swapParams(hsuffix1, hsuffix2);
    }
    
    private void swapParams(String p1, String p2)
    {
    	String s = p1;
    	String ss = p2;
    	p1=ss;
    	p2=s;
    }
    
    public String shortString()
    {
    	return startDepth+"-"+endDepth;
    }
    
    
    public String toUIString()
    {
    	if ( ( layerNumber==null)) layerNumber="";
        return layerNumber+": "+startDepth+"-"+endDepth;
    }
    
    public String getHardness1()
    {
    	if (hardness1==null) hardness1="";
        return hardness1;
    }
    
    public String getLString()
    {
    	if (layerNumber==null) layerNumber="";
    	return layerNumber;
    }
    
    public String getHardness2()
    {
    	if (hardness2==null) hardness2="";
        return hardness2;
    }
    
    public String getGrainType1()
    {
    	if ( grainType==null ) grainType="";
        return grainType;
    }
    
    public String getGrainType2()
    {
    	if ( grainType1==null ) grainType1="";
        return grainType1;
    }
    
    public String getGrainSize1()
    {
    	if ( grainSize==null ) grainSize="";
        return grainSize;
    }
    
    public String getGrainSizeUnits1()
    {
    	if ( grainSizeUnits1==null ) grainSizeUnits1="";
        return grainSizeUnits1;
    }
    
    public String getGrainSizeUnits2()
    {
    	if ( grainSizeUnits2==null ) grainSizeUnits2="";
        return grainSizeUnits2;
    }
    
    public String getGrainSize2()
    {
    	if ( grainSize1==null ) grainSize1="";
        return grainSize1;
    }
    
    public String getGrainUnits1()
    {
    	if ( grainSizeUnits1==null ) grainSizeUnits1="";
        return grainSizeUnits1;
    }
    
    public String getGrainUnits2()
    {
    	if ( grainSizeUnits2==null ) grainSizeUnits2="";
        return grainSizeUnits2;
    }
    
    public String getWaterContent()
    {
    	if ( waterContent==null ) waterContent="";
        return waterContent;
    }
    
    public String getHSuffix1()
    {
    	if ( hsuffix1==null ) hsuffix1="";
        return hsuffix1;
    }
    
    public String getGrainSuffix()
    {
    	if ( grainSuffix==null ) grainSuffix="";
        return grainSuffix;
    }
    
    public String getGrainSuffix1()
    {
    	if ( grainSuffix1==null ) grainSuffix1="";
        return grainSuffix1;
    }
    
    public void setGrainSuffix(String suffix)
    {
        grainSuffix = suffix;
    }
    
    public String getHSuffix2()
    {
    	if ( hsuffix2==null ) hsuffix2="";
        return hsuffix2;
    }
    
    public String getMultipleHardness()
    {
        return multipleHardness;
    }
    
    public String getMultipleGrainType()
    {
        return multipleGrainType;
    }
    
    public String getMultipleGrainSize()
    {
        if ( grainSize1==null) grainSize1="";
        if ( grainSize1.trim().length() > 1 ) return "true";
        else return "false";
    }
    
    public String getDensity()
    {
    	String d1 = getDensity1();
    	String d2 = getDensity2();
    	if (d1.trim().length()>1) return d1;
    	if (d2.trim().length()>1) return d2;
    	return d1;
    }
    
    public String getDensity1()
    {
    	if ( density1==null ) density1="";
    	return density1;
     }
	
    public String getDensity2()
    {
    	if ( density2==null ) density2="";
    	return density2;
     }
	
    public String getMultipleDensity()
    { 
	if (multipleDensity==null) multipleDensity="";
	return multipleDensity;
    }
    
    public void setMultipleHardness(String code)
    {
        multipleHardness = code;
    }
    
    public void setMultipleGrainSize(String code)
    {
        multipleGrainSize = code;
    }
    
    public void setMultipleDensity(String code)
    {
        multipleDensity = code;
    }
    
    public void setGrainType1(String type)
    {
        grainType = type;
    }
    public void setGrainType2(String type)
    {
        grainType1 = type;
    }
    ////////////////////////////////////
    /// to support CAAML in mm
    ////////////////////////////////////////
    
    public String getGrainSizeMin()
    {
    	String s="0";
    	double gs1=0;
    	double gs2=0;
    	
    	try
    	{
    		gs1 = new Double(grainSize).doubleValue();
    	}
    	catch(Exception e)
    	{
    		gs1=0;
    	}
    	
    	try
    	{
    		gs2 = new Double(grainSize1).doubleValue();
    	}
    	catch(Exception e)
    	{
    		gs2=0;
    	}
    	
    	
    	if (grainSizeUnits1!=null)if (grainSizeUnits1.equals("cm")) gs1=10*gs1;
    	if (grainSizeUnits2!=null) if (grainSizeUnits2.equals("cm")) gs2=10*gs2;
    	
    	if ( gs1 < gs2 ) s=gs1+"";
    	else s=gs2+"";
    	if (s.equals("0")) s="";
    	return s;
    }
    
    public String getGrainSizeMax()
    {
       	String s="0";
    	double gs1=0;
    	double gs2=0;
    	
    	try
    	{
    		gs1 = new Double(grainSize).doubleValue();
    	}
    	catch(Exception e)
    	{
    		gs1=0;
    	}
    	
    	try
    	{
    		gs2 = new Double(grainSize1).doubleValue();
    	}
    	catch(Exception e)
    	{
    		gs2=0;
    	}
    	
    	
    	if (grainSizeUnits1!=null) if (grainSizeUnits1.equals("cm")) gs1=10*gs1;
    	if (grainSizeUnits2!=null) if (grainSizeUnits2.equals("cm")) gs2=10*gs2;
    	
    	if ( gs1 > gs2 ) s=gs1+"";
    	else s=gs2+"";
    	if (s.equals("0")) s="";
    	return s;
    }
    
    public String getAvgGrainSize()
    {
    	String s="0";
    	double gs1 = 0;
    	double gs2 = 0;
    	try
    	{
    		gs1 = new Double(grainSize).doubleValue();
    	}
    	catch(Exception e)
    	{
    		gs1=0;
    	}
    	
    	try
    	{
    		gs2 = new Double(grainSize1).doubleValue();
    	}
    	catch(Exception e)
    	{
    		gs2=0;
    	}
    		
    	
    	if (grainSizeUnits1!=null) if (grainSizeUnits1.equals("cm")) gs1=10*gs1;
    	if (grainSizeUnits2!=null) if (grainSizeUnits2.equals("cm")) gs2=10*gs2;
    	double gs=0;
    	
    	if (gs1==0) return gs2+"";
    	if (gs2==0) return gs1+"";
    	
    	gs = (gs1+gs2)/2.0;
    	return gs+"";
    }
    
    
    
    public void writeAttributes()
    {
        try
        {
            put("startDepth", startDepth);
            put("endDepth", endDepth);
            put("hardness1", hardness1);
            put("hardness2", hardness2);
            put("hsuffix1", hsuffix1);
            put("hsuffix2", hsuffix2);
            put("grainType", grainType);
            put("grainType1", grainType1);
            put("grainSize", grainSize);
            put("grainSize1", grainSize1);
            put("grainSizeUnits1", grainSizeUnits1);
            put("grainSizeUnits2", grainSizeUnits2);
            put("grainSuffix", grainSuffix);
            put("grainSuffix1", grainSuffix1);
            put("waterContent", waterContent);
            put("density1", density1);
            put("density2", density2);
            put("multipleHardness", multipleHardness);
            put("multipleGrainSize", multipleGrainSize);
            put("multipleDensity", multipleDensity);
            put("multipleGrainType", multipleGrainType);
            put("comments", comments);
            put("layerNumber", layerNumber);
            put("fromTop", fromTop);
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
            System.out.println("getAttributes()");
            startDepth = getString("startDepth");
            endDepth = getString("endDepth");
            hardness1 = getString("hardness1");
            hardness2 = getString("hardness2");
            hsuffix1 = getString("hsuffix1");
            hsuffix2 = getString("hsuffix2");
            grainType = getString("grainType");
            grainType1 = getString("grainType1");
            grainSize = getString("grainSize");
            grainSize1 = getString("grainSize1");
            grainSizeUnits1 = getString("grainSizeUnits1");
            grainSizeUnits2 = getString("grainSizeUnits2");
            grainSuffix = getString("grainSuffix");
            grainSuffix1 = getString("grainSuffix1");
            waterContent = getString("waterContent");
            density1 = getString("density1");
            density2 = getString("density2");
            multipleHardness = getString("multipleHardness");
            multipleGrainSize = getString("multipleGrainSize");
            multipleDensity = getString("multipleDensity");
            multipleGrainType = getString("multipleGrainType");
            comments = getString("comments");
            layerNumber = getString("layerNumber");
            fromTop = getString("fromTop");
            if ((startDepth==null) && (endDepth==null))
            {
                startDepth="";
                endDepth="";
            }
            if (startDepth==null)startDepth=endDepth;
            if (endDepth==null)endDepth=startDepth;
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}