package com.ppj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        System.out.println(toSystem(inputNumber, 2));
        System.out.println(toSystem(inputNumber, 4));
        System.out.println(toSystem(inputNumber, 8));
        System.out.println(toSystem(inputNumber, 16));

    }

    private static String toSystem(int inputNumber, int numericSystem){
        int pow = switch (numericSystem){
            case 2 -> 1;
            case 4 -> 2;
            case 8 -> 3;
            case 16 -> 4;
            default -> throw new IllegalArgumentException();
        };

        String str = "";
        for(int i=0; i<31; i+=pow){
            int tmp = ((inputNumber >> i) & (numericSystem-1));
            str = tmp < 10 ? tmp + str : (char)('A'+(tmp-10))+str;
        }

        return str;
    }
}
