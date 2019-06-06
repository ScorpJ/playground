package com.homework.galaxy.service;


import com.homework.galaxy.dao.KnowledgeDao;
import com.homework.galaxy.dao.impl.KnowledgeDaoImpl;
import com.homework.galaxy.service.impl.IntergalacticConversionServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.homework.galaxy.utils.QuestionProcessor.NO_ANSWER;
import static org.junit.Assert.assertEquals;


@RunWith(value= Parameterized.class)
public class IntergalacticConversionServiceTest {

    private String question;
    private String answerExpected;

    IntergalacticConversionService service = new IntergalacticConversionServiceImpl();


    public IntergalacticConversionServiceTest(String question, String answerExpected) {
        this.question = question;
        this.answerExpected = answerExpected;
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        KnowledgeDao dao = KnowledgeDaoImpl.getInstance();

        dao.addAssignedValue("i","I");
        dao.addAssignedValue("v","V");
        dao.addAssignedValue("x","X");
        dao.addAssignedValue("l","L");
        dao.addAssignedValue("c","C");
        dao.addAssignedValue("d","D");
        dao.addAssignedValue("m","M");

        dao.addAssignedValue("Unit",10.0d);

    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestCases()  {

        List<Object[]> paras = new ArrayList<Object[]>();

        paras.add(new Object[]{"how much is m c m x l i v ?","m c m x l i v is 1944"});
        paras.add(new Object[]{"how many Credits is m c m x l i v Unit ?","m c m x l i v Unit is 19440"});

        paras.add(new Object[]{"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?",NO_ANSWER});
        paras.add(new Object[]{"howmuch is m c m x l i v ?",NO_ANSWER});
        paras.add(new Object[]{"how muchx is m c m x l i v ?",NO_ANSWER});
        paras.add(new Object[]{"howmany Credits is m c m x l i v Unit ?",NO_ANSWER});
        paras.add(new Object[]{"how manyx Credits is m c m x l i v Unit ?",NO_ANSWER});
//        paras.add(new Object[]{"how many Credits is m c m x l i v Unit",NO_ANSWER});



        return paras;
    }

    @Test
    public void responseQuestions() {
        String answer = service.responseQuestions(this.question);
        assertEquals(question,this.answerExpected,answer);
    }


}