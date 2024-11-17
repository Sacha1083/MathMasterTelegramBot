package org.sacha1083.shapes;

public class Square implements Figure {
    private double lado;

    /**
         * <h1>Constructor de la clase Cuadrado</h1>
         * @param lado El lado del cuadrado
     */
    public Square(double lado) {
        this.lado = lado;
    }

    /**
         * <h1>Método para calcular el área del cuadrado</h1>
         * - Calcula el área del cuadrado utilizando la fórmula lado * lado
         * @return El área del cuadrado
     */
    @Override
    public double area() {
        return lado * lado;
    }

    /**
         * <h1>Método para calcular el perímetro del cuadrado</h1>
         * - Calcula el perímetro del cuadrado utilizando la fórmula lado * 4
         * @return El perímetro del cuadrado
     */
    @Override
    public double perimetro() {
        return lado * 4;
    }
}