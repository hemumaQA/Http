package org.wbl.JacksonLibrary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
                                  //SERIALIZATION---POJO TO Json--WRITE

public class ObjectToJson {
    public void convertJavaObjectToJson(){

        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);  //json format structure

        Users users = new Users();
        users.setId(5);
        users.setFirstname("Will");
        users.setLastname("Power");

        try {
            om.writeValue(new File("src/test/java/org/wbl/JacksonLibrary/Users.json"),users);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args ) {
        ObjectToJson oj = new ObjectToJson();
        oj.convertJavaObjectToJson();

    }
}
