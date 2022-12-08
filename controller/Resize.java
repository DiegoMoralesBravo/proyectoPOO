package controller;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Resize {

    public ImageIcon resizeImage(ImageIcon icon) {

        Image imagenIcono = icon.getImage();
        Image imagenModificada = imagenIcono.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);

        return new ImageIcon(imagenModificada);
    }
}
