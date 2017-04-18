package avscience.ppc;

public class AvOccurence extends avscience.ppc.AvScienceDataObject
{
    private String pitObs = "";
    private String estDate = "";
    private String estTime = "";
    private String elvStart = "";
    private String elvDeposit = "";
    private String aspect = "";
    private String aspect1 = "";
    private String aspect2 = "";
    private String type = "";
    private String wcStart = "";
    private String wcDeposit = "";
    private String triggerType = "";
    private String triggerCode = "";
    private String USSize = "";
    private String CASize = "";
    private String avgFractureDepth = "";
    private String maxFractureDepth = "";
    private String levelOfBedSurface = "";
    private String weakLayerType = "";
    private String weakLayerHardness = "";
    private String hardnessAbove = "";
    private String hardnessBelow = "";
    private String hsuffix = "";
    private String hsuffixAbove = "";
    private String hsuffixBelow = "";
    private String crystalTypeAbove = "";
    private String crystalTypeBelow = "";
    private String crystalSizeAbove = "";
    private String crystalSize = "";
    private String crystalSizeBelow = "";
    private String sizeSuffixAbove = "";
    private String sizeSuffixBelow = "";
    private String sizeSuffix = "";
    private String snowPackType = "";
    private String fractureWidth = "";
    private String fractureLength = "";
    private String lengthOfAvalanche = "";
    private String avgStartAngle = "";
    private String maxStartAngle = "";
    private String minStartAngle = "";
    private String alphaAngle = "";
    private String depthOfDeposit = "";
    private String lengthOfDeposit = "";
    private String widthOfDeposit = "";
    private String areaOfDeposit = "";
    private String densityOfDeposit = "";
    private String numPeopleCaught = "";
    private String numPeoplePartBuried = "";
    private String numPeopleTotalBuried = "";
    private String injury = "";
    private String fatality = "";
    private String estDamage = "";
    private String bldgDmg = "";
    private String eqDmg = "";
    private String vehDmg = "";
    private String miscDmg = "";
    private String totDmg = "";
    private String comments = "";
    private String causeOfRelease = "";
    private String sympathetic = "";
    private String sympDistance = "";
    private String serial = "";
    private String archname="";
    private String hasPit = "true";
    private String edited = "false";
    
    public AvOccurence(){}
    
    public void writeAttributes()
    {
        try
        {
            put("pitObs", pitObs);
            put("estDate", estDate);
            put("estTime", estTime);
            put("elvStart", elvStart);
            put("elvDeposit", elvDeposit);
            put("aspect", aspect);
            put("aspect1", aspect1);
            put("aspect2", aspect2);
            put("type", type);
            put("wcStart", wcStart);
            put("wcDeposit", wcDeposit);
            put("triggerType", triggerType);
            put("triggerCode", triggerCode);
            put("USSize", USSize);
            put("CASize", CASize);
            put("avgFractureDepth", avgFractureDepth);
            put("maxFractureDepth", maxFractureDepth);
            put("levelOfBedSurface", levelOfBedSurface);
            put("weakLayerType", weakLayerType);
            put("weakLayerHardness", weakLayerHardness);
            put("hardnessAbove", hardnessAbove);
            put("hardnessBelow", hardnessBelow);
            put("fractureWidth", fractureWidth);
            put("fractureLength", fractureLength);
            put("lengthOfAvalanche", lengthOfAvalanche);
            put("avgStartAngle", avgStartAngle);
            put("maxStartAngle", maxStartAngle);
            put("minStartAngle", minStartAngle);
            put("alphaAngle", alphaAngle);
            put("depthOfDeposit", depthOfDeposit);
            put("lengthOfDeposit", lengthOfDeposit);
            put("widthOfDeposit", widthOfDeposit);
            put("areaOfDeposit", areaOfDeposit);
            put("densityOfDeposit", densityOfDeposit);
            put("injury", injury);
            put("fatality", fatality);
            put("estDamage", estDamage);
            put("comments", comments);
            put("hasPit", hasPit);
            put("hsuffix", hsuffix);
            put("hsuffixAbove", hsuffixAbove);
            put("hsuffixBelow", hsuffixBelow);
            put("crystalTypeAbove", crystalTypeAbove);
            put("crystalTypeBelow", crystalTypeBelow);
            put("crystalSizeAbove", crystalSizeAbove);
            put("crystalSize", crystalSize);
            put("crystalSizeBelow", crystalSizeBelow);
            put("sizeSuffixAbove", sizeSuffixAbove);
            put("sizeSuffixBelow", sizeSuffixBelow);
            put("sizeSuffix", sizeSuffix);
            put("numPeopleCaught", numPeopleCaught);
            put("numPeoplePartBuried", numPeoplePartBuried);
            put("numPeopleTotalBuried", numPeopleTotalBuried);
            put("bldgDmg", bldgDmg);
            put("eqDmg", eqDmg);
            put("vehDmg", vehDmg);
            put("miscDmg", miscDmg);
            put("totDmg", miscDmg);
            put("snowPackType", snowPackType);
            put("causeOfRelease", causeOfRelease);
            put("sympathetic", sympathetic);
            put("sympDistance", sympDistance);
            put("serial", serial);
            put("edited", edited);
            put("archname", archname);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void popAttributes()
    {
    	System.out.println("AvOcc getAttributes()");
        try
        {
            pitObs = getString("pitObs");
            estDate = getString("estDate");
            estTime = getString("estTime");
            elvStart = getString("elvStart");
            elvDeposit = getString("elvDeposit");
            aspect = getString("aspect");
            aspect1 = getString("aspect1");
            aspect2 = getString("aspect2");
            type = getString("type");
            wcStart = getString("wcStart");
            wcDeposit = getString("wcDeposit");
            triggerType = getString("triggerType");
            triggerCode = getString("triggerCode");
            USSize = getString("USSize");
            CASize = getString("CASize");
            avgFractureDepth = getString("avgFractureDepth");
            maxFractureDepth = getString("maxFractureDepth");
            levelOfBedSurface = getString("levelOfBedSurface");
            weakLayerType = getString("weakLayerType");
            weakLayerHardness = getString("weakLayerHardness");
            hardnessAbove = getString("hardnessAbove");
            hardnessBelow = getString("hardnessBelow");
            fractureWidth = getString("fractureWidth");
            fractureLength = getString("fractureLength");
            lengthOfAvalanche = getString("lengthOfAvalanche");
            avgStartAngle = getString("avgStartAngle");
            maxStartAngle = getString("maxStartAngle");
            minStartAngle = getString("minStartAngle");
            alphaAngle = getString("alphaAngle");
            depthOfDeposit = getString("depthOfDeposit");
            lengthOfDeposit = getString("lengthOfDeposit");
            widthOfDeposit = getString("widthOfDeposit");
            areaOfDeposit = getString("areaOfDeposit");
            densityOfDeposit = getString("densityOfDeposit");
            injury = getString("injury");
            fatality = getString("fatality");
            estDamage = getString("estDamage");
            comments = getString("comments");
            hasPit = getString("hasPit");
            hsuffix = getString("hsuffix");
            hsuffixBelow = getString("hsuffixBelow");
            hsuffixAbove = getString("hsuffixAbove");
            crystalTypeAbove = getString("crystalTypeAbove");
            crystalTypeBelow = getString("crystalTypeBelow");

            crystalSizeAbove = getString("crystalSizeAbove");
            crystalSizeBelow = getString("crystalSizeBelow");
            crystalSize = getString("crystalSize");
            sizeSuffixAbove = getString("sizeSuffixAbove");
            sizeSuffixBelow = getString("sizeSuffixBelow");
            sizeSuffix = getString("sizeSuffix");
            numPeopleCaught = getString("numPeopleCaught");
            numPeoplePartBuried = getString("numPeoplePartBuried");
            numPeopleTotalBuried = getString("numPeopleTotalBuried");
            bldgDmg = getString("bldgDmg");
            eqDmg = getString("eqDmg");
            vehDmg = getString("vehDmg");
            miscDmg = getString("miscDmg");
            totDmg = getString("totDmg");
            snowPackType = getString("snowPackType");
            causeOfRelease = getString("causeOfRelease");
            sympathetic = getString("sympathetic");
            sympDistance = getString("sympDistance");
            serial = getString("serial");
            edited = getString("edited");
            archname = getString("archname");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public AvOccurence(String data) throws Exception
    {
    	super(data);
    }
    
    public boolean hasPit()
    { 
    	if ( hasPit.equals("true") ) return true;
    	else return false;
    }
    
    
    public void setHasPit(boolean has)
    {
    	if ( has ) hasPit = "true";
    	else hasPit = "false";
    }
   
    public void setPitName(String name)
    {
    	this.pitObs = name;
    }
    public void setEstDate(String estDate){this.estDate = estDate;}
    public void setEstTime(String estTime) {this.estTime = estTime;}
    public void setElvStart(String elvStart) {this.elvStart = elvStart;}
    public void setElvDeposit(String elvDeposit) {this.elvDeposit = elvDeposit;}
    public void setAspect(String aspect){this.aspect = aspect;} 
    public void setAspect1(String aspect){this.aspect1 = aspect;} 
    public void setAspect2(String aspect){this.aspect2 = aspect;} 
    public void setType(String type){this.type = type;}
    public void setWcStart(String wcStart){this.wcStart = wcStart;}
    public void setWcDeposit(String wcDeposit){this.wcDeposit = wcDeposit;}
    public void setTriggerType(String triggerType){this.triggerType = triggerType;}
    public void setTriggerCode(String triggerCode) {this.triggerCode = triggerCode;}
    public void setUSSize(String USSize){this.USSize = USSize;}
    public void setCASize(String CASize){this.CASize = CASize;} 
    public void setAvgFractureDepth(String avgFractureDepth){this.avgFractureDepth = avgFractureDepth;}
    public void setMaxFractureDepth(String maxFractureDepth){this.maxFractureDepth = maxFractureDepth;}
    public void setLevelOfBedSurface(String levelOfBedSurface){this.levelOfBedSurface = levelOfBedSurface;}
    public void setWeakLayerType(String weakLayerType){this.weakLayerType = weakLayerType;}
    public void setWeakLayerHardness(String weakLayerHardness){this.weakLayerHardness = weakLayerHardness;}
    public void setHardnessAbove(String hardnessAbove){this.hardnessAbove = hardnessAbove;}
    public void setHardnessBelow(String hardnessBelow){this.hardnessBelow = hardnessBelow;}
    public void setFractureWidth(String fractureWidth){this.fractureWidth = fractureWidth;}
    public void setFractureLength(String fractureLength){this.fractureLength = fractureLength;}
    public void setLengthOfAvalanche(String lengthOfAvalanche){this.lengthOfAvalanche = lengthOfAvalanche;}
    public void setAvgStartAngle(String avgStartAngle){this.avgStartAngle = avgStartAngle;}
    public void setMaxStartAngle(String maxStartAngle){this.maxStartAngle = maxStartAngle;}    
    public void setMinStartAngle(String minStartAngle){this.minStartAngle = minStartAngle;}    
    public void setAlphaAngle(String alphaAngle){this.alphaAngle = alphaAngle;}  
    public void setDepthOfDeposit(String depthOfDeposit) {this.depthOfDeposit = depthOfDeposit;}
    public void setLengthOfDeposit(String s) {this.lengthOfDeposit = s;}
    public void setWidthOfDeposit(String s) {this.widthOfDeposit = s;}
    public void setAreaOfDeposit(String areaOfDeposit) {this.areaOfDeposit = areaOfDeposit;}
    public void setDensityOfDeposit(String densityOfDeposit) {this.densityOfDeposit = densityOfDeposit;}
    public void setInjury(String injury) {this.injury = injury;}
    public void setFatality(String fatality) {this.fatality = fatality;}
    public void setEstDamage(String estDamage) {this.estDamage = estDamage;}
    public void setComments(String comments) {this.comments = comments;}
    public void setHsuffix(String s) {this.hsuffix = s;}
    public void setHsuffixAbove(String s) {this.hsuffixAbove = s;}
    public void setHsuffixBelow(String s) {this.hsuffixBelow = s;}
    public void setCrystalTypeAbove(String s) {this.crystalTypeAbove = s;}
    public void setCrystalTypeBelow(String s) {this.crystalTypeBelow = s;}
    public void setCrystalSizeAbove(String s) {this.crystalSizeAbove = s;}
    public void setCrystalSize(String s) {this.crystalSize = s;}
    public void setCrystalSizeBelow(String s) {this.crystalSizeBelow = s;}
    public void setSizeSuffixBelow(String s) {this.sizeSuffixBelow = s;}
    public void setSizeSuffixAbove(String s) {this.sizeSuffixAbove = s;}
    public void setSizeSuffix(String s) {this.sizeSuffix = s;}
    public void setNumPeopleCaught(String s){this.numPeopleCaught = s;}
    public void setNumPeoplePartBuried(String s){this.numPeoplePartBuried = s;}
    public void setNumPeopleTotalBuried(String s){this.numPeopleTotalBuried = s;}
    public void setBldgDmg(String s){this.bldgDmg = s;}
    public void setEqDmg(String s){this.eqDmg = s;}
    public void setVehDmg(String s){this.vehDmg = s;}
    public void setMiscDmg(String s){this.miscDmg = s;}
    public void setTotalDmg(String s){this.totDmg = s;}
    public void setSnowPackType(String s){this.snowPackType = s;}
    public void setCauseOfRelease(String s){this.causeOfRelease = s;}
    public void setSympathetic(String s){this.sympathetic = s;}
    public void setSympDistance(String s){this.sympDistance = s;}
    public void setSerial(String s){serial = s;}
    public void setArchName(String s){archname = s;}
    
   public void setEdited(boolean edited)
   {
   	if (edited) this.edited = "true";
   	else this.edited="false";
   }
   	
    public String getPitName(){ return pitObs; }
    public String getEstDate(){ return estDate; }
    public String getEstTime(){ return estTime; }
    public String getElvStart(){ return elvStart; }
    public String getElvDeposit(){ return elvDeposit; }
    public String getAspect(){ return aspect; }
    public String getAspect1(){ return aspect1; }
    public String getAspect2(){ return aspect2; }
    public String getType(){ return type; }
    public String getWcStart(){ return wcStart; }
    public String getWcDeposit(){ return wcDeposit; }
    public String getTriggerType(){ return triggerType; }
    public String getTriggerCode(){ return triggerCode; }
    public String getUSSize(){ return USSize; }
    public String getCASize(){ return CASize; }
    public String getAvgFractureDepth(){ return avgFractureDepth; }
    public String getMaxFractureDepth(){ return maxFractureDepth; }
    public String getLevelOfBedSurface(){ return levelOfBedSurface; }
    public String getWeakLayerType(){ return weakLayerType; }
    public String getWeakLayerHardness(){ return weakLayerHardness; }
    public String getHardnessAbove(){ return  hardnessAbove; }
    public String getHardnessBelow(){ return  hardnessBelow; }
    public String getFractureWidth(){ return  fractureWidth; }
    public String getFractureLength(){ return  fractureLength; }
    public String getLengthOfAvalanche(){ return lengthOfAvalanche; }
    public String getAvgStartAngle(){ return avgStartAngle; }
    public String getMinStartAngle(){ return minStartAngle; }
    public String getMaxStartAngle(){ return maxStartAngle; }
    public String getAlphaAngle(){ return alphaAngle; }
    public String getDepthOfDeposit(){ return depthOfDeposit; }
    public String getLengthOfDeposit(){ return lengthOfDeposit; }
    public String getWidthOfDeposit(){ return widthOfDeposit; }
    public String getAreaOfDeposit(){ return areaOfDeposit; }
    public String getDensityOfDeposit(){ return densityOfDeposit; }
    public String getInjury(){ return injury; }
    public String getFatality(){ return fatality; }
    public String getEstDamage(){ return estDamage; }
    public String getComments(){ return comments; }
    public String getHsuffix(){ return hsuffix; }
    public String getHsuffixAbove(){ return hsuffixAbove; }
    public String getHsuffixBelow(){ return hsuffixBelow; }
    public String getCrystalTypeAbove(){ return crystalTypeAbove; }
    public String getCrystalTypeBelow(){ return crystalTypeBelow; }
    public String getCrystalSizeAbove() {return crystalSizeAbove;}
    public String getCrystalSizeBelow() {return crystalSizeBelow;}
    public String getCrystalSize() {return crystalSize;}
    public String getSizeSuffixBelow() {return sizeSuffixBelow;}
    public String getSizeSuffixAbove() {return sizeSuffixAbove;}
    public String getSizeSuffix() {return sizeSuffix;}
    public String getNumPeopleCaught(){return numPeopleCaught;}
    public String getNumPeoplePartBuried(){return numPeoplePartBuried;}
    public String getNumPeopleTotalBuried(){return numPeopleTotalBuried;}
    public String getBldgDmg(){return bldgDmg;}
    public String getEqDmg(){return eqDmg;}
    public String getVehDmg(){return vehDmg;}
    public String getMiscDmg(){return miscDmg;}
    public String getTotalDmg(){return totDmg;}
    public String getSnowPackType(){return snowPackType;}
    public String getCauseOfRelease(){return causeOfRelease;}
    public String getSympathetic(){return sympathetic;}
    public String getSympDistance(){return sympDistance;}
    public String getSerial(){return serial;}
    public String getArchName(){return archname;}
    public boolean getEdited()
    {
    	if (edited.equals("true")) return true;
    	else return false;
    }
}