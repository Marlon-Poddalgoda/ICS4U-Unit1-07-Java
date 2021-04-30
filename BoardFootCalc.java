import java.util.Scanner;
/**
 * This program calculates the dimensions of a board foot.
 *
 * @author  Marlon Poddalgoda
 * @version 1.0
 * @since 2021-04-29
 */

public final class BoardFootCalc {
    private BoardFootCalc() {

        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }

    /**
    * This method calculates the height of a piece of wood from 1 parameter.
    * @param length This value is the length of the board.
    * @return height This value returns the height.
    */
    public static float boardFoot(final float length) {
        // calculates height using only 1 value

        // height variable
        float height = 0f;
        // constant of area
        final int areaOfBoard = 144;

        // process
        height = areaOfBoard / (length * length);

        // return statement
        return height;
    }

    /**
    * This method calculates the height of a piece of wood from 2 parameters.
    * @param length This value is the length of the board.
    * @param width This value is the width of the board.
    * @return height This value returns the height.
    */
    public static float boardFoot(final float length, final float width) {
        // calculates height using only 1 value

        // height variable
        float height = 0f;
        // constant of area
        final int areaOfBoard = 144;

        // process
        height = areaOfBoard / (length * width);

        // return statement
        return height;
    }

    /**
    * This method takes in user input and passes to the function.
    * @param args
    */
    public static void main(final String[] args) {

        // Create new Scanner-type variable
        Scanner paramInput = new Scanner(System.in);
        Scanner lengthInput = new Scanner(System.in);
        Scanner widthInput = new Scanner(System.in);

        // Variables
        float length = 0f;
        float width = 0f;
        float finalHeight = 0f;
        int numOfParams = 0;

        // program information
        System.out.println("This program calculates the dimensions of a piece"
            + " of wood in order to equal to 1 board foot.");
        System.out.println();

        // Asks user to enter a range value
        System.out.print("How many dimensions do you want "
                        + "to enter (max 2): ");

        while (true) {
            // check if input is an integer
            while (!paramInput.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("How many dimensions do you want "
                                    + "to enter (max 2): ");
                paramInput.next(); // moves scanner until correct value
            }
            numOfParams = paramInput.nextInt();

            // input for length
            if (numOfParams == 1 || numOfParams == 2) {
                // user inputs 1 or 2 for numOfparams, program asks for length
                System.out.print("Enter the length of the wood piece: ");

                while (!lengthInput.hasNextFloat()) {
                    // make sure input is an integer
                    System.out.println("That's not a number!");
                    System.out.print("Enter the length of the wood piece: ");
                    lengthInput.next(); // moves scanner until correct value
                }
                length = lengthInput.nextFloat();

                if (length <= 0) {
                    // error catch for number of dimensions
                    System.out.println("Please enter a positive number.");
                    continue;
                }
            } else {
                // error catch for number of dimensions
                System.out.println("Please enter either 1 or 2.");
                continue;
            }

            // input for width
            if (numOfParams == 2) {
                // if user inputs 2 for numOfParams, program asks for width
                System.out.print("Enter the width of the wood piece: ");

                while (!widthInput.hasNextFloat()) {
                    System.out.println("That's not a number!");
                    System.out.print("Enter the width of the wood piece: ");
                    widthInput.next(); // moves scanner until correct value
                }
                width = widthInput.nextFloat();

                if (width <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }

                // call function while passing both length and width
                finalHeight = boardFoot(length, width);

            } else  if (numOfParams == 1) {
                // call function while passing length
                finalHeight = boardFoot(length);
            } else {
                // error catch
                System.out.println("Sorry, please try again!");
                continue;
            }

            // print height to console
            System.out.println("");
            System.out.println("This board will have to be " + finalHeight
                                + " inches tall to be 1 board foot in area");

            System.out.println("");
            System.out.println("Done.");
            break;
        }
    }
}
