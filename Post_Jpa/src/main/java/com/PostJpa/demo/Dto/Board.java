package com.PostJpa.demo.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity // entity 지정
@Data // 안에 @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor 도 같이 사용되어 짐.
public class Board {
    @Id // Pk로 사용될 Entity의 프로퍼티에 @Id를 선언
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA에서 Entity의 Primary Key를 생성하여 주는 기능

    private int boardId;
    private String title;
    private String content;
    private int userId;
    private LocalDateTime regdate;
    private int viewCnt;
    private String name; // BeanPropertySqlParameterSource() 를 위한 추가
    }
