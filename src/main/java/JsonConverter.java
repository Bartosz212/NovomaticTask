import com.google.gson.Gson;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

class JsonConverter {

    static void loadFromJson(){
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(App.jsonFile));
            App.jsonObjs = gson.fromJson(reader, JsonObj[].class);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}