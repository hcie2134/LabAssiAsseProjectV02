package service;

import domain.Student;
import org.junit.Test;
import org.junit.internal.JUnitSystem;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ServiceTest {
    private StudentXMLRepo studentFileRepository;
    private Service service;

    @Test
    public void addStudentTest_Works(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        String idStudent = "125";
        String numeStudent = "Student 125";
        int grupa = 123;
        String email = "foo@bar.com";
        Student student = new Student(idStudent, numeStudent, grupa, email);
        Student student1 = service.addStudent(student);
        System.out.println("here");
        assertEquals(student1, student);
        service.deleteStudent(idStudent);
    }

    @Test
    public void addStudentTest_EmptyId(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        String idStudent = "";
        String numeStudent = "Student 123";
        int grupa = 123;
        String email = "foo@bar.com";
        Student student = new Student(idStudent, numeStudent, grupa, email);
        System.out.println("here");
        Assertions.assertThrows(ValidationException.class, () -> {
            service.addStudent(student);});
    }

    @Test
    public void addStudentTest_StudentExists(){
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        String idStudent = "120";
        String numeStudent = "Student 120";
        int grupa = 123;
        String email = "foo120@bar.com";
        Student student = new Student(idStudent, numeStudent, grupa, email);
        Student student1 = service.addStudent(student);
        System.out.println("here");
        assertEquals(student1, student);

        Student student2 = service.addStudent(student);
        assertEquals(student2, null);
    }
}
