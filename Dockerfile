FROM openjdk:17
EXPOSE 9090
ADD target/tarefa.jar tarefa.jar
ENTRYPOINT [ "java","-jar","tarefa.jar" ]