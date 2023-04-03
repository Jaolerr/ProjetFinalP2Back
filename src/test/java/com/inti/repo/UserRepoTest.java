package com.inti.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoTest {
	private Utilisateur u, savedUser;
	
	@Autowired IUtilisateurRepository iur;
	
	@BeforeAll
	public void setup() {
		u=new Utilisateur("test","test", "mail@mail.fr", "06987898", "login", "pw", false);
		savedUser=iur.save(u);
	}
	
	@Test @DisplayName("test pour l'enregistrement d'un utilisateur")
	public void saveDestination() {
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId_U()).isGreaterThan(0);
	}
	
	@Test @DisplayName("test recupération user")
	public void getDestination()
	{
		Utilisateur u2=iur.getReferenceById(savedUser.getId_U());
		
		assertThat(u2).isNotNull();
		assertThat(u2.getId_U()).isEqualTo(savedUser.getId_U());
		assertThat(u2.getLogin()).isEqualTo(savedUser.getLogin());
		assertThat(u2.getMail()).isEqualTo(savedUser.getMail());
		assertThat(u2.getTelephone()).isEqualTo(savedUser.getTelephone());
		assertThat(u2.getNom()).isEqualTo(savedUser.getNom());

		
		
	}
	

}
