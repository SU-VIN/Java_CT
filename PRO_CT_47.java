import java.util.*;
//레벨2 완전탐색 소수찾기 1h
public class PRO_CT_47 {
    static String number;
    static boolean[] visited;
    static ArrayList<Integer>list = new ArrayList<>();
    public static int solution(String numbers) {
        number=numbers;



        //모든 경우의 수
        for (int i = 0; i < numbers.length(); i++) {
            visited=new boolean[number.length()];
            visited[i]=true;
            backtraking(numbers.substring(i,i+1));
        }
        //중복 제거
        ArrayList<Integer>result= new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if(!result.contains(list.get(i))){
                result.add(list.get(i));
            }
        }

        int answer = 0;
        //소수인지 판별
        for (int i = 0; i < result.size(); i++) {
            if(isPrime(result.get(i)))answer++;
        }

        return answer;
    }

    public static void backtraking(String num){
        list.add(Integer.parseInt(num));

        for (int i = 0; i <number.length() ; i++) {
            if(!visited[i]){
                visited[i]=true;
                String str =num+number.substring(i,i+1);
                backtraking(str);
                str = str.substring(0,str.length()-1);
                visited[i]=false;


            }

        }

    }

    public static boolean isPrime(int num){
        if(num<2) return false;
        for (int i = 2; i <num ; i++) {
            if(num%i==0)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String numbers= "011";
        System.out.println(solution(numbers));
    }
}
