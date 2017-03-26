package triangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class randyTest {

	randy ran = new randy();;
	
	@Test
	public void testscalene() {
		assertEquals((int)0,ran.judgetriangle(3,4,5));
	}
	
	@Test
	public void testequilateral() {
		assertEquals((int)1,ran.judgetriangle(3,5,5));
	}
	
	@Test
	public void testisosceles() {
		assertEquals((int)3,ran.judgetriangle(3,3,3));
	}
	
	@Test
	public void testnot_triangle() {
		assertEquals((int)4,ran.judgetriangle(3,2,1));
	}

}
