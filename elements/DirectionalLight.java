package elements;

import java.awt.Color;

import primitives.*;

public class DirectionalLight  extends Light implements LightSource {
	private Vector _direction;
	
	// ***************** Constructors ********************** //
	
	public DirectionalLight(DirectionalLight dl) {
		super(dl.get_color());
		this._direction = new Vector(dl.get_direction());
	}
	public DirectionalLight() {
		super();
		this._direction = new Vector();
	}
	public DirectionalLight(Color _color,Vector _direction) {
		super(_color);
		this._direction = _direction;
	}
	
	// ***************** Getters/Setters ********************** // 
	
	public Vector get_direction() {
		return _direction;
	}
	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}	
	
	// ***************** Administration  ******************** //
	
	@Override
	public String toString() {
		return super.toString()+" DirectionalLight [_direction=" + _direction + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	@Override
	public Color getIntensity() {
		return super.get_color();
	}
	
	@Override
	public Vector getL(Point3D point) {
		return new Vector(point.subtract(_direction.getHead())).normalize();
	}
	
	@Override
	public Color getIntensity(Point3D point) {
		return super.get_color();
	}


}
