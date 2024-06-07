package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanCategory;
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
@Entity(name = "ExcanCategory")
@Table(name = "TB_EXCAN_CATEGORY", schema = "EXCAN013")
public class ExcanCategoryJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String name;
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

    public ExcanCategoryJpo() {
    }

    public ExcanCategoryJpo(ExcanCategory entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanCategory toDomain() {
        ExcanCategory retVal = new ExcanCategory();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanCategory> toDomains(Iterable<ExcanCategoryJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanCategoryJpo::toDomain)).collect(Collectors.toList());
    }

//    @Override
//    public void validateJpo()
//        throws PosBaseException
//    {
//    }
}
