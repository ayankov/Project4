//Alexei Yankovsky
//Lab section 4
//Assignment 4

package project4;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
    	

    	  // Be sure that the user has provided arguments.
        if(args.length == 0 || args.length > 1) {
            System.err.println("Incorrect number of parameters:  " + args.length + ".");
            System.err.println("Should be 1.");
            System.exit(1);
        }

        // Get a path to the file specified.
        Path path = null;
        try {
            path = Paths.get(args[0]);
        } catch(InvalidPathException e) {
            System.err.println("Could not resolve the given filepath: " + args[0] + ".");
            System.exit(1);
        }

    	int n=2;

    	@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
    	while(n!=0 && n!=1){
    	System.out.println("Enter 0 to use JCL set objects or 1 to use custom set objects: ");
    	n = reader.nextInt();
    	}
    	
        GenericSetExtended[] sets = new GenericSetExtended[100];
        int setCount = 0;
        
        // Read all of the lines from the file.
    	if(n==0){
	        try {
	            for (String line : Files.readAllLines(path)) {
	                if (setCount % 2 == 0) {
	                    sets[setCount] = (GenericSetExtended) new HashSet(100);
	                } else {
	                    sets[setCount] = (GenericSetExtended) new TreeSet();
	                }
	
	                for (String word : line.split("\\W+")) {
	                    if (!sets[setCount].contains(word)) {
	                        sets[setCount].insert(word);
	                    }
	                }
	                ++setCount;
	            }
	        } catch (IOException e) {
	            System.err.println("Coud not read all lines from the file at the given path.");
	        }
    	}
    	else{
    		try {
	            for (String line : Files.readAllLines(path)) {
	                if (setCount % 2 == 0) {
	                    sets[setCount] = (GenericSetExtended) new GenericSet1();
	                } else {
	                    sets[setCount] = (GenericSetExtended) new GenericSet2();
	                }
	
	                for (String word : line.split("\\W+")) {
	                    if (!sets[setCount].contains(word)) {
	                        sets[setCount].insert(word);
	                    }
	                }
	                ++setCount;
	            }
	        } catch (IOException e) {
	            System.err.println("Coud not read all lines from the file at the given path.");
	        }
    		
    	}
    	
    	
    	
    	
        for (int i = 0; i < setCount; i += 2) {
            GenericSet1 union = new GenericSet1(), intersection = new GenericSet1(), difference = new GenericSet1();

            sets[i].union(sets[i + 1]);
            sets[i].intersect(sets[i + 1]);
            sets[i].difference(sets[i + 1]);

            // Print all of the sets, including the state of the initial sets.
            System.out.println("First line: " + sets[i]);
            System.out.println("Second line: " + sets[i + 1]);

            System.out.println();

            System.out.println("Union: " + union);
            System.out.println("Intersection: " + intersection);
            System.out.println("Difference: " + difference);

            System.out.println();
            
        }
      
    	

    }
}
