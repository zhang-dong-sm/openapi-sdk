package com.baas.openapi.todocenter.dto;

import lombok.Data;

/**
 * <p>
 *  待办事项dto(清雪项目专用)
 * </p>
 *
 * @author guyuegan
 * @since 2020/8/17
 */
@Data
public class TodoTaskDto4CleanSnow {

    /**
     * 单位名称
     */
    private String org;

    /**
     * 接收人
     */
    private String receiver;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 接收时间
     */
    private String receiveTime;

    /**
     * 反馈时间
     */
    private String feedbackTime;

    /**
     * 状态(0或1-未反馈，2-已完成)
     */
    private Integer status;
}
