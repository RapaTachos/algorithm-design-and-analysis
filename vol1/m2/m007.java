import java.util.Scanner;

public class m007{
  static int[] data;


  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);
    int n = in.nextInt();
    data = new int[n];
    for(int i=0;i<n;i++)
      data[i] = in.nextInt();

    FastPrint.out.println( sms(data,0,data.length-1) );

    FastPrint.out.close();
  }

  public static int crosum(int[] v, int l, int m, int h){
      int sum = 0;// ESTA FUNCAO FOI PATROCINADA POR: GEEKSFORGEEKS
      int left_sum = Integer.MIN_VALUE;
      for(int i=m; i>=l; i--){
        sum = sum+ v[i];
        if(sum>left_sum)
          left_sum = sum;
      }
      sum=0;
      int right_sum = Integer.MIN_VALUE;
      for(int i= m+1; i<= h; i++){
        sum = sum + v[i];
        if(sum>right_sum)
          right_sum = sum;
      }
      return left_sum + right_sum;
  }

  public static int sms(int[] v, int a, int b){
    if(a==b) return v[a];
    int meio = (a+b)/2;
    return max(sms(v,a,meio),sms(v,meio+1,b),crosum(v, a, meio , b));
  }

  public static int max(int a, int b, int c){
    return Math.max(a, Math.max(b,c) );
  }

}
