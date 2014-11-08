package cit591_hw10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LayoutTest {
	
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
		l2DEmpty = new Layout(array1DEmpty);
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
		assertEquals(array2D, layout.data);
	}

	@Test
	public void testLayoutIntArray() {
		layout = new Layout(array1D);
		assertEquals(1, layout.data.length);
		assertEquals(array1D, layout.data[0]);
	}

	@Test
	public void testLayoutInt() {
		layout = new Layout(3);
		assertEquals(1, layout.data.length);
		for (int i = 0; i < 3; i++){
			assertEquals(i + 1, layout.data[0][i]);
		}
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
		fail("Not yet implemented");
	}

	@Test
	public void testUnravel() {
		fail("Not yet implemented");
	}

	@Test
	public void testReshape() {
		fail("Not yet implemented");
	}

	@Test
	public void testJoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testStack() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testColumns() {
		fail("Not yet implemented");
	}

	@Test
	public void testSlice() {
		fail("Not yet implemented");
	}

	@Test
	public void testReplace() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testToArray2D() {
		fail("Not yet implemented");
	}

	@Test
	public void testAt() {
		fail("Not yet implemented");
	}

}
