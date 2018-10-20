import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Research {
    public String title;
    public String initDate;
    public String endDate;
    public Status status;
    public String financier;
    public String financing;
    public String goal;
    public String description;
    public ArrayList<User> collabs;
    public ArrayList<User> advisors;
    public ArrayList<Publication> publications = null;

    public Research(String initDate, String title, String financier, String financing, String goal, String description,
                    Status status, ArrayList<User> collabs, ArrayList<User> advisors)
    {
        this.description = description;
        this.financier = financier;
        this.financing = financing;
        this.advisors = advisors;
        this.initDate = initDate;
        this.collabs = collabs;
        this.status = status;
        this.title = title;
        this.goal = goal;
    }

    public static void newResearch(ArrayList<Research> listOfResearch, ArrayList<User> listOfUsers)
    {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String initDate = date.format(calendar.getTime());

        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String financier = scanner.nextLine();
        String financing = scanner.nextLine();
        String goal = scanner.nextLine();
        String description = scanner.nextLine();
        Status status = Status.ELABORATION;
        ArrayList<User> collabs = new ArrayList<User>();
        ArrayList<User> advisors = new ArrayList<User>();

        alocateCollaborator(collabs, advisors, listOfUsers);

        listOfResearch.add(new Research(initDate, title, financier, financing, goal, description, Status.PROGRESS, collabs,
                advisors));

    }

    public static void finishResearch(ArrayList<Research> listOfResearch)
    {
        Research research = getResearchByTitle(listOfResearch);

        if(research == null)
            System.out.println("Nenhum projeto foi encontrado!");
        else
        {
            if(research.publications.size() > 0)
            {
                research.status = Status.FINISHED;
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                Calendar calendar = Calendar.getInstance();
                String endDate = date.format(calendar.getTime());
                research.endDate = endDate;
            }
            else
                System.out.println("Nao foi possivel finalizar o projeto");
        }
    }

    public static void alocateCollaborator(ArrayList<User> collabs, ArrayList<User> advisors, ArrayList<User> listOfUsers)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Usuario a ser alocado: ");
            User user = User.getUserByCpf(listOfUsers);
            if(user instanceof Teacher)
                advisors.add(user);
            else if(user == null)
                System.out.println("Usuario nao encontrado");
            else
            {
                collabs.add(user);
            }

            if(advisors.size() > 0)
            {
                System.out.print("Deseja continuar? 1(Sim)");
                int option = scanner.nextInt();
                if(option != 1)
                    break;
            }
        }
    }

    public static Research getResearchByTitle(ArrayList<Research> listOfResearch)
    {
        System.out.print("Digite o titulo do projeto: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        for (Research research: listOfResearch) {
            if(research.title.equals(title))
                return research;
        }
        return null;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public Status getStatus() {
        return status;
    }
}
