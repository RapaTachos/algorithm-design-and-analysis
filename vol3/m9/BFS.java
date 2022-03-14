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
  public void bfs(int v) {
    LinkedList<Integer> q = new LinkedList<Integer>();
    for (int i=1; i<=n; i++) nodes[i].visited = false;

    q.add(v); // enqueue o 1º nó e marca-o como visitado
    nodes[v].visited = true;
    nodes[v].distance = 0;

    while (q.size() > 0) { // enquanto existirem nos na pilha
      int u = q.removeFirst();
      System.out.println(u + " [dist=" + nodes[u].distance + "]");

      for (int w : nodes[u].adj) // para cada no adjacente
        if (!nodes[w].visited) {         // e nao visitado
          q.add(w);     //adiciona-o e marca como visitado
          nodes[w].visited  = true;
          nodes[w].distance = nodes[u].distance + 1;
        }
    } // END WHILE
  } // END BFS
}

public class BFS {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    Graph g = new Graph(in.nextInt());
    int   e = in.nextInt();
    for (int i=0; i<e; i++)
      g.addLink(in.nextInt(), in.nextInt());

    // Pesquisa em largura a partir do no 1
    g.bfs(1);
  }
}
