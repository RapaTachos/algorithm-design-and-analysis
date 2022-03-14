import java.util.Scanner;

public class m1e1{
  public static void main(String[] args){

    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int count = 0;
    for(int i =0; i<n; i++){
      int temp = in.nextInt();
      if(temp==42) count++;
    }

    System.out.println(count);
  }
  
}
