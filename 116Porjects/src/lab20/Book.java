package lab20;

public class Book {
    private String title;
    private String author;
    private int pubYear;
    private String checkedOut;
    private int location;
    private String dueDate;
    
    public Book(String Title, String Author, int PubYear, int Location) {
        this.title = Title;
        this.author = Author;
        this.pubYear = PubYear;
        setLocation(Location);
        this.checkedOut = null;
        this.dueDate = null;
    }
    
    public Book(String Title, String Author, int PubYear) {
        this(Title, Author, PubYear, 0);
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public int getPubYear() {
        return this.pubYear;
    }
    
    public String getCheckStat() {
        return this.checkedOut;
    }
    
    public String getDueDate() {
        return this.dueDate;
    }
    
    public boolean checkOut(String unityId) {
        checkedOut = "Yes";
        return true;
    }
    
    public void checkIn() {
        checkedOut = null;
    }
    
    public int getLocation() {
        return location;
    } 
    
    public void setLocation(int newLocation) {
        if (newLocation < 0) {
            throw new IllegalArgumentException ();
        }
        location = newLocation;
    }
}