import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class JImageDisplay extends JComponent {
    /* Для хранения изображения и управления им */
    private BufferedImage image;

    /*Принимает целочисленные значения ширины и высоты и инициализирует
     * объект BufferedImage новым изображением
     */
    JImageDisplay(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(width, height));
    }

    /**Для использования и отображения изображения */ 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    /**Для очищения изображения - замена на чёрный цвет */ 
    public void clearImage() {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
    }

    /**Для вставки пикселя по координатам */
    public void drawPixel(int x, int y, int rgbColor) {
        image.setRGB(x, y, rgbColor);
    }
}