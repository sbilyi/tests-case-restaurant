Background

You are a senior developer at ACME Games an online casual gaming company. The company has more than 1 million daily active users playing games online. The site however does not have a game of rock, paper, scissors. This is now the most requested game by the users of the site. The CTO of the company wants you to develop the game and deploy it to production.

Task

Write a program that plays Rock, Paper, Scissors against a human. Try to exploit that humans are very bad at generating random numbers.
You are only required to code the server-side components.

Deliverable

1.	The assignment should be delivered as a web application that allows the user to start the game, make moves, terminate the game and observe the statistics. A user interface is not expected.

2.	This is an open assignment in terms of how you structure the solution. You will be judged on the overall quality of the code (simplicity, restauranttation, performance).


```sh
##check all menu items
$  curl -X GET http://localhost:8080/api/menu_item/
  {  
     "id":4,
     "userId":"sergii",
     "userMove":"PAPER",
     "systemMove":"PAPER",
     "winner":"NONE"
  }

##create new menu item
$  curl -X POST http://localhost:8080/api/menu_item {  
     "title":"sandwich",
     "image":"https://",
     "description":"some sandwich"
  }
```

To access db we need to enter mysql image via docker execute command
```sh
$ docker exec -it rock-paper-scissors-mysql "/bin/bash"
$ docker exec -it rock-paper-scissors-mysql sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD" rock-paper-scissors'
```

To run with in memory db
```
$ mvn -DskipTests clean package && java -jar -Dspring.config.location=classpath:inmemory-application.properties target/restaurant-1.0-SNAPSHOT.jar
```

To run in docker
```
$ docker-compose up --build  
```

To reset docker DB:
```
$ docker rm $(docker ps -a -q) -f
$ docker volume prune

```

