package com.xuzhi.model;

import java.util.List;

public class GirlBlog extends Girl {
    private List<Blog> blog;

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return  "Girl{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", flower='" + getFlower() + '\'' +
                ", birthday=" + getBirthday() +
                '}'+
                "GirlBlog{" +
                "blog=" + blog +
                '}';
    }
}
