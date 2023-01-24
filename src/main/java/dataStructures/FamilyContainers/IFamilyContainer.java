package dataStructures.FamilyContainers;

import PeopleGenerator.PeopleGenerator;

import java.io.IOException;

public interface IFamilyContainer {

    /**
     * Funkcja eksportująca wszystkie rodziny w kontenerze
     */
    public void Export() throws IOException;

    /**
     * Funkcja generująca wszystkie rodziny w kontenerze
     */
    public void Generate(int n, PeopleGenerator generator);
}
