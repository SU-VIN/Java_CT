public class javatest {
    public static void main(String[] args) {

        String num = "010-1111-1111";
        System.out.println(num.indexOf("-",4));
        //특정 문자 이후로 자르고 싶을때


        //공백으로 잘라 배열에 넣기
        String str = "안녕하세요 저는 자바 입니다.";
        String[] arr = str.split(" ");

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
