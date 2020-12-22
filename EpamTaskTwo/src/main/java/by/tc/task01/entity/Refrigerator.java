package by.tc.task01.entity;

import java.util.Objects;

public class Refrigerator extends Appliance {

    private int overallCapacity;
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private int height;
    private int width;

    public Refrigerator(){

    }

    public Refrigerator(int overallCapacity, int powerConsumption, int weight, int freezerCapacity, int height, int width){
        this.overallCapacity = overallCapacity;
        this.powerConsumption = powerConsumption;
        this.weight=weight;
        this.freezerCapacity=freezerCapacity;
        this.height=height;
        this.width=width;
    }

    public int getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(int overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Refrigerator)) return false;
        Refrigerator that = (Refrigerator) o;
        return overallCapacity == that.overallCapacity &&
                powerConsumption == that.powerConsumption &&
                weight == that.weight &&
                freezerCapacity == that.freezerCapacity &&
                height == that.height &&
                width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(overallCapacity, powerConsumption, weight, freezerCapacity, height, width);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "overallCapacity=" + overallCapacity +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", height=" + height +
                ", width=" + width +
                "} ";
    }
}
