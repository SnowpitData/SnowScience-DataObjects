     package avscience.wba;

     import java.util.Hashtable;
     
     public final class SkyCover implements DataTable 
     {
            private static final SkyCover instance = new SkyCover();
            private String[] codes;
            private String[] descriptions;
            private String[] shortCodes;
            private int size = 6;
            private Hashtable codesDesc = new Hashtable(size);

            public static SkyCover getInstance()
            {
                return instance;
            }

           private SkyCover()
           {
             init();
           }

           private void init()
           {
             codes = new String[size];
             descriptions = new String[size];
             shortCodes = new String[size];
 
             codes[0] = "Clear";
             descriptions[0] = "Clear";
             shortCodes[0] = "CLR";
	     codesDesc.put(shortCodes[0], descriptions[0]);
 
             codes[1] = "Few";
             descriptions[1] = "sky < 2/8 covered";
             shortCodes[1] = "FEW";
	     codesDesc.put(shortCodes[1], descriptions[1]);
 
             codes[2] = "Scattered";
             descriptions[2] = "sky 3/8 to 4/8 covered";
             shortCodes[2] = "SCT";
             codesDesc.put(shortCodes[2], descriptions[2]);
 
             codes[3] = "Broken";
             descriptions[3] = "sky 4/8 to 8/8 covered";
             shortCodes[3] = "BKN";
	     codesDesc.put(shortCodes[3], descriptions[3]);

             codes[4] = "Overcast";
             descriptions[4] = "sky 8/8 covered";
             shortCodes[4] = "OVC";
	     codesDesc.put(shortCodes[4], descriptions[4]);
 
             codes[5] = "Obscured";
             descriptions[5] = "Fog";
             shortCodes[5] = "X";
             codesDesc.put(shortCodes[5], descriptions[5]);
          }
 
            public String[] getCodes()
            {
                return this.codes;
            }
 
            public String[] getDescriptions()
            {
                return descriptions;
            }
            
           public String getCode(int i)
           {
               return codes[i];
           }
           
           public String getShortCode(int i)
           {
               if (i < 0) return "";
               return shortCodes[i];
           }
			
	   public String getDescription(String code)
	   {
		Object o = codesDesc.get(code);
		if (o!=null)return o.toString();
		else return null;
	    }
 }
