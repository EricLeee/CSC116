package project3;

import java.util.*;
/**
 * Automates the admission selection process for a college. 
 *
 * @author Jialang Li
 */
public class Admissions {
    
    /** Lower range of SAT score */ 
    public static final int SAT_RAN_L = 200;
    /** Higher range of SAT score */
    public static final int SAT_RAN_H = 800;
    /** Lower range of essay score */
    public static final int ESSAY_RAN_L = 1;
    /** Higher range of essay score */
    public static final int ESSAY_RAN_H = 4;
    /**
     * Starts the program
     * @param args Common LIne argument
     * @throws IllegalArgumentException if the school is not 'E','e','L','l','F', or 'f'
     *                                  if essayScore is less than 1 or greater than 4
     *                                  if school is 'E', 'e', 'L', or 'l' and
     *                                  mathSAT or readingSAT is less than 200 or greater than 800
     *                                  if school is 'F' or 'f' and portfolioRating is
     *                                  not 'E', 'e', 'G', 'g', 'F', 'f', 'P', or 'p'
     *                                  if numberOfAlumni is less than 0
     */
    public static void main(String[] args) throws IllegalArgumentException {
        
        int mathScore = 0;
        int readingScore = 0;
        int essayScore = 0;
        char portfolio = 'i';
        Scanner console = new Scanner(System.in);
        System.out.println("           Welcome to the College Admissions Program!");
        System.out.println("When prompted,  please enter the applicant's name, the school to \n"
                + "which he/she is applying - E (Engineering), L (Liberal Arts), or \n"
                + "F (Fine Arts), and the applicant's essay score. Depending on the \n"
                + "school, enter the Math/Reading SAT scores or the Portfolio rating \n"
                + "- E (Excellent), G (Good), F (Fair), or P (Poor). Also, enter the \n"
                + "number of alumni family members. The applicant's admission status \n"
                + "of Admit, Defer, or Deny will then be displayed.");
        System.out.println();
        System.out.print("Applicant Name: ");
        console.nextLine();
        System.out.println();
        System.out.print("E (Engineering), L (Liberal Arts), or F (Fine Arts): ");
        String sch = console.next();
        if (sch.length() > 1) {
            System.out.println("Invalid input");
            System.exit(1);
        }
        char scho = sch.charAt(0);
        scho = Character.toUpperCase(scho);
        
        
        if (scho == 'E' || scho == 'L') {
            
            System.out.print("Essay score (1-4): ");
            essayScore = console.nextInt();
            
            if (essayScore < ESSAY_RAN_L || essayScore > ESSAY_RAN_H) {
                System.out.println("Invalid input");
                System.exit(1);
            }
            
            System.out.print("Math SAT score (200-800): ");
            mathScore = console.nextInt();
            
            if (mathScore < SAT_RAN_L || mathScore > SAT_RAN_H ) {
                System.out.println("Invalid input");
                System.exit(1);
            }
            
            System.out.print("Reading SAT score (200-800): ");
            readingScore = console.nextInt();
            
            if (readingScore < SAT_RAN_L || readingScore > SAT_RAN_H) {
                System.out.println("Invalid input");
                System.exit(1);
            }
            
        } else if (scho == 'F') {
            
            System.out.print("Essay score (1-4): ");
            essayScore = console.nextInt();
            
            if (essayScore < ESSAY_RAN_L || essayScore > ESSAY_RAN_H) {
                System.out.println("Invalid input");
                System.exit(1);
            }
            
            System.out.print("Portfolio rating (E (Excellent), G (Good), F (Fair), or P (Poor)): ");
            String portfo = console.next();
            char portfol = portfo.charAt(0);
            portfolio = Character.toLowerCase(portfol);
            
            if (!(portfolio == 'e' || portfolio == 'g' || portfolio == 'f' || portfolio == 'p')) {
                System.out.println("Invalid input");
                System.exit(1);
            }
            
        } else {
            System.out.println("Invalid input");
            System.exit(1);
            
        }
        
        System.out.print("Number of alumni family members: ");
        int numOfM = console.nextInt();
        console.close();
        if (numOfM < 0) {
            System.out.println("Invalid input");
            System.exit(1);
        }
            
        System.out.println();    
        System.out.println("Admission Status: " + getAdmissionStatus(
                           scho, essayScore, mathScore, readingScore, 
                           portfolio, numOfM));
        
    }
    
    /**
     * get admission status for three school
     * @param school school that user applys
     * @param essayScore applicant's essay score
     * @param mathSAT applicant's SAT math score
     * @param readingSAT applicant's SAT reading score
     * @param portfolioRating applicant's portfolio rating
     * @param numberOfAlumni applicant's alumni family members number
     * @return status Returns the admission status as a string ("Admit", "Defer", or "Deny")
     * @throws IllegalArgumentException if the school is not 'E','e','L','l','F', or 'f'
     *                                  if essayScore is less than 1 or greater than 4
     *                                  if school is 'E', 'e', 'L', or 'l' and
     *                                  mathSAT or readingSAT is less than 200 or greater than 800
     *                                  if school is 'F' or 'f' and portfolioRating is
     *                                  not 'E', 'e', 'G', 'g', 'F', 'f', 'P', or 'p'
     *                                  if numberOfAlumni is less than 0
     */
    public static String getAdmissionStatus(char school, int essayScore, int mathSAT,
                                            int readingSAT, char portfolioRating,
                                            int numberOfAlumni) throws IllegalArgumentException {

        final int E_ESSAY_REQ = 2;
        final int E_MATH_REQ = 500;
        final int E_MATH_ADM = 700;
        final int E_READING_REQ = 400;
        final int E_READING_ADM = 600;
        final int L_ESSAY_REQ = 3;
        final int L_MATH_REQ = 400;
        final int L_MATH_ADM = 500;
        final int L_READING_REQ = 500;
        final int L_READING_ADM = 650;
        final int F_ESSAY_REQ = 2;
        String status = "";
        char schooL = Character.toUpperCase(school);
        
        if (schooL == 'E') {
            
            if (readingSAT < SAT_RAN_L || readingSAT > SAT_RAN_H ||
                mathSAT < SAT_RAN_L || mathSAT > SAT_RAN_H ||
                essayScore < ESSAY_RAN_L || essayScore > ESSAY_RAN_H) {
                throw new IllegalArgumentException("Invalid input");
            }
            if (essayScore < E_ESSAY_REQ || mathSAT < E_MATH_REQ || readingSAT < E_READING_REQ) {
                status = "Deny";
            } else if (mathSAT >= E_MATH_ADM && readingSAT >= E_READING_ADM) {
                status = "Admit";
            } else if (mathSAT >= E_MATH_REQ && readingSAT >= E_READING_REQ) {
                status = "Defer";
            }
        } else if (schooL == 'L') {
            
            if (readingSAT < SAT_RAN_L || readingSAT > SAT_RAN_H ||
                mathSAT < SAT_RAN_L || mathSAT > SAT_RAN_H ||
                essayScore < ESSAY_RAN_L || essayScore > ESSAY_RAN_H) {
                throw new IllegalArgumentException("Invalid input");
            }
            if (essayScore < L_ESSAY_REQ || mathSAT < L_MATH_REQ || readingSAT < L_READING_REQ) {
                status = "Deny";
            } else if (mathSAT >= L_MATH_ADM && readingSAT >= L_READING_ADM) {
                status = "Admit";
            } else if (mathSAT >= L_MATH_REQ && readingSAT >= L_READING_REQ) {
                status = "Defer";
            }
        } else if (schooL == 'F') {
            if (essayScore < F_ESSAY_REQ || portfolioRating == 'p' || portfolioRating == 'f') {
                status = "Deny";
            } else if (portfolioRating == 'e') {
                status = "Admit";
            } else if (portfolioRating == 'g') {
                status = "Defer";
            } else {
                throw new IllegalArgumentException("Invalid input");
            }
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
        
        return status;
    }
}