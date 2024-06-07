package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanSetting;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanSetting")
@Table(name = "TB_EXCAN_SETTING", schema = "EXCAN013")
public class ExcanSettingJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DURATION")
    private int duration;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NUMBER_OF_QUESTION")
    private int numberOfQuestion;
    @Column(name = "STATUS")
    private int status;
    @Column(name = "CREATE_AT")
    private Date createAt;
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "UPDATE_AT")
    private Date updateAt;
    @Column(name = "UPDATE_BY")
    private String updateBy;
    @Column(name = "DELETE_AT")
    private Date deleteAt;

    public ExcanSettingJpo() {
    }

    public ExcanSettingJpo(ExcanSetting entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanSetting toDomain() {
        ExcanSetting retVal = new ExcanSetting();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanSetting> toDomains(Iterable<ExcanSettingJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanSettingJpo::toDomain)).collect(Collectors.toList());
    }

    @PrePersist
    public void beforeCreate() {
        createAt = new Date();
    }

    @PreUpdate
    public void beforeUpdate() {
        updateAt = new Date();
    }
}
