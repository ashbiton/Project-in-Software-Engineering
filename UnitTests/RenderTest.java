package UnitTests;


import elements.*;
import geometries.*;

import java.awt.Color;

import org.junit.Test;

import primitives.*;
import renderer.*;
import Scene.Scene;

public class RenderTest {
/*
	@Test
	public void printGridTest() {
		
		Render r = new Render(new Scene(),new ImageWriter("printGridTest",100,100,25,25));
		r.printGrid(4);
	}
	
	@Test
	public void renderImageTest1() 
	{
		Sphere s = new Sphere(Color.black , 40 ,new Point3D(0,0,-50));
		Triangle t1 = new Triangle(Color.black,new Point3D(100,0,-49),new Point3D(0,100,-49),new Point3D(100,100,-49));
		Triangle t2 = new Triangle(Color.CYAN,new Point3D(100,0,-49),new Point3D(0,-100,-49),new Point3D(100,-100,-49));
		Triangle t3 = new Triangle(Color.ORANGE,new Point3D(-100,0,-49),new Point3D(0,100,-49),new Point3D(-100,100,-49));
		Triangle t4 = new Triangle(Color.MAGENTA,new Point3D(-100,0,-49),new Point3D(0,-100,-49),new Point3D(-100,-100,-49));
		Scene sc =new Scene();
		sc.addGeometry(s);
		sc.addGeometry(t1);
		sc.addGeometry(t2);
		sc.addGeometry(t3);
		sc.addGeometry(t4);		
		ImageWriter iw = new ImageWriter("renderImageTest1",500,500,500,500);
		Render r = new Render(sc,iw);
		r.renderImage();
		r.printGrid(50);
		iw.writeToimage();
	}
	

	@Test
	public void renderImageTest2() 
	{
		Sphere s = new Sphere(Color.green , 40 ,new Point3D(-100,0,-100));
		Sphere s1 = new Sphere(Color.green , 30 ,new Point3D(-50,5,-100));
		Sphere s2 = new Sphere(Color.green , 25 ,new Point3D(0,10,-100));
		Sphere s3 = new Sphere(Color.green , 30 ,new Point3D(50,5,-100));
		Sphere s4 = new Sphere(Color.green , 40 ,new Point3D(100,0,-100));
		Scene sc =new Scene();
		sc.addGeometry(s);
		sc.addGeometry(s1);
		sc.addGeometry(s2);
		sc.addGeometry(s3);
		sc.addGeometry(s4);
		ImageWriter iw = new ImageWriter("renderImageTest2",500,500,500,500);
		Render r = new Render(sc,iw);
		r.renderImage();
		r.printGrid(10);
		iw.writeToimage();
	}
	
	@Test
	public void renderImageOurOwnLight2() 
	{
		Scene scene = new Scene();
		//scene.set_screenDistance(10);
		Triangle triangle = new Triangle(new Color(255, 200, 200),new Point3D( 5,  0, -10),
				 new Point3D( 5, 10, -10),
				 new Point3D(  -5, 10, -10));
		Triangle triangle1 = new Triangle(new Color(200, 200, 255),new Point3D( -5,  10, -10),
				 new Point3D( 5, 0, -10),
				 new Point3D( -5, 0, -10));
		Triangle triangle2 = new Triangle(new Color(200, 255, 200),new Point3D( 5,  0, -10),
				 new Point3D( 6, 3, -10),
				 new Point3D(  6, 13, -10));
		Triangle triangle3 = new Triangle(new Color(200, 200, 200),new Point3D( 5,  0, -10),
				 new Point3D( 5, 10, -10),
				 new Point3D(  6, 13, -10));
		scene.addGeometry(triangle);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		ImageWriter imageWriter = new ImageWriter("OurOwnLightTest2", 700, 700, 700, 700);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
	}
	
	@Test
	public void renderImageOurOwnLight() 
	{
		Sphere s = new Sphere(new Color(75, 102, 0) , 40 ,new Point3D(-100,10,-100));
		Sphere s1 = new Sphere(new Color(112, 153, 0) , 30 ,new Point3D(-50,10,-100));
		Sphere s2 = new Sphere(new Color(168, 230, 0) , 25 ,new Point3D(0,10,-100));
		Sphere s3 = new Sphere(new Color(112, 153, 0), 30 ,new Point3D(50,10,-100));
		Sphere s4 = new Sphere(new Color(75, 102, 0) , 40 ,new Point3D(100,10,-100));
		s.get_material().set_nShininess(20);
		s1.get_material().set_nShininess(20);
		s2.get_material().set_nShininess(20);
		s3.get_material().set_nShininess(20);
		s4.get_material().set_nShininess(20);
		Scene sc =new Scene();
		sc.addGeometry(s);
		sc.addGeometry(s1);
		sc.addGeometry(s3);
		sc.addGeometry(s4);
		sc.addGeometry(s2);
		sc.set_background(new Color(201, 177, 131));
		//point originally was 200 200 100
		sc.addLight(new PointLight(new Color(255, 255, 255), new Point3D(0, 10, -100), 
					   0, 0.000001, 0.0000005));
		
		sc.addLight(new PointLight(new Color(255, 255, 255), new Point3D(0, 10, -100), 
				   0, 0.000001, 0.0000005));
		
		ImageWriter imageWriter = new ImageWriter("OurOwnLightTest", 700, 700, 700, 700);
		
		Render render = new Render(sc,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
	}
	
	@Test
	public void renderImagePointLight2() 
	{

		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100),800, new Point3D(0.0, 0.0, -1000));
		sphere.get_material().set_nShininess(20);
		
		Triangle triangle = new Triangle(new Color(0, 54, 54),new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0, 45, 45),new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("PointLightTest2", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
	}
	
	@Test
	public void renderImageSpotLight() 
	{
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100),800, new Point3D(0.0, 0.0, -1000));
		sphere.get_material().set_nShininess(20);
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
									 0, 0.00001, 0.000005,new Vector(2, 2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("SpotLightTest", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
	}
	
	@Test
	public void renderImagePointLight() 
	{
		Scene scene = new Scene();
		Sphere sphere = new Sphere (new Color(0, 0, 100),800, new Point3D(0.0, 0.0, -1000));
		sphere.get_material().set_nShininess(20);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
					   0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("PointLightTest", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
	}
	
	@Test
	public void spotLightTest2(){
		
		Scene scene = new Scene();
		scene.set_screenDistance(200);
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Material(1,1,20), 500, new Point3D(0.0, 0.0, -1000));
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100), new Material(1,1,4), new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270));
		
		scene.addGeometry(triangle);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("NEED TO CHECK!!!", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
	
	
	}
	
	@Test
	public void spotLightTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,20),800, new Point3D(0.0, 0.0, -1000));
		
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005,new Vector(2, 2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}

	 
	@Test
	public void pointLightTest(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),800, new Point3D(0.0, 0.0, -1000));
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
					   0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
		
		
	}
	
	@Test
	public void spotLightTest3(){
		
		Scene scene = new Scene();
		
		Triangle triangle = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005 ,new Vector(-2, -2, -3)));
	
		
		ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
	
	@Test
	public void pointLightTest2(){
		
		Scene scene = new Scene();
	//	Sphere sphere = new Sphere(new Color(0, 0, 100),new Material(1,1,20),800, new Point3D(0.0, 0.0, -1000));
	
		
		Triangle triangle = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0,0,0),new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					   0, 0.000001, 0.0000005));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
		
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
	public void finalTest(){
	Sphere s = new Sphere(new Color(0,0,100), 300, new Point3D(0,0,-350));
	s.get_material().set_kt(0.8);
	s.get_material().set_nShininess(20);
	Triangle t =new Triangle(new Color (50,0,45), new Point3D (0,0,-350),
							new Point3D(100,-200,-350), new Point3D (-100,-200,-350));
	
	
	Scene scene = new Scene();
	scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, -200, -50), 
			 0, 0.000001, 0.0000005,new Vector(-2, -2, -3)));
	scene.addGeometry(s);
	scene.addGeometry(t);
	
	ImageWriter imageWriter = new ImageWriter("final test", 500, 500, 500, 500);
	
	Render render = new Render(scene, imageWriter);
	
	render.renderImage();
	imageWriter.writeToimage();                        
	}
	
	@Test
	public void final2Test(){
	Sphere s = new Sphere(new Color(0,0,100), 200, new Point3D(0,-200,-350));
	//s.get_material().set_kt(0);
	s.get_material().set_kr(1);
	s.get_material().set_nShininess(20);
	Sphere s2 = new Sphere(new Color(255,255,102), 200, new Point3D(100,200,-300));
	s2.get_material().set_nShininess(20);

	//Triangle t =new Triangle(new Color (50,0,45), new Point3D (100,200,-300),
						//	new Point3D(100,100,-400), new Point3D (100,100,-200));
	
	
	Scene scene = new Scene();
	scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, -200, -50), 
			 0, 0.000001, 0.0000005,new Vector(-2, -2, -3)));
	scene.addGeometry(s);
	//scene.addGeometry(t);
	scene.addGeometry(s2);
	ImageWriter imageWriter = new ImageWriter("final test 2", 500, 500, 500, 500);
	
	Render render = new Render(scene, imageWriter);
	
	render.renderImage();
	imageWriter.writeToimage();                        
	}
}
