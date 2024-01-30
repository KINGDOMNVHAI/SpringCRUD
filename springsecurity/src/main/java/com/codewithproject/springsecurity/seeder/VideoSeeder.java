package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.config.ChannelContants;
import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class VideoSeeder {

    @Autowired
    public VideoRepository videoRepo;

    public List<Video> seederVideos() {
        Random r = new Random();
        List<Video> result = new ArrayList<>();
        try {
            Video video1 = new Video();
            video1.setIdVideo("NV3v5_jPAOo");
            video1.setNameVideoVI("Hana no No ni Saku Utakata no Vietsub 1-4 dọn nhà");
            video1.setDescriptionVideoVI("Hana no No ni Saku Utakata no Vietsub 1-4 dọn nhà\n" +
"Những bài ca nở trên cánh đồng hoa 花の野に咲くうたかたの\n" +
"\n" +
"Michitaka Shindou chuyển nhà đến trang viên Ouka, nơi ông cậu từng sống. Trang viên này cũng bị đồn là ngôi nhà ma ám. Hàng xóm của cậu là 2 chị em nhà Fujimiya."
);
            video1.setCreatedDateVideo(new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01"));
            video1.setViews(r.nextInt(100) + 1);;
            video1.setEnableVideo(true);;
            video1.setAdultVideo(false);
            video1.setIdChannel(ChannelContants.CHANNEL_ID_KINGDOMNVHAI);
            videoRepo.save(video1);
            result.add(video1);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
