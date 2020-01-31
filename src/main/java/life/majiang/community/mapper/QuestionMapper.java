package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionMapper {

   void createQuestion(Question question);

    List<Question> findlist();
}
