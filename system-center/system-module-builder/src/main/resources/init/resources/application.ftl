spring:
  application:
    name: system-${projectName}
  profiles:
    active: ${r'@environment@'}
server:
  port: 8080
mybatis-plus:
  type-aliases-package: ${packageBaseParent}.model
  mapper-locations: classpath:mapper/*.xml
  global-config:
    banner: false
swagger:
  contact:
    name: "${author}"
    email: "dingdangmaoup@vip.qq.com"
    url: "https://kuroneko.fun"
  enabled: true
  base-package: ${packageBaseParent}
  version: 1.0.0
  title: ${projectName}



