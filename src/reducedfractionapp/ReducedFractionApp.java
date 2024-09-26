/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reducedfractionapp;

import java.util.Scanner;

/**
 *
 * @author Groza1337
 */
public class ReducedFractionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите числитель для 1 дроби: ");
        int numerator1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите знаменатель для 1 дроби: ");
        String denominatorInput1 = sc.nextLine();
        int denominator1 = denominatorInput1.isEmpty() ? 1 : Integer.parseInt(denominatorInput1);
        System.out.print("Введите числитель для 2 дроби: ");
        int numerator2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите знаменатель для 2 дроби: ");
        String denominatorInput2 = sc.nextLine();
        int denominator2 = denominatorInput2.isEmpty() ? 1 : Integer.parseInt(denominatorInput2);


        ReducedFraction reducedFraction1 = new ReducedFraction(numerator1, denominator1);
        ReducedFraction reducedFraction2 = new ReducedFraction(numerator2, denominator2);


        System.out.println();
        System.out.print("Первая дробь: ");
        System.out.println(reducedFraction1);

        System.out.print("Вторая дробь: ");
        System.out.println(reducedFraction2);


        ReducedFraction sum = reducedFraction1.addition(reducedFraction2);
        System.out.println();
        System.out.println("Сумма дробей:");
        System.out.println(
                        reducedFraction1 + " + " +
                                reducedFraction2 +
                        " = " + sum.getNumerator() + "/" + sum.getDenominator());

        ReducedFraction difference = reducedFraction1.subtraction(reducedFraction2);
        System.out.println();
        System.out.println("Разница дробей:");
        System.out.println(
                reducedFraction1 + " - " +
                        reducedFraction2 +
                        " = " + difference.getNumerator() + "/" + difference.getDenominator());

        ReducedFraction multiplication = reducedFraction1.multiplication(reducedFraction2);
        System.out.println();
        System.out.println("Перемножение дробей:");
        System.out.println(
                reducedFraction1 + " * " +
                        reducedFraction2 +
                        " = " + multiplication.getNumerator() + "/" + multiplication.getDenominator());

        ReducedFraction division = reducedFraction1.division(reducedFraction2);
        System.out.println();
        System.out.println("Деление дробей:");
        System.out.println(
                reducedFraction1 + " / " +
                        reducedFraction2 +
                        " = " + division);

        Compare compare = reducedFraction1.comparing(reducedFraction2);
        System.out.println();
        System.out.println("Сравнение дробей:");
        System.out.println(
                reducedFraction1 + " " + compare +
                        " " + reducedFraction2);

        boolean equals = reducedFraction1.equals(reducedFraction2);
        System.out.println();
        System.out.println("Эквивалентность дробей: ");
        if (equals) {
            System.out.println(reducedFraction1 + " " + "==" + " " + reducedFraction2);
        } else {
            System.out.println(reducedFraction1 + " " + "!=" + " " + reducedFraction2);
        }
        System.out.println();
        System.out.println("Представить как вещественное число:");
        System.out.println(reducedFraction1 + " = " + reducedFraction1.toFloat());
        System.out.println(reducedFraction2 + " = " + reducedFraction2.toFloat());
    }
    
}
