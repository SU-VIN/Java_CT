import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

//문자열 - 괄호 실버4
public class BJ_CT_25 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<String> dq = new ArrayDeque<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            for (int j = 0; j < ps.length(); j++) {
                if(dq.isEmpty()){
                    dq.addLast(ps.substring(j, j+1));
                    continue;
                }
                if(dq.peekLast().equals("(")&&ps.substring(j,j+1).equals(")")){
                    dq.pollLast();
                }else{
                    dq.addLast(ps.substring(j,j+1));
                }
            }
            if(dq.size()==0){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
            dq.clear();
        }
        bw.flush();

    
}
}
