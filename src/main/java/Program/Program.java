package Program;

import dataStructures.FamilyContainers.FamilyContainer;
import dataStructures.FamilyContainers.IFamilyContainer;
import Loader.Loader;
import PeopleGenerator.PeopleGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Program implements IProgram {
    /**
     * Kontener zawierający rodziny
     */
    private final IFamilyContainer Container = new FamilyContainer();
    /**
     * Generator osób
     */
    private final PeopleGenerator generator = new PeopleGenerator();

    /**
     * Metoda tworząca nasze rodziny
     * @param n Liczba osób, których dane chcemy wygenerować
     */
    private void Create(int n) {
        Container.Generate(n, generator);
    }

    /**
     * Metoda tworząca nasze rodziny
     */
    private void Export() {
        Container.Export();
    }

    @Override
    public void Start() throws IOException {
        int n = GetN();
        new Loader().Load(generator);
        Create(n);
        Export();
    }

    /**
     * Funkcja przyjmująca z konsoli od użytkownika liczbę osób, którą chce on wygenerować
     * @return Liczba osób, których dane chcemy wygenerować
     */
    private int GetN() {
        Scanner input = new Scanner(System.in);
        int n = 0;
        boolean invalidInput;
        do {
            invalidInput = false;
            try {
                System.out.println("Ile danych chcesz wygenerować?");
                n = input.nextInt();
                if(n < 0) {
                    throw new Exception("Wprowadzono ujemną liczbę, proszę wprowadź dodatnią liczbę całkowitą");
                }
                else {
                    System.out.println("Wszystko ok, generowanie danych.");
                }
            }
            catch (Exception e) {
                System.out.println("Proszę wprowadź dodatnią liczbę całkowitą.\n");
                invalidInput = true;
                input.nextLine();
            }
        } while (invalidInput);

        return n;
    }
}
