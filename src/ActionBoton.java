import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author Ricardo Martín García
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
		//Si abrircasilla() nos retorna true significa que no hay mina,  por lo que muestra las minas alrrededor,actualiza la puntuación y si a terminado el juego (por que ya a conseguido los 80 puntos) se muestra el final del juego  
		if(ventana.juego.abrirCasilla(i, j)){
			ventana.mostrarNumMinasAlrededor(i, j);
			ventana.actualizarPuntuacion();
			if(ventana.juego.esFinJuego()){
				ventana.mostrarFinJuego(false);
			}
			//En caso de que nos retorne false significa que hay una mina y se muestra un mensaje de fin dle juego (por explosión)
		}else{
			ventana.ponerImagenesDeMinas();
			ventana.mostrarFinJuego(true);
		}
		//Es importante refrecar la pantalla...
		ventana.refrescarPantalla();

	}

}
