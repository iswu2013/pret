package com.pret.api.message;

import com.pret.api.vo.ResBody;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *
 * @author wujinsong
 */
@XmlRootElement(name = "ResBody")
public class ServiceVo extends ResBody {

    /**
     * 小扁网页id
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
