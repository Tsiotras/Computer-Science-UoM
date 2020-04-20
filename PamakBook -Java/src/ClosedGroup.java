
public class ClosedGroup extends Group {
	
	public ClosedGroup(String name, String description) {
        super(name, description);
    }


    public void addUser(User aUser) {

        boolean isMember = false;

        for (User u: getGroupMembers()) {
            if (u.equals(aUser)) {
                isMember = true;
                break;
            }
        }

        if (this.getGroupMembers().isEmpty()) {
            this.getGroupMembers().add(aUser);
            aUser.addTogroupsList(this);
        }
        
        else {
            
            if (!isMember) {
                User tempUser;
                boolean mutualFriendFlag = false;
                int sizeOfArray = this.getGroupMembers().size();

                for (int i = 0; i < sizeOfArray; i++) {
                    tempUser = getGroupMembers().get(i);

                    if (tempUser.isHeFriend(aUser)) {
                        this.getGroupMembers().add(aUser);
                        aUser.addTogroupsList(this);
                        mutualFriendFlag = true;
                        break;
                    }
                }

                if (!mutualFriendFlag)
                   return;
            }

        }
    }
}

