import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.JSlider;

import javax.swing.event.*;

import java.applet.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.color.*;

import java.awt.*;

import java.awt.GridBagLayout;
import java.util.Hashtable;
import java.awt.GridBagConstraints;

public class SelectorDificultad extends JDialog {
    JSlider barraDificulta;

    JButton aceptar;
    int LADO;

    private static final long serialVersionUID = 1L;

    public SelectorDificultad() {
        super();
        setModal(true);
        setBounds(0, 0, 250, 300);
        añadirElementos();
        ponerListeners();

    }

    private void añadirElementos() {

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
        ajustes.insets = new Insets(50,0,0,0);
        aceptar = new JButton("JUGAR");
        this.add(aceptar, ajustes);

    }

    private void ponerListeners() {
        aceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch(barraDificulta.getValue()){
                    case 0:{
                        LADO = 5;
                    break;
                    }
                    case 1:{
                        LADO = 10;
                        break;
                    }
                    case 2:{
                        LADO = 15;
                        break;
                    }
                    case 3:{
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