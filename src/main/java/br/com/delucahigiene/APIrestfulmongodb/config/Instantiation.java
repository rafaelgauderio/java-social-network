package br.com.delucahigiene.APIrestfulmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.delucahigiene.APIrestfulmongodb.domain.Post;
import br.com.delucahigiene.APIrestfulmongodb.domain.User;
import br.com.delucahigiene.APIrestfulmongodb.dto.AuthorDTO;
import br.com.delucahigiene.APIrestfulmongodb.dto.CommentDTO;
import br.com.delucahigiene.APIrestfulmongodb.repository.PostRepository;
import br.com.delucahigiene.APIrestfulmongodb.repository.UserRepository;

//Essa seria a carga inicial para testar o bando de dados

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
		
		userRepository.saveAll(Arrays.asList(rafael,maria,alex,robert));
		
		Post post1 = new Post(null,sdf.parse("21/08/2021"), "Bora ir pra praia","Vamos viajar para Miami, abraços.",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("25/03/2021"),"Bem vindo a Foz.","Hoje vai ser bom o passeio.",new AuthorDTO(maria));
		Post post3 = new Post(null,sdf.parse("17/12/2020"),"Aniversário","Sucesso hoje faço quase 40 anos", new AuthorDTO(rafael));
		
		CommentDTO comt1 = new CommentDTO("Boa viajem pra praia meu jovem!", sdf.parse("22/08/2021"), new AuthorDTO(alex));
		CommentDTO comt2 = new CommentDTO("Curta Foz do iguaçu, visita as Cataratas.",sdf.parse("25/03/2021"),new AuthorDTO(rafael));
		CommentDTO comt3 = new CommentDTO("Aproveite para visitar o Paraguai.",sdf.parse("25/03/2021"),new AuthorDTO(robert));
		CommentDTO comt4 = new CommentDTO("Faça um festão de aniversário e me convide",sdf.parse("17/12/2020"),new AuthorDTO(maria));
		
		
		post1.getComments().addAll(Arrays.asList(comt1));
		post2.getComments().addAll(Arrays.asList(comt2,comt3));
		post3.getComments().addAll(Arrays.asList(comt4));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2,post3));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		rafael.getPosts().addAll(Arrays.asList(post3));
		
		userRepository.save(maria);
		userRepository.save(rafael);
		
		
	}

}
