package geometries;
import java.awt.Color;
import java.util.ArrayList;

import primitives.*;
public abstract class Geometry {
	private Material _material;
	private Color color; //emission

	public Geometry(Color color,Material _material) {
		this.color = color;
		this._material = new Material(_material);
	}
	public Geometry(Color color) {
		this.color = color;
		this._material = new Material();
	}
	public Geometry() {
		this.color = new Color(0,0,0);
		this._material = new Material();
	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public Material get_material() {
		return _material;
	}
	public void set_material(Material _material) {
		this._material = _material;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geometry other = (Geometry) obj;
		if (_material == null) {
			if (other._material != null)
				return false;
		} else if (!_material.equals(other._material))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Geometry [_material=" + _material + ", color=" + color + "]";
	} 
	public abstract Vector getNormal(Point3D p);
	public abstract ArrayList<Point3D> findIntersections(Ray ray);
}
