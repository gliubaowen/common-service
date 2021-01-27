/**
 * 
 */
package com.lbw.common.service.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lbw.common.service.entity.User;

/**
 * Mongo UserRepository
 * 
 * @author LiuBaoWen
 *
 */
public interface UserRepository extends MongoRepository<User, Long> {

}
