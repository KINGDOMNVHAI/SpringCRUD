package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.config.ChannelContants;
import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.CommunityDto;
import com.codewithproject.springsecurity.dto.entitydto.ChannelDto;
import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import com.codewithproject.springsecurity.repository.CommunityRepository;
import com.codewithproject.springsecurity.seeder.ChannelSeeder;
import com.codewithproject.springsecurity.services.ChannelService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.codewithproject.springsecurity.config.ParamConstants.PARAM_KEYWORD;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

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
        truncateLanguages();
        return channelSeeder.seederChannels();
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
        return channelRepo.getAllIdChannels();
    }

    public List<Channel> updateYouTubeSubcribe() {
        List<Channel> listChannels = new ArrayList<>();
        listChannels = channelRepo.getListChannels();
        if (listChannels.isEmpty()) {
            return listChannels;
        }

        // get subscribe from API
        List<Channel> params = new ArrayList<>();
        params = listChannels.stream().map(channel -> {
            Integer subscribeCount = getSubscriberCount(channel.getIdChannel());
            if (subscribeCount > 0) {
                System.out.println(subscribeCount);
                channel.setSubscribe(subscribeCount);
            }
            return channel;
        }).collect(Collectors.toList());

        // update subscribe
        channelRepo.saveAll(params);

        return params;
    }

    private Integer getSubscriberCount(String idChannel) {
        int subCount = 0;
        try {
            String apiKey = ChannelContants.APIKEY;

            // Create the API request URL
            String apiUrl = "https://www.googleapis.com/youtube/v3/channels?part=snippet,statistics&id=" + idChannel + "&key=" + apiKey;

            // Send the HTTP GET request
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the JSON response
            try {
                Gson gs = new Gson();
                JsonObject convertedObject = gs.fromJson(response.toString(), JsonObject.class);
                JsonElement elementItems = convertedObject.get("items").getAsJsonArray().get(0);
                JsonElement elementStatistics = elementItems.getAsJsonObject().get("statistics");
                String sub = elementStatistics.getAsJsonObject().get("subscriberCount").getAsString();
                subCount = Integer.parseInt(sub);
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subCount;
    }

    public List<ChannelDto> searchListVideo(Map<String, Object> param) {
        String keyword = param.get(PARAM_KEYWORD).toString();
        List<ChannelDto> result = new ArrayList<>();
        List<Channel> listChannel = new ArrayList<>();
        listChannel = channelRepo.searchListVideo(keyword);

        if (!listChannel.isEmpty()) {
            result = listChannel.stream().map(c -> {
                ChannelDto dto = new ChannelDto();
                c.convertToDto(dto, param.get(Constants.LANGUAGE_ID).toString());
                return dto;
            }).collect(Collectors.toList());
        }

        return result;
    }
}
