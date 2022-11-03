# Sprig Security JPA Authentication

## Problem

We are using Spring Security, and we need to authenticate against a DB that uses Spring Data JPA.

Working with JDBC, for example, and Spring Security to authenticate users, is simple,
because it has a built-in mechanism called jdbcUserDetailsManager for the configuration.

However, there is no a built-in mechanism for authenticate users verifying against a DB using JPA.

## Solution

Creating our own jpaUserDetailsManager implementing the public interface UserDetailsManager which is used by jdbcUserDetailsManager

1. Creating a JpaUserDetailsService implementing UserDetailsManager.
2. Defining the User Entity and the User Repository to persist the credentials.
3. [Optional] Inserting some users manually in the command line runner , to have some users loaded.
4. Creating a user model for Security purposes,to check against the user Entity info. This SecurityUser must implements the UserDetails interface
5. Overriding the UserDetails interface methods in the SecurityUser we created before
6. Returning the UserSecurity in the JpaUserDetailsService we defined and expected a UserDetails type to return.
7. ```java  
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(()-> new UsernameNotFoundException("The user "+username+ "was not found"));
    }

8. Defining our UserDetailsService in the SecurityConfig class to let Spring knows which authentication service it must use.

