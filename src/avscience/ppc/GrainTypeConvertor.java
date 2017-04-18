
 package avscience.ppc;

import java.util.*;

public class GrainTypeConvertor 
{
        public final static int numberOfTypes = 9;
	public GrainTypeSet[] types = new GrainTypeSet[numberOfTypes];
        public String[] basicTypes = new String[numberOfTypes];
        public String[] basicTypeCodes = new String[numberOfTypes];
        
	Hashtable<String, String> lwc = new Hashtable<String, String>();
        
        public final static int PP = 0;
        public final static int DF = 1;
        public final static int RG = 2;
        public final static int FC = 3;
        public final static int DH = 4;
        public final static int SH = 5;
        public final static int MF = 6;
        public final static int IF = 7;
        public final static int MM = 8;
        
    private static final GrainTypeConvertor instance  = new GrainTypeConvertor();
    public static GrainTypeConvertor getInstance()
    {
        return instance;
    }
        
    private GrainTypeConvertor() 
    {
        basicTypes[PP] = "Precipitation particles";
        basicTypes[DF] = "Decomposing and fragmented precipitation particles";
        basicTypes[RG] = "Rounded grains";
        basicTypes[FC] = "Faceted crystals";
        basicTypes[DH] = "Depth hoar";
        basicTypes[SH] = "Surface hoar";
        basicTypes[MF] = "Melt forms";
        basicTypes[IF] = "Ice formations";
        basicTypes[MM] = "Machine made Snow";
        
        basicTypeCodes[PP] = "PP";
        basicTypeCodes[DF] = "DF";
        basicTypeCodes[RG] = "RG";
        basicTypeCodes[FC] = "FC";
        basicTypeCodes[DH] = "DH";
        basicTypeCodes[SH] = "SH";
        basicTypeCodes[MF] = "MF";
        basicTypeCodes[IF] = "IF";
        basicTypeCodes[MM] = "MM";
           
        types[PP] = new GrainTypeSet("PP", 9);
        
        types[PP].put("Graupel", "PPgp");
  	types[PP].put("Columns", "PPco");
        types[PP].put("Plates", "PPpl");
  	types[PP].put("Needles", "PPnd");
  	types[PP].put("Stellars, Dendrites", "PPsd");
  	types[PP].put("Irregular crystals", "PPir");
  	types[PP].put("Hail", "PPhl");
  	types[PP].put("Ice pellets", "PPip`");
        types[PP].put("Rime", "PPrm");
        
        types[DF] = new GrainTypeSet("DF", 2);;
    	types[DF].put("Partly decomposed precipitation particles", "DFdc");
    	types[DF].put("Wind-broken precipitation particles", "DFbk");
        
        types[RG] = new GrainTypeSet("RG", 4);
  	types[RG].put("Small rounded particles", "RGsr" );
        types[RG].put("Large rounded particles", "RGlr");
  	types[RG].put("Wind packed", "RGwp");
    	types[RG].put("Faceted rounded particles", "RGxf");
        
        types[FC] = new GrainTypeSet("PP", 3);
  	types[FC].put("Solid faceted particles", "FCso");
    	types[FC].put("Near surface faceted particles","FCsf" );
    	types[FC].put("Rounding faceted particles","FCxr" );
        
        types[DH] = new GrainTypeSet("DH", 5);
        types[DH].put("Hollow cups", "DHcp");
  	types[DH].put("Hollow prisms", "DHpr");
    	types[DH].put("Chains of depth hoar", "DHch");
    	types[DH].put("Large striated crystals", "DHla");
    	types[DH].put("Rounding depth hoar", "DHxr");
        
        types[SH] = new GrainTypeSet("SH", 3);
        types[SH].put("Surface hoar crystals", "SHsu");
  	types[SH].put("Cavity or crevasse hoar", "SHcv");
  	types[SH].put("Rounding surface hoar", "SHxr");
        
        types[MF] = new GrainTypeSet("MF", 4);
        types[MF].put("Clustered rounded grains", "MFcl");
    	types[MF].put("Rounded polycrystals", "MFpc");
    	types[MF].put("Slush", "MFsl");
    	types[MF].put("Melt-freeze crust", "MFcr");
        
        types[IF] = new GrainTypeSet("IF", 5);
        types[IF].put("Ice layer", "IFil");
  	types[IF].put("Ice column", "IFic");
  	types[IF].put("Basal ice", "IFbi");
    	types[IF].put("Rain crust", "IFrc");
    	types[IF].put("Sun crust", "IFsc");
        
        types[MM] = new GrainTypeSet("MM", 2);
        types[MM].put("Round polycrystalline particles", "MMrp");
        types[MM].put("Crushed ice particles", "MMci");
    	
    	lwc.put("Dry", "D");
    	lwc.put("Moist", "M");
    	lwc.put("Wet", "W");
    	lwc.put("Very Wet", "U");
        
    }
    
    public String getUITypeFromCode(String code)
    {
        code = code.trim();
        if (code.length() < 2) return " ";
        int bti = getArrayIndexFromBasicType(code);
        String s = null;
        if (bti > -1) s = basicTypes[bti];
        if (s==null) System.out.println("s is null!");
        else return s;
       
        String bt = code.substring(0, 2);
        bti = getArrayIndexFromBasicType(bt);
  
        if ( bti > -1 ) s = types[bti].getDescription(code);
        if (s==null) System.out.println("s is null!");
        else return s;
        
        return " ";
    }
    
    public String getSubTypeCode(String uitype)
    {
        uitype = uitype.trim();
        for (int i=0; i<numberOfTypes; i++)
        {
            if (basicTypes[i].equals(uitype)) return basicTypeCodes[i];
        }
        
        for (int i=0; i<numberOfTypes; i++)
        {
            String s = types[i].getCode(uitype);
            if ( s!= null) return s;
        }
        return "";
    }
    
    public String[] getSubTypesArray(String bType)
    {
        bType = bType.trim();
        int idx = getArrayIndexFromBasicType(bType);
        
        String[] stypes = types[idx].getCodes();
        String[] uiTypes = new String[stypes.length+3];
        
        uiTypes[0] = " ";
        uiTypes[1] = basicTypeCodes[idx];
        uiTypes[2] = " ";
        
        for (int ii = 3; ii < uiTypes.length; ii++)
        {
            uiTypes[ii] = stypes[ii-3];
        }
        return uiTypes;
    }
    
    public int getArrayIndexFromBasicType(String bType)
    {
        bType = bType.trim();
        for (int i = 0; i < basicTypeCodes.length; i++)
        {
            if (bType.equals(basicTypeCodes[i])) return i;
        }
        return -1;
    }
    
    public String getCAAMLType(String grainType)
    {
    	return getSubTypeCode(grainType);
    }
    
    public String getLWC(String splwc)
    {
    	String s = lwc.get(splwc);
    	if (s==null) s="unknown";
    	return s;
    }
    
    class GrainTypeSet
    {
        public String basicType;
        public String[][] codes_desc;
        int idx=0;
        int size = 1;
        
        private GrainTypeSet(){}
        
        public GrainTypeSet(String bCode, int sz)
        {
           size=sz;
           basicType = bCode;
           codes_desc = new String[2][size];
        }
        
        public void put(String code, String desc)
        {
            if (idx < size)
            {
                codes_desc[0][idx] = code;
                codes_desc[1][idx] = desc;
                idx++;
            }
        }
        
        public String[] getCodes()
        {
            return codes_desc[1];
        }
        
        public String[] getDescriptions()
        {
            return codes_desc[0];
        }
        
        public String getCode(String description)
        {
            for (int i = 0; i < idx; i++)
            {
                if ( description.equals(codes_desc[0][i])) return codes_desc[1][i];
            }
            return null;
        }
        
        public String getDescription(String code)
        {
            for (int i = 0; i < idx; i++)
            {
                if ( code.equals(codes_desc[1][i])) return codes_desc[0][i];
            }
            return null;
        }
        
    }
}