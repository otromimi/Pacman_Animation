
package pacman_timer;

import javax.swing.ImageIcon;

/**
 * @author Guillermo Leiro Arroyo
 */

public class Animacion
{
    /**
	 *Secuencias de imagenes usadas para cada uno de las direcciones
	 */
	
	private boolean animacion_on;
    private int step=0;
    private final String up[] = {"../images/pacman.gif",
                                    "../images/up1.gif",
                                    "../images/up2.gif",
                                    "../images/up3.gif",
                                    "../images/up2.gif",
                                    "../images/up1.gif"};
    private final String right[] = {"../images/pacman.gif",
                                    "../images/right1.gif",
                                    "../images/right2.gif",
                                    "../images/right3.gif",
                                    "../images/right2.gif",
                                    "../images/right1.gif"};
    private final String down[] = {"../images/pacman.gif",
                                    "../images/down1.gif",
                                    "../images/down2.gif",
                                    "../images/down3.gif",
                                    "../images/down2.gif",
                                    "../images/down1.gif"};
    private final String left[] = {"../images/pacman.gif",
                                    "../images/left1.gif",
                                    "../images/left2.gif",
                                    "../images/left3.gif",
                                    "../images/left2.gif",
                                    "../images/left1.gif"};

    
    public Animacion(boolean animacion)
    {
        this.animacion_on=animacion;
    }
    public ImageIcon getNextImage(int direccion)
    {
        if(animacion_on)
        {
            step++;
            step=step%6;
        
            switch(direccion)
            {
                case 1:
                    return new ImageIcon(getClass().getResource(up[step]));
                case 2:
                    return new ImageIcon(getClass().getResource(right[step]));
                case 3:
                    return new ImageIcon(getClass().getResource(down[step]));
                case 4:
                    return new ImageIcon(getClass().getResource(left[step]));
                default:
		            return new ImageIcon(getClass().getResource("../images/pacman.gif"));
            }
        }
        else
        {
            return new ImageIcon(getClass().getResource("../images/pacman.gif"));
        }
      
    }

}