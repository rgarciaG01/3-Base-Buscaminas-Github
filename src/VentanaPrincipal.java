import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * * @author Ricardo Martín García
 * 
 * La clase VentanaPrincipal es la encargada de realizar las tareas en cuando
 * gráficos se refire, es decir nos muestra las ventanas, mensajes , botones
 * etc... Ademas de eso se encarga de poner a escuchar todos los botones tantos
 * los del tablero como el del reiniciar el juego y es encargada de actualizar
 * la puntuación del juego(en el panel), tambien es encargada de refrescar la
 * pantalla y tiene una instancia del ControlJuego(ver descripción de
 * ControlJuego )
 * 
 * @see ControlJuego
 * @version 1.0
 * @since 1.0
 */
public class VentanaPrincipal {

	// La ventana principal, en este caso, guarda todos los componentes:
	JFrame ventana;
	JPanel panelImagen;
	JPanel panelEmpezar;
	JPanel panelPuntuacion;
	JPanel panelJuego;

	// Todos los botones se meten en un panel independiente.
	// Hacemos esto para que podamos cambiar después los componentes por otros
	JPanel[][] panelesJuego;
	JButton[][] botonesJuego;

	JButton botonEmpezar;
	JTextField pantallaPuntuacion;

	// LA VENTANA GUARDA UN CONTROL DE JUEGO:
	ControlJuego juego;

	// Constructor, marca el tamaño y el cierre del frame
	public VentanaPrincipal(int lado) {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 700, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		juego = new ControlJuego(lado);
	}

	// Inicializa todos los componentes del frame
	public void inicializarComponentes() {

		// Definimos el layout:
		ventana.setLayout(new GridBagLayout());

		// Inicializamos componentes
		panelImagen = new JPanel();
		panelEmpezar = new JPanel();
		panelEmpezar.setLayout(new GridLayout(1, 1));
		panelPuntuacion = new JPanel();
		panelPuntuacion.setLayout(new GridLayout(1, 1));
		panelJuego = new JPanel();
		panelJuego.setLayout(new GridLayout(juego.LADO_TABLERO, juego.LADO_TABLERO));

		botonEmpezar = new JButton("Go!");
		pantallaPuntuacion = new JTextField("0");
		pantallaPuntuacion.setEditable(false);
		pantallaPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);

		// Bordes y colores:
		panelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panelEmpezar.setBorder(BorderFactory.createTitledBorder("Empezar"));
		panelPuntuacion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panelJuego.setBorder(BorderFactory.createTitledBorder("Juego"));

		// Colocamos los componentes:
		// AZUL
		GridBagConstraints settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelImagen, settings);
		// VERDE
		settings = new GridBagConstraints();
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelEmpezar, settings);
		// AMARILLO
		settings = new GridBagConstraints();
		settings.gridx = 2;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelPuntuacion, settings);
		// ROJO
		settings = new GridBagConstraints();
		settings.gridx = 0;
		settings.gridy = 1;
		settings.weightx = 1;
		settings.weighty = 10;
		settings.gridwidth = 3;
		settings.fill = GridBagConstraints.BOTH;
		ventana.add(panelJuego, settings);

		// Paneles
		panelesJuego = new JPanel[juego.LADO_TABLERO][juego.LADO_TABLERO];
		for (int i = 0; i < panelesJuego.length; i++) {
			for (int j = 0; j < panelesJuego[i].length; j++) {
				panelesJuego[i][j] = new JPanel();
				panelesJuego[i][j].setLayout(new GridLayout(1, 1));
				panelJuego.add(panelesJuego[i][j]);
			}
		}

		// Inicializamos los botones en un método aparte , esto nos simplificará el
		// volver a caragr otra partida

		this.iniciarBotones();

		// BotónEmpezar:
		panelEmpezar.add(botonEmpezar);
		panelPuntuacion.add(pantallaPuntuacion);

	}

	public void iniciarBotones() {
		ImageIcon icono = new ImageIcon("c.PNG");

		botonesJuego = new JButton[juego.LADO_TABLERO][juego.LADO_TABLERO];
		for (int i = 0; i < botonesJuego.length; i++) {
			for (int j = 0; j < botonesJuego[i].length; j++) {
				botonesJuego[i][j] = new JButton("");
				panelesJuego[i][j].add(botonesJuego[i][j]);

			}
		}
	}

	public void ponerImagenesDeMinas() {

		ImageIcon icono = new ImageIcon("iconoMina.PNG");

		for (int i = 0; i < botonesJuego.length; i++) {
			for (int j = 0; j < botonesJuego[i].length; j++) {
				if (juego.getMinasAlrededor(i, j) == juego.MINA) {
					botonesJuego[i][j].setText("");
					botonesJuego[i][j].setIcon(icono);
				} else {
					botonesJuego[i][j].setText("");
				}
			}
		}

	}

	public void borrarBotones() {
		for (int i = 0; i < botonesJuego.length; i++) {
			for (int j = 0; j < botonesJuego[i].length; j++) {
				panelesJuego[i][j].removeAll();
			}
		}
	}

	/**
	 * Metodo que pone el listener el botón de "Go", reiniciando la partida
	 */

	public void iniciarListenersDeGO() {
		botonEmpezar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.setPuntuacion(0);
				actualizarPuntuacion();
				borrarBotones();
				iniciarBotones();
				inicializarListeners();
				juego.inicializarPartida();
				refrescarPantalla();

			}
		});
	}

	/**
	 * Método que inicializa todos los lísteners que necesita inicialmente el
	 * programa
	 */

	public void inicializarListeners() {
		for (int i = 0; i <= juego.LADO_TABLERO - 1; i++) {
			for (int j = 0; j <= juego.LADO_TABLERO - 1; j++) {
				botonesJuego[i][j].addActionListener(new ActionBoton(this, i, j));
			}
		}

		// dar listenes a botones para que se abran las casillas

	}

	/**
	 * Pinta en la pantalla el número de minas que hay alrededor de la celda Saca el
	 * botón que haya en la celda determinada y añade un JLabel centrado y no
	 * editable con el número de minas alrededor. Se pinta el color del texto según
	 * la siguiente correspondecia (consultar la variable correspondeciaColor): - 0
	 * : negro - 1 : cyan - 2 : verde - 3 : naranja - 4 ó más : rojo
	 * 
	 * @param i: posición vertical de la celda.
	 * @param j: posición horizontal de la celda.
	 */
	public void mostrarNumMinasAlrededor(int i, int j) {
		// TODO
		String numero;
		int aux;
		JLabel jl;
		numero = "" + juego.getMinasAlrededor(i, j);

		panelesJuego[i][j].remove(botonesJuego[i][j]);
		jl = new JLabel(numero);
		aux = Integer.parseInt(numero);
		jl.setHorizontalAlignment(0);

		switch (aux) {
			case 0: {
				jl.setForeground(Color.BLACK);
				break;
			}
			case 1: {
				jl.setForeground(Color.CYAN);
				break;
			}
			case 2: {
				jl.setForeground(Color.GREEN);
				break;
			}
			case 3: {
				jl.setForeground(Color.ORANGE);
				break;
			}
			default: {
				jl.setForeground(Color.RED);
				break;
			}
		}

		panelesJuego[i][j].add(jl);

	}

	/**
	 * Muestra una ventana que indica el fin del juego
	 * 
	 * @param porExplosion : Un booleano que indica si es final del juego porque ha
	 *                     explotado una mina (true) o bien porque hemos desactivado
	 *                     todas (false)
	 * @post : Todos los botones se desactivan excepto el de volver a iniciar el
	 *       juego.
	 */
	public void mostrarFinJuego(boolean porExplosion) {

		String info = "";
		for (int i = 0; i < juego.LADO_TABLERO; i++) {
			for (int j = 0; j < juego.LADO_TABLERO; j++) {
				botonesJuego[i][j].setEnabled(false);
			}
		}
		if (porExplosion) {
			info = "Has perdido, tocaste un mina\n  Has conseguido " + pantallaPuntuacion.getText() + " puntos";
			JOptionPane.showMessageDialog(ventana, info);

		} else {
			info = "¡¡Muy bien!! has conseguido encontrar todas las minas";
			JOptionPane.showMessageDialog(ventana, info);
		}

	}

	/**
	 * Método que muestra la puntuación por pantalla.
	 */
	public void actualizarPuntuacion() {
		pantallaPuntuacion.setText(Integer.toString(juego.getPuntuacion()));
	}

	/**
	 * Método para refrescar la pantalla
	 */
	public void refrescarPantalla() {
		ventana.revalidate();
		ventana.repaint();
	}

	/**
	 * Método que devuelve el control del juego de una ventana
	 * 
	 * @return un ControlJuego con el control del juego de la ventana
	 */
	public ControlJuego getJuego() {
		return juego;
	}

	/**
	 * Método para inicializar el programa
	 */
	public void inicializar() {
		ventana.setVisible(true);
		inicializarComponentes();
		inicializarListeners();
		iniciarListenersDeGO();
	}

}
