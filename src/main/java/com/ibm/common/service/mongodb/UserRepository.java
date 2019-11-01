/**
 * 
 */
package com.ibm.common.service.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.common.service.entity.User;

/**
 * Mongo UserRepository
 * 
 * @author LiuBaoWen
 *
 */
public interface UserRepository extends MongoRepository<User, Long> {

}
