package com.blox.StringtoJson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class StringtoJsonApplication {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		SpringApplication.run(StringtoJsonApplication.class, args);
		String jsonString = "{\"name\":\"rajashekar\",\"rollno\":18}";
		String jsonString2 = "[1,2,3]";
		convertToCorrespondingObject(jsonString, Map.class);//to convert desired class
		convertToCorrespondingObject(jsonString2, List.class);
	}

	public static void convertToCorrespondingObject(String j1, Class<?> i)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(j1);//when we dont which type it is using jsonNode
		if (jsonNode.isObject()) {
			Map<Object, Object> map = (Map<Object, Object>) mapper.readValue(j1, i);//converting to map
			System.out.println(map);
		} else if (jsonNode.isArray()) {
			List<Object> lst = (List<Object>) mapper.readValue(j1, i);//converting to array
			System.out.println(lst);

		}
		//viceversa

	}

}
