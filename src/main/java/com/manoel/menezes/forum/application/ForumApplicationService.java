package com.manoel.menezes.forum.application;

import com.manoel.menezes.forum.query.model.ForumFinder;
import com.manoel.menezes.forum.query.model.ForumQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumApplicationService {

    private final ForumFinder finder;

    @Autowired
    public ForumApplicationService(final ForumFinder finder) {
        this.finder = finder;
    }

    public List<ForumQueryModel> findAll() {
        return finder.findAll();
    }

}
