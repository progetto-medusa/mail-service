package com.progetto_medusa.mail_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.progetto_medusa.mail_service.config.OkHttpClientCustom;
import com.progetto_medusa.mail_service.model.components.UserGuiDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalCallingService {
    private static final String USER_SERVICE_URL = "http://localhost:8080/";
    private final ObjectMapper objectMapper;
    private final OkHttpClientCustom okHttpClientCustom;

    public List<UserGuiDTO> retrieveUserData() throws IOException {
        String url = USER_SERVICE_URL + "role";
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

        String urlWithParams = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(urlWithParams)
                .build();

        Response response = okHttpClientCustom.okHttpClient().newCall(request).execute();

        if (!response.isSuccessful() || response.body() == null) {
            throw new IOException("Unexpected code " + response);
        }

        String responseBody = response.body().string();

        return objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, UserGuiDTO.class));

    }
}