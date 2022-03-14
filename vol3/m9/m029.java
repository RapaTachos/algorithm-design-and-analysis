import java.util.*;
import java.io.*;
// aprendi a lição ao fim de 2 horas a fazer debugging...
// tenho que começar a fazer mais DEFINES
class m029{
  static char[][] data;

  static int n;              // Numero de nos do grafo
  static boolean adj[][];    // Matriz de adjacencias
  static boolean visited[];  // Que nos ja foram visitados?
  static int order[], norder = 0;
  static boolean letras[];

  static void dfs(int v) { // dfs para ord topologica
    //System.out.print(v + " ");
    visited[v] = true;
    for (int i=0; i<26; i++)
      if (adj[v][i] && !visited[i])
          dfs(i);
    //podias ser homezinho e usar listas e push_front ou whatever
    order[norder++] = v;
  }

  static void criaNos(int x1, int x2){ // processa as palavras x1,x2 e cria nós
    //System.out.print(x1 + " " + x2 + "| ");
    int char1Value,char2Value;
    // podia ter usado charAt whatever
    for(int i=0; i<data[x1].length;i++){
      char1Value =  (int)data[x1][i] -65;
      char2Value =  (int)data[x2][i] -65;
        if(char1Value!=char2Value){ //eventually quando a letra for diferente
          //System.out.print(char1Value + " " + char2Value + "| ");
          //System.out.print(data[x1][i]+ " " + data[x2][i]);
          adj[char1Value][char2Value] = true;
          letras[char1Value] = letras[char2Value] = true;
          n++;
          break; // paro, nao preciso de processar mais letras
        }
    }// END FOR cada letra da 1ª palavra
    //System.out.println();
  } // END criaNos

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int nrPalavras = in.nextInt();
    data = new char[nrPalavras][10];
    adj     = new boolean[26][26];
    visited = new boolean[26];
    order = new int[26];
    letras = new boolean[26];
    in.nextLine(); //buffer na prox linha

    for(int i=0; i< nrPalavras ;i++){
      String s = in.nextLine();
      //System.out.println(s);
      data[i] = s.toCharArray();
    }

    // for(int i=0; i<nrPalavras;i++){
    //   for(int j=0;j<data[i].length;j++)
    //     System.out.print(data[i][j] + " ");
    // System.out.println();
    // }

    for(int i=1; i<nrPalavras;i++) // a partir da segunda palavra
          criaNos(i-1,i); // cria no entre cada palavra e a anterior

    for(int i=0;i<26;i++) // para cada letra do abcedario
      if(!visited[i] && letras[i]) // se não foi visitada e a letra apareceu
        dfs(i);

   for(int i=norder-1;i>=0;i--) // imprimir pela ordem inversa
     System.out.print((char)('A' + order[i]) );
  System.out.println();

  }
}
