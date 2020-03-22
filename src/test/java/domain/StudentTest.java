package domain;

import org.junit.Test;
import repository.AbstractXMLRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import javax.annotation.processing.SupportedAnnotationTypes;
//import java.util.ArrayList;
//import java.util.List;

public class StudentTest {

    @Test
    public void createStudentTest(){

    }
}

//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
//    private Repository rep;
//    private ParticipantController ctrl;
//
//    @Test
//    public void tc_4_AllParticipantsMax() {
//
//        rep = new Repository("FileParticipantsMaxAll.txt");
//
//        ctrl=new ParticipantController(rep);
//        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();
//
//        assertEquals(4, noParticipantsMax);
//    }
//    @Test
//    public void tc_3_AllParticipantsOnlyOne() {
//        rep = new Repository("FileParticipantsMaxOne.txt");
//
//        ctrl=new ParticipantController(rep);
//        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();
//
//        assertEquals(1, noParticipantsMax);
//    }
//
//    @Test
//    public void tc_20_ParticipantsWith99Points() {
//        rep = new Repository("FileParticipants99Points.txt");
//
//        ctrl=new ParticipantController(rep);
//        int noParticipantsMax= ctrl.getNumberOfParticipantWithMaxPointsReceived();
//
//        assertEquals(3, noParticipantsMax);
//    }