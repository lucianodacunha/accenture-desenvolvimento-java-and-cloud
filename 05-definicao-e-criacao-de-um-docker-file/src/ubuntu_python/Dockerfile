FROM ubuntu

RUN apt update && apt install -y python3 && apt clean

COPY app.py /home/ubuntu/app.py

CMD ["python3", "/home/ubuntu/app.py"]
