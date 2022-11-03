# Sprig Security JPA Aunthentication

## Problem

We are using Spring Security and we need to authenticate against a DB that uses Spring Data JPA.

Working with JDBC, for example, and Spring Security to authenticate users, is simple,
because it has a built-in mechanism called jdbcUserDetailsManager for the configuration.

However, there is no a built-in mechanism for authenticate users verifying against a DB using JPA.

## Solution

Creating our own jpaUserDetailsManager implmenting the public interface UserDetailsManager which is used by jdbcUserDetailsManager
