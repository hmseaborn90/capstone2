package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class AccountService {
    public static final String API_BASE_URL = "http://localhost:8080/account/";
    private RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;


    public void setAuthToken(AuthenticatedUser currentUser) {
        if (currentUser != null && currentUser.getToken() != null) {
            System.out.println(currentUser.getToken());
            this.authToken = currentUser.getToken();
        } else {
            throw new IllegalArgumentException("Invalid AuthenticatedUser or token");
        }
    }
    public BigDecimal getBalance(Integer accountId) {
        BigDecimal balance = null;
        try {
            ResponseEntity<BigDecimal> response =
                    restTemplate.exchange(API_BASE_URL + "balance/" + accountId, HttpMethod.GET, makeAuthEntity(), BigDecimal.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                balance = response.getBody();
            } else {
                System.out.println("Error: " + response.getStatusCode() + " - " + response.getBody());
            }
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return balance;
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        if (authToken != null) {
            headers.setBearerAuth(authToken);
        } else {
            throw new IllegalStateException("Auth token not set");
        }
        return new HttpEntity<>(headers);
    }
}
