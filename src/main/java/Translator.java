import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Translator {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Введите предложение на русском языке:");
        Scanner scanner = new Scanner(System.in);
        String sentenceToTranslate = scanner.nextLine();

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://translate.api.cloud.yandex.net/translate/v2/translate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + "t1.9euelZqUlpjHlM2Uy8-amJCSzsfNz-3rnpWanYvNjpeOnM2VxovPmJ2VzpLl8_cvbA1F-e9UY1wn_d3z928aC0X571RjXCf9zef1656Vmo3Mx8uQlomZzZLGzs6WjZqc7_zF656Vmo3Mx8uQlomZzZLGzs6WjZqc.Qok55tPNMH5wgj9QIWNJX_7aZKSuUDtPiCO96kQBk8P0BjFHk4Mbr_1NRfyGLdf4p9lSc2IE144LTXZUbgeFDw");

        Map<String, String> jsonData = new Hashtable<>();
        jsonData.put("folderId", "b1g4v6g3dc04od4170r7");
        jsonData.put("texts", "[" + sentenceToTranslate + "]");
        jsonData.put("targetLanguageCode", "en");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);

        YandexResponse response = restTemplate.postForObject(url, request, YandexResponse.class);
//        String response = restTemplate.postForObject(url, request, String.class);

        // Парсим полученный JSON с помощью Jackson
        // 1 способ
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode node = mapper.readTree(response);

//        System.out.println("Перевод: " + node.get("translations").get(0).get("text"));
        System.out.println("Перевод: " + response.getTranslations().get(0).getText());



    }
}
