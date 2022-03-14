import java.util.*;
import java.io.*;

public class m026 {
  static int rows, cols;
  static char m[][];
  static boolean visited[][];
  static int counter, maxSoFar;


  static int[] incX = {-1,+1, 0, 0,-1,-1,+1,+1};
  static int[] incY = { 0, 0,-1,+1,-1,+1,-1,+1};

  static void dfs(int y, int x){
    if(y<0 || y>= rows || x<0 || x>= cols) return;
    if( visited[y][x] || m[y][x] != '#') return;

    // System.out.println("DFS " + y + " " + x);
    visited[y][x] = true;
    counter++;

    for(int i=0; i < 8 ;i++)
      dfs( y + incY[i] , x + incX[i]  );

  }


  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int nrQuestoes = in.nextInt();

    for(int k=0;k<nrQuestoes;k++){
      rows = in.nextInt();
      cols = in.nextInt();
      in.nextLine(); // SUPER IMPORTANTE ! BUFFER NA PROX LINHA
      m = new char[rows][cols];
      visited = new boolean[rows][cols];

      for(int i=0;i<rows;i++)
        m[i] = in.nextLine().toCharArray();

      //printMatriz();
      counter = 0;
      maxSoFar = 0;

      for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
          if(m[i][j]=='#' && !visited[i][j]){
            counter = 0;
            dfs(i,j);
            // System.out.println("------->" + counter);
            if(counter > maxSoFar) maxSoFar = counter;
          }

      System.out.println(maxSoFar);
      // System.out.println("-----------------------------------------------");
    }
  }

  static void printMatriz(){
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++)
        System.out.print(m[i][j]);
      System.out.println();
    }
  }

}
