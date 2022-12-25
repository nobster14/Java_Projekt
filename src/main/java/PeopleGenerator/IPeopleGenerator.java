package PeopleGenerator;

import DataStructures.Mappers.FileType.FileType;
import DataStructures.People.People;

/**
 * Klasa służąca generowaniu danych
 */
public interface IPeopleGenerator {
    public People GetRandomHusband();

    public People GetRandomWife(People husband);

    public People GetRandomChild(People dad, People mum);

    /**
     * Metoda dodająca nowe dane do zbióru danych, z którego będziemy generować
     * @param fileType typ wczytywanego pliku
     * @param data dodawane dane
     */
    public void AddData(FileType fileType, String data);
}
