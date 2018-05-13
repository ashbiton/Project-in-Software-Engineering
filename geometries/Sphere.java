package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Sphere extends RadialGeometry {
	private Point3D center; 

	// ***************** Constructors ********************** // 	
	public Sphere(Color c ,double r ,Point3D center) {
		super(c,r);
		this.center = center;
	}
	
	public Sphere(Color color, Material _material, double radius, Point3D center) {
		super(color, _material, radius);
		this.center = center;
	}

	public Sphere() {
		super();
		this.center = new Point3D();
	}
	public Sphere(Sphere s) {
		super(s.getColor(),s.getRadius());
		this.center = new Point3D(s.getCenter());
		this.setRadius(s.getRadius());
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getCenter() {
		return center;
	}

	public void setCenter(Point3D center) {
		this.center = center;
	}
	// ***************** Administration  ******************** // 
	@Override
	public Vector getNormal(Point3D p) {
		Vector v=new Vector(p.subtract(center));
		return v.normalize();
	}

	@Override
	public boolean equals(Object arg) {
		if (!super.equals(arg))
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Sphere s = (Sphere)arg;
		if (!s.getCenter().equals(this.center))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+" Center: "+ this.center.toString();
	}
	
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) {
		ArrayList<Point3D> Intersections = new ArrayList<Point3D>();
		Vector V = ray.getDirection().normalize();
		Vector L = new Vector (center.subtract(ray.getPOO()));
		double tm = L.dotProduct(V);
		double d = Math.sqrt((Math.pow(L.length(),2)- Math.pow(tm, 2)));
		if (d > getRadius())
			return Intersections;
		double th = Math.pow(Math.pow(getRadius(), 2)- Math.pow(d, 2),0.5);
		double t1 = tm - th;
		double t2 = tm + th;
		if (t1 >0)
			Intersections.add(new Point3D(ray.getPOO().add(V.scale(t1).getHead())));
		if (t2 >0)
			Intersections.add(new Point3D(ray.getPOO().add(V.scale(t2).getHead())));
		return Intersections;
	}
	



}
