package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.dto.entitydto.ImageDto;
import com.codewithproject.springsecurity.dto.entitydto.LineProgressDto;
import com.codewithproject.springsecurity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_bb_image")
@IdClass(ImageId.class)
public class Image {
    @Id
    @Column(name = "obj_id", nullable = false)
    private String objId;
    @Id
    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "table_name")
    private String tableName;
    
    public ImageDto toDto(){
        ImageDto dto = new ImageDto();
        dto.setUrl(this.getUrl());
        dto.setObjId(this.getObjId());
        return dto;
    }
}

class ImageId implements Serializable {
    private String objId;
    private String url;
}