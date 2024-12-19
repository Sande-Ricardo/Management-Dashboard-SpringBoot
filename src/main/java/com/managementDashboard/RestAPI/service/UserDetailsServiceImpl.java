package com.managementDashboard.RestAPI.service;

import com.managementDashboard.RestAPI.controller.UserController;
import com.managementDashboard.RestAPI.controller.dto.AuthCreateUserRequest;
import com.managementDashboard.RestAPI.controller.dto.AuthLoginRequest;
import com.managementDashboard.RestAPI.controller.dto.AuthResponse;
import com.managementDashboard.RestAPI.model.FlashCard;
import com.managementDashboard.RestAPI.model.Headline;
import com.managementDashboard.RestAPI.model.Roles;
import com.managementDashboard.RestAPI.model.User;
import com.managementDashboard.RestAPI.repository.RoleRepositoryI;
import com.managementDashboard.RestAPI.repository.UserRepositoryI;
import com.managementDashboard.RestAPI.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UserRepositoryI userRepositoryI;

    @Autowired
    RoleRepositoryI roleRepositoryI;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoryI.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User " + username + " not found."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        user.getRoles()
                .forEach(roles -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(roles.getRoleEnum().name()))));

        user.getRoles().stream()
                .flatMap(roles -> roles.getPermissions().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNoExpired(),
                user.isCredentialNoExpired(),
                user.isAccountNoLocked(),
                authorityList
                ) ;
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){

        String email = authLoginRequest.email();
        String password = authLoginRequest.password();
        String username;

        Long id;
        String name;
        String last_name;
        List<Headline> headlines;
        List<FlashCard> flashCards;

        try{
            User user = userRepositoryI.findByEmail(email);
            username = user.getUsername();

            id = user.getIdUser();
            name = user.getName();
            last_name = user.getLast_name();
            headlines = user.getHeadlines();
            flashCards = user.getFlashCards();

        } catch (BadCredentialsException e){
            logger.error("Error: "+ e);
            throw new BadCredentialsException("Incorrect email! " + e);
        }


        Authentication authentication = this.authenticate(username, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accesToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse(username, "User logged succesfuly", accesToken, id, name, last_name, email, headlines, flashCards, true);

        return authResponse;
    }

    public Authentication authenticate (String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);

        if(userDetails == null){
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

    public AuthResponse createUser(AuthCreateUserRequest authCreateUserRequest){
        String username = authCreateUserRequest.username();
        String password = authCreateUserRequest.password();
        String email = authCreateUserRequest.email();

        String name = authCreateUserRequest.name();
        String last_name = authCreateUserRequest.last_name();
        List<Headline> headlines = authCreateUserRequest.headlines();
        List<FlashCard> flashCards = authCreateUserRequest.flashCards();

        Long id;

        List<String> roleRequest = authCreateUserRequest.roleRequest().roleListName();

        Set<Roles> rolesSet = roleRepositoryI.findRolesByRoleEnumIn(roleRequest).stream().collect(Collectors.toSet());
        if(rolesSet.isEmpty()){
            throw new IllegalArgumentException("Specified roles doesn´t exist.");
        }


        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)

                .name(name)
                .last_name(last_name)
                .flashCards(flashCards)
                .headlines(headlines)

                .roles(rolesSet)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();

        User userCreated = userRepositoryI.save(user);

        id = userRepositoryI.findByEmail(email).getIdUser();

        ArrayList<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userCreated.getRoles().forEach(roles -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(roles.getRoleEnum().name()))));

        userCreated.getRoles()
                .stream()
                .flatMap(roles -> roles.getPermissions().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userCreated.getUsername(), userCreated.getPassword(), authorityList);

        String accesToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse(userCreated.getUsername(), "User created succesfuly.", accesToken, id, name, last_name, email, headlines, flashCards, true);
        return authResponse;
    }
}
