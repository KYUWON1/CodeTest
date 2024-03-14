package JavaPractice.Practice1;

public class Practice3 {
    public static String solution(char[] str, char[] find, char[] to) {
        int idx = 0;
        String replaceStr = "";
        char[] replaceArr = str.clone();

        do {
            idx = findIndex(replaceArr,find);

            if(idx != -1){
                for (int i = 0; i < idx; i++) {
                    replaceStr += replaceArr[i];
                }
                for(int i = 0; i< to.length; i++){
                    replaceStr += to[i];
                }
                for (int i = idx + find.length; i < replaceArr.length; i++) {
                    replaceStr += replaceArr[i];
                }
                replaceArr = replaceStr.toCharArray();
                replaceStr = "";
            }
        }while(idx != -1);
        //모든 단어를 찾은후에 리턴
        replaceStr = new String(replaceArr);
        return replaceStr;
    }

    public static int findIndex(char[] str, char[]find){
        int idx = -1;
        boolean isFind = false;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == find[0] && str.length - i >= find.length) { // find의 첫번째와 같다면
                isFind = true;
                for (int j = 1; j < find.length; j++) { // find의 길이만큼 비교, 첫번째는 이미 같으니까
                    if (str[i + j] != find[j]) {
                        isFind = false;
                        break;
                    }
                }
            }
            if(isFind){
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        // Test code
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 String replace
        System.out.println(str.replace(find, to));

        // 자체 구현 replace
        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}
