
//레벨1 신규 아이디 추천
public class PRO_CT_10 {
    public static String solution(String new_id) {
        String answer = "";
        StringBuilder result = new StringBuilder();

        /* ---------1번------------*/
        new_id=new_id.toLowerCase();
        System.out.println("1번 "+new_id);


        /* ---------2번------------*/
        new_id=new_id.replaceAll("[^a-z0-9-_.]","");
        System.out.println("2번 "+new_id);


        /* ---------3번------------*/
        StringBuilder sb = new StringBuilder(new_id); //효율성 높이기 위해 StringBuilder사용
        for(int i=0;i<=sb.length()-2;i++){ //문자열을 순회 하고
            if(sb.charAt(i)=='.'&&sb.charAt(i+1)=='.'){ //앞뒤가 둘다 . 이면
                sb=sb.deleteCharAt(i);// StringBuilder의 deleteCharAt 을 통해 해당 인덱스를 지워준다
                i=-1; //문자열 길이가 바꼈으니 i 리셋 해준다
            }
        }
        System.out.println("3번 "+sb);


        /* ---------4번------------*/
        if(sb.charAt(0)=='.') sb=sb.deleteCharAt(0);

        if(sb.length()>0){ //만약 . 이였으면 위의 처음 . 제거로 빈문자열이 되었으므로 꼭 길이를 확인해준다 아니면 에러나용
            if(sb.charAt(sb.length()-1)=='.')sb=sb.deleteCharAt(sb.length()-1);}

        System.out.println("4번 "+sb);



        /* ---------5번------------*/
        if(sb.length()==0) sb.append('a'); //StringBuilder append사용
        System.out.println("5번 "+sb);


        /* ---------6번------------*/
        if(sb.length()>=16){
            answer=sb.substring(0,15); //잘라주고
            result = new StringBuilder(answer);
            //잘랐을때 마지막 문자가 . 이면 삭제시켜준다
            if(result.charAt(result.length()-1)=='.')result=result.deleteCharAt(result.length()-1);
        }else{
            result=new StringBuilder(sb);
        }
        System.out.println("6번 "+result);


        /* ---------7번------------*/
        if(result.length()<=2){
            while (result.length()!=3){ //길이가 3 될때까지 마지막 문자 반복
                result.append(result.charAt(result.length()-1));

            }
        }
        System.out.println("7번 "+result);

        return result.toString();
    }
    public static void main(String[] args) {
        String new_id ="...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id));
    }
}
