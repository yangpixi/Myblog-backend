package com.yangpixi.blog.myblog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yangpixi
 * @date 2025/9/25 20:33
 * @description 文章返回数据包装类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    private String title;
    private String content;
    private List<subtitle> subtitles;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class subtitle {
        private int level;
        private String text;
        private String id;
    }
}
