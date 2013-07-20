import java.util.ArrayList;

public class RubiksCube {

	public static void main(String[] args) {

		RubiksCube rc = new RubiksCube();

	} // main

	// structure of cube
	int[][][] cube = new int[6][3][3];
	// list to hold commands from input file
	ArrayList<String> commands = new ArrayList<String>();

	public RubiksCube() {
		/*
		 * constructs a cube with the colors as follows (numbers next to the
		 * faces are the indices and the numbers next to the colors are the
		 * numerical representations:
		 * 
		 * Up(0) - White(1)
		 * Down(1) - Yellow(2)
		 * Front(2) - Red(3)
		 * Back(3) - Orange(4)
		 * Left(4) - Green(5)
		 * Right(5) - Blue(6)
		 */

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cube[i][j][k] = i + 1;
				}
			}
		}
	}

	/*---------------------------------------------------------------------
	 |  Method rotateTop, rotateBottom, rotateFront, rotateBack, 
	 |			rotateLeft, rotateRight
	 |
	 |  Purpose:  Rotate one face of the cube in a clockwise direction. All 
	 |			  of these methods work under the premise that the faces are 
	 |			  stored in cube as such (numbers refer to the index of the 
	 |			  first dimension):
	 |
	 |			  0 - Up		3 - Back
	 |			  1 - Down 		4 - Left
	 |			  2 - Front 	5 - Right
	 |
	 |			  rotateFront is the only one of these methods that actually 
	 |			  does any rotation. The other methods work by using the 
	 |			  rotateCube methods to rotate the appropriate face to be 
	 |			  the front face, calling the rotateFront method, and then 
	 |			  rotating the cube back to its original position.
	 |
	 |			  For example, rotateTop first calls rotateCubeDown so that 
	 |			  the entire cube is rotated such that the top face becomes 
	 |			  the front face. The rotation is then performed on the front 
	 |			  face (which was originally the top face). Then, the method 
	 |			  calls rotateCubeUp so that the cube is returned to its 
	 |			  original position.
	 |
	 |			  rotateFront itself works by manually shifting the necessary 
	 |			  values from the cube array. All shifts are done by storing 
	 |			  one value in a temp variable and then moving values around 
	 |			  until the program gets to the index where it must store the 
	 |			  value held in the temp variable. It is essentially an 
	 |			  extension of the classic swap procedure. 
	 |
	 |			  First, the corners of the face are shifted. Then, the edges 
	 |			  of the face. Then, the facelets that connect to the face 
	 |			  being rotated but reside on other faces are shifted. For 
	 |			  example, when rotating the top face, the top row of the 
	 |			  front, back, left, and right faces are also rotated.
	 |
	 |  Pre-condition:  cube must be a 3D array full of ints
	 |
	 |  Post-condition: cube will have its values changed to reflect the 
	 |					rotation specified.
	 |
	 |  Parameters: 	None
	 |
	 |  Returns:  		None
	 *-------------------------------------------------------------------*/

	public void rotateTop() {
		rotateCubeDown();
		rotateFront();
		rotateCubeUp();
	}

	public void rotateBottom() {
		rotateCubeUp();
		rotateFront();
		rotateCubeDown();
	}

	public void rotateFront() {
		int temp;

		// rotate corners
		temp = cube[2][0][0];
		cube[2][0][0] = cube[2][2][0];
		cube[2][2][0] = cube[2][2][2];
		cube[2][2][2] = cube[2][0][2];
		cube[2][0][2] = temp;

		// rotate edges
		temp = cube[2][0][1];
		cube[2][0][1] = cube[2][1][0];
		cube[2][1][0] = cube[2][2][1];
		cube[2][2][1] = cube[2][1][2];
		cube[2][1][2] = temp;

		// rotate colors on edges and corners of other faces that connect
		// corner
		temp = cube[0][2][0];
		cube[0][2][0] = cube[4][0][2];
		cube[4][0][2] = cube[1][0][2];
		cube[1][0][2] = cube[5][0][2];
		cube[5][0][2] = temp;

		// edge
		temp = cube[0][2][1];
		cube[0][2][1] = cube[4][0][1];
		cube[4][0][1] = cube[1][0][1];
		cube[1][0][1] = cube[5][0][1];
		cube[5][0][1] = temp;

		// corner
		temp = cube[0][2][2];
		cube[0][2][2] = cube[4][0][0];
		cube[4][0][0] = cube[1][0][0];
		cube[1][0][0] = cube[5][0][0];
		cube[5][0][0] = temp;
	}

	public void rotateBack() {
		rotateCubeUp();
		rotateCubeUp();
		rotateFront();
		rotateCubeDown();
		rotateCubeDown();
	}

	public void rotateLeft() {
		rotateCubeRight();
		rotateFront();
		rotateCubeLeft();
	}

	public void rotateRight() {
		rotateCubeLeft();
		rotateFront();
		rotateCubeRight();
	}

	/*---------------------------------------------------------------------
	 |  Method rotateTopReverse, rotateBottomReverse, rotateFrontReverse, 
	 |			rotateBackReverse, rotateLeftReverse, rotateRightReverse
	 |
	 |  Purpose:  Rotate one face of the cube in a counter clockwise direction.
	 |			  All of these methods work under the premise that the faces 
	 |			  are stored in cube as such (numbers refer to the index of the 
	 |			  first dimension):
	 |
	 |			  0 - Up		3 - Back
	 |			  1 - Down 		4 - Left
	 |			  2 - Front 	5 - Right
	 |
	 |			  None of these methods contain algorithms to shift around 
	 |			  values in the cube array. Rather, they all work on two 
	 |			  premises: 1) a counter-clockwise rotation is the same 
	 |			  same as 3 clockwise rotations, and 2) any face can be 
	 |			  rotated by rotating the entire cube so the desired face 
	 |			  is facing the front, performing a front face rotation, 
	 |			  and then rotating the entire cube back to the original 
	 |			  position.
	 |
	 |			  Hence, rotateFrontReverse simply calls rotateFront 3 times. 
	 |			  All the other reverse rotations work by rotating the cube 
	 |			  so the desired face is in the front (same cube rotations 
	 |			  used in the corresponding clockwise rotation methods), and 
	 |			  then calling rotateFrontReverse.
	 |
	 |  Pre-condition:  cube must be full of integer values that represent 
	 |					the desired initial structure of the cube, per the 
	 |					input file.
	 |
	 |  Post-condition: The values in cube will be shifted to reflect the 
	 |					rotation performed.
	 |
	 |  Parameters: 	None
	 |
	 |  Returns:  		None
	 *-------------------------------------------------------------------*/

	public void rotateTopReverse() {
		rotateCubeDown();
		rotateFrontReverse();
		rotateCubeUp();
	}

	public void rotateBottomReverse() {
		rotateCubeUp();
		rotateFrontReverse();
		rotateCubeDown();
	}

	public void rotateFrontReverse() {
		// three clockwise front rotations
		rotateFront();
		rotateFront();
		rotateFront();
	}

	public void rotateBackReverse() {
		rotateCubeUp();
		rotateCubeUp();
		rotateFrontReverse();
		rotateCubeDown();
		rotateCubeDown();
	}

	public void rotateLeftReverse() {
		rotateCubeRight();
		rotateFrontReverse();
		rotateCubeLeft();
	}

	public void rotateRightReverse() {
		rotateCubeLeft();
		rotateFrontReverse();
		rotateCubeRight();
	}

	/*---------------------------------------------------------------------
	 |  Method rotateCubeUp, rotateCubeDown, rotateCubeLeft, rotateCubeRight
	 |
	 |  Purpose:  Rotate the entire cube in one of four directions (up, down, 
	 |			  left, or right) such that the structure of the cube isn't 
	 |			  changed, but rather only the ordering of which direction 
	 |			  each face is facing changes (to the program, this means 
	 |			  changing which index of the first dimension of the cube 
	 |			  array each face resides in).
	 |
	 |			  Only rotateCubeUp and rotateCubeLeft actually shift around 
	 |			  values in the cube array. rotateCubeDown simply calls 
	 |			  rotateCubeUp three times and rotateCubeRight simply calls 
	 |			  rotateCubeLeft three times.
	 |
	 |			  rotateCubeUp first swaps around the Up, Down, Front, and 
	 |			  Back faces so that the values in Up become the values in 
	 |			  Back, Back -> Down, Down -> Front, and Front -> Up.
	 |			  Then, the method finishes the cube rotation by performing 
	 |			  a clockwise shift on the right face (just the values on that 
	 |			  face, does not shift the values of the connecting facelets 
	 |			  over the corners and edges, hence why the rotateFront 
	 |			  method cannot be used here) and a counter clockwise rotation 
	 |			  on the left face.
	 |
	 |			  Similarly, rotateCubeLeft shifts the values around so that 
	 |			  Front -> Left, Left -> Back, Back -> Right, and 
	 |			  Right -> Front. Then, the values on the top face are rotated 
	 |			  clockwise and the bottom face is rotated counter-clockwise.
	 |
	 |  Pre-condition:  cube must be a 3D array full of integer values that 
	 |					represents the structure of the cube as per the input
	 |					file.
	 |
	 |  Post-condition: The values in cube will reflect the appropriate cube 
	 |					rotation. That is, the structure will be the same (all 
	 |					facelets next to the same facelets as before), but the 
	 |				 	direction that the faces are facing will have changed.
	 |
	 |  Parameters:		None
	 |      
	 |  Returns:  		None
	 *-------------------------------------------------------------------*/

	public void rotateCubeUp() {
		int temp;

		// U becomes B, F becomes U, D becomes F, B becomes D
		temp = cube[2][0][0];
		cube[2][0][0] = cube[1][0][0];
		cube[1][0][0] = cube[3][2][2];
		cube[3][2][2] = cube[0][0][0];
		cube[0][0][0] = temp;

		temp = cube[2][0][1];
		cube[2][0][1] = cube[1][0][1];
		cube[1][0][1] = cube[3][2][1];
		cube[3][2][1] = cube[0][0][1];
		cube[0][0][1] = temp;

		temp = cube[2][0][2];
		cube[2][0][2] = cube[1][0][2];
		cube[1][0][2] = cube[3][2][0];
		cube[3][2][0] = cube[0][0][2];
		cube[0][0][2] = temp;

		temp = cube[2][1][0];
		cube[2][1][0] = cube[1][1][0];
		cube[1][1][0] = cube[3][1][2];
		cube[3][1][2] = cube[0][1][0];
		cube[0][1][0] = temp;

		temp = cube[2][1][1];
		cube[2][1][1] = cube[1][1][1];
		cube[1][1][1] = cube[3][1][1];
		cube[3][1][1] = cube[0][1][1];
		cube[0][1][1] = temp;

		temp = cube[2][1][2];
		cube[2][1][2] = cube[1][1][2];
		cube[1][1][2] = cube[3][1][0];
		cube[3][1][0] = cube[0][1][2];
		cube[0][1][2] = temp;

		temp = cube[2][2][0];
		cube[2][2][0] = cube[1][2][0];
		cube[1][2][0] = cube[3][0][2];
		cube[3][0][2] = cube[0][2][0];
		cube[0][2][0] = temp;

		temp = cube[2][2][1];
		cube[2][2][1] = cube[1][2][1];
		cube[1][2][1] = cube[3][0][1];
		cube[3][0][1] = cube[0][2][1];
		cube[0][2][1] = temp;

		temp = cube[2][2][2];
		cube[2][2][2] = cube[1][2][2];
		cube[1][2][2] = cube[3][0][0];
		cube[3][0][0] = cube[0][2][2];
		cube[0][2][2] = temp;

		// rotate left face counter clockwise
		// corners
		temp = cube[4][2][0];
		cube[4][2][0] = cube[4][0][0];
		cube[4][0][0] = cube[4][0][2];
		cube[4][0][2] = cube[4][2][2];
		cube[4][2][2] = temp;
		// edges
		temp = cube[4][1][0];
		cube[4][1][0] = cube[4][0][1];
		cube[4][0][1] = cube[4][1][2];
		cube[4][1][2] = cube[4][2][1];
		cube[4][2][1] = temp;

		// rotate right face clockwise
		// corners
		temp = cube[5][0][2];
		cube[5][0][2] = cube[5][0][0];
		cube[5][0][0] = cube[5][2][0];
		cube[5][2][0] = cube[5][2][2];
		cube[5][2][2] = temp;
		// edges
		temp = cube[5][1][2];
		cube[5][1][2] = cube[5][0][1];
		cube[5][0][1] = cube[5][1][0];
		cube[5][1][0] = cube[5][2][1];
		cube[5][2][1] = temp;
	}

	public void rotateCubeDown() {
		// three up cube rotations
		rotateCubeUp();
		rotateCubeUp();
		rotateCubeUp();
	}

	public void rotateCubeLeft() {
		int temp;

		// L becomes B, B becomes R, R becomes F, F becomes L
		temp = cube[2][0][0];
		cube[2][0][0] = cube[5][0][2];
		cube[5][0][2] = cube[3][0][0];
		cube[3][0][0] = cube[4][2][0];
		cube[4][2][0] = temp;

		temp = cube[2][0][1];
		cube[2][0][1] = cube[5][1][2];
		cube[5][1][2] = cube[3][0][1];
		cube[3][0][1] = cube[4][1][0];
		cube[4][1][0] = temp;

		temp = cube[2][0][2];
		cube[2][0][2] = cube[5][2][2];
		cube[5][2][2] = cube[3][0][2];
		cube[3][0][2] = cube[4][0][0];
		cube[4][0][0] = temp;

		temp = cube[2][1][0];
		cube[2][1][0] = cube[5][0][1];
		cube[5][0][1] = cube[3][1][0];
		cube[3][1][0] = cube[4][2][1];
		cube[4][2][1] = temp;

		temp = cube[2][1][1];
		cube[2][1][1] = cube[5][1][1];
		cube[5][1][1] = cube[3][1][1];
		cube[3][1][1] = cube[4][1][1];
		cube[4][1][1] = temp;

		temp = cube[2][1][2];
		cube[2][1][2] = cube[5][2][1];
		cube[5][2][1] = cube[3][1][2];
		cube[3][1][2] = cube[4][0][1];
		cube[4][0][1] = temp;

		temp = cube[2][2][0];
		cube[2][2][0] = cube[5][0][0];
		cube[5][0][0] = cube[3][2][0];
		cube[3][2][0] = cube[4][2][2];
		cube[4][2][2] = temp;

		temp = cube[2][2][1];
		cube[2][2][1] = cube[5][1][0];
		cube[5][1][0] = cube[3][2][1];
		cube[3][2][1] = cube[4][1][2];
		cube[4][1][2] = temp;

		temp = cube[2][2][2];
		cube[2][2][2] = cube[5][2][0];
		cube[5][2][0] = cube[3][2][2];
		cube[3][2][2] = cube[4][0][2];
		cube[4][0][2] = temp;

		// rotate U(0) clockwise
		// corners
		temp = cube[0][0][0];
		cube[0][0][0] = cube[0][2][0];
		cube[0][2][0] = cube[0][2][2];
		cube[0][2][2] = cube[0][0][2];
		cube[0][0][2] = temp;
		// edges
		temp = cube[0][0][1];
		cube[0][0][1] = cube[0][1][0];
		cube[0][1][0] = cube[0][2][1];
		cube[0][2][1] = cube[0][1][2];
		cube[0][1][2] = temp;

		// rotate D(1) counter clockwise
		// corners
		temp = cube[1][0][0];
		cube[1][0][0] = cube[1][0][2];
		cube[1][0][2] = cube[1][2][2];
		cube[1][2][2] = cube[1][2][0];
		cube[1][2][0] = temp;
		// edges
		temp = cube[1][0][1];
		cube[1][0][1] = cube[1][1][2];
		cube[1][1][2] = cube[1][2][1];
		cube[1][2][1] = cube[1][1][0];
		cube[1][1][0] = temp;
	}

	public void rotateCubeRight() {
		// three cube left rotations
		rotateCubeLeft();
		rotateCubeLeft();
		rotateCubeLeft();
	}

	public void scrambleCube() {
		int calledStatement;
		for (int i = 0; i < 100; i++) {
			calledStatement = (int) Math.random() * 17;
			switch (calledStatement) {
				case 1:
					rotateTop();
					break;
				case 2:
					rotateBottom();
					break;
				case 3:
					rotateFront();
					break;
				case 4:
					rotateBack();
					break;
				case 5:
					rotateLeft();
					break;
				case 6:
					rotateRight();
					break;
				case 7:
					rotateTopReverse();
					break;
				case 8:
					rotateBottomReverse();
					break;
				case 9:
					rotateFrontReverse();
					break;
				case 10:
					rotateBackReverse();
					break;
				case 11:
					rotateLeftReverse();
					break;
				case 12:
					rotateRightReverse();
					break;
				case 13:
					rotateCubeUp();
					break;
				case 14:
					rotateCubeDown();
					break;
				case 15:
					rotateCubeLeft();
					break;
				case 16:
					rotateCubeRight();
					break;
				default:
					System.err.println("Random number out of range");
			}
		}

	}

	public boolean isCubeComplete() {
		for (int a = 0; a < 6; a++) {
			for (int b = 0; b < 3; b++) {
				for (int c = 0; c < 3; c++) {
					if (cube[a][b][c] != cube[a][1][1])
						return false;
				}
			}
		}
		return true;
	}
} // class RubiksCube