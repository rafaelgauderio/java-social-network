package br.com.delucahigiene.APIrestfulmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.delucahigiene.APIrestfulmongodb.domain.Post;
import br.com.delucahigiene.APIrestfulmongodb.domain.User;
import br.com.delucahigiene.APIrestfulmongodb.repository.PostRepository;
import br.com.delucahigiene.APIrestfulmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String...arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User rafael = new User (null,"Rafael De Luca", "rafael@gmail");
		User maria = new User(null, "Maria da Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Pereira", "alex@gmail.com");
		User robert = new User(null, "Robert Grey", "bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/08/2021"), "Bora ir pra praia","Vamos viajar para Miami, abraços.",maria);
		Post post2 = new Post(null,sdf.parse("25/03/2021"),"Bem vindo a Foz.","Hoje vai ser bom o passeio.",maria);
		
		
		userRepository.saveAll(Arrays.asList(rafael,maria,alex,robert));
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		
	}

}
