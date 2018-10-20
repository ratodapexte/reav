import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Publication {
    public String name;
    public String conference;
    public String initDate;

    public Publication(String name, String conference, String initDate)
    {
        this.conference = conference;
        this.initDate = initDate;
        this.name = name;
    }

    public static void newPublication(ArrayList<Publication> listOfPublication, ArrayList<Research> listOfResearch,
                                      ArrayList<User> listOfUser)
    {
        System.out.println("Nova publicação");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Conferencia: ");
        String conference = scanner.nextLine();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String initDate = date.format(calendar.getTime());

        Publication publication = new Publication(name, conference, initDate);

        System.out.println("Deseja relacionar publicação a um projeto?");

        Research research = Research.getResearchByTitle(listOfResearch);

        if(research == null)
            System.out.println("Nenhum projeto foi associado!");
        else
        {
            if(research.getStatus() == Status.PROGRESS)
                research.getPublications().add(publication);
            else
                System.out.println("Nao foi possivel associar");
        }

        while (true)
        {
            System.out.print("Colaborador a ser relacionado: ");

            User user = User.getUserByCpf(listOfUser);
            if(user == null)
                System.out.println("Usuario nao encontrado");
            else
                user.getPublications().add(publication);

            System.out.print("Deseja continuar? 1(Sim)");
            int option = scanner.nextInt();
            if(option != 1)
                break;
        }

        listOfPublication.add(publication);
    }


}


