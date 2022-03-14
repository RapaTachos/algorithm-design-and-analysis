import java.util.Scanner;

public class m002{

  public static int sumOf(int x){
    int counter = 0;
    while(x > 0){
      counter += x%10;
      x /= 10;
    }
    return counter;
  }


  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int casos = in.nextInt();

    for(int i=0;i<casos;i++){

      int nr = in.nextInt();
      int sum = in.nextInt();
      while(true){
        nr++;

        if(sumOf(nr)==sum){
          System.out.println(nr);
          break;
        }

      }


    }




  }

}
