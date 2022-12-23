package Program;

import DataStructures.Constants;
import DataStructures.FamilyContainers.FamilyCointainer;
import DataStructures.FamilyContainers.IFamilyCointainer;

import java.util.List;

public class Program implements IProgram{
    private List<IFamilyCointainer> Cointainers;
    @Override
    public void CreateFamilyContainers(int n) {
        for (int i = 0; i < Math.ceil(n / Constants.COINTAINER_SIZE); i++)
            Cointainers.add(new FamilyCointainer());
    }

    @Override
    public void ExportFamilyContainers() {
        for (var cointainer : Cointainers)
            cointainer.Export();
    }
}
