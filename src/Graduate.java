import java.util.Scanner;

public class Graduate extends User {
    public Graduate(String name, String email, String cpf)
    {
        super(name, email, cpf);
    }

    public static Graduate newCollaborator()
    {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String cpf = scanner.nextLine();

        return new Graduate(name, email, cpf);
    }
}
