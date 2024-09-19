package edu.bsu.cs;

public class ConsoleIO {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(new URLConnector().doTheThing());
    }
    private static String doTheThing(){
        return "Giraffe";
    }
}
