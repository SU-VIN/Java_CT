import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//문자열 - 문자열폭발 골드4

public class BJ_CT_26 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if(stack.size()>=bomb.length()){
                boolean isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size()-bomb.length()+j)!=bomb.charAt(j)){
                        isBomb=false;
                        break;
                    }


                }
                if(isBomb){
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }

            }
            
        }

        if(stack.size()==0){
            bw.write("FRULA");
        }else{
           for(Character c : stack){
            bw.write(c);
           }
        }

        bw.flush();
    }
    
}
