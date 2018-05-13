package UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import primitives.*;
import elements.Camera;



public class CameraTest 
{
	@Test
	public void constructRayThroughPixelTest()
	{
		Camera camera = new Camera();
		Ray ray = new Ray(camera.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150));
		assertEquals(ray,new Ray(new Point3D(0,0,0), new Vector (100,-100,-100)));
	}
}
