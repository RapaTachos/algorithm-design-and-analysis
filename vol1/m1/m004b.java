import java.util.Scanner;

public class m004b{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int casos = in.nextInt();

    for(int i=0;i<casos;i++){
      long start = in.nextLong();
      long goal = in.nextLong();
      long result = 0;

      //System.out.println(sum(start));
      if(sum(start)==goal){
        result = start + 10 - 1;

      }else{
        if(goal>sum(start)){
          long diff = Math.abs(goal - sum(start)) ;
          long exp = 1;
          result = start;
          long temp = 0;
          while(diff>9){ // AQUIIIIIIIII <----
            temp = start%10;
            result+=(9-temp)*exp;
            diff = diff- (9-temp);
            start/=10;
            exp *=10;
          }
          // System.out.println("1----" + result + " | | "+ sum(result));
          temp = start%10;
          if(temp == 0) result+=diff*exp; // <-----?
          else{

            while(diff>0){
              // System.out.println("MTHRFCKING TEMP" + temp);
              // System.out.println("MTHRFCKING DIFF" + diff);

              if(diff-temp<0){
                // System.out.println("----------" + result + " | | "+ sum(result));
                result += diff*exp;
                break;
              }

              result+=(9-temp)*exp;
              diff = diff- (9-temp);
              start/=10;
              exp *=10;
              temp = start%10;
            }



          }

          // System.out.println("2----" + result + " | | "+ sum(result));
        }else{
          result = 0;
        }


      }

      System.out.println(result);
    }



  }

  public static long sum(long nr){
    long temp = 0;
    while( nr  > 0 ){
      temp += nr%10;
      nr = nr/10;
    }
    return temp;
  }


}
