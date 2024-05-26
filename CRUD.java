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
    int books = 0;

    public CRUD() {
        // Creación de un JFrame
        JFrame frame = new JFrame("Biblioteca");
        frame.setSize(600, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creación de un JPanel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /*
     * Método para mostrar botones en la interfaz
     */
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        // Creación del JLabel
        JLabel label = new JLabel("Elige una opción: ");
        label.setBounds(25, 25, 200, 25);
        panel.add(label);

        // Creación del primer botón
        JButton botonLibros = new JButton("Libros");
        botonLibros.setBounds(20, 60, 160, 30);
        panel.add(botonLibros);

        // Agregar ActionListener a cada botón
        botonLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Libros");
                frame2.setSize(600, 500);
                JPanel panel2 = new JPanel();
                frame2.add(panel2);
                placeComponentsBooks(panel2);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
    }

    /*
     * Método para mostrar interfaz de la opción libros
     */
    private void placeComponentsBooks(JPanel panel) {
        panel.setLayout(null);
        // Asignar título
        JLabel label = new JLabel("Ingresa el título:");
        label.setBounds(20, 20, 150, 30);
        panel.add(label);
        JTextField titleField = new JTextField(20);
        titleField.setBounds(220, 20, 150, 30);
        panel.add(titleField);

        // Asignar año de publicación
        JLabel label2 = new JLabel("Ingresa el año de publicación:");
        label2.setBounds(20, 60, 200, 30);
        panel.add(label2);
        JTextField anioField = new JTextField(20);
        anioField.setBounds(220, 60, 200, 30);
        panel.add(anioField);

        // Asignar el id
        JLabel label3 = new JLabel("Ingresa el número de identificación:");
        label3.setBounds(20, 100, 200, 30);
        panel.add(label3);
        JTextField idField = new JTextField(20);
        idField.setBounds(220, 100, 200, 30);
        panel.add(idField);

        // Asignar género
        JLabel label4 = new JLabel("Ingresa el género:");
        label4.setBounds(20, 140, 200, 30);
        panel.add(label4);
        JTextField genField = new JTextField(20);
        genField.setBounds(220, 140, 200, 30);
        panel.add(genField);

        // Asignar autor
        JLabel label5 = new JLabel("Ingresa el autor:");
        label5.setBounds(20, 180, 200, 30);
        panel.add(label5);
        JTextField autorField = new JTextField(20);
        autorField.setBounds(220, 180, 200, 30);
        panel.add(autorField);

        // Asignar número de páginas
        JLabel label6 = new JLabel("Ingresa el número de páginas:");
        label6.setBounds(20, 220, 200, 30);
        panel.add(label6);
        JTextField numPagField = new JTextField(20);
        numPagField.setBounds(220, 220, 200, 30);
        panel.add(numPagField);

        // Asignar número de capítulos
        JLabel label7 = new JLabel("Ingresa el número de capítulos:");
        label7.setBounds(20, 260, 200, 30);
        panel.add(label7);
        JTextField capField = new JTextField(20);
        capField.setBounds(220, 260, 200, 30);
        panel.add(capField);

        // Botón para agregar libro
        JButton botonAgregar = new JButton("Agregar libro");
        botonAgregar.setBounds(20, 300, 160, 30);
        panel.add(botonAgregar);
        botonAgregar.addActionListener(event -> {
            String titulo = titleField.getText();
            String anio = anioField.getText();
            String numId = idField.getText();
            String genero = genField.getText();
            String autor = autorField.getText();
            String numPaginas = numPagField.getText();
            String numCapitulos = capField.getText();
            // Guardamos los datos en una clase
            elementos.add(new Libro(titulo, anio, numId, genero, autor, numPaginas, numCapitulos));
            // Escribimos los datos en un archivo de texto
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt", true))) {
                writer.write("Título: " + titulo + "\n");
                writer.write("Año de publicación: " + anio + "\n");
                writer.write("Número de identificación: " + numId + "\n");
                writer.write("Género: " + genero + "\n");
                writer.write("Autor: " + autor + "\n");
                writer.write("Número de páginas: " + numPaginas + "\n");
                writer.write("Número de capítulos: " + numCapitulos + "\n");
                writer.write("\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            books++;
            JOptionPane.showMessageDialog(null, "¡Se guardaron correctamente los datos!");
        });

        // Botón para mostrar información
        JButton mostrarBoton = new JButton("Mostrar información");
        mostrarBoton.setBounds(200, 300, 160, 30);
        panel.add(mostrarBoton);
        mostrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLibrosGuardados();
            }
        });

        // Botón para eliminar información
        JButton eliminarBoton = new JButton("Eliminar");
        eliminarBoton.setBounds(20, 340, 160, 30);
        panel.add(eliminarBoton);
        eliminarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameEliminar = new JFrame("Eliminar libros");
                frameEliminar.setSize(400, 300);
                frameEliminar.setVisible(true);
                JPanel panelEliminar = new JPanel();
                frameEliminar.add(panelEliminar);
                panelEliminar.setLayout(null);
                JLabel labelEliminar = new JLabel("Ingresa el número de identifiación: ");
                labelEliminar.setBounds(5, 0, 200, 30);
                panelEliminar.add(labelEliminar);
                JTextField textEliminar = new JTextField(20);
                textEliminar.setBounds(5, 30, 200, 30);
                panelEliminar.add(textEliminar);
                JButton buscarLibro = new JButton("Buscar");
                buscarLibro.setBounds(5, 70, 100, 30);
                panelEliminar.add(buscarLibro);
                buscarLibro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        String id = idField.getText();
                        eliminarInformacionLibros(id);
                    }
                });
                frameEliminar.setLocationRelativeTo(null);
            }
        });
    }

    /*
     * Método para mostrar todos los libros guardados
     */
    public void mostrarLibrosGuardados() {
        JFrame frame = new JFrame("Libros guardados");
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

    /*
     * Método para buscar los elementos
     */
    public boolean buscarInformacion(String id) {
        // Declaración de variables
        int count = 0;
        boolean found = false;

        if (!elementos.isEmpty()) {
            do {
                if (elementos.get(count).getNumIdentificacion().equals(id)) {
                    found = true;
                }
                count++;
            } while (!found && count < elementos.size());
        }
        return found;
    }

    /*
     * Método para eliminar información
     */

     public void eliminarInformacionLibros(String id) {
        boolean encontrado = false;
        for (ElementoBiblioteca elemento : elementos) {
            if (elemento.getNumIdentificacion().equals(id)) {
                elementos.remove(elemento);
                encontrado = true;
                break; // Se detiene después de eliminar el primer libro con el ID dado
            }
        }
    
        if (encontrado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt"))) {
                for (ElementoBiblioteca elemento : elementos) {
                    if (elemento instanceof Libro) {
                        Libro libro = (Libro) elemento;
                        writer.write("Título: " + libro.getTitulo() + "\n");
                        writer.write("Año de publicación: " + libro.getAnioPublicacion() + "\n");
                        writer.write("Número de identificación: " + libro.getNumIdentificacion() + "\n");
                        writer.write("Género: " + libro.getGenero() + "\n");
                        writer.write("Autor: " + libro.getAutor() + "\n");
                        writer.write("Número de páginas: " + libro.getNumPaginas() + "\n");
                        writer.write("Número de capítulos: " + libro.getNumCapitulos() + "\n");
                        writer.write("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente el libro con ID: " + id);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún libro con el ID: " + id);
        }
    }    
}
