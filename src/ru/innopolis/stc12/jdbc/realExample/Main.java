package ru.innopolis.stc12.jdbc.realExample;

import ru.innopolis.stc12.jdbc.realExample.dao.DaoFactory;
import ru.innopolis.stc12.jdbc.realExample.dao.StudentDao;
import ru.innopolis.stc12.jdbc.realExample.pojo.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = DaoFactory.getStudentDao();
        System.out.println(studentDao.read(46));
        Sex sex = DaoFactory.getSexDao().read(1);
        Group group = DaoFactory.getGroupDao().read(1);
        City city = DaoFactory.getCityDao().read(2);
        Student student = new Student(74,
                "Nikolai",
                "Shevchenko",
                sex,
                new Date(),
                group,
                new PersonalData(44, new Date(), city, "ul. Lenina, 73-87", "+79581256366", "nikola@mail.ru"));
        //studentDao.create(student);
        student.setSurname("Subbotin");
        studentDao.update(student);
        //studentDao.delete(74);
        System.out.println(studentDao.getAll());
    }

}
