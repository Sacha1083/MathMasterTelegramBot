package org.sacha1083.shapes;

public class Pentagon implements Figure {
    private double sideLength;
    private double apothem;

    /**
     * <h1>Constructor de la clase Pentagon</h1>
     * @param sideLength La longitud del lado del pentágono
     * @param apothem La apotema del pentágono
     */
    public Pentagon(double sideLength, double apothem) {
        this.sideLength = sideLength;
        this.apothem = apothem;
    }

    /**
     * <h1>Método para calcular el área del pentágono</h1>
     * - Calcula el área del pentágono utilizando la fórmula (5 * sideLength * apothem) / 2
     * @return El área del pentágono
     */
    @Override
    public double area() {
        return (5 * sideLength * apothem) / 2;
    }

    /**
     * <h1>Método para calcular el perímetro del pentágono</h1>
     * - Calcula el perímetro del pentágono utilizando la fórmula 5 * sideLength
     * @return El perímetro del pentágono
     */
    @Override
    public double perimetro() {
        return 5 * sideLength;
    }
}