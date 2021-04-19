import java.util.Scanner;


@SuppressWarnings("serial")
class OutOfRangeException extends Exception {
	public void printEx() {
		System.out.println("OutOfRangeException");
	}
}

@SuppressWarnings("serial")
class SubtractZeroException extends Exception {
	public void printEx() {
		System.out.println("SubtractZeroException");
	}
}

@SuppressWarnings("serial")
class AddZeroException extends Exception {
	public void printEx() {
		System.out.println("AddZeroException");
	}
}


public class SimpleCalculator {
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		try {
			String str = sc.nextLine();
			
			int plus = str.indexOf("+");
			int minus = str.indexOf("-");
			int flag = 0;	//1이면 더하기, 0이면 빼기
			
			
			int left = 0 , right = 0;
			
			if(plus > 0) {
				flag = 1;
				String[] num = str.split("\\+");
				left = Integer.parseInt(num[0]);
				right = Integer.parseInt(num[1]);
			}	
				
			if(minus > 0) {
				flag = 0;
				String[] num = str.split("\\-");
				left = Integer.parseInt(num[0]);
				right = Integer.parseInt(num[1]);
			}
			
			int result = 0;
			
			if(flag == 1)
				result = left + right;
			if(flag == 0)
				result = left - right;
			
			if(flag == 1 && (left == 0 || right == 0))
				throw new AddZeroException();
			
			if(flag == 0 && (left == 0 || right == 0))
				throw new SubtractZeroException();
			
			if (result < 0 || result > 1000 || right < 0 || right > 1000 || left < 0 || left > 1000) 
				throw new OutOfRangeException();
			
			System.out.println(result);
				
		}catch(AddZeroException e) {
			e.printEx();
			//e.printStackTrace();
		}catch(SubtractZeroException e) {
			e.printEx();
			//e.printStackTrace();
		}catch(OutOfRangeException e) {
			e.printEx();
			//e.printStackTrace();
		}finally {
			sc.close();
		}

	}
	


}
