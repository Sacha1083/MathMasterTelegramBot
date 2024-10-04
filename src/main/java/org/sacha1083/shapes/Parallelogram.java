package org.sacha1083.shapes;

public class Parallelogram implements Figure {
    private double base;
    private double altura;

    /**
     * <h1>Constructor de la clase Parallelogram</h1>
     * @param base La base del paralelogramo
     * @param altura La altura del paralelogramo
     */
    public Parallelogram(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /**
     * <h1>Método para calcular el área del paralelogramo</h1>
     * - Calcula el área del paralelogramo utilizando la fórmula base * altura
     * @return El área del paralelogramo
     */
    @Override
    public double area() {
        return base * altura;
    }

    /**
     * <h1>Método para calcular el perímetro del paralelogramo</h1>
     * - Calcula el perímetro del paralelogramo
     * @return El perímetro del paralelogramo
     */
    @Override
    public double perimetro() {
        return 2 * (base + altura);
    }
}