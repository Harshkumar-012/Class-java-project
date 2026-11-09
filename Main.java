import java.util.*;

public class Main {

        static Scanner sc = new Scanner(System.in);
        static String[] name = {"Rice","Egg","Banana","Milk","Desserts"};

        static double[] calories = {130,72,105,153,300};
        static double[] protein = {2.7,6.3,1.3,8,4};
        static double[] carbs = {28,0.4,27,12,45};
        static double[] fat = {0.3,4.8,0.4,8,12};

        static double totalCalories = 0;
        static double totalProtein = 0;
        static double totalCarbs = 0;
        static double totalFat = 0;

        static double totalCaloriesTarget = 0;
        static double totalProteinTarget = 0;
        static double totalCarbsTarget = 0;
        static double totalFatTarget = 0;

        static void displayMenu(){
            System.out.println("Meal Nutrition");
            System.out.println("1.View food catalogue");
            System.out.println("2.Add food to meal");
            System.out.println("3.View Daily Summary");
            System.out.println("4.Set Nutrition Target");
            System.out.println("5.Compare Nutrition Target");
            System.out.println("6.Exit");
        }

        static void displayFood(){
            System.out.println("Food Catalogue");
            for(int i=0;i<name.length;i++){
                System.out.println((i+1)+"."+name[i]);
                System.out.println("Calories : "+calories[i]);
                System.out.println("Protein : "+protein[i]);
                System.out.println("Carbs : "+carbs[i]);
                System.out.println("Fat : "+fat[i]);
            }
        }

        static void displayFoodNames(){
            System.out.println("Food Name");
            for(int i=0;i<name.length;i++){
                System.out.println((i+1)+"."+name[i]);
            }
        }

        static void addFood(){
            displayFoodNames();
            System.out.println("Enter Food Number");
            int foodNumber = sc.nextInt();
            if(foodNumber>=1 && foodNumber<=name.length){
                System.out.println("Enter Quantity: ");
                double quantity = sc.nextDouble();
                if(quantity>0){
                    int index = foodNumber-1;
                    double cal = calories[index]*quantity;
                    double prot = protein[index]*quantity;
                    double carbo = carbs[index]*quantity;
                    double fa = fat[index]*quantity;

                    totalCalories+=cal;
                    totalProtein+=prot;
                    totalCarbs+=carbo;
                    totalFat+=fa;

                    System.out.println("Food added Successfully");
                    System.out.println("Calories : "+cal);
                    System.out.println("Protein : "+prot);
                    System.out.println("Carbs : "+carbo);
                    System.out.println("Fat : "+fa);
                }
                else{
                    System.out.println("Invalid Quantity");
                }
            }
            else{
                System.out.println("Invalid Food Number");
            }
        }
        
        static void displaySummary(){
            System.out.println("Daily Summary");
            System.out.println("TotalCalories : "+totalCalories);
            System.out.println("TotalProtein : "+totalProtein);
            System.out.println("TotalCarbs : "+totalCarbs);
            System.out.println("TotalFat : "+totalFat);
        }

        static void target(){
            System.out.println("Enter Calories Target : ");
            double cal = sc.nextDouble();
            System.out.println("Enter Protein Target : ");
            double pro = sc.nextDouble();
            System.out.println("Enter Carbs Target : ");
            double car = sc.nextDouble();
            System.out.println("Enter Fat Target : ");
            double fa = sc.nextDouble();

            if(cal>=0 && pro>=0 && car>=0 && fa>=0){
                totalCaloriesTarget = cal;
                totalProteinTarget = pro;
                totalCarbsTarget = car;
                totalFatTarget = fa;

                System.out.println("Target Set Successfully");
            }
            else{
                System.out.println("Invalid Target");
            }
        }

        static void compareValue(String name,double target,double actual){
            double remaining = target-actual;
            System.out.println(name);
            System.out.println("Target : "+target);
            System.out.println("Consumed : "+actual);
            if(remaining>0){
                System.out.println("Remaining : "+remaining);
            }
            else if(remaining<0){
                System.out.println("Exceeded : "+(actual-target));
            }
            else{
                System.out.println("Target Achieved");
            }
        }
        public static void main(String[] args) {
            int choice;
            do{
                displayMenu();
                System.out.println("Enter your choice");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        displayFood();
                        break;

                    case 2:
                        addFood();
                        break;
                        
                    case 3:
                        displaySummary();
                        break;
                    case 4:
                        target();
                        break;

                    case 5:
                        compareValue("Calories",totalCaloriesTarget,totalCalories);
                        compareValue("Protein",totalProteinTarget,totalProtein);
                        compareValue("Carbs",totalCarbsTarget,totalCarbs);
                        compareValue("Fat",totalFatTarget,totalFat);
                        System.out.println("Thank You");    
                        break;
                
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
            while(choice!=6);
        }
}
