package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.ChannelDto;
import com.codewithproject.springsecurity.util.DateUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "channels")
public class Channel {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) unable for string
    @Column(name = "id_channel", nullable = false)
    private String idChannel;

    @Column(name = "name_channel_vi")
    private String nameChannelVI;

    @Column(name = "name_channel_en")
    private String nameChannelEN;

    @Column(name = "name_channel_jp")
    private String nameChannelJP;

    @Column(name = "url_channel")
    private String urlChannel;

    @Column(name = "url_video_present")
    private String urlVideoPresent;

    @Column(name = "description_channel_vi", columnDefinition = "TEXT")
    private String descriptionChannelVI;

    @Column(name = "description_channel_en", columnDefinition = "TEXT")
    private String descriptionChannelEN;

    @Column(name = "description_channel_jp", columnDefinition = "TEXT")
    private String descriptionChannelJP;

    @Column(name = "created_date_channel")
    private Date createdDateChannel;

    @Column(name = "subscribe")
    private Integer subscribe;

    @Column(name = "thumbnail_channel")
    private String thumbnailChannel;

    @Column(name = "banner_channel")
    private String bannerChannel;

    @Column(name = "website_channel")
    private String websiteChannel;

    @Column(name = "facebook_channel")
    private String facebookChannel;

    @Column(name = "twitter_channel")
    private String twitterChannel;

    @Column(name = "enable_channel")
    private boolean enableChannel;

    @Column(name = "lock_update")
    private boolean lockUpdate; // lock update

    @Column(name = "vtuber")
    private boolean vtuber;

    @Column(name = "hololive")
    private boolean hololive;

    public void convertToDto(ChannelDto dto, String lang) {
        dto.setIdChannel(this.idChannel);
        dto.setUrlChannel(this.getUrlChannel());
        dto.setUrlVideoPresent(this.getUrlVideoPresent());
        dto.setSubscribe(this.getSubscribe());
        dto.setCreatedDateChannel(DateUtil.toDateString(this.getCreatedDateChannel(), Constants.FORMAT_YYYY_MM_DD));
        dto.setThumbnailChannel(this.getThumbnailChannel());
        dto.setBannerChannel(this.getBannerChannel());
        dto.setLockUpdate(this.lockUpdate);
        dto.setWebsiteChannel(this.getWebsiteChannel());
        dto.setFacebookChannel(this.getFacebookChannel());
        dto.setTwitterChannel(this.getTwitterChannel());
        if (lang.equals(Constants.LANG_EN)) {
            dto.setNameChannel(this.getNameChannelEN());
            dto.setDescriptionChannel(this.getDescriptionChannelEN());
        } if (lang.equals(Constants.LANG_JP)) {
            dto.setNameChannel(this.getNameChannelJP());
            dto.setDescriptionChannel(this.getDescriptionChannelJP());
        } else {
            dto.setNameChannel(this.getNameChannelVI());
            dto.setDescriptionChannel(this.getDescriptionChannelVI());
        }
    }
}
