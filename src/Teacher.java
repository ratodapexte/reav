import java.util.Scanner;

public class Teacher extends User {
    public Teacher(String name, String email, String cpf)
    {
        super(name, email, cpf);
    }

    static Teacher newCollaborator()
    {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String cpf = scanner.nextLine();

        return new Teacher(name, email, cpf);
    }
}
