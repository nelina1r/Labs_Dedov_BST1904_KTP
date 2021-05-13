import java.util.Scanner; 

public class App {
    public static void main(String[] args) {
        System.out.print("Создание точки в трёхмерном пространстве\n");

        // Ввод трёх точек
        Scanner scan = new Scanner(System.in);
        System.out.print("Ввод точки №1\n");
        Point3d point1 = inputPoint(scan);
        System.out.print("Ввод точки №2\n");
        Point3d point2 = inputPoint(scan);
        System.out.print("Ввод точки №3\n");
        Point3d point3 = inputPoint(scan);
        scan.close();

        // Проверка на равенство точек
        if (point1.equals(point2))
            System.out.print("Точки №1 и №2 равны, площадь равна 0\n");
        else if (point2.equals(point3))
            System.out.print("Точки №2 и №3 равны, площадь равна 0\n");
        else if (point3.equals(point1))
            System.out.print("Точки №1 и №3 равны, площадь равна 0\n");
        else {
            // Вычисление площади и её вывод
            double area = computeArea(point1, point2, point3);
            System.out.printf("Площадь треугольника из трёх точек: %.4f\n", area);
        }

    }
    // Вспомогательный метод для ввода трёх координат точки
    private static Point3d inputPoint(Scanner scan) {
        System.out.print("Введите координату x:");
        double x = scan.nextDouble();
        System.out.print("Введите координату y:");
        double y = scan.nextDouble();
        System.out.print("Введите координату z:");
        double z = scan.nextDouble();
        return new Point3d(x, y, z);
    }
    
    // Метод для вычисления площади треугольника из трёх точек
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);
        double p = (a + b + c) / 2.0;
        double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return area;
    }
}


