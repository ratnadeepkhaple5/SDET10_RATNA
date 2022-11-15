package javapractice;

import java.util.Scanner;

public class String1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("enter name : ");
		String name="Bhavan@1";
	
		int lettercount=0;
		int digitcount=0;
		int uppercount=0;
		int lowercount=0;
		int spcharcount=0;
		
		if (name.length()==8) {
		
			System.out.println("length varified= "+name.length());
			
			for (int i = 0; i < name.length(); i++) {
				
				if (Character.isLetter(name.charAt(i)) ) {
					lettercount++;
				}
				if (Character.isUpperCase(name.charAt(i))) {
					uppercount++;
				}
				if (Character.isLowerCase(name.charAt(i))) {
					lowercount++;
				}
				if (Character.isDigit(name.charAt(i))) {
					digitcount++;
				}
				if (!Character.isDigit(name.charAt(i)) && 
					!Character.isLetter(name.charAt(i)) &&
					!Character.isWhitespace(name.charAt(i))) {
					spcharcount++;
				}
			}
			/*
			System.out.println(lettercount);
			System.out.println(digitcount);
			System.out.println(uppercount);
			System.out.println(lowercount);
			System.out.println(spcharcount);
			*/
			if (uppercount>=1 && lowercount>=1 && digitcount>=1 && spcharcount>=1) {
				System.out.println(name);
				System.out.println("valid password");
			}
			else {
				System.out.println("invalid data: must contains Uppercase,Lowercase,"
						+ "Digit,Special Character");
			}
		}
	}

}
