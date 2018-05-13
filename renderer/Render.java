package renderer;

import elements.LightSource;
import geometries.FlatGeometry;
import geometries.Geometry;

import java.awt.Color;
import java.util.*;
import java.util.Map.Entry;

import primitives.*;
import primitives.Vector;
import Scene.Scene;

public class Render {
	private static int RECURSION_LEVEL = 4;
	Scene scene;
	ImageWriter imageWriter;
	
	// ***************** Constructors ********************** //
	public Render(Scene scene, ImageWriter imageWriter) {
		super();
		this.scene = scene;
		this.imageWriter = imageWriter;
	}

	public Render(Render r) {
		super();
		this.scene = r.getScene();
		this.imageWriter = r.getImageWriter();
	}
	// ***************** Getters/Setters ********************** // 
	public Scene getScene() {
		return scene;
	}


	public void setScene(Scene scene) {
		this.scene = scene;
	}


	public ImageWriter getImageWriter() {
		return imageWriter;
	}


	public void setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
	}

	
	// ***************** Administration  ******************** //


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (imageWriter == null) {
			if (other.imageWriter != null)
				return false;
		} else if (!imageWriter.equals(other.imageWriter))
			return false;
		if (scene == null) {
			if (other.scene != null)
				return false;
		} else if (!scene.equals(other.scene))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Render [scene=" + scene + ", imageWriter=" + imageWriter + "]";
	}
	/*
	public void renderImage()
	{
		for (int i=0; i< imageWriter.getHeight(); i++)
			for (int j=0; j< imageWriter.getWidth(); j++)
			{
				Ray ray =scene.get_camera().constructRayThroughPixel(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.get_screenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight());
				Map<Geometry,ArrayList<Point3D>> intersectionPoints = getSceneRayIntersctions(ray);
				if (intersectionPoints.isEmpty())
					imageWriter.writePixel(j, i, scene.get_background());
				else
				{
					Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
					for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
						imageWriter.writePixel(j, i, calcColor(e.getKey(),e.getValue()));
				}

			}
	}

	public void renderImage()
	{
		for (int i=0; i< imageWriter.getHeight(); i++)
			for (int j=0; j< imageWriter.getWidth(); j++)
			{
				Ray ray =scene.get_camera().constructRayThroughPixel(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.get_screenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight());
				Map<Geometry,ArrayList<Point3D>> intersectionPoints = getSceneRayIntersctions(ray);
				if (intersectionPoints.isEmpty())
					imageWriter.writePixel(j, i, scene.get_background());
				else
				{
					
					Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
					for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
					
						imageWriter.writePixel(j, i, calcColor(e.getKey(),e.getValue(),ray));
					
				}

			}
	}*/
	//fixed function for supersampling!!!
	public void renderImage()
	{
		for (int i=0; i< imageWriter.getHeight(); i++)
			for (int j=0; j< imageWriter.getWidth(); j++)
			{
				ArrayList<Ray> rays =scene.get_camera().constructRayThroughPixel1(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.get_screenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight());
				int red = 0, blue = 0, green = 0;
				for (Ray ray : rays)
				{
					Map<Geometry,ArrayList<Point3D>> intersectionPoints = getSceneRayIntersctions(ray);
					if (intersectionPoints.isEmpty())
						{ 
							Color back = scene.get_background();
							red+= back.getRed();
							green+= back.getGreen();
							blue+= back.getBlue();
						}
					
					else
					{
						
						Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
						for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
						{
							Color color = calcColor(e.getKey(),e.getValue(),ray);
							red += color.getRed();
							green += color.getGreen();
							blue += color.getBlue();
						}
						
					}
				}
				red = red/9;	green = green/9;	blue = blue/9;
				imageWriter.writePixel(j, i, new Color (red, green ,blue));

			}
	}

	public void printGrid(int interval)
	{
		for (int i=0; i< imageWriter.getHeight(); i++)
			for (int j=0; j< imageWriter.getWidth(); j++)
			{
				if (i%interval == 0 || j%interval == 0)
					imageWriter.writePixel(i, j, Color.white);
			}
		imageWriter.writeToimage();
	}
	/*
	private Map<Geometry,Point3D> getClosestPoint(Map<Geometry,ArrayList<Point3D>> intersectionPoints) {
		double distance =Double.MAX_VALUE;
		Point3D P0 = scene.get_camera().getP0();
		Map<Geometry,Point3D> minDisPoint = new HashMap<Geometry,Point3D>();
		for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
		{
			for (Point3D point: entry.getValue())
			{
				if (P0.distance(point) < distance)
				minDisPoint.clear();
				minDisPoint.put(entry.getKey(), new Point3D(point));
				distance = P0.distance(point);
			}
		}
			return minDisPoint; 
	}
*/

	private Map<Geometry, Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> intersectionPoints) {
		double distance = Double.MAX_VALUE;
		Point3D P0 = scene.get_camera().getP0();
		Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet()){
			for (Point3D point : entry.getValue()){
				double pointDistance = P0.distance(point);
				if (pointDistance < distance){
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = pointDistance;
					}
				}
			}
			return minDistancePoint;
	}

	/*private Map<Geometry,ArrayList<Point3D>> getSceneRayIntersctions(Ray ray) 
	{
			Iterator<Geometry> geometries = scene.getGeomeriesIterator();
			Map<Geometry,ArrayList<Point3D>> intersectionPoints = new HashMap<Geometry,ArrayList<Point3D>>();

			
			while (geometries.hasNext())
			{
				Geometry geometry = geometries.next();
				ArrayList<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
				//add geometryIntersectionPoints to intersectionPoints
				if(!geometryIntersectionPoints.isEmpty())
					intersectionPoints.put(geometry, geometryIntersectionPoints);
			}
			return intersectionPoints;
	}*/
	
	private Map<Geometry,ArrayList<Point3D>> getSceneRayIntersctions(Ray ray) 
	{
			Iterator<Geometry> geometries = scene.getGeomeriesIterator();
			Map<Geometry,ArrayList<Point3D>> intersectionPoints = new HashMap<Geometry,ArrayList<Point3D>>();

			
			while (geometries.hasNext())
			{
				Geometry geometry = geometries.next();

			
				ArrayList<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);
				//add geometryIntersectionPoints to intersectionPoints
				if(!geometryIntersectionPoints.isEmpty())
				
					intersectionPoints.put(geometry, geometryIntersectionPoints);
				
			}
			return intersectionPoints;
	}
	
	private Color calcDiffuseComp(double kd, Vector normal , Vector L , Color intensity)
	{/*
		double temp = Math.abs(normal.dotProduct(L));
		double scelar = kd * temp; 
		int red = (int) (intensity.getRed()*scelar);
		int green = (int) (intensity.getGreen()*scelar);
		int blue = (int) (intensity.getBlue()*scelar);
		if (red<0)		red=0;
		if (green<0)	green=0;
		if (blue<0)		blue=0;
		if (red>255)	red=255;
		if (green>255)	green=255;
		if (blue>255)	blue=255;
		return new Color(red,green,blue);*/
		//return new Color(0,0,0);
	//Joyce's Code
				normal.normalize();
				L.normalize();
				double k = Math.abs(kd * normal.dotProduct(L));
				return new Color (
						(int)(intensity.getRed() * k),
						(int)(intensity.getGreen() * k),
						(int)(intensity.getBlue() * k));
				
	}
	
	private Color calcSpecularComp (double ks , Vector V , Vector normal , Vector D , int shininess , Color intensity)//j
	{
		double dot = (D.dotProduct(normal))*2;
		Vector R = D.subtract(normal.scale(dot)).normalize();
		double temp = ks * Math.pow(V.normalize().dotProduct(R), shininess);
		double scelar = Math.abs(temp);
		int red = (int) (intensity.getRed()*scelar);
		int green = (int) (intensity.getGreen()*scelar);
		int blue = (int) (intensity.getBlue()*scelar);
		if (red<0)		red=0;
		if (green<0)	green=0;
		if (blue<0)		blue=0;
		if (red>255)	red=255;
		if (green>255)	green=255;
		if (blue>255)	blue=255;
		return new Color(red,green,blue);
		
	}
	
	private Color calcColor(Geometry geometry,Point3D closestPoint,Ray inRay){
		return calcColor( geometry, closestPoint, inRay ,0);
	}
	/*
	private Color calcColor(Geometry geometry,Point3D closestPoint,Ray inRay,int level) {
		if (level == RECURSION_LEVEL) 
			return new Color(0, 0, 0);
		
		Color emissionLight = geometry.getColor();
		Color ambientLight = scene.get_ambientLight().getIntensity();
		Iterator <LightSource> lights = scene.getLightsIterator();
		int DiffRed = 0, DiffGreen = 0, DiffBlue = 0, SpecRed = 0, SpecGreen = 0, SpecBlue = 0;
		while (lights.hasNext())
		{
			LightSource current = lights.next();
			if (!occluded(current, closestPoint, geometry))
			{
				Color  diffuseLight = calcDiffuseComp(geometry.get_material().get_kd(),
												geometry.getNormal(closestPoint),
												current.getL(closestPoint),
												current.getIntensity(closestPoint));
				
				Color specularLight = calcSpecularComp (geometry.get_material().get_ks(),
													new Vector(closestPoint.subtract(scene.get_camera().getP0())),						
													geometry.getNormal(closestPoint),
													current.getL(closestPoint),
													geometry.get_material().get_nShininess(),
													current.getIntensity(closestPoint));
				
				 DiffRed = DiffRed + diffuseLight.getRed();
				 DiffGreen = DiffGreen + diffuseLight.getGreen();
				 DiffBlue = DiffBlue + diffuseLight.getBlue();
				 SpecRed = SpecRed + specularLight.getRed();
				 SpecGreen = SpecGreen + specularLight.getGreen();
				 SpecBlue = SpecBlue + specularLight.getBlue();
			 
			}
		}
		// Recursive call for a reflected ray
		double kr = geometry.get_material().get_kr();
		Color reflectedLight= new Color(0,0,0);
		if (kr != 0)
		{
			Color reflectedColor = new Color(0,0,0);
			Ray reflectedRay = constructReflectedRay(geometry.getNormal(closestPoint), closestPoint, inRay);
			Map<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay);
			for(Entry<Geometry,Point3D> e: reflectedEntry.entrySet())
				reflectedColor = calcColor(e.getKey(), e.getValue(), reflectedRay,level+1);
			reflectedLight = new Color ((int)(kr * reflectedColor.getRed()),
										(int)(kr * reflectedColor.getGreen()),
										(int)(kr * reflectedColor.getBlue()));
		}
		
		// Recursive call for a refracted ray
		double kt = geometry.get_material().get_kt();
		Color refractedLight = new Color(0,0,0);
		if (kt != 0)
		{
			Color refractedColor = new Color(0,0,0);
			Ray refractedRay = constructRefractedRay(geometry.getNormal(closestPoint), closestPoint, inRay);
			Map<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
			for(Entry<Geometry,Point3D> e: refractedEntry.entrySet())
				refractedColor = calcColor(e.getKey(),e.getValue(), refractedRay ,level+1);		
			 refractedLight = new Color ((int)(kt * refractedColor.getRed()),
					 					 (int)(kt * refractedColor.getGreen()),
					 					 (int)(kt * refractedColor.getBlue()));
		}
		
		int red = ambientLight.getRed()+emissionLight.getRed()+DiffRed + SpecRed + reflectedLight.getRed() + refractedLight.getRed();
		int green = ambientLight.getGreen()+emissionLight.getGreen()+ DiffGreen+SpecGreen + reflectedLight.getGreen() + refractedLight.getGreen();
		int blue = ambientLight.getBlue()+emissionLight.getBlue()+ DiffBlue + SpecBlue + reflectedLight.getBlue() + refractedLight.getBlue();
		if (red>255)	red=255;
		if (green>255)	green=255;
		if (blue>255)	blue=255;
		return new Color(red,green,blue);
	}*/
	
	private Color calcColor(Geometry geometry,Point3D closestPoint,Ray inRay,int level) {
		if (level == RECURSION_LEVEL) 
			return new Color(0, 0, 0);
		
		Color emissionLight = geometry.getColor();
		Color ambientLight = scene.get_ambientLight().getIntensity();
		Iterator <LightSource> lights = scene.getLightsIterator();
		int DiffRed = 0, DiffGreen = 0, DiffBlue = 0, SpecRed = 0, SpecGreen = 0, SpecBlue = 0;
		while (lights.hasNext())
		{
			LightSource current = lights.next();
			if (!occluded(current, closestPoint, geometry) && current.getL(closestPoint).dotProduct(geometry.getNormal(closestPoint))>0)
			{
				Color  diffuseLight = calcDiffuseComp(geometry.get_material().get_kd(),
												geometry.getNormal(closestPoint),
												current.getL(closestPoint),
												current.getIntensity(closestPoint));
				
				Color specularLight = calcSpecularComp (geometry.get_material().get_ks(),
													new Vector(closestPoint.subtract(scene.get_camera().getP0())),						
													geometry.getNormal(closestPoint),
													current.getL(closestPoint),
													geometry.get_material().get_nShininess(),
													current.getIntensity(closestPoint));
				
				 DiffRed = DiffRed + diffuseLight.getRed();
				 DiffGreen = DiffGreen + diffuseLight.getGreen();
				 DiffBlue = DiffBlue + diffuseLight.getBlue();
				 SpecRed = SpecRed + specularLight.getRed();
				 SpecGreen = SpecGreen + specularLight.getGreen();
				 SpecBlue = SpecBlue + specularLight.getBlue();
			 
			}
		}
		// Recursive call for a reflected ray
		double kr = geometry.get_material().get_kr();
		Color reflectedLight= new Color(0,0,0);
		if (kr != 0)
		{
			Color reflectedColor = new Color(0,0,0);
			Ray reflectedRay = constructReflectedRay(geometry.getNormal(closestPoint), closestPoint, inRay);
			Entry<Geometry,Point3D> reflectedEntry = findClosestIntersection(reflectedRay);
			if (reflectedEntry != null)
			{
				reflectedColor = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay,level+1);
				reflectedLight = new Color ((int)(kr * reflectedColor.getRed()),
											(int)(kr * reflectedColor.getGreen()),
											(int)(kr * reflectedColor.getBlue()));
			}
		}
		
		// Recursive call for a refracted ray
		double kt = geometry.get_material().get_kt();
		Color refractedLight = new Color(0,0,0);
		if (kt != 0)
		{
			Color refractedColor = new Color(0,0,0);
			Ray refractedRay = constructRefractedRay(geometry.getNormal(closestPoint), closestPoint, inRay);
			Entry<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
			if (refractedEntry != null)
			{
				 refractedColor = calcColor(refractedEntry.getKey(),refractedEntry.getValue(), refractedRay ,level+1);		
				 refractedLight = new Color ((int)(kt * refractedColor.getRed()),
						 					 (int)(kt * refractedColor.getGreen()),
						 					 (int)(kt * refractedColor.getBlue()));
			}
		}
		
		int red = ambientLight.getRed()+emissionLight.getRed()+DiffRed + SpecRed + reflectedLight.getRed() + refractedLight.getRed();
		int green = ambientLight.getGreen()+emissionLight.getGreen()+ DiffGreen+SpecGreen + reflectedLight.getGreen() + refractedLight.getGreen();
		int blue = ambientLight.getBlue()+emissionLight.getBlue()+ DiffBlue + SpecBlue + reflectedLight.getBlue() + refractedLight.getBlue();
		if (red>255)	red=255;
		if (green>255)	green=255;
		if (blue>255)	blue=255;
		return new Color(red,green,blue);
	}
	
/*
	private Map<Geometry,Point3D> findClosestIntersection(Ray reflectedRay) {
		Map<Geometry,ArrayList<Point3D>> intersections = getSceneRayIntersctions(reflectedRay);
		Map<Geometry,Point3D> closestPoint = getClosestPoint(intersections);
		return closestPoint;
	}*/
	private Entry<Geometry,Point3D> findClosestIntersection(Ray reflectedRay) {
		Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersctions(reflectedRay);
		if (intersectionPoints.size() == 0)
			return null;
		Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
		Entry<Geometry, Point3D> entry = closestPoint.entrySet().iterator().next();
		return entry;
	}
	

	/*
	private Color calcColor(Geometry geometry,Point3D closestPoint) {
		Color emissionLight = geometry.getColor();
		Color ambientLight = scene.get_ambientLight().getIntensity();
		Iterator <LightSource> lights = scene.getLightsIterator();
		int DiffRed = 0, DiffGreen = 0, DiffBlue = 0, SpecRed = 0, SpecGreen = 0, SpecBlue = 0;
		while (lights.hasNext())
		{
			LightSource current = lights.next();
			if (!occluded(current, closestPoint, geometry))
			{
				Color  diffuseLight = calcDiffuseComp(geometry.get_material().get_kd(),
												geometry.getNormal(closestPoint),
												current.getL(closestPoint),
												current.getIntensity(closestPoint));
				
				Color specularLight = calcSpecularComp (geometry.get_material().get_ks(),
													new Vector(closestPoint.subtract(scene.get_camera().getP0())),						
													geometry.getNormal(closestPoint),
													current.getL(closestPoint),
													geometry.get_material().get_nShininess(),
													current.getIntensity(closestPoint));
				
				 DiffRed = DiffRed + diffuseLight.getRed();
				 DiffGreen = DiffGreen + diffuseLight.getGreen();
				 DiffBlue = DiffBlue + diffuseLight.getBlue();
				 SpecRed = SpecRed + specularLight.getRed();
				 SpecGreen = SpecGreen + specularLight.getGreen();
				 SpecBlue = SpecBlue + specularLight.getBlue();
			 
			}
		}
		int red = ambientLight.getRed()+emissionLight.getRed()+DiffRed + SpecRed;
		int green = ambientLight.getGreen()+emissionLight.getGreen()+ DiffGreen+SpecGreen;
		int blue = ambientLight.getBlue()+emissionLight.getBlue()+ DiffBlue + SpecBlue;
		if (red>255)	red=255;
		if (green>255)	green=255;
		if (blue>255)	blue=255;
		return new Color(red,green,blue);
	}
	*/
	private boolean occluded(LightSource light, Point3D point, Geometry geometry) {
		Vector lightDirection = light.getL(point);
		lightDirection = lightDirection.scale(-1);

		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point)).scale(20);

		geometryPoint=geometryPoint.add(epsVector.getHead());
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersctions(lightRay);

		// Flat geometry cannot self intersect
		if (geometry instanceof FlatGeometry)
		{
			intersectionPoints.remove(geometry);
		}
		for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
			if (entry.getKey().get_material().get_kt() == 0)
				return true;
			return false;
		}

	private Ray constructReflectedRay (Vector normal, Point3D point, Ray inRay)
	{
		Vector l = inRay.getDirection();
		l.normalize();
		normal = normal.scale(-2*l.dotProduct(normal));
		l = l.add(normal);
		Vector R = new Vector(l);
		R.normalize();
		point = point.add(normal.getHead());
		
		Ray reflectedRay = new Ray (point, R);
		
		return reflectedRay;
	}
	
	private Ray constructRefractedRay (Vector normal, Point3D point,Ray inRay)
	{
		normal = normal.scale(-2);
		point = point.add(normal.getHead());
		return new Ray(point,inRay.getDirection());
	}
	
}
