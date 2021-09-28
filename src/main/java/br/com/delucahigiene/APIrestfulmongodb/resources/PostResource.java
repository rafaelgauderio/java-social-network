package br.com.delucahigiene.APIrestfulmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.delucahigiene.APIrestfulmongodb.domain.Post;
import br.com.delucahigiene.APIrestfulmongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;

	//tem que usar o Object_id que pode pegar no MongoDB compass para fazer a busca no postman
	//http://localhost:8081/posts/615336418d6b5d0afc433515
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}