package org.zerock.springex2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.springex2.domain.TodoVO;
import org.zerock.springex2.dto.PageRequestDTO;
import org.zerock.springex2.dto.PageResponseDTO;
import org.zerock.springex2.dto.TodoDTO;
import org.zerock.springex2.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private ModelMapper modelMapper;

    //  글 하나 등록
    @Override
    public void register(TodoDTO todoDTO) {

        log.info("서비스 층에서의 modelMapper 객체 : " +modelMapper );

        TodoVO todoVO=modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.insert(todoVO);
    }

    //글 전체 조회(페이징 처리 후)
    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {

        List<TodoVO> voList= todoMapper.selectList(pageRequestDTO);

        List<TodoDTO> dtoList=voList.stream().map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());

        int total=todoMapper.getCount(pageRequestDTO);


        PageResponseDTO<TodoDTO> pageResponseDTO  = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList).total(total)
                .pageRequestDTO(pageRequestDTO).build();

        return pageResponseDTO;
    }

    //글 전체 조회(페이징 처리 전)
//    @Override
//    public List<TodoDTO> getAll() {
//
//        List<TodoDTO> dtoList=todoMapper.selectAll().stream().map(vo->modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());
//
//        return dtoList;
//    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO= todoMapper.selectOne(tno);
        TodoDTO todoDTO=modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class );

        todoMapper.update(todoVO);
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }






}