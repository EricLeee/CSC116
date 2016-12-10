package lab19;
/**
 * describes name object
 *
 * @author Justin Schwab
 * @author Zach Scott
 * @author Jialang Li
 *
 */
public class Name{
    /** first name */    
    String firstName;
    /** last name */
    String lastName;
    /** middle initial */
    char middleInitial;
    
    /**
     * gets first name
     * @return first name 
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * sets first name
     * @param first first name to set
     */
    public void setFirstName(String first){
        firstName = first;
    }

    /**
     * gets last name
     * @return last name 
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * sets last name
     * @param last last name to set
     */
    public void setLastName(String last){
        lastName = last;
    }

    /**
     * gets middle initial
     * @return middle initial 
     */
    public char getMiddleInitial(){
        return middleInitial;
    }

    /**
     * sets middle initial
     * @param mid initial to set
     */
    public void setMiddle(char mid){
        middleInitial = mid;
    }
    
    /**
     * returns name as a string
     * @return name in normal order 
     */
    public String getNormalOrder(){
        return (firstName + " " + middleInitial + ". " + lastName);
    }

    /**
     * returns name as a string in reverse order
     * @return name in reverse order
     */
    public String getReverseOrder(){
        return (lastName + ", " + firstName + " " + middleInitial + ".");
    }
    
    /**
     * returns name as a string
     * @return name in normal order 
     */
    public String toString(){
        return getNormalOrder();
    }

    /**
     * checks equality
     * @param o object being tested
     * @return whether or not they are equal 
     */
    public boolean equals(Object o){
        if(o instanceof Name){
            Name n = (Name) o;
            return firstName.equals(n.getFirstName()) 
                && lastName.equals(n.getLastName())
                && middleInitial == n.getMiddleInitial();
        } else {
            return false;
        }
    }

    
}

