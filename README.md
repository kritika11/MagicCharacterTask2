### MagicCharacter Application

This application runs on AWS ElasticBeanStalk and has a MySQL database hosted on AWS RDS.

It has different layers for CRUD operations: model, repository, service and controller. It also makes use of a custom serializer to serialize the response.

The application response can be seen on: http://magiccharacter-env.eba-bx3iaaif.ap-south-1.elasticbeanstalk.com/characters