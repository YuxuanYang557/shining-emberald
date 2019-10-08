package debug;

public class debug1 {
		public static void main(String[] args) {
			int [] test = new int[3];
			char[] test2 = new char[3];
			boolean[] test3 = new boolean[3];
			System.out.print(test3[0]);
			
			
		}

	    public static int trap(int[] height) {
	        int sum = 0;
	        int l = height.length;
	        for(int i = 0; i < l-1 ; i++){
	            if(height[i] > height[i+1]){
	                int k=0;
	                int max =0;
	                for(int j = i+1 ; j< l; j++){
	                    k += height[j];
	                    if(height[j] > height[j-1]){
	                        if(height[i] <= height[j]){
	                            sum += (j-i-1)*height[i] - k+height[j];
	                            i=j-1;
	                            break;
	                        }else{
	                            Math.max((j-i-1)*height[j] - k+height[j], max);
	                        }
	                    }
	                    sum += max;
	                }
	            }
	        }
	        return sum;
	    }
}
