import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.List;
//import java.util.stream.Stream;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Points implements GLEventListener {

	private GLU glu;

	@Override
	public void init(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		glu = new GLU();

		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glViewport(-250, -150, 250, 150);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
	}

	@Override
	public void dispose(GLAutoDrawable glad) {

	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		gl.glPointSize(14.0f);
		gl.glColor3d(1, 0, 0);

		gl.glBegin(GL2.GL_LINES);

		// gl.glVertex3f(10.0f, 10.0f, 0);

		List<String> st;
        try {
            st = Files.readAllLines(Path.of("E:\\Eclipse Codings\\CSE423Lab\\src\\input.txt"));
            for (String s:st) {
            	String [] str = s.split(", ");
            	float d1=Float.parseFloat(str[0]);
            	float d2=Float.parseFloat(str[1]);
            	gl.glVertex3f(d1, d2, 0);
            }

        } catch (IOException e) {
            System.out.println("Error found :(");
        }

		gl.glEnd();
		

  /*	//POINT
		gl.glBegin(GL2.GL_POINTS);
//		gl.glVertex2d(-20, -10);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glEnd();
		
		
			
		//LINES
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glVertex3f(10.0f, 50.0f, 0);
		gl.glEnd();

		
		//TRIANGLE
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glVertex3f(50.0f, 10.0f, 0);
		gl.glVertex3f(50.0f, 10.0f, 0);
		gl.glVertex3f(30.0f, 50.0f, 0);
		gl.glVertex3f(30.0f, 50.0f, 0);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glEnd();
		
//		gl.glBegin(GL2.GL_TRIANGLES);  //you get a solid triangle with only 3ta points :D
		
		
		//Quadruple or Quadrilateral
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glVertex3f(70.0f, 10.0f, 0);
		gl.glVertex3f(70.0f, 10.0f, 0);
		gl.glVertex3f(70.0f, 70.0f, 0);
		gl.glVertex3f(70.0f, 70.0f, 0);
		gl.glVertex3f(10.0f, 70.0f, 0);
		gl.glVertex3f(10.0f, 70.0f, 0);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glEnd();
		
		
		//POLYGON
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glVertex3f(40.0f, -30.0f, 0);
		gl.glVertex3f(40.0f, -30.0f, 0);
		gl.glVertex3f(70.0f, 10.0f, 0);
		gl.glVertex3f(70.0f, 10.0f, 0);
		gl.glVertex3f(70.0f, 70.0f, 0);
		gl.glVertex3f(70.0f, 70.0f, 0);
		gl.glVertex3f(10.0f, 70.0f, 0);
		gl.glVertex3f(10.0f, 70.0f, 0);
		gl.glVertex3f(10.0f, 10.0f, 0);
		gl.glEnd();
		
	//  gl.glBegin(GL2.GL_POLYGON); //gives a solid polygon
*/
		
	}

	@Override
	public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {

	}

}
