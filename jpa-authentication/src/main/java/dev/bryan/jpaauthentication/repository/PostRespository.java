package dev.bryan.jpaauthentication.repository;

import dev.bryan.jpaauthentication.model.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRespository extends CrudRepository<Post, Long> {
}
