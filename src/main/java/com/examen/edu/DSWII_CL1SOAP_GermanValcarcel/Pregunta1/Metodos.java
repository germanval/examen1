package com.examen.edu.DSWII_CL1SOAP_GermanValcarcel.Pregunta1;

import java.util.Scanner;

public class Metodos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese su sexo (H/M): ");
        char sexo = scanner.next().charAt(0);
        if ((sexo == 'H' && edad >= 60) || (sexo == 'M' && edad >= 55)) {
            System.out.println("Usted ya puede jubilarse.");
        } else {
            System.out.println("Usted no puede jubilarse aún.");
        }


        System.out.println("\nIngrese 4 números:");
        int[] numeros = new int[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }
        int menor = encontrarMenor(numeros);
        System.out.println("El menor número es: " + menor);


        System.out.print("\nIngrese el número de materias: ");
        int numMaterias = scanner.nextInt();
        double costoMatricula = calcularCostoMatricula(numMaterias);
        System.out.println("El costo de la matrícula es: S/ " + costoMatricula);


        System.out.print("\nIngrese su salario mensual: ");
        double salario = scanner.nextDouble();
        System.out.print("Ingrese los años trabajando en la institución: ");
        int anosTrabajando = scanner.nextInt();
        double utilidades = calcularUtilidades(salario, anosTrabajando);
        System.out.println("Sus utilidades son: S/ " + utilidades);


        int suma = calcusum();
        System.out.println("\nLa suma de los múltiplos de 3 y 7 entre 9 y 45 es: " + suma);

        scanner.close();
    }


    public static int encontrarMenor(int[] numeros) {
        int menor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        return menor;
    }


    public static double calcularCostoMatricula(int numMaterias) {
        double costoPorMateria = 520.0;
        double total = numMaterias * costoPorMateria;
        if (numMaterias > 5) {
            total = total * 0.9;
        }
        return total;
    }


    public static double calcularUtilidades(double salario, int anosTrabajando) {
        double porcentajeUtilidad;
        if (anosTrabajando < 1) {
            porcentajeUtilidad = 0.05;
        } else if (anosTrabajando < 2) {
            porcentajeUtilidad = 0.07;
        } else if (anosTrabajando < 5) {
            porcentajeUtilidad = 0.10;
        } else if (anosTrabajando < 10) {
            porcentajeUtilidad = 0.15;
        } else {
            porcentajeUtilidad = 0.20;
        }
        return salario * porcentajeUtilidad;
    }


    public static int calcusum() {
        int suma = 0;
        for (int i = 9; i <= 45; i++) {
            if (i % 3 == 0 || i % 7 == 0) {
                suma += i;
            }
        }
        return suma;
    }
}