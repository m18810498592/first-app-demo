package firstappdemo.repository;

import firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wcz
 * @date 2019-06-07 23:26
 **/
@Repository
public class UserRepository {

	/**
	 * 采用内存型存储方式
	 */
	private ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();

	private static final AtomicInteger idGenerator = new AtomicInteger();

	/**
	 * 保存用户对象
	 * @param user
	 * @return
	 * 成功	<code>true</code>
	 * 失败	<code>false</code>
	 *
	 */
	public boolean save(User user){
		Integer id = idGenerator.incrementAndGet();
		user.setId(id);
		return repository.put(id,user) == null;
	}

	public Collection<User> findAll(){
		return repository.values();
	}

}
