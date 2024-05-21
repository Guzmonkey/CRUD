import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        // Mostrar mensajes en el panel
        // Mostrar mensaje para ingresar el titulo
        JLabel label = new JLabel("Ingresa el titulo: ");
        label.setBounds(20, 20, 150, 30);
        panel.add(label);
        JTextField titleField = new JTextField(20);
        titleField.setBounds(220, 20, 150, 30);
        panel.add(titleField);
        
        // Mostrar mensaje para ingresar el año de publicacion
        JLabel label2 = new JLabel("Ingresa el año de publicación:");
        label2.setBounds(20, 60, 200, 30);
        panel.add(label2);
        JTextField yearField = new JTextField(20);
        yearField.setBounds(220, 60, 200, 30);
        panel.add(yearField);
        
        // Mostrar mensaje para ingresar el num de identifacion
        JLabel label3 = new JLabel("Ingresa el número de identifiación:");
        label3.setBounds(20,100, 200, 30);
        panel.add(label3);
        JTextField numField = new JTextField(20);
        numField.setBounds(220, 100, 200, 30);
        panel.add(numField);
        
        // Mostrar mensaje de ingresar el genero
        JLabel label4 = new JLabel("Ingresa el género:");
        label4.setBounds(20, 140, 200, 30);
        panel.add(label4);
        JTextField genField = new JTextField(20);
        genField.setBounds(220, 140, 200, 30);    
        panel.add(genField);
        
        // Mostrar mensaje para ingresar el autor
        JLabel label5 = new JLabel("Ingresa el autor:");
        label5.setBounds(20, 180, 200, 30);
        panel.add(label5);
        JTextField autorField = new JTextField(20);
        autorField.setBounds(220, 180, 200, 30);
        panel.add(autorField);
        
        // Mostrar mensaje para ingresar el numero de paginas
        JLabel label6 = new JLabel("Ingresa el numero de páginas:");
        label6.setBounds(20, 220, 200, 30);
        panel.add(label6);
        JTextField pagField = new JTextField(20);
        pagField.setBounds(220, 220, 200, 30);
        panel.add(pagField);

        // Mostrar mensaje para ingresar el numero de capitulos
        JLabel label7 = new JLabel("Ingresa el número de capitulos:");
        label7.setBounds(20, 260, 200, 30);
        panel.add(label7);
        JTextField capField = new JTextField(20);
        capField.setBounds(220, 260, 200, 30);
        panel.add(capField);

        // Agregar boton para que se guarde la información
        JButton botonAgregar = new JButton("Agregar Libro");
        botonAgregar.setBounds(20, 300, 160, 30);
        panel.add(botonAgregar);
        botonAgregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                String titulo = titleField.getText();
                String anio = yearField.getText();
                String numIdentificacion = numField.getText();
                String genero = genField.getText();
                String autor = autorField.getText();
                String numPaginas = pagField.getText();
                String numCapitulos = capField.getText();
                elementos.add(new Libro(titulo, anio, numIdentificacion, genero, autor, numPaginas, numCapitulos));
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt", true))){
                    writer.write("Título: " + titulo + "\n");
                    writer.write("Año de publicación: " + anio + "\n");
                    writer.write("Número de identificación: " + numIdentificacion + "\n");
                    writer.write("Género: " + genero + "\n");
                    writer.write("Autor: " + autor + "\n");
                    writer.write("Número de páginas: " + numPaginas + "\n");
                    writer.write("Número de capítulos: " + numCapitulos + "\n");
                    writer.write("\n");
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Se guardaron los datos exitosamente!");
            }
        });
        mostrarDatosGuardados();
    }

     private void mostrarDatosGuardados() {
        JFrame frame = new JFrame("Datos Guardados");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        try (BufferedReader reader = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


