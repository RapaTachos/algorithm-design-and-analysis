import java.util.*;

class Encomenda implements Comparable<Encomenda>{
  int dias; int multa; float taxaMulta; int nrEncomenda;
  static int n=0;

  Encomenda(int d, int m){
    dias = d;
    multa = m;
    taxaMulta = (float)multa / dias;
    nrEncomenda = ++n;
  }

  @Override
  public int compareTo(Encomenda e) {
    if (taxaMulta > e.taxaMulta) return -1;
    if (taxaMulta < e.taxaMulta) return +1;
    return 0;
  }

}

class m014{
  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();
    Encomenda[] data = new Encomenda[n];

    for(int i=0;i<n;i++)
      data[i] = new Encomenda(in.nextInt(),in.nextInt());

    Arrays.sort(data);

    // for(int i=0;i<n;i++)
    //   FastPrint.out.println(
    //     data[i].nrEncomenda + "nr: " + data[i].dias + "dias " + data[i].multa + "multa " +
    //     data[i].taxaMulta
    //   );

    for(int i=0;i<n;i++){
      FastPrint.out.print(data[i].nrEncomenda);
      if(i < n-1) FastPrint.out.print(" ");
    }
    FastPrint.out.println();

    FastPrint.out.close();
  }
}
