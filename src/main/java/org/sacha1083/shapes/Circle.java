package org.sacha1083.shapes;

public class Circle implements Figure {
    private double radius;

    /**
     * <h1>Constructor de la clase Circle</h1>
     * @param radius El radio del círculo
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * <h1>Método para calcular el área del círculo</h1>
     * - Calcula el área del círculo utilizando la fórmula Math.PI * Math.pow(radius, 2)
     * @return El área del círculo
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * <h1>Método para calcular el perímetro del círculo</h1>
     * - Calcula el perímetro del círculo utilizando la fórmula 2 * Math.PI * radius
     * @return El perímetro del círculo
     */
    @Override
    public double perimetro() {
        return 2 * Math.PI * radius;
    }
}