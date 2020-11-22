import java.awt.EventQueue;

/**
 * Clase principal del Buscaminas
 * 
 * @author Ricardo Martín García
 *
 */
public class Principal {

	/**
	 * Método main, es el método principal y su función es llamar al JDialog
	 * 
	 * @param args : Cadenas de parámetros del main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectorDificultad selector = new SelectorDificultad();
					selector.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
