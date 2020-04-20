import java.util.ArrayList;

public class Group {

    private String name, description;
    private ArrayList<User> groupMembers = new ArrayList<>();

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<User> getGroupMembers() {
		return groupMembers;
	}

	private boolean isHeMember(User aUser) {
        boolean flag = false;

        for(User u : groupMembers)
            if(u.equals(aUser))
                flag = true;

        return flag;
    }
	


    public void addUser(User aUser) {
        if(this.isHeMember(aUser))
            return ;
        else {
            groupMembers.add(aUser);
            aUser.addTogroupsList(this);
        }

    }


}