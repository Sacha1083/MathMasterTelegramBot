package org.sacha1083.shapes;

public class Trapezoid implements Figure {
    private double baseMenor;
    private double baseMayor;
    private double altura;

    /**
     * <h1>Constructor de la clase Trapecio</h1>
     * @param baseMenor La base menor del trapecio
     * @param baseMayor La base mayor del trapecio
     * @param altura La altura del trapecio
     */
    public Trapezoid(double baseMenor, double baseMayor, double altura) {
        this.baseMenor = baseMenor;
        this.baseMayor = baseMayor;
        this.altura = altura;
    }

    /**
     * <h1>Método para calcular el área del trapecio</h1>
     * - Calcula el área del trapecio utilizando la fórmula ((baseMenor + baseMayor) * altura) / 2
     * @return El área del trapecio
     */
    @Override
    public double area() {
        return ((baseMenor + baseMayor) * altura) / 2;
    }

    /**
     * <h1>Método para calcular el perímetro del trapecio</h1>
     * - Calcula el perímetro del trapecio utilizando la fórmula baseMenor + baseMayor + (2 * sqrt(altura^2 + ((baseMayor - baseMenor) / 2)^2))
     * @return El perímetro del trapecio
     */
    @Override
    public double perimetro() {
        return baseMenor + baseMayor + (2 * Math.sqrt(Math.pow(altura, 2) + Math.pow((baseMayor - baseMenor) / 2, 2)));
    }
}