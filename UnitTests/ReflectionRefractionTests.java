package UnitTests;

//import static org.junit.Assert.*;

import java.awt.Color;

import elements.*;
import geometries.*;

import org.junit.Test;

import Scene.Scene;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;

public class ReflectionRefractionTests {
/*
	@Test
	public void test() {
		Triangle t = new Triangle(new Color(51, 51, 204),new Material(1,1,0,0,20),
								new Point3D(200,150,-100),
								new Point3D(200,-50,-100),
								new Point3D(-200,-50,-100));
		Triangle t1 = new Triangle(new Color(0, 153, 50),new Material(1,1,0,1,20),
				new Point3D(200,150,-70),
				new Point3D(200,-50,-70),
				new Point3D(-200,-50,-70));
		//Sphere s = new Sphere(new Color(0,0,0),new Material(1,1,0,1,20),40,new Point3D(0,0,-70));
		SpotLight sl = new SpotLight(new Color(255, 255, 255), new Point3D(0, 0, -10), 
				0, 0.00001, 0.000005 ,new Vector(1, 1, 1));
		Scene sc = new Scene();
		ImageWriter imageWriter = new ImageWriter("RefractionTest", 700, 700, 700, 700);
		sc.addGeometry(t);
		sc.addGeometry(t1);
		sc.addLight(sl);
		//sc.addGeometry(s);
		Render render = new Render(sc,imageWriter);
		render.renderImage();
		imageWriter.writeToimage();
	}
	
	@Test
	public void test1() {
		Sphere s = new Sphere(new Color(0,0,0),new Material(1,1,0,1,20),40,new Point3D(0,0,-70));
		SpotLight sl = new SpotLight(new Color(255, 255, 255), new Point3D(0, 0, -10), 
				0, 0.00001, 0.000005 ,new Vector(1, 1, 1));
		Scene sc = new Scene();
		ImageWriter imageWriter = new ImageWriter("RefractionTest2", 700, 700, 700, 700);
		sc.addLight(sl);
		sc.addGeometry(s);
		Render render = new Render(sc,imageWriter);
		render.renderImage();
		imageWriter.writeToimage();
	}
	
	@Test
	public void refractedTest(){
		
		Scene scene = new Scene();
	//	scene.set_ambientLight(new AmbientLight(Color.white, 0.1));
		Sphere sphere = new Sphere (new Color(0, 0, 100), 800, new Point3D(0.0, 0.0, -1000));
		sphere.get_material().set_nShininess(20);
		sphere.get_material().set_kt(0.5);
	//	sphere.get_material().set_kr(0.8);
		scene.addGeometry(sphere);
		Sphere sphere2 = new Sphere (Color.pink, 400, new Point3D(0.0, 0.0, -1000));
		sphere2.get_material().set_nShininess(20);
		scene.addGeometry(sphere2);
		scene.addLight(new SpotLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
					   0, 0.00001, 0.000005,new Vector(2, 2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("Refracted test", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
		
	}
	
	@Test
	public void reflectionTest(){
		
		Scene scene = new Scene();
	//	scene.set_ambientLight(new AmbientLight(Color.white, 0.1));
		Sphere sphere = new Sphere (new Color(0, 0, 100), 800, new Point3D(0.0, 0.0, -1000));
		sphere.get_material().set_nShininess(20);
		Triangle t = new Triangle (new Color(51, 51, 204),new Material(1,1,1,0,20),
				new Point3D(2000,1500,-1000),
				new Point3D(2000,-1500,-1000),
				new Point3D(2000,-500,-2000));
		sphere.get_material().set_kt(0.5);
	//	sphere.get_material().set_kr(0.8);
		scene.addGeometry(sphere);
		scene.addGeometry(t);
	//	Sphere sphere2 = new Sphere (Color.pink, 400, new Point3D(0.0, 0.0, -1000));
	//	sphere2.get_material().set_nShininess(20);
	//	scene.addGeometry(sphere2);
		scene.addLight(new SpotLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
					   0, 0.00001, 0.000005,new Vector(2, 2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("Reflected test", 700, 700, 700, 700);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
		
	}
	@Test
	public void shadowTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,20),500, new Point3D(0.0, 0.0, -1000));

		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		triangle.get_material().set_kr(1);
		triangle2.get_material().set_kr(1);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				 0, 0.000001, 0.0000005,new Vector(-2, -2, -3)));
	
		
		ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
*/
	@Test
	public void reflectionTest2(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		Sphere sphere = new Sphere(new Color(0,0,100), 300, new Point3D(-550, -500, -1000));
		sphere.get_material().set_nShininess(20);
		sphere.get_material().set_kt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20),150, new Point3D(-550, -500, -1000));
		sphere2.get_material().set_nShininess(20);
		sphere2.get_material().set_kt(0);
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375));
		
		Triangle triangle2 = new Triangle(new Color(20, 20, 20),new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500));
		
		triangle.get_material().set_kr(1);
		triangle2.get_material().set_kr(0.5);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150), 
				0, 0.00001, 0.000005, new Vector(new Point3D(-2, -2, -3))));
		
	
		ImageWriter imageWriter = new ImageWriter("Reflection Test 2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	/*
	@Test
	public void recursiveTest()
       {
		Scene scene = new Scene();
		scene.set_screenDistance(300);
		scene.set_ambientLight(new AmbientLight(Color.white, 0.1));
		Sphere sphere = new Sphere(new Color(0, 0, 100),500, new Point3D(0.0, 0.0, -1000));
		sphere.get_material().set_nShininess(20);
        sphere.get_material().set_kt(0.5);
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20),250, new Point3D(0.0, 0.0, -1000));
		sphere2.get_material().set_nShininess(20);
		sphere2.get_material().set_kt(0);
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				0.1, 0.00001, 0.000005, new Vector(new Point3D(2, 2, -3))));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test 1", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
	}
*/
	
}
