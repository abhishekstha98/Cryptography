package cryptography;

import java.util.Scanner;

public class MonoAlphabeticCipher {
	public static void main(String[] args) {
		 String msg,pt="",key,a2="",a="abcdefghijklmnopqrstuvwxyz";
		 Scanner sc = new Scanner(System.in);
		 int n = 26,x;
//		 System.out.println("enter the key to generate cipher text");
//		 key = sc.next();
		 key="qwerjyuikpasdfgrtolzxcvbnm";
		 int n1 = key.length();
		 System.out.println(n1);
		 for(int i =0;i<n;i++) {
			 x=i % n1;
		     a2 =a2 + key.charAt(x);
		 }
		     System.out.println("key is : ");
		 for(int i =0;i<n;i++) {
		     System.out.print(a2.charAt(i));
		 }
		 System.out.println();
		 System.out.println("enter the message to encrypt : ");
	     msg = sc.next();
	     
	     
	     int x1 = msg.length();
	     for(int i =0 ; i<msg.length() ; i++){
	    	 for(int j = 0 ; j<a.length() ; j++) {
	    		 if(a.charAt(j)==msg.charAt(i)) {
	    			 pt=pt+a2.charAt(j);
	    		 }
	    		 else {
	    			 continue;
	    		 }
	    	 }
		 }
		 System.out.println(pt);
		 sc.close();
	}
}
