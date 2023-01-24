package dataStructures.People;

import java.util.Date;

public class People {
    private Date birthDate;
    private String name;
    private String surname;
    private Gender gender;

    private String idNumber;

    private String pesel;
    private String city;
    private String street;
    public People(Date birthDate, Gender gender, String name, String surname, String pesel, String idNumber, String city, String street) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.idNumber = idNumber;
        this.street = street;
        this.city = city;
    }

    public Gender GetGender() {
        return gender;
    }
    public Date GetBirthDate() {
        return birthDate;
    }
    public void SetPesel(String pesel) {
        this.pesel = pesel;
    }
    public String GetSurname() {
        return this.surname;
    }
    public String GetCity() { return this.city; }
    public String GetStreet() { return this.street; }
}

