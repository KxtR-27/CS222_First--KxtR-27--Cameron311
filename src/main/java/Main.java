import edu.bsu.cs.WikiApiFetcher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        runProgramInCLI();
        System.exit(0);
    }

    public static void runProgramInCLI() throws Exception {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.printf("%n%nEnter the name of a Wikipedia article: ");
        String data = WikiApiFetcher.fetchArticleInformationWithTitle(consoleScanner.nextLine()).toString();
        System.out.printf("%n%s", data);

        consoleScanner.close();
    }
}
