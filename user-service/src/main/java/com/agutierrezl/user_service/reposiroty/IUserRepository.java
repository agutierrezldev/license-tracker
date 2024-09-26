package com.agutierrezl.user_service.reposiroty;

import com.agutierrezl.user_service.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface IUserRepository extends CrudRepository<UserEntity, String> {
}
