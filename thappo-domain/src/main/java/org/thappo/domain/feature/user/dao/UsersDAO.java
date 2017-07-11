package org.thappo.domain.feature.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.thappo.domain.feature.user.model.User;

/*
 * DOC: http://docs.spring.io/spring-data/jpa/docs/1.4.2.RELEASE/reference/html/jpa.repositories.html
 */

public interface UsersDAO extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email, String asd);
    
	void delete(Integer id);

	User findOne(Integer id);

	@Modifying
	@Transactional
	@Query("update users u set u.state = 'INACTIVE' where u.userId = :userId")
	int setUserStateToInactive(@Param("userId")Integer userId);

}
