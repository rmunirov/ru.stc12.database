package ru.innopolis.stc12.jdbc.realExample.pojo;

public class Group {
    private int id;
    private String name;
    private Teacher curator;

    public Group(int id, String name, Teacher curator) {
        this.id = id;
        this.name = name;
        this.curator = curator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }
}
