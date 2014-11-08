package cit591_hw10;

import java.util.Arrays;

public class Layout {
	
	final int[][] data;
	
	public Layout(int[][] array){
		data = array;
	}
	
	public Layout(int[] array){
		data = new int[1][];
		data[0] = array;
	}
	
	public Layout(int length){
		int[] array = new int[length];
		for(int i=0; i<length; i++){
			array[i] = i+1;
		}
		data = new int[1][];
		data[0] = array;
	}
	
	public void print(){
		int rows = rowCount();
		int columns = columnCount();
		for(int i=0; i<rows; i++){		
			for(int j=0; j<columns; j++){
				System.out.printf("%d ", data[i][j]);
			}
			System.out.print("\n");
		}
	}
	
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

	public Layout rotateRight() {
		//lol
		return rotateLeft().rotateLeft().rotateLeft();
	}

	
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

	//selah
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
			return null;	
	}
	
	//selah
	public Layout unravel() {
		return null;		
	}
	
	//selah
	public Layout reshape(int n) {
		return null;		
	}
	public Layout join(Layout layout) {
		return null;		
	}
	public Layout stack(Layout layout) {
		return null;		
	}
	public int rowCount() {
		return data.length;		
	}
	public int columnCount(){
		return data[0].length;		
	}
	public Layout rows(int firstRow, int lastRow) {
		return null;	
	}
	public Layout columns(int firstColumn, int lastColumn) {
		return null;	
	}
	public Layout slice(int firstRow, int lastRow, int firstColumn, int lastColumn) {
		return null;	
	}
	public Layout replace(Layout layout, int row, int column) {
		return null;
	}
	
	
	
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

	@Override
	public int hashCode(){
		return Arrays.deepHashCode(data);
	}

	
	
	public int[] toArray1D() {
		return null;
	}
	public int[][] toArray2D() {
		return null;
	}
	
	public int at(int row, int column) {
		return -1;
	}

}