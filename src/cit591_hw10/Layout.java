package cit591_hw10;

import java.util.Arrays;

public class Layout {
	
	final int[][] data;
	
	//passed
	public Layout(int[][] array){
		data = array;
	}
	
	//passed
	public Layout(int[] array){
		data = new int[1][];
		data[0] = array;
	}
	
	//passed
	public Layout(int length){
		if (length < 0) {
			throw new IllegalArgumentException("Array length must be positive");
		}
		
		int[] array = new int[length];
		for(int i=0; i<length; i++){
			array[i] = i+1;
		}
		data = new int[1][];
		data[0] = array;
	}
	
	//helper method
	public void print(){
		int rows = rowCount();
		int columns = columnCount();
		for(int i=0; i<rows; i++){		
			for(int j=0; j<columns; j++){
				System.out.printf("%d ", data[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	//passed
	//take each row and reverse it
	//making the first column last and the last column first
	public Layout reverse() {
		int rows = rowCount(); 
		int columns = columnCount(); 
		int[][] data_reversed = new int[rows][columns];
		for(int i=0; i<rows; i++){		
			for(int j=0; j<columns; j++){
				int reverse_index = (columns - j) - 1;
				data_reversed[i][reverse_index] = data[i][j]; 
			}
		}
		return new Layout(data_reversed);
	}

	//passed
	public Layout rotateRight() {
		//lol
		return rotateLeft().rotateLeft().rotateLeft();
	}

	//passed
	public Layout rotateLeft() {
		int rowCount = rowCount(); 
		int columnCount = columnCount(); 
		
		int[][] dataRotated = new int [columnCount][rowCount]; 

		for(int i=0; i<rowCount; i++){		
			for(int j=0; j<columnCount; j++){
				int jReversed = columnCount - j - 1;
				dataRotated[jReversed][i] = data[i][j]; 
			}
		}

		return new Layout(dataRotated);
	}

	//passed
	public Layout transpose() {
		int rowCount = rowCount(); 
		int columnCount = columnCount(); 
		
		int[][] dataRotated = new int [columnCount][rowCount]; 

		for(int i=0; i<rowCount; i++){		
			for(int j=0; j<columnCount; j++){
				dataRotated[j][i] = data[i][j]; 
			}
		}

		return new Layout(dataRotated);
	}

	//selah
	public Layout ravel(int n) {

		//check if this array is appropriate for ravelling
		if(rowCount() != 1){
			throw new IllegalArgumentException("ravel can only be run on one dimensional arrays");
		}
		else if(columnCount() % n != 0){
			throw new IllegalArgumentException("array length must be divisible by ravel parameter");
		}

		//initialize ravelled array
		int newRowCount = columnCount()/n;
		int newColumnCount = n;		
		int[][] ravelledData = new int[newRowCount][newColumnCount];

		//fill ravelled array with data
		for(int i=0; i<columnCount(); i++){
			int newRow = i / n;
			int newColumn = i % n;			
			ravelledData[newRow][newColumn] = data[0][i]; 
		}
		
		return new Layout(ravelledData);	
	}
	
	//selah
	public Layout unravel() {

		//initialize unravelled array
		int newRowCount = 1;
		int newColumnCount = rowCount()*columnCount();
		int[][] unravelledData = new int[newRowCount][newColumnCount];

		//fill unravelled array with data
		for(int i=0; i<newColumnCount; i++){
			int oldRow = i / columnCount();
			int oldColumn = i % columnCount();			
			 unravelledData[0][i] = data[oldRow][oldColumn]; 
		}
		
		return new Layout(unravelledData);	
	}
	
	//selah
	public Layout reshape(int n) {
		return null;		
	}
	
	//Dichen, passed!
	public Layout join(Layout layout) {
		if (layout.rowCount() != this.rowCount()) {
			throw new IllegalArgumentException("The row numbers are different!");
		}
		
		int row = this.rowCount();
		int col1 = this.columnCount();
		int col2 = layout.columnCount();
		int col = col1 + col2;
		int[][] array = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col1; j++){
				array[i][j] = this.at(i, j);
			}
			for (int j = 0; j < col2; j++) {
				array[i][j + col1] = layout.at(i,  j);
			}
		}
		
		Layout joined = new Layout(array);
		return joined;
	}
	
	//Dichen, passed!
	public Layout stack(Layout layout) {
		if (layout.columnCount() != this.columnCount()) {
			throw new IllegalArgumentException("The column numbers are different!");
		}	
		
		int row = this.rowCount() + layout.rowCount();
		int[][] array = new int[row][columnCount()];
		for (int i = 0; i < this.rowCount(); i++) {
			System.arraycopy(data[i], 0, array[i], 0, columnCount());
		}
		
		int[][] arrayLayout = layout.toArray2D();
		for (int i = this.rowCount(); i < row; i++) {
			System.arraycopy(arrayLayout[i - this.rowCount()], 0, array[i], 0, columnCount());
		}
		
		return new Layout(array);
	}
	
	//test passed!
	public int rowCount() {
		return data.length;		
	}
	
	//test passed!
	public int columnCount(){
		return data[0].length;		
	}
	
	//Dichen passed
	public Layout rows(int firstRow, int lastRow) {
		if (firstRow > rowCount() || lastRow > rowCount()) {
			throw new IllegalArgumentException("rows out of bond");	
		} else if (firstRow < 0 || lastRow < 0) {
			throw new IllegalArgumentException("rows must be non-negative");
		} else if (lastRow < firstRow) {
			throw new IllegalArgumentException("starting row is larger than ending row");
		}
		
		//http://stackoverflow.com/questions/11001720/get-only-part-of-an-array-in-java
		int[][] newArray = Arrays.copyOfRange(data, firstRow, lastRow + 1); 
		return new Layout(newArray);
	}
	
	//Dichen passed
	public Layout columns(int firstColumn, int lastColumn) {
		if (firstColumn > columnCount() || lastColumn > columnCount()) {
			throw new IllegalArgumentException("Columns out of bond");	
		} else if (firstColumn < 0 || lastColumn < 0) {
			throw new IllegalArgumentException("Columns must be non-negative");
		} else if (lastColumn < firstColumn) {
			throw new IllegalArgumentException("starting column is larger than ending column");
		}
		
		int length = lastColumn - firstColumn + 1; // number of columns of copied array
		int[][] newArray = new int[rowCount()][length];
		for (int i = 0; i < rowCount(); i++) { //copy each row
			System.arraycopy(data[i], firstColumn, newArray[i], 0, length);
		} 
		return new Layout(newArray);
	}
	
	//Dichen passed
	public Layout slice(int firstRow, int lastRow, int firstColumn, int lastColumn) {
		return this.rows(firstRow, lastRow).columns(firstColumn, lastColumn);	
	}
	
	//Dichen passsed
	public Layout replace(Layout layout, int row, int column) {
		if (row > this.rowCount() || row < 0) {
			throw new IllegalArgumentException("Rows out of bond");
		} else if (column > this.columnCount() || column < 0) {
			throw new IllegalArgumentException("Columns out of bond");	
		} else if (row + layout.rowCount() > this.rowCount() || column + layout.columnCount() > this.columnCount()) {
			throw new IllegalArgumentException("The parameter layout goes beyond the bounds of the recipient layout");
		}

		int[][] array = layout.toArray2D();  // input layout array
		int[][] newArray = this.toArray2D(); // array to be exported
		for (int i = 0; i < layout.rowCount(); i++) { //copy each row
			System.arraycopy(array[i], 0, newArray[i + row], column, layout.columnCount());
		} 
		return new Layout(newArray);
	}
	
	
	//Selah
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Layout)){
			return false;
		}
		Layout l2 = (Layout)o;
		if(data.length != l2.data.length){
			return false;
		}
		//at this point we assume that array[0] exists
		if(data[0].length != l2.data[0].length){
			return false;
		}
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[0].length; j++){
				//and every value in those arrays.				
				if(data[i][j] != l2.data[i][j]){
					return false;
				}
			}
		}

		return true;
	}

	//Selah
	@Override
	public int hashCode(){
		return Arrays.deepHashCode(data);
	}

	//Dichen, requires unravel()
	public int[] toArray1D() {
		if (this.rowCount() <= 0) {
			return null;
		} //just in case
		
		else if (this.rowCount() > 1) {
			return this.unravel().toArray1D();
		} else {
			int[] array1D = new int[this.columnCount()];
			System.arraycopy( data, 0, array1D, 0, columnCount());
			return array1D;
		}
	}
	
	//Dichen, passed!
	public int[][] toArray2D() {
		int[][] array = new int[rowCount()][columnCount()];
		for (int i = 0; i < rowCount(); i++) {
			System.arraycopy(data[i], 0, array[i], 0, columnCount());
		}
		return array;
	}
	
	//Dichen, passed!
	public int at(int row, int column) {
		return data[row][column];
	}

}