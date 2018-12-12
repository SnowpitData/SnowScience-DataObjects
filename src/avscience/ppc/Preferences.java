/*
 @author Mark Kahrl
 */
package avscience.ppc;

public class Preferences extends AvScienceDataObject
{
    public Preferences(){super();}
    public Preferences(String data) throws Exception
    {
        super(data);
        popAttributes();
    }
    
    public Preferences(String prof, String share, String tempUnits, String depthUnits, String elvUnits, String rhoUnits, String measureFrom, String longType, String latType, String coordType)
    {
        this.prof = prof;
        this.share = share;
        this.tempUnits = tempUnits;
        this.depthUnits = depthUnits;
        this.elvUnits = elvUnits;
        this.rhoUnits = rhoUnits;
        this.measureFrom = measureFrom;
        this.longType = longType;
        this.latType = latType;
        this.coordType = coordType;
    }
    
    private String prof = "false";
    private String share = "true";
    private String tempUnits = "C";
    private String depthUnits = "cm";
    private String elvUnits = "m";
    private String rhoUnits = "kg/cubic_m";
    private String measureFrom = "top";
    private String longType = "W";
    private String latType = "N";
    private String coordType="Lat/Lon";
    
    public void writeAttributes()
    {
        try
        {
            put("prof", prof);
            put("share", share);
            put("tempUnits", tempUnits);
            put("depthUnits", depthUnits);
            put("elvUnits", elvUnits);
            put("rhoUnits", rhoUnits);
            put("measureFrom", measureFrom);
            put("longType", longType);
            put("latType", latType);
            put("coordType", coordType);
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
            prof = getString("prof");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            share = getString("share");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            tempUnits = getString("tempUnits");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            depthUnits = getString("depthUnits");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            elvUnits = getString("elvUnits");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            rhoUnits = getString("rhoUnits");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            measureFrom = getString("measureFrom");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            longType = getString("longType");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            latType = getString("latType");
        }
        catch(Exception e) {System.out.println(e.toString());}
        try
        {
            coordType = getString("coordType");
        }
        catch(Exception e) {System.out.println(e.toString());}
        
        
    }
    
    /**
     * @return the prof
     */
    public String getProf() {
        return prof;
    }

    /**
     * @param prof the prof to set
     */
    public void setProf(String prof) {
        this.prof = prof;
    }

    /**
     * @return the share
     */
    public boolean getShare() {
        share = share.trim();
        if (share.equals("true")) return true;
        else return false;
    }

    /**
     * @param share the share to set
     */
    public void setShare(String share) {
        this.share = share;
    }

    /**
     * @return the tempUnits
     */
    public String getTempUnits() {
        return tempUnits;
    }

    /**
     * @param tempUnits the tempUnits to set
     */
    public void setTempUnits(String tempUnits) {
        this.tempUnits = tempUnits;
    }

    /**
     * @return the depthUnits
     */
    public String getDepthUnits() {
        return depthUnits;
    }

    /**
     * @param depthUnits the depthUnits to set
     */
    public void setDepthUnits(String depthUnits) {
        this.depthUnits = depthUnits;
    }

    /**
     * @return the elvUnits
     */
    public String getElvUnits() {
        return elvUnits;
    }

    /**
     * @param elvUnits the elvUnits to set
     */
    public void setElvUnits(String elvUnits) {
        this.elvUnits = elvUnits;
    }

    /**
     * @return the rhoUnits
     */
    public String getRhoUnits() {
        return rhoUnits;
    }

    /**
     * @param rhoUnits the rhoUnits to set
     */
    public void setRhoUnits(String rhoUnits) {
        this.rhoUnits = rhoUnits;
    }

    /**
     * @return the measureFrom
     */
    public String getMeasureFrom() {
        return measureFrom;
    }

    /**
     * @param measureFrom the measureFrom to set
     */
    public void setMeasureFrom(String measureFrom) {
        this.measureFrom = measureFrom;
    }

    /**
     * @return the longType
     */
    public String getLongType() {
        return longType;
    }

    /**
     * @param longType the longType to set
     */
    public void setLongType(String longType) {
        this.longType = longType;
    }

    /**
     * @return the latType
     */
    public String getLatType() {
        return latType;
    }

    /**
     * @param latType the latType to set
     */
    public void setLatType(String latType) {
        this.latType = latType;
    }

    /**
     * @return the coordType
     */
    public String getCoordType() {
        return coordType;
    }

    /**
     * @param coordType the coordType to set
     */
    public void setCoordType(String coordType) {
        this.coordType = coordType;
    }
    
}
