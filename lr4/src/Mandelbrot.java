import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    /** Для отображения правильного начального диапазона для фрактала */
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    /** Константа максимального количества итераций */
    public static final int MAX_ITERATIONS = 2000;

    /** Подкласс для работы с комплексными числами */
    protected class ComplexNumber {
        /** Реальная часть */
        private double x;
        /** Воображаемая часть */
        private double y;

        ComplexNumber(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /** Сложение с комплексным числом */
        public ComplexNumber plus(ComplexNumber other) {
            return new ComplexNumber(this.x+other.x, this.y+other.y);
        }

        /** Умножение с комплексным числом */
        public ComplexNumber multiply(ComplexNumber other) {
            return new ComplexNumber(this.x*other.x - this.y*other.y, this.x*other.y + this.y*other.x);
        }

        /** Вспомогательный метод для вычисления квадрата модуля комплексного числа */
        public double abs_squared() {
            return this.x*this.x + this.y*this.y;
        }
    }

    /** Реализует итеративную функцию для фрактала Мандельброта */
    @Override
    public int numIterations(double x, double y) {
        ComplexNumber c = new ComplexNumber(x, y);
        ComplexNumber z = new ComplexNumber(0, 0);
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            if (z.abs_squared() > 2*2)
                return i;
            /** След. элемент последовательности z = z^2+c */
            z = z.multiply(z).plus(c);
        }
        return -1;
    }
}
