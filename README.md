For ActiveMQ you do not need any ConnectionFactory as Spring provides a ConnectionFactory for AMQ.

For RabbitMQ we need a ConnectionFactory and hence the class com.test.jms.factory.ConnFactory.java

Steps to test this application:

Download ActiveMQ and Start AMQ, 

a) Start RabbitMQ

Run this application and use the below rest URI to test

To Produce Message:

GET http://localhost:8080/produce?msg="Hello Folks!!!"

To Consume the Produced Message - One message at a time.

GET http://localhost:8080/consume

After testing this sucessfully,

a) You can now Stop RabbitMQ, 

b) Comment @Configuration annotation of ConnFactory Bean

c) Start ActiveMQ and perform the same test again

To Produce Message:

GET http://localhost:8080/produce?msg="Hello Folks!!!"

To Consume the Produced Message - One message at a time.

GET http://localhost:8080/consume

Enjoy!!!!
