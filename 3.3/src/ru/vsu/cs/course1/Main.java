package ru.vsu.cs.course1;

public class Main {

    public static void main(String[] args) {
        class Test {

        };

        String inputFile = args[0];
        String outputFile = args[1];

        System.out.println("Hello, World!");
        System.out.println("------");
        for (String arg: args) {
            System.out.println(arg);
        }
    }
}
