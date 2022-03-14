class m015{

  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();
    int[] data = new int[10000];
    for(int i=0;i<10000;i++)
      data[i] = 0;

    for(int i=0; i<n;i++)
      data[in.nextInt()]++;

    for(int i=0;i<10;i++){
      System.out.println(i + ": " + data[i]);
    }



    FastPrint.out.close();
  }
}
