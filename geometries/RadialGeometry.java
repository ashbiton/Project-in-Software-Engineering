package geometries;

import java.awt.Color;

import primitives.Material;

public abstract class RadialGeometry extends Geometry {
	private double radius;

	public RadialGeometry(Color color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	public RadialGeometry(Color color, Material _material, double radius) {
		super(color, _material);
		this.radius = radius;
	}

	public RadialGeometry() {
		super();
		this.radius = 0;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;		
	}

	@Override
	public boolean equals(Object arg) {
		if(!super.equals(arg))
			return false;
		RadialGeometry rg = (RadialGeometry)arg;
		if (rg.getRadius()!= this.getRadius())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+ " Radius: "+this.getRadius();
	}
}
