import java.util.Comparator;

import static java.util.Collections.replaceAll;

public class Car  implements Comparable<Car> {
    private String makeModel;
    private double engineSizeL;
    private int prodYear;

    public Car() {
    }

    public Car(String makeModel, double engineSizeL, int prodYear) {
        this.makeModel = makeModel;
        this.engineSizeL = engineSizeL;
        this.prodYear = prodYear;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public double getEngineSizeL() {
        return engineSizeL;
    }

    public void setEngineSizeL(double engineSizeL) {
        this.engineSizeL = engineSizeL;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "makeModel='" + makeModel + '\'' +
                ", engineSizeL=" + engineSizeL +
                ", prodYear=" + prodYear +
                '}';
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.getMakeModel().compareTo(otherCar.getMakeModel());
    }


}
