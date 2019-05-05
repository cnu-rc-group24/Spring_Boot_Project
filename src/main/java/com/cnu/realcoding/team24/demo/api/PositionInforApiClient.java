package com.cnu.realcoding.team24.demo.api;

import com.cnu.realcoding.team24.demo.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class PositionInforApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-18ead41c-f734-4d13-918e-105830198ef6";
    private final String SummonerURL = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{EncryptedSummonerId}?api_key={apiKey}";

    public LeaguePositionDTO getPositionInfor(String SummoenrId) {
        LeaguePositionDTO leaguePositionDTO = restTemplate.exchange(SummonerURL, HttpMethod.GET, null, LeaguePositionDTO.class, SummoenrId, apiKey).getBody();
        return leaguePositionDTO;
    }
}
