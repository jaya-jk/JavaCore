import java.util.Scanner;
class Calculator{
    public static boolean choice;
    public static  Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        choice = getChoice();
        if(choice){
            String Expression = validateExpression();
            char[] operators = getOperators(Expression);
            int[] numbers = getNumbers(Expression);
            try {
                printResult(operators, numbers);
            }
            catch (NumberFormatException nfe){
                System.out.println("anything / 0 --> Infinite Error");
                //choice = getChoice();
            }
        }
        else {
            System.out.println("See you again ...");
            input.close();
        }
    }
    // getChoice() -> Validate the user input and force them to select either 1 to start or 0 to exit;
     public   static boolean getChoice() {
        System.out.println("1 : Start Calculator ");
        System.out.println("0 : Exit ");
        int number = input.nextInt();
        if (number == 1) return true;
        else if (number == 0) return false;
        else {
            System.out.println("Choose either 1 or 0 ");
            return getChoice();
        }
    }
    //validateExpression() -> validate the correct mathematical Expression and in case of mismatch it again call by itself to get the correct expression
    public static String validateExpression() {
        System.out.println("Enter Expression Without Space Here : ");
        String expression = input.next();
        if (expression.matches("^\\s*([-+]?)(\\d+)(?:\\s*([-+*\\/])\\s*((?:\\s[-+])?\\d+)\\s*)+$")) {
            return expression;
        }
        else{
            System.out.println("Syntax Error");
            return validateExpression();
        }
    }
        //getOperators() -> this return a character array which contains operators.
    public static char[] getOperators(String e) {
        String[] op = e.split("[0-9]+");
        StringBuilder sb = new StringBuilder();
        for (String pass:op) {
            sb.append(pass);
        }
        return sb.toString().toCharArray();
    }
        //getNumbers() -> this will return numbers in the Mathematical expression.
    public static int[] getNumbers(String e){
        String[] a = e.split("[/*+-]+");
        int[] num = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            num[i] = Integer.parseInt(a[i]);
        }
        return num;
    }
        //printResult() -> it prints result to the console and Handle NumberFormatException in case of (/0) .
    protected static void printResult(char[] ope, int[] num) throws NumberFormatException{
        // res stores first number.
        int res = num[0];
        //loop that will run operator array.
        for (int i = 0; i < ope.length; i++) {
            int j =i+1;
            switch (ope[i]){
                case '+':
                     res += num[j];
                     //j++;
                     break;
                case '-':
                    res -= num[j];
                    //j++;
                    break;
                case '*':
                    res *= num[j];
                    //i++;
                    break;
                case '/':
                    if (num[j] == 0) throw new NumberFormatException();
                    else {
                        res /= num[j];
                        //i++;
                        break;
                    }

            }
        }
        System.out.println("Answer = " + res);
    }
}

