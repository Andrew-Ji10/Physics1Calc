package com.company;

import Calculators.Mechanics.Kinematics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        Kinematics kinematics = new Kinematics("","1","2","3","?");
        System.out.println(kinematics.getAnswer());
        String str = "";
        System.out.println(str.isEmpty());

    }
}
