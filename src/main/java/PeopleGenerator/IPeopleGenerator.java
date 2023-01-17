package PeopleGenerator;

import DataStructures.Mappers.FileType.FileType;
import DataStructures.People.People;

/**
 * Klasa służąca generowaniu danych
 */
public interface IPeopleGenerator {
    People GetRandomAdult();

    People GetRandomSpouse(People husband);

    People GetRandomChild(People dad, People mum);

    String GeneratePesel(People people);

    /**
     * Metoda dodająca nowe dane do zbioru danych, z którego będziemy generować
     * @param fileType typ wczytywanego pliku
     * @param data dodawane dane
     */
    void AddData(FileType fileType, String data);
}
