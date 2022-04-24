package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.BlogDto;
import com.zensar.entity.BlogDocument;
import com.zensar.exception.InvalidIdException;
import com.zensar.repo.BlogRepo;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BlogRepo blogRepo;

    @Override
    public BlogDto createNewBlog(BlogDto blogDto) {
	// TODO Auto-generated method stub
	blogRepo.save(convertDtoIntoDocument(blogDto));

	return blogDto;
    }

    @Override
    public BlogDto readBlogById(int id) {
	Optional<BlogDocument> blogDocument = blogRepo.findById(id);
	if (blogDocument == null) {
	    throw new InvalidIdException("wring id");
	}
	return convertDocumentIntoDto2(blogDocument);
    }

    private BlogDto convertDocumentIntoDto2(Optional<BlogDocument> blog) {
	BlogDto blogDtoEntity = modelMapper.map(blog, BlogDto.class);
	return blogDtoEntity;
    }

    @Override
    public BlogDto updateBlogById(int id, BlogDto blogDto) {
	Optional<BlogDocument> opblogdoc = blogRepo.findById(id);

	if (opblogdoc.isPresent()) {
	    BlogDocument bg = opblogdoc.get();
	    bg.setContent(blogDto.getContent());
	    bg.setTitle(blogDto.getTitle());
	    blogRepo.save(bg);
	}

	return blogDto;

    }

    @Override
    public boolean deleteById(int id) {

	if (blogRepo.existsById(id)) {
	    blogRepo.deleteById(id);
	    return true;
	}

	throw new InvalidIdException();
    }

    private BlogDocument convertDtoIntoDocument(BlogDto blogDto) {

	BlogDocument blogDtoEntity = modelMapper.map(blogDto, BlogDocument.class);
	return blogDtoEntity;
    }

    private BlogDto convertDocumentIntoDto(BlogDocument blog) {

	BlogDto blogDtoEntity = modelMapper.map(blog, BlogDto.class);
	return blogDtoEntity;
    }

}
