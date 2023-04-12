import java.util.Arrays;
import java.util.Comparator;

//레벨2 파일명 정렬

public class PRO_CT_42 {

    static class File{
        String fileName;
        String head;
        int number;
        
        public File(String fileName, String head, int number){
            this.fileName=fileName;
            this.head=head;
            this.number=number;
        }
    }


    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        File[] file_info = new File[files.length];

        for (int i = 0; i < files.length; i++) {
            String[] split = splitFile(files[i]);
            //원본이름 /소문자로변경한 head / number
            file_info[i]=new File(files[i],split[0],Integer.parseInt(split[1]));
        }

        Arrays.sort(file_info, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2){
                if((o1.head).equals(o2.head)){ //head가 같다면
                    return o1.number-o2.number; //number 오름차순으로 정렬
                }else{                          //head가 다르다면
                    return(o1.head).compareTo(o2.head); //head 오름차순 정렬
                }
            }

        });

        for (int i = 0; i < files.length; i++) {
            answer[i]=file_info[i].fileName;
            System.out.println(answer[i]);
        }


        return answer;
    }


    //파일명 구분
    public static String[] splitFile(String file){
        String[] str = new String[3];
        //0 = head 1 = number 2 = tail
        str[0] = ""; // HEAD
        str[1] = ""; // NUMBER
        str[2] = ""; // TAIL
        int index = 0;
        for (int i = 0; i < file.length(); i++) {
            char c = file.charAt(i); //한글자씩 받아오기
            if(index==0&&!Character.isDigit(c) ){ //head면서 가져온 한글자가 숫자가아닐때
                str[index]+=c;
                continue;
            }

            if(index==0&&Character.isDigit(c)){//head면서 가져온 한글자가 숫자일때
                index++; //number로 넘어가기
            }

            if(index==1&&Character.isDigit(c)){ //number이면서 가져온 한글자가 숫자일때
                str[index]+=c;
                continue;
            }

            if(index==1&&!Character.isDigit(c)){//number이면서 가져온 한글자가 숫자가 아닐때
                index++;//tail로 넘어가
            }
            str[index]+=c; //tail저장
        }

        str[0]=str[0].toLowerCase();
        return str;
    }



    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        //결과 "img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"

        System.out.println(solution(files));
    }
}
