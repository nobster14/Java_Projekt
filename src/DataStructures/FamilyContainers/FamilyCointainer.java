package DataStructures.FamilyContainers;

import DataStructures.FamilyTemplates.FamilyTemplate;
import DataStructures.FamilyTemplates.IFamilyTemplate;
import DataStructures.People.People;
import jdk.jshell.spi.ExecutionControl;

import javax.xml.transform.Templates;
import java.util.List;

public class FamilyCointainer implements IFamilyCointainer {

    public FamilyCointainer()
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
