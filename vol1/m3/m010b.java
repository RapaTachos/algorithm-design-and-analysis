import java.util.*;

class m010{
  static int nrCombs(int n){
      return ( fact(n) / ( 2 * fact(n-2) ) );
  }

  static int fact(int n){
    if(n==1) return 1;
    return n * fact(n-1);
  }

  static String bsearch(int goal){
    int low = 0; int high = somas.length;int middle;
    while(low<= high){
      middle = low + (high-low)/2;
      if(goal==somas[middle]) return "-->" + somas[middle];
      else if (goal<somas[middle]) high = middle -1;
      else low = middle + 1;
    }
    return "";
  }

  static int[] somas;
  static void somas(int[] v,int n){
    somas = new int[ nrCombs(n) ];
    int counter = 0;
    for(int i=0;i<n-1;i++)
      for(int j= i+1; j<n;j++)
        somas[counter++] = v[i] + v[j];
    Arrays.sort(somas);
  }

  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();
    int[] v = new int[n];
    for(int i=0;i<n;i++)
      v[i] = in.nextInt();

    somas(v,n);

    // for(int i=0;i<nrCombs(n);i++)
    //   System.out.println(somas[i]);

      int goal = 1;
      String result = bsearch(goal);
      int up = goal; String result1 = "";
      int down = goal; String result2 = "";
      while(result==""){
        result1 += bsearch(++up);
        //FastPrint.out.println( "r1-" +result1 );
        result2 += bsearch(--down);
        //FastPrint.out.println( "r2-" +result2 );
        result+= result2 + "" + result1;
        //FastPrint.out.println( "r-" +result + "|" );
      }
      //FastPrint.out.println( "| |" +result );

    //FastPrint.out.println( bsearch(51) );

    FastPrint.out.close();
  }
}
