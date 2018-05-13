package com.mathxhspringboot.demo.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by MathxH on 2018/3/28.
 */
@Component
public class ProjectProperties {

    @Value("${com.mathxhspringboot.demo.title}")
    private String title;
    @Value("${com.mathxhspringboot.demo.content}")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
