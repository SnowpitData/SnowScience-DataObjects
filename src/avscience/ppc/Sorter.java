package avscience.ppc;

import java.util.*;

public class Sorter
{
	public static avscience.ppc.PitObs sortPit(avscience.ppc.PitObs pit)
	{
            pit.layers = sortAscendingLayers(pit.layers);
            pit.shearTests = sortAscendingTests(pit.shearTests);
            pit.layers = checkLayers(pit.layers);
            return pit;
	}
	
	public static java.util.Vector checkLayers(java.util.Vector layers)
        {
            Iterator it = layers.iterator();
            while (it.hasNext())
            {
                    Layer l = (Layer)it.next();
                    if (l.getFromTop()) l.swapHardness();
            }
            return layers;
        }
	
	
	public static java.util.Vector sortDescendingLayers(java.util.Vector layers)
        {
            boolean sorted = false;
            int length = layers.size();
            int i = 0;
            avscience.ppc.Layer layer;
            avscience.ppc.Layer layerInc;

            if (length > 0)
            {
                while (!sorted)
                {
                    sorted = true;
                    for(i=0; i<length - 1; i++)
                    {
                        layer = (avscience.ppc.Layer) layers.elementAt(i);
                        int strt = layer.getStartDepthInt();
                        int end = layer.getEndDepthInt();
                        int n = strt+end;
                        layerInc = (avscience.ppc.Layer) layers.elementAt(i+1);
                        int istrt = layerInc.getStartDepthInt();
                        int iend = layerInc.getEndDepthInt();
                        int ninc = istrt+iend;

                        if ( ninc > n )
                        {
                            layers.setElementAt(layerInc, i);
                            layers.setElementAt(layer, i+1);
                            sorted = false;
                        }
                    }
                }
            }
            return layers;
    }
    
    
    public static java.util.Vector sortAscendingLayers(java.util.Vector layers)
    {
        boolean sorted = false;
        int length = layers.size();
        int i = 0;
        avscience.ppc.Layer layer;
        avscience.ppc.Layer layerInc;

        if (length > 0)
        {
            while (!sorted)
            {
                sorted = true;
                for(i=0; i<length - 1; i++)
                {
                    layer = (avscience.ppc.Layer) layers.elementAt(i);
                    int n = layer.getStartDepthInt();
                    layerInc = (avscience.ppc.Layer) layers.elementAt(i+1);
                    int ninc = layerInc.getStartDepthInt();
                  
                    if ( ninc < n )
                    {
                        layers.setElementAt(layerInc, i);
                        layers.setElementAt(layer, i+1);
                        sorted = false;
                    }
                }
            }
        }
        return layers;
    }
    
    public static java.util.Vector sortAscendingTests(java.util.Vector tests)
    {
        boolean sorted = false;
        int length = tests.size();
        int i = 0;
        avscience.ppc.ShearTestResult test;
        avscience.ppc.ShearTestResult testInc;

        if (length > 0)
        {
            while (!sorted)
            {
                sorted = true;
                for(i=0; i<length - 1; i++)
                {
                    test = (avscience.ppc.ShearTestResult) tests.elementAt(i);
                    int n = test.getDepthValueInt();
                    testInc = (avscience.ppc.ShearTestResult) tests.elementAt(i+1);
                    int ninc = testInc.getDepthValueInt();
                  
                    if ( ninc < n )
                    {
                        tests.setElementAt(testInc, i);
                        tests.setElementAt(test, i+1);
                        sorted = false;
                    }
                }
            }
        }
        return tests;
    }
    
    public static java.util.Vector sortDescendingTests(java.util.Vector tests)
    {
        boolean sorted = false;
        int length = tests.size();
        int i = 0;
        avscience.ppc.ShearTestResult test;
        avscience.ppc.ShearTestResult testInc;

        if (length > 0)
        {
            while (!sorted)
            {
                sorted = true;
                for(i=0; i<length - 1; i++)
                {
                    test = (avscience.ppc.ShearTestResult) tests.elementAt(i);
                    int n = test.getDepthValueInt();
                    testInc = (avscience.ppc.ShearTestResult) tests.elementAt(i+1);
                    int ninc = testInc.getDepthValueInt();
                    
                    if ( ninc > n )
                    {
                        tests.setElementAt(testInc, i);
                        tests.setElementAt(test, i+1);
                        sorted = false;
                    }
                }
            }
        }
        return tests;
    }
}
