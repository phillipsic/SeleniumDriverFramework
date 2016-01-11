package com.framework.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DB extends Main {

    private String ip;
    private String service_name;
    private String login;
    private String password;
    private PropertyHelper propsHelper = new PropertyHelper();

    public DB(String key) throws Exception {
        setIp(key);
        setService_name(key);
        setLogin(key);
        setPassword(key);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String key) {
        this.ip = propsHelper.getDBProperties(key + "_IP");
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String key) {
        this.service_name = propsHelper.getDBProperties(key + "_SERVICE_NAME");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String key) {
        this.login = propsHelper.getDBProperties(key + "_LOGIN");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String key) {
        this.password = propsHelper.getDBProperties(key + "_PASSWORD");
    }

    public Statement oracleDBStatement() throws Exception {
        return oracleDBCnx().createStatement();
    }

    public Connection oracleDBCnx() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@" + getIp() + ":1521/" + getService_name(), getLogin(), getPassword());

        return con;
    }

    public Statement mysqlDBStatement() throws Exception {
        return mysqlDBCnx().createStatement();
    }

    public Connection mysqlDBCnx() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + getIp() + ":3306/" + getService_name(), getLogin(), getPassword());

        return con;
    }

    public String execSQLSelect(Statement st, String sqlQuery, int columnId) throws Exception {
        String sqlResult = "";
        ResultSet rs = st.executeQuery(sqlQuery);
        Thread.sleep(2000);
        if (rs.next()) {
            sqlResult = rs.getString(columnId);
        }
        rs.close();

        return sqlResult;
    }

    public String execSQLSelectWithParam(Connection connection, String sqlQuery, int columnId, String param) throws Exception {
        String sqlResult = "";
        java.sql.PreparedStatement prepStmt = connection.prepareStatement(sqlQuery.replace("$param", param));
        ResultSet rs = prepStmt.executeQuery();
        Thread.sleep(2000);
        if (rs.next()) {
            sqlResult = rs.getString(columnId);
        }
        rs.close();

        return sqlResult;
    }

    public void execSQLUpdate(Statement st, String sqlQuery) throws Exception {
        st.executeUpdate(sqlQuery);
        Thread.sleep(2000);
    }

    public void execSQLUpdateWithParam(Statement st, String sqlQuery, String param) throws Exception {
        st.executeUpdate(sqlQuery.replace("$param", param));
        Thread.sleep(2000);
    }
}
