package erudite.maotronics.com.erudite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Backend extends SetAndGet {

    Statement stmt = null;
    int year;
    ResultSet rs;
    String URL = "jdbc:mysql://localhost/", user = "maotronics", pass = "MAOtronics45";
    public Backend(String subject, int year) {
        this.URL = URL + subject;
        this.year = year;
    }


    public void Load(int qNumber) {

        try {
            Connection c = DriverManager.getConnection(URL, user, pass);
            c.setAutoCommit(false);
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + year + " where "
                    + "sn=" + qNumber
                    + ";");
            while (rs.next()) {
                int id = rs.getInt("sn");
                String question = rs.getString("question");
                String option1 = rs.getString("opt1");
                String option2 = rs.getString("opt2");
                String option3 = rs.getString("opt3");
                String option4 = rs.getString("opt4");
                String correctAnswer = rs.getString("ans");
                setQuestion(question);
                setAns(correctAnswer);
                setOption1(option1);
                setOption2(option2);
                setOption3(option3);
                setOption4(option4);

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
}
