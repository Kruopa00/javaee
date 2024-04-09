package org.example.lab01.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab01.mybatis.dao.GrupeMapper;
import org.example.lab01.mybatis.model.Grupe;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class GrupesMyBatis {
    @Inject
    private GrupeMapper grupeMapper;

    @Getter
    private List<Grupe> allGrupes;

    @Getter @Setter
    private Grupe grupeToCreate = new Grupe();

    @PostConstruct
    public void init() {
        this.allGrupes = grupeMapper.selectAll();
    }

    @Transactional
    public String createGrupe() {
        grupeMapper.insert(grupeToCreate);
        return "/myBatis/grupes?faces-redirect=true";
    }

}
