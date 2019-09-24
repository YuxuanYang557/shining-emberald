package part6;

public class Backtrack1 {
		public static void main(String[] args) {
			climbStairs(2);
			System.out.println();
		}

	    public static int climbStairs(int n) {
	        int count=0 ;
	        backtrack(count, 0, 0, 0, n);
	        return count;
	        
	                   
	    }
	    public static void backtrack(int count,int cur, int i, int j, int n){
	        if(cur == n ) {
	        count++;
	        return; }
	            
	        if(cur < n){
	            backtrack(count,cur+1,i+1,j,n);
	        }
	        if(j <3 ){
	            backtrack(count,cur+2,i,j+1,n);
	        }
	    }
}
