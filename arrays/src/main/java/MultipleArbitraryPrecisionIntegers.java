import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultipleArbitraryPrecisionIntegers {

    /*
    6.3
    */

    public static List<Integer> multiply(List<Integer> a, List<Integer> b) {
    	int sign = (a.get(0) ^ b.get(0)) < 0 ? -1 : 1;
    	List<Integer> result = new ArrayList<>(Collections.nCopies(a.size() + b.size(), 0));
    	
    	for (int i = a.size()-1; i >=0 ; i--) {
			for (int j = b.size()-1; j >=0; j--) {
				
				int temp = result.get(i+j+1) + (a.get(i)*b.get(j));
				result.set(i+j+1, temp);
				result.set(i+j, result.get(i+j) + temp/10);
				result.set(i+j+1, temp%10);
			}
		}
    	
    	result = removeFrontZeros(result);
    	
    	if(result.isEmpty()) {
    		return Arrays.asList(0);
    	}
    	
    	result.set(0, result.get(0) * sign);
        return result;
    }
    
    private static List<Integer> removeFrontZeros(List<Integer> result) {
    	int index = 0;
		while(index < result.size() && result.get(index) == 0) {
			index++;
		}
		return result.subList(index, result.size());
	}

	public static void main(String[] args) {
		List<Integer> l = multiply(Arrays.asList(0), Arrays.asList(1,2));
		
		l.forEach(System.out::print);
	}
    
}
