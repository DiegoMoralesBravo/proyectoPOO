package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import controller.Resize;

public class View extends JFrame {

    public JButton prev, next, addImage, viewImages, imageLoaderButton, confirmButton, cancelButton;

    public static JLabel imagenPreview, chartPreview;

    public static JLabel nombre, numero, tamano, morfologia, fecha, comentarios;

    public static JTextField inputName, inputMorfologia;

    public JPanel panel1, panel2;

    public JTextArea textAreaComentarios;

    public JScrollPane scrollArea;

    public View() {

        panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setBounds(10, 50, 1005, 670);
        panel1.setVisible(false);

        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setBounds(10, 50, 1005, 670);
        panel2.setVisible(true);

        addImage = new JButton("Add image");
        addImage.setBounds(211, 1, 200, 50);
        addImage.setBackground(Color.white);

        viewImages = new JButton("View images");
        viewImages.setBounds(10, 1, 200, 50);
        viewImages.setBackground(Color.white);

        config();

        loadPanelOneComponents();
        loadPanelTwoComponents();

        panel1.add(prev);
        panel1.add(next);

        panel2.add(imageLoaderButton);

        panel2.add(imagenPreview);
        panel2.add(chartPreview);



        panel2.add(nombre);
        panel2.add(inputName);

        panel2.add(numero);
        panel2.add(tamano);

        panel2.add(morfologia);
        panel2.add(inputMorfologia);

        panel2.add(comentarios);

        panel2.add(scrollArea);


        panel2.add(confirmButton);
        panel2.add(cancelButton);

        add(panel1);
        add(panel2);

        add(viewImages);
        add(addImage);

        panel2.setLayout(null);
        panel1.setLayout(null);
    }

    private void loadPanelOneComponents() {

        // Aqui seria poner un tipo preview sin nada de informacion

        prev = new JButton("<");
        prev.setBounds(10, 369, 60, 30);

        next = new JButton(">");
        next.setBounds(1, 1, 60, 30);
    }

    /**
     * 
     */
    private void loadPanelTwoComponents() {

        imageLoaderButton = new JButton("Cargar nueva imagen");
        imageLoaderButton.setBounds((1005 / 2) - 100, (768 / 2) - 60, 200, 30);
        imageLoaderButton.setVisible(false);

        imagenPreview = new JLabel();
        imagenPreview.setIcon(new ImageIcon("test1.png"));
        imagenPreview.setBounds(20, 20, 400, 300);

        chartPreview = new JLabel();
        chartPreview.setIcon(new ImageIcon("test2.png"));
        chartPreview.setBounds(20, 340, 400, 300);

        nombre = new JLabel("Nombre: ");
        nombre.setBounds(500, 20, 100, 20);

        inputName = new JTextField();
        inputName.setBounds(600, 20, 200, 20);

        numero = new JLabel("Numero: ");
        numero.setBounds(500, 60, 100, 20);

        tamano = new JLabel("Tamano: ");
        tamano.setBounds(500, 100, 100, 20);

        morfologia = new JLabel("Morfologia: ");
        morfologia.setBounds(500, 140, 100, 20);

        inputMorfologia = new JTextField();
        inputMorfologia.setBounds(600, 140, 200, 20);

        comentarios = new JLabel("Comentarios: ");
        comentarios.setBounds(500, 180, 100, 20);

        textAreaComentarios = new JTextArea("Comentario...");
        scrollArea = new JScrollPane(textAreaComentarios);
        scrollArea.setBounds(500, 200, 100, 200);


        confirmButton = new JButton("Guardar");
        confirmButton.setBounds(600, 580, 120, 60);

        cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(800, 580, 120, 60);

        // cancelButton.setVisible(false);
        // confirmButton.setVisible(false);
        // scrollArea.setVisible(false);
        // textArea.setVisible(false);

    }

    private void config() {
        // Salir
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Titulo
        this.setTitle("Proyecto POO");

        // Tamano
        this.setSize(1024, 768);

        this.setLocationRelativeTo(null);

        this.getContentPane().setBackground(Color.lightGray);

        this.setResizable(false);
        this.setEnabled(true);
        this.setLayout(null);
    }
}
