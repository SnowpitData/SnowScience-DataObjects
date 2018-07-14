package avscience.ppc;

import java.util.*;
import java.io.*;
import avscience.wba.DensityProfile;
import avscience.wba.TempProfile;
import org.jdom.*;
import org.jdom.output.*;

public class XMLWriter 
{
    public XMLWriter(){}
    public String getXMLString(avscience.ppc.AvScienceDataObject obj)
    {
	Element e = getElementFromObject(obj);
	Document doc = new Document(e);
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	try
	{
            return outputter.outputString(doc);
	}
	catch(Exception ex)
	{
            System.out.println(ex.toString());
	}
        return null;
    }
    
    public void writeToXML(avscience.ppc.PitObs pit, File f)
  	{
                Sorter.sortPit(pit);
		Document doc = getDocumentFromPit(pit);
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		try
		{
                   outputter.output(doc, new FileOutputStream(f));
		}
		catch(Exception ex)
		{
                    System.out.println(ex.toString());
		}
  	}
    
        public char[] getXML(avscience.ppc.PitObs pit)
        {
            CharArrayWriter cwriter = new CharArrayWriter(8400);
            Sorter.sortPit(pit);
            System.out.println("writePitToXML");
            
	    Document doc = getDocumentFromPit(pit);
	    XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		try
		{
			outputter.output(doc, cwriter);
                        return cwriter.toCharArray();
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
                return null;
        }
  	
  	Element addProfileFromTable(Hashtable table, Element el)
  	{
  		Enumeration e = table.keys();
  		StringBuffer buffer = new StringBuffer();
  		while (e.hasMoreElements())
  		{
  			Object o = e.nextElement();
  			buffer.append(o);
  			buffer.append("_");
  			Object oo = table.get(o);
  			buffer.append(oo);
  			buffer.append(";");
  			
  		}
  		String s = buffer.toString();
  		String ss = s.substring(0, s.length()-1);
  		Attribute a = new Attribute("profile", ss);
  		el.setAttribute(a);
  		return el;
  	}
        
        public Document getDocumentFromPit(PitObs pit)
        {
            System.out.println("getDocumentFromPit");
           // Sorter.sortPit(pit);
            Element e = new Element("Pit_Observation");
            Iterator<String> en = pit.keys();
  
            while ( en.hasNext())
            {
                try
                {
                    String key = en.next();
                    Object o = pit.get(key);
                    if ( o instanceof String )
                    {
                        String s = o.toString();
                        if (!((key.equals("loc")) | (key.equals("user")) | (key.equals("prefs")) | (key.equals("tempProfile")) | (key.equals("densityProfile"))))
                        {
                            Attribute a = new Attribute(key, s);
                            e.setAttribute(a);
                        }
                        
                    }
                    
                }
                catch(Exception ex)
                {
                    System.out.println(ex.toString());
                }
            }
            
            String acts = pit.getActivitiesString();
            Attribute a = new Attribute("activities", acts);
            e.setAttribute(a);
            
            Location l = pit.getLocation();
            Element eloc =  getElementFromObject(l);
            e.addContent(eloc);
            
            Preferences prefs = pit.getPrefs();
            Element eu = getElementFromObject(prefs);
            e.addContent(eu);
            
            Enumeration layers = pit.getLayers();
            
            while (layers.hasMoreElements())
            {
                Layer layer = (Layer) layers.nextElement();
                Element elayer = getElementFromObject(layer);
                e.addContent(elayer);
            }
            
            Enumeration tests = pit.getShearTests();
            
            while (tests.hasMoreElements())
            {
                ShearTestResult test = (ShearTestResult) tests.nextElement();
                Element etest = getElementFromObject(test);
                e.addContent(etest);
            }
            
            Element rhoPro = new Element("Density_Profile");
            
            DensityProfile rhop = pit.getDensityProfile();
            rhop.writeAttributes();
            Attribute rhou = new Attribute("rhoUnits", rhop.getDensityUnits());
            rhoPro.setAttribute(rhou);
            Attribute du = new Attribute("depthUnits", rhop.getDepthUnits());
            rhoPro.setAttribute(du);
            try
            {
                Attribute pdata = new Attribute("profile", (String) rhop.get("profile"));
                rhoPro.setAttribute(pdata);
            }
            catch(Exception ee)
            {
                System.out.println(ee.toString());
            }
            e.addContent(rhoPro);
            
            /////////////
            
            Element tPro = new Element("Temperature_Profile");
            
            TempProfile tp = pit.getTempProfile();
            tp.writeAttributes();
            Attribute tu = new Attribute("tempUnits", tp.getTempUnits());
            tPro.setAttribute(tu);
            Attribute tdu = new Attribute("depthUnits", tp.getDepthUnits());
            tPro.setAttribute(tdu);
            try
            {
                Attribute pdata = new Attribute("profile", tp.getString("profile"));
                tPro.setAttribute(pdata);
            }
            catch(Exception ee)
            {
                System.out.println(ee.toString());
            }
            e.addContent(tPro);
            
            Document doc = new Document(e);
            return doc;
        }
  	
  	public Element getElementFromObject(avscience.ppc.AvScienceDataObject oo)
	{
		System.out.println("getElementFromObject");
		oo.writeAttributes();
		Element e = new Element(oo.getClass().getSimpleName());
                
		Iterator en = oo.keys();
		while ( en.hasNext())
		{
                    try
                    {
                        String att = en.next().toString();
                        System.out.println("att: "+att);
                        Attribute a = new Attribute(att, oo.getString(att));
                        e.setAttribute(a);
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.toString());
                    }
			
		}
		return e;
	}
}