package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

    // Inner class for Feet
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // 1. Same reference
            if (this == obj)
                return true;

            // 2. Null check
            if (obj == null)
                return false;

            // 3. Type check
            if (getClass() != obj.getClass())
                return false;

            // 4. Cast
            Feet other = (Feet) obj;

            // 5. Compare values
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter first value in feet: ");
        double v1 = scanner.nextDouble();

        System.out.print("Enter second value in feet: ");
        double v2 = scanner.nextDouble();

        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);

        // System.out.println("Are equal? " + f1.equals(f2));
        boolean result = f1.equals(f2);

        if (result) {
            System.out.println("Output: Equal (true)");
        } else {
            System.out.println("Output: Not Equal (false)");
        }

        scanner.close();
    }
}