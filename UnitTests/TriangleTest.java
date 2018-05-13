package UnitTests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import geometries.*;
import primitives.*;

public class TriangleTest
{
	@Test
	public void getNormalTests(){
	
	Triangle T=new Triangle(new Color(0), new Point3D(0,0,0), new Point3D(1,0,1), new Point3D(1,0,0) );
	Vector v1 = T.getNormal( new Point3D(0,0,0));
	assertEquals(v1,new Vector(0,1,0));
	}
	@Test
	public void IntersectionTest(){
		Triangle t =new Triangle(new Color(0), new Point3D(100,-100,-200), new Point3D(-100,-100,-200), new Point3D(0,100,-200));
		double h = Math.pow(3, -0.5);
		Ray ray =new Ray(new Point3D(0,0,0),new Vector(h,-h,-h));
		ArrayList<Point3D> intersections = t.findIntersections(ray);
		assertEquals(intersections.isEmpty(),true);
		
		Ray ray1 =new Ray(new Point3D(0,0,0),new Vector(0,0,-1));
		ArrayList<Point3D> intersections1 = t.findIntersections(ray1);
		ArrayList<Point3D> temp = new ArrayList<Point3D>();
		temp.add(new Point3D(0,0,-200));
		assertEquals(intersections1,temp);
		
		Ray ray2 =new Ray(new Point3D(0,0,0),new Vector(2,-2,-5));
		ArrayList<Point3D> intersections2 = t.findIntersections(ray2);
		ArrayList<Point3D> temp2 = new ArrayList<Point3D>();
		temp2.add(new Point3D(80.00000369670303,-80.00000369670303,-200.00000924175754));
		assertEquals(intersections2,temp2);
		
		
	}
}