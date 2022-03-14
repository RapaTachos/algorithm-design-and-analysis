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
      int resultado;

      if(m1-m2>0){
        resultado = m1-m2;
      }else {
        resultado = m2-m1;
      }

      System.out.println(resultado);

    }

    //System.out.println(valor('Z'));
    //String example = "00-AA-00";
    //System.out.println(number(example));

  }

//recebe um char [A-Z]
//devolve um int [0-22] 23 letras tirando X,Y,W
  public static int CharTonumber(char character){
      int charact = (int) character;
      int y = (int) charact - ((65) -  (charact > 89 ? 3 :(charact >87 ?2 : (charact >75 ? 1 : 0   ) ) ) ) ;
      
      return y;
  }
//recebe string, como AA ou 00
//devolve o equivalente numerico
  public static int converte(String s){
    if(Character.isDigit(s)){

      return Character.getNumericValue(s); 
     // return Character.getNumericValue(s.charAt(0))*10 + Character.getNumericValue( s.charAt(1) );
    }else { 
      return CharTonumber(s.charAt(0))*23 + CharTonumber(s.charAt(1));
    }
  }

//parte a string e calcula o valor numerico
  public static int number(String s){
    String[] digits = s.split("-");
    //System.out.println(digits[0] + " " + digits[1] + " " + digits[2]);
    int temp = 0;
    //ifs / switch
    int Ncasos = 5290000;
    //1ª geração
    if(!Character.isDigit(digits[0].charAt(0)) && !Character.isDigit(digits[2].charAt(0))){

      temp = Ncasos * 3 + converte(digits[0]) * 100 * 23 * 23  + converte(digits[2]) * 100 + converte(digits[1]);

    }else if(!Character.isDigit(digits[0].charAt(0))){

        temp = converte(digits[0])*10000 + converte(digits[1])*100 + converte(digits[2]);

    }
    else if(!Character.isDigit(digits[2].charAt(0))){

      temp =  Ncasos + converte(digits[2])*10000  + converte(digits[0]) * 100  + converte(digits[1]);

    }
    else if(!Character.isDigit(digits[1].charAt(0))){

      temp = Ncasos * 2 + converte(digits[1]) * 10000 + converte(digits[0]) * 100  + converte(digits[2]);
    } 

    return temp;
  }



}
