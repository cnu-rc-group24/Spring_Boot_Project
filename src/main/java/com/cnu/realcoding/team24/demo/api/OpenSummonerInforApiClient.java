package com.cnu.realcoding.team24.demo.api;

import com.cnu.realcoding.team24.demo.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenSummonerInforApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-18ead41c-f734-4d13-918e-105830198ef6";
    //https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/
    private final String SummonerURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{EncryptedSummonerId}?api_key={apiKey}";

    public SummonerDTO getSummonerInformation(String SummonerName) {
        SummonerDTO summonerDTO = restTemplate.exchange(SummonerURL, HttpMethod.GET, null, SummonerDTO.class, SummonerName, apiKey).getBody();
        return summonerDTO;
    }
}
