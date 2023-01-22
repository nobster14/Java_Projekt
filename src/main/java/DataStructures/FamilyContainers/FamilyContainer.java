package DataStructures.FamilyContainers;

import DataStructures.FamilyTemplates.Family;
import DataStructures.People.People;
import PeopleGenerator.PeopleGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FamilyContainer implements IFamilyContainer {

    private Random random = new Random();
    public FamilyContainer() {
    }
    private List<List<People>> families = new ArrayList<>();

    @Override
    public void Export() {

    }

    @Override
    public void Generate(int n, PeopleGenerator generator) {
        int familyTypes = Family.GetTemplates().size();
        int personsGeneratedCount = 0;

        while (personsGeneratedCount < n) {
            var template = Family.GetTemplates().get(random.nextInt(familyTypes));

            families.add(template.Create(generator));
            personsGeneratedCount += template.GetFamilySize();
        }
    }
}
