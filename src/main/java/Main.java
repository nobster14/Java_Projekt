import Program.IProgram;
import Program.Program;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        IProgram program = new Program();

        long startTime = System.currentTimeMillis();
        //program.Start();
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.println("Generacja danych zakończona!");
        System.out.println("Czas generowania danych zajął " + elapsedTime + " milisekund");
    }
}