package com.zeqinlin.MyCommunity.dao.elasticsearch;

import com.zeqinlin.MyCommunity.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * date: 2021/6/8 21:30
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {

}
