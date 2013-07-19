/*
 * ==========================================================================
 * === | Assignment: Program #1: Rubik's Cube | Program: RubiksCube.java |
 * Author: Gaurav Mangal (gmangal@email.arizona.edu) | Grader: | | Course:
 * CSC 345 | Instructor: Lisa Peairs | Due Date: July 10, 2013, 11:59 p.m.
 * | | Description: This program implements a 3x3 Rubik's Cube. This
 * program is | not a cube solver. It reads an initial state from an input
 * | file. The first part of an input file tells the program the | initial
 * state of the cube. This is stored in a 3D array of | ints. The first
 * dimension of the array represents the 6 | faces of the cube. The second
 * and third dimensions represent | the 9 facelets of each face in a 3x3
 * array. Following the | integers, the file may optionally contain String
 * commands | to be interpreted by the program as rotations to the cube. |
 * Each command should be on its own line in the input file. | These
 * strings are stored in an ArrayList. | | main uses a switch statement to
 * interpret each String | command. Since the commands are read line by
 * line, if there | is more than one command on a line, the program will
 * not | recognize it as matching a case in the switch statement, | and
 * therefore throw an error. | | After reading the input and performing any
 * specified | commands, the program writes the resulting state of the cube
 * | to the output file. Both the input and output files are | specified by
 * the user as command line arguments. | | First dimension of array
 * represents a specific face. | face 0 - Up, face 1 - Down/Bottom, face 2
 * - Front, | face 3 - Back, face 4 - Left, face 5 - Right | | 2nd and 3rd
 * dimensions of the array hold the color of the | facelet. | 1 - White, 2
 * - Yellow, 3 - Red, | 4 - Orange, 5 - Green, 6 - Blue | | Imports:
 * java.io.BufferedReader | java.io.BufferedWriter | java.io.File |
 * java.io.FileReader | java.io.FileWriter | java.io.IOException |
 * java.util.ArrayList | java.util.Scanner | | Instance Vars: cube - 3D
 * array of ints of size [6][3][3]. Represents the | Rubik's cube. |
 * commands - ArrayList of Strings that holds any commands read | from the
 * input file. These commands are interpreted as | cube rotations by the
 * program. | | Operational | Requirements: Program is written in Java and
 * must be compiled using a Java | compiler. When run, the program requires
 * two arguments. The | first argument is the name of the input file. The
 * filename | must exist in the same directory as the java program. The |
 * output filename must be provided as the second command line | argument.
 * However, the filename need not exist in the | current directory. If it
 * does exist, the file will be | overwritten by the program. If it does
 * not exist, it will be | created and then written to by the program. | |
 * Deficiencies: No known deficiencies
 * ======================================
 * =====================================
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RubiksCube
{
  
  public static void main(String[] args)
  {
    
    // check if input file arg exists
    if (args[0] == null)
    {
      System.err.println("No input file specified");
      System.exit(1);
    }
    // check if output file arg exists
    if (args[1] == null)
    {
      System.err.println("No output file specified");
      System.exit(1);
    }
    
    RubiksCube rc = new RubiksCube();
    
    rc.readCube(args[0]);
    
    // switch through all strings in command ArrayList. Note, at this
    // point, commands can have both valid and invalid commands. The
    // default case handles invalid commands
    for (String s : rc.commands)
    {
      switch (s)
      {
        case "topcw":
          rc.rotateTop();
          break;
        case "topccw":
          rc.rotateTopReverse();
          break;
        case "bottomcw":
          rc.rotateBottom();
          break;
        case "bottomccw":
          rc.rotateBottomReverse();
          break;
        case "frontcw":
          rc.rotateFront();
          break;
        case "frontccw":
          rc.rotateFrontReverse();
          break;
        case "backcw":
          rc.rotateBack();
          break;
        case "backccw":
          rc.rotateBackReverse();
          break;
        case "leftcw":
          rc.rotateLeft();
          break;
        case "leftccw":
          rc.rotateLeftReverse();
          break;
        case "rightcw":
          rc.rotateRight();
          break;
        case "rightccw":
          rc.rotateRightReverse();
          break;
        case "cubeup":
          rc.rotateCubeUp();
          break;
        case "cubedown":
          rc.rotateCubeDown();
          break;
        case "cubeleft":
          rc.rotateCubeLeft();
          break;
        case "cuberight":
          rc.rotateCubeRight();
          break;
        default:
          System.err.println(s + " is not a valid command");
          
      }
    }
    
    rc.writeCube(args[1]);
    
  } // main
  
  // structure of cube
  int[][][] cube = new int[6][3][3];
  // list to hold commands from input file
  ArrayList<String> commands = new ArrayList<String>();
  
  /*---------------------------------------------------------------------
   |  Method readCube
   |
   |  Purpose:  Read input from the file specified as the parameter. The 
   |			input tells the program the initial structure of the cube 
   |			using 54 integers (one for each facelet). If there are more 
   |			or less than 54 integers, the program prints an error message 
   |			and exits. Additionally, if it reads an integer that is not 
   |			between 1 and 6 (inclusive), it prints out an error message. 
   |			Only the numbers 1 through 6 correspond to colors in this 
   |			program. After the integers, the input file may have 
   |			commands as strings that tell the program what rotations to 
   |			perform on the cube. Each command should be on a separate line.
   |
   |			This method uses a Scanner to read through the file. It makes 
   |			sure that the first 54 things read are integers. After 54 
   |			integers have been read, anything remaining in the file is added 
   |			to the commands ArrayList. These are added as String 
   |			representations of an entire line at a time.
   |
   |  Pre-condition:  cube must be a declared 3D array of ints, commands 
   |			must be a declared ArrayList<String>
   |
   |  Post-condition: cube will contain integers to represent a full 
   |			Rubiks cube and commands will contain any commands in the 
   |			input file as Strings
   |
   |  Parameters:
   |      String input -- name of the file containing the input numbers 
   |			for the initial cube's setup, and any commands to be executed
   |			afterwards.
   |
   |  Returns:  None
   *-------------------------------------------------------------------*/
  public void readCube(String input)
  {
    
    // Scanner used to iterate through the file
    Scanner s = null;
    // count keeps track of how many integers have been read from the file
    int count = 0;
    // i, j, k used to index the cube array
    int i = 0;
    int j = 0;
    int k = 0;
    // temporary variable to hold the parsed form of each number read
    int parsedNum;
    // current is a temporary variable to hold the String read by Scanner
    String current;
    
    // try catch block to catch errors when reading the file
    try
    {
      s = new Scanner(new BufferedReader(new FileReader(input)));
      
      while (s.hasNext())
      {
        // try to parse an Integer until 54 ints have been read
        if (count < 54)
        {
          current = s.next();
          // try catch block to catch errors when parsing
          // String to int
          try
          {
            parsedNum = Integer.parseInt(current);
            // check if the number represents a valid color
            if (parsedNum >= 1 && parsedNum <= 6)
              cube[i][j][k] = parsedNum;
            else
            {
              System.err.println("Invalid integer input. "
                  + "Integers must be between " + "1 and 6 inclusive.");
              System.exit(2);
            }
            // getting to here means an integer was successfully
            // read. In this case, increment indexes and increment
            // count
            k++;
            if (k > 2)
            {
              k = 0;
              j++;
            }
            if (j > 2)
            {
              j = 0;
              i++;
            }
            count++;
          }
          catch (NumberFormatException ex)
          {
            System.err.println("Invalid integer input. There "
                + "must be exactly 54 integers between 1 "
                + "and 6 inclusive");
            System.exit(2);
          }
        }
        else
        {
          // 54 integers have been read. Everything else gets added
          // to the commands ArrayList. Note: Even invalid commands
          // are added to the list. The switch statement in main
          // checks for valid and invalid commands
          current = s.nextLine().trim();
          // check for blank lines by trimming and then checking
          // the length. Don't add blank lines to the commands list
          if (current.length() == 0) continue;
          commands.add(current);
        }
      }
      
      // check to make sure file didn't have less than 54 numbers
      if (count < 54)
      {
        System.err.println("Not enough numbers");
        System.exit(2);
      }
      
      // check to make sure there are 9 of each color
      // variables hold the count of each number found when iterating
      // through the entire 3D array
      int count1 = 0;
      int count2 = 0;
      int count3 = 0;
      int count4 = 0;
      int count5 = 0;
      int count6 = 0;
      
      for (int a = 0; a < 6; a++)
      {
        for (int b = 0; b < 3; b++)
        {
          for (int c = 0; c < 3; c++)
          {
            switch (cube[a][b][c])
            {
              case 1:
                count1++;
                break;
              case 2:
                count2++;
                break;
              case 3:
                count3++;
                break;
              case 4:
                count4++;
                break;
              case 5:
                count5++;
                break;
              case 6:
                count6++;
                break;
              default:
                // there shouldn't be any invalid integers at
                // this point, but check anyway
                System.err.println("Invalid integer input. There "
                    + "must be exactly 54 integers between 1 "
                    + "and 6 inclusive");
                System.exit(2);
            }
          }
        }
      }
      
      // if there are more or less than 9 of any number, something is
      // wrong with the input
      if (count1 != 9 || count2 != 9 || count3 != 9 || count4 != 9
          || count5 != 9 || count6 != 9)
      {
        System.err.println("Invalid input. Must have exactly 9 of "
            + "each integer 1 through 6 inclusive");
        System.exit(2);
      }
      
      // close Scanner along with input streams
      s.close();
    }
    catch (Exception e)
    {
      System.err.println(e);
      System.exit(1);
    }
    
  }
  
  /*---------------------------------------------------------------------
   |  Method writeCube
   |
   |  Purpose:  Write the structure of the cube to the file specified in 
   | 			the parameter. If the file does not exist, this method creates 
   |			it in the current directory. Then, using a BufferedWriter, it 
   |			iterates through each element of the cube array and writes 
   |			each one to the file.
   |
   |			Note that the order in which the cube is written is the same 
   |			as the order in which it is read from the input file.
   |
   |  Pre-condition:  cube is a 3D array filled with integers to represent 
   |			the structure of the Rubiks cube. This structure has already 
   |			been read from an input file and rotations have been performed 
   |			based on commands in the input file (may or may not exist).
   |
   |  Post-condition: The structure of the cube after all the commands have 
   |			been performed will be written to the output file specified 
   |			by the parameter (parameter comes from the command line).
   |
   |  Parameters:
   |      String output -- name of file to write the cube structure to.
   |
   |  Returns:  None
   *-------------------------------------------------------------------*/
  public void writeCube(String output)
  {
    try
    {
      File file = new File(output);
      // create file is it doesn't exist in the current directory
      if (!file.exists()) file.createNewFile();
      
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      
      // iterate through cube and write each value to the file
      for (int i = 0; i < 6; i++)
      {
        for (int j = 0; j < 3; j++)
        {
          for (int k = 0; k < 3; k++)
          {
            bw.write(cube[i][j][k] + " ");
          }
          // newline after every 3 numbers
          bw.write("\n");
        }
      }
      
      // close BufferedWriter
      bw.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
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
  
  public void rotateTop()
  {
    rotateCubeDown();
    rotateFront();
    rotateCubeUp();
  }
  
  public void rotateBottom()
  {
    rotateCubeUp();
    rotateFront();
    rotateCubeDown();
  }
  
  public void rotateFront()
  {
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
  
  public void rotateBack()
  {
    rotateCubeUp();
    rotateCubeUp();
    rotateFront();
    rotateCubeDown();
    rotateCubeDown();
  }
  
  public void rotateLeft()
  {
    rotateCubeRight();
    rotateFront();
    rotateCubeLeft();
  }
  
  public void rotateRight()
  {
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
  
  public void rotateTopReverse()
  {
    rotateCubeDown();
    rotateFrontReverse();
    rotateCubeUp();
  }
  
  public void rotateBottomReverse()
  {
    rotateCubeUp();
    rotateFrontReverse();
    rotateCubeDown();
  }
  
  public void rotateFrontReverse()
  {
    // three clockwise front rotations
    rotateFront();
    rotateFront();
    rotateFront();
  }
  
  public void rotateBackReverse()
  {
    rotateCubeUp();
    rotateCubeUp();
    rotateFrontReverse();
    rotateCubeDown();
    rotateCubeDown();
  }
  
  public void rotateLeftReverse()
  {
    rotateCubeRight();
    rotateFrontReverse();
    rotateCubeLeft();
  }
  
  public void rotateRightReverse()
  {
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
  
  public void rotateCubeUp()
  {
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
  
  public void rotateCubeDown()
  {
    // three up cube rotations
    rotateCubeUp();
    rotateCubeUp();
    rotateCubeUp();
  }
  
  public void rotateCubeLeft()
  {
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
  
  public void rotateCubeRight()
  {
    // three cube left rotations
    rotateCubeLeft();
    rotateCubeLeft();
    rotateCubeLeft();
  }
  
  public void scrambleCube()
  {
    int calledStatement;
    for (int i = 0; i < 100; i++)
    {
      calledStatement = (int) Math.random() * 17;
      switch (calledStatement)
      {
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
          System.out.println("Random number out of range");
      }
    }
    
  }
  
} // class RubiksCube