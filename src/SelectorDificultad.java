import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JSlider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import java.awt.GridBagLayout;
import java.util.Hashtable;
import java.awt.GridBagConstraints;

/**
 * Esta clase ejecuta una pequeña ventana de selección de dificultad, una vez
 * elegida arranca el juego con los parametros dichos por el usuario
 * 
 * @author Ricardo Martín García
 * 
 * 
 */
public class SelectorDificultad extends JDialog {
    JSlider barraDificulta;

    JButton aceptar;
    int LADO;

    private static final long serialVersionUID = 1L;

    public SelectorDificultad() {
        super();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setBounds((width / 2) - (250 / 2), (height / 2) - (300 / 2), 250, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        anadirElementos();
        ponerListeners();

    }

    private void anadirElementos() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints ajustes = new GridBagConstraints();
        // Poner el texto de selecciona color;
        ajustes.gridx = 0;
        ajustes.gridy = 0;
        ajustes.insets = new Insets(0, 0, 50, 0);

        this.add(new JLabel("Selecciona La dificultad: "), ajustes);

        ajustes.gridy = 2;
        ajustes.insets = new Insets(0, 0, 0, 0);

        // Poner primera barra

        barraDificulta = new JSlider(JSlider.HORIZONTAL, 0, 3, 0);
        ajustes.gridy = 1;
        Hashtable labelTable = new Hashtable();
        labelTable.put(0, new JLabel("Facil"));
        labelTable.put(1, new JLabel("Medio"));
        labelTable.put(2, new JLabel("Dificil  "));
        labelTable.put(3, new JLabel("PRO"));

        barraDificulta.setLabelTable(labelTable);
        barraDificulta.setPaintLabels(true);
        barraDificulta.setMinorTickSpacing(100);
        barraDificulta.setPaintTicks(true);

        this.add(barraDificulta, ajustes);

        // Poner el boton
        ajustes.gridy = 2;
        ajustes.fill = GridBagConstraints.NONE;
        ajustes.ipady = 0;
        ajustes.insets = new Insets(50, 0, 0, 0);
        aceptar = new JButton("JUGAR");
        this.add(aceptar, ajustes);

    }

    // Pone el listener al botón
    private void ponerListeners() {
        aceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (barraDificulta.getValue()) {
                    case 0: {
                        LADO = 5;
                        break;
                    }
                    case 1: {
                        LADO = 10;
                        break;
                    }
                    case 2: {
                        LADO = 15;
                        break;
                    }
                    case 3: {
                        LADO = 20;
                        break;
                    }

                }

                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            VentanaPrincipal vp = new VentanaPrincipal(LADO);
                            vp.inicializar();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                dispose();

            }

        });

    }

}