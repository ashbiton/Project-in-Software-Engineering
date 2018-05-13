package primitives;

public class Ray {
	Point3D POO;
	Vector direction;
	// ***************** Constructors ********************** // 
	public Ray() {
		POO = new Point3D(0,0,0);
		direction = new Vector();
	}
	public Ray(Point3D pOO, Vector direction) {
		super();
		POO = new Point3D(pOO);
		this.direction = new Vector(direction);
	}
	public Ray(Ray ray) {
		POO = new Point3D(ray.getPOO());
		direction = new Vector(ray.getDirection());
	}
	// ***************** Getters/Setters ********************** //
	public Point3D getPOO() {
		return POO;
	}

	public void setPOO(Point3D pOO) {
		POO = pOO;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	// ***************** Administration  ******************** // 
	@Override
	public boolean equals(Object arg) {
		if (arg.getClass() != this.getClass())
			return false;
		Ray r = (Ray)arg;
		return POO.equals(r.getPOO()) && direction.equals(r.getDirection());
	}
	@Override
	public String toString() {
		return "Ray: [ "+ POO.toString() + " , " + direction.toString() + " ]";
	}
	// ***************** Operations ******************** // 
	
}
