import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
//        System.out.println(restTemplate.getForObject("https://reqres.in/api/users?page=2",String.class));
//        Map<String, String> json = new HashMap<String, String>();
//        json.put("name","Иванов");
//        json.put("job","Лига цифровой экономики");
//        HttpEntity<Map<String,String>> request = new HttpEntity<Map<String, String>>(json);
//        System.out.println(restTemplate.postForEntity("https://reqres.in/api/users",request, String.class));
        String response = restTemplate.getForObject("https://reqres.in/api/users/2",String.class);
        System.out.println(response);
        //Парсинг полученного json с помощью jackson
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(response);
        System.out.println("Email: " + obj.get("data").get("email"));
        System.out.println("Имя: " + obj.get("data").get("first_name"));
        System.out.println("Фамилия: " + obj.get("data").get("last_name"));
    }
}
