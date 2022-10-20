package com.example.pss.domain.user.service;

import com.example.pss.domain.user.domain.User;
import com.example.pss.domain.user.domain.repository.UserRepository;
import com.example.pss.domain.user.present.dto.TokenResponse;
import com.example.pss.global.enums.Authority;
import com.example.pss.global.properties.GithubProperties;
import com.example.pss.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class UserSignService {
    private final UserRepository userRepository;
    private final GithubProperties githubProperties;
    private final JwtTokenProvider jwtTokenProvider;
    private String rst;

    @Transactional
    public TokenResponse getCode(String code) throws IOException, org.json.simple.parser.ParseException {
        StringBuffer result = new StringBuffer();

        StringBuilder builder = new StringBuilder("https://github.com/login/oauth/access_token");
        builder
                .append("?")
                .append(URLEncoder.encode("client_id", "UTF-8"))
                .append("=")
                .append(githubProperties.getClientId());

        builder
                .append("&")
                .append(URLEncoder.encode("client_secret", "UTF-8"))
                .append("=")
                .append(githubProperties.getClientSecret());

        builder
                .append("&")
                .append(URLEncoder.encode("code", "UTF-8"))
                .append("=")
                .append(code);

        URL url = new URL(builder.toString());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        BufferedReader rd;
        if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            System.out.println(connection.getResponseCode());
        }

        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line + "\n");
        }
        rd.close();
        connection.disconnect();

        String rst2 = result + "";

        rst = "token " + rst2.substring(13, 53);

        return getData(rst);
    }

    @Transactional
    public TokenResponse getData(String token) throws JsonProcessingException, org.json.simple.parser.ParseException {
        HashMap<String, Object> result = new HashMap<String, Object>();
        String jsonInString = "";
        String url = "https://api.github.com/user";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", token);
        HttpEntity<?> entity = new HttpEntity<>(header);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        ResponseEntity<?> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

        result.put("statusCode", resultMap.getStatusCodeValue());
        result.put("header", resultMap.getHeaders());
        result.put("body", resultMap.getBody());

        ObjectMapper mapper = new ObjectMapper();
        jsonInString = mapper.writeValueAsString(resultMap.getBody());

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInString);

        String name = (String) jsonObject.get("login");
        String image = (String) jsonObject.get("avatar_url");
        String email = (String) jsonObject.get("email");

        if (userRepository.findByNickname(name).isEmpty()) {
            User user = userRepository.save(
                    User.builder()
                            .nickname(name)
                            .imageUrl(image)
                            .email(email)
                            .authority(Authority.user)
                            .build()
            );
        }

        String accessToken = jwtTokenProvider.generateAccessToken(name);
        String refreshToken = jwtTokenProvider.generateRefreshToken(name);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .authority(Authority.user)
                .build();
    }
}
