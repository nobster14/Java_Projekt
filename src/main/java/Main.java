import Program.IProgram;
import Program.Program;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IProgram program = new Program();
        program.Start();
    }
}