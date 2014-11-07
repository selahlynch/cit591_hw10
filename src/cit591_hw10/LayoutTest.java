package cit591_hw10;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LayoutTest {

	@Before
	public void setUp() throws Exception {
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
		fail("Not yet implemented");
	}

	@Test
	public void testLayoutIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testLayoutInt() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	public void testColumnCount() {
		fail("Not yet implemented");
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
