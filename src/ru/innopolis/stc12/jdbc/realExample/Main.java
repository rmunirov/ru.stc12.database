package ru.innopolis.stc12.jdbc.realExample;

import ru.innopolis.stc12.jdbc.realExample.dao.StudentDao;
import ru.innopolis.stc12.jdbc.realExample.dao.StudentDaoImpl;
import ru.innopolis.stc12.jdbc.realExample.pojo.Student;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student(0, "Alex", "Pushkin", 59, "ajsdkljhfskl@list.ru", 5);
        studentDao.addStudent(student);
        Student student1 = studentDao.getStydentById(4);
        studentDao.deleteStudentByName(student1);
        System.out.println(student1);

    }
}
