# Build
mvn clean package && docker build -t pl.fis.szymon.gretka/lbd-library .

# RUN

docker rm -f lbd-library || true && docker run -d -p 8080:8080 -p 4848:4848 --name lbd-library pl.fis.szymon.gretka/lbd-library 