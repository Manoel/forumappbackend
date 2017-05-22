package com.manoel.menezes.forum.infrastructure;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.manoel.menezes.forum.domain.model.Forum;
import com.manoel.menezes.forum.query.model.ForumFinder;
import com.manoel.menezes.forum.query.model.ForumQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.manoel.menezes.forum.infrastructure.DynamoBaseRepository.dynamoDBMapperConfig;
import static com.manoel.menezes.forum.infrastructure.DynamoBaseRepository.mapper;

@Repository
public final class ForumFinderImpl implements ForumFinder {

    @Override
    public List<ForumQueryModel> findAll() {

        PaginatedScanList<Forum> forumPaginatedScanList = mapper.scan(Forum.class, new DynamoDBScanExpression(), dynamoDBMapperConfig);

        return forumPaginatedScanList.stream()
                .map(f -> new ForumQueryModel(f.getName(),
                        f.getCategory()!= null ? f.getCategory() : "", f.getThreads()))
                .collect(Collectors.toList());

    }
}
