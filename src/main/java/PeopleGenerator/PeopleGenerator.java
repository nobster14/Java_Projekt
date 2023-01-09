package PeopleGenerator;

import DataStructures.Mappers.FileType.FileType;
import DataStructures.People.People;
import PeopleGenerator.PeselGenerator.PeselGenerator;

import java.util.ArrayList;
import java.util.List;

public class PeopleGenerator implements IPeopleGenerator{
    private List<String> maleSurnames = new ArrayList<String>();
    private List<String> maleNames = new ArrayList<String>();
    private List<String> femaleSurnames = new ArrayList<String>();
    private List<String> femaleNames = new ArrayList<String>();

    private PeselGenerator peselGenerator = new PeselGenerator();

    @Override
    public People GetRandomHusband() {
        return null;
    }

    @Override
    public People GetRandomWife(People husband) {
        return null;
    }

    @Override
    public People GetRandomChild(People dad, People mum) {
        return null;
    }

    @Override
    public String GeneratePesel(People people) {
        return peselGenerator.generate(people);
    }

    @Override
    public void AddData(FileType fileType, String data) {
        switch (fileType) {
            case maleNames -> maleNames.add(data);
            case femaleNames -> femaleNames.add(data);
            case maleSurnames -> maleSurnames.add(data);
            case femaleSurnames -> femaleSurnames.add(data);
        }
    }
}
