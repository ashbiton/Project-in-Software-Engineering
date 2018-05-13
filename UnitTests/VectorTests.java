package UnitTests;

import static org.junit.Assert.*;
import primitives.*;

import org.junit.Test;

public class VectorTests {

	@Test
	public void addTest() {
		Vector v = new Vector (1,2,3);
		Vector v1 = new Vector (3,5,6);
		Vector result = v.add(v1);
		assertEquals(result,new Vector (4,7,9));
		
		Vector v2 = new Vector ();
		Vector v3 = new Vector (3,5,6);
		result = v2.add(v3);
		assertEquals(result,new Vector (3,5,6));
	}
	@Test
	public void subtractTest(){
		Vector v = new Vector (1,2,3);
		Vector v1 = new Vector (3,5,6);
		Vector result = v.subtract(v1);
		assertEquals(result,new Vector (-2,-3,-3));
		Vector v2 = new Vector ();
		Vector v3 = new Vector (3,5,6);
		result = v3.subtract(v2);
		assertEquals(result,new Vector (3,5,6));
	}
	@Test
	public void normalizeTest(){
		Vector v = new Vector (1,0,0);
		assertEquals(v.normalize(),new Vector (1,0,0));
		Vector v1 = new Vector (2,4,4);
		assertEquals(v1.normalize(),new Vector (1/3d,2/3d,2/3d));
	}
	@Test
	public void dotProudctTest(){
		Vector v1 = new Vector (2,0,4);
		Vector v2 = new Vector (5,6,-7);
		assertEquals(v1.dotProduct(v2),-18d,0);
		Vector v3 = new Vector (0,0,0);
		assertEquals(v2.dotProduct(v3),0,0);
	}
	@Test
	public void crossProudctTest(){
		Vector v1 = new Vector (2,0,4);
		Vector v2 = new Vector (5,6,-7);
		assertEquals(v1.crossProduct(v2), new Vector(-24,34,12));
		Vector v3 = new Vector (1,0,0);
		Vector v4 = new Vector (0,1,0);
		assertEquals(v3.crossProduct(v4), new Vector(0,0,1));		
	}
	@Test
	public void leangthTest()
	{
		Vector v1 = new Vector (2,0,4);
		assertEquals(v1.length(),Math.sqrt(20),0);
		Vector v2 = new Vector (5,6,-7);
		assertEquals(v2.length(),Math.sqrt(110),0);
		Vector v3 = new Vector (1,0,0);
		assertEquals(v3.length(),1d,0);
	}
	@Test
	public void scaleTest()
	{
		Vector v1 = new Vector (2,3,-4);
		assertEquals(v1.scale(-5),new Vector(-10,-15,20));
		Vector v2 = new Vector (5,6,-7);
		assertEquals(v2.scale(10),new Vector(50,60,-70));
	}
	
}
