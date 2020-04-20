import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		int choice;
		
		//dhmiourgia Users
		User dimitris = new User("Dimitris", "dimitristsiotras14@gmail.com");
		User alexandros = new User("Alexandros", "tsiotrasalex@gmail.com");
		User gregory = new User("Gregory", "chatzgregory@gmail.com");
		User natasha = new User("Natasha", "natasha95@gmail.com");
		User chris = new User("Chris", "chriskaza@gmail.com");
		User eleni = new User("Eleni", "elenikazantzi@yahoo.com");
		User mpampis = new User("Mpampis", "mpampis94@gmail.com");
	    User andreas = new User ("Andreas", "andreastompros@gmail.com");
	    User pavlos = new User("Pavlos", "paschalidispavlos@gmail.com");
	    User elvina = new User("Elvina", "elvinageorgari@gmail.com");	   
	    User[] users = {elvina, pavlos, andreas,mpampis, eleni, chris, natasha, gregory, alexandros, dimitris};
	    for(User user : users)
	    UserCatalog.addToallUsers(user);
	   
	   
	  
	    Post p1 = new Post(new Date(2017,6,9), dimitris, "Summer is here!");
	    Post p2 = new Post(new Date(2017, 8,31), dimitris, "Bye Bye Summer!");
	    Post p3 = new Post(new Date(2017, 8,31), mpampis, "Hello everyone!");
	    Post p4 = new Post(new Date(2017, 8,31), alexandros, "Like Halkidiki, nowhere!");
	    Post p5 = new Post(new Date(2017, 4, 7), pavlos, "Happy Birthday Dimitris, even though we are no longer friends!");
	    Post p6 = new Post(new Date(2017, 8,31), eleni, "Bye Summer!");
	    Post p7 = new Post(new Date(2017, 8,30), dimitris, "Drop it like it's hot!");
	    Post p8 = new Post(new Date(2017, 3, 2), pavlos, "Happy birthday Chris!");
	    Post p9 = new Post(new Date(2017, 8,31), elvina, "Bye Summer :( ");
	    Post p10 = new Post(new Date(2017, 8, 31), andreas, "Wake me up when September ends!");
	    Post p11 = new Post(new Date(2017, 3, 29), andreas, "Finally! I'm home!");
	    Post p12 = new Post(new Date(2017, 2, 3), chris, "Happy Birthday to me!");
	    Post[] posts = { p12, p11 , p10, p9, p8, p7, p6, p5, p4, p3 , p2 ,p1};
	    for(Post post : posts)
	    	post.getPublisher().addTopostsList(post);
	    
	 //Dhmiourgia Groups & ClosedCroups
	    
	    Group g1 = new Group("Tsili Kafeneio", "Oloi oi opadoi edw");     
	    ClosedGroup cg1 = new ClosedGroup("Hermanos",  "Aderfia Tsiotra");
	    Group g2 = new Group("Paok -4-", "PRWTATHLIMA STON PYRGO TON LEYKO");
	    ClosedGroup cg2 = new ClosedGroup("Cinema Fans", "All about movies");
	    Group g3 = new Group("Olympiakos G7", "Thrylos");
	    ClosedGroup cg3 = new ClosedGroup("NBA Fans", "LET'S PLAY!");
	  
	    //Pros8hkh Users sta Group
	    
	    g1.addUser(pavlos);
	    g1.addUser(andreas);
	    g1.addUser(mpampis);
	    g1.addUser(chris);
	    g1.addUser(gregory);
	    
	    cg1.addUser(dimitris);
	    cg1.addUser(alexandros);
	    
	    g2.addUser(eleni);
	    g2.addUser(dimitris);
	    g2.addUser(alexandros);
	    g2.addUser(natasha);
	    g2.addUser(andreas);
	    
	    cg2.addUser(elvina);
	    cg2.addUser(eleni);
	    cg2.addUser(natasha);
	    cg2.addUser(dimitris);
	    cg2.addUser(alexandros);
	    
	    g3.addUser(mpampis);
	    g3.addUser(elvina);
	    g3.addUser(gregory);
	    
	    cg3.addUser(dimitris);
	    cg3.addUser(chris);
	    cg3.addUser(alexandros);
	    cg3.addUser(andreas);
        cg3.addUser(mpampis);
        cg3.addUser(pavlos);
	    		
	    //Anathesh filiwn
        dimitris.addFriend(alexandros);
        dimitris.addFriend(chris);
        dimitris.addFriend(eleni);
        alexandros.addFriend(mpampis);
        alexandros.addFriend(chris);
        alexandros.addFriend(eleni);
        alexandros.addFriend(gregory);
        chris.addFriend(eleni);
        chris.addFriend(pavlos);
        chris.addFriend(andreas);
        andreas.addFriend(natasha);
        andreas.addFriend(gregory);
        elvina.addFriend(natasha);
        
       
        
	   do { 
	    System.out.println("Hello, Dimitris!");
		System.out.println("Friends List: ");
		for(User user : dimitris.getfriendsList()) {
			System.out.println(user.getName());
		}
		System.out.println( );
		System.out.println("Choose option for suggested friends: ");
		System.out.println("1-By friends");
		System.out.println("2-By Groups"); 
		System.out.println("3-By your last post");
		System.out.println("4-Exit");
	
		do {
			System.out.print("Choice: ");
			Scanner s = new Scanner(System.in);
			choice = s.nextInt();
			System.out.println( );
		}while (choice <1 || choice >4);
		
			switch (choice)
			{
			
			case 1: 
				dimitris.findSuggestedFriendsByFriends();
				if(dimitris.getSuggestedFriendsList().size() == 0 || dimitris.getfriendsList().size() == 0)
					System.out.println("No suggested friends!");
				else {
					System.out.println("Suggested Friends");
					System.out.println("--------------------");
				for(User user : dimitris.getSuggestedFriendsList()) {
				System.out.println(user.getName());}
				System.out.println();
				}
				System.out.println("--------------------");
				break;
	
			case 2: 
				dimitris.findSuggestedFriendsByGroups();
				if(dimitris.getSuggestedFriendsList().size() == 0 || dimitris.getgroupsList().size()==0)
					System.out.println("No suggested friends!");
				else {
					System.out.println("Suggested Friends");
					System.out.println("--------------------");
				for(User user : dimitris.getSuggestedFriendsList()) {
					System.out.println(user.getName());}
					System.out.println();
				}
				System.out.println("--------------------");
					break;
					
			case 3: 
				
				 dimitris.findSuggestedFriendsByPost();
				if(dimitris.getSuggestedFriendsList().size() == 0 || dimitris.getgroupsList().size()==0)
					System.out.println("No suggested friends!");
				else {
					System.out.println("Suggested Friends");
					System.out.println("--------------------");
				for(User user : dimitris.getSuggestedFriendsList()) {
					System.out.println(user.getName());}
					System.out.println();
				}
				System.out.println("--------------------");
					break;
			case 4: 
				System.out.println("Exit");
				break;
			default:
				break;
				
			}
		}while (choice!=4);
		
	}

}
