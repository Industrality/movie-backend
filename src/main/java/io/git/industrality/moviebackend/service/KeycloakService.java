package io.git.industrality.moviebackend.service;

import io.git.industrality.moviebackend.dao.CreateUserRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KeycloakService {

  private final RestTemplate restTemplate = new RestTemplate();

  private String getAdminAccessToken() {
    String url = "http://localhost:8080/realms/master/protocol/openid-connect/token";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    Map<String, String> body = new HashMap<>();
    body.put("client_id", "admin-cli");
    body.put("grant_type", "password");
    body.put("username", "admin");
    body.put("password", "admin");

    HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

    ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

    return (String) response.getBody().get("access_token");
  }

  public void createUser(CreateUserRequest request) {
    String token = getAdminAccessToken();

    String url = "http://localhost:8080/admin/realms/YOUR_REALM/users";

    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(token);
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, Object> user = new HashMap<>();
    user.put("username", request.getUsername());
    user.put("email", request.getEmail());
    user.put("firstName", request.getFirstName());
    user.put("lastName", request.getLastName());
    user.put("enabled", true);
    user.put("credentials", Collections.singletonList(Map.of(
        "type", "password",
        "value", request.getPassword(),
        "temporary", false
    )));

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(user, headers);

    restTemplate.postForEntity(url, entity, String.class);
  }
}
