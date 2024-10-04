package org.sacha1083.shapes;

public class Hexagon implements Figure {
    private double sideLength;

    /**
     * <h1>Constructor de la clase Hexagon</h1>
     * @param sideLength La longitud del lado del hexágono
     */
    public Hexagon(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * <h1>Método para calcular el área del hexágono</h1>
     * - Calcula el área del hexágono utilizando la fórmula (3 * Math.sqrt(3) * Math.pow(sideLength, 2)) / 2
     * @return El área del hexágono
     */
    @Override
    public double area() {
        return (3 * Math.sqrt(3) * Math.pow(sideLength, 2)) / 2;
    }

    /**
     * <h1>Método para calcular el perímetro del hexágono</h1>
     * - Calcula el perímetro del hexágono multiplicando la longitud del lado por 6
     * @return El perímetro del hexágono
     */
    @Override
    public double perimetro() {
        return sideLength * 6;
    }
}