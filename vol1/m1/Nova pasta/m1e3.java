import java.util.Scanner;

public class m1e3{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int casos = in.nextInt();
    String nada = in.nextLine();

    for(int i=0;i<casos;i++){
      String buffer = in.nextLine();
      String matricula[] = buffer.split(" ");
      int m1 = number(matricula[0]);
      int m2 = number(matricula[1]);
      System.out.println(Math.abs(m1-m2));

    }

    //System.out.println(valor('Z'));
    //String example = "00-AA-00";
    //System.out.println(number(example));

  }

//recebe um char [A-Z]
//devolve um int [0-22] 23 letras tirando X,Y,W
  public static int valor(char x){
      int y = (int) x - 65;
      if(x>75)y--;
      if(x>87)y--;
      if(x>89)y--;

      return y;
  }

//recebe string, como AA ou 00
//devolve o equivalente numerico
  public static int converte(String s){
    if(Character.isDigit(s.charAt(0))){
      return Integer.parseInt(s);
      // return Character.getNumericValue(s.charAt(0) )*10
      //         + Character.getNumericValue( s.charAt(1) );
    }else return valor(s.charAt(0))*23 + valor(s.charAt(1));
  }

//parte a string e calcula o valor numerico
  public static int number(String s){
    String[] digits = s.split("-");
    //System.out.println(digits[0] + " " + digits[1] + " " + digits[2]);
    int temp = 0;

    //1ª geração
    if(Character.isDigit(digits[1].charAt(0))
    &&Character.isDigit(digits[2].charAt(0))){
        temp = converte(digits[0])*10000
        + converte(digits[1])*100
        + converte(digits[2]);
    }
    else if(Character.isDigit(digits[0].charAt(0))
    &&Character.isDigit(digits[1].charAt(0))){
      temp = 5290000
      + converte(digits[2])*10000
      + converte(digits[0])*100
      + converte(digits[1]);
    }
    else if(Character.isDigit(digits[0].charAt(0))
    &&Character.isDigit(digits[2].charAt(0))){
      temp = 5290000+5290000
      + converte(digits[1])*10000
      + converte(digits[0])*100
      + converte(digits[2]);
    }
    else{
      temp = 5290000+5290000+5290000
      + converte(digits[0])*100*23*23
      + converte(digits[2])*100
      + converte(digits[1]);
    }

    return temp;
  }



}
