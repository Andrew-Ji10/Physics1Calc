package Calculators.Mechanics;

import java.util.ResourceBundle;

public class Kinematics {
    private boolean hasAcceleration;
    private boolean hasVInit;
    private boolean hasVFinal;
    private boolean hasTime;
    private boolean hasDistance;
    private double[] dataset;
    private double[] result;
    private int vType;
    private int calcType;

    public Kinematics(String acceleration, String vInit, String vFinal, String time, String distance){
        dataset = new double[5];
        result = new double[5];

        if (acceleration.isEmpty()){
            hasAcceleration = false;
            dataset[0] = 0.0;
            result[0] = dataset[0];
        } else {
            hasAcceleration = true;
            dataset[0] = Double.parseDouble(acceleration);
            result[0] = dataset[0];
        }

        if (vInit.isEmpty()){
            hasVInit = false;
            dataset[1] = 0.0;
            result[1] = dataset[1];
        } else {
            hasVInit = true;
            dataset[1] = Double.parseDouble(vInit);
            result[1] = dataset[1];
        }

        if(vFinal.isEmpty()){
            hasVFinal = false;
            dataset[2] = 0.0;
            result[2] = dataset[2];
        } else {
            hasVFinal = true;
            dataset[2] = Double.parseDouble(vFinal);
            result[2] = dataset[2];
        }

        if (time.isEmpty()){
            hasTime = false;
            dataset[3] = 0.0;
            result[3] = dataset[3];
        } else {
            hasTime = true;
            dataset[3] = Double.parseDouble(time);
            result[3] = dataset[3];
        }

        if (distance.isEmpty()) {
            hasDistance = false;
            dataset[4] = 0.0;
            result[4] = dataset[4];
        } else {
            hasDistance = true;
            dataset[4] = Double.parseDouble(distance);
            result[4] = dataset[4];
        }


        if (!hasAcceleration){
            result[0] = solveForAccel();
            hasAcceleration = true;
            dataset[0] = result[0];
        }

        if (!hasVInit) {
            result[1] = solveForvIn();
            hasVInit = true;
            dataset[1] = result[1];
        }

        if (!hasVFinal) {
            result[2] = solveForvFin();
            hasVFinal = true;
            dataset[2] = result[2];
        }

        if (!hasTime) {
            result[3] = solveForTime();
            hasTime = true;
            dataset[3] = result[3];
        }

        if(!hasDistance) {
            result[4] = solveForDistance();
            hasDistance = true;
            dataset[4] = result[4];
        }

    }


    public double solveForAccel(){
        if (!hasVInit){
            return ((dataset[2] * dataset[3]) - dataset[4]) * 2 / (dataset[3] * dataset[3]);
        } else if (!hasVFinal) {
            return ((dataset[4] - dataset[1] * dataset[3]) * 2) / (dataset[3] * dataset[3]);
        } else if (!hasTime) {
            return (dataset[2] * dataset[2] - dataset[1] * dataset[1]) / (2 * dataset[4]);
        } else if (!hasDistance) {
            return (dataset[2] - dataset[1])/dataset[3];
        } else if (hasVInit && hasVFinal && hasTime && hasDistance) {
            return (dataset[2] * dataset[3] - dataset[4]) * 2 / (dataset[3] * dataset[3]);
        }
            return 420.69;


    }

    public double solveForvIn(){
        if(!hasAcceleration){
            return ((dataset[4] * 2) / dataset[3]) - dataset[2];
        } else if (!hasVFinal) {
            return (dataset[4] - (dataset[1] * dataset[3] * dataset [3])/2) / dataset[3];
        } else if (!hasTime){
            return Math.sqrt(dataset[2] * dataset[2] - 2 * dataset[0] * dataset[4]);
        } else if (!hasDistance){
            return dataset[2] - (dataset[0] * dataset[3]);
        } else if (hasAcceleration && hasVFinal && hasTime && hasDistance){
            return dataset[2] - (dataset[0] * dataset[3]);
        }
        return 420.69;
    }

    public double solveForvFin(){
        if(!hasAcceleration){
            return dataset[1] + (dataset[0] * dataset[3]);
        } else if (!hasVInit) {
            return (dataset[4] + (dataset[0] * dataset[3] * dataset[3] / 2))/dataset[3];
        } else if (!hasTime) {
            return Math.sqrt(dataset[1] * dataset[1] + 2 * dataset[0] * dataset[4]);
        } else if (!hasDistance) {
            return dataset[1] + dataset[0] * dataset[3];
        } else if (hasAcceleration && hasVInit && hasTime && hasDistance) {
            return dataset[1] + dataset[0] * dataset[3];
        }

        return 420.69;
    }

    public double solveForTime(){
        if (!hasAcceleration){
            return (dataset[4] * 2) / (dataset[1] + dataset[2]);
        } else if (!hasVInit) {
            return (dataset[4] * 2) / (dataset[1] + dataset[2]);
        } else if (!hasVFinal) {
            return (dataset[4] * 2) / (dataset[1] + dataset[2]);
        } else if (!hasDistance) {
            return ((dataset[2] - dataset[1])/dataset[0]);
        } else if (hasAcceleration && hasVInit && hasVFinal && hasDistance) {
            return (dataset[4] * 2) / (dataset[1] + dataset[2]);
        }

        return 420.69;
    }

    public double solveForDistance(){
        if (!hasAcceleration){
            return ((dataset[2] + dataset[1])/2) * dataset[3];
        } else if (!hasVInit) {
            return ((dataset[2] * dataset[3] - dataset[0] * dataset[3] * dataset[3] * 0.5));
        } else if (!hasVFinal) {
            return (dataset[1] * dataset[3] + dataset[0] * dataset[3] * dataset[3] * 0.5);
        } else if (!hasTime) {
            return (dataset[2] * dataset[2] - dataset[1] * dataset[1])/(2 * dataset[0]);
        } else if (hasAcceleration && hasVInit && hasVFinal && hasTime) {
            return ((dataset[2] + dataset[1])/2) * dataset[3];
        }
        return 420.69;
    }


    public double[] getAnswer(){
        return result;
    }
}
