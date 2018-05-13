package elements;

import java.awt.Color;
import primitives.*;

public interface LightSource {
	 Color getIntensity(Point3D point);
	 Vector getL(Point3D point);

}
