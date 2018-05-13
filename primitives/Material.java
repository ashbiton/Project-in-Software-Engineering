package primitives;

public class Material {
	
	private double _kd, _ks;
	private double _kr, _kt;
	private int	_nShininess;

	
	// ***************** Constructors ********************** // 
	public Material() {
		super();
		this._kd = 1;
		this._ks = 1;
		this._kr = 0;
		this._kt = 0;
		this._nShininess = 1;
	}
	
	public Material(double _kd, double _ks, int _nShininess) {
		super();
		this._kd = _kd;
		this._ks = _ks;
		this._nShininess = _nShininess;
	}
	public Material(double _kd, double _ks, double _kr, double _kt,
			int _nShininess) {
		super();
		this._kd = _kd;
		this._ks = _ks;
		this._kr = _kr;
		this._kt = _kt;
		this._nShininess = _nShininess;
	}
	
	public Material(Material m) {
		this._kd = m.get_kd();
		this._ks = m.get_ks();
		this._kr = m.get_kr();
		this._kt = m.get_kt();
		this._nShininess = m.get_nShininess();
	}
	
	
	// ***************** Getters/Setters ******************* // 
	
	public double get_kd() {
		return _kd;
	}
	public void set_kd(double _kd) {
		this._kd = _kd;
	}
	public double get_ks() {
		return _ks;
	}
	public void set_ks(double _ks) {
		this._ks = _ks;
	}
	public double get_kr() {
		return _kr;
	}

	public void set_kr(double _kr) {
		this._kr = _kr;
	}

	public double get_kt() {
		return _kt;
	}

	public void set_kt(double _kt) {
		this._kt = _kt;
	}

	public int get_nShininess() {
		return _nShininess;
	}
	public void set_nShininess(int _nShininess) {
		if (_nShininess<0)
			_nShininess=0;
		this._nShininess = _nShininess;
	}

	
	// ***************** Administration  ******************* //


	@Override
	public String toString() {
		return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _nShininess="
				+ _nShininess + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
			return false;
		if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
			return false;
		if (_nShininess != other._nShininess)
			return false;
		return true;
	}

}
