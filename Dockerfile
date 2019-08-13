FROM airhacks/glassfish
COPY ./target/lbd-library.war ${DEPLOYMENT_DIR}
