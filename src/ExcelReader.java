import Bean.AllianceFirst;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017/7/13.
 */
public class ExcelReader {

    public ArrayList<AllianceFirst> readXls(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        AllianceFirst allianceFirst = null;
        ArrayList<AllianceFirst> list = new ArrayList<AllianceFirst>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    HSSFCell id = hssfRow.getCell(0);
                    HSSFCell name = hssfRow.getCell(1);
                    HSSFCell urlImage = hssfRow.getCell(2);
                    HSSFCell urlGoodsInfo = hssfRow.getCell(3);
                    HSSFCell shopName = hssfRow.getCell(4);
                    HSSFCell goodsPirce = hssfRow.getCell(5);
                    HSSFCell saleNumMonth = hssfRow.getCell(6);
                    HSSFCell commissionPercentage = hssfRow.getCell(7);
                    HSSFCell commissionPirce = hssfRow.getCell(8);
                    HSSFCell WANGWANG = hssfRow.getCell(9);
                    HSSFCell TaobaoShortChain = hssfRow.getCell(10);
                    HSSFCell TaobaoShortChainLong = hssfRow.getCell(11);
                    HSSFCell TaobaoPassword = hssfRow.getCell(12);
                    HSSFCell couponTotal = hssfRow.getCell(13);
                    HSSFCell couponRemaining = hssfRow.getCell(14);
                    HSSFCell couponDenomination = hssfRow.getCell(15);
                    HSSFCell couponStartTime = hssfRow.getCell(16);
                    HSSFCell couponEndTime = hssfRow.getCell(17);
                    HSSFCell urlCoupon = hssfRow.getCell(18);
                    HSSFCell couponPassword = hssfRow.getCell(19);
                    HSSFCell couponShortChain = hssfRow.getCell(20);
                    HSSFCell marketingPlan = hssfRow.getCell(21);
                    boolean isMarketingPlan = marketingPlan.getStringCellValue().equals("是");
                    allianceFirst = new AllianceFirst(getValue(id),
                            getValue(name),
                            getValue(urlImage),
                            getValue(urlGoodsInfo),
                            getValue(shopName),
                            getValue(goodsPirce),
                            getValue(saleNumMonth),
                            getValue(commissionPercentage),
                            getValue(commissionPirce),
                            getValue(WANGWANG),
                            getValue(TaobaoShortChain),
                            getValue(TaobaoShortChainLong),
                            getValue(TaobaoPassword),
                            Integer.valueOf(getValue(couponTotal)),
                            Integer.valueOf(getValue(couponRemaining)),
                            getValue(couponDenomination),
                            getValue(couponStartTime),
                            getValue(couponEndTime),
                            getValue(urlCoupon),
                            getValue(couponPassword),
                            getValue(couponShortChain),
                            isMarketingPlan
                    );
                    list.add(allianceFirst);
                }
            }
        }
        return list;
    }


    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell != null) {
            if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
                // 返回布尔类型的值
                return String.valueOf(hssfCell.getBooleanCellValue());
            } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
                // 返回数值类型的值
                return String.valueOf(hssfCell.getNumericCellValue());
            } else {
                // 返回字符串类型的值
                return String.valueOf(hssfCell.getStringCellValue());
            }
        } else {
            return "";
        }
    }
}
