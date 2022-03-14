import java.util.*;
import java.io.*;

public class m027 {
  static int n;              // Numero de nos do grafo
  static boolean adj[][];    // Matriz de adjacencias
  static boolean visited[];  // Que nos ja foram visitados?
  static int cores[];

  static boolean dfs(int v, int cor) {
    // System.out.print("\n" +v + "| ");
    // System.out.print((cor==1)?"blue":"red");
    // System.out.print(cor + "\t" +cores[v]); //ignorar este print i guess

    visited[v] = true;
    for (int i=1; i<=n; i++){

      if (adj[v][i] && !visited[i]){          // se é adj e ainda ñ foi visitado
        if(cores[i]!=cor)
          if(dfs(i, -cor)){ //se o dfs retornar true
            cores[i] = -cor;
            //System.out.print(" [" + cores[i] + "] ");
          }else return false; // senao "propaga" o false para cima

      }else if (adj[v][i] && visited[i])           // se for adj e já visitado
        if(cores[i]==cor)
          return false;   //e se a cor for igual "à anterior" retorna false

    }// END FOR,  se passar isto retorna true tranquilamente
    return true;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int nrQuestoes = in.nextInt();
    for(int k=0;k<nrQuestoes;k++){

      n = in.nextInt();
      adj     = new boolean[n+1][n+1];
      visited = new boolean[n+1];
      cores = new int[n+1];

      int edges = in.nextInt();
      for (int i=0; i<edges; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        adj[a][b] = adj[b][a] = true;
        //System.out.println("Scanning: " + a + " " + b);
      }
      // printAdj();
      System.out.println(dfs(1,1)?"sim":"nao"); // retorna true se conseguir
      //System.out.println("----------------");
    }
    // END FOR nrQuestoes
  } // END MAIN
  static void printAdj(){
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n;j++)
        System.out.print(adj[i][j]?"1":"0");
      System.out.println();
    }
    System.out.println("-----------------------");
  }
}
