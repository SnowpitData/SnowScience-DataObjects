 package avscience.wba;

import java.util.Hashtable;
 
 public final class Precipitation
  {
    private static final Precipitation instance = new Precipitation();
    private String[] codes;
    private String[] descriptions;
    private int size = 13;
    private Hashtable codesDesc = new Hashtable(size);
 
   public static Precipitation getInstance()
   {
        return instance;
    }

   private Precipitation()
   {
        init();
   }
 
   private void init()
   {
        codes = new String[size];
        descriptions = new String[size];

        codes[0] = " ";
        descriptions[0] = " ";
        codesDesc.put(codes[0], descriptions[0]);
        
        codes[1] = "NIL";
        descriptions[1] = "None";
	codesDesc.put(codes[1], descriptions[1]); 
        
        codes[2] = "S-1";
        descriptions[2] = "Snow < 0.5 cm/hr";
	codesDesc.put(codes[2], descriptions[2]); 
        
        codes[3] = "S1";
        descriptions[3] = "Snow - 1 cm/hr";
        codesDesc.put(codes[3], descriptions[3]);

        codes[4] = "S2";
        descriptions[4] = "Snow - 2 cm/hr";
	codesDesc.put(codes[4], descriptions[4]);
 
        codes[5] = "S5";
        descriptions[5] = "Snow - 5 cm/hr";
	codesDesc.put(codes[5], descriptions[5]);
 
        codes[6] = "S10";
        descriptions[6] = "Snow - 10 cm/hr";
	codesDesc.put(codes[6], descriptions[6]);
        
        codes[7] = "G";
        descriptions[7] = "Graupel or hail";
        codesDesc.put(codes[7], descriptions[7]);
        
        codes[8] = "RS";
        descriptions[8] = "Mixed rain and snow";
        codesDesc.put(codes[8], descriptions[8]); 
        
        codes[9] = "RV";
        descriptions[9] = "Very light rain - mist";
        codesDesc.put(codes[9], descriptions[9]);
 
        codes[10] = "RL";
        descriptions[10] = "Light Rain < 2.5mm/hr";
	codesDesc.put(codes[10], descriptions[10]);
        
        codes[11] = "RM";
        descriptions[11] = "Moderate rain < 7.5mm/hr";
	codesDesc.put(codes[11], descriptions[11]);
 
        codes[12] = "RH";
        descriptions[12] = "Heavy Rain > 7.5mm/hr";
	codesDesc.put(codes[12], descriptions[12]);
   }

  public String[] getCodes()
   {
     return this.codes;
  }

  public String[] getDescriptions()
   {
        return this.descriptions;
    }

    public String getDescription(String code )
    {
	code = code.trim();
	Object o = codesDesc.get(code);
	if (o!=null) return o.toString();
	else return null;
    }
 }
