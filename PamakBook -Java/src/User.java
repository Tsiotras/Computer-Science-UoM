
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class User  {

    private String name;
    private String email;
    private ArrayList<User> friendsList = new ArrayList<>();
    private ArrayList<Group> groupsList = new ArrayList<>();
    private HashSet<User> suggestedFriends = new HashSet<>();
    private TreeSet<Post> postsList = new TreeSet<>();
    
    public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public boolean isHeFriend(User aUser) {
        boolean isHeFriend = false;

        
        if(!this.equals(aUser)) {
            
            for(User u: this.friendsList) {
                if(u.equals(aUser)) {
                    isHeFriend = true;
                    break;
                }
            }
        }

        return isHeFriend;
    }

    public void addFriend(User aUser) {
       
        if(this.isHeFriend(aUser))
            return;
        
        else {
            if(this.equals(aUser)) {
                return;
            }
            else{
                this.friendsList.add(aUser);
                aUser.friendsList.add(this);
            }
          
        }
         
    }

    
	public ArrayList<User> getfriendsList() {
        return friendsList;
    }
    

	
	public ArrayList<Group> getgroupsList() {
    	return groupsList;
    }
    
    public TreeSet<Post> getpostsList() {
    	return postsList;
    }
    
    public HashSet<User> getSuggestedFriendsList(){
    	return suggestedFriends;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public void addTogroupsList (Group group) {
    	this.groupsList.add(group);
    	group.addUser(this);
    }

    public void addTopostsList (Post post) {
    	this.postsList.add(post);
    }
    
  
    public void addTosuggestedFriends (User user) {
    	this.suggestedFriends.add(user);
    }
    
    
    //SUGGESTED ME BASH TOYS FILOYS
    public void findSuggestedFriendsByFriends() {
    	this.suggestedFriends.removeAll(suggestedFriends);
    	for(User user : this.friendsList) {
    		for(User aUser : user.friendsList) {
    			if(aUser.isHeFriend(this) == false || aUser.equals(this) == false) {
    				this.suggestedFriends.add(aUser);
    			}
    		}
    		
    	}
    	for(User user : this.friendsList) {
    	this.suggestedFriends.remove(user);
    	}
    	this.suggestedFriends.remove(this);
    }  	
    
    //SUGGESTED ME BASH TA GROUPS
    public void findSuggestedFriendsByGroups (){
    	this.suggestedFriends.removeAll(suggestedFriends);
    	for(Group group : groupsList)
    		for(User user : group.getGroupMembers()) {
    			if(user.isHeFriend(this) == false || user.equals(this) == false  ) {
    				this.addTosuggestedFriends(user);
    			}
    		}
    	  
    	
    	
    	for(User user : this.friendsList) {
        	this.suggestedFriends.remove(user);
        	}
        	this.suggestedFriends.remove(this);
    }
    
   public void findSuggestedFriendsByPost() {
	   this.suggestedFriends.removeAll(suggestedFriends);
	   Post lastPost = this.postsList.last();
	   
	   for(User user : UserCatalog.getAllUsers()) {
	   for(Post post : user.postsList) {
		   if(post.getDate().equals(lastPost.getDate()))
			   this.addTosuggestedFriends(post.getPublisher());
   		}
	   
	 
	   
	     }
	  
	   for(User user : this.friendsList) {
       	this.suggestedFriends.remove(user);
       	}
       	this.suggestedFriends.remove(this);
	   
		   }  
		  
   }
    	
    
  
   
