package com.homework.galaxy.utils;

import com.homework.galaxy.dao.KnowledgeDao;
import com.homework.galaxy.dao.impl.KnowledgeDaoImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.homework.galaxy.utils.QuestionProcessor.NO_ANSWER;
import static com.homework.galaxy.utils.QuestionProcessor.WRONG_ROMAN_NUMBER;
import static org.junit.Assert.assertEquals;


@RunWith(value= Parameterized.class)
public class QuestionProcessorTest {

    private String question;
    private String answerExpected;


    private QuestionProcessor qProcesser = new QuestionProcessor();

    public QuestionProcessorTest(String question, String answerExpected) {
        this.question = question;
        this.answerExpected = answerExpected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestCases()  {

        List<Object[]> paras = new ArrayList<Object[]>();

        paras.add(new Object[]{"how much is pish tegj glob glob ?","pish tegj glob glob is 42"});
        paras.add(new Object[]{"how many Credits is glob prok Silver ?","glob prok Silver is 68"});
        paras.add(new Object[]{"how many Credits is glob prok Gold ?","glob prok Gold is 57800"});
        paras.add(new Object[]{"how many Credits is glob prok Iron ?","glob prok Iron is 782"});
        paras.add(new Object[]{"how many Credits is glob EEEE ?","glob EEEE is 50.8"});

        paras.add(new Object[]{"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?",NO_ANSWER});
        paras.add(new Object[]{"howmuch is pish tegj glob glob ?",NO_ANSWER});
        paras.add(new Object[]{"how muchx is pish tegj glob glob ?",NO_ANSWER});
        paras.add(new Object[]{"howmany Credits is glob prok Iron ?",NO_ANSWER});
        paras.add(new Object[]{"how manyx Credits is glob prok Iron ?",NO_ANSWER});
        paras.add(new Object[]{"how manyx credits is glob prok Iron ?",NO_ANSWER});

        paras.add(new Object[]{"how many credits is pish pish pish pish Iron ?",WRONG_ROMAN_NUMBER});



        return paras;
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        KnowledgeDao dao = KnowledgeDaoImpl.getInstance();

        dao.addAssignedValue("glob","I");
        dao.addAssignedValue("prok","V");
        dao.addAssignedValue("pish","X");
        dao.addAssignedValue("tegj","L");
        dao.addAssignedValue("Silver",17.0d);
        dao.addAssignedValue("Gold",14450.0d);
        dao.addAssignedValue("Iron",195.5d);
        dao.addAssignedValue("EEEE",50.80d);

    }






    @Test
    public void processQuestion() {
        String answer = qProcesser.processQuestion(this.question);
        assertEquals(this.answerExpected,answer);
    }
}