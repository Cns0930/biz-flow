package com.seassoon.bizflow.core.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.img.ImgUtil;
import com.seassoon.bizflow.core.model.ocr.Shape;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author lw900925 (liuwei@seassoon.com)
 */
public class ImgUtils extends ImgUtil {

    /**
     * 读取图片的宽高
     *
     * @param path 图片路径
     * @return {@link Shape}
     */
    public static Shape getShape(String path) {
        BufferedImage image = read(path);
        return Shape.of(image.getWidth(), image.getHeight());

    }

    /**
     * 计算一张图片的相对坐标
     *
     * @param shape {@link Shape}
     * @param ratio 计算系数
     * @return 计算后的坐标
     */
    public static List<List<Integer>> calcLocation(Shape shape, List<List<BigDecimal>> ratio) {
        // 读取图片的宽高
        if (CollectionUtil.isNotEmpty(ratio)) {
            Integer a = ratio.get(0).get(0).multiply(BigDecimal.valueOf(shape.getHeight())).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            Integer b = ratio.get(0).get(1).multiply(BigDecimal.valueOf(shape.getWidth())).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            Integer c = ratio.get(1).get(0).multiply(BigDecimal.valueOf(shape.getHeight())).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            Integer d = ratio.get(1).get(1).multiply(BigDecimal.valueOf(shape.getWidth())).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

            List<Integer> lt = Arrays.asList(a, b);
            List<Integer> rb = Arrays.asList(c, d);
            return Arrays.asList(lt, rb);
        } else {
            return Arrays.asList(Arrays.asList(1, 1), Arrays.asList(shape.getHeight() - 1, shape.getWidth() - 1));
        }
    }

}
