import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;


public class FractalExplorer {
    /* Размер экрана (квадратное отображение) **/
    private int displaySize;

    /* Для отображения в процессе вычисления фрактала **/
    private JImageDisplay display;

    /* Для отображения других видов фракталов в будущем **/
    private FractalGenerator generator;

    /* Указывает диапазон комплексной области, которая выводится на экран **/
    private Rectangle2D.Double range;

    /* Принимает размер экрана, инициализирует объекты диапазона и генератора
     * фрактала
     */
    public FractalExplorer(int length) {
        this.displaySize = length;
        range = new Rectangle2D.Double();
        generator = new Mandelbrot();
        generator.getInitialRange(range);
    }

    /** Инициализация и отображение окна */
    public void createAndShowGUI() {
        display = new JImageDisplay(displaySize, displaySize);
        JFrame frame = new JFrame();
        /** Инициализация кнопки */
        JButton button = new JButton("Reset Display");
        AL actionListner = new AL();
        button.addActionListener(actionListner);
        /** Инициализация мыши */
        ML mouseListener = new ML();
        frame.addMouseListener(mouseListener);
        /** Параметры окна */
        frame.add(display, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setTitle("Fractal Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /** Отрисовка фрактала попиксельно **/
    private void drawFractal() {
        
        for (int x = 0; x < displaySize; x++) {
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
            for (int y = 0; y < displaySize; y++) {
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
                int n = generator.numIterations(xCoord, yCoord);
                if (n == -1) {
                    display.drawPixel(x, y, 0);
                }
                else {
                    float hue = 0.7f + (float)n / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        /** После того, как вы закончили отрисовывать все пиксели, вам необходимо 
         * обновить JimageDisplay в соответствии с текущим изображением.
         */
        display.repaint();
    }

    /** Для обработки события для кнопки */
    private class AL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            generator.getInitialRange(range);
            drawFractal();
        }
    }

    /** Для обработки события мыши */
    private class ML extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, e.getX());
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, e.getY());
            generator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    public static void main(String[] args) {
        FractalExplorer explorer = new FractalExplorer(800);
        explorer.createAndShowGUI();
        explorer.drawFractal();
    }
}