package com.example.excelnumberfinder;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<Integer> readNumbers(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(new File(filePath));
            Sheet sheet = workbook.getSheetAt(0); // First sheet
            for (Row row : sheet) {
                Cell cell = row.getCell(0); // First column (A)
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        }
        return numbers;
    }
}
