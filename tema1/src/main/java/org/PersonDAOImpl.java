package org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConnectionProvider;

public class PersonDAOImpl implements PersonDAO {
	static Connection con;
	static PreparedStatement ps;

		@Override
		public int insertPerson(Person person) {
			int status=0;
			try {
				con=ConnectionProvider.getConnection();
				ps=con.prepareStatement("insert into person values(?,?)");
				ps.setString(1, person.getName());
				ps.setString(2, person.getEmail());
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			return status;
		}

		@Override
		public Person getPerson (String name, String email) {
			Person person=new Person();
			try {
				con=ConnectionProvider.getConnection();
				ps=con.prepareStatement("select * from person where name=? and email=?");
				ps.setString(1, name);
				ps.setString(2, email);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					person.setName(rs.getString(1));
					person.setEmail(rs.getString(2));
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}


	}

