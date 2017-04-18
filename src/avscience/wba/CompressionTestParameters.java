
package avscience.wba;


public interface CompressionTestParameters
{

    public abstract String[] getDescriptions();

    public abstract String[] getScores();

    public abstract String getDescription(String s);

    public abstract String getStability(String s);

    public abstract String getType();

    public abstract String getTypeDescription();

    public abstract String getTypeCode();
}
