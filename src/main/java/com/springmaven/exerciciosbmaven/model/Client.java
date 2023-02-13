package com.springmaven.exerciciosbmaven.model;

public class Client {

    private int id;
    private int age;
    private String name;
    private String cpf;

    public Client() {
    }

    public Client(int age, String name, String cpf){
        this.age = age;
        this.name = name;
        this.cpf = cpf;
    }

    public Client(int id, int age, String name, String cpf){
        this.cpf = cpf;
        this.age = age;
        this.name = name;
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
