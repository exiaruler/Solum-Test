
import java.util.*;


// A. Mystic Waves
public class Main {
    // x/number
    private int number;
    // n/waves
    private int waves;

    public Main(int number, int waves) {
        this.number = number;
        this.waves = waves;
    }
    
    public static void main(String[] args) {
        List<Main> testCases = new ArrayList<>();
        // test cases
        testCases.add(new Main(1, 4 ));
        testCases.add(new Main(2, 5));
        testCases.add(new Main(3, 6));
        testCases.add(new Main(4, 7));
        testCases.add(new Main(8, 0 ));
        System.out.println("Test cases in total "+testCases.size());
        // loop through test cases
        for(int i=0; i<testCases.size(); i++) {
            Main testCase = testCases.get(i);
            int res= testCase.mysticWaves(testCase.number, testCase.waves);
            System.out.println("Input: "+testCase.number+" "+testCase.waves);
            System.out.println("Result: "+res);
        }
    }
    
    public int mysticWaves(int number, int testCase) {
        int res=0;
        int sum=testCase%2;
        if(sum!=0){
            res=number;
        }
        return res;
    }
}
