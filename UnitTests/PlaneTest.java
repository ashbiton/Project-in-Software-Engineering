package UnitTests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import geometries.*;

import primitives.*;

public class PlaneTest {
	@Test
	public void getNormal()
	{
		Plane p=new Plane();
		Vector v= p.getVertiacl();
		Vector v1=p.getNormal(new Point3D(1,2,3));
		assertEquals(v1,v);
	}
	@Test
	public void IntersectionTest(){
		Plane p=new Plane(new Color(1),new Vector(0,0,1),new Point3D(0,0,-200));
		Ray ray = new Ray (new Point3D(0,0,0),new Vector(0,0,-1));
		ArrayList <Point3D> temp  = new ArrayList <Point3D>();
		temp.add(new Point3D(0,0,-200));
		assertEquals(p.findIntersections(ray),temp);
		
		double h = Math.pow(3, -0.5);
		Ray ray1 =new Ray(new Point3D(0,0,0),new Vector(h,-h,-h));
		ArrayList <Point3D> temp1  = new ArrayList <Point3D>();
		temp1.add(new Point3D(200.00001458028976,-200.00001458028976,-200.00001458028976));
		assertEquals(p.findIntersections(ray1),temp1);
		
		Ray ray2 =new Ray(new Point3D(0,0,0),new Vector(1,0,0));
		assertEquals(p.findIntersections(ray2).isEmpty(),true);
	}
}
