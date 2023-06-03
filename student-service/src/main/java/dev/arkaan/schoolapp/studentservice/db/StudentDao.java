package dev.arkaan.schoolapp.studentservice.db;

import org.jdbi.v3.sqlobject.SqlObject;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

public interface StudentDao extends SqlObject {

    @SqlQuery("SELECT first_name FROM student;")
    List<String> getAllFirstName();

    @SqlQuery("SELECT last_name FROM student;")
    List<String> getAllLastName();
}