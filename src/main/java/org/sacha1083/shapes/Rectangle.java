package org.sacha1083.shapes;

public class Rectangle implements Figure {
    private double ladoBase;
    private double ladoAltura;

    /**
     * <h1>Constructor de la clase Rectangulo</h1>
     * @param ladoBase La base del rectángulo
     * @param ladoAltura La altura del rectángulo
     */
    public Rectangle(double ladoBase, double ladoAltura) {
        this.ladoBase = ladoBase;
        this.ladoAltura = ladoAltura;
    }

    /**
     * <h1>Método para calcular el área del rectángulo</h1>
     * - Calcula el área del rectángulo utilizando la fórmula ladoBase * ladoAltura
     * @return El área del rectángulo
     */
    @Override
    public double area() {
        return ladoBase * ladoAltura;
    }

    /**
     * <h1>Método para calcular el perímetro del rectángulo</h1>
     * - Calcula el perímetro del rectángulo utilizando la fórmula 2 * (ladoBase + ladoAltura)
     * @return El perímetro del rectángulo
     */
    @Override
    public double perimetro() {
        return 2 * (ladoBase + ladoAltura);
    }
}