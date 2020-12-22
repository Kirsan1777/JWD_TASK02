package by.tc.task01.service.validation;

public class Parser {
    public double parseDouble(String number){
        double resultDouble;
        resultDouble = Double.parseDouble(number);
        return resultDouble;
    }

    public int parseInt(String number){
        int resultInt;
        resultInt = Integer.parseInt(number);
        return resultInt;
    }
}
