import java.util.*;

/*
	A program that converts two base-10 numbers to binary and calculates the logical AND/OR of the two numbers
*/
public class BitWise
{
	public static void main(String[] args)
	{

		int cont;
		do
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the max number of bits to use: ");
			int maxBits = input.nextInt();
			System.out.print("Enter a number: ");
			int number1 = input.nextInt();
			System.out.print("\n");

			int quotient1 = number1; 
			int n = maxBits;
			int binaryStr1[] = new int[n];
			while (quotient1 >= 1 && (n - 1) >= 0)
			{
				if ((quotient1 % 2) != 0) // oddness test
				{
					binaryStr1[n - 1] = 1;
					quotient1 = (quotient1 / 2);
				}
				else if ((quotient1 % 2) == 0) // evenness test
				{

					binaryStr1[n - 1] = 0;
					quotient1 = (quotient1 / 2);
				}
				n--;
			}

			n = maxBits; // reset n
			StringBuffer stringBuffer1 = new StringBuffer(n);
			System.out.print(number1 + " in binary is: ");
			for (int i = 0; i < n; i++)
			{
				stringBuffer1.append(binaryStr1[i]);
			}
			System.out.print(stringBuffer1);
			System.out.print("\n");




			System.out.print("\nEnter second number: ");
			int number2 = input.nextInt();
			System.out.print("\n");

			int quotient2 = number2; 
			int m = maxBits;
			int binaryStr2[] = new int[m];
			while (quotient2 >= 1 && (m - 1) >= 0)
			{
				if ((quotient2 % 2) != 0) // oddness test
				{
					binaryStr2[m - 1] = 1;
					quotient2 = (quotient2 / 2);
				}
				else if ((quotient2 % 2) == 0) // evenness test
				{

					binaryStr2[m - 1] = 0;
					quotient2 = (quotient2 / 2);
				}
				m--;
			}
			m = maxBits;
			StringBuffer stringBuffer2 = new StringBuffer(m);
			System.out.print(number2 + " in binary is: ");
			for (int i = 0; i < m; i++)
			{
				stringBuffer2.append(binaryStr2[i]);
			}
			System.out.print(stringBuffer2);

			int orNumber3 = (number1 | number2);
			int andNumber3 = (number1 & number2);




			System.out.println("\n\nEnter 1 for " + '\"' + "OR" + '\"' + " or 2 for " + '\"' + "AND" + '\"' + "\n");

			Scanner orAnd = new Scanner(System.in);
			int orAnd1 = orAnd.nextInt();
			System.out.print("\n");



			if (orAnd1 == 1)
			{
				System.out.println("Operation is OR (|)\n");
				n = maxBits;
				m = maxBits;
				System.out.print(stringBuffer1 + "     = " + number1);
				System.out.print("\n");
				
				System.out.print(stringBuffer2 + "     = " + number2 + "\n");
				for(int i = 0; i < m; i++){
					System.out.print("-"); // print a divider between the operands and the result
				}
				System.out.print("\n");

				n = 0;
				StringBuffer stringBuffer3 = new StringBuffer(maxBits);
				while(n < binaryStr1.length && n < binaryStr2.length){
					stringBuffer3.append(binaryStr1[n] | binaryStr2[n]);
					n++;
				}
				System.out.print(stringBuffer3);
				System.out.print("     = " + orNumber3);
				System.out.println("\n\n" + number1 + " | " + number2 + " = " + (number1 | number2));
			}


			if (orAnd1 == 2)
			{
				System.out.println("Operation is AND (&)\n");
				n = maxBits;
				m = maxBits;
				System.out.print(stringBuffer1 + "     = " + number1 + "\n");
				System.out.print(stringBuffer2 + "     = " + number2 + "\n");
				for (int i = 0; i < m; i++){
					System.out.print("-");
				}
				System.out.print("\n");
			
				n = 0;
				StringBuffer stringBuffer3 = new StringBuffer(maxBits);
				while(n < binaryStr1.length && n < binaryStr2.length){
					stringBuffer3.append(binaryStr1[n] & binaryStr2[n]);
					n++;
				}
				System.out.print(stringBuffer3);
				System.out.print("     = " + andNumber3);
				System.out.println("\n\n" + number1 + " & " + number2 + " = " + (number1 & number2));
			}

			Scanner askCont = new Scanner(System.in);
			System.out.println("Continue? (1 = yes / 2 = no)" + '\n' + '\n');
			cont = askCont.nextInt();
		}
		while (cont == 1);

		System.out.println("\n" + "Thanks for playing!");

	}
}
