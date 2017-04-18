/**
 * @(#)CAAMLWriter.java
 *
 *
 * @author Mark KAHRL
 * @version 1.00 2009/8/20
 */
package avscience.ppc;

import org.jdom.*;
import org.jdom.output.*;
import org.jdom.input.*;
import org.jdom.filter.*;
import java.io.*;
import java.net.*;
import java.util.*;
import avscience.ppc.*;
import avscience.wba.*;

public class CAAMLWriter 
{
	final static String baseFile = "http://www.kahrlconsulting.com/BaseCAAML.xml";
	Namespace caaml = Namespace.getNamespace("caaml", "http://caaml.org/Schemas/V5.0/Profiles/SnowProfileIACS ");
	Namespace gml = Namespace.getNamespace("gml", "http://www.opengis.net/gml");
	Element layerRoot;// root for layers and tests.
	Element root;
	Document doc;
	File file;
        ShearTests shearTests = ShearTests.getInstance();
    
    public CAAMLWriter() 
    {
    	XMLReader reader = new XMLReader();
    	reader.run();
    	PitObs pit = reader.pit;
    	writePitToCAAML(pit);
    }
    
    public CAAMLWriter(PitObs pit, File f)
    {
    	this.file=f;
    	writePitToCAAML(pit);
    }
    public static void main(String[] args)
    {
    	new CAAMLWriter();//.writePitToCAAML(null);
    }
    
    public void writePitToCAAML(avscience.ppc.PitObs pit)
    {
    	if (pit==null) 
    	{
            System.out.println("pit is NULL.");
            return;
    	}
    	pit = Sorter.sortPit(pit);
    	loadBaseDoc();
    	root = doc.getRootElement();
    	ElementFilter filter = new ElementFilter("dateTimeReport");
    	Iterator<Element> result = root.getDescendants(filter);
    	Element dateTime  = result.next();
   	if (dateTime!=null) if (pit!=null) dateTime.setText(getIsoDate(new Date(pit.getTimestamp())));
   		
   	ElementFilter filter1 = new ElementFilter("timePosition");
    	Iterator<Element> result1 = root.getDescendants(filter1);
    	Element timePos  = result1.next();
   	if (timePos!=null) if (pit!=null) timePos.setText(getIsoDateTime(new Date(pit.getTimestamp())));//(new Date(pit.getTimestamp()).toString());
   		
   	ElementFilter spFilter = new ElementFilter("SnowProfileMeasurements");
    	Iterator<Element> spResults = root.getDescendants(spFilter);
    	Element snowProfile = spResults.next();
        
        ////////////
        String measureFrom = pit.getMeasureFrom();
	String tb = "top down";
	/////if ( measureFrom.equals("bottom") )  tb = "top down";/// to support back assword SnowPiz
	Attribute a = new Attribute("dir", tb);
	snowProfile.setAttribute(a);
        //////////
    	if ( snowProfile==null )
    	{
    		System.out.println("Snow Profile is NULL !!!!!!!!!");
    	}
    	else System.out.println("Got Snow Profile.");
    	
    	setPitInfo(pit, snowProfile);
    	addLayers(pit, snowProfile);
    	addTests(pit, snowProfile);
      //  setActsAndNotes(pit);
    	setLocation(pit, root);
        setPersonInfo(pit, root);
        addTempProfile(pit, root);
        addRhoProfile(pit, root);
    	writeCAAMLToFile();
    }
    
    void addRhoProfile(avscience.ppc.PitObs pit, Element root)
    {
    	ElementFilter rFilter = new ElementFilter("densityProfile"); 
    	Iterator<Element> rit = root.getDescendants(rFilter);
    	Element rhoProfile = rit.next();
    	
    	Attribute dpthUnits = new Attribute("uomDepthTop", pit.getUser().getDepthUnits());
	Attribute thkUnits = new Attribute("uomThickness", pit.getUser().getDepthUnits());
	Attribute rhoUnits = new Attribute("uomDensity", "kgm-3");
		
	rhoProfile.setAttribute(dpthUnits);
	rhoProfile.setAttribute(thkUnits);
		
	ElementFilter lFilter = new ElementFilter("Layer"); 
    	Iterator<Element> lit = rhoProfile.getDescendants(lFilter);
    	Element  llayer = lit.next();
    	
    	Element baseLayer = (Element) llayer.clone();
    	rhoProfile.removeContent(baseLayer);
    	
    	if ( pit.hasLayers())
        {
	        java.util.Enumeration e = pit.getLayers();
	        if ( e!=null )
	        {
		        while ( e.hasMoreElements() )
		        {
		            avscience.ppc.Layer l = (avscience.ppc.Layer) e.nextElement();
		            Element layer = (Element) baseLayer.clone();
		            ElementFilter dt = new ElementFilter("depthTop");
		            Iterator<Element> dti = layer.getDescendants(dt);
		            Element top = dti.next();
		            
                            ElementFilter thkf = new ElementFilter("thickness");
                            Iterator<Element> thki = layer.getDescendants(thkf);
                            Element thicknss = thki.next();
                            thicknss.setText(l.getThickness()+"");
					
                            ElementFilter rhof = new ElementFilter("density");
                            Iterator<Element> rhoi = layer.getDescendants(rhof);
                            Element rho = rhoi.next();
                            rho.setText(l.getDensity()+"");
		        }
	        }
        }
    }
    
    void setPersonInfo(avscience.ppc.PitObs pit, Element root)
    {
    	ElementFilter cpFilter = new ElementFilter("contactPerson");
    	Iterator<Element> cpi = root.getDescendants(cpFilter);
    	Element cp = cpi.next();
    	
    	ElementFilter pFilter = new ElementFilter("Person");
    	Iterator<Element> pi = cp.getDescendants(pFilter);
    	Element person = pi.next();
    	
    	ElementFilter nameFilter = new ElementFilter("name");
    	Iterator<Element> ni = person.getDescendants(nameFilter);
    	Element name = ni.next();
    	name.setText(pit.getUser().getFirst()+" "+pit.getUser().getLast());
    }
    
    // set Location Info
    public void setLocation(avscience.ppc.PitObs pit, Element snowProfile)
    {
    	ElementFilter filter = new ElementFilter("locRef");
    	Iterator<Element> result = snowProfile.getDescendants(filter);
    	Element e  = result.next();
    	
    	ElementFilter obsPoint = new ElementFilter("ObsPoint");
    	Iterator<Element> obsr = e.getDescendants(obsPoint);
    	Element oPoint  = obsr.next();
    	
        ElementFilter nFilter = new ElementFilter("name");
    	Iterator<Element> iname = oPoint.getDescendants(nFilter);
    	Element name  = iname.next();
    	name.setText(pit.getLocation().getName());
    	
    	ElementFilter elvFilter = new ElementFilter("validElevation");
    	Iterator<Element> elvit = oPoint.getDescendants(elvFilter);
    	Element velv = elvit.next();
    	
    	ElementFilter elvposFilter = new ElementFilter("ElevationPosition");
    	Iterator<Element> elvitp = velv.getDescendants(elvposFilter);
    	Element elvPos = elvitp.next();
    	
    	Attribute a = new Attribute("uom", pit.getUser().getElvUnits());
    	elvPos.setAttribute(a);
    	
    	ElementFilter posFilter = new ElementFilter("position");
    	Iterator<Element> posit = elvPos.getDescendants(posFilter);
    	Element pos = posit.next();
    	pos.setText(pit.getLocation().getElv());
    	
    	ElementFilter vaspFilter = new ElementFilter("validAspect");
    	Iterator<Element> vaspI = oPoint.getDescendants(vaspFilter);
    	Element validAspect = vaspI.next();
    	
    	ElementFilter aspposFilter = new ElementFilter("AspectPosition");
    	Iterator<Element> aspposI = validAspect.getDescendants(aspposFilter);
    	Element aspectPos = aspposI.next();
    	
    	ElementFilter aposFilter = new ElementFilter("position");
    	Iterator<Element> aposI = aspectPos.getDescendants(aposFilter);
    	Element aaPos = aposI.next();
    	try
    	{
    		java.lang.Integer iaspect = new java.lang.Integer(pit.getAspect());
    		int ai = iaspect.intValue();
    		String sa = getAspectCat(ai);
    		aaPos.setText(sa);
    	}
    	catch(Exception exp)
    	{
    		System.out.println(exp.toString());
    	}
    	
    	ElementFilter vslopeFilter = new ElementFilter("validSlopeAngle");
    	Iterator<Element> vslopeI = oPoint.getDescendants(vslopeFilter);
    	Element vSlope = vslopeI.next();
    	
    	ElementFilter sapFilter = new ElementFilter("SlopeAnglePosition");
    	Iterator<Element> sapi = vSlope.getDescendants(sapFilter);
    	Element sap = sapi.next();
    	
    	ElementFilter sapposFilter = new ElementFilter("position");
    	Iterator<Element> sapposI = sap.getDescendants(sapposFilter);
    	Element slopeAngle = sapposI.next();
    	slopeAngle.setText(pit.getIncline());
    	
    	ElementFilter pointLocFilter = new ElementFilter("pointLocation");
    	Iterator<Element> pointLocI = oPoint.getDescendants(pointLocFilter);
    	Element ploc = pointLocI.next();
        
        ElementFilter gmlPonFilter = new ElementFilter("Point", gml);
    	Iterator<Element> gmlPonI = ploc.getDescendants(gmlPonFilter);
    	Element gmlpon = gmlPonI.next();
        gmlpon.setAttribute("srsDimension", "1");
    	
    	ElementFilter gmlPosFilter = new ElementFilter("pos", gml);
    	Iterator<Element> gmlPosI = gmlpon.getDescendants(gmlPosFilter);
    	Element gmlpos = gmlPosI.next();
    	gmlpos.setText(pit.getLocation().getLongitude()+" "+pit.getLocation().getLat());
    }
    
    public void setPitInfo(avscience.ppc.PitObs pit, Element snowProfile)
    {
    	
    	ElementFilter filter = new ElementFilter("AspectPosition");
    	Iterator<Element> aPos = snowProfile.getDescendants(filter);
    	Element asPos = aPos.next();
    	if ( asPos != null )
    	{
    		ElementFilter apf = new ElementFilter("position");
    		Iterator<Element> pos = asPos.getDescendants(apf);
    		Element e = pos.next();
    		if (e!=null)
    		{
    			int aspect =-1;
	    		try
	    		{
	    			aspect = new java.lang.Integer(pit.getAspect()).intValue();
	    		}
	    		catch(Exception ee){}
	    		e.setText(getAspectCat(aspect));
    		}
    	}
    	//sky
    	ElementFilter ffilter = new ElementFilter("skyCond");
    	Iterator<Element> result = snowProfile.getDescendants(ffilter);
    	Element e = result.next();
    	if ( e!=null )
    	{
            String sc = getSkyCondition(pit.getSky());
            e.setText(sc);
    	}
        
        /////////////////////////////////
        filter = new ElementFilter("profileDepth");
    	result = snowProfile.getDescendants(filter);
    	e  = result.next();
    	if ( e!=null )
    	{
    		Attribute a = new Attribute("uom", pit.getUser().getDepthUnits());
    		e.setAttribute(a);
                String mds = new Integer(getMaxDepth(pit)).toString();
                System.out.println("MAX DEPTH::: "+mds);
    		e.setText((mds));
    	}
        ///////////////////////////
    	filter = new ElementFilter("precipTI");
    	result = snowProfile.getDescendants(filter);
    	e = result.next();
    	if ( e!=null )
    	{
            String sc = getSkyCondition(pit.getSky());
            e.setText(sc);
    	}
    	// airTemp
    	filter = new ElementFilter("airTempPres");
    	result = snowProfile.getDescendants(filter);
    	e  = result.next();
    	if ( e!=null )
    	{
            Attribute a = new Attribute("uom", "deg"+pit.getUser().getTempUnits());
            e.setAttribute(a);
            e.setText(pit.getAirTemp());
    	}
    	
    		/// wind speed
    	filter = new ElementFilter("windSpd");
    	result = snowProfile.getDescendants(filter);
    	e  = result.next();
    	if ( e!=null )
    	{
            Attribute a = new Attribute("uom", "mph");
            e.setAttribute(a);
            e.setText(getWindspeedMPH(pit.getWindspeed()));
    	}
    	
    		/// wind dir
    	filter = new ElementFilter("windDir");
    	result = snowProfile.getDescendants(filter);
        Element wd = result.next();
        ElementFilter aFilter = new ElementFilter("AspectPosition");
        result = wd.getDescendants(aFilter);
        Element aspectPos = result.next();
    	
    	if ( aspectPos != null )
    	{
            ElementFilter apf = new ElementFilter("position");
            Iterator<Element> pos = aspectPos.getDescendants(apf);
            Element ee = pos.next(); 
            if (ee!=null)
            {
                int windDir = getWindDirAzi(pit.getWinDir());
                ee.setText(windDir+"");
                    
            }
         }
               
    		/// snow height
    	filter = new ElementFilter("snowHeight");
    	result = snowProfile.getDescendants(filter);
    	e  = result.next();
    	if ( e!=null )
    	{
            Attribute a = new Attribute("uom", pit.getUser().getDepthUnits());
            e.setAttribute(a);
            e.setText(pit.getHeightOfSnowpack());
    	}
    	/// surface penetration.
    	
    	String skiBoot = pit.getSkiBoot();
    	if ( skiBoot != null )
    	{
    		if ( skiBoot.equals("Ski"))
    		{
    				/// ski pen
		    filter = new ElementFilter("penetrationSki");
		    result = snowProfile.getDescendants(filter);
		    e  = result.next();
		    if ( e!=null )
		    {
                        Attribute a = new Attribute("uom", pit.getUser().getDepthUnits());
		    	e.setAttribute(a);
		    	e.setText(pit.getSurfacePen());
		    }
    		}
    		else if ( skiBoot.equals("Foot"))
    		{
    			/// boot pen
		    filter = new ElementFilter("penetrationBoot");
		    result = snowProfile.getDescendants(filter);
		    e  = result.next();
		    if ( e!=null )
		    {
                        Attribute a = new Attribute("uom", pit.getUser().getDepthUnits());
		    	e.setAttribute(a);
		    	e.setText(pit.getSurfacePen());
		    }
    		}
    	}
    	
    	filter = new ElementFilter("comment");
    	result = snowProfile.getDescendants(filter);
    	e  = result.next();
    	if ( e!=null )
    	{
            e.setText(pit.getPitNotes());
    	}
    	
    }
    
    public void addTests(avscience.ppc.PitObs pit, Element snowProfile)
    {
    	System.out.println("Add tests.");
    	if (  snowProfile ==null )
    	{
            System.out.println("root is NULL!");
            return;
    	}
    	Element testRoot = new Element("stbTests");
    	java.util.Enumeration tests = pit.getShearTests();
    	
    	while (tests.hasMoreElements())
    	{
            ShearTestResult test = (ShearTestResult) tests.nextElement();
            String code = test.getCode();
            AbstractShearTest ast = shearTests.getShearTestByCode(code);
            String type = ast.getType();
            String score = test.getScore();
            String sdpth = test.getDepth();
    		
            System.out.println("Test type: "+type+" score "+score+" sdpth "+sdpth);
    		
            if ( type.equals("Compression Test"))
            {
    			Element ctscore = new Element("ComprTest");
    			if ( !score.equals("CTN") )
    			{
    				Element failedOn = new Element("failedOn");
    				Element llayer = new Element("Layer");
    				Element dpth = new Element("depthTop");
    				
    				Attribute dpthUnits = new Attribute("uom",pit.getUser().getDepthUnits());
				dpth.setAttribute(dpthUnits);
    				dpth.setText(sdpth);
    				
    				llayer.addContent(dpth);
    				failedOn.addContent(llayer);
    				ctscore.addContent(failedOn);
    				
    				Element res = new Element("Results");
    				Element tscore = new Element("testScore");
    				Element fc = new Element("fractureCharacter");
    				String sfc = test.getQuality()+test.fractureCat;
    				fc.setText(sfc);
    				
    				tscore.setText(test.getCTScore());
    				res.addContent(tscore);
    				res.addContent(fc);
    				failedOn.addContent(res);
    				
    			}
    			else
    			{
    				Element nofail = new Element("noFailure");
    				ctscore.addContent(nofail);
    			}
    			testRoot.addContent(ctscore);
    		
    		}
    		
    		else if ( type.equals("Rutschblock Test"))
    		{
    			Element rbTest = new Element("RBlockTest");
    			if ( !score.equals("RB7") )
    			{
    				Element failedOn = new Element("failedOn");
    				Element llayer = new Element("Layer");
    				Element dpth = new Element("depthTop");
    				
    				Attribute dpthUnits = new Attribute("uom",pit.getUser().getDepthUnits());
				dpth.setAttribute(dpthUnits);
    				dpth.setText(sdpth);
    				
    				llayer.addContent(dpth);
    				failedOn.addContent(llayer);
    				rbTest.addContent(failedOn);
    				
    				Element res = new Element("Results");
    				Element tscore = new Element("testScore");
    				Element fc = new Element("fractureCharacter");
    				Element rt = new Element("releaseType");
    				rt.setText(test.releaseType);
    				
    				String sfc = test.getQuality()+test.fractureCat;
    				fc.setText(sfc);
    				
    				tscore.setText(test.getScore());
    				res.addContent(tscore);
    				res.addContent(fc);
    				res.addContent(rt);
    				failedOn.addContent(res);
    				
    			}
    			else
    			{
    				Element nofail = new Element("noFailure");
    				rbTest.addContent(nofail);
    			}
    			testRoot.addContent(rbTest);
    		}
    		else if ( type.equals("Extended Column Test"))
    		{
    			Element ectest = new Element("ExtColumnTest");
    			if ( !score.equals("ECTX") )
    			{
	    			Element failedOn = new Element("failedOn");
				Element llayer = new Element("Layer");
				Element dpth = new Element("depthTop");
					
				Attribute dpthUnits = new Attribute("uom",pit.getUser().getDepthUnits());
				dpth.setAttribute(dpthUnits);
				dpth.setText(sdpth);
					
				llayer.addContent(dpth);
    				failedOn.addContent(llayer);
    				ectest.addContent(failedOn);
    				
    				Element res = new Element("Results");
    				Element tscore = new Element("testScore");
    				tscore.setText(test.getECScore());
    				res.addContent(tscore);
    				failedOn.addContent(res);
    			}
    			else
    			{
    				Element nofail = new Element("noFailure");
    				ectest.addContent(nofail);
    			}
    			testRoot.addContent(ectest);
    		}
                else if ( type.equals("Propogation Saw Test"))
                {
                        Element pstest = new Element("PropSawTest");
                        Element failedOn = new Element("failedOn");
			Element llayer = new Element("Layer");
			Element dpth = new Element("depthTop");
					
			Attribute dpthUnits = new Attribute("uom",pit.getUser().getDepthUnits());
			dpth.setAttribute(dpthUnits);
			dpth.setText(sdpth);
					
			llayer.addContent(dpth);
    			failedOn.addContent(llayer);
    			pstest.addContent(failedOn);
                }
    		
    	}
    	snowProfile.addContent(testRoot);
    }
    
    public void addTempProfile(avscience.ppc.PitObs pit, Element root)
    {
    	ElementFilter tpFilter = new ElementFilter("tempProfile");
    	Iterator<Element> tpres = root.getDescendants(tpFilter);
    	Element tempProfile = tpres.next();
    	
    	if (!pit.hasTempProfile())
    	{
            root.removeContent(tempProfile);
            return;
    	}
    	
    	ElementFilter obsFilter = new ElementFilter("Obs");
    	Iterator<Element> oi = tempProfile.getDescendants(obsFilter);
    	Element obs = oi.next();
    	tempProfile.removeContent(obs);
    	
    	Attribute duom = new Attribute("uomDepth", pit.getTempProfile().getDepthUnits());
    	Attribute tuom = new Attribute("uomTemp", "deg"+pit.getTempProfile().getTempUnits());
    	tempProfile.setAttribute(duom);
    	tempProfile.setAttribute(tuom);
    	
    	TempProfile profile = pit.getTempProfile();
    	Hashtable tprofile = profile.getProfile();
    	System.out.println("Temp Profile size:: "+tprofile.size());
    	Enumeration e = tprofile.keys();
    	while ( e.hasMoreElements())
    	{
    		Object dpth = e.nextElement();
    		Object o = tprofile.get(dpth);
    		Element aobs = (Element)obs.clone();
    		ElementFilter dfilter = new ElementFilter("depth");
    		Iterator<Element> dit = aobs.getDescendants(dfilter);
    		Element edpth = dit.next();
    		edpth.setText(dpth.toString());
    		
    		ElementFilter tfilter = new ElementFilter("snowTemp");
    		Iterator<Element> tit = aobs.getDescendants(tfilter);
    		Element etemp = tit.next();
    		etemp.setText(o.toString());
    		tempProfile.addContent(aobs);
    	}	
    }
    
    String getTupleListFromTable(Hashtable table)
  {
  		Enumeration e = table.keys();
  		StringBuffer buffer = new StringBuffer();
  		while (e.hasMoreElements())
  		{
  			Object o = e.nextElement();
  			buffer.append(o);
  			buffer.append(" ");
  			Object oo = table.get(o);
  			buffer.append(oo);
  			buffer.append(",");
  			
  		}
  		String s = buffer.toString();
  		String ss ="";
  		if (s.length()>1)ss = s.substring(0, s.length()-1);
  		return ss;
  	}
    
    public void addLayers(avscience.ppc.PitObs pit, Element snowProfile)
    {
    	ElementFilter lfilter = new ElementFilter("stratProfile");
    	Iterator<Element> lresult = snowProfile.getDescendants(lfilter);
    	layerRoot  = lresult.next();
    	
    	ElementFilter llaer = new ElementFilter("Layer");
    	Iterator<Element> llaers = snowProfile.getDescendants(llaer);
    	Element alayer = llaers.next();
    	
    	Element baseLayer = (Element) alayer.clone();
    	layerRoot.removeContent();
    	
	String measureFrom = pit.getMeasureFrom();
	String tb = "top down";
		///if ( measureFrom.equals("top") )  tb = "bottom up";/// backassword SnowPiz  hack
	Attribute a = new Attribute("dir", tb);
	layerRoot.setAttribute(a);
    	java.util.Enumeration e=null;
        if ( pit.hasLayers())
        {
	        e = pit.getLayers();
	        if ( e!=null )
	        {
		        while ( e.hasMoreElements() )
		        {
		            avscience.ppc.Layer l = (avscience.ppc.Layer) e.nextElement();
		            System.out.println("Adding Layer: "+l.toString());
		            Element layer = (Element) baseLayer.clone();
		            ElementFilter dt = new ElementFilter("depthTop");
		            Iterator<Element> dti = layer.getDescendants(dt);
		            Element top = dti.next();
		            top.setText(l.getStartDepth()+"");
					
                            Attribute dpthUnits = top.getAttribute("uom");
                            dpthUnits.setValue(pit.getUser().getDepthUnits());
					
                            ElementFilter thkf = new ElementFilter("thickness");
                            Iterator<Element> thki = layer.getDescendants(thkf);
                            Element thicknss = thki.next();
                            thicknss.setText(l.getThickness()+"");
                            dpthUnits = thicknss.getAttribute("uom");
                            dpthUnits.setValue(pit.getUser().getDepthUnits());
					
                            String gt = l.getGrainType1();
                   
                            String cgt = GrainTypeConvertor.getInstance().getCAAMLType(gt);
                            System.out.println("CAAML grain type primary: ........  "+cgt);
		
                            if ( cgt!=null )
                            {
                                ElementFilter gfpf = new ElementFilter("grainFormPrimary");
                                Iterator<Element> gfpi = layer.getDescendants(gfpf);
				Element gfp = gfpi.next();
				gfp.setText(cgt);
                                if ( cgt.trim().length()<1)	layer.removeContent(gfp);
                            }
					
				String gt2 = l.getGrainType2();
				String cgt2 = GrainTypeConvertor.getInstance().getCAAMLType(gt2);
                                System.out.println("CAAML grain type secondary: ........  "+cgt2);
                                ElementFilter gt2f = new ElementFilter("grainFormSecondary");
				Iterator<Element> gt2i = layer.getDescendants(gt2f);
				Element gtsecond = gt2i.next();
				if (( cgt2!=null ) && (cgt2.trim().length()>0)) gtsecond.setText(cgt2);
				else layer.removeContent(gtsecond);
					
				ElementFilter gsf = new ElementFilter("grainSize");
				Iterator<Element> gsfi = layer.getDescendants(gsf);
				Element grainSize = gsfi.next();
					
				String avg = l.getAvgGrainSize();
				String max = l.getGrainSizeMax();
				if ( avg.equals("0.0") && max.equals("0.0")) layer.removeContent(grainSize);
				else
				{
                                    ElementFilter avgf = new ElementFilter("avg");
                                    Iterator<Element> avgfi = grainSize.getDescendants(avgf);
                                    Element eavg = avgfi.next();
						
                                    if ( avg.equals("0.0")) grainSize.removeContent(eavg);
                                    else eavg.setText(avg);
						
                                    ElementFilter maxf = new ElementFilter("avgMax");
                                    Iterator<Element> maxff = grainSize.getDescendants(maxf);
                                    Element emax = maxff.next();
						
                                    if ( max.equals("0.0")) grainSize.removeContent(emax);
                                    else emax.setText(max);
						
                                }
					
				ElementFilter hardf = new ElementFilter("hardness");
				Iterator<Element> hardi = layer.getDescendants(hardf);
				Element hard = hardi.next();
					
				String hard1 = l.getHardness1();
				String hard2 = l.getHardness2();
				String s = "";
				if (( hard1.trim().length() < 1) && (hard2.trim().length()<1)) layer.removeContent(hard);
				else
				{
                                    if (( hard1.trim().length() > 0) && (hard2.trim().length()>0)) s = hard1+"-"+hard2;
                                    else s = hard1+hard2;
                                    hard.setText(s); 
				}
					
				String splwc = l.getWaterContent();
                                String lw = GrainTypeConvertor.getInstance().getLWC(splwc);
			        
                                ElementFilter lwcf = new ElementFilter("lwc");
                                Iterator<Element> lwci = layer.getDescendants(lwcf);
				Element lwc = lwci.next();
				if ( !lw.equals("unknown") ) lwc.setText(lw);
				else layer.removeContent(lwc);
			       
			        layerRoot.addContent(layer);
		        }
		        
	        }
        }
        
    }
    
    public int getMaxDepth(avscience.ppc.PitObs pit)
    {
    	System.out.println("getMaxDepth");
        int max = 0;
        if ( pit==null )
        {
            System.out.println("PIT IS NULL.");
            return 0;
        }
      
      	System.out.println("max depth layers.");
        java.util.Enumeration e=null;
        if ( pit.hasLayers())
        {
	        e = pit.getLayers();
	        if ( e!=null )
	        {
		        while ( e.hasMoreElements() )
		        {
		            avscience.ppc.Layer l = (avscience.ppc.Layer) e.nextElement();
		            int end = l.getEndDepthInt();
		            if ( end > max ) max=end;
		            int start = l.getStartDepthInt();
		            if ( start > max ) max=start;
		        }
		     }
		 }
		 System.out.println("max depth tests.");
            if ( max==0 )
            {
	   		e = pit.getShearTests();
	   		if ( e!=null )
                        {
		   		while ( e.hasMoreElements() )
                                {
                                    avscience.ppc.ShearTestResult result = (avscience.ppc.ShearTestResult) e.nextElement();
                                    int depth = result.getDepthValueInt();
                                    if ( depth > max ) max=depth;
                                }
                        }
	    //	max+=6;
	    }
	    System.out.println("max depth tempprofile.");
	    if ( (pit.getTempProfile()!=null) && (pit.getTempProfile().getDepths()!=null))
	    {
	    	Enumeration ee = pit.getTempProfile().getDepths().elements();
		   
		    while ( ee.hasMoreElements() )
		    {
		    	Integer I = (Integer)ee.nextElement();
		    	int depth = I.intValue();
		    	// need to scale for temp depth??
		    	depth=depth*10;
		    	if ( depth > max ) max=depth;
		    }
		}
	    boolean mor=false;
	    System.out.println("max depth rho profile.");
	    if (( pit.getDensityProfile()!=null) && (pit.getDensityProfile().getDepths()!=null))
	    {
	    	Enumeration ee = pit.getDensityProfile().getDepths().elements();
		    
		    while ( ee.hasMoreElements() )
		    {
		    	Integer I = (Integer)ee.nextElement();
		    	int depth = I.intValue();
		    	// need to scale for rho depth??
		    	depth=depth*10;
		    	if ( depth > max )
		    	{
		    		max=depth;
		    		mor=true;
		    	}
		    }
		}
       return max/10;
    }
    
    public String getWindspeedCat(String windspeed)
    {
    	if ( windspeed==null ) 	return "unknown";
    	if (windspeed.equals("Calm")) return "C";
    	if (windspeed.equals("Light Breeze")) return "L";
    	if (windspeed.equals("Moderate")) return "M";
    	if (windspeed.equals("Strong")) return "S";
    	if (windspeed.equals("gale force winds")) return "X";
    	return "unknown";
    }
    
    public int getWindDirAzi(String windirCard)
    {
        if (windirCard.equals("N")) return 360;
        if (windirCard.equals("NE")) return 45;
        if (windirCard.equals("E")) return 90;
        if (windirCard.equals("SE")) return 135;
        if (windirCard.equals("S")) return 180;
        if (windirCard.equals("SW")) return 225;
        if (windirCard.equals("W")) return 270;
        if (windirCard.equals("NW")) return 315;
        
        return 0;
    }
    
    public String getWindspeedMPH(String windspeed)
    {
    	if ( windspeed==null ) 	return "0";
    	if (windspeed.equals("Calm")) return "0";
    	if (windspeed.equals("Light Breeze")) return "8";
    	if (windspeed.equals("Moderate")) return "20";
    	if (windspeed.equals("Strong")) return "32";
    	if (windspeed.equals("gale force winds")) return "45";
    	return "0";
    }
    
    //////////
    public String getSkyCondition(String skyCover)
    {
    	if ( skyCover==null ) return "unknown";
    	if ( skyCover.equals("Clear")) return "CLR";
    	if ( skyCover.equals("sky < 2/8 covered")) return "FEW";
    	if ( skyCover.equals("sky 3/8 to 4/8 covered")) return "-SCT";
    	if ( skyCover.equals("sky 4/8 to 8/8 covered")) return "SCT";
    	if ( skyCover.equals("sky 8/8 covered")) return "BKN";
    	if ( skyCover.equals("Fog")) return "OVC";
    	return "unknown";
    }
    ////////
    public String getPrecipTI(String precip)
    {
    	if (precip==null) return "unknown";
    	if (precip.equals("None")) return "Nil";
    	if (precip.equals("Snow < 0.5 cm/hr")) return "S-1";
    	if (precip.equals("Snow - 1 cm/hr")) return "S1";
    	if (precip.equals("Snow - 2 cm/hr")) return "S2";
    	if (precip.equals("Snow - 5 cm/hr")) return "S5";
    	if (precip.equals("Snow - 10 cm/hr")) return "S10";
    	if (precip.equals("Graupel or hail")) return "G";
    	if (precip.equals("Mixed rain and snow")) return "RS";
    	if (precip.equals("Very light rain - mist")) return "RV";
    	if (precip.equals("Light Rain < 2.5mm/hr")) return "RL";
    	if (precip.equals("Moderate rain < 7.5mm/hr")) return "RM";
    	if (precip.equals("Heavy Rain > 7.5mm/hr")) return "RH";
    	return "unknown";
    }
    
    public String getAspectCat(int aspect)
    {
    	if ( aspect < 0 ) return "NA";
    	if (( aspect >=337.5 ) || (aspect <=22.5)) return "N";
    	if (( aspect >= 157.5 ) && (aspect <= 202.5)) return "S";
    	if (( aspect >= 247.5 ) && (aspect <= 292.5)) return "W";
    	if (( aspect >= 67.5 ) && (aspect <= 112.5)) return "E";
    	if (( aspect >= 22.5 ) && (aspect <= 67.5)) return "NE";
    	if (( aspect >= 292.5 ) && (aspect <= 337.5)) return "NW";
    	if (( aspect >= 112.5 ) && (aspect <= 157.5)) return "SE";
    	if (( aspect >= 202.5 ) && (aspect <= 247.5)) return "SW";
    	return "NA";
    }
    
    String getIsoDate(Date date)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        StringBuffer buffer = new StringBuffer();
        buffer.append(cal.get(Calendar.YEAR));
        buffer.append("-");
        
        buffer.append(cal.get(Calendar.MONTH));
        buffer.append("-");
        buffer.append(cal.get(Calendar.DAY_OF_MONTH));
        buffer.append("T");
        
        buffer.append(cal.get(Calendar.HOUR_OF_DAY));
        buffer.append(":");
        buffer.append(cal.get(Calendar.MINUTE));
        buffer.append(":");
        buffer.append(cal.get(Calendar.SECOND));
        int offset = (int) (cal.getTimeZone().getRawOffset()/(1000*60*60));
        buffer.append(offset);
       
        return buffer.toString();
    }
    
    String getIsoDateTime(Date date)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        StringBuffer buffer = new StringBuffer();
        buffer.append(cal.get(Calendar.YEAR));
        buffer.append("-");
        
        buffer.append(cal.get(Calendar.MONTH));
        buffer.append("-");
        buffer.append(cal.get(Calendar.DAY_OF_MONTH));
        buffer.append("T");
        
        buffer.append(cal.get(Calendar.HOUR_OF_DAY));
        buffer.append(":");
        buffer.append(cal.get(Calendar.MINUTE));
        buffer.append(":");
        buffer.append(cal.get(Calendar.SECOND));
        buffer.append(".");
        buffer.append(cal.get(Calendar.MILLISECOND));
        
        int offset = (int) (cal.getTimeZone().getRawOffset()/(1000*60*60));
        buffer.append(offset);
       
        return buffer.toString();
    }
    
    void writeCAAMLToFile()
    {
    	System.out.println("writeCAAMLToFile()");
    	XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	try
	{
            if ( file==null )file = new File("SPTestPitCAAML.xml");
            outputter.output(doc, new FileOutputStream(file));
	}
	catch(Exception ex)
	{
            System.out.println(ex.toString());
	}
    }
    
    void loadBaseDoc()
    {
    	URL url=null;
    	try
    	{
	    	url = new URL(baseFile);
    	}
	catch(Exception e)
         {
            System.out.println(e.toString());
            e.printStackTrace();
         }
    	if (url==null) 
    	{
    		System.out.println("Can't find base doc: "+url.toString());
    		return;
    	}
    	
    	try
    	{
    		SAXBuilder builder = new SAXBuilder();
    		doc = builder.build(url);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
}
    
    
