package com.ccsw.techassessment.question;

import com.ccsw.techassessment.question.model.QuestionSearchDto;
import org.dozer.DozerBeanMapper;

import com.ccsw.techassessment.question.model.Question;
import com.ccsw.techassessment.question.model.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping(value = "/question")
@RestController
public class QuestionController {
    private QuestionService questionService;
    private DozerBeanMapper mapper;

    @Autowired
    public QuestionController(QuestionService questionService, DozerBeanMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @Operation(summary = "Find Page Filtered", description = "Method that return a filtered page of Questions")
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<QuestionDto> findPage(@RequestBody QuestionSearchDto dto) {

        Page<Question> page = this.questionService.findPage(dto);

        return new PageImpl<>(
                page.getContent().stream().map(question -> mapper.map(question, QuestionDto.class)).collect(Collectors.toList()),
                page.getPageable(), page.getTotalElements());
    }

    @Operation(summary = "Question by id", description = "Method that return a question by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public QuestionDto getQuestion(@PathVariable("id") Long id) {
        return mapper.map(questionService.getQuestion(id), QuestionDto.class);
    }

    @Operation(summary = "All questions", description = "Method that return all questions")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return questions.stream().map(question -> mapper.map(question, QuestionDto.class)).toList();
    }

    @Operation(summary = "New Question", description = "Method that create a new question")
    @RequestMapping(path ={"/new"}, method = RequestMethod.POST)
    public void newQuestion(@RequestBody QuestionDto questionDto) throws Exception {
        questionService.saveQuestion(null,questionDto);
    }
    @Operation(summary = "Update", description = "Method that update a question")
    @RequestMapping(path ={"","/{id}"}, method = RequestMethod.PUT)
    public void updateQuestion(@PathVariable(name = "id", required = false) Long id, @RequestBody QuestionDto questionDto) throws Exception {
        questionService.saveQuestion(id, questionDto);
    }

    @Operation(summary = "Delete question", description = "Method that delete a question")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable("id") Long id) throws Exception {
        questionService.deleteQuestion(id);
    }

}
