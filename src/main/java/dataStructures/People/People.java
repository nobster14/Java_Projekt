package dataStructures.People;

import dataStructures.Mappers.FamilyMember.FamilyMemberMapper;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

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

    private FamilyMember who;
    public People(Date birthDate, Gender gender, String name, String surname, String pesel, String idNumber, String city, String street, FamilyMember who) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.idNumber = idNumber;
        this.street = street;
        this.city = city;
        this.who = who;
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

    public void Export (SXSSFRow row) {
        int cellId = 0;
        var cell = row.createCell(cellId++);
        cell.setCellValue(name);
        cell = row.createCell(cellId++);
        cell.setCellValue(surname);
        cell = row.createCell(cellId++);
        cell.setCellValue(birthDate.toLocaleString().split(",")[0]);
        cell = row.createCell(cellId++);
        cell.setCellValue(pesel);
        cell = row.createCell(cellId++);
        cell.setCellValue(city);
        cell = row.createCell(cellId++);
        cell.setCellValue(street);
        cell = row.createCell(cellId++);
        cell.setCellValue(idNumber);
        cell = row.createCell(cellId++);
        cell.setCellValue(FamilyMemberMapper.MapFamilyMemberToString(who));
    }
}

