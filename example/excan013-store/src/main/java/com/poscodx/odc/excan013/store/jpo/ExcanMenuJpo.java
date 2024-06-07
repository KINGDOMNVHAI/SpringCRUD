package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanMenu;
import com.poscdx.odc.excan013.domain.entity.ExcanMenu;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanMenu")
@Table(name = "TB_EXCAN_MENU", schema = "EXCAN013")
public class ExcanMenuJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "MENU_CODE")
    private String menuCode;
    @Column(name = "MENU_NAME")
    private String menuName;
    @Column(name = "TOP_MENU")
    private int topMenu;
    @Column(name = "URL")
    private String url;
    @Column(name = "PERMISSION_GROUP")
    private int permissionGroup;
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "CREATE_AT")
    private Date createAt;
    @Column(name = "STATUS")
    private int status;
    public ExcanMenuJpo() {
    }

    public ExcanMenuJpo(ExcanMenu entity) {

        BeanUtils.copyProperties(entity, this);
    }

    public ExcanMenu toDomain() {
        ExcanMenu retVal = new ExcanMenu();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanMenu> toDomains(Iterable<ExcanMenuJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanMenuJpo::toDomain)).collect(Collectors.toList());
    }
}
