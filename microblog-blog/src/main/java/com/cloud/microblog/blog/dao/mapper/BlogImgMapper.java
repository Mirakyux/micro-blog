package com.cloud.microblog.blog.dao.mapper;

import com.cloud.microblog.blog.dao.model.BlogImg;
import java.util.List;

public interface BlogImgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_img
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long imgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_img
     *
     * @mbggenerated
     */
    int insert(BlogImg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_img
     *
     * @mbggenerated
     */
    BlogImg selectByPrimaryKey(Long imgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_img
     *
     * @mbggenerated
     */
    List<BlogImg> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_img
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BlogImg record);
}