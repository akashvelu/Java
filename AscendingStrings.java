import java.util.Scanner;

public class AscendingStrings {

	//hi

	public static int getRight(String s, int start, int end) {
		String result = "";
		while (start > end) {
			result += s.substring(start, start+1);
			start--;
		}
		return Integer.parseInt(result);
	}

	public static void solve(String s) {
		boolean found = true;
		int rInd = 1; 
		int rInd2 = 2; 
		int lInd = s.length()-1; 
		int lInd2 = lInd - 1;
		int num = Integer.parseInt(s.substring(0,1));
		System.out.print(num + " ");
		int side = 1; 
		int output = 0; 

		while (found) {
			if (side == 0) {
				side = 1; 
				output = Integer.parseInt(s.substring(rInd, rInd2));
				while (output <= num) {
					rInd2++; 
					output = Integer.parseInt(s.substring(rInd, rInd2));
				}
				rInd = rInd2; 
				rInd2 = rInd+1; 
			}
			else if (side == 1) {
				side = 0; 
				output = getRight(s, lInd, lInd2);
				while (output <= num) {
					lInd2--; 
					output = getRight(s, lInd, lInd2);
				}
				lInd = lInd2; 
				lInd2 = lInd - 1; 

			}

			if (rInd > lInd+1) {
				found = false;
			}
			else {
				System.out.print(output + " ");
				num = output; 
			}			
		}
		System.out.println();
	}

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String input; 
		for (int i = 0; i < 5; i++) {
			input = scan.nextLine();
			solve(input);
		}		
	}
}