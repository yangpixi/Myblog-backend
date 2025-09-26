package com.yangpixi.blog.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangpixi
 * @date 2025/9/25 20:13
 * @description 前端发送创建文章请求包装类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {
    private String title;
    private String content;
}
