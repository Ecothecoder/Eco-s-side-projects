package ecocodingpackage;

public class test {
	private static int num = 10;
	private static int total = 1;
	public static void main(String[] args) {
		factorial(num);
	}
public static int factorial(int num){
	if (num == 0)
		System.out.print(total); 
	else {
	total *= factorial(num-1);
	System.out.print(total);
	}
	return total;
	
	
	
}
}
