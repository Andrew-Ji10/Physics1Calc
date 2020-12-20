package Calculators.Mechanics;

public class Kinematics {
    private double acceleration;
    private double vInit;
    private double vFinal;
    private double time;
    private double distance;
    private double result;

    public Kinematics(String acceleration, String vInit, String vFinal, String time, String distance){
        int calcType = 1;
        int vType = 1;
        if (acceleration.isEmpty()){
            calcType = 1;
            if (vInit == "?"){
                vType = 1;
            } else if (vFinal == "?") {
                vType = 2;
            } else if (time == "?") {
                vType = 3;
            } else if (distance == "?"){
                vType = 4;
            }
        } else {
            this.acceleration = Double.parseDouble(acceleration);
        }

        if (vInit.isEmpty()){
            calcType = 2;
            if (acceleration == "?"){
                vType = 1;
            } else if (vFinal == "?") {
                vType = 2;
            } else if (time == "?") {
                vType = 3;
            } else if (distance == "?"){
                vType = 4;
            }
        } else {
            this.vInit = Double.parseDouble(vInit);
        }

        if (vFinal.isEmpty()){
            calcType = 3;
            if (acceleration == "?"){
                vType = 1;
            } else if (vInit == "?") {
                vType = 2;
            } else if (time == "?") {
                vType = 3;
            } else if (distance == "?"){
                vType = 4;
            }
        } else {
            this.vFinal = Double.parseDouble(vInit);
        }

        if (time.isEmpty()){
            calcType = 4;
            if (acceleration == "?"){
                vType = 1;
            } else if (vInit == "?") {
                vType = 2;
            } else if (vFinal == "?") {
                vType = 3;
            } else if (distance == "?"){
                vType = 4;
            }
        } else {
            this.time = Double.parseDouble(vInit);
        }

        if (distance.isEmpty()){
            calcType = 5;
            if (acceleration == "?"){
                vType = 1;
            } else if (vInit == "?") {
                vType = 2;
            } else if (time == "?") {
                vType = 3;
            } else if (vFinal == "?"){
                vType = 4;
            }
        } else {
            this.distance = Double.parseDouble(vInit);
        }

        result = execute(calcType, vType);

    }

    public double execute(int calcType, int vType){
        switch (calcType) {
            case 1:
                return withoutAcceleration(vType);
            case 2:
                return withoutvInit(vType);
            case 3:
                return withoutvFinal(vType);
            case 4:
                return withoutTime(vType);
            case 5:
                return withoutDistance(vType);
        }
        return 0;
    }

    public double withoutAcceleration(int vType){
        switch (vType){
            case 1:
                return (((2 * distance)/time) - vFinal);
            case 2:
                return ((2 * distance)/time) - vInit;
            case 3:
                return distance/((vInit + vFinal)/2);
            case 4:
                return (vInit + vFinal) * time/2;
        }
        return 0;

    }

    public double withoutvInit(int vType){
        return 0;
    }

    public double withoutvFinal(int vType){
        return 0;
    }

    public double withoutTime(int vType){
        return 0;
    }

    public double withoutDistance(int vType){
        return 0;
    }

    public double getAnswer(){
        return result;
    }
}
