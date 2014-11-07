package cit591_hw10;

import java.util.Arrays;

public class Layout {
	
	final public int[][] data;
	
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
	
	public Layout reverse() {
		return null;
	}
	public Layout rotateRight() {
		return null;		
	}

	public Layout rotateLeft() {
		return null;		
	}
	public Layout transpose() {
		return null;		
	}
	public Layout ravel(int n) {
		return null;		
	}
	public Layout unravel() {
		return null;		
	}
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
		return null;		
	}
	public int columnCount(){
		return null;		
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
		return null;
	}

}