package com.managementDashboard.RestAPI;

import com.managementDashboard.RestAPI.enums.RoleEnum;
import com.managementDashboard.RestAPI.model.*;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Value("${front.allowed.origins}")
	private String allowedOrigin;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {


				registry
						.addMapping("/**")
						.allowedOrigins(allowedOrigin)
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

//  **************************************** TEMPORAL ****************************************
//	@Bean
//	CommandLineRunner init(UserRepositoryI userRepositoryI) {
//		return args -> {
//			/* Create PERMISSIONS */
//			Permission createPermission = Permission.builder()
//					.name("CREATE")
//					.build();
//
//			Permission readPermission = Permission.builder()
//					.name("READ")
//					.build();
//
//			Permission updatePermission = Permission.builder()
//					.name("UPDATE")
//					.build();
//
//			Permission deletePermission = Permission.builder()
//					.name("DELETE")
//					.build();
//
//			Permission refactorPermission = Permission.builder()
//					.name("REFACTOR")
//					.build();
//
//			/* Create ROLES */
//			Roles roleAdmin = Roles.builder()
//					.roleEnum(RoleEnum.ADMIN)
//					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission))
//					.build();
//
//			Roles roleUser = Roles.builder()
//					.roleEnum(RoleEnum.USER)
//					.permissions(Set.of(createPermission, readPermission, updatePermission))
//					.build();
//
////			Roles roleInvited = Roles.builder()
////					.roleEnum(RoleEnum.INVITED)
////					.permissions(Set.of(readPermission))
////					.build();
//
//			Roles roleDeveloper = Roles.builder()
//					.roleEnum(RoleEnum.DEVELOPER)
//					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
//					.build();
//
//			/* Create Headlines */
//			List<Headline> headlines = new ArrayList<>();
//			List<Task> tasks = new ArrayList<>();
//
//			Task task = new Task();
//			task.setTitle("Title");
//			task.setContent("Content");
//			tasks.add(task);
//
//			Headline headline = new Headline();
//			headline.setContent("CONTENT");
//			headline.setTasks(tasks);
//
//			headlines.add(headline);
//
//			List<Headline> headlines2 = new ArrayList<>();
//			List<Task> tasks2 = new ArrayList<>();
//
//			Task task2 = new Task();
//			task2.setTitle("Title");
//			task2.setContent("Content");
//			tasks2.add(task2);
//
//			Headline headline2 = new Headline();
//			headline2.setContent("CONTENT");
//			headline2.setTasks(tasks2);
//
//			headlines2.add(headline2);
//
//			List<Headline> headlines3 = new ArrayList<>();
//			List<Task> tasks3 = new ArrayList<>();
//
//			Task task3 = new Task();
//			task3.setTitle("Title");
//			task3.setContent("Content");
//			tasks3.add(task3);
//
//			Headline headline3 = new Headline();
//			headline3.setContent("CONTENT");
//			headline3.setTasks(tasks3);
//
//			headlines3.add(headline3);
//
//			/* Create FlashCards */
//			List<FlashCard> flashCards1 = new ArrayList<>();
//			FlashCard flashCard1 = new FlashCard();
//			flashCard1.setTitle("Title");
//			flashCard1.setContent("Content");
//			flashCards1.add(flashCard1);
//
//			List<FlashCard> flashCards2 = new ArrayList<>();
//			FlashCard flashCard2 = new FlashCard();
//			flashCard2.setTitle("Title");
//			flashCard2.setContent("Content");
//			flashCards2.add(flashCard2);
//
//			List<FlashCard> flashCards3 = new ArrayList<>();
//			FlashCard flashCard3 = new FlashCard();
//			flashCard3.setTitle("Title");
//			flashCard3.setContent("Content");
//			flashCards3.add(flashCard3);
//
//			/* Create USERS */
//			User userAdmin = User.builder()
//					.username("admin")
//					.email("admin@gmail.com")
//					.password("$2a$10$3UQpHdOrF53t45xEI6sNsuASdtc31py8BaGbmBX8.ypok69rmSpZO")
//					.name("Admin")
//					.last_name("Ad")
//					.headlines(headlines)
//					.flashCards(flashCards1)
//
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleAdmin))
//					.build();
//
//			User userUser = User.builder()
//					.username("user")
//					.email("user@gmail.com")
//					.password("$2a$10$3UQpHdOrF53t45xEI6sNsuASdtc31py8BaGbmBX8.ypok69rmSpZO")
//					.name("User")
//					.last_name("Us")
//					.headlines(headlines2)
//					.flashCards(flashCards2)
//
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleUser))
//					.build();
//
//			User userDeveloper = User.builder()
//					.username("developer")
//					.email("developer@gmail.com")
//					.password("$2a$10$3UQpHdOrF53t45xEI6sNsuASdtc31py8BaGbmBX8.ypok69rmSpZO")
//					.name("Developer")
//					.last_name("Dev")
//					.headlines(headlines3)
//					.flashCards(flashCards3)
//
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleDeveloper))
//					.build();
//
////			userRepositoryI.saveAll(List.of(userAdmin
////					, userUser
////					, userDeveloper
////			));
//		};
//	}


}
