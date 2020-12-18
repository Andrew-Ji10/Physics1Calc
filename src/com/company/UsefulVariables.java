package com.company;

public class UsefulVariables {
    public static double proNeuMass = 1.67 * base10Exp(-27);
    public static double ElecMass = 1.67 * base10Exp(-27);
    public static double lightSpeed = 3 * base10Exp(8);
    public static double elecChargeMag = 1.6 * base10Exp(-19);
    public static double Coulombconstant = 9 * base10Exp(9);
    public static double gravConstant = 6.67 * 10 * base10Exp(-11);
    public static double earthGravaccell = 9.8;

    public static double base10Exp( double exp ){
        return Math.pow(10, exp);
    }
}
