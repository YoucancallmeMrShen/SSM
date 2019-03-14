package pro.zyyz.util;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class ExcelWriteUtil {


    /**
     * Excel表格导出类
     * @param header
     * @param body
     */
    public static void excelWrite(String sheetName, List<String> header, List<List<String>> body, OutputStream out){
        //1、创建excel表格
        Workbook workbook = new HSSFWorkbook();

        //2、添加一个sheet（sheet即excel表格中的小表）
        Sheet sheet = workbook.createSheet(sheetName);

        //3、在excel表格中新建一行，作为表头,以第0行为表头,并根据header中的值设置表头中各项目的名称
        Row firstRow = sheet.createRow(0);
        for(int colNum = 0; colNum < header.size(); colNum ++){
            //4、创建单元格
            Cell hssCell = firstRow.createCell( colNum );
            //5、设置单元格的值
            hssCell.setCellValue(header.get(colNum));
        }
        //6、手动设置列宽，第一个参数表示设置第几列，第二个参数表示列的宽度，单位为像素
//        for (int i = 0; i < body.size() + 7; i++) {
//            sheet.setColumnWidth((short) i, (short) (28 * 200));
//        }
        //7、设置主体数据
        for(int rowNum = 0; rowNum < body.size(); rowNum ++){
            //8、创建一行数据，并设置该行的内容
            Row hssRow = sheet.createRow( rowNum + 1 );
            List<String> rowValue = body.get(rowNum);
            for(int colNum = 0; colNum < rowValue.size(); colNum ++){
                Cell hssCell = hssRow.createCell(colNum);
                hssCell.setCellValue(rowValue.get(colNum));
            }
        }
        try {
            ((HSSFWorkbook) workbook).write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
