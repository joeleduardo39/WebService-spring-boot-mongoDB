package com.joeleduardo.webservicemongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joeleduardo.webservicemongo.domain.User;

@Repository //anotação no SpringData
public interface UserRepository extends MongoRepository<User, String> {

}
