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

        LinkedList<JsonObj> l;
        LinkedList<String> pN;
        l = searcher.searchByReporterName(name);
        l = searcher.searchByWordsInDescription(arr);
        l = searcher.searchBySummaryLengthLessThan(summaryLength);
        l = searcher.searchByLoggedTimeLessThan(numberOfDays);
        l = searcher.searchByCreationTime(fromDate,toDate);
        pN = searcher.searchProjectNamesByIssues();
        System.out.println(pN);
        l.forEach(JsonObj::print);
    }
}
