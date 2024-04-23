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
public class HololiveChannelSeeder {

    @Autowired
    private ChannelRepository channelRepo;

    public List<Channel> hololiveSeederChannels() {
        List<Channel> result = new ArrayList<>();
        try {
            Channel channelTanigox = new Channel();
            channelTanigox.setIdChannel("UCu2DMOGLeR_DSStCyeQpi5Q");
            channelTanigox.setNameChannelVI("tanigox");
            channelTanigox.setUrlChannel("https://www.youtube.com/channel/UCu2DMOGLeR_DSStCyeQpi5Q");
            channelTanigox.setUrlVideoPresent("https://youtu.be/4h9opriUmu0");
            channelTanigox.setDescriptionChannelVI("YAGOO là CEO của Hololive. Tên thật là Motoaki Tanigo. Giấc mơ của ông là muốn xây dựng một nhóm idol giống AKB47 nhưng ở lĩnh vực streamer. Ông được biết đến với những lời trêu đùa từ các fan và chính các tài năng Hololive của mình khi giấc mơ của ông luôn bị vùi dập. Các idol của ông hành xử không giống idol, trừ Tokino Sora và AZKi.");
            channelTanigox.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2006-10-01"));
            channelTanigox.setSubscribe(2100000);
            channelTanigox.setThumbnailChannel("tanigox-channel-thumbnail.jpg");
            channelTanigox.setBannerChannel("tanigox-channel-banner.jpg");
            channelTanigox.setVtuber(true);
            channelTanigox.setHololive(true);
            channelTanigox.setEnableChannel(true);
            channelRepo.save(channelTanigox);
            result.add(channelTanigox);

            Channel channelHololive = new Channel();
            channelHololive.setIdChannel(ChannelContants.CHANNEL_ID_HOLOLIVE);
            channelHololive.setNameChannelVI("hololive ホロライブ - VTuber Group");
            channelHololive.setUrlChannel("https://www.youtube.com/channel/" + ChannelContants.CHANNEL_ID_HOLOLIVE);
            channelHololive.setUrlVideoPresent("https://youtu.be/RrsGNMMghKM");
            channelHololive.setDescriptionChannelVI("Hololive là công ty giải trí thành lập nên một nhóm gồm các Virtual Youtuber - gọi tắt là VTuber - nhằm cạnh tranh trên thị trường VTuber đang nổi lên khắp Nhật Bản.");
            channelHololive.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2016-03-03"));
            channelHololive.setSubscribe(1500000);
            channelHololive.setThumbnailChannel("hololive-channel-thumbnail.jpg");
            channelHololive.setBannerChannel("hololive-channel-banner.jpg");
            channelHololive.setVtuber(true);
            channelHololive.setHololive(true);
            channelHololive.setEnableChannel(true);
            channelRepo.save(channelHololive);
            result.add(channelHololive);

            Channel channelSora = new Channel();
            channelSora.setIdChannel("UCp6993wxpyDPHUpavwDFqgg");
            channelSora.setNameChannelVI("Tokino Sora - SoraCh. ときのそらチャンネル");
            channelSora.setUrlChannel("https://www.youtube.com/channel/UCp6993wxpyDPHUpavwDFqgg");
            channelSora.setUrlVideoPresent("https://www.youtube.com/watch?v=G9SWOk2J6aw");
            channelSora.setDescriptionChannelVI("Tokino Sora là Vtuber đầu tiên của Hololive. Cô là senpai đời đầu của Hololive mà các đàn em phải ngưỡng mộ và học hỏi. " +
                    "Dù bây giờ cô nhường phần lớn thời lượng cho đàn em nhưng mỗi lần cô xuất hiện đều tạo dấu ấn như một boss cuối của Hololive. " +
                    "Cô không bao giờ giật mình khi bị dọa ma. Cô cũng đảm nhận nhiều chương trình Collab với các khách mời. Sora như một đại sứ của Hololive với rất nhiều MV Collab với các Vtuber khác.");
            channelSora.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-07"));
            channelSora.setSubscribe(1200000);
            channelSora.setThumbnailChannel("sora-channel-thumbnail.jpg");
            channelSora.setBannerChannel("sora-channel-banner.jpg");
            channelSora.setTwitterChannel("https://twitter.com/tokino_sora");
            channelSora.setVtuber(true);
            channelSora.setHololive(true);
            channelSora.setEnableChannel(true);
            channelRepo.save(channelSora);
            result.add(channelSora);

            Channel channelAZKi = new Channel();
            channelAZKi.setIdChannel("UC0TXe_LYZ4scaW2XMyi5_kw");
            channelAZKi.setNameChannelVI("AZKi Channel");
            channelAZKi.setUrlChannel("https://www.youtube.com/channel/UC0TXe_LYZ4scaW2XMyi5_kw");
            channelAZKi.setUrlVideoPresent("https://www.youtube.com/watch?v=MYgM7IZdeqI");
            channelAZKi.setDescriptionChannelVI("AZKi là VTuber của Hololive. Cô là VTuber chủ yếu theo lĩnh vực âm nhạc nên lượt subcribe của cô rất khiêm tốn. Bù lại cô được đầu tư cả nhân vật 3D. 2 bài hát cùng Tokino Sora nổi tiếng là Dango Daikazoku và Blessing You. Cô và Sora trở thành cặp đôi SorAz, bức tường cuối cùng để bảo vệ giấc mơ Idol Group của YAGOO, CEO Hololive. Cô dần tập chơi một số game để thu hút thêm view.");
            channelAZKi.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-11"));
            channelAZKi.setSubscribe(930000);
            channelAZKi.setThumbnailChannel("azki-channel-thumbnail.jpg");
            channelAZKi.setBannerChannel("azki-channel-banner.jpg");
            channelSora.setTwitterChannel("https://twitter.com/AZKi_VDiVA/");
            channelAZKi.setVtuber(true);
            channelAZKi.setHololive(true);
            channelAZKi.setEnableChannel(true);
            channelRepo.save(channelAZKi);
            result.add(channelAZKi);

            Channel channelSuisei = new Channel();
            channelSuisei.setIdChannel("UC5CwaMl1eIgY8h02uZw7u8A");
            channelSuisei.setNameChannelVI("Suisei Channel");
            channelSuisei.setUrlChannel("https://www.youtube.com/channel/UC5CwaMl1eIgY8h02uZw7u8A");
            channelSuisei.setUrlVideoPresent("https://www.youtube.com/watch?v=medUm1AqRZ8");
            channelSuisei.setDescriptionChannelVI("Hoshimachi Suisei là VTuber của Hololive. Cô mang hình ảnh của một thần tượng và có khả năng chơi Tetris rất giỏi.");
            channelSuisei.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-18"));
            channelSuisei.setSubscribe(2100000);
            channelSuisei.setThumbnailChannel("suisei-channel-thumbnail.jpg");
            channelSuisei.setBannerChannel("suisei-channel-banner.jpg");
            channelSora.setTwitterChannel("https://twitter.com/suisei_hosimati");
            channelSuisei.setVtuber(true);
            channelSuisei.setHololive(true);
            channelSuisei.setEnableChannel(true);
            channelRepo.save(channelSuisei);
            result.add(channelSuisei);

            Channel channelMiko = new Channel();
            channelMiko.setIdChannel("UC-hM6YJuNYVAmUWxeIr9FeA");
            channelMiko.setNameChannelVI("Sakura Miko - Miko Ch. さくらみこ");
            channelMiko.setUrlChannel("https://www.youtube.com/channel/UC-hM6YJuNYVAmUWxeIr9FeA");
            channelMiko.setUrlVideoPresent("https://www.youtube.com/watch?v=7lFqJSIbEqw");
            channelMiko.setDescriptionChannelVI("Sakura Miko là Vtuber của Hololive. Cô có tạo hình là một Vu Nữ (Miko) và thường được gọi với cái tên Elite Miko - Vu Nữ Ưu Tú.");
            channelMiko.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-04-25"));
            channelMiko.setSubscribe(2000000);
            channelMiko.setThumbnailChannel("miko-channel-thumbnail.jpg");
            channelMiko.setBannerChannel("miko-channel-banner.jpg");
            channelMiko.setVtuber(true);
            channelMiko.setHololive(true);
            channelMiko.setEnableChannel(true);
            channelRepo.save(channelMiko);
            result.add(channelMiko);

            Channel channelRoboco = new Channel();
            channelRoboco.setIdChannel("UCDqI2jOz0weumE8s7paEk6g");
            channelRoboco.setNameChannelVI("Roboco Ch. - ロボ子");
            channelRoboco.setUrlChannel("https://www.youtube.com/channel/UCDqI2jOz0weumE8s7paEk6g");
            channelRoboco.setUrlVideoPresent("https://www.youtube.com/watch?v=ttpdreD_9Os");
            channelRoboco.setDescriptionChannelVI("Roboco là VTuber của Hololive. Cô là một trong số các VTuber đầu tiên của Hololive. Tuy nhiên, tốc độ tăng sub của cô không tốt lắm.");
            channelRoboco.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-08"));
            channelRoboco.setSubscribe(960000);
            channelRoboco.setThumbnailChannel("roboco-channel-thumbnail.jpg");
            channelRoboco.setBannerChannel("roboco-channel-banner.jpg");
            channelRoboco.setVtuber(true);
            channelRoboco.setHololive(true);
            channelRoboco.setEnableChannel(true);
            channelRepo.save(channelRoboco);
            result.add(channelRoboco);

            // ============== Gen 1 ==============
            Channel channelMatsuri = new Channel();
            channelMatsuri.setIdChannel("UCQ0UDLQCjY0rmuxCDE38FGg");
            channelMatsuri.setNameChannelVI("Natsurio Matsuri - Matsuri Channel 夏色まつり");
            channelMatsuri.setUrlChannel("https://www.youtube.com/channel/UCQ0UDLQCjY0rmuxCDE38FGg");
            channelMatsuri.setUrlVideoPresent("https://www.youtube.com/watch?v=DHMUymmD-eE");
            channelMatsuri.setDescriptionChannelVI("Natsurio Matsuri là Vtuber của Hololive. Cô là thế hệ thứ 1 của Hololive. Cô nổi tiếng với những câu chuyện nhạy cảm, chửi bới nhưng rất hài hước.");
            channelMatsuri.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-25"));
            channelMatsuri.setSubscribe(1420000);
            channelMatsuri.setThumbnailChannel("matsuri-channel-thumbnail.jpg");
            channelMatsuri.setBannerChannel("matsuri-channel-banner.jpg");
            channelMatsuri.setVtuber(true);
            channelMatsuri.setHololive(true);
            channelMatsuri.setEnableChannel(true);
            channelRepo.save(channelMatsuri);
            result.add(channelMatsuri);

            Channel channelAkiRose = new Channel();
            channelAkiRose.setIdChannel("UCFTLzh12_nrtzqBPsTCqenA");
            channelAkiRose.setNameChannelVI("アキロゼCh。Vtuber/ホロライブ所属");
            channelAkiRose.setUrlChannel("https://www.youtube.com/channel/UCFTLzh12_nrtzqBPsTCqenA");
            channelAkiRose.setUrlVideoPresent("https://www.youtube.com/watch?v=Ii7rtNaGlls");
            channelAkiRose.setDescriptionChannelVI("Aki Rosenthal là VTuber của Hololive. Cô là thế hệ thứ 1 của Hololive. Cô có tạo hình là một robot đến từ thế giới khác. Cô theo phong cách ecchi và có khả năng múa bụng. Bài múa Sha-Le-Ys mang phong cách Elf/Fantasy say đắm lòng người là bài hát biểu tượng nhất của cô.");
            channelAkiRose.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-25"));
            channelAkiRose.setSubscribe(850000);
            channelAkiRose.setThumbnailChannel("aki-channel-thumbnail.jpg");
            channelAkiRose.setBannerChannel("aki-channel-banner.jpg");
            channelAkiRose.setVtuber(true);
            channelAkiRose.setHololive(true);
            channelAkiRose.setEnableChannel(true);
            channelRepo.save(channelAkiRose);
            result.add(channelAkiRose);

            Channel channelMel = new Channel();
            channelMel.setIdChannel("UCD8HOxPs4Xvsm8H0ZxXGiBw");
            channelMel.setNameChannelVI("Yozora Mel - Mel Channel 夜空メルチャンネル");
            channelMel.setUrlChannel("https://www.youtube.com/channel/UCD8HOxPs4Xvsm8H0ZxXGiBw");
            channelMel.setUrlVideoPresent("https://www.youtube.com/watch?v=C0KQZUyfZ3Q");
            channelMel.setDescriptionChannelVI("Yozora Mel là VTuber của Hololive. Cô là thế hệ thứ 1 của Hololive. Mel-chan tạo hình là một vampire, nhưng cô đã có tên mới là BANpire. " +
"Quá trình làm việc tại Hololive thật sự rất sóng gió đối với cô. Một kẻ theo dõi cô đã gửi cô những thông tin đời tư cá nhân của cô. Cô hoảng sợ phải nhờ CEO Hololive là YAGOO can thiệp. " +
"Vụ việc khiến cô không live stream 2 tháng, bỏ lỡ buổi debut 3D của mình. Trong buổi stream ra mắt mình trở lại, cô bị Youtube cắt sóng 2 lần vì bộ đồ mặc định hở ngực và có nhắc đến patsu. " +
"Sau 5 năm 8 tháng làm việc cho Hololive, cô đã bị hủy hợp đồng vì lỗi tiết lộ thông tin cho bên thứ 3. Một kết thúc buồn cho hành trình sóng gió của Mel với Hololive.");
            channelMel.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-25"));
            channelMel.setSubscribe(900000);
            channelMel.setThumbnailChannel("mel-channel-thumbnail.jpg");
            channelMel.setBannerChannel("mel-channel-banner.jpg");
            channelMel.setLockUpdate(true);
            channelMel.setVtuber(true);
            channelMel.setHololive(true);
            channelMel.setEnableChannel(true);
            channelRepo.save(channelMel);
            result.add(channelMel);

            Channel channelFubuki = new Channel();
            channelFubuki.setIdChannel("UCdn5BQ06XqgXoAxIhbqw5Rg");
            channelFubuki.setNameChannelVI("フブキCh。白上フブキ");
            channelFubuki.setUrlChannel("https://www.youtube.com/channel/UCdn5BQ06XqgXoAxIhbqw5Rg");
            channelFubuki.setUrlVideoPresent("https://www.youtube.com/watch?v=UZnIHM2dQvA");
            channelFubuki.setDescriptionChannelVI("Shirakami Fubuki là VTuber của Hololive. Cô là thế hệ thứ 1 của Hololive. Cô có tạo hình là một con cáo trong dân gian Nhật Bản. Fubuki là VTuber thành công nhất của Hololive với lượng subcribe cao nhất. Trong hình dạng Shirigami, cô thường collab với các đàn em để kéo sub cho họ.");
            channelFubuki.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-25"));
            channelFubuki.setSubscribe(2300000);
            channelFubuki.setThumbnailChannel("fubuki-channel-thumbnail.jpg");
            channelFubuki.setBannerChannel("fubuki-channel-banner.jpg");
            channelFubuki.setVtuber(true);
            channelFubuki.setHololive(true);
            channelFubuki.setEnableChannel(true);
            channelRepo.save(channelFubuki);

            Channel channelHaachama = new Channel();
            channelHaachama.setIdChannel("UC1CfXB_kRs3C-zaeTG3oGyg");
            channelHaachama.setNameChannelVI("Akai Haato - Haato Channel 赤井はあと");
            channelHaachama.setUrlChannel("https://www.youtube.com/channel/UC1CfXB_kRs3C-zaeTG3oGyg");
            channelHaachama.setUrlVideoPresent("https://www.youtube.com/watch?v=zpjVX9v8e84");
            channelHaachama.setDescriptionChannelVI("Akai Haato là VTuber của Hololive. Cô là thế hệ thứ 1 của Hololive. Haato là Heart viết bằng Katakana. Akai Haato nghĩa là Trái Tim Màu Đỏ. " +
"Cô có một drama mùa COVID: kẹt lại Australia, không thể về Nhật cho đến hết năm 2020 hay hết dịch. Sau đó cô đã đăng nhiều video và nhận những bình luận hài nói rằng cô càng ngày càng mất trí khi mắc kẹt tại Australia. " +
"Từ đó, cô sinh ra một phiên bản mới: Haachama.");
            channelHaachama.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-24"));
            channelHaachama.setSubscribe(1500000);
            channelHaachama.setThumbnailChannel("haato-channel-thumbnail.jpg");
            channelHaachama.setBannerChannel("haato-channel-banner.jpg");
            channelHaachama.setVtuber(true);
            channelHaachama.setHololive(true);
            channelHaachama.setEnableChannel(true);
            channelRepo.save(channelHaachama);
            result.add(channelHaachama);

            // ============== Gen 2 ==============
            Channel channelAqua = new Channel();
            channelAqua.setIdChannel("UC1opHUrw8rvnsadT-iGp7Cg");
            channelAqua.setNameChannelVI("Minato Aqua - Aqua Ch. 湊あくあ");
            channelAqua.setUrlChannel("https://www.youtube.com/channel/UC1opHUrw8rvnsadT-iGp7Cg");
            channelAqua.setUrlVideoPresent("https://www.youtube.com/watch?v=-aB6MQU8l1s");
            channelAqua.setDescriptionChannelVI("Aqua là VTuber của Hololive. Cô là thế hệ thứ 2 của Hololive. Cô có tạo hình là một hầu gái với biểu tượng mỏ neo. Lần đầu KINGDOM NVHAI biết đến kênh này là từ bài nhạc nghe khá dễ thương バレンタインに (tạm dịch là Đến Ngày Valentine).");
            channelAqua.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-01"));
            channelAqua.setSubscribe(2000000);
            channelAqua.setThumbnailChannel("aqua-channel-thumbnail.jpg");
            channelAqua.setBannerChannel("aqua-channel-banner.jpg");
            channelAqua.setVtuber(true);
            channelAqua.setHololive(true);
            channelAqua.setEnableChannel(true);
            channelRepo.save(channelAqua);
            result.add(channelAqua);

            Channel channelChoco = new Channel();
            channelChoco.setIdChannel("UC1suqwovbL1kzsoaZgFZLKg");
            channelChoco.setNameChannelVI("Yuzuki Choco - Choco Ch. 癒月ちょこ");
            channelChoco.setUrlChannel("https://www.youtube.com/channel/UC1suqwovbL1kzsoaZgFZLKg");
            channelChoco.setUrlVideoPresent("https://www.youtube.com/watch?v=Rvgfa37Nseg");
            channelChoco.setDescriptionChannelVI("Yuzuki Choco là Vtuber của Hololive. Cô là thế hệ thứ 2 của Hololive. Cô được gọi là Choco-sensei với ngoại hình là Succubus ngực to đóng vai y tá trường học với loạt video ASRM đầy những âm thanh dâm dục. Hơi đáng tiếc là kênh của cô dù ra mắt từ lâu nhưng bị Youtube cảnh cáo các video ASRM của cô nên cô tăng sub chậm lại.");
            channelChoco.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-20"));
            channelChoco.setSubscribe(1020000);
            channelChoco.setThumbnailChannel("choco-channel-thumbnail.jpg");
            channelChoco.setBannerChannel("choco-channel-banner.jpg");
            channelChoco.setVtuber(true);
            channelChoco.setHololive(true);
            channelChoco.setEnableChannel(true);
            channelRepo.save(channelChoco);
            result.add(channelChoco);

            Channel channelSubaru = new Channel();
            channelSubaru.setIdChannel("UCvzGlP9oQwU--Y0r9id_jnA");
            channelSubaru.setNameChannelVI("Oozora Subaru - Subaru Ch. 大空スバル");
            channelSubaru.setUrlChannel("https://www.youtube.com/channel/UCvzGlP9oQwU--Y0r9id_jnA");
            channelSubaru.setUrlVideoPresent("https://www.youtube.com/watch?v=QjHlXKEF6A4");
            channelSubaru.setDescriptionChannelVI("Oozora Subaru là VTuber của Hololive. Cô là thế hệ thứ 2 của Hololive. Cô là một tomboy, kể mình đã vào Hololive sau khi nhà của cô bị cháy. Cô nổi tiếng từ video nói rằng sẽ làm một buổi stream ASMR (buổi stream âm thanh nói qua micro 2 tai). Kết quả là cô bị gán danh hiệu Donald Duck vì giọng tomboy vịt đực của mình.");
            channelSubaru.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-22"));
            channelSubaru.setSubscribe(1570000);
            channelSubaru.setThumbnailChannel("subaru-channel-thumbnail.jpg");
            channelSubaru.setBannerChannel("subaru-channel-banner.jpg");
            channelSubaru.setVtuber(true);
            channelSubaru.setHololive(true);
            channelSubaru.setEnableChannel(true);
            channelRepo.save(channelSubaru);
            result.add(channelSubaru);

            Channel channelShion = new Channel();
            channelShion.setIdChannel("UCXTpFs_3PqI41qX2d9tL2Rw");
            channelShion.setNameChannelVI("Murasaki Shion - Shion Ch. 紫咲シオン");
            channelShion.setUrlChannel("https://www.youtube.com/channel/UCXTpFs_3PqI41qX2d9tL2Rw");
            channelShion.setUrlVideoPresent("https://www.youtube.com/watch?v=ISORcbhkfxM");
            channelShion.setDescriptionChannelVI("Murasaki Shion là VTuber của Hololive. Cô là thế hệ thứ 2 của Hololive. Cô có tạo hình là một phù thủy. Cô thường xuyên xuất hiện trong các phim ngắn với phép thuật hay gây rắc rối của mình. Nội dung của cô xoay quanh chủ đề NTR.");
            channelShion.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-03"));
            channelShion.setSubscribe(1120000);
            channelShion.setThumbnailChannel("shion-channel-thumbnail.jpg");
            channelShion.setBannerChannel("shion-channel-banner.jpg");
            channelShion.setVtuber(true);
            channelShion.setHololive(true);
            channelShion.setEnableChannel(true);
            channelRepo.save(channelShion);
            result.add(channelShion);

            Channel channelAyame = new Channel();
            channelAyame.setIdChannel("UC7fk0CB07ly8oSl0aqKkqFg");
            channelAyame.setNameChannelVI("Nakiri Ayame Ch. 百鬼あやめ");
            channelAyame.setUrlChannel("https://www.youtube.com/channel/UC7fk0CB07ly8oSl0aqKkqFg");
            channelAyame.setUrlVideoPresent("https://www.youtube.com/watch?v=vm41hDf1sx4&t=0s");
            channelAyame.setDescriptionChannelVI("Nakiri Ayame là VTuber của Hololive. Cô là thế hệ thứ 2 của Hololive. Cô có tạo hình là một con quỷ Oni. Cô nổi tiếng với bài hát Docchi Docchi tự chế, luôn cười trong buổi stream và có khả năng bắn súng đỉnh cao trong các tựa game FPS.");
            channelAyame.setCreatedDateChannel(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-12"));
            channelAyame.setSubscribe(1500000);
            channelAyame.setThumbnailChannel("ayame-channel-thumbnail.jpg");
            channelAyame.setBannerChannel("ayame-channel-banner.jpg");
            channelAyame.setVtuber(true);
            channelAyame.setHololive(true);
            channelAyame.setEnableChannel(true);
            channelRepo.save(channelAyame);
            result.add(channelAyame);

            // ============== Gen 3 ==============

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
