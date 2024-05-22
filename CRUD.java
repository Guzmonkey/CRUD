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
   int magazines = 0;
   int dvds = 0;

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
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Revistas");
                frame2.setSize(1000, 900);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel2 = new JPanel();
                frame2.add(panel2);
                placeComponentsMagazines(panel2);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });
        // Boton 3 para agregar DVD
        JButton button3 = new JButton("DVDs");
        button3.setBounds(380, 60, 160, 30);
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("DVDs");
                frame2.setSize(1000, 900);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel2 = new JPanel();
                frame2.add(panel2);
                placeComponentsDVDs(panel2);
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
            }
        });

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
        botonAgregar.addActionListener(event -> {
            String titulo = titleField.getText();
            String anio = yearField.getText();
            String numIdentificacion = numField.getText();
            String genero = genField.getText();
            String autor = autorField.getText();
            String numPaginas = pagField.getText();
            String numCapitulos = capField.getText();
            elementos.add(new Libro(titulo, anio, numIdentificacion, genero, autor, numPaginas, numCapitulos));
            if (books == 0){
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt"))){
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
            }else{
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
            }
            books++;
            JOptionPane.showMessageDialog(null, "Se guardaron los datos exitosamente!");
        });
        
        JButton mostrarBoton = new JButton("Mostrar Información");
        mostrarBoton.setBounds(200, 300, 160, 30);
        panel.add(mostrarBoton);
        mostrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarLibrosGuardados();
            }
        });
        
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(20, 350, 160, 30);
        panel.add(botonEliminar);
        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numId = numField.getText();
                if (buscarElemento(numId) == true){
                    eliminarElemento(numId, "libro");
                    actualizarDatos("libros");
                    JOptionPane.showMessageDialog(null, "Elemento eliminado exitosamente.");
                }else{
                    JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                }
                books--;
            }
        });
        
        JButton botonEditar = new JButton("Editar");
        botonEditar.setBounds(200, 350, 160, 30);
        panel.add(botonEditar);
        botonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numId = numField.getText();
                if (buscarElemento(numId) == true){
                    String titulo = titleField.getText();
                    String anio = yearField.getText();
                    String numIdentificacion = numField.getText();
                    String genero = genField.getText();
                    String autor = autorField.getText();
                    String numPaginas = pagField.getText();
                    String numCapitulos = capField.getText();
                    int count = 0;
                    boolean found = false;
                    do{
                       if (elementos.get(count).getNumIdentificacion().equals(numIdentificacion)){
                           elementos.set(count, new Libro(titulo, anio, numIdentificacion, genero, autor, numPaginas, numCapitulos));
                           found = true;
                       }
                       count++;
                    }while(found==false && count<elementos.size());
                    actualizarDatos("libros");
                    JOptionPane.showMessageDialog(null, "Elemento editado exitosamente.");
                }else{
                    JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                }
            }
        });
    }
    
    private void placeComponentsMagazines(JPanel panel){
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
        JLabel label6 = new JLabel("Ingresa el numero de ejemplares:");
        label6.setBounds(20, 220, 200, 30);
        panel.add(label6);
        JTextField ejempField = new JTextField(20);
        ejempField.setBounds(220, 220, 200, 30);
        panel.add(ejempField);

        // Mostrar mensaje para ingresar el numero de capitulos
        JLabel label7 = new JLabel("Ingresa los editores:");
        label7.setBounds(20, 260, 200, 30);
        panel.add(label7);
        JTextField editField = new JTextField(20);
        editField.setBounds(220, 260, 200, 30);
        panel.add(editField);

        // Agregar boton para que se guarde la información
        JButton botonAgregar = new JButton("Agregar Revista");
        botonAgregar.setBounds(20, 300, 160, 30);
        panel.add(botonAgregar);
        botonAgregar.addActionListener(event -> {
            String titulo = titleField.getText();
            String anio = yearField.getText();
            String numIdentificacion = numField.getText();
            String genero = genField.getText();
            String autor = autorField.getText();
            String numEjemplares = ejempField.getText();
            String editores = editField.getText();
            elementos.add(new Revista(titulo, anio, numIdentificacion, genero, autor, numEjemplares, editores));
            if (magazines == 0){
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("revistas.txt"))){
                    writer.write("Título: " + titulo + "\n");
                    writer.write("Año de publicación: " + anio + "\n");
                    writer.write("Número de identificación: " + numIdentificacion + "\n");
                    writer.write("Género: " + genero + "\n");
                    writer.write("Autor: " + autor + "\n");
                    writer.write("Número de ejemplares: " + numEjemplares + "\n");
                    writer.write("Editores: " + editores + "\n");
                    writer.write("\n");
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else{
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("revistas.txt", true))){
                    writer.write("Título: " + titulo + "\n");
                    writer.write("Año de publicación: " + anio + "\n");
                    writer.write("Número de identificación: " + numIdentificacion + "\n");
                    writer.write("Género: " + genero + "\n");
                    writer.write("Autor: " + autor + "\n");
                    writer.write("Número de ejemplares: " + numEjemplares + "\n");
                    writer.write("Editores: " + editores + "\n");
                    writer.write("\n");
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            magazines++;
            JOptionPane.showMessageDialog(null, "Se guardaron los datos exitosamente!");
        });
        
        JButton mostrarBoton = new JButton("Mostrar Información");
        mostrarBoton.setBounds(200, 300, 160, 30);
        panel.add(mostrarBoton);
        mostrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRevistasGuardadas();
            }
        });
        
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(20, 350, 160, 30);
        panel.add(botonEliminar);
        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numId = numField.getText();
                if (buscarElemento(numId) == true){
                    eliminarElemento(numId, "revista");
                    actualizarDatos("revistas");
                    JOptionPane.showMessageDialog(null, "Elemento eliminado exitosamente.");
                }else{
                    JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                }
                magazines--;
            }
        });
        
        JButton botonEditar = new JButton("Editar");
        botonEditar.setBounds(200, 350, 160, 30);
        panel.add(botonEditar);
        botonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numId = numField.getText();
                if (buscarElemento(numId) == true){
                    String titulo = titleField.getText();
                    String anio = yearField.getText();
                    String numIdentificacion = numField.getText();
                    String genero = genField.getText();
                    String autor = autorField.getText();
                    String numEjemplares = ejempField.getText();
                    String editores = editField.getText();
                    int count = 0;
                    boolean found = false;
                    do{
                       if (elementos.get(count).getNumIdentificacion().equals(numIdentificacion)){
                           elementos.set(count, new Revista(titulo, anio, numIdentificacion, genero, autor, numEjemplares, editores));
                           found = true;
                       }
                       count++;
                    }while(found==false && count<elementos.size());
                    actualizarDatos("revistas");
                    JOptionPane.showMessageDialog(null, "Elemento editado exitosamente.");
                }else{
                    JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                }
            }
        });
    }
    
    private void placeComponentsDVDs(JPanel panel){
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
        JLabel label6 = new JLabel("Ingresa la duración:");
        label6.setBounds(20, 220, 200, 30);
        panel.add(label6);
        JTextField durField = new JTextField(20);
        durField.setBounds(220, 220, 200, 30);
        panel.add(durField);

        // Mostrar mensaje para ingresar el numero de capitulos
        JLabel label7 = new JLabel("Ingresa el idioma:");
        label7.setBounds(20, 260, 200, 30);
        panel.add(label7);
        JTextField idiomField = new JTextField(20);
        idiomField.setBounds(220, 260, 200, 30);
        panel.add(idiomField);

        // Agregar boton para que se guarde la información
        JButton botonAgregar = new JButton("Agregar DVD");
        botonAgregar.setBounds(20, 300, 160, 30);
        panel.add(botonAgregar);
        botonAgregar.addActionListener(event -> {
            String titulo = titleField.getText();
            String anio = yearField.getText();
            String numIdentificacion = numField.getText();
            String genero = genField.getText();
            String autor = autorField.getText();
            String duracion = durField.getText();
            String idioma = idiomField.getText();
            elementos.add(new DVD(titulo, anio, numIdentificacion, genero, autor, duracion, idioma));
            if (dvds == 0){
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("dvds.txt"))){
                    writer.write("Título: " + titulo + "\n");
                    writer.write("Año de publicación: " + anio + "\n");
                    writer.write("Número de identificación: " + numIdentificacion + "\n");
                    writer.write("Género: " + genero + "\n");
                    writer.write("Autor: " + autor + "\n");
                    writer.write("Duración: " + duracion + "\n");
                    writer.write("Idioma: " + idioma + "\n");
                    writer.write("\n");
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else{
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("dvds.txt", true))){
                    writer.write("Título: " + titulo + "\n");
                    writer.write("Año de publicación: " + anio + "\n");
                    writer.write("Número de identificación: " + numIdentificacion + "\n");
                    writer.write("Género: " + genero + "\n");
                    writer.write("Autor: " + autor + "\n");
                    writer.write("Duración: " + duracion + "\n");
                    writer.write("Idioma: " + idioma + "\n");
                    writer.write("\n");
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            dvds++;
            JOptionPane.showMessageDialog(null, "Se guardaron los datos exitosamente!");
        });
        
        JButton mostrarBoton = new JButton("Mostrar Información");
        mostrarBoton.setBounds(200, 300, 160, 30);
        panel.add(mostrarBoton);
        mostrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDVDsGuardados();
            }
        });
        
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(20, 350, 160, 30);
        panel.add(botonEliminar);
        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numId = numField.getText();
                if (buscarElemento(numId) == true){
                    eliminarElemento(numId, "dvd");
                    actualizarDatos("dvds");
                    JOptionPane.showMessageDialog(null, "Elemento eliminado exitosamente.");
                }else{
                    JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                }
                dvds--;
            }
        });
        
        JButton botonEditar = new JButton("Editar");
        botonEditar.setBounds(200, 350, 160, 30);
        panel.add(botonEditar);
        botonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numId = numField.getText();
                if (buscarElemento(numId) == true){
                    String titulo = titleField.getText();
                    String anio = yearField.getText();
                    String numIdentificacion = numField.getText();
                    String genero = genField.getText();
                    String autor = autorField.getText();
                    String duracion = durField.getText();
                    String idioma = idiomField.getText();
                    int count = 0;
                    boolean found = false;
                    do{
                       if (elementos.get(count).getNumIdentificacion().equals(numIdentificacion)){
                           elementos.set(count, new DVD(titulo, anio, numIdentificacion, genero, autor, duracion, idioma));
                           found = true;
                       }
                       count++;
                    }while(found==false && count<elementos.size());
                    actualizarDatos("dvds");
                    JOptionPane.showMessageDialog(null, "Elemento editado exitosamente.");
                }else{
                    JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                }
            }
        });
    }
    
   private void eliminarElemento(String numeroId, String tipoElemento){
        switch (tipoElemento){
            case "libro":
                int count = 0;
                do{
                    if (elementos.get(count).getNumIdentificacion().equals(numeroId)){
                        elementos.remove(count);
                        actualizarDatos("libros");
                        break;
                    }
                    count++;
                }while (count < elementos.size());
                break;
            case "revista":
                count = 0;
                do{
                    if (elementos.get(count).getNumIdentificacion().equals(numeroId)){
                        elementos.remove(count);
                        actualizarDatos("revistas");
                        break;
                    }
                    count++;
                }while (count < elementos.size());
                break;
            case "dvd":
                if (buscarElemento(numeroId) == true){
                    eliminarElemento(numeroId);
                    actualizarDatos("dvds");
                }
                break;
        }
    }
   
   private void actualizarDatos(String tipoElemento){
       try(BufferedWriter writer = new BufferedWriter(new FileWriter(tipoElemento+".txt"))){
           int count = 0;
           do{
               if (tipoElemento.equals("libros") && elementos.get(count) instanceof Libro){
                   writer.write("Título: " + elementos.get(count).getTitulo() + "\n");
                   writer.write("Año de publicación: " + elementos.get(count).getAnioPublicacion() + "\n");
                   writer.write("Número de identificación: " + elementos.get(count).getNumIdentificacion() + "\n");
                   writer.write("Género: " + elementos.get(count).getGenero() + "\n");
                   writer.write("Autor: " + elementos.get(count).getAutor() + "\n");
                   Libro libro = (Libro) elementos.get(count);
                   writer.write("Número de páginas: " + libro.getNumPaginas() + "\n");
                   writer.write("Número de capítulos: " + libro.getNumCapitulos() + "\n");
                   writer.write("\n");
               }else if (tipoElemento.equals("revistas") && elementos.get(count) instanceof Revista){
                   writer.write("Título: " + elementos.get(count).getTitulo() + "\n");
                   writer.write("Año de publicación: " + elementos.get(count).getAnioPublicacion() + "\n");
                   writer.write("Número de identificación: " + elementos.get(count).getNumIdentificacion() + "\n");
                   writer.write("Género: " + elementos.get(count).getGenero() + "\n");
                   writer.write("Autor: " + elementos.get(count).getAutor() + "\n");
                   Revista revista = (Revista) elementos.get(count);
                   writer.write("Número de ejemplares: " + revista.getNumEjemplares() + "\n");
                   writer.write("Editores: " + revista.getEditores() + "\n");
                   writer.write("\n");
               }else if (tipoElemento.equals("dvds") && elementos.get(count) instanceof DVD){
                   writer.write("Título: " + elementos.get(count).getTitulo() + "\n");
                   writer.write("Año de publicación: " + elementos.get(count).getAnioPublicacion() + "\n");
                   writer.write("Número de identificación: " + elementos.get(count).getNumIdentificacion() + "\n");
                   writer.write("Género: " + elementos.get(count).getGenero() + "\n");
                   writer.write("Autor: " + elementos.get(count).getAutor() + "\n");
                   DVD dvd = (DVD) elementos.get(count);
                   writer.write("Duracion: " + dvd.getDuracion() + "\n");
                   writer.write("Idioma: " + dvd.getIdioma() + "\n");
                   writer.write("\n");
               }
               count++;
           }while (count < elementos.size());
        }catch (IOException ex) {
            ex.printStackTrace();
        }
   }
   
   private boolean buscarElemento(String numeroId){
       int count = 0;
       boolean found = false;
       if (!elementos.isEmpty()){
           do{
               if (elementos.get(count).getNumIdentificacion().equals(numeroId)){
                   found = true;
               }
               count++;
           }while(found==false && count<elementos.size());
       }
       return found;
   }
   
   private void eliminarElemento(String numeroId){
       int count = 0;
       boolean found = false;
       if (!elementos.isEmpty()){
           do{
               if (elementos.get(count).getNumIdentificacion().equals(numeroId)){
                   found = true;
                   elementos.remove(count);
                   break;
               }
               count++;
           }while(found==false);
       }
   }
    
     private void mostrarLibrosGuardados() {
        JFrame frame = new JFrame("Libros Guardados");
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
     
     private void mostrarRevistasGuardadas() {
        JFrame frame = new JFrame("Revistas Guardadas");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        try (BufferedReader reader = new BufferedReader(new FileReader("revistas.txt"))) {
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
     
     private void mostrarDVDsGuardados() {
        JFrame frame = new JFrame("DVDs Guardados");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        try (BufferedReader reader = new BufferedReader(new FileReader("dvds.txt"))) {
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
