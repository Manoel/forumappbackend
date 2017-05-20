package com.manoel.menezes.forum.infrastructure;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.manoel.menezes.forum.query.model.ForumFinder;
import com.manoel.menezes.forum.query.model.ForumQueryModel;
import org.springframework.stereotype.Repository;

import static com.manoel.menezes.forum.infrastructure.DynamoBaseRepository.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public final class ForumFinderImpl implements ForumFinder {

    private static final String tableName = "Forum";

    @Override
    public List<ForumQueryModel> findAll() {

        Table table = dynamoDB.getTable(tableName);

        ItemCollection<ScanOutcome> items = table.scan();

        Iterator<Item> iterator = items.iterator();

        List<ForumQueryModel> result = new ArrayList<>();

        while (iterator.hasNext()) {
            Item item = iterator.next();

            String name = item.getString("Name");
            String category = item.hasAttribute("Category") ? item.getString("Category") : "";
            int threads = item.hasAttribute("Threads") ? item.getInt("Threads") : 0;
            int messages = item.hasAttribute("Messages") ? item.getInt("Messages") : 0;
            int views = item.hasAttribute("Views") ? item.getInt("Views") : 0;

            result.add(new ForumQueryModel(name, category, threads, messages, views));
        }

        return result;

    }
}
