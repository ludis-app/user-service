package com.ludis.userservice.repository;

import com.ludis.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    @Query("{name:'?0'}")
    User findItemByName(String name);

    @Query(value="{country:'?0'}", fields="{'name' : 1, 'country' : 1}")
    List<User> findAll(String country);

    public long count();
}
