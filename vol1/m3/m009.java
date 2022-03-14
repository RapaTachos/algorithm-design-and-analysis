import java.util.*;
import java.io.*;

class DNA implements Comparable<DNA>{
  public int count = 0;
  public int firstPos = -1;
  public char letra;

  DNA(char c){
    letra = c;
  }
  @Override
  public int compareTo(DNA d) {
    if(count > d.count) return -1;
    if(count < d.count) return +1;
    if(firstPos>d.firstPos) return +1;
    return -1;
  }
}

class m009{
  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);
    String s = in.nextLine();

    DNA[] data = new DNA[26];

    for(int i=0;i<26;i++){
      char c = (char) (i + 'A');
      data[i] = new DNA(c);
    }

    for(int i=0;i<s.length();i++){
      int temp = s.charAt(i)-'A';
      if(data[temp].count==0) data[temp].firstPos = i;
      data[temp].count++;
      //FastPrint.out.println("aqui vai " + data[temp].letra + " contagem " +   data[temp].count + " first pos " + data[temp].firstPos);
    }
    Arrays.sort(data);

    for(int i=0;i<26;i++){
      if(data[i].count==0) break;
      FastPrint.out.println(data[i].letra + " " + data[i].count);
    }

    FastPrint.out.close();

  }

}
