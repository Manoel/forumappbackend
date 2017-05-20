package com.manoel.menezes.forum.infrastructure;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

class DynamoBaseRepository {

    private static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(
                    // we can use any region here
                    new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "00000000"))
            .build();

    static DynamoDB dynamoDB = new DynamoDB(client);

}
