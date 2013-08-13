import static org.junit.Assert.*;

import org.junit.Test;


@SuppressWarnings("unused")
public class TestRubiksCube {

	@Test
	public void testRotateRight() {
		RubiksCube rc = new RubiksCube();
		
		rc.printCube();
		rc.rotateRight();
		System.out.println("\n");
		rc.printCube();
	}

}
