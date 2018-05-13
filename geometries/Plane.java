package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Plane extends Geometry implements FlatGeometry{
	Vector vertiacl;
	Point3D p;
	// ***************** Constructors ********************** // 
	public Plane(Color color, Vector vertiacl, Point3D p) {
		super(color);
		this.vertiacl = vertiacl;
		this.p = p;
	}
	
	public Plane(Color color, Material _material, Vector vertiacl, Point3D p) {
		super(color, _material);
		this.vertiacl = vertiacl;
		this.p = p;
	}

	public Plane() {
		super();
		this.vertiacl = new Vector(1,0,0);
		this.p = new Point3D();
	}
	public Plane(Plane p) {
		super(p.getColor());
		this.vertiacl = new Vector(p.getVertiacl());
		this.p = new Point3D(p.getP());
	}
	// ***************** Getters/Setters ********************** // 
	public Vector getVertiacl() {
		return vertiacl;
	}

	public void setVertiacl(Vector vertiacl) {
		this.vertiacl = vertiacl;
	}

	public Point3D getP() {
		return p;
	}

	public void setP(Point3D p) {
		this.p = p;
	}
	// ***************** Administration  ******************** // 
	@Override
	public Vector getNormal(Point3D p) {
		return vertiacl.normalize();
	}
	@Override
	public boolean equals(Object arg) {
		if(!super.equals(arg))
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Plane p = (Plane)arg;
		if (this.vertiacl.equals(p.getVertiacl()) && this.p.equals(p.getP()))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString()+" Point p: "+this.p+" Vertical: "+this.vertiacl;
	}
	
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) 
	{
	 ArrayList<Point3D> Intersections = new ArrayList<Point3D>();
	 Vector V = ray.getDirection().normalize();
	 Vector _N = vertiacl.scale(-1);
	 Point3D temp = ray.getPOO().subtract(p); 
	 double scaler = vertiacl.dotProduct(V);
	 if (scaler == 0)
		 return Intersections;
	 double t = _N.dotProduct(new Vector(temp).scale(1/scaler));
	 Intersections.add(new Point3D(ray.getPOO().add(V.scale(t).getHead())));
	 return Intersections;	 
	}
	

}
