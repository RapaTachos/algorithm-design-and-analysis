import java.io.*;

class m017{
  static long[][] data;
  static int n;

  static void calcula(){
    for(int i=1;i<=n;i++)
      for(int j=1; j<= n-i+1 ; j++){
        //System.out.println("entrei " + i + " " + j);
        if(data[i][j] == 0) continue;
        if( i==1 ){
          data[i][j] = 1;
        }else{
          data[i][j] = data[i-1][j] + data[i-1][j+1];
        }
        //System.out.println(data[i][j]);
      }

  }

  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);
    n = in.nextInt();
    data = new long[n+1][n+1];
    for(int i=1;i<=n;i++)
      for(int j=1;j<=n;j++)
        data[i][j] = -1;


    int nrPedrasFddas = in.nextInt();
    for(int i=0; i<nrPedrasFddas;i++)
      data[in.nextInt()][in.nextInt()] = 0;
    calcula();
    System.out.println(data[n][1]);
  }

}
