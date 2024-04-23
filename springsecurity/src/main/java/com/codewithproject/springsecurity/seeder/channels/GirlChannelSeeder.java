package com.codewithproject.springsecurity.seeder.channels;

import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class GirlChannelSeeder {

    @Autowired
    private ChannelRepository channelRepo;

    public List<Channel> girlSeederChannels() {
        List<Channel> result = new ArrayList<>();
        try {
            Channel channelMilkFilm = new Channel();
            channelMilkFilm.setIdChannel("UCSYR5sATT6NMUR3kFNxqbeQ");
            channelMilkFilm.setNameChannelVI("밀크필름 MilkFilm");
            channelMilkFilm.setUrlChannel("https://www.youtube.com/channel/UCSYR5sATT6NMUR3kFNxqbeQ");
            channelMilkFilm.setUrlVideoPresent("https://youtu.be/TACWGxygc5g?si=OCt1j4J7XaOrhmvf");
            channelMilkFilm.setDescriptionChannelVI("Đây là MilkFilm, nơi biến trí tưởng tượng và ảo tưởng thành video.\" Đó là đoạn giới thiệu ngắn gọn của kênh. Nội dung là những câu chuyện ngắn trong các bộ phim Nhật như harem, cosplay hầu gái... với các cô gái ngực tấn công, mông phòng thủ.");
            channelMilkFilm.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-06"));
            channelMilkFilm.setSubscribe(300000);
            channelMilkFilm.setThumbnailChannel("milkfilm-channel-thumbnail.jpg");
            channelMilkFilm.setBannerChannel("milkfilm-channel-banner.jpg");
            channelMilkFilm.setEnableChannel(true);
            channelRepo.save(channelMilkFilm);
            result.add(channelMilkFilm);

            Channel channelNagi = new Channel();
            channelNagi.setIdChannel("UCxDX9DXSqoRxxB-NO5Hz6XQ");
            channelNagi.setNameChannelVI("根本凪チャンネル");
            channelNagi.setUrlChannel("https://www.youtube.com/channel/UCxDX9DXSqoRxxB-NO5Hz6XQ");
            channelNagi.setUrlVideoPresent("https://youtu.be/Rx7XA7xVaEY?si=bb6fghiMBG3afBkr");
            channelNagi.setDescriptionChannelVI("Nemoto Nagi là ca sĩ, gravue idol đến từ Nhật Bản. Cô sinh ngày 15/3/1999. Số đo 3 vòng của cô là 90-57-85. Cô từng là thành viên nhóm nhạc Niji No Conquistador. Sau đó cô trở thành VTuber hoạt động tự do. Cô từng đóng một số bộ phim như live action Tomodachi Game. Đặc biệt, cô từng đến Việt Nam biểu diễn và có một lượng fan nhất định.");
            channelNagi.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-18"));
            channelNagi.setSubscribe(36000);
            channelNagi.setThumbnailChannel("nemoto-nagi-channel-thumbnail.jpg");
            channelNagi.setBannerChannel("nemoto-nagi-channel-banner.jpg");
            channelNagi.setEnableChannel(true);
            channelRepo.save(channelNagi);
            result.add(channelNagi);

            Channel channelInfiniHD = new Channel();
            channelInfiniHD.setIdChannel("UCUFNaNGi3lnBPq4gtdfJCAA");
            channelInfiniHD.setNameChannelVI("INFINI HD 4K");
            channelInfiniHD.setUrlChannel("https://www.youtube.com/channel/UCUFNaNGi3lnBPq4gtdfJCAA");
            channelInfiniHD.setUrlVideoPresent("https://www.youtube.com/watch?v=XpnpsKgaTKM&list=PL5N5Hv3klahFQ0NIEJSwvUGHdWoP7VbHe&index=12");
            channelInfiniHD.setDescriptionChannelVI("Kênh chuyên chiếu sự kiện dành cho người lớn tại Trung Quốc. KINGDOM NVHAI thích kênh này vì một video cosplay Yoshino và Kurumi trong Date a live.");
            channelInfiniHD.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2006-05-13"));
            channelInfiniHD.setSubscribe(12000000);
            channelInfiniHD.setThumbnailChannel("infini-hd-4k-channel-thumbnail.jpg");
            channelInfiniHD.setBannerChannel("infini-hd-4k-channel-banner.jpg");
            channelInfiniHD.setEnableChannel(true);
            channelRepo.save(channelInfiniHD);
            result.add(channelInfiniHD);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
