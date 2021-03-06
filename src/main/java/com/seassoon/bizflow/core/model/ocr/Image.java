package com.seassoon.bizflow.core.model.ocr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author lw900925 (liuwei@seassoon.com)
 */
@Data
@EqualsAndHashCode
public class Image implements java.io.Serializable {
    private String imageId;
    private String imageUrl;
    private String documentName;
    private String documentLabel;
    private Integer documentSource;
    private String correctedImageUrl;
    private Corrected corrected;
    private Integer documentPage;
    private Integer totalPages;
    private Integer processMode;
    @JsonProperty("isWithTitle")
    private String isWithTitle;
    @JsonIgnore
    private String classifiedPath;  // 已分类图片本地保存路径

    @Data
    @EqualsAndHashCode
    public static class Corrected implements java.io.Serializable {
        private String url;             // 矫正后的图片URL
        private Double rotationAngle;   // 矫正后图片的旋转角度
        @JsonIgnore
        private String localPath;       // 矫正后图片本地存储路径
    }
}
