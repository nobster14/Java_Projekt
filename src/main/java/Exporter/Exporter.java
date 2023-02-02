package Exporter;

import dataStructures.Config;
import dataStructures.FamilyTemplates.Family;
import dataStructures.People.People;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exporter {

    private SXSSFWorkbook workbook;
    private ArrayList<SXSSFSheet> spreadsheets = new ArrayList<SXSSFSheet>();

    private int sheetId = 0;
    private String sheetName;

    private int rowId = 0;
    public Exporter(String spreadsheetName) {
        workbook = new SXSSFWorkbook();
        sheetName = spreadsheetName;
        spreadsheets.add(workbook.createSheet(spreadsheetName + "" + sheetId));

    }

    public void WriteFamilyToSheet(List<People> family) {
       rowId = Family.Export(spreadsheets.get(sheetId), rowId, family);
       spreadsheets.get(sheetId).createRow(rowId++);

       if (rowId > 1000000)
       {
           sheetId += 1;
           spreadsheets.add(workbook.createSheet(sheetName + " " + sheetId));
           InitSheet(spreadsheets.get(sheetId));
       }
    }
    public void ExportFile() throws IOException {
        String path = new java.io.File(".").getCanonicalPath() + Config.outputDataFolderName + Config.outputFileName;

        FileOutputStream out = new FileOutputStream(new File(path));
        workbook.write(out);
        out.close();
    }
    private void InitSheet(SXSSFSheet sheet)
    {
        rowId = 0;
        var row = spreadsheets.get(sheetId).createRow(rowId++);

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
}
