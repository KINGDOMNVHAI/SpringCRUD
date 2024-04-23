package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.CommunityDto;
import com.codewithproject.springsecurity.dto.entitydto.ChannelDto;
import com.codewithproject.springsecurity.services.impl.ChannelServiceImpl;
import com.codewithproject.springsecurity.services.impl.UserServiceImpl;
import com.codewithproject.springsecurity.services.impl.VideoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChannelController {

    @Autowired
    private ChannelServiceImpl channelsServiceImpl;

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/public/channel/get-all")
    public List<ChannelDto> getAllChannel() {
//        Map<String, Object> result = new HashMap<>();
        List<ChannelDto> listChannel = new ArrayList<>();
        try {
            listChannel = channelsServiceImpl.getListChannels(0, Constants.FILTER_DESC);

//            result.put(Constants.MAP_SUCCESS, true);
//            result.put(Constants.MAP_RESULT, listChannel);
//            result.put(Constants.MAP_MESSAGE, Constants.SAVE_SUCCESSED);
        } catch (Exception e) {
//            result.put(Constants.MAP_SUCCESS, false);
//            result.put(Constants.MAP_MESSAGE, Constants.SAVE_FAILED);
        }
        return listChannel;
    }

    @PostMapping("/public/channel/search")
    public List<ChannelDto> searchChannel(@RequestBody Map<String, Object> param) {
//        HashMap<String, Object> param = new HashMap<>();
        int languageId = Constants.DEFAULT_LANGUAGE;
        param.put(Constants.LANGUAGE_ID, languageId);
        param.put(Constants.PARAM_OFFSET, 0);
        param.put(Constants.PARAM_LIMIT, 5);
        List<ChannelDto> listVideo = new ArrayList<>();
        try {
            listVideo = channelsServiceImpl.searchListVideo(param);
        } catch (Exception e) {

        }
        return listVideo;
    }

    @GetMapping("/public/channel/community/get-all/{idChannel}")
    public List<CommunityDto> getAllCommunity(@PathVariable String idChannel) {
        List<CommunityDto> listCom = new ArrayList<>();
        try {
            listCom = channelsServiceImpl.getListCommunityByIDChannel(idChannel);
        } catch (Exception e) {

        }
        return listCom;
    }

    @GetMapping("/public/channel/community/{idCom}")
    public CommunityDto getAllCommunity(@PathVariable Integer idCom) {
        CommunityDto postCom = new CommunityDto();
        try {
            postCom = channelsServiceImpl.getCommunity(idCom);
        } catch (Exception e) {

        }
        return postCom;
    }
}
