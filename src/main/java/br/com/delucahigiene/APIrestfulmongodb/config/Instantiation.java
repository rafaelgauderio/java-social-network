package br.com.delucahigiene.APIrestfulmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.delucahigiene.APIrestfulmongodb.domain.User;
import br.com.delucahigiene.APIrestfulmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String...arg0) throws Exception {
			
		userRepository.deleteAll();
		
		User rafael = new User (null,"Rafael De Luca", "rafael@gmail");
		User maria = new User(null, "Maria da Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Pereira", "alex@gmail.com");
		User robert = new User(null, "Robert Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(rafael,maria,alex,robert));
		
		
	}

}
