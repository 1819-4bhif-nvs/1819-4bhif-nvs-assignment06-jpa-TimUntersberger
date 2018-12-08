package at.htl.database.entity;

import at.htl.database.converter.LocalDateConverter;

import javax.persistence.Convert;
import java.time.LocalDate;

public class Person{
    protected String firstName;
    protected String lastName;
    @Convert(converter = LocalDateConverter.class)
    protected LocalDate birthday;
    protected Float salary;
}