  package calories_consumed;

  import java.io.BufferedReader;
  import java.io.File;
  import java.io.FileReader;
  import java.io.IOException;
  import java.util.Arrays;
  import java.util.stream.IntStream;
  
  public class Calories_consumed {
  
      public static void main(String[] args) throws IOException {
          // TODO Auto-generated method stub
          String calories = "";
          String[] calorie;
          int[] breakfast = new int[7];
          int[] lunch = new int[7];
          int[] dinner = new int[7];
          int i=0;
          File myfile = new File("src/Calories_Table.txt");
          if (!myfile.exists())
              System.out.println("File not found");
          else
          {
          BufferedReader bufferedReader = new BufferedReader(new FileReader(myfile));		
          do {
              calories = bufferedReader.readLine();
              if (calories != null) {			
              calorie = calories.split(" ");
              if(calorie.length!=3)
              {
                  calories = null;
                  //System.out.println("Data is missing or not in correct format");
              }
              else
              {	
                          try {			
                  breakfast[i]=Integer.parseInt(calorie[0]);
                  lunch[i]=Integer.parseInt(calorie[1]);
                  dinner[i]=Integer.parseInt(calorie[2]);
                  i++;
              }
              catch(Exception ex)
              {
                  calories = null;				
              }
              }
              }
          } while (calories != null);
          if(i!=7)
          {
              System.out.println("Data is missing or not in correct format");
          }
          else
          {
              System.out.println("The number of calories consumed in any specific day : "+calories_consumed_specific_day(breakfast,lunch,dinner,1));
              System.out.println("List of the total number of calories consumed each day  ");
              int [] each_Day=calories_consumed_each_day(breakfast,lunch,dinner);
              for(int j=0;j<each_Day.length;j++)
              {
                  System.out.println("Day "+j+" calories : "+each_Day[j]);
              }
              System.out.println("The average number of calories consumed each day   ");
              double [] eachDay=average_calories_consumed_each_day(breakfast,lunch,dinner);
              for(int j=0;j<eachDay.length;j++)
              {
                  System.out.println("Day "+j+" calories : "+eachDay[j]);
              }
              System.out.println("The average number of calories consumed in each of the three meals    ");
              double [] eachmeals=average_calories_consumed_each_meals(breakfast,lunch,dinner);			
                  System.out.println("Breakfast  	: "+eachmeals[0]);
                  System.out.println("lunch  		: "+eachmeals[1]);
                  System.out.println("dinner  	: "+eachmeals[2]);					
              System.out.println("The maximum number of calories consumed in any specific day  : "+maximum_calories_consumed_specific_day(breakfast,lunch,dinner,1));
              System.out.println("The maximum number of calories consumed in any one meal  : "+calories_consumed_one_meal(breakfast));
          }
          }
      }
      public static int  calories_consumed_specific_day (int[] breakfast,int[] lunch,int[] dinner,int day) {
                  return breakfast[day]+lunch[day]+dinner[day];
      }
      public static int[]  calories_consumed_each_day (int[] breakfast,int[] lunch,int[] dinner) {
          int[] each_day=new int[7] ;
          for (int i=0;i<=6;i++)
          {
              each_day[i]=breakfast[i]+lunch[i]+dinner[i];
          }
          return each_day;
      }
      public static double[]  average_calories_consumed_each_day (int[] breakfast,int[] lunch,int[] dinner) {
          double[] each_day=new double[7] ;
          for (int i=0;i<=6;i++)
          {
              each_day[i]=(breakfast[i]+lunch[i]+dinner[i])/3;
          }
          return each_day;
      }	
      public static double[]  average_calories_consumed_each_meals (int[] breakfast,int[] lunch,int[] dinner) {
          double[] each_day=new double[3] ;	
              each_day[0]=(IntStream.of(breakfast).sum())/7;
              each_day[1]=(IntStream.of(lunch).sum())/7;
              each_day[2]=(IntStream.of(dinner).sum())/7;
          return each_day;
      }	
      public static int  maximum_calories_consumed_specific_day (int[] breakfast,int[] lunch,int[] dinner,int day) {
          int large;
          if( breakfast[day] >= lunch[day] && breakfast[day] >= dinner[day])
              large=breakfast[day];
  
          else if (lunch[day] >= breakfast[day] && lunch[day] >= dinner[day])
              large=lunch[day];
  
          else
              large=dinner[day];
          return large;
      }
      public static int  calories_consumed_one_meal (int[] meal) {
          return Arrays.stream(meal).max().getAsInt();
      }
  }


