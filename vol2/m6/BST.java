// Exemplo de uso de arvores binarias de Pesquisa Equilibradas (BSTs)
// -------------------------------------
// Pedro Ribeiro (DCC/FCUP) - 30/10/2020
// -------------------------------------

import java.util.TreeSet; // Conjuntos
import java.util.TreeMap; // Mapas (associar valores a chaves)
import java.util.Map;     // Para o tipo Map.Entry

public class BST {
    public static void main(String args[]) {

	System.out.println("Testes com tipo \"TreeSet\":\n");
	TreeSet<Integer> s = new TreeSet<Integer>();

	System.out.println("Adicionando 2, 4, 6 e 8");
	s.add(2);
	s.add(4);
	s.add(6);
	s.add(8);
	System.out.println("Tamanho: " +  s.size());

	System.out.print("Procurando o numero 2: ");
	if (s.contains(2)) System.out.println("descobri o 2 :)");
	else System.out.println("nao existe o 2... :(");

	System.out.println("Removendo o numero 2");
	s.remove(2);

	System.out.print("Procurando o numero 2: ");
	if (s.contains(2)) System.out.println("descobri o 2 :)");
	else System.out.println("nao existe o 2... :(");

	System.out.print("Elementos do conjunto (por ordem): ");
	for (int i : s)
	    System.out.print(i + " ");
	System.out.println();

	System.out.println("Primeiro elemento: " + s.first());
	System.out.println("Ultimo elemento: " + s.last());


	// --------------------------------------------------------------
	System.out.println("--------------------------------------");


	System.out.println("Testes com tipo \"TreeMap\":\n");
	TreeMap<String, Integer> m = new TreeMap<String, Integer>();

	System.out.println("Adicionando nomes e notas");
	m.put("Ana", 12);
	m.put("Pedro", 20);
	m.put("Luisa", 19);
	m.put("Miguel", 17);

	System.out.println("Nota do Pedro: " + m.get("Pedro"));
	System.out.println("Nota do Carlos: " + m.get("Carlos")); // nÃ£o existe

	System.out.print("Elementos do mapa (por ordem): ");
	for (Map.Entry<String, Integer> entry : m.entrySet())
	    System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
	System.out.println();
    }
}
