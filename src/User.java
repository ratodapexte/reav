import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public String name;
    public String email;
    public String cpf;
    //lista de projetos
    public ArrayList<Publication> publications = null;

    public User(String name, String email, String cpf)
    {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public static void addCollaborator(ArrayList<User> listOfUser)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Graduando;\n2- Mestrado;\n3- Doutorado;\n4- Pesquisador;\n5- Professor.");
        int option = scanner.nextInt();

        switch(option)
        {
            case  1:
                listOfUser.add(Graduate.newCollaborator());
                break;
            case 2:
                listOfUser.add(Master.newCollaborator());
                break;
            case 3:
                listOfUser.add(Doctor.newCollaborator());
                break;
            case 4:
                listOfUser.add(Researcher.newCollaborator());
                break;
            case 5:
                listOfUser.add(Teacher.newCollaborator());
                break;
        }
    }

    public static User getUserByCpf(ArrayList<User> listOfUser)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite cpf: ");
        String cpf = scanner.nextLine();

        for (User user: listOfUser) {
            if(user.cpf.equals(cpf))
                return user;
        }
        return null;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

}
