package projects;

import projects.dao.DbConnection;
//Driver Manager connecting the code to the database URL
public class ProjectsApp {
	 public static void main(String[] args) {
	 DbConnection.getConnection();
	 }
}
