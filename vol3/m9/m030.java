// Exemplo de pesquisa em largura (BFS) num grafo nao dirigido
// (similar ao codigo feito na teorica - inclui calculo de distancias)

import java.io.*;
import java.util.*;

// Classe que representa um no
class Node {
  public LinkedList<Integer> adj; // Lista de adjacencias
  public boolean visited;         // Valor booleano que indica se foi visitado numa pesquisa
  public int distance;            // Distancia ao no origem da pesquisa

  Node() {
    adj = new LinkedList<Integer>();
  }
}

// Classe que representa um grafo
class Graph {
  int n;           // Numero de nos do grafo
  Node nodes[];    // Array para conter os nos

  Graph(int n) {
    this.n = n;
    nodes  = new Node[n+1]; // +1 se nos comecam em 1 ao inves de 0
    for (int i=1; i<=n; i++)
    nodes[i] = new Node();
  }

  public void addLink(int a, int b) {
    nodes[a].adj.add(b);
    nodes[b].adj.add(a);
  }

  // Algoritmo de pesquisa em largura
  public void bfs(int v, int[][] distMin, int[] excentric) {
    LinkedList<Integer> q = new LinkedList<Integer>();
    for (int i=1; i<=n; i++) nodes[i].visited = false;

    q.add(v); // enqueue o 1º nó e marca-o como visitado
    nodes[v].visited = true;
    nodes[v].distance = 0;

    while (q.size() > 0) { // enquanto existirem nos na pilha
      int u = q.removeFirst();
      //System.out.println(u + " [dist=" + nodes[u].distance + "]");

      distMin[v][u] = nodes[u].distance;
      if(excentric[v]<nodes[u].distance) excentric[v] = nodes[u].distance;

      for (int w : nodes[u].adj) // para cada no adjacente
        if (!nodes[w].visited) { // e nao visitado
          q.add(w);       //adiciona-o e marca como visitado
          nodes[w].visited  = true;
          nodes[w].distance = nodes[u].distance + 1;
        }

    } // END WHILE
  } // END BFS
}

public class m030 {
  static int exMin = Integer.MAX_VALUE;
  static int exMax = Integer.MIN_VALUE;

  static void maxiMino(int[] excentric ){
    for(int i=1;i<excentric.length;i++){
      if(excentric[i]> exMax) exMax = excentric[i];
      if(excentric[i]< exMin) exMin = excentric[i];
    }

  }
  static void printCentral(int[] excentric){
    String s1 = "";
    String s2 = "";
    for(int i=1;i<excentric.length;i++){
      if(excentric[i]==exMin)
        if(s1!=""){
          s1+= " " +i;
        }else s1+=i;

    }
    System.out.println(s1);
    for(int i=1;i<excentric.length;i++){
      if(excentric[i]==exMax)
        if(s2!=""){
          s2+= " " +i;
        }else s2+=i;
      
    }
    System.out.println(s2);
  }


  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int nrNos = in.nextInt();
    Graph g = new Graph(nrNos);
    int distMin[][] = new int[nrNos+1][nrNos+1];
    int excentric[] = new int[nrNos+1];
    Arrays.fill(excentric,0);

    int   e = in.nextInt();
    for (int i=0; i<e; i++)
      g.addLink(in.nextInt(), in.nextInt());

    // Pesquisa em largura a partir do no 1
    for(int i=1;i<=nrNos;i++)
      g.bfs(i,distMin, excentric);

    // for(int i=1;i<=nrNos;i++){
    //   for(int j=1;j<=nrNos;j++)
    //     System.out.print(distMin[i][j] + " ");
    //
    //   System.out.println();
    // }
    //System.out.println("----------------");

    // System.out.println("max 1: "+ excentric[1]);
    // System.out.println("max 3: "+ excentric[3]);
    maxiMino(excentric);
    System.out.println(exMax);
    System.out.println(exMin);

    printCentral(excentric);

  }
}
