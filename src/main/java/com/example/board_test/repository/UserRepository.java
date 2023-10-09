package com.example.board_test.repository;

import com.example.board_test.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    //회원가입
    UserEntity save(UserEntity user);

    //로그인
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.pw = :pw")
    Optional<UserEntity> findByEmailAndPw
            (@Param("email") String email, @Param("pw") String pw);
    
    //이메일로 사용자 조회
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    Optional<UserEntity> findByEmail(@Param("email") String email);

    //gpt- @Param 사용 이유, 가독성, 변수명 변경 시 안전, 동일한 이름의 파라미터 처리
}
