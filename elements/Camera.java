package elements;



import java.util.ArrayList;

import primitives.*;

public class Camera {
	private Point3D p0;
	private Vector v_up;
	private Vector v_right;
	private Vector v_to;
	
	// ***************** Constructors ********************** //
	public Camera() {
		super();
		this.p0 = new Point3D(0,0,0);
		this.v_up = new Vector (0,1,0);
		this.v_right = new Vector(1,0,0);
		this.v_to = new Vector(0,0,-1);
	}
	public Camera(Point3D p0, Vector v_up, Vector v_right, Vector v_to) {
		super();
		this.p0 = p0;
		this.v_up = v_up;
		this.v_right = v_right;
		this.v_to = v_to;
	}
	public Camera(Camera c) {
		setP0 (c.getP0());
		setV_up (c.getV_up());
		setV_right (c.getV_right());
		setV_to (c.getV_to());
	}
	
	// ***************** Getters/Setters ********************** //
	public Point3D getP0() {
		return p0;
	}
	public void setP0(Point3D p0) {
		this.p0 = p0;
	}
	public Vector getV_up() {
		return v_up;
	}
	public void setV_up(Vector v_up) {
		this.v_up = v_up;
	}
	public Vector getV_right() {
		return v_right;
	}
	public void setV_right(Vector v_right) {
		this.v_right = v_right;
	}
	public Vector getV_to() {
		return v_to;
	}
	public void setV_to(Vector v_to) {
		this.v_to = v_to;
	}

	// ***************** Administration  ******************** // '
	 public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y, 
			 			double screenDist, double screenWidth, double screenHeight)
	 {
		 Vector v1 = v_to.scale(screenDist);
		 Point3D Pc = p0.add(v1.getHead());
		 Vector v_r = v_to.crossProduct(v_up).normalize();
		 v_to=v_to.normalize();
		 v_up=v_up.normalize();
		 double Rx = screenWidth/Nx;
		 double Ry = screenHeight/Ny;
		 double Nx2 = Nx/2.0;
		 double Ny2 = Ny/2.0;
		 double Rx2 = screenWidth/(Nx*2.0);
		 double Ry2 = screenHeight/(Ny*2.0);
		 double Sx = (x - Nx2)*Rx + Rx2;
		 double Sy = (y - Ny2)*Ry + Ry2;
		 Vector v = v_r.scale(Sx).subtract(v_up.scale(Sy));
		 Point3D p = Pc.add(v.getHead());
		 Vector direction = new Vector(p.subtract(p0));
		 return new Ray(p0,direction);
	 }
	 
	//fixed function for supersampling!!!
	 public ArrayList<Ray> constructRayThroughPixel1 (int Nx, int Ny, double x, double y, 
	 			double screenDist, double screenWidth, double screenHeight)
	{
		//fix for SuperSampling
		Vector v1 = v_to.scale(screenDist);
		Point3D Pc = p0.add(v1.getHead());
		Vector v_r = v_to.crossProduct(v_up).normalize();
		v_to=v_to.normalize();
		v_up=v_up.normalize();
		double Rx = screenWidth/Nx;
		double Ry = screenHeight/Ny;
		double Nx2 = Nx/2.0;
		double Ny2 = Ny/2.0;
		
		ArrayList<Ray> Rays = new ArrayList<Ray> ();
		double Sx = (x - Nx2)*Rx ;
		double Sy = (y - Ny2)*Ry ;
		
		for (int i=0; i<3; i++)
		{
			Sx += Rx*0.25;
			
			for (int j=0; j<3; j++)
			{	
			   	Sy += Ry*0.25;
			 	Vector v = v_r.scale(Sx).subtract(v_up.scale(Sy));
			 	Point3D p = Pc.add(v.getHead());
				Vector direction = new Vector(p.subtract(p0));
				Rays.add( new Ray(p0,direction));
			}
		}
		return Rays;
	}
}
