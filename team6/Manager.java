public abstract class Manager {
}

class ShowManager extends Manager{
    public void addShow(){}
    public void updateShow(Show show){}
    public void deleteShow(Show show){}
}

class UserManager extends Manager{
    public void createUser(){}
    public void deleteUser(User user){}
    public void updateUser(User user){}

}