FROM alpine:3.19 AS builder
RUN apk add --no-cache build-base
WORKDIR /app
COPY hello.c .
RUN gcc -static hello.c -o hello

FROM alpine:3.19
WORKDIR /app
COPY --from=builder /app/hello .
CMD ["./hello"]
