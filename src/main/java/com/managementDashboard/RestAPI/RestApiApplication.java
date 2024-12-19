package com.managementDashboard.RestAPI;

import com.managementDashboard.RestAPI.enums.RoleEnum;
import com.managementDashboard.RestAPI.model.Permission;
import com.managementDashboard.RestAPI.model.Roles;
import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
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
//			/* Create USERS */
//			User userAdmin = User.builder()
//					.username("admin")
//					.password("$2a$10$3UQpHdOrF53t45xEI6sNsuASdtc31py8BaGbmBX8.ypok69rmSpZO")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleAdmin))
//					.build();
//
//			User userUser = User.builder()
//					.username("user")
//					.password("$2a$10$3UQpHdOrF53t45xEI6sNsuASdtc31py8BaGbmBX8.ypok69rmSpZO")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleUser))
//					.build();
//
//			User userDeveloper = User.builder()
//					.username("developer")
//					.password("$2a$10$3UQpHdOrF53t45xEI6sNsuASdtc31py8BaGbmBX8.ypok69rmSpZO")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleDeveloper))
//					.build();
//
//			userRepositoryI.saveAll(List.of(userAdmin, userUser, userDeveloper));
//		};
//	}


}
