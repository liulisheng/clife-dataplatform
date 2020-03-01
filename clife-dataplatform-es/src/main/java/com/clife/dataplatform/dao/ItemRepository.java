package com.clife.dataplatform.dao;

import com.clife.dataplatform.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
}
