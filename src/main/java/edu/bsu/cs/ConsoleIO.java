package edu.bsu.cs;

import java.util.Scanner;

public class ConsoleIO {
    @SuppressWarnings("unused")
    // For some reason, it warns that String[] args is never used. Did I miss something?
    public static void main(String[] args) throws Exception {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.printf("%nEnter the name of a Wikipedia article.%n> ");

        System.out.println(WikiApiFetcher.fetchArticleInformationWithTitle(consoleScanner.nextLine()));
    }
}
