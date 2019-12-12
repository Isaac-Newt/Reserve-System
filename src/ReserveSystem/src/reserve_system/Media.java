package reserve_system;

public class Media extends CirculatingItem {

    private String callNumber;
    private String Title;
    private String Author;
    private String Course;
    // This will be "Library" or the professor/faculty's name
    // Combines "Professor" and "isLibraryProperty" from class diagram
    private String Owner;

    // Constructor
    public Media(
            String call, String title, String auth, String course, String owner,
            int bar, int dur, String loc, CheckoutRecord rec) {
        // Super class constructor
        super("Media", bar, dur, loc);
        this.callNumber = call;
        this.Title = title;
        this.Author = auth;
        this.Course = course;
        this.Owner = owner;
    }

}
