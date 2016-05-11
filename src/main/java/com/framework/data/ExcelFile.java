package com.framework.data;

public abstract class ExcelFile {
	
	private String filename;
	private String sheetname;
	private int firstDateRow;
	private int numberOfRows;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSheetname() {
        return sheetname;
    }

    public void setSheetname(String sheetname) {
        this.sheetname = sheetname;
    }

    public int getFirstDateRow() {
        return firstDateRow;
    }

    public void setFirstDateRow(int firstDateRow) {
        this.firstDateRow = firstDateRow;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

        
	
	protected ExcelFile(){
		
	}

   

}
