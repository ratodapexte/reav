import java.util.Scanner;

public class Researcher extends User {
    public Researcher(String name, String email, String cpf)
    {
        super(name, email, cpf);
    }

    static Researcher newCollaborator()
    {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String cpf = scanner.nextLine();

        return new Researcher(name, email, cpf);
    }
}
