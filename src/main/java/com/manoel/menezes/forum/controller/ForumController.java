package com.manoel.menezes.forum.controller;

import com.manoel.menezes.forum.application.ForumApplicationService;
import com.manoel.menezes.forum.query.model.ForumQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/forums")
public class ForumController {

    private final ForumApplicationService service;

    @Autowired
    public ForumController(final ForumApplicationService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ForumQueryModel> findAll() {
        return service.findAll();
    }


}
