package Loader;

import dataStructures.Config;
import dataStructures.Mappers.FileType.FileType;
import dataStructures.Mappers.FileType.FileTypeMapper;
import PeopleGenerator.IPeopleGenerator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Loader implements ILoader{
    @Override
    public void Load(IPeopleGenerator generator) throws IOException {
        LoadData(FileType.maleNames, generator);
        LoadData(FileType.maleSurnames, generator);
        LoadData(FileType.femaleNames, generator);
        LoadData(FileType.femaleSurnames, generator);
        LoadData(FileType.cities, generator);
        LoadData(FileType.streets, generator);
    }

    /**
     *
     * @param fileType typ wczytywanego pliku
     * @param generator generator, do którego ładujemy dane
     * @throws IOException rzucany wyjątek
     */
    private void LoadData(FileType fileType, IPeopleGenerator generator) throws IOException {
        FileInputStream file = new FileInputStream(new File(GetPath(FileTypeMapper.MapFileTypeToFileName(fileType))));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getCell(0) != null)
                generator.AddData(fileType, row.getCell(0).getStringCellValue());
        }
    }

    /**
     * Zwraca bezwzględną ścieżkę do pliku na podstawie jego nazwy
     * @param fileName nazwa pliku
     */
    private String GetPath(String fileName) throws IOException {
        String path = new java.io.File(".").getCanonicalPath();
        return path + Config.folderName + fileName;
    }
}
