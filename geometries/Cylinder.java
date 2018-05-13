package geometries;

import java.util.ArrayList;

import primitives.*;

public class Cylinder extends RadialGeometry {

	private Point3D axisCenter;
	private Vector axisDirection;
	// ***************** Constructors ********************** // 
	public Cylinder(double r ,Point3D axisCenter, Vector axisDirection) {
		super();
		this.setRadius(r);
		this.axisCenter = axisCenter;
		this.axisDirection = axisDirection;
	}
	public Cylinder() {
		super();
		this.axisCenter = new Point3D();
		this.axisDirection = new Vector();
	}
	public Cylinder (Cylinder c){
		this.setRadius(c.getRadius());
		this.axisCenter = new Point3D(c.getAxisCenter());
		this.axisDirection = new Vector(c.getAxisDirection());
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getAxisCenter() {
		return axisCenter;
	}
	public void setAxisCenter(Point3D axisCenter) {
		this.axisCenter = axisCenter;
	}
	public Vector getAxisDirection() {
		return axisDirection;
	}
	public void setAxisDirection(Vector axisDirection) {
		this.axisDirection = axisDirection;
	}
	// ***************** Administration  ******************** // 
	@Override
	public Vector getNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean equals(Object arg) {
		if (!super.equals(arg))
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Cylinder c = (Cylinder)arg;
		if (this.getAxisCenter().equals(c.axisCenter) && this.axisDirection.equals(c.getAxisDirection()))
			return true;
		return false;
	}
	@Override
	public String toString() {
		return super.toString()+" Axis Center: "+this.axisCenter+ " Axis Direction: "+this.axisDirection;
	}
	@Override
	public ArrayList<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
