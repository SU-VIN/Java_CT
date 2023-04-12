public class PRO_CT_40 {
    //레벨2 스킬트리
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt=0;
            //skill 문자 제외 문자는 무시함 ex) BACDE -> BCD
            for(int j=0;j<skill_trees[i].length();j++){
                
                if(skill.contains(skill_trees[i].substring(j,j+1))){
                    sb.append(skill_trees[i].substring(j,j+1));
                }else{
                    cnt++;
                }
            }
            if(cnt==skill_trees[i].length()) answer++; //스킬트리의 스킬이 아닐경우 ex) QWER

            //skill이 될 수 있는지 확인
            for(int j=0;j<sb.length();j++){
                String str = skill.substring(0, sb.length());
                if(str.equals(sb.toString())){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees={"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
}
