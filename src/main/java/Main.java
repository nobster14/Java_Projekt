import Program.IProgram;
import Program.Program;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Ile danych chcesz wygenerować?");

        int n = new Scanner(System.in).nextInt();
        IProgram program = new Program();
        program.Start(n);

        System.out.println("Generacja danych zakończona!");
    }
}