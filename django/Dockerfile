FROM python:3.9.10
WORKDIR /var/jenkins_home/workspace/whatsub/django

COPY requirements.txt ./
RUN pip install --upgrade pip
RUN pip install -r requirements.txt

COPY . .
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
