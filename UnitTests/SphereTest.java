package UnitTests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import primitives.*;
import geometries.*;

public class SphereTest {
	@Test
	public void getNormalTest()
	{
		Sphere s = new Sphere(new Color(1,0,0),4,new Point3D(2,8,2));
		Vector v = s.getNormal(new Point3D(-1,2,0));
		assertEquals(v,new Vector(-3/7d,-6/7d,-2/7d));
		Vector v1 = s.getNormal(new Point3D(6,4,0));
		assertEquals(v1,new Vector(4/6d,-4/6d,-1/3d));
	}
	@Test
	public void IntersectionTest(){
		Sphere s = new Sphere(new Color(1,0,0),200,new Point3D(0,0,-400));
		double h = Math.pow(3, -0.5);
		Ray ray =new Ray(new Point3D(0,0,0),new Vector(h,-h,-h));
		ArrayList<Point3D> intersections = s.findIntersections(ray);
		assertEquals(intersections.isEmpty(),true);
		
		Ray ray1 =new Ray(new Point3D(0,0,0),new Vector(0,0,-1));
		ArrayList<Point3D> intersections1 = s.findIntersections(ray1);
		ArrayList<Point3D> temp = new ArrayList<Point3D>();
		temp.add(new Point3D(0,0,-200));
		temp.add(new Point3D(0,0,-600));
		assertEquals(intersections1,temp);
	}
}
