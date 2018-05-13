package UnitTests;

import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;

public class ImageWriterTest {
	
	@Test
	public void writePixel1()
	{
		ImageWriter iw = new ImageWriter("writePixel1",100,100,10,10);
		for (int i=0 ; i<100; i+=10)
			for(int j=0; j<100; j++)
			{
				iw.writePixel(i, j, Color.blue);
				iw.writePixel(j, i, Color.blue);
			}
		for (int i=1 ; i<10; i++)
			for(int j=1; j<10; j++)
			{
				iw.writePixel(i, j,255,0,0);
			}
		iw.writeToimage();
	}
	
	@Test
	public void writePixel2()
	{
		ImageWriter iw = new ImageWriter("writePixel2",100,100,10,10);
		for (int i=0 ; i<100; i+=10)
			for(int j=0; j<100; j++)
			{
				iw.writePixel(i, j, Color.orange);
				iw.writePixel(j, i, Color.orange);
			}
		int [] rgbArray = {120,30,120};
		for (int i=1 ; i<10; i++)
			for(int j=1; j<10; j++)
			{
				iw.writePixel(i, j,rgbArray);
			}
		iw.writeToimage();
	}
	
	@Test
	public void writePixel3()
	{
		ImageWriter iw = new ImageWriter("writePixel3",100,100,10,10);
		for (int i=0 ; i<100; i+=10)
			for(int j=0; j<100; j++)
			{
				iw.writePixel(i, j, Color.white);
				iw.writePixel(j, i, Color.white);
			}
		iw.writeToimage();
	}

}
