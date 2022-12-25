package Program;

import DataStructures.Config;
import DataStructures.FamilyContainers.FamilyContainer;
import DataStructures.FamilyContainers.IFamilyContainer;
import Loader.Loader;
import PeopleGenerator.PeopleGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void Start(int n) throws IOException {
        new Loader().Load(generator);
        CreateFamilyContainers(n);
        ExportFamilyContainers();
    }
}
