import java.util.Arrays;
import java.util.Stack;
//레벨1 카카오 크레인 인형뽑기
public class PRO_CT_6 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                int a= moves[i]-1;
                if(board[j][a]!=0){
                    if(st.isEmpty()){
                        st.push(board[j][a]);
                    }
                    else if(st.peek()==board[j][a]){
                        answer++;
                        answer++;
                        st.pop();
                    }else{
                        st.push(board[j][a]);
                    }
                    board[j][a]=0;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] board= {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
}
