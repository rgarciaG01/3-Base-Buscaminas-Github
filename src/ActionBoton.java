import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener{

	private VentanaPrincipal ventana;
	private int i;
	private int j;
	
	public ActionBoton(VentanaPrincipal venta, int ien,int jen) {
		ventana = venta;
		i = ien;
		j = jen;
	}
	
	/**
	 *Acción que ocurrirá cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(ventana.juego.abrirCasilla(i, j)){
			ventana.mostrarNumMinasAlrededor(i, j);
			ventana.actualizarPuntuacion();
		}else{
			ventana.mostrarFinJuego(true);
		}

		ventana.refrescarPantalla();

	}

}
