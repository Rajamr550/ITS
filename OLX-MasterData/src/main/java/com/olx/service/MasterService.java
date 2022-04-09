package com.olx.service;

import java.util.List;
import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryEntity;

public interface MasterService {
    public List<Category> getAllCategory();

    public List<Status> getAllStatus();
}
