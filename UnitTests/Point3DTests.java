package UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import primitives.*;

public class Point3DTests {
	@Test
	public void addTest()
	{
		Point3D p1 = new Point3D (1,2,3); 
		Point3D p2 = new Point3D (0,4,-8);
		assertEquals(p1.add(p2),new Point3D(1,6,-5));
		Point3D p3 = new Point3D (0,0,0);
		assertEquals(p1.add(p3),new Point3D(1,2,3));
	}
	@Test
	public void distanceTest()
	{
		Point3D p = new Point3D (7,6,8);
		double dis = p.distance(new Point3D(5,2,4));
		assertEquals(dis,6d,0);
		Point3D p1 = new Point3D (5,6,4);
		double dis1 = p1.distance(new Point3D(5,-2,-2));
		assertEquals(dis1,10d,0);
	}
	@Test
	public void dotProudctTest()
	{
		Point3D p = new Point3D (7,6,8);
		Point3D p1 = new Point3D (5,-2,-2);
		assertEquals(p.dotProduct(p1),7d,0);
		Point3D p2 = new Point3D (5,-6,0);
		assertEquals(p.dotProduct(p2),-1d,0);
	}
	@Test
	public void subtractTest()
	{
		Point3D p = new Point3D (7,6,8);
		Point3D p1 = new Point3D (5,-2,-2);
		Point3D p2 = new Point3D (5,-6,0);
		assertEquals(p1.subtract(p2),new Point3D(0,4,-2));
		assertEquals(p.subtract(p1),new Point3D(2,8,10));
		assertEquals(p2.subtract(p2),new Point3D(0,0,0));
	}
}
