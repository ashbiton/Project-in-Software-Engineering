package elements;

import java.awt.Color;

public abstract class Light {
	
	private Color _color;
	
	public abstract Color getIntensity();
	// ***************** Constructors ********************** //
	public Light() {
		super();
		this._color = new Color(255,255,255);
	}
	public Light(Color _color) {
		super();
		this._color = _color;
	}
	public Light(Light l) {
		super();
		this._color = new Color(l.get_color().getRGB());
	}
	// ***************** Getters/Setters ********************** //
	
	public Color get_color() {
		return _color;
	}

	public void set_color(Color _color) {
		this._color = _color;
	}
	// ***************** Getters/Setters ********************** //

	@Override
	public String toString() {
		return "Light [_color=" + _color + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}
	

	
}
