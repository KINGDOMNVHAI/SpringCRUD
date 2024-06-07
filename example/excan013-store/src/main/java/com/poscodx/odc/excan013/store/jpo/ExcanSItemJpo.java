package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanSItem;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanSItem")
@Table(name = "TB_EXCAN_SETTING_ITEM", schema = "EXCAN013")
public class ExcanSItemJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "SETTING_ID")
    private int settingId;
    @Column(name = "CATEGORY_ID")
    private int categoryId;
    @Column(name = "NUMBER_OF_QUESTION")
    private int numberOfQuestion;
    @Column(name = "LEVEL")
    private int level;
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

    public ExcanSItemJpo() {
    }

    public ExcanSItemJpo(ExcanSItem entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanSItem toDomain() {
        ExcanSItem retVal = new ExcanSItem();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanSItem> toDomains(Iterable<ExcanSItemJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanSItemJpo::toDomain)).collect(Collectors.toList());
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
