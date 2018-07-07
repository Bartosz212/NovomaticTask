import com.google.gson.annotations.SerializedName;

class JsonObj {
    @SerializedName("id")
    String id;
    @SerializedName("key")
    String key;
    @SerializedName("summary")
    String summary;
    @SerializedName("description")
    String description;
    @SerializedName("reporter")
    String reporter;
    @SerializedName("created")
    String created;
    @SerializedName("loggedTime")
    Integer loggedTime;

    public void print(){
        System.out.println( "id: "+this.id+
                            "\nkey: "+this.key+
                            "\nsummary: "+this.summary+
                            "\ndescription: "+this.description+
                            "\nreporter: "+this.reporter+
                            "\ncreated: "+this.created+
                            "\nloggedTime: "+this.loggedTime+"\n");
    }
}
