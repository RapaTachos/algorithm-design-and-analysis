// Exemplo de ordenacao customizada de pessoas
// Primeiro por ordem crescente da idade, e em caso de empate por
// ordem crescente alfabetica do nome
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 11/10/2020
// ----------------------------------

import java.io.*;
import java.util.*;

// Classe para guardar um nome
class Person implements Comparable<Person> {
  public int age;
  public String name;

  Person(int a, String n) {
    age = a;
    name = n;
  }

  // Definir como comparar dois elementos da classe Person
  // compareTo e uma funcao que compara objecto com outro objecto "p"
  // Esta funcao deve devolver:
  //  - numero < 0 se objecto for menor que objecto "p"
  //  - numero > 0 se objecto for maior que objecto "p"
  //  - zero, se objecto for igual ao objecto "p"
  @Override
  public int compareTo(Person p) {
    if (age < p.age) return -1;
    if (age > p.age) return +1;
    return name.compareTo(p.name);
  }
}

public class CustomSort {
  public static void main(String args[]) {
    Scanner stdin = new Scanner(System.in);

    int n    = stdin.nextInt();
    Person v[] = new Person[n];
    for (int i = 0; i<n; i++)
    v[i] = new Person(stdin.nextInt(), stdin.next());

    // Chamada ao sort padrao da linguagem Java
    // Usa o comparador padrao do tipo do array
    Arrays.sort(v);

    for (int i = 0; i<n; i++)
    System.out.println(v[i].age + " " + v[i].name);
  }
}
