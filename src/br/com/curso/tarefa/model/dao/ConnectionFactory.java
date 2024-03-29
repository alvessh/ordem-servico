package br.com.curso.tarefa.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static String status = "Não conectou...";

	//Método Construtor da Classe//

	public ConnectionFactory() {

	}

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null;          //atributo do tipo Connection



		try {

			// Carregando o JDBC Driver padrão

			String driverName = "com.mysql.jdbc.Driver";                        

			Class.forName(driverName); //registrar a classe do driver.



			// Configurando a nossa conexão com um banco de dados//

			String serverName = SERVER_NAME;    //caminho do servidor do BD

			String mydatabase =DATABASE_NAME;        //nome do seu banco de dados

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = DATABASE_USERNAME;        //nome de um usuário de seu BD      

			String password = DATABASE_PASSWORD;      //sua senha de acesso

			connection = DriverManager.getConnection(url, username, password);

			//Testa sua conexão//  

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return connection;

		} catch (ClassNotFoundException e) {  //Driver não encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

			//Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}
	}

	//Método que retorna o status da sua conexão//

	public static String statusConection() {

		return status;

	}

	//Método que fecha sua conexão//

	public static boolean FecharConexao() {

		try {

			ConnectionFactory.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}
	}

	//Método que reinicia sua conexão//

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();
		return ConnectionFactory.getConexaoMySQL();
	}
}
