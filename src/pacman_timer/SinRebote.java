
package pacman_timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @author Guillermo Leiro Arroyo
 */
public class SinRebote extends Rebote
{
    public SinRebote(String titulo, boolean animacion)
    {
        super(titulo,animacion);
    }

    @Override
    protected void initMetronomo()
	{
		metronomo = new Timer(50,new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int alto = marco.getSize().height;
				int ancho = marco.getSize().width;
				if(y>alto)
					y=alto-30;
				if(x>ancho)
					x=ancho-30;
				switch(direccion)
				{
					case 1:
						if(y>30)
							y=y-2;
						break;
					case 2:
						if(x<ancho-30)
							x=x+2;
						break;
					case 3:
						if(y<alto-30)
							y=y+2;
						break;
					case 4:
						if(x>10)
							x=x-2;
						break;
					default:
				}
				marco.repaint();
			}

		});
	}
}