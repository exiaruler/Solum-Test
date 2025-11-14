
import java.util.*;
// B. CargoCraft Fleet
public class Main {
    // test case/propulsion
    private long propulsion;

    public Main(long propulsion) {
        this.propulsion = propulsion;
    }
    public static void main(String[] args) {
            List<Main> testCases = new ArrayList<>();
            // test cases
            testCases.add(new Main(4));
            testCases.add(new Main(7));
            testCases.add(new Main(24));
            testCases.add(new Main(998244353998244352L));
            testCases.add(new Main(50));
            System.out.println("Test cases in total "+testCases.size());
            // loop through test cases
            for(int i=0; i<testCases.size(); i++) {
                Main testCase = testCases.get(i);
                System.out.println("Input: "+testCase.propulsion);
                long [] result = testCase.cargoCraft(testCase.propulsion);
                
                if(result[0]==-1&&result[1]==-1){
                    System.out.println("Output: "+result[0]);
                }else System.out.println("Output: "+result[0]+" "+result[1]);
                
                
            }
    }
    public long [] cargoCraft(long input) {
        long [] result ={-1,-1};
        long typeA=4;
        long typeB=6;
        long divSum=0;
        if(input>=typeA||input>=typeB){
            // find possibilites from type A and type B first
            long minRem=input%typeA;
            long maxRem=input%typeB;
            long divRem=input%2;
            if(minRem==0){
                result[0]=input/typeA;
                result[1]=input/typeA;
            }else
            {
                long res=remainderCalculate(input, typeA, typeB);
                result[0]=res;
                result[1]=res;
            }

            if(maxRem==0){
                result[1]=input/typeB;
            }else
            {
                long res=remainderCalculate(input, typeB, typeA);
                if(res!=-1)result[1]=res;
            }
            // find possibilities through division
            if(divRem==0){
                long div=input/2;
                long aPart=0,bPart=0;
                long aRem=div%typeA;
                long bRem=div%typeB;
                if(aRem==0){
                    aPart=div/typeA;
                }else
                {   
                    aPart=divisionRemainCalculate(div, typeA,input,0);
                }

                if(bRem==0){
                    bPart=div/typeB;
                }else
                {
                    bPart=divisionRemainCalculate(div, typeB,input,aPart*typeA);
                }
                if(aPart>0&&bPart>0) divSum=aPart+bPart;
            }
            if(result[0]>result[1]){
                long maxTemp=result[0];
                result[0]=result[1];
                result[1]=maxTemp;
            }
            if(divSum>0){
                if(divSum<result[0]){
                    result[0]=divSum;
                }
                if(divSum>result[1]) result[1]=divSum;
            }
        }
        
        return result;
    }
    // calculate potential possibility using single craft
    public long remainderCalculate(long input,long aType,long bType){
        long multi=(input/aType)-1;
        long sum=aType*multi;
        long bsum=input-sum;
        long times=bsum/bType;
        if((aType*multi)+(bType*times)==input){
            multi+=times;
        }else multi=-1;
        return multi;
    }
    // calculate potential possibility in divison in combination of both craft
    public long divisionRemainCalculate(long input,long type, long total,long current){
        long res=-1;
        long power=(input/type)-1;
        long firstSum=type*power;
        if(current>0&&total>0){
            long left=total-current;
            long remain=left-firstSum;
            long divRm=remain%type;
            long totalCheck=current+remain+firstSum;
            if(divRm==0&&totalCheck==total){
                long div=remain/type;
                res=(firstSum/type)+div;
            }
        }else res=firstSum/type;
        return res;
    }
    
}
