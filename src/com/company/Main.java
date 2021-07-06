package com.company;

import Calculators.Mechanics.Kinematics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        Kinematics kinematics = new Kinematics("1","4","5","","");


        for(int i = 0; i < kinematics.getAnswer().length; i++ ){
            System.out.println(kinematics.getAnswer()[i]);
        }

        System.out.println(kinematics.getAnswer().length);


    }
}
