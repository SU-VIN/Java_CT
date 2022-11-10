public class Ct12 {
    int[] numbers = {1,1,1,1,1};
    int target = 3;
    int answer;
    public int solution(int[] numbers, int target) {
        this.numbers=numbers;
        this.target=target;
        answer = 0;
        dfs(0,0);
        return answer;
    }

    void dfs(int index, int sum){
        //탈출 조건
        if(index == numbers.length){
            if(sum==target){
                answer++;
            }
            return;

        }
        //수행동작 재귀이기 때문에 다음 dfs를 호출해야함
        dfs(index+1,sum+numbers[index]);
        dfs(index+1,sum-numbers[index]);
    }
    public static void main(String[] args) {
        Ct12 sol = new Ct12();

        System.out.println(sol.solution(sol.numbers,sol.target));

    }
}
