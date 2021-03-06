package a1;

import graphicslib3D.Point3D;
import graphicslib3D.Vector3D;
import sage.camera.ICamera;
import sage.input.action.AbstractInputAction;

public class ForwardCameraMovement extends AbstractInputAction {

	private ICamera camera;
	private MovementToggle m;
	public ForwardCameraMovement(ICamera c, MovementToggle t)
	{
		camera = c;
		m = t;

	}
	
	public void performAction(float timeElapsed, net.java.games.input.Event e)
	{
		
		float moveAmount;
		if (m.isMoving())
		{
			moveAmount = (float) 0.5;
		}
		else {
			moveAmount = (float) 0.1;
		}
		
		// create Vector3D
		
		Vector3D curLoc = new Vector3D(camera.getLocation());
		Vector3D viewDir = camera.getViewDirection().normalize();
		Vector3D newLoc = curLoc.add(viewDir.mult(moveAmount));
				
		// set to new vector
		double dx = newLoc.getX();
		double dy = newLoc.getY();
		double dz = newLoc.getZ();
		Point3D newPoint = new Point3D(dx, dy, dz);
		System.out.println("u " + newPoint.getX());
		System.out.println("v" + newPoint.getY());
		System.out.println("n " + newPoint.getZ());
		camera.setLocation(newPoint);
	}
}
