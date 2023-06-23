package cl.camila;

    public class Calculadora {


        public float sumar(float x, float y) {
            if (x > 0 && y > 0) {
                return x + y;
            } else {
                System.out.println("Valores deben ser mayores a cero");
                return 0;
            }
        }

        public float restar(float x, float y) {
            if (x > 0 && y > 0) {
                return x - y;
            } else {
                System.out.println("Valores deben ser mayores a cero");
                return 0;
            }
        }

        public float multiplicar(float x, float y) {
            if (x > 0 && y > 0) {
                return x + y;
            } else {
                System.out.println("Valores deben ser mayores a cero");
                return 0;
            }
        }

        public float dividir(float x, float y) {
            try {
                if (x > 0 && y > 0) {
                    return x / y;
                } else {
                    System.out.println("Valores deben ser mayores a cero");
                    return 0;
                }
            } catch (ArithmeticException e) {
                System.out.println("No se puede dividir por cero");
                return 0f;
            }
        }
    }



