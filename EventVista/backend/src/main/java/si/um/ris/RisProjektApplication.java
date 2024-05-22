package si.um.ris;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import si.um.ris.models.AppUser;
import si.um.ris.models.Role;
import si.um.ris.repository.IAppUserRepo;
import si.um.ris.repository.IRoleRepo;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class RisProjektApplication {

	public static void main(String[] args) {

		SpringApplication.run(RisProjektApplication.class, args);
	}

	@Bean
	CommandLineRunner run(IRoleRepo roleRepo, IAppUserRepo userRepo, PasswordEncoder passwordEncode) {
		return args -> {
			System.out.println("Delam admina");
			if(roleRepo.findByAuthority("ADMIN").isPresent()) {
				System.out.println("admin ze obstaja");
				return;
			}
			System.out.println("Ni se admina");
			Role adminRole = roleRepo.save(new Role("ADMIN"));
			roleRepo.save(new Role("USER"));
			System.out.println("_____________1_______________");
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			System.out.println("______________2______________");
			AppUser admin = new AppUser(1L, "admin", "admin@eventvista.com", passwordEncode.encode("admin"), roles);

			userRepo.save(admin);
			System.out.println("naredo sem admina" + admin);
		};
	}

}
