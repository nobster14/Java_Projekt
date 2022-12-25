package Loader;

import PeopleGenerator.IPeopleGenerator;

import java.io.IOException;

public interface ILoader {
    /**
     * Metoda do załadowania danych z plików
     * @param generator Generator danych, do którego będziemy ładować dane
     */
    public void Load(IPeopleGenerator generator) throws IOException;
}
