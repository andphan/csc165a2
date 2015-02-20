package a1;

import java.nio.*;

import sage.event.IEventListener;
import sage.event.IGameEvent;
import sage.scene.TriMesh;

public class myNewTriMesh extends TriMesh implements IEventListener{
	
	private float[] vrts = new float[]  {-1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 
			-1.0f, 0.0f, 1.0f, 1.0f, 0.0f, }; // create new verticies keep on messing around with this
//	private int[] tri = new int[] {0,1,2,0,2,3,0,3,4,0,4,1,1,4,2,4,3,2};
//	private int[] tri = new int[] {0,1,2,1,1,1,0,1,1,0,1,1,1,1,2,1,1,1};
	private int[] tri = new int[] {1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1};
		
	public myNewTriMesh()
	{
		FloatBuffer vertBuf = com.jogamp.common.nio.Buffers.newDirectFloatBuffer(vrts);
		IntBuffer triBuf = com.jogamp.common.nio.Buffers.newDirectIntBuffer(tri);
	
		this.setVertexBuffer(vertBuf);
		this.setIndexBuffer(triBuf);
		
	}

	public boolean handleEvent(IGameEvent e) {
		CrashEvent c = (CrashEvent) e;
		int crashInc = c.getCrash();
		
		if (crashInc % 2 == 0)
		{
			System.out.println("Scale up this trimesh!");
		}
		else
		{
			System.out.println("Scale down this trimesh??");
		}
		return true;
	}
	
}
