class Circle {
    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(10);
        c1.display();
        c2.display();
    }
}