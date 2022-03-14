//ajuda do Tiago Araujo ^_^
import java.util.*;

class daa010{
    static int[] somas;
    static int[] resultado;
    static void somas(int[] v,int n){
	int tamanho = 0;
	somas = new int[10000000];
	//System.out.println("AQUI --> NR COMBS " +nrcombs );
	int counter = 0;
	for(int i=0;i<n-1;i++)
	    for(int j= i+1; j<n;j++){
		somas[counter++] = v[i] + v[j];
		tamanho ++;
	    }
	resultado = new int[tamanho];
	for(int i = 0; i < tamanho; i++)
	    resultado[i] = somas[i];

	Arrays.sort(resultado);
    }

    public static int bsearch1(int goal, int low, int high){
	while(low<high){
	    int middle = low + (high-low)/2;
	    if( resultado[middle] >= goal ) high = middle;
	    else low = middle + 1;
	}
	if( resultado[low] < goal ) return -1;

	return low;
    }

    public static void main(String[] args){
	FastScanner in = new FastScanner(System.in);

	int n = in.nextInt();
	int[] v = new int[n];
	for(int i=0;i<n;i++)
	    v[i] = in.nextInt();

	somas(v,n);
	//
	// for(int i=0;i<nrCombs(n);i++)
	//   System.out.print(somas[i] + " ");

	// System.out.println("---------------------");
	// System.out.println( bsearch1(21,0,somas.length-1));
	// System.out.println( bsearch2(21,0,somas.length-1));

	int nr_questoes = in.nextInt();
	for(int i=0;i<nr_questoes;i++){
	    int goal = in.nextInt();
	    int flag = bsearch1(goal, 0, resultado.length-1);
	    //System.out.println(flag + " " + goal);
	    if(flag==-1){
		FastPrint.out.println(resultado[resultado.length-1]);
	    }else if(flag==0){
		FastPrint.out.println(resultado[0] );
	    }else{
		int best1 = resultado[flag];
		int best2 = resultado[flag-1];
		if( Math.abs(goal-best1) < Math.abs(goal-best2) ){
		    FastPrint.out.println(best1);
		}else if ( Math.abs(goal-best1) > Math.abs(goal-best2) ){
		    FastPrint.out.println(best2);
		}else{
		    FastPrint.out.println(best2 + " " + best1);
		}
	    }
	}


	FastPrint.out.close();
    }
}
