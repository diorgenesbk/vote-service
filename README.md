Rodar a aplicação localmente
 - executar na raíz do projeto:
    - gradlew build
    - docker-compose up -d --build
    - rodar no banco os scripts de inicialização disponíveis em:
      - https://github.com/diorgenesbk/vote-database
    
Rodar a aplicação em nuvem
 - executar na raíz do projeto:
    - kubectl apply -f .\k8s\deployment.yaml
    - kubectl apply -f .\k8s\service.yaml
    - rodar no banco os scripts de inicialização disponíveis em:
      - https://github.com/diorgenesbk/vote-database