sudo docker load < /jenkins/images_tar/vue.tar
sudo docker load < /jenkins/images_tar/django.tar
sudo docker load < /jenkins/images_tar/spring.tar

if (sudo docker ps | grep "vue"); then sudo docker stop vue; sudo docker rm vue; fi
if (sudo docker ps | grep "django"); then sudo docker stop django; sudo docker rm django; fi
if (sudo docker ps | grep "spring"); then sudo docker stop spring; sudo docker rm spring; fi

sudo docker run -it -d -p 80:80 -p 443:443 -v /etc/letsencrypt/:/etc/letsencrypt/ -v /jenkins/workspace/whatsub/django/staticfiles:/home/ubuntu/staticfiles --name vue whatsub/vue
echo "Run Vue-Nginx Container"
sudo docker run -it -d --rm -p 8000:8000  --name django whatsub/django
echo "Run Django Container"
sudo docker run -it -d --rm -p 8081:8081  --name spring whatsub/spring
echo "Run Spring Container"
