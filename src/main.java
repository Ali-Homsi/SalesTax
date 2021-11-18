import java.util.ArrayList;
import java.util.Scanner;


public class main {
    // checks user's answer if it is a 'y' or a 'n', returns the answer in case of correct user input.
    // throws an exception and terminates the program in case of incorrect user input.
    public static boolean validateAndGetUserAnswer(){
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().charAt(0);
        boolean answer = false;
        try {
            if (choice == 'y') answer = true; else if  (choice == 'n') answer = false; else throw new Exception("WrongValueException");

        } catch (Exception e) {
            System.err.println("The acceptable answers are only y for yes and n for no.. exiting..");
            System.exit(0);
        }
        return answer;
    }

    //validates correct user float input and returns it. terminates the program in case of incorrect user input.
    public static int validateAndGetIntInput(){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        try {
            input = sc.nextInt();

        } catch (Exception e) {
            System.err.println("Please enter a correct value.. exiting..");
            System.exit(0);
        }
        return input;
    }

    //validates correct user float input and returns it. terminates the program in case of incorrect user input.
    public static float validateAndGetFloatInput(){
        Scanner sc = new Scanner(System.in);
        float input = 0;
        try {
            input = sc.nextFloat();

        } catch (Exception e) {
            System.err.println("Please enter a correct value.. exiting..");
            System.exit(0);
        }
        return input;
    }


    public static void main (String[] args)  {
        Scanner sc = new Scanner(System.in);


        System.out.println("Please enter the amount of purchased items");
        int itemCount = validateAndGetIntInput();

        //data structure to store purchased items
        ArrayList<PurchasedItem> items = new ArrayList<PurchasedItem>();

        //purchased items attributes
        String name;
        float price, total = 0 , taxSum = 0;
        int count;
        boolean isTaxable, isImported;

        //asking user for input regarding the purchased items
        for (int i = 1; i <= itemCount; i++){
            System.out.println("Item # " + i);
            System.out.println("Please enter the name of the item..");
            name = sc.nextLine();

            System.out.println("Please enter the shelf price of the "+ name + "..");
            price = validateAndGetFloatInput();

            System.out.println("Please enter how many " + name + "s did you buy..");
            count = validateAndGetIntInput();

            System.out.println("Is this item a (book/food/medical product)? choose y = Yes, n = No..");
            isTaxable = !validateAndGetUserAnswer();

            System.out.println("Is this item imported? choose y = Yes, n = No..");
            isImported = validateAndGetUserAnswer();

            //instantiate a PurchasedItem based on user input
            PurchasedItem item = new PurchasedItem(name, price, count, isTaxable, isImported);
            item.calculateTax();
            taxSum += item.calculateTax();
            total += item.getPriceWithTax();
            items.add(item);

            System.out.println("###############################################");

        }
        //final output
        for (int i = 0; i < items.size(); i++) {
            PurchasedItem currentItem = items.get(i);
            if (currentItem.isImported)
                System.out.printf("%d imported %s : %.2f \n", currentItem.count , currentItem.name, currentItem.priceWithTax );
            else
                System.out.printf("%d  %s : %.2f \n", currentItem.count , currentItem.name, currentItem.priceWithTax );
        }
        System.out.printf("Sales Taxes: %.2f \n",taxSum);
        System.out.printf("Total: %.2f \n",total);

    }

}
