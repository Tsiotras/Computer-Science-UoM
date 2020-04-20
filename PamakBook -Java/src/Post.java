import java.util.ArrayList;
import java.util.Date;

public class Post implements Comparable<Post>{

	private Date date;
	private String text;
	private User publisher;
	
	private static ArrayList<Post> posts = new ArrayList<Post>();
	
	public Post(Date date, User publisher, String text) {
		super();
		this.date = date;
		this.publisher=publisher;
		this.text = text;
	}

	public Date getDate() {
		return date;
	}


	public String getText() {
		return text;
	}
	
	public User getPublisher() {
		return publisher;
	}

	public static ArrayList<Post> getPosts() {
		return posts;
	}
	  
	public static void addPost(Post aPost) {
		posts.add(aPost);
		}
	
	@Override
	public int compareTo(Post other) {
		return date.compareTo(other.getDate());
	}


}
 
	
	

