package DataStructures.FamilyTemplates;

import DataStructures.People.People;
import PeopleGenerator.PeopleGenerator;

import java.util.ArrayList;
import java.util.List;

public class Family implements IFamily {
    private final int parentCount;
    private final int childCount;

    /**
     * Lista wzorców naszych rodzin
     */
    private static final ArrayList<Family> familyTemplates = new ArrayList<> () {{
        add(new Family(0, 1));
        add(new Family(0, 2));
        add(new Family(1, 2));
        add(new Family(2, 2));
        add(new Family(3, 2));
        add(new Family(4, 2));
    }};
    public Family(int childCount, int parentCount) {
        this.childCount = childCount;
        this.parentCount = parentCount;
    }

    @Override
    public List<People> Create(PeopleGenerator generator) {
        if (parentCount == 1) return GetOneAdultFamily(generator);

        List<People> family = new ArrayList<>();

        //generujemy ojca/męża
        family.add(generator.GetRandomAdult(true));
        //generujemy matkę/żonę
        family.add(generator.GetRandomSpouse(family.get(0)));

        for (int i = 0; i < childCount; i++)
            family.add(generator.GetRandomChild(family.get(0), family.get(1)));

        return family;
    }

    @Override
    public void Export() {

    }

    public static ArrayList<Family> GetTemplates() { return familyTemplates; }

    public int GetFamilySize() { return childCount + parentCount;}

    private List<People> GetOneAdultFamily(PeopleGenerator generator) {
        return new ArrayList<People>() {{ add(generator.GetRandomAdult(false)); }};
    }
}
