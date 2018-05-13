package primitives;
import java.awt.Color;

import geometries.*;
public class Main {

	public static void main(String[] args) {
	Coordinate c = new Coordinate(5.25);
	Coordinate c1 = new Coordinate(6.05);
	Coordinate c2 = new Coordinate(9.75);
	System.out.println("Testing for Coordinate: ");
	System.out.println("c: " + c);
	System.out.println("c1: " + c1);
	System.out.println("c2: " + c2);
	System.out.println("c + c1 = " + c.add(c1));
	System.out.println("c2 + c1 = " + c2.add(c1));
	System.out.println("c2 - c = " + c2.subtract(c));
	
	System.out.println();
	
	System.out.println("Testing for Point3D: ");
	Point3D p = new Point3D (c,c1,c2);
	System.out.println("p: " + p);
	Point3D p1 = new Point3D (p);
	System.out.println("p1: " + p1);
	Point3D p2 = new Point3D(2,3,6);
	System.out.println("p2: " + p2);
	System.out.println("distance between p and p2: " + p.distance(p2));
	System.out.println("distance between p and p1: " + p.distance(p1));
	System.out.println("p1 equal p? " + p1.equals(p));
	System.out.println("p1 + p2 = " + p1.add(p2));
	System.out.println("p - p2 = " + p.subtract(p2));
	System.out.println("p1 dotProduct p2: " + p1.dotProduct(p2));
	System.out.println("p1 equal p2? " + p1.equals(p2));

	System.out.println();
	
	System.out.println("Testing for Vector: ");
	Vector v = new Vector (p2);
	Vector v1 = new Vector (new Point3D(6,5,-8));
	Vector v2 = new Vector ();
	System.out.println("v: " + v);
	System.out.println("v1: " + v1);
	System.out.println("v2: " + v2);
	System.out.println("v2 + v1 = " + v2.add(v1));
	System.out.println("v2 - v = " + v2.subtract(v));
	System.out.println("v1 dotProduct v: " + v1.dotProduct(v));
	System.out.println("v1 crossProduct v: " + v1.crossProduct(v));
	System.out.println("length of v: " + v.length());
	System.out.println("v normalized: " + v.normalize());
	System.out.println("v1 equal v2? " + v1.equals(v2));
	Vector v3 = new Vector (v1);
	System.out.println("v3: " + v3);
	System.out.println("v3 equal v1? " + v3.equals(v1));
	

	System.out.println();
	
	System.out.println("Testing for getNormal: ");
	Sphere s = new Sphere(Color.CYAN,4.0,new Point3D(0,0,0));
	System.out.println(s.getNormal(new Point3D(1,1,1)));
	
	Triangle t = new Triangle(Color.CYAN,new Point3D(0,0,0),new Point3D(1,1,1), p2 );
	System.out.println(t.getNormal(p1));
	
	Plane pl = new Plane(Color.CYAN,new Vector(new Point3D(3,4,5)) ,new Point3D(0,0,0) );
	System.out.println(pl.getNormal(p1));
	}

}
