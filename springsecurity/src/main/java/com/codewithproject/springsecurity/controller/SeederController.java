package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.entities.CategoryTest;
import com.codewithproject.springsecurity.entities.Channel;
import com.codewithproject.springsecurity.entities.Language;
import com.codewithproject.springsecurity.entities.Question;
import com.codewithproject.springsecurity.entities.Test;
import com.codewithproject.springsecurity.entities.User;
import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.services.impl.CategoryTestServiceImpl;
import com.codewithproject.springsecurity.services.impl.ChannelServiceImpl;
import com.codewithproject.springsecurity.services.impl.LanguageServiceImpl;
import com.codewithproject.springsecurity.services.impl.QuestionServiceImpl;
import com.codewithproject.springsecurity.services.impl.TestServiceImpl;
import com.codewithproject.springsecurity.services.impl.UserServiceImpl;
import com.codewithproject.springsecurity.services.impl.VideoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/seeder")
@RequiredArgsConstructor
public class SeederController {

    @Autowired
    private CategoryTestServiceImpl categorytestServiceImpl;

    @Autowired
    private ChannelServiceImpl channelServiceImpl;

    @Autowired
    private LanguageServiceImpl languageServiceImpl;

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    @Autowired
    private TestServiceImpl testServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/category-test")
    public List<CategoryTest> migrateCategoryTest() {
        return categorytestServiceImpl.seederCategoryTest();
    }

    @GetMapping("/channels")
    public List<Channel> migrateChannel() {
        return channelServiceImpl.seederChannels();
    }

    @GetMapping("/languages")
    public List<Language> migrateLanguage(){
        return languageServiceImpl.seederLanguages();
    }

    @GetMapping("/questions")
    public List<Question> migrateQuestion() {
        return questionServiceImpl.seederQuestions();
    }

    @GetMapping("/tests")
    public List<Test> migrateTest() {
        return testServiceImpl.seederTests();
    }

    @GetMapping("/user")
    public List<User> migrateUser() {
        return userServiceImpl.seederUser();
    }

    @GetMapping("/videos")
    public List<Video> migrateVideo(){
        return videoServiceImpl.seederVideos();
    }

    @GetMapping("/update-channel-subcribe")
    @Scheduled(cron = "* * 1 * * *", zone = "Asia/Ho_Chi_Minh") // Execute every 1 hour
    public String updateChannelSubcribe() {
        List<Channel> listChannel = channelServiceImpl.updateYouTubeSubcribe();
        return !listChannel.isEmpty() ? "Updated" : "Failed";
    }

//    @GetMapping("/welcome-client")
//    public String greetMessage() {
//        HttpEntity <Void> httpEntity = new HttpEntity<>();
//        return restTemplate.getForObject("https://youtube.googleapis.com/youtube/v3/channels?part=snippet%2CcontentDetails%2Cstatistics&id=UCD8HOxPs4Xvsm8H0ZxXGiBw&key=AIzaSyBYvogrKc3YK4xsXB0NCh6g7X-fnw2JJ4I", String.class);
//    }
}
