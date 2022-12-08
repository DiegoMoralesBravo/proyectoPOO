package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

import view.View;

public class Controller implements MouseInputListener {

    private View view;

    private int contador = 0;

    private Path org, destTwo;
    private Resize resize = new Resize();
    private List<String> imagenesMostrar = new ArrayList<String>();

    private File archive;

    public Controller(View view) {
        this.view = view;
        view.setVisible(true);
        
        String folderPath = "./images/";
        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        
        for (File file : files){

            if (!file.isDirectory()){
                file.delete();
            }
        }
            

        listeners();
    }

    /**
     * 
     */
    private void listeners() {

        view.next.addMouseListener(this);
        view.prev.addMouseListener(this);
        view.addImage.addMouseListener(this);
        view.viewImages.addMouseListener(this);
        view.confirmButton.addMouseListener(this);
        view.cancelButton.addMouseListener(this);
        view.imageLoaderButton.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == view.addImage) {
            view.panel1.setVisible(false);
            view.panel2.setVisible(true);
        }

        if (e.getSource() == view.viewImages) {

            String folderPath = "./images/";
            File folder = new File(folderPath);

            File[] files = folder.listFiles();

            for (File file : files) {

                if (file.isFile()) {

                    view.imagenReport
                            .setIcon(resize.resizeImage(new ImageIcon("./images/" + imagenesMostrar.get(contador))));
                    view.chartReport
                            .setIcon(resize.resizeImage(new ImageIcon("./histogram/" + String.valueOf(contador + 1) + ".png")));

                    String[] extension3 = imagenesMostrar.get(contador).split("\\.");

                    try (BufferedReader br = new BufferedReader(
                            new FileReader(new File("./images/" + extension3[0] + ".txt")))) {

                        StringBuilder everything = new StringBuilder();
                        String line;

                        while ((line = br.readLine()) != null) {
                            everything.append(line + "\n" + "\r");
                            everything.append("\n");
                            everything.append("\r");

                        }

                        view.reporteTXT.setText(everything.toString());

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    view.next.setVisible(true);
                    view.prev.setVisible(true);
                    view.exportButton.setVisible(true);

                    view.noHay.setVisible(false);
                } else {
                    view.noHay.setVisible(false);
                    view.noHay.setText("No hay reportes que mostrar...");
                }
            }

            view.panel1.setVisible(true);
            view.panel2.setVisible(false);
        }

        if (e.getSource() == view.next) {

            if (contador >= imagenesMostrar.size() - 1) {
                contador = 0;
            } else {
                contador++;
            }

            String folderPath = "./images/";
            File folder = new File(folderPath);

            File[] files = folder.listFiles();

            for (File file : files) {

                if (file.isFile()) {

                    view.imagenReport
                            .setIcon(resize.resizeImage(new ImageIcon("./images/" + imagenesMostrar.get(contador))));
                    view.chartReport
                            .setIcon(resize.resizeImage(new ImageIcon("./histogram/" + String.valueOf(contador + 1) + ".png")));

                    String[] extension3 = imagenesMostrar.get(contador).split("\\.");

                    try (BufferedReader br = new BufferedReader(
                            new FileReader(new File("./images/" + extension3[0] + ".txt")))) {

                        StringBuilder everything = new StringBuilder();
                        String line;

                        while ((line = br.readLine()) != null) {
                            everything.append(line + "\n" + "\r");
                            everything.append("\n");
                            everything.append("\r");

                        }

                        view.reporteTXT.setText(everything.toString());

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    view.next.setVisible(true);
                    view.prev.setVisible(true);

                    view.noHay.setVisible(false);
                } else {
                    view.noHay.setVisible(false);
                    view.noHay.setText("No hay reportes que mostrar...");
                }
            }

        }

        if (e.getSource() == view.prev) {
            if (contador <= 0) {
                contador = imagenesMostrar.size() - 1;
            } else {
                contador--;
            }

            String folderPath = "./images/";
            File folder = new File(folderPath);

            File[] files = folder.listFiles();

            for (File file : files) {

                if (file.isFile()) {

                    view.imagenReport
                            .setIcon(resize.resizeImage(new ImageIcon("./images/" + imagenesMostrar.get(contador))));
                    view.chartReport
                            .setIcon(resize.resizeImage(new ImageIcon("./images/" + imagenesMostrar.get(contador))));

                    String[] extension3 = imagenesMostrar.get(contador).split("\\.");

                    try (BufferedReader br = new BufferedReader(
                            new FileReader(new File("./images/" + extension3[0] + ".txt")))) {

                        StringBuilder everything = new StringBuilder();
                        String line;

                        while ((line = br.readLine()) != null) {
                            everything.append(line + "\n" + "\r");
                            everything.append("\n");
                            everything.append("\r");

                        }

                        view.reporteTXT.setText(everything.toString());

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    view.next.setVisible(true);
                    view.prev.setVisible(true);

                    view.noHay.setVisible(false);
                } else {
                    view.noHay.setVisible(false);
                    view.noHay.setText("No hay reportes que mostrar...");
                }
            }
        }

        if (e.getSource() == view.confirmButton) {

            try {
                Files.copy(org, destTwo, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "El archivo fue copiado con exito en la carpeta");

                String[] archivoTxtName = (archive.getName()).split("\\.");

                File reporteTxt = new File(System.getProperty("user.dir") + "/images/" + archivoTxtName[0] + ".txt");

                if (reporteTxt.createNewFile()) {

                    System.out.println("File created: " + reporteTxt.getName());

                    FileWriter fw = new FileWriter(reporteTxt.getAbsoluteFile(), true);

                    fw.write("<html> <p> Nombre de la imagen: " + archivoTxtName[0] + "<p>");

                    fw.write("<html> <p> Persona que genero reporte: " + view.inputName.getText() + "<p>");

                    fw.write("Numero de nanoparticulas: " + view.inputNumero.getText() + "<p>");
                    fw.write("Tamano promedio de nanoparticulas: " + view.inputTamano.getText() + " nm <p>");
                    fw.write("Morofologia: " + view.jboxMorfologia.getSelectedItem() + "<p>");
                    fw.write("Comentarios: " + view.textAreaComentarios.getText() + "<p>");

                    DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");
                    String date = dateFormat.format(new Date());
                    fw.write("Fecha: " + date + "\n" + " <p><html>");

                    fw.close();

                    System.out.println(imagenesMostrar);

                    imagenesMostrar.add(archivoTxtName[0] + ".png");

                    System.out.println(imagenesMostrar);

                } else {

                    JOptionPane.showMessageDialog(null, "No se genero reporte, ya existe uno con esta imagen");

                }

            } catch (Exception error) {

                System.out.println(error);

            }

            view.imageLoaderButton.setVisible(true);
            view.imagenPreview.setVisible(false);
            view.chartPreview.setVisible(false);
            view.panel2Inputs.setVisible(false);
            view.cancelButton.setVisible(false);
            view.confirmButton.setVisible(false);

        }

        if (e.getSource() == view.imageLoaderButton) {

            JFileChooser imageLoader = new JFileChooser();

            imageLoader.showOpenDialog(imageLoader);

            archive = imageLoader.getSelectedFile();

            if (archive != null) {
                try {

                    String dest = System.getProperty("user.dir") + "/images/" + archive.getName();

                    destTwo = Paths.get(dest);

                    String origin = archive.getPath();

                    org = Paths.get(origin);

                } catch (Exception error) {

                    System.out.println("algo paso");

                }
            }

            view.imagenPreview.setIcon(resize.resizeImage(new ImageIcon(archive.getPath())));

            int numero = (int) (Math.random() * 10 + 1);
            view.chartPreview.setIcon(resize.resizeImage(new ImageIcon("./histogram/" + numero + ".png")));

            int numeroParticulas = (int) (Math.random() * 100 + 1);
            int tamanoParticulas = (int) (Math.random() * 100 + 1);

            view.inputNumero.setText(String.valueOf(numeroParticulas) + " nanoparticulas");

            view.inputTamano.setText(String.valueOf(tamanoParticulas) + " nanometros");

            view.inputName.setText("");
            view.textAreaComentarios.setText("Comentarios...");

            view.imageLoaderButton.setVisible(false);
            view.imagenPreview.setVisible(true);
            view.chartPreview.setVisible(true);
            view.panel2Inputs.setVisible(true);
            view.cancelButton.setVisible(true);
            view.confirmButton.setVisible(true);
        }

        if (e.getSource() == view.cancelButton) {

            view.imageLoaderButton.setVisible(true);
            view.imagenPreview.setVisible(false);
            view.chartPreview.setVisible(false);
            view.panel2Inputs.setVisible(false);
            view.cancelButton.setVisible(false);
            view.confirmButton.setVisible(false);

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
