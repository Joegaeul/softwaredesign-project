import controller.MemberController;
import model.Repository;
import view.memberview.LoginFrame;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        MemberController memberController = new MemberController(repository);

        LoginFrame loginFrame = new LoginFrame(memberController);
    }
}