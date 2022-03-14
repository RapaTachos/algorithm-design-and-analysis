// Exemplo de aplicacao do algoritmo de Dijkstra
// (assumindo um grafo pesado e dirigido, sem pesos negativos)
// (codigo adaptado do codigo em C++ feito na teorica)

import java.util.*;
import java.lang.*;
import java.io.*;

// Classe que representa uma aresta
class Edge {
  int to;     // No destino
  float weight; // Peso da aresta

  Edge(int t, float w) {
    to = t;
    weight = w;
  }
}

// Classe que representa um no
class Node {
  public LinkedList<Edge> adj; // Lista de adjacencias
  public boolean visited;      // No ja foi visitado?
  public float distance;         // Distancia ao no origem da pesquisa

  Node() {
    adj = new LinkedList<>();
  }
};

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
  public float cost;
  public int node;

  NodeQ(float c, int n) {
    cost = c;
    node = n;
  }

  @Override
  public int compareTo(NodeQ nq) {
    if (cost < nq.cost) return -1;
    if (cost > nq.cost) return +1;
    if (node < nq.node) return -1;
    if (node > nq.node) return +1;
    return 0;
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

  void addLink(int a, int b, float c) {
    nodes[a].adj.add(new Edge(b, c));
  }

  // Algoritmo de Dijkstra
  void dijkstra(int s) {

    //Inicializar nos como nao visitados e com distancia infinita
    for (int i=1; i<=n; i++) {
      nodes[i].distance = Integer.MAX_VALUE;
      nodes[i].visited  = false;
    }

    // Inicializar "fila" com no origem
    nodes[s].distance = 0;
    TreeSet<NodeQ> q = new TreeSet<>();
    q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

    // Ciclo principal do Dijkstra
    while (!q.isEmpty()) {

      // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
      NodeQ nq = q.pollFirst();
      int  u = nq.node;
      nodes[u].visited = true;
      //System.out.println(u + " [dist=" + nodes[u].distance + "]");

      // Relaxar arestas do no retirado
      for (Edge e : nodes[u].adj) {
        int v = e.to;
        float cost = e.weight;
        if (!nodes[v].visited && nodes[u].distance + cost < nodes[v].distance) {
          q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
          nodes[v].distance = nodes[u].distance + cost;
          q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
        }
      }
    }
    System.out.printf("%.1f\n",nodes[2].distance);
  }
};


public class m033 {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    Graph g = new Graph(in.nextInt());
    int   e = in.nextInt(); in.nextLine(); //buffer na prox linha
    int nrKeys = 0;
    TreeMap <String,Integer> map = new TreeMap<String,Integer>();
    String[] data = in.nextLine().split(" ");
    map.put(data[0], ++nrKeys);
    map.put(data[1], ++nrKeys);


    for (int i=0; i<e; i++){
      String[] temp = in.nextLine().split(" ");
      int curKey1, curKey2;

      if(!map.containsKey(temp[0])){
          curKey1 = ++nrKeys;
          map.put(temp[0], curKey1);

      }else curKey1 = map.get(temp[0]);

      if(!map.containsKey(temp[1])){
          curKey2 = ++nrKeys;
          map.put(temp[1], curKey2);

      }else curKey2 = map.get(temp[1]);

      g.addLink(curKey1, curKey2, Float.parseFloat(temp[2]));
      g.addLink(curKey2, curKey1, Float.parseFloat(temp[2]));

    }

    //System.out.println(map);

    // Execucao exemplo a partir do no 1
    g.dijkstra(1);

    // ja imprimo no final do dijkstra but whatever
    //System.out.println(g.nodes[2].distance);
  }
}
