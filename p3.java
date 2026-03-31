public class p3 {

    public static void main(String[] args) {
        for (Shape myShape : Shape.values()) {
            System.out.println(myShape + ": " + myShape.getDescription());
            System.out.println("  Area: " + myShape.area());
        }

        Shape coolShape = null;
        System.out.println(coolShape.getDescription());

    }

    enum Shape {
        CIRCLE(5.0),
        RECTANGLE(3.0, 4.0);

        private final double dim1, dim2;

        Shape(double radius) {
            this.dim1 = radius;
            this.dim2 = 0;
        }

        Shape(double width, double height) {
            this.dim1 = width;
            this.dim2 = height;
        }

        public String getDescription() {
            switch (this) {
                case CIRCLE:
                    return "radius = " + dim1;
                case RECTANGLE:
                    return "width = " + dim1 + ", height = " + dim2;
                default:
                    return "Unknown";
            }
        }

        public double area() {
            switch (this) {
                case CIRCLE:
                    return Math.PI * dim1 * dim1;

                case RECTANGLE:
                    return dim1 * dim2;

                default:
                    return 0.0;
            }
        }

    }

}
