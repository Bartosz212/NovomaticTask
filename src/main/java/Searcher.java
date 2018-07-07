import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

class Searcher {

    LinkedList<JsonObj> searchByReporterName(String name){

        LinkedList<JsonObj> objList = new LinkedList<>();

        for (JsonObj obj: App.jsonObjs){
            if (obj.reporter.equals(name)){
                objList.add(obj);
            }
            
        }

        return objList;
    }

    LinkedList<JsonObj> searchByWordsInDescription(String[] wordsArray){

        LinkedList<JsonObj> objList = new LinkedList<>();

        for (JsonObj obj: App.jsonObjs){
            for (String word: wordsArray) {
                if (obj.description.matches(".*\\b"+word+"\\b.*")) {
                    objList.add(obj);
                    break;
                }
            }

        }

        return objList;
    }

    LinkedList<JsonObj> searchByLoggedTimeLessThan(Integer days){

        LinkedList<JsonObj> objList = new LinkedList<>();
        Integer loggedTimeSecond = days*24*60*60;

        for (JsonObj obj: App.jsonObjs){
            if (obj.loggedTime < loggedTimeSecond) {
                objList.add(obj);
            }
        }

        return objList;
    }

    LinkedList<JsonObj> searchByCreationTime(String _fromDate, String _toDate){

        LinkedList<JsonObj> objList = new LinkedList<>();

        int[] from = Arrays.asList(_fromDate.split("-")).stream().mapToInt(Integer::parseInt).toArray();
        int[] to = Arrays.asList(_toDate.split("-")).stream().mapToInt(Integer::parseInt).toArray();
        Date fromDate = new Date(from[0], from[1], from[2]);
        Date toDate = new Date(to[0], to[1], to[2]);

        for (JsonObj obj: App.jsonObjs) {
            int[] _creationTime = Arrays.asList(obj.created.split("-")).stream().mapToInt(Integer::parseInt).toArray();
            Date creationTime = new Date(_creationTime[0], _creationTime[1], _creationTime[2]);
            if(creationTime.after(fromDate) && creationTime.before(toDate) || creationTime.equals(fromDate) || creationTime.equals(toDate)){
                objList.add(obj);
            }
        }
        return objList;
    }

    LinkedList<JsonObj> searchBySummaryLengthLessThan(Integer number){

        LinkedList<JsonObj> objList = new LinkedList<JsonObj>();

        for (JsonObj obj: App.jsonObjs){
            if (obj.summary.length() < number) {
                objList.add(obj);
            }
        }

        return objList;
    }

    LinkedList<String> searchProjectNamesByIssues(){

        LinkedList<String> projectNames = new LinkedList<>();

        for (JsonObj obj: App.jsonObjs){
            String projectName = obj.key.split("-")[0];
            if (!projectNames.contains(projectName)){
                projectNames.add(projectName);
            }
        }

        return projectNames;
    }
}
