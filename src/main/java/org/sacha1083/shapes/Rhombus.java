package org.sacha1083.shapes;

public class Rhombus implements Figure {
    private double diagonalMayor;
    private double diagonalMenor;

    /**
     * <h1>Constructor de la clase Rhombus</h1>
     * @param diagonalMayor La diagonal mayor del rombo
     * @param diagonalMenor La diagonal menor del rombo
     */
    public Rhombus(double diagonalMayor, double diagonalMenor) {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    /**
     * <h1>Método para calcular el área del rombo</h1>
     * - Calcula el área del rombo utilizando la fórmula (diagonalMayor * diagonalMenor) / 2
     * @return El área del rombo
     */
    @Override
    public double area() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    /**
     * <h1>Método para calcular el perímetro del rombo</h1>
     * - Calcula el perímetro del rombo utilizando la fórmula 4 * lado
     * @return El perímetro del rombo
     */
    @Override
    public double perimetro() {
        return 4 * Math.sqrt((Math.pow(diagonalMayor / 2, 2) + Math.pow(diagonalMenor / 2, 2)));
    }
}