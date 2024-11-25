// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2

		public static int plus(int x1, int x2) {
			int result = x1;
			if (x2 > 0) {
				for (int i = 0; i < x2; i++) {
					result++;
				}
			}
				else if (x2==0){
					return x1;
				}
			 else {
				for (int i = 0; i < -x2; i++) {
					result--;
				}
			}
			return result;
		}
	

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int min = x1;
	
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				min--; 
			}
		} else if (x2 < 0) {
			int absX2 = 0;
			for (int i = 0; i > x2; i--) {
				absX2++; 
			}
	
			for (int i = 0; i < absX2; i++) {
				min++; 
			}
			
		}
		return min;
	}
	
	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 <0 && x2<0){
			x1 = minus(0, x1);
			x2 = minus(0, x2);

			int difference = 0;
		for (int i=0; i< x2 ; i++){
			difference = plus(difference, x1);
		}
		return difference;
	}
	else if (x1 <0 && x2>0 ){
		x1 = minus(0, x1);
		int difference = 0;
		for (int i=0; i< x2 ; i++){
			difference = plus(difference, x1);
			difference = minus(0, difference);
		}
		return difference;
		
	}
	else if(x1 >0 && x2<0){
		x2 = minus(0, x2);
		int difference = 0;
		for (int i=0; i< x2 ; i++){
			difference = plus(difference, x1);
			difference = minus(0, difference);
		}
		return difference;
	}
		else{
			int difference = 0;
		for (int i=0; i< x2 ; i++){
			difference = plus(difference, x1);
		}
		return difference;
	}
}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		
		if (n==0){
			return 1;
		}
		else{
		int pow = 1;
		for (int i=0; i< n ; i++){
			pow = times(pow, x);
		}
		return pow;
}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 == 0) {
			return -1; 
		}
		else if (0<=x1 && x1<x2){
		return 0;
		}

		boolean isNegative = false;
    if (x1 < 0 && x2 < 0) {
        x1 = minus(0, x1); 
        x2 = minus(0, x2);

    } else if (x1 < 0 || x2 < 0) {
        isNegative = true; 
		if (x1<0){
			x1 = minus(0, x1); 
		}
		else{
			x2 = minus(0, x2);
		}
	}
       
		int count = 0; 
		while (x1 >= x2) { 
		x1 = minus(x1, x2);
			count++; 
			
			}
		
		if (isNegative == true) {
			return minus(0, count);
    }
		return count; 
	}


	
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) {
			return -1;
		}
		else if (x1==0){
			return 0;
		}
		else{
			boolean isNegative = false;

			if (x1 < 0 && x2 < 0) {
				x1 = minus(0, x1); 
				x2 = minus(0, x2);

			} else if (x1 < 0 || x2 < 0) {
				isNegative = true;
				if (x1 < 0) {
					x1 = minus(0, x1);
				} else {
					x2 = minus(0, x2);
				}
			}
		
			while (x1 >= x2) {
				x1 = minus(x1, x2);
			}
		

			if (isNegative == true) {
			return minus(0, x1);
		}
			return x1;
	}
	
}



	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) {
			return -1; 
		}
		else if(x == 0){
			return 0;
		}
		else{
			int guess = 0;
		while (times(guess, guess)<= x){
			guess++;
		}
        
		return guess-1;
	}	
}  	  
}