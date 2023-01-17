package DataStructures.FamilyTemplates;

import DataStructures.People.People;
import PeopleGenerator.PeopleGenerator;

import java.util.ArrayList;
import java.util.List;

public class Family implements IFamily {
    private int parentCount;
    private int childCount;

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
        List<People> family = new ArrayList<>();


        return family;
    }

    @Override
    public void Export() {

    }

    public static ArrayList<Family> GetTemplates() { return familyTemplates; }

    public int GetFamilySize() { return childCount + parentCount;}

}
