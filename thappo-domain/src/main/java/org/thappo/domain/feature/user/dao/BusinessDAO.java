package org.thappo.domain.feature.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thappo.domain.feature.user.model.User;

/*
 * DOC: http://docs.spring.io/spring-data/jpa/docs/1.4.2.RELEASE/reference/html/jpa.repositories.html
 */

public interface BusinessDAO extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email, String asd);
    
	void delete(Integer id);

	User findOne(Integer id);


}
