package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlCon {

        private static Connection con;
        MySqlCon(){

        }

        public static Connection getConnection () {

            if (MySqlCon.con != null) {

                return MySqlCon.con;

            } else {

                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin_online", "root", "");

                    return con;

                } catch (Exception e) {
                    System.out.println(e);
                    return null;
                }

            }
        }

    }


