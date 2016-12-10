package project3;

public class la {
    
     /** Lower range of SAT score */ 
    public static final int SAT_RAN_L = 200;
    /** Higher range of SAT score */
    public static final int SAT_RAN_H = 800;
    /** Lower range of essay score */
    public static final int ESSAY_RAN_L = 1;
    /** Higher range of essay score */
    public static final int ESSAY_RAN_H = 4;
    
    public static void main(String[] args) {
        char school = 'E';
        int essayS = 3;
        int maths = 766;
        int rea = 666;
        char port = ' ';
        int num = 4;
        System.out.println("res: " + getAdmissionStatus(school, essayS, maths, rea, port, num));
    
    }
    
    
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