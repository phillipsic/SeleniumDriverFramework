package com.comverse.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.comverse.css.common.PropertyHelper;

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

    public Statement oracleDBcnx() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@" + getIp() + ":1521/" + getService_name(), getLogin(), getPassword());

        return con.createStatement();
    }

    public Statement mysqlDBcnx() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://" + getIp() + ":3306/" + getService_name(), getLogin(), getPassword());

        return con.createStatement();
    }

    public String execSQL(Statement st, String sqlQuery, int columnId) throws Exception {
        String sqlResult = "";
        ResultSet rs = st.executeQuery(sqlQuery);

        if (rs.next()) {
            sqlResult = rs.getString(columnId);
        }
        rs.close();

        return sqlResult;
    }

}
