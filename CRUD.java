import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class CRUD {
   ArrayList<ElementoBiblioteca> elementos = new ArrayList<>();

    public CRUD() {
        // Creacion de un jframe
        JFrame frame = new JFrame("Biblioteca");
        frame.setSize(600, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creacion de un jpanel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setLocationRelativeTo(null); // Centramos la ventana en la pantalla
        frame.setVisible(true);
        
    }
    /* 
     * Método para mostrar botones en el interfaz
     */
    private void placeComponents(JPanel panel){
        panel.setLayout(null);
        JLabel label = new JLabel("Elige una opcion: ");
        label.setBounds(25, 25, 200, 25);
        panel.add(label);
        // Boton 1 para agregar libros
        JButton button1 = new JButton("Libros");
        button1.setBounds(20, 60, 160, 30);
        panel.add(button1);
          // Agregar ActionListener a cada botón
          button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Libros");
                frame2.setSize(1000, 900);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel2 = new JPanel();
                frame2.add(panel2);
                placeComponentsBooks(panel2);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        // Boton 2 para agregar revistas
        JButton button2 = new JButton("Revistas");
        button2.setBounds(200, 60, 160, 30);
        panel.add(button2);
        // Boton 3 para agregar DVD
        JButton button3 = new JButton("DVD\'s");
        button3.setBounds(380, 60, 160, 30);
        panel.add(button3);

    }

    private void placeComponentsBooks(JPanel panel){
        panel.setLayout(null);
        JLabel label = new JLabel("Ingresa el titulo: ");
        label.setBounds(20, 20, 150, 30);
        panel.add(label);
        JLabel label2 = new JLabel("Ingresa el año de publicación:");
        label2.setBounds(20, 40, 200, 30);
        panel.add(label2);
        JLabel label3 = new JLabel("Ingresa el número de identifiación:");
        label3.setBounds(20, 60, 200, 30);
        panel.add(label3);
    }
}

