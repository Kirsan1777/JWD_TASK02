package by.tc.task01.entity;

import java.util.Objects;

public class Speakers extends Appliance{
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange; ///FREQUENCY_RANGE=2-4,
    private int cordLength;

    public Speakers(){

    }

    public Speakers(int powerConsumption, int numberOfSpeakers, String frequencyRange, int cordLength){
        this.powerConsumption=powerConsumption;
        this.numberOfSpeakers=numberOfSpeakers;
        this.frequencyRange=frequencyRange;
        this.cordLength=cordLength;
    }


    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speakers)) return false;
        Speakers speakers = (Speakers) o;
        return powerConsumption == speakers.powerConsumption &&
                numberOfSpeakers == speakers.numberOfSpeakers &&
                frequencyRange == speakers.frequencyRange &&
                cordLength == speakers.cordLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange='" + frequencyRange + '\'' +
                ", cordLength=" + cordLength +
                "} ";
    }
}
