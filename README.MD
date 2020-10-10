# openapi-sdk简介
    该项目用于对接开放平台，包含openapi-client和openapi-demo工程
    
## openapi-client
    1、在工程目录下，按功能创建模块
    2、编写对应的Client代码
    3、编辑结束后，执行mvn clean package，会自动将openapi-client.jar文件copy到openapi-demo工程的lib目录下

## openapi-demo
    1、该工程用于对外提供demo
    2、lib目录包含对外提供的jar包
    3、doc目录包含对外提供的文档，文档编写结束后，重新生成index.html
    3、编写结束后，执行package.sh脚本，该脚本会在target目录下生成openapi-demo.zip文件，直接将zip文件提供给第三方