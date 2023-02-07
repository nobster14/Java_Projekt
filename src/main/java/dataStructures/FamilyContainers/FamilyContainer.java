package dataStructures.FamilyContainers;

import Exporter.Exporter;
import dataStructures.Config;
import dataStructures.FamilyTemplates.Family;
import dataStructures.People.People;
import PeopleGenerator.PeopleGenerator;
import org.apache.commons.math3.analysis.function.Exp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FamilyContainer implements IFamilyContainer {

    private Random random = new Random();
    private Exporter exporter = new Exporter(Config.outputSheetName);
    public FamilyContainer() {
    }
    private List<List<People>> families = new ArrayList<>();

    @Override
    public void Export() throws IOException {
        for (var family : families)
            exporter.WriteFamilyToSheet(family);

        exporter.ExportFile();
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
