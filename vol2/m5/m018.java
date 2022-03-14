class m018{

  static void calcula(int goal){
    result[0] = 0;
    for(int i= 1; i<= goal;i++){
      result[i] = Integer.MAX_VALUE;
      use[i] = 0;
      // System.out.print(i + ": ");
      for(int j=coins.length-1; j>=0 ;j--){
        int moeda = coins[j];
        if( moeda<=i && result[ i-moeda ] < result[i] ){
          result[i] = 1 + result[ i-moeda ];
          use[i] = moeda;
          // System.out.print(moeda + " ");
        }

      }
       // System.out.println();
    }

  }

  static int[] coins,result,use;
  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);
    int nrCoins = in.nextInt();
    coins = new int[nrCoins];
    for(int i=0;i<nrCoins;i++)
      coins[i] = in.nextInt();

    int nrQuestions = in.nextInt();
    for(int i=0; i< nrQuestions;i++){
      int quant = in.nextInt();
      result = new int[quant + 1];
      use = new int[quant + 1];
      calcula(quant);
      FastPrint.out.print(quant + ": [" + result[quant] + "]");

      // for(int j=0; j<=quant;j++)
      //   System.out.print(use[j] + " ");

        String res = "";
        while(quant>0){
          res += " " + use[quant];
          //System.out.print(" " + use[quant]);
          quant -= use[quant];
        }
      FastPrint.out.println(res);
    }
    FastPrint.out.close();
  }
}
