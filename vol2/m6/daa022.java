// Codigo inicial para o problema [DAA 022] Arvores Red-Black
// Pedro Ribeiro (DCC/FCUP)

import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node {
  boolean isBlack;  // No preto?
  boolean isNull;   // No nulo?
  int value;        // Valor
  Node left, right; // Filhos

  Node(int v) {
    isNull  = (v==0);
    isBlack = (v>=0);
    value   = Math.abs(v);
  }
}

public class daa022 {

  // Ler input em preorder
  static Node readPreOrder(Scanner in) {
    int v = in.nextInt();
    Node aux = new Node(v);
    if (v!=0) {
      aux.left  = readPreOrder(in);
      aux.right = readPreOrder(in);
    }
    return aux;
  }

  // Menor valor da arvore
  static int minimum(Node t) {
    if (t.isNull) return Integer.MAX_VALUE;
    int minLeft  = minimum(t.left);
    int minRight = minimum(t.right);
    return Math.min(t.value, Math.min(minLeft, minRight));
  }

  // Maior valor da arvore
  static int maximum(Node t) {
    if (t.isNull) return Integer.MIN_VALUE;
    int minLeft  = maximum(t.left);
    int minRight = maximum(t.right);
    return Math.max(t.value, Math.max(minLeft, minRight));
  }

  // Quantidade de nos (internos)
  static int size(Node t) {
    if (t.isNull) return 0;
    return 1 + size(t.left) + size(t.right);
  }

  // ---------------------------------------------------

  static boolean isBST(Node t){
    if(t.isNull) return true;
    if( maximum(t.left) < t.value && t.value < minimum(t.right) )
      return (isBST(t.left) && isBST(t.right));

    return false;
  }
/*
  static boolean isBST(Node t){
    if(t.isNull) return true;

    if(!t.left.isNull && t.left.value > t.value)
      return false;

    if(!t.right.isNull && t.right.value < t.value)
      return false;

    if( !isBST(t.left) || !isBST(t.right))
      return false;
//lança recursao para os 2 lados para checkar se ñ sao BST
    return true; //se passar tudo é BST
  }*/

  static boolean redProp(Node t){
    if(t.isNull) return true;

    if(!t.isBlack){ // !black = red
      if( !t.left.isBlack) return false; // se ele & um dos filhos forem vermelhos estoura
      if( !t.right.isBlack) return false;
    }

    if( !redProp(t.left) || !redProp(t.right) ) return false;
    return true;
  }

  static int blackProp(Node t){
    if(t.isNull) return 1;

    int leftValue = blackProp(t.left);
    int rightValue = blackProp(t.right);

    if( leftValue != rightValue ) return -1;

    if(!t.isBlack) return leftValue;

    return leftValue + 1;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n =  in.nextInt();
    for (int i=0; i<n; i++) {
      Node root = readPreOrder(in);
      //System.out.printf("Tree with %d nodes (min=%d, max=%d)\n", size(root), minimum(root), maximum(root));


      // System.out.println(isBST(root)); // check
      // System.out.println(redProp(root)); // pretty fcking sure
      // System.out.println(blackProp(root));

      if( root.isBlack &&isBST(root)&&redProp(root)&& blackProp(root) != -1){
        System.out.println("SIM");
      }else
        System.out.println("NAO");


      //System.out.println("---------------------------------------------------");
    }
  }
}
