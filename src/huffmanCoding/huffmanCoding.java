package huffmanCoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import binaryHeap.binaryHeap;

public class huffmanCoding {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner user = new Scanner( System.in ); 
	    String  inputFileName, outputFileName;

	    // prepare the input file
	    System.out.print("Input File Name: ");
	    inputFileName = user.nextLine().trim();
	    File input = new File( inputFileName );      
	    Scanner scan = new Scanner( input ); 
	    System.out.println(scan.nextLine());
	    
	}
}
