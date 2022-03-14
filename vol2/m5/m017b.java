import java.io.*;

class m017{
  static int[][] data;
  static int n;

  static int melhor(int x, int y){
    if( data[x][y] == -1 ) return 0;
    if( x == 1 ) return 1;
    int melhor1 = melhor ( x - 1  , y );
    int melhor2 = melhor ( x - 1, y + 1 );
    System.out.println("computing: " + x + " " + y);
    return  melhor1 + melhor2 ;
  }

  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);
    n = in.nextInt();
    data = new int[n+1][n+1];
    int nrPedrasFddas = in.nextInt();
    for(int i=0; i<nrPedrasFddas;i++)
      data[in.nextInt()][in.nextInt()] = -1;
    System.out.println( melhor(n,1) ) ;
  }

}
