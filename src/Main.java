import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<User> listOfUser = new ArrayList<User>();
        ArrayList<Research> listOfResearch = new ArrayList<Research>();
        ArrayList<Publication> listOfPublication = new ArrayList<Publication>();

        int option;

        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Novo colaborador;\n2 - Novo projeto\n3 - Finalizar projeto\n 4 - Nova publicação" +
                    "\n5 - Relatório\n 99 - Finalizar");
            option = scanner.nextInt();
            switch(option)
            {
                case 1:
                    User.addCollaborator(listOfUser);
                    break;
                case 2:
                    Research.newResearch(listOfResearch, listOfUser);
                    break;
                case 3:
                    Research.finishResearch(listOfResearch);
                    break;
                case 4:
                    Publication.newPublication(listOfPublication, listOfResearch, listOfUser);
                    break;
                case 5:
                    Report.showReport(listOfPublication, listOfResearch, listOfUser);
                    break;
            }

            if(option == 99)
                break;
        }

    }
}
