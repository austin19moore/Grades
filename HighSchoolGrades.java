import java.util.Scanner;
public class HighSchoolGrades {

    public static void addModifyGrade(int idxFrom, int idxTo, double gGrades[]) { // takes an inputted list from the array, and assigns a new grade to the value
        Scanner gIn = new Scanner(System.in);
        System.out.print("Enter the index from (" + idxFrom + " to " + idxTo + ") : ");
        int choosenInt = gIn.nextInt();
        int to = idxTo;
        int from = idxFrom;
        while ((choosenInt > to) || (choosenInt < from)) {
            System.out.println("Value out of range, please, try again");
            System.out.print("Enter the index from (" + idxFrom + " to " + idxTo + ") : ");
            choosenInt = gIn.nextInt();
        }
        System.out.println("The current value of the grade in index " + choosenInt + " is : " + gGrades[choosenInt]);
        System.out.print("Enter the grade you want to assign (0.00 - 100.00) : ");
        double choosenG = gIn.nextDouble();

        while ((choosenG > 100.00) || (choosenG < 0.00)) {
            System.out.println("Value out of range, please, try again");
            System.out.println("The current value of the grade in index " + choosenInt + " is : " + gGrades[choosenInt]);
            System.out.print("Enter the grade you want to assign (0.00 - 100.00) : ");
            choosenG = gIn.nextDouble();
        }

        System.out.println("");
        gGrades[choosenInt] = choosenG;
        return;
    }

    public static void swapGrades(int idxFrom, int idxTo, double gGrades[]) { // takes two integers and swaps their locations on the array using the swapValues() method
        Scanner gIn = new Scanner(System.in);
        System.out.print("Enter the index from (" + idxFrom + " to " + idxTo + ") : ");
        int from = gIn.nextInt();

        while ((from < idxFrom) || (from > idxTo)) {
            System.out.println("Value out of range, please, try again");
            System.out.print("Enter the index from (" + idxFrom + " to " + idxTo + ") : ");
            from = gIn.nextInt();
        }

        System.out.print("Enter the index from (" + idxFrom + " to " + idxTo + ") that is not " + from + " : ");
        int to = gIn.nextInt();

        while ((to > idxTo) || (to < idxFrom) || (to == from)) {
            System.out.println("Value out of range, please, try again");
            System.out.print("Enter the index from (" + idxFrom + " to " + idxTo + ") that is not " + from + " : ");
            to = gIn.nextInt();
        }

        swapValues(from, to, gGrades);
        System.out.println("");
        return;
    }

    public static void swapValues(int f,int t, double gGrades[]) { // swaps the 2 entered array values
        double a = gGrades[f];
        gGrades[f] = gGrades[t];
        gGrades[t] = a;
        return;
    }

    public static void listGrades(double gGrades[]) { // lists all grades in the array gGrades
        int i = 0;
        System.out.println("LIST OF GRADES");
        for (i = 0; i < gGrades.length; i++) {
            System.out.println("Grade[" + i + "] : " + gGrades[i]);
        }
        System.out.println("");
        return;
    }

    public static void Report(double gGrades[]) { // reports how many arrays values are in each letter grade using getGradesLetter() method
        Scanner gIn = new Scanner(System.in);
        String A = "A";
        String B = "B";
        String C = "C";
        String D = "D";
        String F = "F";
        System.out.println("A : " + getGradesLetter(A, gGrades));
        System.out.println("B : " + getGradesLetter(B, gGrades));
        System.out.println("C : " + getGradesLetter(C, gGrades));
        System.out.println("D : " + getGradesLetter(D, gGrades));
        System.out.println("F : " + getGradesLetter(F, gGrades));
        System.out.println("");
        return;
    }

    public static int getGradesLetter(String letter, double gGrades[]) { // this method is used in Report() to calculate how many of the grades in the gGrades array is in each letter grade
    int i = 0;
    int j = 0;
    int gradesLetter = 0;


    for (i = 0; i < gGrades.length; i++) {

        if (letter == "A") {
            if ((gGrades[i] <= 100.00) && (gGrades[i] >= 90.00)) {
                gradesLetter = gradesLetter + 1;
            }
        }
        if (letter == "B") {
            if ((gGrades[i] <= 90.00) && (gGrades[i] >= 80.00)) {
                gradesLetter = gradesLetter + 1;
            }
        }
        if (letter == "C") {
            if ((gGrades[i] <= 80.00) && (gGrades[i] >= 70.00)) {
                gradesLetter = gradesLetter + 1;
            }
        }
        if (letter == "D") {
            if ((gGrades[i] <= 70.00) && (gGrades[i] >= 60.00)) {
                gradesLetter = gradesLetter + 1;
            }
        }
        if (letter == "F") {
            if ((gGrades[i] < 60.00)) {
                gradesLetter = gradesLetter + 1;
            }
        }

    }


    return gradesLetter;
    }


    public static void main(String [] args) {
        Scanner gIn = new Scanner(System.in);
        int gClassSize;
        int input = 0;
        System.out.print("Please, enter the class size : ");
        gClassSize = gIn.nextInt();
        System.out.println("");
        int idxFrom = 0;
        int idxTo = gClassSize - 1;
        double[] gGrades = new double[gClassSize];

        System.out.println("MAIN MENU");
        System.out.println("0 - Exit, 1 - Add/Modify Grade, 2 - Swap Grades, 3 - List, 4 - Report");
        System.out.print("Select an option : ");
        input = gIn.nextInt();

        while ((input > 4) || (input < 0)) {
            System.out.println("Value out of range, please, try again");
            System.out.println("");
            System.out.println("MAIN MENU");
            System.out.println("0 - Exit, 1 - Add/Modify Grade, 2 - Swap Grades, 3 - List, 4 - Report");
            System.out.print("Select an option : ");
            input = gIn.nextInt();
        }

        while (input != 0) {

            if (input == 1) {

                addModifyGrade(idxFrom, idxTo, gGrades);

            } else if (input == 2) {

                swapGrades(idxFrom, idxTo, gGrades);

            } else if (input == 3) {

                listGrades(gGrades);

            } else if (input == 4) {

                Report(gGrades);

            } else {

                System.out.println("Value out of range, please, try again");

            }

            System.out.println("MAIN MENU");
            System.out.println("0 - Exit, 1 - Add/Modify Grade, 2 - Swap Grades, 3 - List, 4 - Report");
            System.out.print("Select an option : ");
            input = gIn.nextInt();

        }

        System.out.print("Thank you for using the grades program! Bye!");


    }
}
