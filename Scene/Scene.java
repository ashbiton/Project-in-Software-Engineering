package Scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import geometries.*;
import elements.*;

public class Scene {
	private String _sceneName;
	private Color _background;
	private Camera _camera;
	private double _screenDistance;
	private ArrayList<LightSource> _lights;
	private ArrayList<Geometry> geometries;
	private AmbientLight _ambientLight;
	
	// ***************** Constructors ********************** //
	
	public Scene() {
		super();
		_sceneName= "";
		_background= Color.black;
		_camera = new Camera();
		_screenDistance = 100;
		_lights = new ArrayList<LightSource>();
		geometries = new ArrayList<Geometry>();
		_ambientLight = new AmbientLight();
	}

	public Scene(String _sceneName, Color _background, Camera _camera,
			double _screenDistance, ArrayList<LightSource> _lights,
			ArrayList<Geometry> geometries, AmbientLight _ambientLight) {
		super();
		this._sceneName = _sceneName;
		this._background = _background;
		this._camera = _camera;
		this._screenDistance = _screenDistance;
		this._lights = _lights;
		this.geometries = geometries;
		this._ambientLight = _ambientLight;
	}

	public Scene (Scene _scene)
	{
		super();
		this._sceneName = _scene._sceneName;
		this._background = _scene._background;
		this._camera = new Camera(_scene._camera);
		this._screenDistance = _scene._screenDistance;
		this.geometries = new ArrayList<Geometry>(_scene.getGeometries());
		this._lights = new ArrayList<LightSource>(_scene.get_lights());
		this._ambientLight = new AmbientLight(_scene._ambientLight);
	}

	// ***************** Getters/Setters ********************** // 

	

	public String get_sceneName() {
		return _sceneName;
	}

	public void set_sceneName(String _sceneName) {
		this._sceneName = _sceneName;
	}

	public Color get_background() {
		return _background;
	}

	public void set_background(Color _background) {
		this._background = _background;
	}

	public Camera get_camera() {
		return _camera;
	}

	public void set_camera(Camera _camera) {
		this._camera = _camera;
	}

	public double get_screenDistance() {
		return _screenDistance;
	}

	public void set_screenDistance(double _screenDistance) {
		this._screenDistance = _screenDistance;
	}

	public ArrayList<Geometry> getGeometries() {
		return geometries;
	}

	public void setGeometries(ArrayList<Geometry> geometries) {
		this.geometries = geometries;
	}	
	
	public AmbientLight get_ambientLight() {
		return new AmbientLight(_ambientLight);
	}

	public void set_ambientLight(AmbientLight _ambientLight) {
		this._ambientLight = _ambientLight;
	}
	
	public ArrayList<LightSource> get_lights() {
		return _lights;
	}

	public void set_lights(ArrayList<LightSource> _lights) {
		this._lights = _lights;
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
		Scene other = (Scene) obj;
		if (_ambientLight == null) {
			if (other._ambientLight != null)
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_background == null) {
			if (other._background != null)
				return false;
		} else if (!_background.equals(other._background))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_lights == null) {
			if (other._lights != null)
				return false;
		} else if (!_lights.equals(other._lights))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double
				.doubleToLongBits(other._screenDistance))
			return false;
		if (geometries == null) {
			if (other.geometries != null)
				return false;
		} else if (!geometries.equals(other.geometries))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _background="
				+ _background + ", _camera=" + _camera + ", _screenDistance="
				+ _screenDistance + ", _lights=" + _lights + ", geometries="
				+ geometries + ", _ambientLight=" + _ambientLight + "]";
	}
	
	public void addGeometry (Geometry g)
	{
		geometries.add(g);
	}

	public Iterator<Geometry> getGeomeriesIterator()
	{
		return geometries.iterator();
	}
	
	public Iterator<LightSource> getLightsIterator()
	{
		return _lights.iterator();
	}

	public void addLight(LightSource light) 
	{
		_lights.add(light);
	}

	

}
