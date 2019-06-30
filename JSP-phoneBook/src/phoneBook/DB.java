package phoneBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    private Connection connection;
    private PreparedStatement statement;

    public DB() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:42333/PhoneBook?user=root&password=root");
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }

    public int check(String userName, String password) throws Exception {
        statement = connection.prepareStatement("SELECT userName, password FROM user WHERE userName=?");
        statement.setString(1, userName);
        ResultSet result = statement.executeQuery();
        if(result.next())
        {
            String dbUserName = result.getString("userName");
            String dbPassword = result.getString("password");

            if (password.equals(dbPassword) && userName.equals(dbUserName))
                return 200;
            if (userName.equals(dbUserName))
                return 403;
            else return 404;
        }
        else return 404;
    }

    public void print() throws Exception
    {
        statement = connection.prepareStatement("SELECT * FROM user");
        ResultSet result = statement.executeQuery();

        while (result.next())
        {
            System.out.println(result.getString("userName"));
        }
    }

    public void close() throws Exception
    {
        statement.close();
        connection.close();
    }

}
