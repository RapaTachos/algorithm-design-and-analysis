import java.util.*;
import java.lang.*;
import java.io.*;

// Classe que representa um no
class Node {
  public LinkedList<Integer> adj; // Lista de adjacencias

  Node() {
    adj = new LinkedList<>();
  }
}

// Classe que representa um grafo
class Graph {
  int n;          // Numero de nos do grafo
  Node[] nodes;   // Array para conter os nos

  Graph(int n) {
    this.n = n;
    nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
    for (int i=1; i<=n; i++)
    nodes[i] = new Node();
  }

  void addLink(int a, int b) {
    nodes[a].adj.add(b);
  }


  void FloydWarshall(){
    boolean connected[][] = new boolean[n+1][n+1];
    for(int i=0 ; i<=n ; i++)
      Arrays.fill(connected[i],false);

    for(int i=1;i<=n;i++)
      connected[i][i] = true; // MY GOD !!!

    for(int j=1; j<=n ; j++)
      for(int e : nodes[j].adj)
        connected[j][e] = true;

    for(int k=1; k <= n; k++)
      for(int i=1; i <= n ; i++)
        for(int j=1; j <= n ; j++)
          	if(connected[i][k] && connected[k][j])
              connected [i][j] = true;

  System.out.print(" ");

  for(int i=1;i<=n;i++) // imprime 1ª linha || A B C D
    System.out.print(" " +(char)(i+64));
  System.out.println();


  for(int i=1;i<=n;i++){
    System.out.print((char)(i+64)); // imprime 1ª coluna || A B C D
    for(int j=1;j<=n;j++)
      System.out.print(" " +(connected[i][j]?"1":"0"));
    System.out.println();
  }



  }

}


public class m035 {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int v = in.nextInt(); in.nextLine();
    Graph g = new Graph(v);
    for(int j = 0; j<v;j++){

      String[] s = in.nextLine().split(" ");

      int valorLetra1 = (int) (s[0].charAt(0))-65;
      //System.out.println(valorLetra1);

      int nrEdges = Character.getNumericValue(s[1].charAt(0));
      for(int i=0;i<nrEdges;i++){
        int valorLetra2 = (int) (s[i+2].charAt(0))-65;
        //System.out.println(valorLetra1 + " " +valorLetra2);
        g.addLink(valorLetra1+1, valorLetra2+1);
      }

    }

    g.FloydWarshall();


  }
}
