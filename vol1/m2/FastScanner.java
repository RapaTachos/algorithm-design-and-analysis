// FastScanner
// Pedro Ribeiro (DCC/FCUP)

import java.io.*;
import java.util.StringTokenizer;

class FastScanner {
    BufferedReader br;
    StringTokenizer st;
 
    public FastScanner(InputStream stream) {
	br = new BufferedReader(new InputStreamReader(stream));
    }
 
    String next() {
	while (st == null || !st.hasMoreElements()) {
	    try {
		st = new StringTokenizer(br.readLine());
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return st.nextToken();
    }
 
    int nextInt() {
	return Integer.parseInt(next());
    }
 
    long nextLong() {
	return Long.parseLong(next());
    }
 
    double nextDouble() {
	return Double.parseDouble(next());
    }
 
    String nextLine(){
	String str = "";
	try {
	    str = br.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return str;
    }

}
