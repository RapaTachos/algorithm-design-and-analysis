import java.util.Scanner;

public class m005{
  static int[] data;
  static int[] sum;

  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();
    data = new int[n+1];
    sum = new int[n+1];
    sum[0] = 0;
    for(int i=1;i<=n;i++){
      data[i] = in.nextInt();
      sum[i] = sum[i-1] + data[i];
      //FastPrint.out.println(i + " - - " + sum[i]);
    }

    int nrtestes = in.nextInt();
    for(int i=0;i<nrtestes;i++)
      FastPrint.out.println(calc(in.nextInt(),in.nextInt()));

    FastPrint.out.close();
  }

  public static int calc(int start, int end){
      int temp = sum[end]-sum[start-1];

      return temp;
  }

}
