package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.config.ChannelContants;
import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import com.codewithproject.springsecurity.seeder.channels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class ChannelSeeder {

    @Autowired
    private ChannelRepository channelRepo;

    @Autowired
    private GirlChannelSeeder girlChannelSeeder;

    @Autowired
    private HololiveChannelSeeder hololiveChannelSeeder;

    @Autowired
    private MusicChannelSeeder musicChannelSeeder;

    @Autowired
    private GameChannelSeeder gameChannelSeeder;

    public List<Channel> seederChannels() {
        List<Channel> result = new ArrayList<>();
        try {
            Channel channelKD = new Channel();
            channelKD.setIdChannel(ChannelContants.CHANNEL_ID_KINGDOMNVHAI);
            channelKD.setNameChannelVI("KINGDOM NVHAI");
            channelKD.setUrlChannel("https://www.youtube.com/channel/" + ChannelContants.CHANNEL_ID_KINGDOMNVHAI + "?sub_confirmation=1");
            channelKD.setUrlVideoPresent("https://youtu.be/hxY99J_OMtg");
            channelKD.setDescriptionChannelVI("Là kênh Youtube duy nhất của trang web này. Được xây dựng và ra mắt vào 1/7/2015 khi NVHAI là sinh viên năm cuối, kênh Youtube chuyên dịch các Visual Novel sang phụ đề tiếng Việt. Trong tương lai, các video sẽ được dịch sonh song tiếng Anh và tiếng Việt để thu hút thêm nhiều khán giả trên thế giới. Ngoài dịch Visual Novel, KINGDOM NVHAI còn hướng dẫn Photoshop, Premiere Pro và lập trình.");
            channelKD.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2015-06-28"));
            channelKD.setSubscribe(3190);
            channelKD.setThumbnailChannel("kingdom-nvhai-channel-thumbnail.jpg");
            channelKD.setBannerChannel("kingdom-nvhai-banner.jpg");
            channelKD.setEnableChannel(true);
            channelRepo.save(channelKD);
            result.add(channelKD);

            Channel channelNiji = new Channel();
            channelNiji.setIdChannel(ChannelContants.CHANNEL_ID_NIJI_NO_CONQUISTADOR);
            channelNiji.setNameChannelVI("虹のコンキスタドール - Niji No Conquistador");
            channelNiji.setUrlChannel("https://www.youtube.com/channel/" + ChannelContants.CHANNEL_ID_NIJI_NO_CONQUISTADOR);
            channelNiji.setUrlVideoPresent("https://youtu.be/_uYTSn6Pyak");
            channelNiji.setDescriptionChannelVI("Nhóm Idol khá nổi tiếng của Nhật Bản được thành lập năm 2014. Các thành viên nổi tiếng nhất nhóm là Nemoto Nagi, Moe Tsurumi, Akari Nakamura, Karin Matoba, Ao Yamato. Đặc biệt, Nemoto Nagi là thành viên gánh team và đang hoạt động cho Dempagumi.inc.");
            channelNiji.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-29"));
            channelNiji.setSubscribe(115000);
            channelNiji.setThumbnailChannel("niji-no-conquistador-channel-thumbnail.jpg");
            channelNiji.setBannerChannel("niji-no-conquistador-banner.jpg");
            channelNiji.setEnableChannel(true);
            channelRepo.save(channelNiji);
            result.add(channelNiji);

            List<Channel> listGameChannel = gameChannelSeeder.gameSeederChannels();
            result.addAll(listGameChannel);

            List<Channel> listGirlChannel = girlChannelSeeder.girlSeederChannels();
            result.addAll(listGirlChannel);

            List<Channel> listHololiveChannel = hololiveChannelSeeder.hololiveSeederChannels();
            result.addAll(listHololiveChannel);

            List<Channel> listMusicChannel = musicChannelSeeder.musicChannelSeeder();
            result.addAll(listMusicChannel);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
