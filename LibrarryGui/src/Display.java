import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class Display {
	
    @SuppressWarnings("deprecation")
    public String getCellText(Cell cell) {
        String result = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = cell.getDateCellValue().toString();
                } else {
                    result = Integer.toString((int) cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula().toString();
                break;
            case Cell.CELL_TYPE_BLANK:
                result = " ";
                break;
            default:
                break;
        }
        return result;
    }

    public Workbook openFile() throws FileNotFoundException, IOException {
        Workbook wb = new HSSFWorkbook(new FileInputStream("lmsdb.xls"));
        return wb;
    }

    public String[] returnResult(int number, Workbook wb) {
        String[] results = new String[7];
        for (int i = 0; i < 7; i++) {
            results[i] = getCellText(wb.getSheetAt(0).getRow(number).getCell(i + 1));
        }
        return results;
    }

    public ArrayList < String > listTitle(Workbook wb, int column) {
        ArrayList < String > list = new ArrayList < String > ();
        String result = new String();
        
        if (column == 3) {
            for (int j = 1; j < wb.getSheetAt(0).getLastRowNum() + 1; j++) {
                result = getCellText(wb.getSheetAt(0).getRow(j).getCell(column)).replaceAll("[^0-9.]", "");
                list.add(result);
                list.set(j - 1, result);
            }
        } 
        
        else {
            for (int j = 1; j < wb.getSheetAt(0).getLastRowNum() + 1; j++) {
                result = getCellText(wb.getSheetAt(0).getRow(j).getCell(column));
                list.add(result);
                list.set(j - 1, result);
            }
        }

        Display mergeSort = new Display();
        
        if (column == 7) {
            ArrayList < Integer > inList = getIntegerArray(list);
            ArrayList < String > newList = new ArrayList < String > ();
            Integer[] inArray = inList.toArray(new Integer[inList.size()]);
            mergeSortIn(inArray);
            //Integer array to String arr
            String[] strArr = Arrays.toString(inArray).split("[\\[\\]]")[1].split(", ");
            for (String i: strArr) {
                newList.add(i);
            }
            list = newList;
        } 
        
        else
            mergeSort.mergeSort(list);
        return list;
    }
    

    private ArrayList < Integer > getIntegerArray(ArrayList < String > stringArray) {
        ArrayList < Integer > result = new ArrayList < Integer > ();
        for (String stringValue: stringArray) {
            try {
                result.add(Integer.parseInt(stringValue));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
        return result;
    }

    //Merge sort to Arraylist with String
    public ArrayList < String > mergeSort(ArrayList < String > whole) {
        ArrayList < String > left = new ArrayList < String > ();
        ArrayList < String > right = new ArrayList < String > ();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size() / 2;
            for (int i = 0; i < center; i++) {
                left.add(whole.get(i));
            }
            for (int i = center; i < whole.size(); i++) {
                right.add(whole.get(i));
            }
            left = mergeSort(left);
            right = mergeSort(right);
            merge(left, right, whole);
        }
        return whole;
    }

    private void merge(ArrayList < String > left, ArrayList < String > right, ArrayList < String > whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList < String > rest;
        int restIndex;
        if (leftIndex >= left.size()) {
           
            rest = right;
            restIndex = rightIndex;
        } 
        else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }


    //ArrayList Integer type  merge Sort
    public static void mergeSortIn(Comparable[] a) {
        Comparable[] tmp = new Comparable[a.length];
        mergeSortIn(a, tmp, 0, a.length - 1);
    }


    private static void mergeSortIn(Comparable[] a, Comparable[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSortIn(a, tmp, left, center);
            mergeSortIn(a, tmp, center + 1, right);
            mergeIn(a, tmp, left, center + 1, right);
        }
    }


    private static void mergeIn(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd)
            if (a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while (left <= leftEnd) 
            tmp[k++] = a[left++];
        
        while (right <= rightEnd) 
            tmp[k++] = a[right++];

        for (int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    public ArrayList < String[] > list(Workbook wb) {
        String[][] books = new String[wb.getSheetAt(0).getLastRowNum()][7];
        for (int i = 0; i < wb.getSheetAt(0).getLastRowNum(); i++) {
            for (int j = 0; j < 7; j++) {
                books[i][j] = returnResult(i + 1, wb)[j];
            }
        }
        ArrayList < String[] > lst = new ArrayList < String[] > ();
        for (int i = 0; i < wb.getSheetAt(0).getLastRowNum(); i++) {
            lst.add(books[i]);
            lst.set(i, books[i]);
        }

        return lst;
    }
}