package playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FastReader{
    BufferedReader br;
    StringTokenizer st;

    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        try {
            if (st == null || !st.hasMoreElements()){
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        return st.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(this.next());
    }

    public double nextDouble(){
        return Double.parseDouble(this.next());
    }

    public String nextLine(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
public class FastInput {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int n = scan.nextInt();
        System.out.println(n);
    }
}
