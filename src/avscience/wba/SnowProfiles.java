package avscience.wba;

import java.awt.Graphics;

public class SnowProfiles
{
    private Graphics g;
    private static final int scale = 4;
    private int yoffset = 2;
    private int xoffset = 2;
    private static final int xx = 2;
    private static final int yy = 2;
    
    public SnowProfiles(Graphics g)
    {
        this.g = g;
    }
    
    public void drawProfile(int type)
    {
        xoffset = xx;
        yoffset = yy;
        int[][] points = getPoints(type);
        if ( points!=null )
        {
            int[] xpoints = points[0];
            int[] ypoints = points[1];
            int size = xpoints.length;
            g.fillPolygon(xpoints, ypoints, size);
        }
    }
    
    public void drawProfile(int type, int x, int y)
    {
        xoffset = xx+x;
        yoffset = yy+y;
        int[][] points = getPoints(type);
        if ( points!=null )
        {
            int[] xpoints = points[0];
            int[] ypoints = points[1];
            int size = xpoints.length;
            g.fillPolygon(xpoints, ypoints, size);
        }
    }
    
    public int[][] getPoints(int type)
    {
        int[][] points = null;
        switch (type)
        {
            case 1:
            points = new int[2][4];
            points[0][0] = xoffset+2*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+3*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+3*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+2*scale;
            points[1][3] = yoffset+0*scale;
            break;
            
            case 2:
            points = new int[2][14];
            
            points[0][0] = xoffset+4*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+4*scale;
            points[1][3] = yoffset+0*scale;
            
            points[0][4] = xoffset+4*scale;
            points[1][4] = yoffset+2*scale;
            
            points[0][5] = xoffset+0*scale;
            points[1][5] = yoffset+2*scale;
            
            points[0][6] = xoffset+0*scale;
            points[1][6] = yoffset+4*scale;
            
            points[0][7] = xoffset+2*scale;
            points[1][7] = yoffset+4*scale;
            
            points[0][8] = xoffset+2*scale;
            points[1][8] = yoffset+6*scale;
            
            points[0][9] = xoffset+3*scale;
            points[1][9] = yoffset+6*scale;
            
            points[0][10] = xoffset+3*scale;
            points[1][10] = yoffset+8*scale;
            
            points[0][11] = xoffset+4*scale;
            points[1][11] = yoffset+8*scale;
            
            points[0][12] = xoffset+4*scale;
            points[1][12] = yoffset+10*scale;
            
            points[0][13] = xoffset+5*scale;
            points[1][13] = yoffset+10*scale;
            
            break;
            
            case 3:
            points = new int[2][16];
            
            points[0][0] = xoffset+5*scale;
            points[1][0] = yoffset+0*scale;
            
            points[0][1] = xoffset+4*scale;
            points[1][1] = yoffset+0*scale;
            
            points[0][2] = xoffset+4*scale;
            points[1][2] = yoffset+2*scale;
            
            points[0][3] = xoffset+3*scale;
            points[1][3] = yoffset+2*scale;
            
            points[0][4] = xoffset+3*scale;
            points[1][4] = yoffset+3*scale;
            
            points[0][5] = xoffset+2*scale;
            points[1][5] = yoffset+3*scale;
            
            points[0][6] = xoffset+2*scale;
            points[1][6] = yoffset+4*scale;
            
            points[0][7] = xoffset+0*scale;
            points[1][7] = yoffset+4*scale;
            
            points[0][8] = xoffset+0*scale;
            points[1][8] = yoffset+6*scale;
            
            points[0][9] = xoffset+2*scale;
            points[1][9] = yoffset+6*scale;
            
            points[0][10] = xoffset+2*scale;
            points[1][10] = yoffset+7*scale;
            
            points[0][11] = xoffset+3*scale;
            points[1][11] = yoffset+7*scale;
            
            points[0][12] = xoffset+3*scale;
            points[1][12] = yoffset+8*scale;
            
            points[0][13] = xoffset+4*scale;
            points[1][13] = yoffset+8*scale;
            
            points[0][14] = xoffset+4*scale;
            points[1][14] = yoffset+10*scale;
            
            points[0][15] = xoffset+5*scale;
            points[1][15] = yoffset+10*scale;
            
            break;
            
            case 4:
            points = new int[2][12];
            
            points[0][0] = xoffset+4*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+4*scale;
            points[1][3] = yoffset+0*scale;
            
            points[0][4] = xoffset+4*scale;
            points[1][4] = yoffset+2*scale;
            
            points[0][5] = xoffset+3*scale;
            points[1][5] = yoffset+2*scale;
            
            points[0][6] = xoffset+3*scale;
            points[1][6] = yoffset+4*scale;
            
            points[0][7] = xoffset+2*scale;
            points[1][7] = yoffset+4*scale;
            
            points[0][8] = xoffset+2*scale;
            points[1][8] = yoffset+6*scale;
            
            points[0][9] = xoffset+1*scale;
            points[1][9] = yoffset+6*scale;
            
            points[0][10] = xoffset+1*scale;
            points[1][10] = yoffset+8*scale;
            
            points[0][11] = xoffset+4*scale;
            points[1][11] = yoffset+8*scale;
            
            break;
            
            case 5:
            points = new int[2][6];
            
            points[0][0] = xoffset+4*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+0*scale;
            points[1][3] = yoffset+0*scale;
            
            points[0][4] = xoffset+0*scale;
            points[1][4] = yoffset+5*scale;
            
            points[0][5] = xoffset+4*scale;
            points[1][5] = yoffset+5*scale;
            break;
            
            case 6:
            points = new int[2][12];
            points[0][0] = xoffset+0*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+4*scale;
            points[1][3] = yoffset+0*scale;
            
            points[0][4] = xoffset+4*scale;
            points[1][4] = yoffset+2*scale;
            
            points[0][5] = xoffset+3*scale;
            points[1][5] = yoffset+2*scale;
            
            points[0][6] = xoffset+3*scale;
            points[1][6] = yoffset+4*scale;
            
            points[0][7] = xoffset+2*scale;
            points[1][7] = yoffset+4*scale;
            
            points[0][8] = xoffset+2*scale;
            points[1][8] = yoffset+6*scale;
            
            points[0][9] = xoffset+1*scale;
            points[1][9] = yoffset+6*scale;
            
            points[0][10] = xoffset+1*scale;
            points[1][10] = yoffset+8*scale;
            
            points[0][11] = xoffset+0*scale;
            points[1][11] = yoffset+8*scale;
            break;
            
            case 7:
            points = new int[2][18];
            points[0][0] = xoffset+0*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+4*scale;
            points[1][3] = yoffset+0*scale;
            
            points[0][4] = xoffset+4*scale;
            points[1][4] = yoffset+2*scale;
            
            points[0][5] = xoffset+3*scale;
            points[1][5] = yoffset+2*scale;
            
            points[0][6] = xoffset+3*scale;
            points[1][6] = yoffset+3*scale;
            
            points[0][7] = xoffset+2*scale;
            points[1][7] = yoffset+3*scale;
            
            points[0][8] = xoffset+2*scale;
            points[1][8] = yoffset+4*scale;
            
            points[0][9] = xoffset+1*scale;
            points[1][9] = yoffset+4*scale;
            
            points[0][10] = xoffset+1*scale;
            points[1][10] = yoffset+5*scale;
            
            points[0][11] = xoffset+4*scale;
            points[1][11] = yoffset+5*scale;
            
            points[0][12] = xoffset+4*scale;
            points[1][12] = yoffset+6*scale;
            
            points[0][13] = xoffset+3*scale;
            points[1][13] = yoffset+6*scale;
            
            points[0][14] = xoffset+3*scale;
            points[1][14] = yoffset+7*scale;
            
            points[0][15] = xoffset+2*scale;
            points[1][15] = yoffset+7*scale;
            
            points[0][16] = xoffset+2*scale;
            points[1][16] = yoffset+8*scale;
            
            points[0][17] = xoffset+0*scale;
            points[1][17] = yoffset+8*scale;
            
            break;
            
            case 8:
            points = new int[2][6];
            
            points[0][0] = xoffset+0*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+4*scale;
            points[1][3] = yoffset+0*scale;
            
            points[0][4] = xoffset+4*scale;
            points[1][4] = yoffset+5*scale;
            
            points[0][5] = xoffset+0*scale;
            points[1][5] = yoffset+5*scale;
            break;
            
            case 9:
            points = new int[2][12];
            points[0][0] = xoffset+0*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+0*scale;
            points[1][3] = yoffset+0*scale;
            
            points[0][4] = xoffset+0*scale;
            points[1][4] = yoffset+2*scale;
            
            points[0][5] = xoffset+2*scale;
            points[1][5] = yoffset+2*scale;
            
            points[0][6] = xoffset+2*scale;
            points[1][6] = yoffset+3*scale;
            
            points[0][7] = xoffset+4*scale;
            points[1][7] = yoffset+3*scale;
            
            points[0][8] = xoffset+4*scale;
            points[1][8] = yoffset+7*scale;
            
            points[0][9] = xoffset+2*scale;
            points[1][9] = yoffset+7*scale;
            
            points[0][10] = xoffset+2*scale;
            points[1][10] = yoffset+8*scale;
            
            points[0][11] = xoffset+0*scale;
            points[1][11] = yoffset+8*scale;
            break;
            
            case 10:
            points = new int[2][4];
            
            points[0][0] = xoffset+0*scale;
            points[1][0] = yoffset+10*scale;
            
            points[0][1] = xoffset+5*scale;
            points[1][1] = yoffset+10*scale;
            
            points[0][2] = xoffset+5*scale;
            points[1][2] = yoffset+0*scale;
            
            points[0][3] = xoffset+0*scale;
            points[1][3] = yoffset+0*scale;
            break;
        }
        return points;
    }
    
}