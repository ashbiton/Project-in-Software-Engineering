package elements;

import java.awt.Color;

import primitives.*;

public class PointLight extends Light implements LightSource {
	private Point3D _position;
	private double _kc,_kq,_kl;
	
	// ***************** Constructors ********************** //
	
	public PointLight()
	{
		super();
		this._position = new Point3D();
		this._kc = 0.01;
		this._kq = 0.01;
		this._kl = 0.01;
	}
	
	public PointLight(Color _color,Point3D _position, double _kc, double _kl, double _kq) {
		super(_color);
		this._position = new Point3D(_position);
		this._kc = _kc;
		this._kq = _kq;
		this._kl = _kl;
	}

	public PointLight(PointLight pl) {
		super(pl.get_color());
		this._position = new Point3D(pl.get_position());
		this._kc = pl.get_kc();
		this._kq = pl.get_kq();
		this._kl = pl.get_kl();
	}

	// ***************** Getters/Setters ********************** //

	public Point3D get_position() {
		return _position;
	}

	public void set_position(Point3D _position) {
		this._position = _position;
	}

	public double get_kc() {
		return _kc;
	}

	public void set_kc(double _kc) {
		this._kc = _kc;
	}

	public double get_kq() {
		return _kq;
	}

	public void set_kq(double _kq) {
		this._kq = _kq;
	}

	public double get_kl() {
		return _kl;
	}

	public void set_kl(double _kl) {
		this._kl = _kl;
	}

	// ***************** Administration  ******************** //
	
	@Override
	public String toString() {
		return super.toString()+ " PointLight [_position=" + _position + ", _kc=" + _kc + ", _kq="
				+ _kq + ", _kl=" + _kl + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}	
	
	@Override
	public Vector getL (Point3D point)
	{
		return new Vector (point.subtract(_position)).normalize();
	}

	@Override
	public Color getIntensity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getIntensity(Point3D point) {
		double distance = point.distance(_position);
		Color color = new Color(super.get_color().getRGB());
		double div = _kc + _kl * distance +_kq * distance * distance ;
		if(div<1) div=1;
		int red = (int)(color.getRed()/div);
		int green = (int)(color.getGreen()/div);
		int blue = (int)(color.getBlue()/div);
		if (red>255)	red=255;
		if (green>255)	green=255;
		if (blue>255)	blue=255;
		return new Color(red,green,blue);
	}

}
