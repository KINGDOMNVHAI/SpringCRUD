package com.codewithproject.springsecurity.dto.entitydto;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.entities.Video;
import com.codewithproject.springsecurity.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDto {

    private String idVideo;

    private String nameVideoVI;

    private String nameVideoEN;

    private String nameVideoJP;

    private String urlVideo;

    private String descriptionVideoVI;

    private String descriptionVideoEN;

    private String descriptionVideoJP;

    private String createdDateVideo;

    private Integer views;

    private String thumbnailVideo;

    private boolean enableVideo;

    private String idChannel;

    private String nameChannel;

    public Video convertToEntity(String lang) {
        Video entity = new Video();
        entity.setIdVideo(this.getIdVideo());
        entity.setCreatedDateVideo(DateUtil.toDate(this.getCreatedDateVideo()));
        entity.setViews(this.getViews());
        if (this.getViews() == null) {
            entity.setViews(0);
        }
        entity.setThumbnailVideo(this.getThumbnailVideo());
        entity.setIdChannel(this.idChannel);
        if (lang.equals(Constants.LANG_EN)) {
            entity.setNameVideoEN(this.getNameVideoEN());
            entity.setDescriptionVideoEN(this.getDescriptionVideoEN());
        } if (lang.equals(Constants.LANG_JP)) {
            entity.setNameVideoJP(this.getNameVideoJP());
            entity.setDescriptionVideoJP(this.getDescriptionVideoJP());
        } else {
            entity.setNameVideoVI(this.getNameVideoVI());
            entity.setDescriptionVideoVI(this.getDescriptionVideoVI());
        }
        return entity;
    }
}
