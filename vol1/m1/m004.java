import java.util.Scanner;

public class m004{


  public static long next(long start, long goal){
    while(sum(start)!=goal){
      long diff = goal-sum(start);

      return diff;
    }
    return start;
  }

  public static long sum(long nr){
    long temp = 0;
    while( nr  > 0 ){
      temp += nr%10;
      nr = nr/10;
    }
    return temp;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int c = in.nextInt();

    for(int i = 0;i< c ;i++){
      long start = in.nextLong();
      long goal = in.nextLong();

      //System.out.println(next(start+1, goal));
      System.out.println(sum(start));
    }


  }
}
