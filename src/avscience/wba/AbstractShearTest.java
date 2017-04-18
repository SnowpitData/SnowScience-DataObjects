package avscience.wba;

import java.util.Hashtable;

public abstract class AbstractShearTest extends Hashtable
{
    public AbstractShearTest()
    {
    }

    public abstract String getType();

    public abstract String getTypeCode();

    public abstract String[] getDescriptions();

    public abstract String[] getScores();

    public abstract String getDescription(String s);

    public abstract String getStability(String s);

    public abstract String getTypeDescription();
}
