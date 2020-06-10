import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class JavaCourseGradeCalc {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your name");
		String name =sc.nextLine();
		
		

		File myfile = new File("src//"+ name + "javaResults.txt");

		
	   if (myfile.createNewFile())
		{
			System.out.println("File created");
		} else {
			System.out.println("Create new file");
		}
		
	double hometask1, hometask2, midterm, Examination, totalScore;
		do{
			System.out.println("Please input your Home Task 1 score");
			hometask1 = sc.nextDouble();
		}while(hometask1>10);  // Hometask1 cannot be greater than 10
		
		do{
			System.out.println("Please input your Home Task 2 score");
			hometask2 = sc.nextDouble();
		}while(hometask2>10); // Hometask2 cannot be greater than 10
		
		do{
			System.out.println("Please input your midterm score");
			midterm = sc.nextDouble();
		}while (midterm>30);   // Midterm score cannot be greater than 30
		
		do{
			System.out.println("Please input your Examination score");
			Examination = sc.nextDouble();	
		} while (Examination>50);	// Examination score cannot be greater than 50
		
	
		totalScore = hometask1+hometask2+midterm+Examination;
		
		System.out.println("Your Total score is :" + totalScore);
		
		PrintWriter writer = new PrintWriter(myfile); // to write into created file
		writer.println("Name: " + name);
		writer.println("Your Home Task 1 grade: " + hometask1);
		writer.println("Your Home Task 2 grade: " + hometask2);
		writer.println("Your Home midterm grade: " + midterm);
		writer.println("Your Examination grade: " + Examination);
		writer.println("Your Total score is: " + totalScore);
	
		writer.close();

		}

}
