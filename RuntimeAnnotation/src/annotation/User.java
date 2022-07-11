package annotation;

public class User {
    public User[] u = null;

    public User[] getU() {
        return u;
    }

    @NotEmpty
    public void setU(User[] u) {
        this.u = u;
    }
}
