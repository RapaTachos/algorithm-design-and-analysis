// [DAA 003] Matriculas

// ----------------------------------

// Pedro Ribeiro (DCC/FCUP) - 27/09/2020

// ----------------------------------

​

#include <stdio.h>

#include <stdlib.h>

#include <ctype.h>

​

#define TOTAL   5290000

#define MAX_BUF 256

​

int value(char c) {

  if (c<'K') return c-'A';

  if (c<'W') return c-'A'-1;

  if (c<'Y') return c-'A'-2;

  return c-'A'-3;

}

​

int convert(char *s) {

  int sum = 0;

  if (isalpha(s[0]) && isalpha(s[6])) sum += TOTAL*3;

  else if (isalpha(s[3])) sum += TOTAL*2;

  else if (isalpha(s[6])) sum += TOTAL;

​

  int ans = 0;

  int base = 1;

  for (int i=7; i>=0; i--)

    if (isdigit(s[i])) {

      ans += base * (s[i]-'0');

      base *= 10;

    }

​

  for (int i=7; i>=0; i--)

    if (isalpha(s[i])) {

      ans += base * value(s[i]);

      base *= 23;

    }

  return ans + sum;

}

​

int main() {

  int t;

  char m1[MAX_BUF], m2[MAX_BUF];



  scanf("%d", &t);

  for (int i=0; i<t; i++) {

    scanf("%s %s", m1, m2);

    int v1 = convert(m1);

    int v2 = convert(m2);

    //printf("%d | %d %d | %s %s\n", abs(v1-v2), v1, v2, m1, m2);

    printf("%d\n", abs(v1-v2));

  }



  return 0;

}
