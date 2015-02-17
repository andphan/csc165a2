package a1;
import sage.app.BaseGame;
import sage.camera.*;
import sage.display.*;
import sage.event.EventManager;
import sage.event.IEventManager;
import sage.input.*;
import sage.input.action.*;
import sage.scene.*;
import sage.scene.shape.*;
import graphicslib3D.Matrix3D;
import graphicslib3D.Point3D;

import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import java.nio.*;
import java.text.DecimalFormat;

import net.java.games.input.Controller;
import net.java.games.input.*;


public class treasurehunt2015 extends BaseGame {
	// what type of objects are in the game
	// world
	// player
	// treasures
	// treasure chest
	Rectangle rect1;
	Sphere sph;
	Cylinder cyl;
	IDisplaySystem display;
	ICamera camera;
	IInputManager im;
	IEventManager em;
	int numHit;
	private int score = 0;
	private float time = 0;
	
		public void initGame() // override
		{	
			IInputManager im = getInputManager();
			em = EventManager.getInstance();
			// initialize Managers
			System.out.println("initGame call");
			initGameObjects();	
			
			String kbName = im.getKeyboardName();
			String gpName = im.getFirstGamepadName();
			
			// create keyboard actions
			IAction quitGame = new QuitGameAction(this);
		/*	IAction moveForward = new ForwardCameraMovement(camera, 0.01f);
			IAction moveBack = new BackCameraMovement();
			IAction moveLeft = new LeftCameraMovement();
			IAction moveRight = new RightCameraMovement();
			IAction rotateUp = new RotateUpCamera();
			IAction rotateDown = new RotateDownCamera();
			IAction rotateLeft = new RotateLeftCamera();
			IAction rotateRight = new RotateRightCamera();
			*/
			// create game controller actions
			
	//		IAction controllerX = new XAxisMovement();
	//		IAction controllerY = new YAxisMovement();
	//		IAction controllerRX = new RXAxisMovement();
	//		IAction controllerRY = new RYAxisMovement();
		
			
			// Associate actions
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.W, moveForward, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.S, moveBackward, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);			
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.A, moveLeft, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.D, moveRight, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.LEFT, rotateLeft, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.RIGHT, rotateRight, 
	//			IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.Up, rotateUp, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
	//		im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.Down, rotateDown, 
	//				IInputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);	
			im.associateAction(kbName, net.java.games.input.Component.Identifier.Key.ESCAPE, quitGame, 
					IInputManager.INPUT_ACTION_TYPE.ON_PRESS_ONLY);
		}
			
		public void initGameObjects()
		{
			display = getDisplaySystem();
			display.setTitle("Treasure Hunt 2015");
			
			// testing out camera
			camera = display.getRenderer().getCamera();
			camera.setPerspectiveFrustum(45, 1, 0.01, 1000);
			camera.setLocation(new Point3D(1, 1, 20));
			
			
			// 	create new objects by using scale()
			Random rng = new Random();
			 rect1 = new Rectangle();
			rect1.scale(1, 2, 2);
			rect1.translate(rng.nextFloat(), rng.nextFloat(), 0);
			addGameWorldObject(rect1);
			
			sph = new Sphere();
			sph.scale(.05f, 0.5f, 1);
			sph.translate(rng.nextFloat(), rng.nextFloat(), 0);
			addGameWorldObject(sph);
			
			cyl = new Cylinder();
			cyl.scale(.05f, 05.f, 0);
			cyl.translate(rng.nextFloat(), rng.nextFloat(), 0);
			addGameWorldObject(cyl);
			
			// SAGE Cube - increase ... by using event handling system
			// event class extends AbstractGameVent
			// IEventListener
			// detecting collision
			// 
			// triMesh
			myNewTriMesh myT = new myNewTriMesh();
			addGameWorldObject(myT);
			// treasureChest
			
		}
		public void update(float ElapsedTimeMS)
		{
			// overwritten
			// update score
			if (rect1.getWorldBound().contains(camera.getLocation()))
			{
				numHit++;
				score++; // add 1 to score
		//		CrashEvent newCrash = new CrashEvent(numHit);
		//		em.triggerEvent(newCrash);
			}
			// do this for sphere, cylinder
			// when crash event happens, treasurechest increase size.
			
			// move camera
			
		}
		
	}
