import java.util.Scanner;

public class Calculator1 {
     
     //addition method
     public static double add(double a,double b) {
        return a + b;
     }

     //subtraction method
     public static double subtract(double a,double b) {
       return a - b;
     }

     //multiplication method
     public static double multiply(double a,double b) {
        return a * b;
     }

     public static double divide(double a,double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Errror cannot divide by zero!");
            return 0;
        }
     }

     //modulus method
     public static double modulus(double a,double b){
        return a % b;
     }

     //square root method
     public static double squareRoot(double a){
        return Math.sqrt(a);
     }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n======Calculator Menu ======");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulus");
            System.out.println("6. Square root");
            System.out.println("0. Exit");
            System.out.println("Choose an operation (0-6):");
            
            //store user data
            int choice = scanner.nextInt();

            if (choice == 0) {
                keepRunning = false;
                System.out.println("Exiting Calculator goodbye!");
                continue;
            }

            double num1, num2;
            switch(choice) {
                case 1:
                    System.out.print("Enter two numbers");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case 2:
                    System.out.println("Enter 2 numbers");  
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result" + subtract(num1, num2));
                    break;
                case 3:
                     System.out.println("Enter 2 numbers");  
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result" + multiply(num1, num2));
                    break;
                case 4:
                 System.out.println("Enter 2 numbers");  
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result" + divide(num1, num2));
                    break;
                case 5:
                     System.out.println("Enter 2 numbers");  
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result" + modulus(num1, num2));
                    break;
                case 6:
                     System.out.println("Enter a number");  
                    num1 = scanner.nextDouble();
                    System.out.println("Result" + squareRoot(num1));
                    break;  
                 default:
                   System.out.println("Invalid choice! Please try again.");             
            }
        }
        scanner.close();
     }
}


