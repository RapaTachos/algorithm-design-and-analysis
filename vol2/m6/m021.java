import java.util.TreeMap; // Mapas (associar valores a chaves)
import java.util.Map;  // Para o tipo Map.Entry

public class m021{
  public static void main(String[] args){
    FastScanner in = new FastScanner(System.in);
    int nrOPa = in.nextInt();
    int nrOPr = in.nextInt();

    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

    for(int i=0; i<nrOPa + nrOPr; i++){
      String s = in.nextLine();
      if(s.equals("MIN")){
        int min = m.firstKey();
        FastPrint.out.println(min);
        if(m.get(min)==1)
          m.remove(min);
        else
          m.put(min,m.get(min)-1);
      }
      else if(s.equals("MAX")){
        int max = m.lastKey();
        FastPrint.out.println(max);
        if(m.get(max)==1)
          m.remove(max);
        else
          m.put(max,m.get(max)-1);
      }
      else{
        String[] data = s.split(" ");
        //System.out.println("1 " + data[0]);
        //System.out.println("2 " + data[1]);
        int power = Integer.parseInt(data[1]);
        //System.out.println("X " + power);

        if(m.get(power)==null)
          m.put(power,1);
        else
          m.put(power,m.get(power)+1);
      }

    }
    // for (Map.Entry<Integer, Integer> entry : m.entrySet())
  	//     System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
  	// System.out.println();
    FastPrint.out.close();
  }
}
