package cit591_hw10;

import static org.junit.Assert.*;

import javax.xml.crypto.Data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

public class LayoutTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	int[][] array2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	int[] array1D = {1, 2, 3};
	int[][] array2DEmpty = {{}, {}};
	int[] array1DEmpty = {};
	
	Layout layout;
	Layout l1D;
	Layout l2DEmpty;
	Layout l1DEmpty;
	
	@Before
	public void setUp() throws Exception {
		layout = new Layout(array2D);
		l1D = new Layout(array1D);
		l2DEmpty = new Layout(array2DEmpty);
		l1DEmpty = new Layout(array1DEmpty);
	}

	@Test
	public void testHashCode() {
		int[] array = {1,2,6};
		Layout l = new Layout(array);
		int[] array2 = {1,2,6};
		Layout l2 = new Layout(array2);
		assertEquals(l.hashCode(), l.hashCode());
	}

	@Test
	public void testLayoutIntArrayArray() {
		layout = new Layout(array2D);
		assertArrayEquals(array2D, layout.data);
		l2DEmpty = new Layout(array2DEmpty);
		assertArrayEquals(array1DEmpty, l2DEmpty.data[0]);
		assertEquals(2, l2DEmpty.data.length);
	}

	@Test
	public void testLayoutIntArray() {
		layout = new Layout(array1D);
		assertEquals(1, layout.data.length);
		assertEquals(array1D, layout.data[0]);
		l1DEmpty = new Layout(array1DEmpty);
		assertEquals(1, l1DEmpty.data.length);
		assertArrayEquals(array1DEmpty, l1DEmpty.data[0]);
	}

	@Test
	public void testLayoutInt() {
		layout = new Layout(3);
		assertEquals(1, layout.data.length);
		for (int i = 0; i < 3; i++) {
			assertEquals(i + 1, layout.data[0][i]);
		}
		
		//when input is 0, special case
		layout = new Layout(0);
		assertArrayEquals(array1DEmpty, layout.data[0]);
	}


	@Test
	public void testReverse() {
		int[][] arrayf = {{1,2,6},{1,6,9}};
		int[][] arrayr = {{6,2,1},{9,6,1}};
		Layout lf = new Layout(arrayf);
		Layout lr = new Layout(arrayr);
		assertTrue(lr.equals(lf.reverse()));
		assertEquals(lr, lf.reverse());
	}

	@Test
	public void testRotateRight() {
		
		int[][] array = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
		};

		int[][] rotatedArray = {
			{9,5,1},
			{10,6,2},
			{11,7,3},
			{12,8,4}	
		};
		Layout l = new Layout(array);
		Layout lRotated = new Layout(rotatedArray);
		
		assertEquals(lRotated, l.rotateRight());
	}

	@Test
	public void testRotateLeft() {

		int[][] array = {
			{9,5,1},
			{10,6,2},
			{11,7,3},
			{12,8,4}	
		};

		int[][] rotatedArray = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
		};
		
		Layout l = new Layout(array);
		Layout lRotated = new Layout(rotatedArray);
		
		assertEquals(lRotated, l.rotateLeft());

	}

	@Test
	public void testTranspose() {
		int[][] array = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
		};

		int[][] transposedArray = {
			{1,5,9},
			{2,6,10},
			{3,7,11},
			{4,8,12}	
		};
		
		Layout l = new Layout(array);
		Layout lTransposed = new Layout(transposedArray);

		assertEquals(lTransposed, l.transpose());

	}

	@Test
	public void testRavel() {
		int[][] array = {{1,2,3,4,5,6,7,8,9,10,11,12}};
		int[][] ravelledArray = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		Layout l = new Layout(array);
		Layout lRavelled = new Layout(ravelledArray);

		assertEquals(lRavelled, l.ravel(4));
	}
	
	@Test
	public void testRavelException1(){
		int[][] array2d = {
				{1,2,3,4,5,6},
				{7,8,9,10,11,12}
		};
		Layout l2d = new Layout(array2d);
		exception.expect(IllegalArgumentException.class);
		l2d.ravel(3);
	}
	
	@Test
	public void testRavelException2(){
		int[][] array = {{1,2,3,4,5,6,7,8,9,10,11,12}};		
		Layout l = new Layout(array);
		exception.expect(IllegalArgumentException.class);
		l.ravel(7);
	}

	@Test
	public void testUnravel() {
		int[][] array = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		int[][] unravelledArray = {{1,2,3,4,5,6,7,8,9,10,11,12}};
		Layout l = new Layout(array);
		Layout lUnravelled = new Layout(unravelledArray);

		lUnravelled.print();
		l.unravel().print();

		assertEquals(lUnravelled, l.unravel());
	}

	@Test
	public void testReshape() {
		int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 11, 12}};
		int[][] array2 = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 0, 11, 12}};
		int[][] array3 = {{1}, {2}, {3}};
		Layout l2D = new Layout(array);
		assertEquals(l2D.reshape(6), new Layout(array2));
		assertEquals(l1D.reshape(1), new Layout(array3));
		assertEquals(l2DEmpty.reshape(1), l1DEmpty); 
		//{{}, {}} reshape to {{}}, not sure whether we should consider this extreme case or not!
		
		//test exception
		exception.expect(IllegalArgumentException.class);
		layout.reshape(4);
		layout.reshape(0);
	}

	@Test
	public void testJoin() {
		int[][] array2 = {{3}, {3}, {3}};
		int[][] array3 = {{1, 2, 3, 3}, {4, 5, 6, 3}, {7, 8, 9, 3}};
		Layout layout2 = new Layout(array2);
		Layout layout3 = layout.join(layout2);
		assertArrayEquals(layout3.data, array3);
		
		//when join empty array with another empty one, result should still be empty
		Layout layoutEmpty = new Layout(array1DEmpty);
		Layout joinEmpty = l1DEmpty.join(layoutEmpty);
		assertEquals(1, joinEmpty.data.length);
		assertArrayEquals(joinEmpty.data[0], array1DEmpty);
		
		//two arrays have different rows
		//There are three ways to test expected exception, see: 
		//http://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
		//The first way and best
		exception.expect(IllegalArgumentException.class);
		Layout layout1Row = new Layout(3); //layout1Row = {{1, 2, 3}}
		layout.join(layout1Row); //layout has 3 rows, there should be assertion error
	}

	//The second way to test expected exception
	@Test(expected=IllegalArgumentException.class)
	public void testJoinException2() {
		Layout layout1Row = new Layout(3); //layout1Row = {{1, 2, 3}}
		//layout has 3 rows, there should be assertion error
		layout.join(layout1Row);
	}
	
	//The third way to test expected exception 
	//http://www.javacodegeeks.com/2013/11/3-ways-of-handling-exceptions-in-junit-which-one-to-choose.html
	@Test
	public void testJoinException3() {
		Layout layout1Row = new Layout(3); //layout1Row = {{1, 2, 3}}
		try {
			layout.join(layout1Row);
			fail("IllegalArgumentException missing!");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "The row numbers are different!");
		}
	}
	
	@Test
	public void testStack() {
		int[][] array2 = {{10, 11, 12}};
		int[][] array3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		Layout layout2 = new Layout(array2);
		Layout layout3 = layout.stack(layout2);
		assertArrayEquals(layout3.data, array3);
		
		//when stack empty array with another empty one, result should be {{}, {}}
		Layout layoutEmpty = new Layout(array1DEmpty);
		Layout joinEmpty = l1DEmpty.stack(layoutEmpty);
		int[][] stackArray = {{}, {}};
		assertArrayEquals(joinEmpty.data, stackArray);
		
		//when two arrays have different columns
		exception.expect(IllegalArgumentException.class);
		int[][] array1Col = {{1}, {2}, {3}};
		Layout layout1Col = new Layout(array1Col); //layout1Row = {{1, 2, 3}}
		layout.stack(layout1Col); //layout has 3 cols, there should be assertion error
	}

	@Test
	public void testRowCount() {
		assertEquals(3 , layout.rowCount());
		assertEquals(1, l1D.rowCount());
		assertEquals(2, l2DEmpty.rowCount());
		assertEquals(1, l1DEmpty.rowCount());
	}


	@Test
	public void testColumnCount() {
		assertEquals(3, layout.columnCount());
		assertEquals(3, l1D.columnCount());
		assertEquals(0, l2DEmpty.columnCount());
		assertEquals(0, l1DEmpty.columnCount());
	}

	@Test
	public void testRows() {
		int[][] a1 = {{4, 5, 6}, {7, 8, 9}};
		assertEquals(new Layout(a1), layout.rows(1, 2));
		assertEquals(l1D, layout.rows(0, 0));
		assertEquals(l1DEmpty, l2DEmpty.rows(1, 1));
		
		//error assertions
		exception.expect(IllegalArgumentException.class);
		layout.rows(2, 1);
		layout.rows(-1, 1);
		layout.rows(3, 4);
		layout.rows(1, 4);
	}

	@Test
	public void testColumns() {
		int[][] a1 = {{2, 3}, {5, 6}, {8, 9}};
		int[][] a2 = {{1}, {4}, {7}};
		assertEquals(new Layout(a1), layout.columns(1, 2));
		assertEquals(new Layout(a2), layout.columns(0, 0));
		
		//error assertions
		exception.expect(IllegalArgumentException.class);
		layout.columns(2, 1);
		layout.columns(-1, 1);
		layout.columns(3, 4);
		layout.columns(1, 4);
	}

	@Test
	public void testSlice() {
		int[][] a1 = {{5, 6}, {8, 9}};
		int[][] a2 = {{1}};
		assertEquals(new Layout(a1), layout.slice(1, 2, 1, 2));
		assertEquals(new Layout(a2), layout.slice(0, 0, 0, 0));
		
		//error assertions
		exception.expect(IllegalArgumentException.class);
		layout.slice(2, 1, 2, 1);
		layout.slice(-1, 1, -1, 1);
		layout.slice(3, 4, 3, 4);
		layout.slice(1, 4, 1, 4);
	}

	@Test
	public void testReplace() {
		int[][] a1 = {{2, 2}, {2, 2}};
		int[][] a2 = {{1, 2, 3}, {4, 2, 2}, {7, 2, 2}};
		int[][] a3 = {{9}};
		int[][] a4 = {{0}};
		assertEquals(new Layout(a2), layout.replace(new Layout(a1), 1, 1));
		assertEquals(new Layout(a4), (new Layout(a3)).replace(new Layout(a4), 0, 0));
		
		//error assertions
		exception.expect(IllegalArgumentException.class);
		assertEquals(new Layout(a2), layout.replace(new Layout(a1), 1, 2));
		assertEquals(new Layout(a2), layout.replace(new Layout(a1), -1, 1));
		assertEquals(new Layout(a2), layout.replace(new Layout(a1), 1, 3));
	}

	@Test
	public void testEqualsObject() {
		int[] array1 = {1,2,6,7};
		Layout l1 = new Layout(array1);
		int[] array2 = {1,2,6,7};
		Layout l2 = new Layout(array2);
		int[][] array3 = {{1,2,6},{1,6,9}};
		Layout l3 = new Layout(array3);
		assertEquals(l1,l2);
		//assertEquals(l1,l3); //this should NOT work
		assertTrue(l1.equals(l2));
		assertFalse(l1.equals(l3));
		//assertTrue(l1==l2); //not supposed to work, only for references
	}

	@Test
	public void testToArray1D() {
		int[] layoutTo1D = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		assertArrayEquals(layoutTo1D, layout.toArray1D());
		assertArrayEquals(array1D, l1D.toArray1D()); 
		assertArrayEquals(array1DEmpty, l1DEmpty.toArray1D());
		assertArrayEquals(array1DEmpty, l2DEmpty.toArray1D());
	}

	@Test
	public void testToArray2D() {
		assertArrayEquals(layout.toArray2D(), array2D);
		//when it's empty layout
		int[][] arrayEmpty = {{}};
		assertArrayEquals(l1DEmpty.toArray2D(), arrayEmpty);
	}

	@Test
	public void testAt() {
		assertEquals(1, layout.at(0, 0));
		exception.expect(ArrayIndexOutOfBoundsException.class);
		l1DEmpty.at(0, 0); // l1DEmpty == {{}};
	}

}
