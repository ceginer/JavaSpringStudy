package com.crudPost.Post.Dao;

import com.crudPost.Post.Dto.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;

// DAO, Data Access Object 로써, 사실상 Repository 의미
@Repository
// 이 아이는 @RequiredArgsConstructor 안씀
public class UserDao {
    // 그냥 jdbcTemplate 의 경우는 sql 에서 비어있는 곳을 ?로 하는 반면,
    // NamedParameterJdbcTemplate 는 sql 에서 ?대신 :변수명 을 이용하여 처리함으로써 순서에 강제를 받지 않는다.

   // jdbcTemplate -> jdbcTemplate.update 시에 사용
    private final NamedParameterJdbcTemplate jdbcTemplate;
    /////////////////////////////
    // insertUser 는 sql param 을 전달받기 위한 객체? 그래서 나중에 insertUser.execute하여 받아들인다.
    private SimpleJdbcInsertOperations insertUser;

    // DAO 가 db와 직접적으로 연동하므로 DAO 에서 datasource 사용
    public UserDao(DataSource dataSource){
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        /////////////////////////////////////////
        // SimpleJdbcInsertOperations 를 초기화하면 insert하는 효과를 얻을 수 있다.
        insertUser = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("user_id");
                // -> 자동으로 증가되는 id 설정(보통 id는 이걸 사용하는 듯)
                //   mysql에서의 autoincrement 설정인데,
                //   왠만하면 id는 mysql에서도 autoincrement 사용한다고 함.

    }
    //Spring JDBC를 이용한 코드.
    @Transactional
    public User addUser(String email, String name, String password){
        // Service에서 이미 트랜잭션이 시작했기 때문에, 그 트랜잭션에 포함된다.
        // insert into user (email, name, password, regdate) values (?, ?, ?, now()); # user_id auto gen
        // ->>> // insert into user (email, name, password, regdate) values (:email, :name, :password, :regdate); # user_id auto gen
        // SELECT LAST_INSERT_ID();
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setRegDate(LocalDateTime.now());  // regDate
        SqlParameterSource param = new BeanPropertySqlParameterSource(user);
        // execute 는 전달된 값을 받아 그냥 실행
        // executeAndReturnKey 전달된 값을 삽입하고 생성된 키를 반환
        Number number = insertUser.executeAndReturnKey(param);
        int userId = number.intValue();
        user.setUserId(userId);
        return user;

    }

//    public int getLastInsertId(){
//        return 0; // 임시
//    }

    // 접근 권한과 관련된 메서드
    @Transactional
    public void mappingUserRole(int userId){
        // Service에서 이미 트랜잭션이 시작했기 때문에, 그 트랜잭션에 포함된다.
        // insert into user_role( user_id, role_id ) values ( ?, 1);
        String sql = "insert into user_role( user_id, role_id ) values (:userId, 1)";
        SqlParameterSource params = new MapSqlParameterSource("userId", userId);

        // 위에서 values (:userId, 1) <- 여기서 ? 를 사용하지 않은 이유가
        // 이 jdbcTemplate는 그냥 JdbcTemplate 가 아닌 NamedParameterJdbcTemplate 를 사용했기 때문
        jdbcTemplate.update(sql, params);
    }

}
