package com.solvd.savich.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Singer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


public class JsonExec {
    private final static Logger LOGGER = Logger.getLogger(JsonExec.class);

    public String convertJavaToJsonString(Object obj){
        String jsonString = "";
        try { jsonString = new ObjectMapper().writeValueAsString(obj);
            LOGGER.info("Convert to string, finished!");}

        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    public void convertJsonToJavaFile(Object obj, String pathToFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Path.of(pathToFile).toFile(), obj);
            LOGGER.info("write to file, finished!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Singer convertJsonStrToArtistsPOJO(String pathToFile){
        Singer artists = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            artists = mapper.readValue(Path.of(pathToFile).toFile(),Singer.class);
            LOGGER.info("convert to POJO, finished!");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return artists;
    }
    public List<Singer> convertJsonStrToListSingerPOJO(String pathToFile){
        List<Singer> artists = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            artists = mapper.readValue(Path.of(pathToFile).toFile(), new TypeReference<>() {
            });
            LOGGER.info("convert to POJO, finished!");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return artists;
    }
}
