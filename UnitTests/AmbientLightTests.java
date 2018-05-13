package UnitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import elements.AmbientLight;

public class AmbientLightTests {

	@Test
	public void getIntensityTest1() {
		AmbientLight al = new AmbientLight(new Color(150,200,100),0.5);
		Color intensity = al.getIntensity();
		assertEquals(intensity.getRed(),75);
		assertEquals(intensity.getGreen(),100);
		assertEquals(intensity.getBlue(),50);
	}
	
	@Test
	public void getIntensityTest2() {
		AmbientLight al = new AmbientLight(new Color(75,31,0),0.5);
		Color intensity = al.getIntensity();
		assertEquals(intensity.getRed(),37);
		assertEquals(intensity.getGreen(),15);
		assertEquals(intensity.getBlue(),0);
	}

}
