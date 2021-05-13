public class Point3d extends Point2d{
    private double zCoord;

    // Конструктор инициализации
    public Point3d (double x, double y, double z) {
        super(x,y);
        this.setZ(z);
    }
    // Конструктор по умолчанию
    public Point3d() {
        this(0, 0, 0);
    }
    // Возвращение координаты z
    public double getZ() {
        return zCoord;
    }
    public void setZ(double val) {
        zCoord = val;
    }

    // Сравнение двух объектов - равенство по координатам точки
    public boolean equals(Point3d point) {
        return (this.getX() == point.getX() && this.getY() == point.getY() && this.getZ() == point.getZ());
    }
    // Вычисляет расстояние между точками
    public double distanceTo(Point3d point) {
        double dx = Math.abs(this.getX() - point.getX());
        double dy = Math.abs(this.getY() - point.getY());
        double dz = Math.abs(this.getZ() - point.getZ());
        double distance = Math.sqrt(dx*dx+dy*dy+dz*dz);
        return distance;
    }
}
