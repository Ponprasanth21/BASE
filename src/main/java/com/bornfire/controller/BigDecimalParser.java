package com.bornfire.controller;

import org.apache.poi.ss.usermodel.Cell;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalParser {

    public BigDecimal getBigDecimalValue(Cell cell) {
        if (cell == null) {
            return BigDecimal.ZERO; // Return default value if cell is null
        }

        String value = getCellValueAsString(cell);
        value = value.replaceAll("[^\\d.]", ""); // Remove non-numeric characters except decimal point

        if (value.isEmpty()) {
            return BigDecimal.ZERO; // Return default value if the processed value is empty
        }

        try {
            // Create BigDecimal and set scale to 2 with rounding mode HALF_UP
            BigDecimal bigDecimalValue = new BigDecimal(value);
            return bigDecimalValue.setScale(2, RoundingMode.HALF_UP); // Round to 2 decimal places
        } catch (NumberFormatException e) {
            // Handle the exception (e.g., log it or return a default value)
            return BigDecimal.ZERO; // Return default value in case of an exception
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return ""; // Return empty string if cell is null
        }

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                // Convert numeric value to BigDecimal, round it to 2 decimal places, and return as plain string
                return BigDecimal.valueOf(cell.getNumericCellValue()).setScale(2, RoundingMode.HALF_UP).toPlainString();
            case Cell.CELL_TYPE_FORMULA:
                // Handle formula case
                return cell.getCellFormula(); // Or evaluate it as needed
            case Cell.CELL_TYPE_BLANK:
                return ""; // Return empty string for blank cells
            case Cell.CELL_TYPE_BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case Cell.CELL_TYPE_ERROR:
                return ""; // Handle error case if necessary
            default:
                return ""; // Default return for unsupported cell types
        }
    }

    public BigDecimal getBigDecimalValue(int i) {
        // Implement if necessary, or return default
        return null;
    }
}
