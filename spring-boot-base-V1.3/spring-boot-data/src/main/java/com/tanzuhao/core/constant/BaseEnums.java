package com.tanzuhao.core.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础枚举值
 * @author tanzuhao
 * @date: 2019年9月9日 下午5:24:58
 */
public enum BaseEnums implements BaseEnum<String, String> {

    SUCCESS("1000", "请求成功"),

    FAILURE("0000", "请求失败"),

    OPERATION_SUCCESS("1100", "操作成功"),

    OPERATION_FAILURE("0001", "操作失败"),

    ERROR("0002", "系统异常"),

    NOT_FOUND("0003", "请求资源不存在"),

    FORBIDDEN("0004", "无权限访问"),

    VERSION_NOT_MATCH("0005", "记录版本不存在或不匹配"),

    PARAMETER_NOT_NULL("0006", "参数不能为空");

    private String code;

    private String desc;

    private static Map<String, String> allMap = new HashMap<>();

    BaseEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static {
        for(BaseEnums enums : BaseEnums.values()){
            allMap.put(enums.code, enums.desc);
        }
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String desc() {
        return desc;
    }

    public String desc(String code) {
        return allMap.get(code);
    }

}