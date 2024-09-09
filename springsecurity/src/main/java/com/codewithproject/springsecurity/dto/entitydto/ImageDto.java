package com.codewithproject.springsecurity.dto.entitydto;

import com.codewithproject.springsecurity.entities.Image;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    private String objId;

    private String url;

    private String tableName;

    public Image toEntity(){
        Image entity = new Image();
        entity.setUrl(this.getUrl());
        entity.setObjId(this.getObjId());
        entity.setTableName(this.getTableName());
        return entity;
    }
}
