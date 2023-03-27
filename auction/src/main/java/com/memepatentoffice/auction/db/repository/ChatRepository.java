package com.memepatentoffice.auction.db.repository;

import com.memepatentoffice.auction.db.entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ChatRepository extends MongoRepository<Chat,Long> {
    Chat findTopByOrderByCreatedAtDesc();
    Chat findBySeq(Long seq);
}