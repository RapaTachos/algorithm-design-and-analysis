import java.util.Scanner;
public class m006{
  static double qx,qy,tq,raio,cx,cy;
  static double area;
  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);
    int casos = in.nextInt();
    for(int i=0;i<casos;i++){
      qx = in.nextInt();
      qy = in.nextInt();
      tq = in.nextInt();
      cx = in.nextInt();
      cy = in.nextInt();
      raio = in.nextInt();
      FastPrint.out.println(intersecao(qx,qx+tq,qy,qy+tq));
    }
    FastPrint.out.close();
  }

  public static double intersecao(double x1,double x2,double y1,double y2){

    //quadrado FORA do circulo
    if( (cx-raio)>x2 || (cx+raio)<x1 || (cy-raio)>y2 || (cy+raio)<y1 )
      return 0;

    //quadrado dentro do circulo
    if(distance(x1,y1,cx,cy)<raio && distance(x2,y2,cx,cy)<raio
    &&distance(x1,y2,cx,cy)< raio && distance(x2,y1,cx,cy)<raio)
        return Math.pow(x2-x1,2);

    //circulo dentro do quadrado
    if( (cx-raio)>x1 && (cx+raio)<x2 && (cy-raio)>y1 && (cy+raio)<y2  )
        return Math.PI * Math.pow(raio,2);

    area = 0;
    if(x2-x1>0.001){
      area += intersecao( x1 , meio(x1,x2) , y1 , meio(y1,y2) );
      area += intersecao( x1 , meio(x1,x2) , meio(y1,y2) , y2 );
      area += intersecao( meio(x1,x2) , x2 , y1 , meio(y1,y2) );
      area += intersecao( meio(x1,x2) , x2 ,meio(y1,y2), y2 );
    }

    return area;

  }

  public static double distance(double x1,double y1,double x2,double y2){
    return Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) );
  }
  public static double meio(double a, double b){
    return (a+b)/2;
  }

}
