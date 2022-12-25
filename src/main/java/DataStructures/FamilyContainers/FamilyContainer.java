package DataStructures.FamilyContainers;

import DataStructures.FamilyTemplates.IFamilyTemplate;
import DataStructures.People.People;

import java.util.List;

public class FamilyContainer implements IFamilyContainer {

    public FamilyContainer()
    {
        Generate();
    }
    private List<List<People>> families;

    @Override
    public void Export() {

    }

    @Override
    public void Generate() {
        for (var template : GenerateTemplates())
            families.add(template.Create());
    }

    private List<IFamilyTemplate> GenerateTemplates() {
        return null;
    }

}
