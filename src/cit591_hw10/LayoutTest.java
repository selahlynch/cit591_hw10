package cit591_hw10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LayoutTest {
	int[][] array2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	int[] array1D = {1, 2, 3};
	Layout layout;
	
	@Before
	public void setUp() throws Exception {
		layout = new Layout(array2D);
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
		fail("Not yet implemented");
	}

	@Test
	public void testRotateRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotateLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testTranspose() {
		fail("Not yet implemented");
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
	}

	@Test
	public void testColumnCount() {
		assertEquals(3 , layout.columnCount());
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
		int[] array1 = {1,2,6};
		Layout l1 = new Layout(array1);
		int[] array2 = {1,2,6};
		Layout l2 = new Layout(array2);
		assertEquals(l1,l2);
		assertTrue(l1.equals(l2));
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
