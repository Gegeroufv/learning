package dataStructure.chapter2;

/**
 * @author leviathan
 * @version 1.0
 * @date 2019/9/20 11:08
 */
//计算特定的二项式 递归处理
public class Exer6 {
    public static void main(String[] args) {
        double v = calBinomial(10, 3);
        System.out.println(v);
    }
    //count>0
    private static double calBinomial(int num,int count){
        if(count==1){
            return num;
        }else {
            return Math.pow(-1, count-1)*Math.pow(num,count)+calBinomial(num,count-1);
        }
    }
}
