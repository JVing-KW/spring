package org.zerock.springex2.service;

import org.zerock.springex2.dto.PageRequestDTO;
import org.zerock.springex2.dto.PageResponseDTO;
import org.zerock.springex2.dto.TodoDTO;

public interface TodoService {

    void register(TodoDTO todoDTO);
//    List<TodoDTO> getAll();

    //페이징 처리후 글 목록 가져오기
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
    TodoDTO getOne(Long tno);

    void modify(TodoDTO todoDTO);

    void remove(Long tno);

}
