package com.codewithproject.springsecurity.entities;

import com.codewithproject.springsecurity.config.Constants;
import com.codewithproject.springsecurity.dto.CommunityDto;
import com.codewithproject.springsecurity.util.DateUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_com", nullable = false)
    private Long idCom;

    @Column(name = "title_com", nullable = false)
    private String titleCom;

    @Column(name = "description_com")
    private String descriptionCom;

    @Column(name = "created_date_com")
    private Date createdDateCom;

    @Column(name = "id_channel", nullable = false)
    private String idChannel;

    public void convertToDto(CommunityDto dto, String lang) {
        dto.setIdCom(this.idCom);
        dto.setTitleCom(this.titleCom);
        dto.setDescriptionCom(this.descriptionCom);
        dto.setCreatedDateCom(DateUtil.toDateString(this.createdDateCom, Constants.FORMAT_YYYY_MM_DD));
        dto.setIdChannel(this.idChannel);
    }
}
