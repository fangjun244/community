package life.majiang.community.service;

import life.majiang.community.dto.QuestionDto;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper  userMapper;

    public List<QuestionDto> list(){

        List<Question> questionList = questionMapper.findlist();
        ArrayList<QuestionDto> questionDtoArrayList = new ArrayList<>();
        for (Question question : questionList) {
            Integer creator_id = question.getCreator();
            User user = userMapper.findByAccountid(creator_id);
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoArrayList.add(questionDto);
        }
        return questionDtoArrayList;
    }
}
