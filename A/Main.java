
import java.util.*;


// A. Mystic Waves
public class Main {
    private int number;
    private int waves;

    public Main(int number, int waves) {
        this.number = number;
        this.waves = waves;
    }
    
    public static void main(String[] args) {
        List<Main> testCases = new ArrayList<>();
        testCases.add(new Main(1, 4 ));
        testCases.add(new Main(2, 5));
        testCases.add(new Main(3, 6));
        testCases.add(new Main(4, 7));
        System.out.println(testCases.size());

        for(int i=0; i<testCases.size(); i++) {
            Main testCase = testCases.get(i);
            int res= testCase.mysticWaves(testCase.number, testCase.waves);
            //int resTest=testCase.mysticWaves2(testCase.number, testCase.waves);
            //System.out.println(resTest);
            System.out.println(res);
        }
    }

    public int mysticWaves(int number, int testCase) {
        int res = 0;
        for(int i=1; i<=testCase; i++) {
            int seq=i%2;
            if(seq==0){
                res-=number;
            }else{
                res+=number;
            }
        }
        return res;
    }
    public int mysticWaves2(int number, int testCase) {
        int res=0;
        int sum=testCase%2;
        if(sum!=0){
            res=number;
        }
        return res;
    }
}
