package Exporter;

import dataStructures.Config;
import dataStructures.FamilyTemplates.Family;
import dataStructures.People.People;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Exporter {

    private XSSFWorkbook workbook;
    private XSSFSheet spreadsheet;

    private int rowId = 0;
    public Exporter(String spreadsheetName) {
        workbook = new XSSFWorkbook();
        spreadsheet = workbook.createSheet(spreadsheetName);
        var row = spreadsheet.createRow(rowId++);

        int cellId = 0;
        Cell cell = row.createCell(cellId++);
        cell.setCellValue("Imię");
        cell = row.createCell(cellId++);
        cell.setCellValue("Nazwisko");
        cell = row.createCell(cellId++);
        cell.setCellValue("Data urodzenia");
        cell = row.createCell(cellId++);
        cell.setCellValue("PESEL");
        cell = row.createCell(cellId++);
        cell.setCellValue("Miejscowość");
        cell = row.createCell(cellId++);
        cell.setCellValue("Ulica");
        cell = row.createCell(cellId++);
        cell.setCellValue("Numer dowodu osobistego");
        cell = row.createCell(cellId++);
        cell.setCellValue("Pokrewieństwo");
    }

    public void WriteFamilyToSheet(List<People> family) {
       rowId = Family.Export(spreadsheet, rowId, family);
       spreadsheet.createRow(rowId++);
    }
    public void ExportFile() throws IOException {
        String path = new java.io.File(".").getCanonicalPath() + Config.outputDataFolderName + Config.outputFileName;

        FileOutputStream out = new FileOutputStream(new File(path));
        workbook.write(out);
        out.close();
    }
}
