package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Triangle extends Geometry implements FlatGeometry{
	private Point3D x;
	private Point3D y;
	private Point3D z; 
	// ***************** Constructors ********************** // 
	public Triangle() {
		super();
		this.x = new Point3D();
		this.y = new Point3D();
		this.z = new Point3D();
	}
	public Triangle(Color color, Point3D x, Point3D y, Point3D z) {
		super(color);
		this.x = new Point3D(x);
		this.y = new Point3D(y);
		this.z = new Point3D(z);
	}
	
	public Triangle(Color color, Material _material, Point3D x, Point3D y,
			Point3D z) {
		super(color, _material);
		this.x = new Point3D(x);
		this.y = new Point3D(y);
		this.z = new Point3D(z);
	}
	public Triangle(Triangle T) {
		super(T.getColor());
		this.x = new Point3D(T.getX());
		this.y = new Point3D(T.getY());
		this.z = new Point3D(T.getZ());
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getX() {
		return x;
	}

	public void setX(Point3D x) {
		this.x = x;
	}

	public Point3D getY() {
		return y;
	}

	public void setY(Point3D y) {
		this.y = y;
	}

	public Point3D getZ() {
		return z;
	}

	public void setZ(Point3D z) {
		this.z = z;
	}
	// ***************** Administration  ******************** // 
	@Override
	public Vector getNormal(Point3D p) {
		Vector v1 = new Vector(x.subtract(z));
		Vector v2 = new Vector(y.subtract(z));
		return v1.crossProduct(v2).normalize();
	}
	@Override
	public boolean equals(Object arg) {
		if (arg.getClass() != this.getClass())
			return false;
		Triangle t = (Triangle)arg;
		return x.equals(t.getX()) && y.equals(t.getY()) && z.equals(t.getZ()) && super.equals(arg);
	}
	@Override
	public String toString() {
		return "Triangle: X:[" + x + "] , Y:[" + y + "] , Z:[" + z+ "] " + super.toString();
	}
	// ***************** Operations ******************** // 
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray)
	{		
		Vector nr1=new Vector (x.subtract(y));
		Vector nr2=new Vector (x.subtract(z));
		Vector Normal=new Vector (nr1.crossProduct(nr2));		
		Plane pl=new Plane(super.getColor(),Normal.normalize(), x);
		
		ArrayList<Point3D> tempIntersection= pl.findIntersections(ray);
		ArrayList<Point3D> Intersections = new ArrayList<Point3D>();
		
		if(tempIntersection.isEmpty())
			return Intersections;
		
		Vector v1 = new Vector (x.subtract(ray.getPOO()));
		Vector v2 = new Vector (y.subtract(ray.getPOO()));
		Vector v3 = new Vector (z.subtract(ray.getPOO()));
		Vector N1 = new Vector(v2.crossProduct(v1).normalize());
		Vector N2 = new Vector(v3.crossProduct(v2).normalize());
		Vector N3 = new Vector(v1.crossProduct(v3).normalize());
		for (int i =0; i<tempIntersection.size(); i++ )
		{
			Point3D p_tmp = tempIntersection.get(i);
			Vector v = new Vector(p_tmp.subtract(ray.getPOO()));

			double s1 = v.dotProduct(N1);
			double s2 = v.dotProduct(N2);
			double s3 = v.dotProduct(N3);
			
			if (Math.signum(s2)==Math.signum(s3)&&Math.signum(s1)==Math.signum(s3)&& Math.signum(s2)!=0)
				Intersections.add(p_tmp);
		/*	if (s1>0 && s2>0 && s3>0)
				Intersections.add(p_tmp);
			if (s1<0 && s2 <0 && s3<0)
				Intersections.add(p_tmp);*/
		}
		return Intersections;			
	}
	

}
