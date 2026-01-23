// src/test/java/utils/ExcelUtils.java
package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<String> getCities() {
        List<String> cities = new ArrayList<>();
        String data;
        try (FileInputStream fis = new FileInputStream("C:\\Intelli J Practise\\TrivagoHotel\\src\\main\\resources\\TestData.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            int row = sheet.getLastRowNum()+1;
            for (int r = 1;r<row;r++) {
                data = sheet.getRow(r).getCell(0).toString();
                cities.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
}