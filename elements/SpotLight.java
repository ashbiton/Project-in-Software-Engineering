package elements;

import java.awt.Color;

import primitives.*;

public class SpotLight extends PointLight { 
	
	private Vector _direction;	
	
	// ***************** Constructors ********************** // 
	
	public SpotLight(Color _color,Point3D _position, double _kc, double _kl, double _kq,Vector _direction) {
		super(_color,_position, _kc,_kl,_kq);
		this._direction = new Vector(_direction);
	}
	
	public SpotLight(SpotLight sl) {
		super(sl.get_color(),sl.get_position(),sl.get_kc(),sl.get_kl(),sl.get_kq());
		this._direction = new Vector(sl.get_direction());
	}
	
	public SpotLight() {
		super();
		this._direction = new Vector();
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
		return super.toString() + " SpotLight [_direction=" + _direction + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	@Override
	public Color getIntensity(Point3D point) {//PROBLEM MAY BE WITH THE POINT WE GET TO CALCULATE THE INTENSITYÁ!
		/*
		double angle = Math.abs(_direction.normalize().dotProduct(super.getL(point).normalize()));
		double distance = super.get_position().distance(point);
		double div = super.get_kc() + super.get_kl()* distance + super.get_kq()  * distance * distance;
		if (angle > 1)	angle=1;
		if (div < 1)	div=1;
		int red = (int)(super.get_color().getRed()*angle);
		int green = (int)(super.get_color().getGreen()*angle);
		int blue = (int)(super.get_color().getBlue()*angle);
		int r = (int)(red /div);
		int g = (int)(green/div);
		int b = (int)(blue/div);
		Color color = new Color(r,g,b);
		return color;
	*/
// JOYCE'S CODE!
			int r = super.get_color().getRed();
			int g = super.get_color().getGreen();
			int b = super.get_color().getBlue();

			double d = get_position().distance(point);
		
			double k = 1/(super.get_kc() + super.get_kl()*d + super.get_kq()*Math.pow(d, 2));

			if (k > 1) k = 1;

			Color temp = new  Color((int)(r * k),			 
			 (int)(g * k),		 
			 (int)(b * k)); 
			
			Color pointColor = temp;
			Vector l = getL(point);
		//	l.normalize();
			double kk = Math.abs(_direction.dotProduct(l));

			if (kk > 1) kk = 1; // doesn't allow light magnification
			Color IO= new Color((int)(pointColor.getRed()   * kk),
			(int)(pointColor.getGreen() * kk),
			(int)(pointColor.getBlue()  * kk)); 
			return IO;
		}

}
