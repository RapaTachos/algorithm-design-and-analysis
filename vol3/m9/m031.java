import java.util.*;
import java.io.*;

class Point{
  int x;
  int y;
  int dist;
  Point(int x, int y, int dist){
    this.x = x;
    this.y = y;
    this.dist = dist;
  }
}

public class m031 {
  static int rows, cols;
  static char m[][];
  static boolean visited[][];
  static int[][] distMin;

  static int[] incX = {-1, 1, 0, 0, 1, 1, -1, -1};
  static int[] incY = {0, 0, -1, 1, 1, -1, 1, -1};


  static void bfs(char[][] m, int[][] distMin) {
    LinkedList<Point> q = new LinkedList<Point>();
    LinkedList<Integer> resultado = new LinkedList<Integer>();

    for(int i=0;i<m.length;i++)
       for(int j=0;j<m[i].length;j++)
         if(m[i][j]=='#'){
           q.add(new Point(i,j,0));
           visited[i][j] = true;
           distMin[i][j] = 0;
         }


    while (q.size() > 0) {
      Point p1 = q.removeFirst();
      //System.out.println(p1.x + " " + p1.y + " | " + p1.dist);

      for(int k = 0;k<4;k++){ // para cada adj
        int xp2 = p1.x + incX[k];
        int yp2 = p1.y + incY[k];
        if( xp2>= 0 && xp2 < rows && yp2>=0 && yp2 < cols && !visited[xp2][yp2] ){
          q.add(new Point(xp2,yp2, p1.dist + 1));
          distMin[xp2][yp2]= p1.dist+1;
          visited[xp2][yp2] = true;

          if(m[xp2][yp2]=='A'){
            //System.out.println("Alto : " + (p1.dist+1) );
            resultado.add(p1.dist+1);
          }

        }
      } // END FOR

    } // END WHILE

    //System.out.println(resultado);

    int min = Integer.MAX_VALUE;
    int max = 0;

    for(int temp:resultado){
      if(temp > max) max = temp;
      if(temp < min) min = temp;
    }
    System.out.println(min + " " + max);

  } // END BFS


  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    rows = in.nextInt();
    cols = in.nextInt();
    in.nextLine(); // SUPER IMPORTANTE ! BUFFER NA PROX LINHA
    m = new char[rows][cols];
    visited = new boolean[rows][cols];
    distMin = new int[rows][cols];


    for(int i=0;i<rows;i++)
      m[i] = in.nextLine().toCharArray();

    // printMatriz();
    // System.out.println("---------------------");

    bfs(m,distMin);
    printMatriz(distMin);

  }

  static void printMatriz(int[][] distMin){
    for(int i=0;i<distMin.length;i++){
      for(int j=0;j<distMin[i].length;j++){
        int coise = distMin[i][j];
        System.out.print(coise);
        if(coise>=10){
          System.out.print("  ");
        }else System.out.print("   ");
      }
      System.out.println();
    }
  }

}

public Map<Integer,PieceShape> getShapes(PuzzleStructure structure) {


  int n = structure.getPieceCount();
  Map<Integer, PieceShape> shapeMap = new HashMap<Integer, PieceShape>();



  for(int i = 0; i < n; i++) {


    double[] coord = new double[4];

    coord = structure.positionGrid.get(i);

    double x = coord[0];
    double y = coord[1];

    double w = structure.getPieceWidth();
    double h =structure.getPieceHeight();

    System.out.println( "(" + x + "," + y + ")" );

    PieceShape shape = new PieceShape( new Point(x,y) );

    shape = shape.addSegment(  new LineTo( new Point(x + w , y) ) );
    shape = shape.addSegment(  new LineTo( new Point(x + w, y + h) ) );
    shape = shape.addSegment(  new LineTo( new Point(x , y+h) ) );
    shape = shape.addSegment(  new LineTo( new Point(x , y) ) );
