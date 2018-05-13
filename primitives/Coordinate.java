package primitives;

public class Coordinate {
	private double x;

	// ***************** Constructors ********************** // 	
	public Coordinate (){
		this.x = 0.0;
	}
	public Coordinate(double x) {
		super();
		this.x = x;
	}
	public Coordinate (Coordinate coor) {
		this.x = coor.getX();
	}
	// ***************** Getters/Setters ********************** // 
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	// ***************** Administration  ******************** //
	@Override
	public boolean equals(Object arg) {
		if (arg.getClass() != this.getClass())
			return false;
		Coordinate c = (Coordinate)arg;
	return x == c.getX();
	}
	@Override
	public String toString() {
		return "Coordinate: [ " + x + " ]";
	}
	// ***************** Operations ******************** // 
	public Coordinate add (Coordinate coor)
	{
		return new Coordinate(x+coor.getX());
	}
	public Coordinate subtract (Coordinate coor){
		return new Coordinate(x-coor.getX());
	}
	

}
