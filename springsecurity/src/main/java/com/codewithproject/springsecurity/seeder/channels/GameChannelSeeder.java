package com.codewithproject.springsecurity.seeder.channels;

import com.codewithproject.springsecurity.config.ChannelContants;
import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameChannelSeeder {

    @Autowired
    private ChannelRepository channelRepo;

    public List<Channel> gameSeederChannels() {
        List<Channel> result = new ArrayList<>();
        try {
            Channel channelEpicSkillshot = new Channel();
            channelEpicSkillshot.setIdChannel("UCdOWyp25T0HDtjpnV2LpIyw");
            channelEpicSkillshot.setNameChannelVI("EpicSkillshot - LoL VOD Library");
            channelEpicSkillshot.setUrlChannel("https://www.youtube.com/channel/UCdOWyp25T0HDtjpnV2LpIyw");
            channelEpicSkillshot.setUrlVideoPresent("https://youtu.be/cHR9kPCKrc4");
            channelEpicSkillshot.setDescriptionChannelVI("Đây là trang tổng hợp tất cả trận đấu LMHT của các giải đấu lớn như LCK, LPL, LMS, LCS...");
            channelEpicSkillshot.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2013-05-19"));
            channelEpicSkillshot.setSubscribe(600000);
            channelEpicSkillshot.setThumbnailChannel("epicskillshot-channel-thumbnail.jpg");
            channelEpicSkillshot.setBannerChannel("epicskillshot-channel-thumbnail.jpg");
            channelEpicSkillshot.setEnableChannel(true);
            channelRepo.save(channelEpicSkillshot);
            result.add(channelEpicSkillshot);

            Channel channelPlayOverwatch = new Channel();
            channelPlayOverwatch.setIdChannel(ChannelContants.CHANNEL_ID_PLAYOVERWATCH);
            channelPlayOverwatch.setNameChannelVI("PlayOverwatch");
            channelPlayOverwatch.setUrlChannel("https://www.youtube.com/channel/" + ChannelContants.CHANNEL_ID_PLAYOVERWATCH);
            channelPlayOverwatch.setUrlVideoPresent("https://youtu.be/GKXS_YA9s7E");
            channelPlayOverwatch.setDescriptionChannelVI("Kênh chính thức của trò chơi Overwatch");
            channelPlayOverwatch.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-27"));
            channelPlayOverwatch.setSubscribe(2950000);
            channelPlayOverwatch.setThumbnailChannel("play-overwatch-channel-thumbnail.jpg");
            channelPlayOverwatch.setBannerChannel("play-overwatch-channel-thumbnail.jpg");
            channelPlayOverwatch.setEnableChannel(true);
            channelRepo.save(channelPlayOverwatch);
            result.add(channelPlayOverwatch);

            Channel channelVexsper = new Channel();
            channelVexsper.setIdChannel("UCRM9eq-dXhdIwZTyNmtAIug");
            channelVexsper.setNameChannelVI("Vexsper");
            channelVexsper.setUrlChannel("https://www.youtube.com/channel/UCRM9eq-dXhdIwZTyNmtAIug");
            channelVexsper.setUrlVideoPresent("https://www.youtube.com/watch?v=NZx74-JpUas");
            channelVexsper.setDescriptionChannelVI("Kênh YouTube edit những pha highlight và funny moment của tựa game Valorant.");
            channelVexsper.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2014-09-27"));
            channelVexsper.setSubscribe(170000);
            channelVexsper.setThumbnailChannel("vexsper-channel-thumbnail.jpg");
            channelVexsper.setBannerChannel("vexsper-channel-thumbnail.jpg");
            channelVexsper.setEnableChannel(true);
            channelRepo.save(channelVexsper);
            result.add(channelVexsper);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
