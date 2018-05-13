package primitives;

public class Vector {
	private Point3D head;

	// ***************** Constructors ********************** // 
	public Vector (double x, double y, double z)
	{
		this.head = new Point3D(x,y,z);
	}
	public Vector(Point3D head) {
		super();
		this.head = head;
	}
	public Vector (Vector v){
		this.head = new Point3D(v.getHead());
	}
	public Vector (){
		this.head = new Point3D (0,0,0);
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getHead() {
		return head;
	}

	public void setHead(Point3D head) {
		this.head = head;
	}
	// ***************** Administration  ******************** // 
	@Override
	public boolean equals(Object arg) {
		if (arg.getClass() != this.getClass())
			return false;
		Vector v = (Vector)arg;
		return head.equals(v.getHead());		
	}
	@Override
	public String toString() {
		return "Vector: [ "+ head.toString()+ " ]";
	}	
	// ***************** Operations ******************** // 
	public Vector add (Vector v){
		return new Vector(head.add(v.getHead()));
	}
	public Vector subtract(Vector v){
		return new Vector(head.subtract(v.getHead()));
	}
	public double dotProduct (Vector v){
		return head.dotProduct(v.getHead());
	}
	public double length(){
		return head.distance(new Point3D(0,0,0));
	}
	public Vector scale (double scler)
	{
		return new Vector(head.getX().getX()*scler, head.getY().getX()*scler, head.getZ().getX()*scler);
	}
	public Vector normalize(){
		double _length = length();//the point is to avoid calling the function again and again
		if (_length==0)
			return this;
		head.setX(new Coordinate(head.getX().getX()/_length));
		head.setY(new Coordinate(head.getY().getX()/_length));
		head.setZ(new Coordinate(head.getZ().getX()/_length));
		return this;
	}
	public Vector crossProduct (Vector v){
		return new Vector(
				new Point3D(
						head.getY().getX()*v.getHead().getZ().getX() - head.getZ().getX()*v.getHead().getY().getX(),
						head.getZ().getX()*v.getHead().getX().getX() - head.getX().getX()*v.getHead().getZ().getX(),
						head.getX().getX()*v.getHead().getY().getX() - head.getY().getX()*v.getHead().getX().getX()));
	}

}
