import java.io.File;
import java.util.LinkedList;

public class App {
    static File jsonFile;
    private static JsonConverter jsonConverter = new JsonConverter();
    static JsonObj[] jsonObjs;
    private static Searcher searcher = new Searcher();
    private static String pathname = "output.txt";

    public static void main(String[] args) {
        jsonFile = new File(pathname);
        jsonConverter.loadFromJson();

        String[] arr = {"Bug", "bug"};
        String name = "aadam";
        Integer summaryLength = 30;
        Integer numberOfDays = 2;
        String fromDate = "2017-06-02";
        String toDate = "2018-03-08";

        LinkedList<JsonObj> list;
        LinkedList<String> projectNames;

        //Wywołania poszczególnych wyszukiwań

        //list = searcher.searchByReporterName(name);

        //list = searcher.searchByWordsInDescription(arr);

        //list = searcher.searchBySummaryLengthLessThan(summaryLength);

        //list = searcher.searchByLoggedTimeLessThan(numberOfDays);

        list = searcher.searchByCreationTime(fromDate,toDate);
        
        projectNames = searcher.searchProjectNamesByIssues();

        System.out.println(projectNames);

        list.forEach(JsonObj::print);
    }
}
