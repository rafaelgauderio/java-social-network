package br.com.delucahigiene.APIrestfulmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.delucahigiene.APIrestfulmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}