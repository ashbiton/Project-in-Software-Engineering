package UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import primitives.*;

public class CoordinateTest {
	@Test
	public void addTest()
	{
		Coordinate x = new Coordinate(-2);
		Coordinate y = new Coordinate(3);
		assertEquals(x.add(y),new Coordinate(1));
		assertEquals(x.add(x),new Coordinate(-4));
	}

	@Test
	public void subtractTest()
	{
		Coordinate x = new Coordinate(-2);
		Coordinate y = new Coordinate(3);
		assertEquals(y.subtract(x),new Coordinate(5));
		assertEquals(x.subtract(x),new Coordinate(0));
	}

}
