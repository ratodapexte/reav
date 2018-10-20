import java.util.Scanner;

public class Doctor extends User{
    public Doctor(String name, String email, String cpf)
    {
        super(name, email, cpf);
    }

    public static Doctor newCollaborator()
    {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String cpf = scanner.nextLine();

        return new Doctor(name, email, cpf);
    }
}
