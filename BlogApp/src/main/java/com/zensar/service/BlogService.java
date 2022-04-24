package com.zensar.service;

import com.zensar.dto.BlogDto;

public interface BlogService {

    public BlogDto createNewBlog(BlogDto blogDto);

    public BlogDto readBlogById(int id);

    public BlogDto updateBlogById(int id, BlogDto blogDto);

    public boolean deleteById(int id);

}
