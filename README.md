###Minimum sample project for [spring-boot#5096 issue](https://github.com/spring-projects/spring-boot/issues/5096)

How to reproduce an error:

1. Start `account-service` and `auth-service` applications
2. Request oauth token with user credentials from `browser` client:

  `curl -X POST --user browser: http://localhost:5000/uaa/oauth/token --data "scope=ui&username=name&password=password&grant_type=password"`

3. Use received token to request account-service controller:

  `curl -X GET http://localhost:6000/ -H "Authorization: Bearer #token#"`
  
You will get `Access is denied` error, because this controller protected with `@PreAuthorize("#oauth2.hasScope('ui')")` annotation, which has unexpected behavior at the moment.

--
UPD:
Custom implementation of ResourceServerTokenServices solves the problem. Have a look at CustomUserInfoTokenServices in account-service.
