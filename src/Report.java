import java.util.ArrayList;

public class Report {
    public static void showReport(ArrayList<Publication> listOfPublication, ArrayList<Research> listOfResearch,
                                  ArrayList<User> listOfUser)
    {
        System.out.println(listOfUser.size() + " colaboradores, " + listOfPublication.size() + " publicações. " +
                listOfResearch.size() + " projetos no total.");
        int ela = 0, prog = 0, fin = 0;

        for (Research research: listOfResearch){
            if(research.getStatus() == Status.ELABORATION)
                ela++;
            else if(research.getStatus() == Status.PROGRESS)
                prog++;
            else
                fin++;
        }
        System.out.println("Sendo " + ela + " em elaboramento, " + prog + " em andamento e " + fin + "finalizados");
    }
}
