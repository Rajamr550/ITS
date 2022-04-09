package com.olx.service;

import java.time.LocalDate;
import java.util.List;

import com.olx.dto.Adv;

public interface AdvService {
    public Adv postAdvertise(Adv adv);

    public Adv updateAdvertise(Adv adv);

    public List<Adv> getAllAdvByUser();

    public List<Adv> getAdvByUser();

    public Adv SearchAdvByText(String searchText);

    public Adv returnAdv(int id);

    public List<Adv> searchAdvertisesByFilterCriteria(String searchText, int categoryId, String postedBy,
	    String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
	    int startIndex, int records);
}
