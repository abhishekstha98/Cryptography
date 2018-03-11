package playfair;

import java.util.Scanner;

public class PlayFairCipher {
	public static void encrypt(String msg,char k_mat[][]) {
		Scanner sc = new Scanner(System.in);
		String a1,ct="",str="",key;
		msg = msg.replaceAll(" ", "");	//removing all the white spaces
		for(int q=0;q<msg.length()-1;q++) {	//loop for inserting letter x between two consecutive letters
			if(msg.charAt(q)==msg.charAt(q+1)) {
				msg = msg.substring(0, q+1)+"x"+msg.substring(q+1,msg.length());
			}
		}
		if(msg.length()%2!=0) {
			msg=msg+"x";
		}
//		System.out.println(msg);
		for(int q=0;q<msg.length();q++){	//loop for finding the position of letters in key matrix
			for(int i =0 ; i< 5;i++){
				for(int j=0 ; j< 5 ; j++) {
					if(k_mat[i][j]==msg.charAt(q)) {
						str = str + String.valueOf(i) + String.valueOf(j);
					}
					else {
						
					}
				}
			}
		}
		for(int i =0; i< str.length();i+=4) {
			if(str.charAt(i)==str.charAt(i+2)) { //if same row 
				int p1 = Integer.valueOf(str.substring(i,i+1));
				int p2 = (Integer.valueOf(str.substring(i+1,i+2))+1)%5;
				int p3 = Integer.valueOf(str.substring(i+2,i+3));
				int p4 = (Integer.valueOf(str.substring(i+3,i+4))+1)%5;
				ct = ct + k_mat[p1][p2] + k_mat[p3][p4] + " ";
			}
			else if(str.charAt(i+1)==str.charAt(i+3)) {  // if same column
				int p1 = (Integer.valueOf(str.substring(i,i+1))+4)%5;
				int p2 = Integer.valueOf(str.substring(i+1,i+2));
				int p3 = (Integer.valueOf(str.substring(i+2,i+3))+4)%5;
				int p4 = Integer.valueOf(str.substring(i+3,i+4));
				ct = ct + k_mat[p1][p2] + k_mat[p3][p4]+ " ";
			}else{
				int p1 = Integer.valueOf(str.substring(i,i+1));
				int p4 = Integer.valueOf(str.substring(i+1,i+2));
				int p3 = Integer.valueOf(str.substring(i+2,i+3));
				int p2 = Integer.valueOf(str.substring(i+3,i+4));
				ct = ct + k_mat[p1][p2] + k_mat[p3][p4]+ " ";
			}
		}
		System.out.println(ct);
		sc.close();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a1,ct="",msg,str="",key;
		char a='a';
		int k=0;
		char k_mat[][]= new char[5][5];
		System.out.println("enter key");
		key = sc.nextLine();
		key = key.replaceAll(" ", "");	// for removing the white spaces in the provided key
		System.out.println();
		a1=key.substring(0,1);
		for(int x1 = 1 ; x1< key.length();x1++) {	//loop for removing the repeating letters in the provided key
			if(!a1.contains(String.valueOf(key.charAt(x1)))) {
				a1=a1+String.valueOf(key.charAt(x1));
			}
			else {
				continue;
			}
		}
		key=a1;
		for(int i =0 ; i < 5 ; i++) {	// loop for making the key matrix using the given key
			for(int j =0 ; j < 5 ; j++) {
				if (k<key.length())
						k_mat[i][j]=key.charAt(k);
				else {
					if(key.contains(String.valueOf(a))) {
						while(key.contains(String.valueOf(a))) {
							a++;
						}
						k_mat[i][j]=a++;
					}
					else {
						k_mat[i][j]=a++;
					}
				}
				k++;
			}
		}
		System.out.println("let the letters y and z be put in to the same index of matrix");
		System.out.println("enter the message to encrypt : ");
		msg = sc.nextLine();
		encrypt(msg, k_mat);
		
//		for(int i =0 ; i < 5 ; i++) {
//			for(int j =0 ; j < 5 ; j++) {
//				System.out.print(k_mat[i][j]);
//			}
//			System.out.println();
//		}
		
		sc.close();
	}
}
