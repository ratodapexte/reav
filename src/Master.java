import java.util.Scanner;

public class Master extends User {
    public Master(String name, String email, String cpf)
    {
        super(name, email, cpf);
    }

    static Master newCollaborator()
    {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String cpf = scanner.nextLine();

        return new Master(name, email, cpf);
    }
}
