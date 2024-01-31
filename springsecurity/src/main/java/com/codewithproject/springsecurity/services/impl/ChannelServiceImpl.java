package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.ChannelDto;
import com.codewithproject.springsecurity.dto.CommunityDto;
import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import com.codewithproject.springsecurity.repository.CommunityRepository;
import com.codewithproject.springsecurity.seeder.ChannelSeeder;
import com.codewithproject.springsecurity.services.ChannelsService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelsService {

    @Autowired
    private ChannelRepository channelRepo;

    @Autowired
    private CommunityRepository comRepo;

    @Autowired
    private ChannelSeeder channelSeeder;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${youtube.api.key}")
    private String apiKey;

    @Value("${youtube.api.channels}")
    private String apiChannels;

    public void truncateLanguages() {
        channelRepo.truncateTable();
    }

    public List<Channel> seederChannels() {
        List<Channel> result = new ArrayList<>();
        result = channelSeeder.seederChannels();
        return result;
    }

    public List<ChannelDto> getListChannels(Integer limit, String filter) {
        List<ChannelDto> result = new ArrayList<>();
        List<Channel> listChannel = channelRepo.getListChannels();
        if (!listChannel.isEmpty()) {
            result = listChannel.stream().map(c -> {
                ChannelDto dto = new ChannelDto();
                c.convertToDto(dto, Constants.LANG_VI);
                return dto;
            }).collect(Collectors.toList());
        }
        return result;
    }

    public List<CommunityDto> getListCommunityByIDChannel(String idChannel) {
        List<CommunityDto> resultItemDtoList = new ArrayList<>();
        List<Object[]> resultList = comRepo.getListCommunityByIDChannel(idChannel);
        CommunityDto resultItemDto;
        for (Object[] object : resultList) {
            resultItemDto = new CommunityDto();
            resultItemDtoList.add(resultItemDto.convertObjectToDto(object));
        }
        return resultItemDtoList;
    }

    public CommunityDto getCommunity(Integer idCom) {
        List<Object[]> resultList = comRepo.getCommunityByID(idCom);
        CommunityDto result = new CommunityDto();
        for (Object[] object : resultList) {
            CommunityDto resultItemDto = new CommunityDto();
            result = resultItemDto.convertObjectToDto(object);
        }
        return result;
    }

    public List<String> getAllIdChannels() {
        List<String> result = new ArrayList<>();
        result = channelRepo.getAllIdChannels();
        return result;
    }

    public List<Channel> updateYouTubeSubcribe() {
        List<Channel> listChannels = new ArrayList<>();
        List<String> listIdChannels = getAllIdChannels();
        if (listIdChannels.isEmpty()) {
            return listChannels;
        }

        // get subcribe from API
        List<Integer> subCount = new ArrayList<>();
        List<List> listObj = new ArrayList<>();
        HttpEntity <Void> httpEntity = new HttpEntity<>(gethttpHeaders());

        listObj = listIdChannels.stream().map(id -> {
            StringBuilder sb = new StringBuilder(apiChannels);
            String apiURL = sb.append("&id=")
                    .append(id)
                    .append("&key=")
                    .append(apiKey)
                    .toString();
            RestTemplate restTemplate = new RestTemplate();
            val response = restTemplate.exchange(apiURL, HttpMethod.GET ,httpEntity, List.class); ;
            return response.getBody();
        }).collect(Collectors.toList());

        if (listObj.isEmpty()) {
            return listChannels;
        }
        return listChannels;
    }

    private HttpHeaders gethttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

//    public List<Map<String, Object>> getPosts() {
//        StringBuilder sb = new StringBuilder(apiChannels);
//        String apiURL = sb.append("&id=UCdOWyp25T0HDtjpnV2LpIyw&key=")
//                .append(apiKey)
//                .toString();
//
//        HttpEntity <Void> httpEntity  = new HttpEntity<>(gethttpHeaders());
//        val response = restTemplate.getForObject(apiURL, httpEntity, String.class); ;
//        return  response.getBody();
//    }

    public String getPosts()
    {
        StringBuilder sb = new StringBuilder(apiChannels);
        String apiURL = sb.append("&id=UCdOWyp25T0HDtjpnV2LpIyw&key=")
                .append(apiKey)
                .toString();

        System.out.println(apiURL);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(apiURL, String.class);
        System.out.println(result);
        return result;
    }
}
