package avscience.wba;
import java.util.*;

public final class ShearTests extends Hashtable 
{
     private static final ShearTests instance  = new ShearTests();
     private String[] codes;
     private Hashtable Codes = new Hashtable();
     
      /** To use this class as a singleton class this method should be called.
    * @return An object variable reference to the singleton class.
    */

    public static   ShearTests getInstance()
    {
	return instance;
    }

    private ShearTests()
    {
        init();
    }
    
    public String[] getShearTestDescriptions()
    {
        String[] descs = new String[this.size()];
        
        int i = 0;
        Enumeration Descs = this.keys();
        while ( Descs.hasMoreElements() )
        {
            String s = (String) Descs.nextElement();
            descs[i] = s;
            i++;
        }
        return descs;
    }
    
    public AbstractShearTest getShearTest(String description)
    {
        return (AbstractShearTest) get(description); 
    }
    
    public AbstractShearTest getShearTestByCode(String code)
    {
        return (AbstractShearTest) Codes.get(code); 
    }
    
    public String getCode(String desc)
    {
    	AbstractShearTest test = getShearTest(desc);
    	return test.getTypeCode();
    }
    
    private void init()
    {
        put("Compression Test", CompressionTest.getInstance());
        put("Deep Tap Test", DeepTapTest.getInstance());
        put("Rutschblock Test", RutschblockTest.getInstance());
        put("Shovel Shear Test", ShovelShearTest.getInstance());
        put("Stuffblock Test", StuffblockTest.getInstance());
        put("Extended Column Test", ExtendedColumnTest.getInstance());
        
        Codes.put(CompressionTest.getInstance().getTypeCode(), CompressionTest.getInstance());
        Codes.put(DeepTapTest.getInstance().getTypeCode(), DeepTapTest.getInstance());
        Codes.put(RutschblockTest.getInstance().getTypeCode(), RutschblockTest.getInstance());
        Codes.put(ShovelShearTest.getInstance().getTypeCode(), ShovelShearTest.getInstance());
        Codes.put(StuffblockTest.getInstance().getTypeCode(), StuffblockTest.getInstance());
        Codes.put(ExtendedColumnTest.getInstance().getTypeCode(), ExtendedColumnTest.getInstance());
      
    }
}