package com.codewithproject.springsecurity.seeder.channels;

import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class MusicChannelSeeder {

    @Autowired
    private ChannelRepository channelRepo;

    public List<Channel> musicChannelSeeder() {
        List<Channel> result = new ArrayList<>();
        try {
            Channel channelWind = new Channel();
            channelWind.setIdChannel("UCUZNK80DemBN3kyxusDLwrA");
            channelWind.setNameChannelVI("The Soul of Wind");
            channelWind.setUrlChannel("https://www.youtube.com/channel/UCUZNK80DemBN3kyxusDLwrA");
            channelWind.setUrlVideoPresent("https://youtu.be/TJ1dEGTGBlk");
            channelWind.setDescriptionChannelVI("Kênh Youtube chuyên đăng các bản nhạc không lời cover từ các bài hát nổi tiếng như Kimi no nawa, Lion King... Video nhiều lượt xem nhất của kênh đạt 35 triệu views. Các bản nhạc nhẹ nhàng, sâu lắng, thích hợp cho những ai cần tập trung làm việc, học tập.");
            channelWind.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2014-11-09"));
            channelWind.setSubscribe(36000);
            channelWind.setThumbnailChannel("the-soul-of-wind-channel-thumbnail.jpg");
            channelWind.setBannerChannel("the-soul-of-wind-channel-banner.jpg");
            channelRepo.save(channelWind);
            result.add(channelWind);

            Channel channelSyrex = new Channel();
            channelSyrex.setIdChannel("UCeZje_7vr6CPK9vPQDfV3WA");
            channelSyrex.setNameChannelVI("Syrex");
            channelSyrex.setUrlChannel("https://www.youtube.com/channel/UCeZje_7vr6CPK9vPQDfV3WA");
            channelSyrex.setUrlVideoPresent("https://youtu.be/8N_aay0ddcY");
            channelSyrex.setDescriptionChannelVI("Trang nghe nhạc Nightcore. NVHAI ấn tượng với bài RISE và bài DARKSIDE.");
            channelSyrex.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-10"));
            channelSyrex.setSubscribe(1870000);
            channelSyrex.setThumbnailChannel("syrex-channel-thumbnail.jpg");
            channelSyrex.setBannerChannel("syrex-channel-banner.jpg");
            channelSyrex.setEnableChannel(true);
            channelRepo.save(channelSyrex);
            result.add(channelSyrex);

            Channel channelPanPiano = new Channel();
            channelPanPiano.setIdChannel("UCI7ktPB6toqucpkkCiolwLg");
            channelPanPiano.setNameChannelVI("Pan Piano");
            channelPanPiano.setUrlChannel("https://www.youtube.com/channel/UCI7ktPB6toqucpkkCiolwLg");
            channelPanPiano.setUrlVideoPresent("https://youtu.be/v7vYCB19KpM");
            channelPanPiano.setDescriptionChannelVI("Pan Piano là một nghệ sĩ piano. Cô thường cosplay những nhân vật anime khi đánh bản nhạc của bộ anime đó. Bộ ngực luôn là điểm nhấn trong tất cả bản nhạc của cô.");
            channelPanPiano.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2016-07-27"));
            channelPanPiano.setSubscribe(3550000);
            channelPanPiano.setThumbnailChannel("pan-piano-channel-thumbnail.jpg");
            channelPanPiano.setBannerChannel("pan-piano-channel-banner.jpg");
            channelPanPiano.setEnableChannel(true);
            channelRepo.save(channelPanPiano);
            result.add(channelPanPiano);

            Channel channelLunaxHolic = new Channel();
            channelLunaxHolic.setIdChannel("UCcerE0mibcYCgdkQPByO89w");
            channelLunaxHolic.setNameChannelVI("LunaxHolic公式チャンネル");
            channelLunaxHolic.setUrlChannel("https://www.youtube.com/channel/UCcerE0mibcYCgdkQPByO89w");
            channelLunaxHolic.setUrlVideoPresent("https://youtu.be/h4dF8g_8QgY");
            channelLunaxHolic.setDescriptionChannelVI("Nhóm Idol nhỏ của Nhật Bản được thành lập năm 2020 với số lượt đăng ký rất ít, chỉ có 418 subscribers. Đột nhiên, vào đầu năm 2022, nhóm này trở thành chủ đề tìm kiếm của nhiều người. Nguyên nhân là thành viên của nhóm, Yuki Miura đã bị sa thải do phát hiện đóng JAV.");
            channelLunaxHolic.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-18"));
            channelLunaxHolic.setSubscribe(418);
            channelLunaxHolic.setThumbnailChannel("lunaxholic-channel-thumbnail.jpg");
            channelLunaxHolic.setBannerChannel("lunaxholic-channel-banner.jpg");
            channelLunaxHolic.setEnableChannel(true);
            channelRepo.save(channelLunaxHolic);
            result.add(channelLunaxHolic);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
