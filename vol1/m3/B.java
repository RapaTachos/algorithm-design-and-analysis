import java.util.*;

public class B {

  public static void bSearch(Integer[] somas, int key) {
    int low=0;
    int high= somas.length-1;
    int middle=0;

    while(low<high) {
      middle = low  + (high-low)/2;

      if(somas[middle]>=key) high = middle;
      else low = middle+1;
    }
  //if(low>=key) System.out.println("-1");
  if(low!=0){
//System.out.println("***" + somas[low-1] + " " + somas[middle] + " " + somas[high]);

  if(somas[low]!=key){
    if((Math.abs(key-somas[low-1])==Math.abs(key-somas[high]) && (somas[low-1]!=somas[high]))) {
      FastPrint.out.println(somas[low-1] + " " + somas[high]);
      return;
    }
}


    if(Math.abs(somas[low-1]-key) < Math.abs(somas[high]-key)) FastPrint.out.println(somas[low-1]);
    else {

      FastPrint.out.println(somas[high]); }
    return;
  }
  //System.out.println("here");
  FastPrint.out.println(somas[low]);

  }

  public static void main(String[] args) {
    FastScanner sc = new FastScanner(System.in);
    int N = sc.nextInt();
    int[] Narray = new int[N];

    for(int i = 0 ; i < N ; i++) {
      Narray[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] Qarray = new int[Q];
    for(int i = 0 ; i < Q ; i++) {
      Qarray[i] = sc.nextInt();
    }
    Set<Integer> somasSet = new HashSet<Integer>();
    for(int i = 0 ; i < N ; i++) {
      for(int j = 0 ; j < N ; j++) {
        if(i!=j)
          somasSet.add(Narray[i]+Narray[j]);
      }
    }

    Integer[] somas = somasSet.toArray(new Integer[somasSet.size()]);

    Arrays.sort(somas);
  //  System.out.println(Arrays.toString(somas));
    for(int i = 0 ;  i < Q ; i++) {
      bSearch(somas,Qarray[i]);
    }
    FastPrint.out.close();
  }
}
