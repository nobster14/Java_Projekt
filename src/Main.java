import Program.IProgram;
import Program.Program;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ile danych chcesz wygenerować?");

        int n = new Scanner(System.in).nextInt();
        IProgram program = new Program();
        program.Start(n);

        System.out.println("Generacja danych zakończona!");
    }
}