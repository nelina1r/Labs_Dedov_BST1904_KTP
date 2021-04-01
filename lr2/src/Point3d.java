public class Point3d 
{
    private double xCoord;  // Координата X
    private double yCoord;  // Координата Y
    private double zCoord;  // Координата Z

    public Point3d(double x, double y, double z) {
        /* Конструктор инициализации */
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    
    public Point3d() {
        /* Конструктор по умолчанию */
        // Вызовите конструктор с двумя параметрами и определите источник
        this(0, 0, 0);
    }
    
    public double getX() {
        /* Возвращение координаты X */
        return xCoord;
    }
    
    public void setX(double val) {
        /* Установка значения координаты X */
        xCoord = val;
    }
    
    public double getY() {
        /* Возвращение координаты Y */
        return yCoord;
    }
    
    public void setY(double val) {
        /* Установка значения координаты Y */
        yCoord = val;
    }
    
    public double getZ() {
        /* Возвращение координаты Z */
        return zCoord;
    }
    
    public void setZ(double val) {
        /* Установка значения координаты Z */
        zCoord = val;
    }
    
    public boolean equals(Point3d anotherPoint) {
        return xCoord == anotherPoint.getX() &&
               yCoord == anotherPoint.getY() &&
               zCoord == anotherPoint.getZ();
    }
    
    
    public double distanceTo(Point3d anotherPoint) {
        return Math.sqrt(
            Math.pow(xCoord - anotherPoint.getX(), 2) +
            Math.pow(yCoord - anotherPoint.getY(), 2) +
            Math.pow(zCoord - anotherPoint.getZ(), 2));
    }
}
