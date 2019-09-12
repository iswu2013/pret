FROM livingobjects/jre8
VOLUME /tmp
ADD  pert-open.jar app.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
