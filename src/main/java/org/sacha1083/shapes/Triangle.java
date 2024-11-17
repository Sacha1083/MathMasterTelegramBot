package org.sacha1083.shapes;

public class Triangle implements Figure {
    private double base;
    private double altura;

    /**
     * <h1>Constructor de la clase Triangulo</h1>
     * @param base La base del triángulo
     * @param altura La altura del triángulo
     */
    public Triangle(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /**
     * <h1>Método para calcular el área del triángulo</h1>
     * - Calcula el área del triángulo utilizando la fórmula (base * altura) / 2
     * @return El área del triángulo
     */
    @Override
    public double area() {
        return (base * altura) / 2;
    }

    /**
     * <h1>Método para calcular el perímetro del triángulo</h1>
     * - Calcula el perímetro del triángulo sumando los tres lados
     * @return El perímetro del triángulo
     */
    @Override
    public double perimetro() {
        return base + altura + Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }
}