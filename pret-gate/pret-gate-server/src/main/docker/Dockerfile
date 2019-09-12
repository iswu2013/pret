FROM livingobjects/jre8
VOLUME /tmp
ADD  pert-gate-server-1.0-SNAPSHOT.jar app.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
