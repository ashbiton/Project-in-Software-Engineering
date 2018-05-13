
package UnitTests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import primitives.Vector;
import elements.DirectionalLight;

public class DirectionalLightTest {

	@Test
	public void getIntensityTest() {
		DirectionalLight dl = new DirectionalLight(new Color(30,245,87),new Vector(2,3,4));
		Color intensity = dl.getIntensity();
		assertEquals(intensity.getRed(),30);
		assertEquals(intensity.getGreen(),245);
		assertEquals(intensity.getBlue(),87);
	}

}
