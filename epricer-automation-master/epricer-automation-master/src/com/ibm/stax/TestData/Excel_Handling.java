/**
 * 
 */
/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.TestData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aspose.cells.Workbook;
import com.ibm.stax.Utilities.Log;

public class Excel_Handling {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	public static Map<String, HashMap<String, String>> TestData;
	public static String fileFullPath;
	public static String srcSheetName;
	public static String resultPath = "";
	public static String resultSheetName = "";
	private XSSFWorkbook workbook2;
	private XSSFWorkbook workbook3;
	private XSSFWorkbook workbook22;

	public void ExcelReader(String fileName, String sheetname, String ResultPath, String ResultName) {
		try {
			fis = new FileInputStream(new File(fileName));
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetname);
			srcSheetName = sheetname;
			fileFullPath = fileName;
			resultPath = ResultPath;
			resultSheetName = ResultName;
			createcopy();
			fis.close();

			fis = new FileInputStream(new File(resultPath));
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(resultSheetName);
			fileFullPath = resultPath;
			srcSheetName = resultSheetName;

		} catch (FileNotFoundException fnfEx) {
			System.out.println(fileName + " is not Found. please check the file name.");
			System.exit(0);
		} catch (IOException ioEx) {
			System.out.println(fis + " is not Found. please check the path.");
		} catch (Exception ex) {
			System.out.println("There is error reading/loading xls file, due to " + ex);
		}
	}

	public static int searchField(String sheetName, int colNum, String value) throws Exception {
		try {
			int rowCount = sheet.getLastRowNum();
			System.out.println("rowCount " + rowCount);
			for (int i = 0; i <= rowCount; i++) {
				if (getCellData(i, colNum).equalsIgnoreCase(value)) {
					return i;
				}
			}
			return -1;
		} catch (Exception e) {
			throw (e);
		}
	}

	public String[] getRowData(int rowNum) throws Exception {
		String[] temp = new String[sheet.getRow(rowNum).getLastCellNum()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = getCellData(rowNum, i);
		return temp;
	}

	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			cell = sheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static String getCellIntData(int rowNum, int colNum) throws Exception {
		try {
			cell = sheet.getRow(rowNum).getCell(colNum);
			String CellData = String.valueOf(cell.getNumericCellValue());
			CellData = CellData.substring(0, CellData.indexOf("."));
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_Num);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}

	public List<HashMap<String, String>> getExcelData() {
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>(lastRow);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			HashMap<String, String> testdata = new HashMap<String, String>();
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				try {
					System.out.println("i:" + i + " " + "j:" + j);
					testdata.put(sheet.getRow(0).getCell(j).getStringCellValue(),
							sheet.getRow(i).getCell(j).getStringCellValue());

				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
			result.add(testdata);
		}
		return result;
	}

	public HashMap<String, String> getExcelRowData(int rowNum) {
		HashMap<String, String> map = new HashMap<String, String>();
		for (int j = 0; j < sheet.getRow(rowNum).getLastCellNum(); j++)
			map.put(sheet.getRow(0).getCell(j).getStringCellValue(),
					sheet.getRow(rowNum).getCell(j).getStringCellValue());
		return map;
	}

	public static String cellToString(HSSFCell cell) {
		int type = cell.getCellType();
		Object result;
		switch (type) {
		case Cell.CELL_TYPE_NUMERIC: // 0
			result = cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_STRING: // 1
			result = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA: // 2
			throw new RuntimeException("We can't evaluate formulas in Java");
		case Cell.CELL_TYPE_BLANK: // 3
			result = "-";
			break;
		case Cell.CELL_TYPE_BOOLEAN: // 4
			result = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_ERROR: // 5
			throw new RuntimeException("This cell has an error");
		default:
			throw new RuntimeException("We don't support this cell type: " + type);
		}
		return result.toString();
	}

	public int getRowCount(String sheetName) {
		return workbook.getSheet(sheetName).getLastRowNum() + 1;
	}

	public static int getFirstRowNum() {
		return sheet.getFirstRowNum();
	}

	public static int getLastRowNum() {
		return sheet.getLastRowNum();
	}

	public boolean setCellData(String filepath, String sheetName, String colName, int rowNum, String data) {
		try {
			if (rowNum <= 0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(filepath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addSheet(String filePath, String sheetName) {
		try {
			workbook.createSheet(sheetName);
			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean removeSheet(String filePath, String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return false;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addColumn(String filePath, String sheetName, String colName) {
		try {
			fis = new FileInputStream(filePath);
			workbook2 = new XSSFWorkbook(fis);
			int index = workbook2.getSheetIndex(sheetName);
			if (index == -1)
				return false;
			XSSFCellStyle style = workbook2.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			XSSFSheet sheet = workbook2.getSheetAt(index);
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = null;
			if (row == null)
				row = sheet.createRow(0);
			if (row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());
			cell.setCellValue(colName);
			cell.setCellStyle(style);
			fileOut = new FileOutputStream(filePath);
			workbook2.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean removeColumn(String filePath, String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			sheet = workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(CellStyle.NO_FILL);
			for (int i = 0; i < getRowCount(sheetName); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colNum);
					if (cell != null) {
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	public int getColumnCount(String sheetName) {
		if (!isSheetExist(sheetName))
			return -1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		if (row == null)
			return -1;
		return row.getLastCellNum();
	}

	public static String HSSFCellToString(HSSFCell cell) {
		String cellValue = null;
		if (cell != null) {
			cellValue = cell.toString();
			cellValue = cellValue.trim();
		} else {
			cellValue = "";
		}
		return cellValue;
	}

	public Map<String, HashMap<String, String>> getExcelDataAll(String sheetName, String Flag, String FlagValue,
			String Key) throws Exception {
		sheet = workbook.getSheet(sheetName);
		int flagIndex, keyIndex;
		flagIndex = findColumnIndex(Flag);
		keyIndex = findColumnIndex(Key);

		int lastRow = sheet.getLastRowNum();

		Map<String, HashMap<String, String>> result = new LinkedHashMap<String, HashMap<String, String>>(lastRow);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			if (getCellData(i, flagIndex).equalsIgnoreCase(FlagValue)) {
				LinkedHashMap<String, String> testdata = new LinkedHashMap<String, String>();
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
					try {
						XSSFCell cell0j = sheet.getRow(0).getCell(j);
						if(cell0j == null) {
							Log.error("Row: 0, Cell: " + j + " is null");
						} else {
							cell0j.setCellType(Cell.CELL_TYPE_STRING);
							XSSFCell cellJ = sheet.getRow(i).getCell(j);
							if(cellJ == null) {
								Log.error(String.format("Row: %d, Cell: %d is null", i,j));
							} else {
								cellJ.setCellType(Cell.CELL_TYPE_STRING);
								testdata.put(cell0j.getStringCellValue(),
										cellJ.getStringCellValue());
							}
						}
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				}
				result.put(sheet.getRow(i).getCell(keyIndex).getStringCellValue(), testdata);
			}
		}
		TestData = result;
		return result;
	}

	public int findColumnIndex(String ColumnHeader) {
		int ColumnCount, CurrentColumn;
		CurrentColumn = -1;
		XSSFRow fr = sheet.getRow(0);
		ColumnCount = fr.getLastCellNum() - fr.getFirstCellNum();

		for (int i = 0; i <= ColumnCount - 1; i++) {
			if (fr.getCell(i).getStringCellValue().contains(ColumnHeader)) {

				CurrentColumn = i;

				break;
			}
		}

		return CurrentColumn;
	}

	public static String Get_Data(String TestCase, String ColumnHeader) {
		LinkedHashMap<String, String> TC = (LinkedHashMap<String, String>) TestData.get(TestCase);
		return TC.get(ColumnHeader);
	}

	public static String Put_Data(String TestCase, String ColumnHeader, String Value) {
		String data = "";
			LinkedHashMap<String, String> TC = (LinkedHashMap<String, String>) TestData.get(TestCase);

			if (TC == null)
				return "Fail";

			if (TC.containsKey(ColumnHeader)) {
				data = TC.get(ColumnHeader);
				data = data + Value;
			} else {
				data = Value;

			}

			TC.put(ColumnHeader, data);
			return "success";
	}

	public String Put_Data_Replace(String TestCase, String ColumnHeader, String Value) {
		LinkedHashMap<String, String> TC = (LinkedHashMap<String, String>) TestData.get(TestCase);

		@SuppressWarnings("unused")
		String data = TC.get(ColumnHeader);

		TC.put(ColumnHeader, Value);
		return "success";
	}

	public static boolean setCellDataWithCondtion(String colName, String rowName, String rowValue, String data) {
		try {

			// int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			int rowNameNum = -1;

			// if (index == -1)
			// return false;
			// sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			// System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+row.getLastCellNum());
			for (int i = 0; i < row.getLastCellNum(); i++) {
				String str= row.getCell(i).getStringCellValue().trim();

				if (str.equals(colName)) {
					colNum = i;
					// System.out.println("+++++++++++++++++++++++++++++++++"+colNum);
					break;
				}

			}
			if (colNum == -1) {

				colNum = row.getLastCellNum();

				row.createCell(colNum);
				cell = row.getCell(colNum);
				cell.setCellValue(colName);

			}
			for (int i = 0; i < row.getLastCellNum() - 1; i++) {
				System.out.println(i + rowName + row.getCell(i).getStringCellValue());
				String s = row.getCell(i).getStringCellValue().trim();
				if (s.equals(rowName.trim())) {
					rowNameNum = i;
					break;
				}

			}
			if (rowNameNum == -1)
				return false;
			// System.out.println("+++++++++++++++++++++++++++++++++RownameNumber"+rowNameNum);

			int rowNum = searchField(srcSheetName, rowNameNum, rowValue);
			// System.out.println(rowNum);
			// System.out.println("+++++++++++++++++++++++++++++++++RowNumber"+rowNum);
			if (rowNum <= 0)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			// System.out.println("+++++++++++++++++++++++++++++++++RowNumber"+rowNum+"colNum"+colNum);
			cell.setCellValue(data);
			// System.out.println("+++++++++++++++++++++++++++++++++RowNumber"+rowNum+"colNum"+colNum+"data"+data);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean Write_Data(String rowName, String ColumnHeader)

	{
		String s = "";
		try {
			Map<String, HashMap<String, String>> map = TestData;
			@SuppressWarnings("unused")
			HashMap<String, String> m = new HashMap<String, String>();
			for (String key : map.keySet()) {

				// System.out.println("key : " + key);
				m = map.get(key);
				s = Get_Data(key, ColumnHeader);
				System.out.println(ColumnHeader + rowName + key + s);
				if (s != null)
					setCellDataWithCondtion(ColumnHeader, rowName, key, s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;

	}

	public void close() {
		System.out.println(fileFullPath + srcSheetName);
		try {
			fileOut = new FileOutputStream(fileFullPath);

			workbook.write(fileOut);
			
				fileOut.close();
			} catch (IOException e) {
				Log.error("Unable to close " + fileFullPath + " file.\n" + e.getMessage());
			}
	}

	public void createcopy() throws Exception {

		File excel = new File(resultPath);
		if (!excel.exists()) {
			try {

				workbook3 = new XSSFWorkbook();

				FileOutputStream out = new FileOutputStream(new File(resultPath));
				workbook3.createSheet(resultSheetName);
				workbook3.write(out);
				out.close();

			} catch (IOException e) {
				System.out.println("Failed to create new file, \n" + e.getMessage()); // Log framework would be much
																						// better instead of system
																						// print outs
			}

		}
		System.out.println(srcSheetName);
		Workbook excelWorkbook1 = new Workbook(fileFullPath);

		Workbook excelWorkbook2 = new Workbook(resultPath);

		// excelWorkbook2.getWorksheets().add();

		excelWorkbook2.getWorksheets().get(0).copy(excelWorkbook1.getWorksheets().get(srcSheetName));

		excelWorkbook2.save(resultPath);

		FileInputStream fis2 = new FileInputStream(new File(resultPath));
		workbook22 = new XSSFWorkbook(fis2);
		workbook22.removeSheetAt(1);
		FileOutputStream fileOut2 = new FileOutputStream(resultPath);

		workbook22.write(fileOut2);
		fileOut2.close();

	}

	public boolean Write_Data_All(String rowName, String ColumnHeaders)

	{

		String ch[] = ColumnHeaders.split(";");

		for (String s : ch) { // System.out.println(s+"*********************************************");
			Write_Data(rowName, s);
		}

		close();
		return true;

	}
	public static String GetSecureData(int RowNum, int ColNum, int sheetnumber, String envString) throws Throwable {
		File UIDFile;
		if (envString.equalsIgnoreCase("Prod")) {
			UIDFile = new File("E://Desktop//SanityReports//SanityUID//UID_Prod.xlsx");
		}else {
			UIDFile = new File("E://Desktop//SanityReports//SanityUID//UID.xlsx");
		}
		FileInputStream istrm = new FileInputStream(UIDFile);
		XSSFWorkbook wrkbuk = new XSSFWorkbook(istrm);
		XSSFSheet sheetseq = wrkbuk.getSheetAt(sheetnumber);
		XSSFCell Cell = sheetseq.getRow(RowNum).getCell(ColNum);
        String CellData = Cell.getStringCellValue();
        wrkbuk.close();
        return CellData;
        
	}

}
