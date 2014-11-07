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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
