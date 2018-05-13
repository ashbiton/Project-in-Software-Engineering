package primitives;

public class Point3D {
	private Coordinate x;
	private Coordinate y;
	private Coordinate z;
	// ***************** Constructors ********************** // 	
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super();
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}
	public Point3D (double x, double y, double z){
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}
	public Point3D(Point3D p3d){
		this.x = new Coordinate(p3d.getX());
		this.y = new Coordinate(p3d.getY());
		this.z = new Coordinate(p3d.getZ());
	}
	public Point3D(){
		this.x = new Coordinate();
		this.y = new Coordinate();
		this.x = new Coordinate();
	}
	// ***************** Getters/Setters ********************** // 
	public Coordinate getX() {
		return x;
	}
	public void setX(Coordinate x) {
		this.x = x;
	}
	public Coordinate getY() {
		return y;
	}
	public void setY(Coordinate y) {
		this.y = y;
	}
	public Coordinate getZ() {
		return z;
	}
	public void setZ(Coordinate z) {
		this.z = z;
	}
	// ***************** Administration  ******************** // 
	@Override
	public boolean equals(Object arg) {
		if (arg.getClass() != this.getClass())
			return false;
		Point3D p = (Point3D)arg;
		return x.equals(p.getX()) && y.equals(p.getY()) && z.equals(p.getZ());
	}
	@Override
	public String toString() {
		return "Point3D: [ X: [" + x.toString() + "] , Y: [" + y.toString() + "] , Z: [" + z.toString() + "] ]";
	}
	// ***************** Operations ******************** // 
	public Point3D add (Point3D p){
		return new Point3D( x.add(p.getX()),
				y.add(p.getY()),
				z.add(p.getZ())
				);
	}
	public Point3D subtract (Point3D p){
		return new Point3D(x.subtract(p.getX()), 
				y.subtract(p.getY()),
				z.subtract(p.getZ())
				);
	}
	/*public double distance (Point3D p){
		return Math.sqrt(
				Math.pow(x.subtract(p.getX()).getX(), 2)+
				Math.pow(y.subtract(p.getY()).getX(), 2)+
				Math.pow(z.subtract(p.getZ()).getX(), 2));
	}*/
	//Joyce's code
	public double distance(Point3D other){
		return Math.sqrt( 
				Math.pow(x.getX()-other.x.getX(),2) +
				Math.pow(y.getX()-other.y.getX(),2) +
				Math.pow(z.getX()-other.z.getX(),2));
		}

	public double dotProduct (Point3D p){
		return x.getX()*p.getX().getX()+
				y.getX()*p.getY().getX()+
				z.getX()*p.getZ().getX();
	}
	

}
