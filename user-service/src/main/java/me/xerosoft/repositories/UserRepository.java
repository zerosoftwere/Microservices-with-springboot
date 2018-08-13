package me.xerosoft.repositories;

import me.xerosoft.models.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by xero on 8/10/18.
 */
@Repository
public interface UserRepository extends BaseRepository<User, String> {
    boolean containsName(String name);
    Collection<User> findByName(String name) throws Exception;
}
