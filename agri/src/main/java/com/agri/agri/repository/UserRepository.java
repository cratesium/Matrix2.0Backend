//package com.agri.agri.repo;
//
//public interface UserRepository {
//}
package com.agri.agri.repository;

import com.agri.agri.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    User findByMobileNo(String mobileNo);
}

