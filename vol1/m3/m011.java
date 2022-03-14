import java.util.*;

class m011{
  static int[] v;

  static boolean consegue(int goal, int dias){
    int sum = 0;
    dias--;
    for(int i=0;i<v.length;i++){
      if(v[i]>goal) return false;
      sum += v[i];
      if( sum > goal ){
        dias--;
        sum = v[i];
        if(dias<0) return false;
      }
      //System.out.println(i + " : " + sum + " " + dias);
    }
    return true;
  }

  public static int bsearch(int dias, int low, int high){
    while(low<high){
      int middle = low + (high-low)/2;
      if( consegue(middle, dias) ) high = middle;
      else low = middle + 1;
    }
    if(consegue(low, dias)==false) return -1;

    return low;
  }

  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();
    v = new int[n];
    int sum = 0;
    for(int i=0;i<n;i++){
      int temp = in.nextInt();
      v[i] = temp;
      sum+= temp;
    }
    int casos = in.nextInt();
    for(int i=0;i<casos;i++)
      FastPrint.out.println( bsearch( in.nextInt(), 0, sum ) );

    //FastPrint.out.println(consegue(9,10));
    //FastPrint.out.println(consegue(sum,1) + " aii");
    FastPrint.out.close();
  }
}
