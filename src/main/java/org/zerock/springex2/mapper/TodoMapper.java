package org.zerock.springex2.mapper;


import org.zerock.springex2.domain.TodoVO;
import org.zerock.springex2.dto.PageRequestDTO;
import org.zerock.springex2.dto.TodoDTO;

import java.util.List;



public interface TodoMapper {
    // interface와 그걸 구현하는 클래스 관계처럼
    //interface TodoMapper를 .xml 설정으로 mybatis와 연결하고 구현까지 해줌
    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void update(TodoVO todoVO);

    void delete(Long tno);
    //페이징 처리(원하는 글의 갯수 선택) 후 글 요청
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);


    //글의 전체 갯수 구함
    int getCount(PageRequestDTO pageRequestDTO);

}