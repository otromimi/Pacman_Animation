
package pacman_timer;

/**
 * @author Guillermo Leiro Arroyo
 * 
 * La aplicacion abre las dos ventanas a la vez un a encima de otra 
 * Si solo se quiere ver una comentar la que no se quiera ver//
 */
public class Aplicacion
{
    public static void main(String args[])
    {
        new Rebote("Rebote",false);   
        new SinRebote("Sin_Rebote",true);
        
    }
}