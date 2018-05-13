package elements;

import java.awt.Color;

public class AmbientLight extends Light{
	private double _ka;
	
	// ***************** Constructors ********************** //
	public AmbientLight(Color _color, double _ka) {
		super(_color);
		this._ka = _ka;
	}
	public AmbientLight() {
		super();
		this._ka = 0.1;
	}
	public AmbientLight(AmbientLight al) {
		super(al.get_color());
		this._ka = al.get_ka();
	}
	
	// ***************** Getters/Setters ********************** // 
	
	public double get_ka() {
		return _ka;
	}
	public void set_ka(double _ka) {
		this._ka = _ka;
	}
	
	// ***************** Administration  ******************** //

	public Color getIntensity()
	{
		Color _color = new Color(super.get_color().getRGB());
		int red = (int)(_color.getRed()*_ka);
		int green = (int)(_color.getGreen()*_ka);
		int blue = (int)(_color.getBlue()*_ka);
		return new Color(red,green,blue);
	}
	@Override
	public String toString() {
		return super.toString()+" AmbientLight [_ka=" + _ka + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
			return false;
		return true;
	}
	

}
