
import java.util.*;

public class Main {

    private long propulsion;

    public Main(long propulsion) {
        this.propulsion = propulsion;
    }
    public static void main(String[] args) {
            List<Main> testCases = new ArrayList<>();
            testCases.add(new Main(50));
            testCases.add(new Main(4));
            testCases.add(new Main(7));
            testCases.add(new Main(24));
            testCases.add(new Main(998244353998244352L));
            System.out.println(testCases.size());
            for(int i=0; i<testCases.size(); i++) {
                Main testCase = testCases.get(i);
                long [] result = testCase.cargoCraft(testCase.propulsion);
                System.out.println(testCase.propulsion);
                if(result[0]==-1&&result[1]==-1){
                    System.out.println(result[0]);
                }else System.out.println(result[0]+" "+result[1]);
                
            }
    }
    public long [] cargoCraft(long input) {
        long [] result ={-1,-1};
        long typeA=4;
        long typeB=6;
        
        if(input>=typeA||input>=typeB){
            long minRem=input%typeA;
            long maxRem=input%typeB;
            if(minRem==0){
                result[0]=input/typeA;
                result[1]=input/typeA;
            }
            if(maxRem==0){
                result[1]=input/typeB;
            }
            if(result[0]>result[1]){
                long maxTemp=result[0];
                result[0]=result[1];
                result[1]=maxTemp;
            }
        }
        
        return result;
    }
}
