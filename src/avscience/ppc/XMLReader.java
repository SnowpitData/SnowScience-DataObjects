/**
 * @(#)XMLReader.java
 *
 *
 * @author 
 * @version 1.00 2009/6/23
 */
 
package avscience.ppc;

import java.util.*;
import java.io.*;
import avscience.wba.*;
import org.jdom.*;
import org.jdom.input.*;

public class XMLReader 
{
    public avscience.ppc.PitObs pit;
    Document doc;
    public XMLReader() 
    {
    }
    
    public static void main(String[] args)
    {
    	new XMLReader().run();
    }
    
    public void run()
    {
        PitObs thepit = getPit(new File("/Users/mark/desktop/ChalfantValley.xml"));
    	String name = thepit.getName();
        System.out.println("PitName: "+name);
        int bld = thepit.getBuild();
        System.out.println("Build: "+bld);
        String ser = thepit.getSerial();
    	System.out.println("SERIAL: "+ser);
        
        File outfile = new File("/Users/mark/desktop/OutTest.xml");
        XMLWriter writer = new XMLWriter();
        writer.writeToXML(pit, outfile);
    }
    
    public PitObs getPit(File file)
    {
    	loadFile(file);
    	popPit();
    	return pit;
    }
    
    private void mapSCandPrecip()
    {
    	String sky1 = pit.getSky();
    	if ( sky1!=null )
    	{
    		String sky2 = SkyCover.getInstance().getDescription(sky1);
    		if ( sky2!=null) pit.setSky(sky2);																	
    	}
    	
    	String precip1 = pit.getPrecip();
    	if ( precip1!=null )
    	{
    		String precip2 = Precipitation.getInstance().getDescription(precip1);
    		if ( precip2!=null)
    		{
    			 precip2 = precip2.trim();
    			 if (precip2.length()>0)
    			 {
    			 	pit.setPrecip(precip2);
    			 }
    		}																	
    	}
    	
    	
    }
   
    public PitObs getPitFromDoc(Document doc)
    {
        this.doc = doc;
        popPit();
        return pit;
    }
    
    public void loadFile(File file)
    {
    	try
    	{
    		SAXBuilder builder = new SAXBuilder();
    		doc = builder.build(file);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
    
    void loadFile(String filename)
    {
    	System.out.println("loadFile");
    	File file = null;
    	
    	try
    	{
    		file = new File(filename);
    		SAXBuilder builder = new SAXBuilder();
    		doc = builder.build(file);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
    
    void printElement(Element e)
    {
    	System.out.println("Element Name: "+e.getName());
    	System.out.println("Element Text: "+e.getText());
    	Namespace nmspc = e.getNamespace();
    	System.out.println("Namespace: "+nmspc.getPrefix()+":"+nmspc.getURI());
    	
    	Iterator<Element> els = e.getChildren().iterator();
    	
    	while ( els.hasNext())
    	{
    		Element ee = els.next();
    		printElement(ee);
    	}
    	
    	List<Attribute> atts = e.getAttributes();
    	
    	System.out.println("Attributes");
    	
    	Iterator<Attribute> ii = atts.iterator();
    	while ( ii.hasNext() )
    	{
    		Attribute a = ii.next();
    		System.out.println(a.getName()+" - "+a.getValue());
    	}
    	
    	
    }
    	
    void traverseDoc()
    {
    	Element root = doc.getRootElement();
    	
    	List<Element> elements = root.getChildren();
    	
    	Iterator<Element> i = elements.iterator();
    	while ( i.hasNext() )
    	{
    		Element e = i.next();
    		printElement(e);
    	}
    }
    
    void popPit()
    {
    	System.out.println("popPit()");
    	avscience.ppc.User user = new avscience.ppc.User();
        user.writeAttributes();
    	pit = new PitObs();
        pit.writeAttributes();
    	
    	Element root = doc.getRootElement();
    	
    	List<Attribute> atts = root.getAttributes();
    	Iterator<Attribute> it = atts.iterator();
    	while (it.hasNext())
    	{
    		Attribute a = it.next();
    		String s = a.getValue();
    		if (s==null)s="";
                try
                {
                    System.out.println("Setting pit param: "+a.getName()+" to value: "+s);
                    pit.put(a.getName(),s);
                }
                catch(Exception e)
                {
                    System.out.println(e.toString());
                }
    		
    	}
    	pit.popAttributes();
    	List<Element> elements = root.getChildren();
    	Iterator<Element> els = elements.iterator();
    	
    	while (els.hasNext())
    	{
    		Element el = els.next();
    		String name = el.getName();
    		System.out.println("Name: "+name);
    		if (name.equals("User"))
    		{
    			
    			List<Attribute> uatts = el.getAttributes();
    			Iterator<Attribute> uit = uatts.iterator();
    			while ( uit.hasNext() )
    			{
    				Attribute a = uit.next();
    				String s = a.getValue();
    				if (s==null)s="";
                                try
                                {
                                    System.out.println("Setting "+name+" param: "+a.getName()+" to value: "+s);
                                    user.put(a.getName(),s);
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e.toString());
                                }
    				
    			}
    			user.popAttributes();
    			pit.setUser(user);
    		}
    		/////////
    		if (name.equals("Location"))
    		{
    			avscience.ppc.Location loc = new avscience.ppc.Location();
                        loc.writeAttributes();
    			List<Attribute> uatts = el.getAttributes();
    			Iterator<Attribute> uit = uatts.iterator();
    			while ( uit.hasNext() )
    			{
    				Attribute a = uit.next();
    				String s = a.getValue();
    				if (s==null)s="";
                                try
                                {
                                    loc.put(a.getName(),s);
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e.toString());
                                }
    			}
    			
    			loc.popAttributes();
    			pit.setLocation(loc);
    		}
    		
    		if (name.equals("Layer"))
    		{
    			avscience.ppc.Layer layer = new avscience.ppc.Layer();
                        layer.writeAttributes();
    			List<Attribute> uatts = el.getAttributes();
    			Iterator<Attribute> uit = uatts.iterator();
    			while ( uit.hasNext() )
    			{
    				Attribute a = uit.next();
    				String s = a.getValue();
    				if (s==null)s="";
                                try
                                {
                                    layer.put(a.getName(),s);
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e.toString());
                                }
    				
    			}
    			layer.popAttributes();
    			if (layer.getFromTop()) layer.swapHardness();
    			pit.addLayer(layer);
    		}
    		
    		if ((name.equals("Shear_Test_Result")) | (name.equals("ShearTestResult")))
    		{
    			avscience.ppc.ShearTestResult result = new avscience.ppc.ShearTestResult();
                        result.writeAttributes();
    			List<Attribute> uatts = el.getAttributes();
    			Iterator<Attribute> uit = uatts.iterator();
    			while ( uit.hasNext() )
    			{
    				Attribute a = uit.next();
    				String s = a.getValue();
    				if (s==null)s="";
                                try
                                {
                                    result.put(a.getName(),s);
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e.toString());
                                }
    			}
    			result.popAttributes();
    			pit.addShearTestResult(result);
    		}
    		if (name.equals("Temperature_Profile"))
    		{
    			System.out.println("getting Temperature_Profile");
    			Attribute tu = el.getAttribute("tempUnits");
    			Attribute du = el.getAttribute("depthUnits");
                        System.out.println("temp units: "+tu.toString());
    			if (( tu!=null ) && ( du!=null ))
    			{
    				TempProfile tp = new TempProfile(tu.getValue(), du.getValue());
                                //tp.writeAttributes();
	    			Attribute prof = el.getAttribute("profile");
	    			if ( prof!=null)
	    			{
	    				String s = prof.getValue();
	    				System.out.println("profile: "+s);
	    				if ( s!=null )
	    				{
	    					s=s.trim();
	    					String[] points = s.split(";");
	    					System.out.println("Number of points: "+points.length);
			    			for ( int i = 0; i<points.length; i++)
			    			{
			    				String[] point = points[i].split("_");
			    				if (point.length>1)
			    				{
			    					int depth = new Integer(point[0]).intValue();
			    					tp.addPoint(depth, point[1]);
			    				}
			    				
			    			}
	    				}
	    				else s="";
		    			
	    			}
	    			pit.setTempProfile(tp);
    			}
    		}
    		if (name.equals("Density_Profile"))
    		{
    			System.out.println("Density_Profile");
    			Attribute tu = el.getAttribute("rhoUnits");
    			Attribute du = el.getAttribute("depthUnits");
    			if (( tu!=null ) && ( du!=null ))
    			{
    				DensityProfile tp = new DensityProfile(tu.getValue(), du.getValue());
                              ///  tp.writeAttributes();
	    			Attribute prof = el.getAttribute("profile");
	    			if ( prof!=null)
	    			{
	    				String s = prof.getValue();
	    				System.out.println("profile: "+s);
	    				if ( s!=null )
	    				{
	    					String[] points = s.split(";");
	    					System.out.println("Number of points: "+points.length);
			    			for ( int i = 0; i<points.length; i++)
			    			{
			    				String[] point = points[i].split("_");
			    				if (point.length>1)
			    				{
			    					int depth = new Integer(point[0]).intValue();
			    					tp.addPoint(depth, point[1]);
			    				}
			    				
			    			}
	    				}
	    				else s="";
		    			
	    			}
	    			pit.setDensityProfile(tp);
    			}
    		}
    	    if (pit.getTempProfile()==null) pit.setTempProfile(new TempProfile());
            if (pit.getDensityProfile()==null)pit.setDensityProfile(new DensityProfile());
            if (pit.version.contains("PitPod")) mapSCandPrecip();
    		////////
    	}
        System.out.println("POP pit complete!");
        String name = pit.getName();
        System.out.println("PitName: "+name);
        int bld = pit.getBuild();
        System.out.println("Build: "+bld);
        String ser = pit.getSerial();
    	System.out.println("SERIAL: "+ser);
    }
    
}