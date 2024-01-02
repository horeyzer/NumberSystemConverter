import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSystemConverter
{
    static int val(char c)
    {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    public static int changeToDecimal(String str, int baseSystem)
    {
        int len = str.length();
        int power = 1; // Initialize power of base
        int num = 0; // Initialize result
        int i;

        // Decimal equivalent is str[len-1]*1 + str[len-2] * base + str[len-3]*(base^2) + ...
        for (i = len - 1; i >= 0; i--)
        {
            // A digit in input number must be less than number's base
            if (val(str.charAt(i)) >= baseSystem)
            {
                System.out.println("Wrong number");
                return -1;
            }
            num += val(str.charAt(i)) * power;
            power = power * baseSystem;
        }
        return num;
    }

    static char reVal(int num)
    {
        if (num >= 0 && num <= 9)
            return (char) (num + 48);
        else
            return (char) (num - 10 + 65);
    }

    // Function to convert a given decimal number to a base 'base' and
    static String changeFromDecimal(int targetSystem, int inputNum)
    {
        String s = "";

        // Convert the given number and the given system (base), by continuously dividing a number with "base" and using the remainder of the division.
        while (inputNum > 0)
        {
            s += reVal(inputNum % targetSystem);
            inputNum /= targetSystem;
        }
        StringBuilder ix = new StringBuilder();

        // append a string into StringBuilder input
        ix.append(s);

        // Reverse the result
        return new String(ix.reverse());
    }

    static int fromWhichSystem(int baseSystem)
    {
        switch (baseSystem)
        {
            case 2:
                baseSystem = 2;
                break;
            case 3:
                baseSystem = 3;
                break;
            case 4:
                baseSystem = 4;
                break;
            case 5:
                baseSystem = 5;
                break;
            case 6:
                baseSystem = 6;
                break;
            case 7:
                baseSystem = 7;
                break;
            case 8:
                baseSystem = 8;
                break;
            case 9:
                baseSystem = 9;
                break;
            case 10:
                baseSystem = 10;
                break;
            case 11:
                baseSystem = 11;
                break;
            case 16:
                baseSystem = 16;
                break;
            default:
                baseSystem = 2;
                break;
        }
        return baseSystem;
    }

    static int toWhichSystem(int targetSystem)
    {
        switch (targetSystem)
        {
            case 2:
                targetSystem = 2;
                break;
            case 3:
                targetSystem = 3;
                break;
            case 4:
                targetSystem = 4;
                break;
            case 5:
                targetSystem = 5;
                break;
            case 6:
                targetSystem = 6;
                break;
            case 7:
                targetSystem = 7;
                break;
            case 8:
                targetSystem = 8;
                break;
            case 9:
                targetSystem = 9;
                break;
            case 10:
                targetSystem = 10;
                break;
            case 16:
                targetSystem = 16;
                break;
            default:
                targetSystem = 2;
                break;
        }
        return targetSystem;
    }

    public static void main(String[] args) throws IOException
    {
        int baseSystem, targetSystem, numFromDecimalSystem;
        String numToDecimalSystem, number1, number2, choose;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\n---------------------------------------------------");
            System.out.println("Choose what operation you want to perform:\n");
            System.out.println("A. Convert from any system to the decimal system");
            System.out.println("B. Convert from decimal system to another system");
            System.out.println("C. Summing up numbers from different systems");
            System.out.println("D. Subtracting numbers from different systems");
            System.out.println("E. Multiplying numbers from different systems");
            System.out.println("F. Dividing numbers from different systems\n");
            System.out.println("W. Exit the program");

            choose = br.readLine();

            if (choose.equals("A"))
            {
                System.out.println("Enter the value you want to convert to the decimal system: ");
                numToDecimalSystem = br.readLine();

                System.out.println("What system is the number from?");
                baseSystem = Integer.parseInt(br.readLine());

                System.out.println(changeToDecimal(numToDecimalSystem, fromWhichSystem(baseSystem)));
            }
            else if (choose.equals("B"))
            {
                System.out.println("Enter a decimal value ");
                numFromDecimalSystem = Integer.parseInt(br.readLine());

                System.out.println("To which system do you want to convert: ");
                targetSystem = Integer.parseInt(br.readLine());

                String result2 = changeFromDecimal(toWhichSystem(targetSystem), numFromDecimalSystem);

                System.out.println(result2);
            }
            else if (choose.equals("C"))
            {
                System.out.println("Enter the value of the first number to sum");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfSum1 = changeToDecimal(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number to sum");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfSum2 = changeToDecimal(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the addition is: " + changeFromDecimal(toWhichSystem(targetSystem),
                        componentOfSum1 + componentOfSum2) + " in the system " + targetSystem);
            }
            else if (choose.equals("D"))
            {
                System.out.println("Enter the value of the first number to be subtracted");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfDifference1 = changeToDecimal(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number to be subtracted");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfDifference2 = changeToDecimal(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the subtraction is: " + changeFromDecimal(toWhichSystem(targetSystem),
                        componentOfDifference1 - componentOfDifference2) + " in the system " + targetSystem);
            }
            else if (choose.equals("E"))
            {
                System.out.println("Enter the value of the first for the multiplication operation");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfMultiplication1 = changeToDecimal(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number for the multiplication operation");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfMultiplication2 = changeToDecimal(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the multiplication is: " + changeFromDecimal(toWhichSystem(targetSystem),
                        componentOfMultiplication1 - componentOfMultiplication2) + " in the system " + targetSystem);
            }
            else if (choose.equals("F"))
            {
                System.out.println("Enter the value of the first for the division operation");
                number1 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfDivision1 = changeToDecimal(number1, fromWhichSystem(baseSystem));

                System.out.println("Enter the value of the second number for the division operation");
                number2 = br.readLine();
                System.out.println("What system is the number from? ");
                baseSystem = Integer.parseInt(br.readLine());
                int componentOfDivision2 = changeToDecimal(number2, fromWhichSystem(baseSystem));

                System.out.println("In which system to display the result?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of the division is: " + changeFromDecimal(toWhichSystem(targetSystem),
                        componentOfDivision1 - componentOfDivision2) + " in the system " + targetSystem);
            }
        }
        while (!choose.equals("W"));
    }
}
