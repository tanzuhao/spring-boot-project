package com.tanzuhao.core.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tanzuhao.core.constant.Constants;
import com.tanzuhao.core.util.Dates;

/**
 * 基础实体类
 * @author tanzuhao
 *
 */
public class BaseDTO implements Serializable {
	private static final long serialVersionUID = 2656246364245010229L;
	public static final String FIELD_OPERATE = "operate";
    public static final String FIELD_OBJECT_VERSION_NUMBER = "versionNumber";
    public static final String FIELD_CREATOR = "creator";
    public static final String FIELD_CREATE_DATE = "createDate";
    public static final String FIELD_UPDATER = "updater";
    public static final String FIELD_UPDATE_DATE = "updateDate";

    /**
     * 操作类型，add/update/delete 参考：{@link Constants.Operation}
     */
    @Transient
    private String _operate;

    /**
     * 数据版本号,每发生update则自增,用于实现乐观锁.
     */
    private Long versionNumber;
    // 下面是标准 WHO 字段
    // ----------------------------------------------------------------------------------------------------
    /**
     * 创建人名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String creator;
    /**
     * 创建时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = Dates.DEFAULT_PATTERN)
    private Date createDate;
    /**
     * 更新人名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String updater;
    /**
     * 更新时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = Dates.DEFAULT_PATTERN)
    private Date updateDate;

    /**
     * 其它属性
     */
    @JsonIgnore
    @Transient
    protected Map<String, Object> innerMap = new HashMap<>();
    
    public String get_operate() {
        return _operate;
    }

    public void set_operate(String _operate) {
        this._operate = _operate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public String toJSONString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @JsonAnyGetter
    public Object getAttribute(String key) {
        return innerMap.get(key);
    }

    @JsonAnySetter
    public void setAttribute(String key, Object obj) {
        innerMap.put(key, obj);
    }
}