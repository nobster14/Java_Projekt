package Program;

import DataStructures.Config;
import DataStructures.FamilyContainers.FamilyContainer;
import DataStructures.FamilyContainers.IFamilyContainer;
import Loader.Loader;
import PeopleGenerator.PeopleGenerator;
import org.apache.commons.collections4.Get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program implements IProgram{
    private List<IFamilyContainer> Cointainers = new ArrayList<IFamilyContainer>();
    private PeopleGenerator generator = new PeopleGenerator();

    private void CreateFamilyContainers(int n) {
        for (int i = 0; i < Math.ceil((float)n / Config.CONTAINER_SIZE); i++)
            Cointainers.add(new FamilyContainer());
    }

    private void ExportFamilyContainers() {
        for (var container : Cointainers)
            container.Export();
    }

    @Override
    public void Start() throws IOException {
        int n = GetN();
        new Loader().Load(generator);
        CreateFamilyContainers(n);
        ExportFamilyContainers();
    }
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
