import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName Test
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/10/8  21:03
 * @Veresion 1.0
 */
public class CalCount {
    public static Map<Integer,Integer> CalCount(int[] nums){
        Map<Integer,Integer> map=new TreeMap<>();
      for(int n:nums){
         int c=map.getOrDefault(n,0);
         map.put(n,c+1);
      }
      return map;
    }

    public static void main(String[] args) {
        int[] nums={1,5,9,3,1,5,9,8,7,6,3};
        Map<Integer,Integer> map=CalCount(nums);
        System.out.println(map);
    }
}
