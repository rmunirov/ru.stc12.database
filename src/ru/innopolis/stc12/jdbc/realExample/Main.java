package ru.innopolis.stc12.jdbc.realExample;

import ru.innopolis.stc12.jdbc.realExample.dao.GenericDao;
import ru.innopolis.stc12.jdbc.realExample.dao.StudentDao;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

public class Main {
    public static void main(String[] args) {
        GenericDao genericDao = new StudentDao();
        Student student = new Student(0, "Alex", "Pushkin", 59, "ajsdkljhfskl@list.ru", 5);
        genericDao.addStudent(student);
        Student student1 = genericDao.getStydentById(4);
        genericDao.deleteStudentByName(student1);
        System.out.println(student1);

    }
}
