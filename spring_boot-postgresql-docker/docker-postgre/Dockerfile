FROM alpine:3.7

RUN apk update && \
    apk add wget ca-certificates

RUN wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add - && \
    sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" >> /etc/apt/sources.list.d/pgdg.list'

RUN apk update && \
    apk add postgresql postgresql-contrib

ENTRYPOINT [ "/bin/ash" ]