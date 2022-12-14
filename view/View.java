package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class View extends JFrame {

    public JButton prev, next, addImage, viewImages, imageLoaderButton, confirmButton, cancelButton, exportButton;

    public JLabel imagenPreview, chartPreview;

    public JLabel imagenReport, chartReport;

    public JLabel nombre, numero, tamano, fecha, morfologia, comentarios;

    public JLabel inputNumero, inputTamano;

    public JLabel noHay, reporteTXT;

    public JTextField inputName;

    public JComboBox jboxMorfologia;

    public JPanel panel1, panel2, panel2Inputs;

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

        panel2Inputs = new JPanel();
        panel2Inputs.setBounds(500, 20, 300, 300);

        addImage = new JButton("Anadir imagen");
        addImage.setBounds(211, 1, 200, 50);
        addImage.setBackground(Color.white);

        viewImages = new JButton("Ver imagenes");
        viewImages.setBounds(10, 1, 200, 50);
        viewImages.setBackground(Color.white);

        config();

        loadPanelOneComponents();
        loadPanelTwoComponents();

        panel1.add(prev);
        panel1.add(next);
        panel1.add(noHay);
        panel1.add(reporteTXT);
        panel1.add(imagenReport);
        panel1.add(chartReport);

        panel1.add(exportButton);

        panel2.add(imageLoaderButton);

        panel2.add(imagenPreview);
        panel2.add(chartPreview);

        panel2Inputs.add(nombre);
        panel2Inputs.add(inputName);
        panel2Inputs.add(numero);
        panel2Inputs.add(tamano);
        panel2Inputs.add(morfologia);
        panel2Inputs.add(jboxMorfologia);
        panel2Inputs.add(comentarios);
        panel2Inputs.add(scrollArea);
        panel2Inputs.add(inputNumero);
        panel2Inputs.add(inputTamano);

        panel2.add(panel2Inputs);

        panel2.add(confirmButton);
        panel2.add(cancelButton);

        add(panel1);
        add(panel2);

        add(viewImages);
        add(addImage);

        panel2.setLayout(null);
        panel2Inputs.setLayout(null);
        panel1.setLayout(null);
    }

    private void loadPanelOneComponents() {

        // Aqui seria poner un tipo preview sin nada de informacion

        prev = new JButton("<");
        prev.setBounds(10, (768 / 2) - 60, 60, 20);

        next = new JButton(">");
        next.setBounds(1005 - 70, (768 / 2) - 60, 60, 20);

        noHay = new JLabel("No hay reportes que mostrar...");
        noHay.setBounds((1005 / 2) - 120, (768 / 2) - 60, 300, 30);

        reporteTXT = new JLabel();
        reporteTXT.setBounds(90, 300, 600, 500);

        imagenReport = new JLabel();
        imagenReport.setBounds(90, 100, 400, 300);

        chartReport = new JLabel();
        chartReport.setBounds(520, 100, 400, 300);

        exportButton = new JButton("Exportar");
        exportButton.setBounds(760, 580, 120, 60);

        exportButton.setVisible(false);

        next.setVisible(false);
        prev.setVisible(false);
    }

    /**
     * 
     */
    private void loadPanelTwoComponents() {

        imageLoaderButton = new JButton("Cargar nueva imagen");
        imageLoaderButton.setBounds((1005 / 2) - 100, (768 / 2) - 60, 200, 30);

        imagenPreview = new JLabel();
        imagenPreview.setBounds(20, 20, 400, 300);

        chartPreview = new JLabel();
        chartPreview.setBounds(20, 340, 400, 300);

        nombre = new JLabel("Nombre: ");
        nombre.setBounds(0, 0, 100, 20);

        inputName = new JTextField();
        inputName.setBounds(100, 0, 200, 20);

        numero = new JLabel("Numero: ");
        numero.setBounds(0, 40, 100, 20);

        inputNumero = new JLabel("aleatorio");
        inputNumero.setBounds(100, 40, 150, 20);;

        tamano = new JLabel("Tamano: ");
        tamano.setBounds(0, 80, 100, 20);

        inputTamano = new JLabel("aleatorio");
        inputTamano.setBounds(100, 80, 150, 20);

        morfologia = new JLabel("Morfologia: ");
        morfologia.setBounds(0, 120, 100, 20);

        String morfoString[] = { "Redonda", "Cuadrada", "Piramidal", "Otra" };

        jboxMorfologia = new JComboBox(morfoString);
        jboxMorfologia.setBounds(100, 120, 200, 20);

        comentarios = new JLabel("Comentarios: ");
        comentarios.setBounds(0, 160, 100, 20);

        textAreaComentarios = new JTextArea("Comentario...");
        scrollArea = new JScrollPane(textAreaComentarios);
        scrollArea.setBounds(0, 200, 300, 100);

        confirmButton = new JButton("Guardar");
        confirmButton.setBounds(600, 580, 120, 60);

        cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(800, 580, 120, 60);

        imagenPreview.setVisible(false);
        chartPreview.setVisible(false);
        panel2Inputs.setVisible(false);
        cancelButton.setVisible(false);
        confirmButton.setVisible(false);

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
