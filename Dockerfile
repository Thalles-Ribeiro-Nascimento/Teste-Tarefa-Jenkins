FROM openjdk:17
EXPOSE 8095
ADD target/tarefa.jar tarefa.jar
ENTRYPOINT [ "java","-jar","tarefa.jar" ]