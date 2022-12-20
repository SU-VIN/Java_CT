import java.util.Arrays;
//레벨1 탐욕법 체육복 수정
public class PRO_CT_5 {
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost); //정렬시켜주기
        Arrays.sort(reserve); //정렬시켜주기
        int answer = 0;
        int lostIdx =0;
        int reserveIdx=0;
        int[] arr = new int[n];
        Arrays.fill(arr,1);//기본1로 채우고 lost면 -1 reserve면 +1 시켜줄거다

        //1. 여벌옷있을시 2, 기본 1, 도난 당했을시 0 으로 배열을 채워준다
        for(int i=1;i<=n;i++){
            if(i==reserve[reserveIdx]){
                arr[i-1]++; //+1해준다
                if(reserveIdx<reserve.length-1)reserveIdx++; //이거안해주면 index에러나용
            }
            if(i==lost[lostIdx]){
                arr[i-1]--; //-1해준다
                if(lostIdx<lost.length-1) lostIdx++;
            }
        }

        //2.나 자신이2이고 양옆들이 0일때만 나는-1 옆은+1 해준다
        for(int i=0;i<n;i++){
            if(i==0){// 0번 index일땐 바로앞만 비교해줌
                if(arr[i]==2&&arr[i+1]==0){
                    arr[i]--;
                    arr[i+1]++;
                }
            }
            if (i==n-1){ //마지막 index일땐 바로전만 비교해줌
                if(arr[i]==2&&arr[i-1]==0){
                    arr[i]--;
                    arr[i-1]++;
                }
            }
            if(i>0&&i<n-1){ //아니라면 나의 왼쪽부터 비교해줌
                if(arr[i]==2&&arr[i-1]==0){
                    arr[i]--;
                    arr[i-1]++;
                }
                if(arr[i]==2&&arr[i+1]==0){ //다음 오른쪽비교
                    arr[i]--;
                    arr[i+1]++;
                }
            }
        }

        //3.최종계산
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) answer++; //최종배열에서 0보다 클때만 answer++해준다
        }
        return answer;
    }
    public static void main(String[] args) {
        int n=5;
        int[] lost = {4,2};
        int[] reserve = {3,5};
        System.out.println(solution(n,lost,reserve));
    }
}
