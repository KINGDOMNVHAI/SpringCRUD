package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.entitydto.VideoDto;
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
@Table(name = "videos")
public class Video {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) unable for string
    @Column(name = "id_video", nullable = false)
    private String idVideo;

    @Column(name = "name_video_vi", nullable = false)
    private String nameVideoVI;

    @Column(name = "name_video_en")
    private String nameVideoEN;

    @Column(name = "name_video_jp")
    private String nameVideoJP;

    @Column(name = "description_video_vi", columnDefinition = "text")
    private String descriptionVideoVI;

    @Column(name = "description_video_en", columnDefinition = "text")
    private String descriptionVideoEN;

    @Column(name = "description_video_jp", columnDefinition = "text")
    private String descriptionVideoJP;

    @Column(name = "created_date_video")
    private Date createdDateVideo;

    @Column(name = "views", columnDefinition = "integer default 0")
    private Integer views;

    @Column(name = "thumbnail_video")
    private String thumbnailVideo;

    @Column(name = "enable_video", columnDefinition = "boolean default false")
    private boolean enableVideo;

    @Column(name = "adult_video", columnDefinition = "boolean default false")
    private boolean adultVideo;

    @Column(name = "present_video", columnDefinition = "boolean default false")
    private boolean presentVideo;

    @Column(name = "id_channel")
    private String idChannel;

    public void convertToDto(VideoDto dto, String lang) {
        dto.setIdVideo(this.getIdVideo());
        dto.setCreatedDateVideo(DateUtil.toDateString(this.getCreatedDateVideo(), Constants.FORMAT_YYYY_MM_DD));
        dto.setViews(this.getViews());
        if (this.getViews() == null) {
            dto.setViews(0);
        }
        dto.setThumbnailVideo(this.getThumbnailVideo());
        dto.setIdChannel(this.idChannel);
        if (lang.equals(Constants.LANG_EN)) {
            dto.setNameVideoEN(this.getNameVideoEN());
            dto.setDescriptionVideoEN(this.getDescriptionVideoEN());
        } if (lang.equals(Constants.LANG_JP)) {
            dto.setNameVideoJP(this.getNameVideoJP());
            dto.setDescriptionVideoJP(this.getDescriptionVideoJP());
        } else {
            dto.setNameVideoVI(this.getNameVideoVI());
            dto.setDescriptionVideoVI(this.getDescriptionVideoVI());
        }
    }
}
