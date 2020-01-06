package com.itheima.document.util;

import com.itheima.document.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李靖宇
 * @Project document
 * @date 2020/1/1 18:33
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class ExcelUtils {
    public static List<Student> importExcel(Workbook workbook){
        List<Student> list=new ArrayList<>();
        final Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            final Row row = sheet.getRow(i);
            Object [] objects=new Object[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                final Cell cell = row.getCell(j);
                Object value =getCell(cell);
                objects[j]=value;
            }
            Student student=new Student(objects);
            list.add(student);
        }
        return list;
    }

    public static Object getCell(Cell cell){
        final CellType cellType = cell.getCellType();
        Object value=null;
        switch (cellType){
            case STRING:value=cell.getStringCellValue();break;
            case BOOLEAN:value=cell.getBooleanCellValue();break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)){
                    value=cell.getDateCellValue();
                }else {
                    value=cell.getNumericCellValue();
                }
                break;
            case FORMULA:value=cell.getCellFormula();break;
            default:break;
        }
        return value;
    }

    public static ByteArrayOutputStream exportUser(List<Student> studentList, String sheetName) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(25);
        sheet.setDefaultRowHeight((short)35);
        int index=0;
        HSSFRow row0=sheet.createRow(index);
        String [] titles={"学号","姓名","专业","班级","学院","性别","身份证号"};
        for (int i = 0; i < titles.length; i++) {
            HSSFCell cell = row0.createCell(i);
            cell.setCellValue(titles[i]);
        }
        index++;
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            final HSSFRow row = sheet.createRow(index);

            final HSSFCell cell = row.createCell(0);
            cell.setCellValue(student.getSno());

            final HSSFCell cell2 = row.createCell(1);
            cell2.setCellValue(student.getName());

            final HSSFCell cell3 = row.createCell(2);
            cell3.setCellValue(student.getMajor());

            final HSSFCell cell4 = row.createCell(3);
            cell4.setCellValue(student.getGrade());

            final HSSFCell cell5 = row.createCell(4);
            cell5.setCellValue(student.getCollege());

            final HSSFCell cell6 = row.createCell(5);
            cell6.setCellValue(student.getGander());

            final HSSFCell cell7 = row.createCell(6);
            cell7.setCellValue(student.getIdcard());
            index++;
        }

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}
