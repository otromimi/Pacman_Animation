
package pacman_timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;

/**
 * @author Guillermo Leiro Arroyo
 * 
 * Solo decir que no pude implementarlo como me sugeriste ya que la clase KeyAdapter es abstracta y no pude crear un objeto de ella.
 * En su lugar he instanciado la clade JFrame y he sobrescrito su metodo paint en la llamada al constructor.
*/

public class Rebote extends KeyAdapter
{
	protected Timer metronomo;
	private Animacion prota;
	protected JFrame marco;
	protected int direccion=2;//1==N, 2==E, 3==S, 4==W 0==standBy
	private KeyAdapter controles;
	protected int x,y;

	public Rebote(String titulo,boolean animacion)
	{	
		//Inicializacion variables
		marco = new JFrame(titulo)
		{
			public void paint(Graphics g)
			{
				g.fillRect( 0, 0, marco.getWidth(), marco.getHeight());
				prota.getNextImage(direccion).paintIcon(marco,g,x,y);
			}
		};
		prota = new Animacion(animacion);
		x=200;
		y=200;

		this.initMetronomo();//Inicializacion objeto Timer plus listener.

		//Ajustes frame
		marco.addKeyListener(this);
		metronomo.start();
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setSize(500,500);
		marco.setLocationRelativeTo(null);

	}

	//Inicia el objeto metronomo y crea el action perfotmer que le da la funcionalidad al pacman
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
						else
							direccion=3;
						break;
					case 2:
						if(x<ancho-30)
							x=x+2;
						else
							direccion=4;
						break;
					case 3:
						if(y<alto-30)
							y=y+2;
						else
							direccion=1;
						break;
					case 4:
						if(x>10)
							x=x-2;
						else
							direccion=2;
						break;
					default:
				}
				marco.repaint();
			}

		});
	}
	
	//manejo de los eventos de teclado
	public void keyPressed(KeyEvent tecleacion)
    {
        switch(tecleacion.getKeyCode())
        {
            case java.awt.event.KeyEvent.VK_UP:
                direccion=1;
                break;
            case java.awt.event.KeyEvent.VK_RIGHT:
                direccion=2;
                break;
            case java.awt.event.KeyEvent.VK_DOWN:
                direccion=3;
                break;
            case java.awt.event.KeyEvent.VK_LEFT:
                direccion=4;
                break;
            default:
                direccion=0;
        }
    }
	
}