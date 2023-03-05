import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//이분탐색 실버4 암기왕
public class BJ_CT_20 {

    private static int N,M;
    private static int[] note1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            //데이터 넣기
            N=Integer.parseInt(br.readLine());
            note1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                note1[j]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1); //정렬시켜줌 이분탐색 하기 위함

            M=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                //이분탐색
                int left = 0;
                int right = N-1;
                int num = Integer.parseInt(st.nextToken()); //있는지 확인해야하는값
                boolean find = false;

                while (left<=right){
                    int mid = (left+right)/2;

                    if(note1[mid]==num){ //값이 있다면 find를 ture로 바꿔주고 break;
                        find=true;
                        break;
                    }else if(note1[mid]<num){ //note1의 값이 있는지 확인해야하는값보다 작다면
                        left=mid+1; //left+1 를 해준다
                    }else {
                        right = mid-1; //아니라면 right-1;
                    }
                }

                int result= find?1:0; //find의 값에따라 0,1를 넣어줌
                bw.write(result+" ");
            }

        }
        bw.flush();
    }


}
