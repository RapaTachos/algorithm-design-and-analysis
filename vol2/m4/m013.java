import java.util.*;

class Segmento implements Comparable<Segmento>{
  int start, finish, tamanho;

  Segmento(int s, int f){
    start = s;
    finish = f;
    tamanho = f-s;
  }

  @Override
  public int compareTo(Segmento s) {
    if (start < s.start) return -1;
    if (start> s.start) return +1;
    if(tamanho > s.tamanho) return -1;
    return 1;
  }

}

class m013{

  public static int procura(Segmento[] data, int time){
    int melhor = 0;
    int temp = 0;

    for(int i=0; i< data.length ; i++){
      if(data[i].start > time) break;

      int resposta = data[i].finish - time;
      //System.out.println("Resposta: " + resposta);
      if( resposta  > melhor ){
        melhor = resposta;
        temp = i;
      }
    }
    return temp;
  }

  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);

    int tamanho = in.nextInt();
    int nrSegmentos = in.nextInt();
    Segmento[] data = new Segmento[nrSegmentos];

    for(int i=0;i<nrSegmentos;i++)
      data[i] = new Segmento(in.nextInt(),in.nextInt());

    Arrays.sort(data);

    // for(int i=0;i<nrSegmentos;i++)
    //   FastPrint.out.println(data[i].start + " " + data[i].finish);

    int time = 0;
    int counter = 0;

    while(time<tamanho){
      int temp = procura(data, time);
      time = data[temp].finish;
      counter++;
    }

    FastPrint.out.println(counter);
    FastPrint.out.close();
  }
}
