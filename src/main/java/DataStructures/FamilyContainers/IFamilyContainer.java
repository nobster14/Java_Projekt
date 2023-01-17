package DataStructures.FamilyContainers;

import PeopleGenerator.PeopleGenerator;

public interface IFamilyContainer {

    /**
     * Funkcja eksportująca wszystkie rodziny w kontenerze
     */
    public void Export();

    /**
     * Funkcja generująca wszystkie rodziny w kontenerze
     */
    public void Generate(int n, PeopleGenerator generator);
}
