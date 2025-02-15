public class BMIcalculator {
    private double weight;
    private double height;
    private double bmi;

    public BMIcalculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public BMIcalculator(double weight, double height, double bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    public double calculateBMI(double weight, double height){
        return weight/(height*height);
    }
    public double bmigoalcalculate(double height , double bmi){
        return (height*height)*bmi ;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
