package dataStructures.Mappers.FamilyMember;

import dataStructures.Config;
import dataStructures.People.FamilyMember;

public class FamilyMemberMapper {

    public static String MapFamilyMemberToString(FamilyMember familyMember)
    {
        switch (familyMember) {
            case mum -> {
                return "Mama";
            }
            case dad -> {
                return "Tata";
            }
            case son -> {
                return "Syn";
            }
            case daughter -> {
                return "Córka";
            }

        }
        return null;
    }
}
