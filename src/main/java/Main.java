import Program.IProgram;
import Program.Program;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        IProgram program = new Program();
        program.Start();

        System.out.println("Generacja danych zakończona!");
    }
}