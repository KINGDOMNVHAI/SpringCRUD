package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanCodeDetail;
import com.poscdx.odc.excan013.domain.entity.ExcanCodeDetail;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanCodeDetail")
@Table(name = "TB_EXCAN_CODE_DETAIL", schema = "EXCAN013")
public class ExcanCodeDetailJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CODE_MASTER")
    private String codeMaster;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
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

    public ExcanCodeDetailJpo() {
    }
    
    public ExcanCodeDetailJpo(ExcanCodeDetail entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanCodeDetail toDomain() {
        ExcanCodeDetail retVal = new ExcanCodeDetail();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanCodeDetail> toDomains(Iterable<ExcanCodeDetailJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanCodeDetailJpo::toDomain)).collect(Collectors.toList());
    }
}
