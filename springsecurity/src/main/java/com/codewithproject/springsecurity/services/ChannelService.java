package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.dto.entitydto.ChannelDto;
import com.codewithproject.springsecurity.dto.CommunityDto;
import com.codewithproject.springsecurity.entities.Channel;

import java.util.List;

public interface ChannelService {
    List<Channel> seederChannels();

    List<ChannelDto> getListChannels(Integer limit, String filter);

    List<CommunityDto> getListCommunityByIDChannel(String idChannel);

    List<String> getAllIdChannels();

    List<Channel> updateYouTubeSubcribe();
}
