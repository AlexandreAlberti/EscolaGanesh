Prerequisites:
	* Have docker comandline tools installed
	* Have maven installed.
	* May require brew.

On 1st terminal TAB:
	* Make safe directory (Only Once) 
		- "mkdir /Users/EscolaGanesh/mysql"
	* Create volume-data
		- docker create --name mysql_data arungupta/mysql-data-container
	* Run DB:
		- docker run --name mysqldb --volumes-from mysql_data -v /Users/Alex/mysql:/var/lib/mysql -e MYSQL_USER=test -e MYSQL_PASSWORD=pass -e MYSQL_DATABASE=db -e MYSQL_ROOT_PASSWORD=test_pass -it -p 3306:3306 mysql

On 2nd terminal TAB:
	* Go Server Folder:
		- mvn spring-boot:run

On 3rd terminal TAB:
	* Go Angular Folder:
		- ng serve

Open "http://localhost:4200"