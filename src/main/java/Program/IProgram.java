package Program;

import Loader.ILoader;

import java.io.IOException;

public interface IProgram {
    /**
     * Metoda uruchamiająca nasz program
     * @param n ilość danych, którą chcemy wygenerować
     */
    public void Start() throws IOException;

}
