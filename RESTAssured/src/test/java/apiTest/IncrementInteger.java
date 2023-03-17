package apiTest;
import java.io.*;

public class IncrementInteger {
	
	public static int increment() {
        int num = 0;
        int initNum = 25; // Set the initial number to 10 (customize as needed)
        try {
            // Open the file for reading
            BufferedReader br = new BufferedReader(new FileReader("count.txt"));
            // Read the number from the file
            num = Integer.parseInt(br.readLine());
            // Close the file
            br.close();
        } catch (IOException e) {
            // If the file does not exist, create it and set num to the initial number
            num = initNum;
        }
        // Increase the number by 1
        num++;
        try {
            // Open the file for writing
            BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
            // Write the new number to the file
            bw.write(Integer.toString(num));
            // Close the file
            bw.close();
        } catch (IOException e) {
            // If an error occurs while writing to the file, print an error message
            System.err.println("Error writing to file");
        }
        // Print the new number to the console
        System.out.println("The new number is " + num);
        return num;
	}
	
	public static void main(String[] args) {
		increment();
	}
}