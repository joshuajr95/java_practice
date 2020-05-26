import java.util.Date;

/* This is an immutable data type representing a tweet */
public class Tweet {
    private String author;
    private String text;
    private Date timestamp;

    /**
     * Constructor for a tweet
    * @param author     name of the author of the tweet
    * @param text       the text of the tweet
    * @param timestamp  time the tweet was made
    * */
    public Tweet(String author, String text, Date timestamp) {
        this.author = author;
        this.text = text;

        // this protects against having a date referenced by multiple tweets
        this.timestamp = new Date(timestamp.getTime());
    }

    /* SINCE STRINGS ARE IMMUTABLE THERE IS NO NEED TO PROTECT THEM FROM MODIFICATION */

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {
        // this protects against a direct reference to the mutable Date object
        return new Date(timestamp.getTime());
    }
}
