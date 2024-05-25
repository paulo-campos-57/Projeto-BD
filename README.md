# Projeto-BD
Repositório direcionado ao projeto da disciplina de Banco de dados. Será desenvolvida uma aplicação que utiliza Java, MySQL e Spring de uma plataforma de jogadores de RPG.
Desenvolvido em sistemas Unix e  Windows.<br>
<img align="center" alt="Linux" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/linux/linux-original.svg">
<img align="center" alt="Windows" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/windows8/windows8-original.svg">
<img align="center" alt="Java" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" />
<img align="center" alt="MySQL" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original-wordmark.svg" />
<img align="center" alt="Spring" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" />

Para acessar nosso mini mundo, modelo lógico e conceitual do banco de dados, acesse o nosso <a href="https://drive.google.com/drive/folders/1HZWx1vfyhndgABlFYS2zlyD5e6y05Zbl?usp=drive_link">Drive</a>

# Requisitos
Para a execução desse projeto, é necessário preencher os seguintes requisitos:
<table>
  <tr>- Java 17 (JDK 17) ou superior</tr><br>
  <tr>- Apache Maven</tr><br>
  <tr>- MySQL Server</tr>
</table>


# Como rodar
Para rodar o proejto, é necessáiro seguir os seguintes passos:
<table>
  <tr>- Clone o repositório para a sua máquina usando o comando:
  <dt> 
  
    git clone https://github.com/paulo-campos-57/Projeto-BD.git

  </dt></tr>
  <tr>- Em seguida, copie e execute o script.sql em sua interface de banco de dados, em um banco chamado 'definitiva_taverna';</tr><br>
  <tr>- Acesse o arquivo 'application.properties', encontrado através do seguinte caminho: project_bd/src/main/resources/application.properties;</tr><br>
  <tr>- Dentro do arquivo, edite a seguinte linha:
    <dt> 
  
    spring.datasource.password=ServerPassword

  </dt>
  Subistituindo ServerPassword pela senha do seu MySQL;
  </tr><br>
  <tr>- Após estes passos, abra seu terminal na pasta do projeto onde se encotra o arquivo 'pom.xml', encontrado na pasta project_bd;</tr><br>
  <tr>- Em seu terminal, execute o seguinte comando: 
    <dt> 
  
    mvn clean install

  </dt>
  </tr>
  <tr>- Após isso, execute o arquivo ProjectBdApplication.java, encontrado através do seguinte caminho: project_bd/src/main/java/com/id/project_bd/ProjectBdApplication.java;</tr><br>
  <tr>- Enquanto a aplicação estiver em execução, acesse, através de seu browser, a url http://localhost:8080/</tr>
</table>

# Desenvolvedores
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/paixaoao">
        <img src="https://avatars.githubusercontent.com/u/126728380?v=4" width="100px;" alt="Foto Paixão"/><br>
        <sub>
          <b>Arthur Paixão</b>
        </sub>
      </a>
      <br>
      <sub>aptm@cesar.school</sub>
    </td>
    <td align="center">
      <a href="https://github.com/grossiter04">
        <img src="https://avatars.githubusercontent.com/u/116268469?v=4" width="100px;" alt="Foto Rossiter"/><br>
        <sub>
          <b>Gabriel Rossiter</b>
        </sub>
      </a>      
      <br>
      <sub>gsr@cesar.school</sub>
    </td>
    <td align="center">
      <a href="https://github.com/paulo-campos-57">
        <img src="https://avatars.githubusercontent.com/u/77108503?v=4" width="100px;" alt="Foto Paulo"/><br>
        <sub>
          <b>Paulo Campos</b>
        </sub>
      </a>      
      <br>
      <sub>pmc3@cesar.school</sub>
    </td>
  </tr>
</table>

# DB-Project
Repository aimed at the Database discipline project. An application will be developed that uses Java, MySQL, and Spring for an RPG player platform.
Developed in Unix and Windows systems.<br>
<img align="center" alt="Linux" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/linux/linux-original.svg">
<img align="center" alt="Windows" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/windows8/windows8-original.svg">
<img align="center" alt="Java" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" />
<img align="center" alt="MySQL" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original-wordmark.svg" />
<img align="center" alt="Spring" height="60" width="70" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" /> 

To access our mini-world, logical model, and conceptual model of the database, please visit our <a href="https://drive.google.com/drive/folders/1HZWx1vfyhndgABlFYS2zlyD5e6y05Zbl?usp=drive_link">Drive</a>

# Requirements
For this project to run, you'll need to meet the following requirements:
<table>
  <tr>- Java 17 (JDK 17) or superior</tr><br>
  <tr>- Apache Maven</tr><br>
  <tr>- MySQL Server</tr>
</table>

# How to Run

To run the project, follow these steps:
<table>
  <tr>- Clone the repository to your machine using the command:
  <dt> 
  
    git clone https://github.com/paulo-campos-57/Projeto-BD.git

  </dt></tr>
  <tr>- Next, copy and execute the script.sql in your database interface, in a database named 'definitiva_taverna';</tr><br>
  <tr>- Access the 'application.properties' file, found at the following path: project_bd/src/main/resources/application.properties;</tr><br>
  <tr>- Inside the file, edit the following line:
    <dt> 
  
    spring.datasource.password=ServerPassword

  </dt>
  Replace ServerPassword with your MySQL password;
  </tr><br>
  <tr>- After these steps, open your terminal in the project folder where the 'pom.xml' file is located, found in the project_bd folder;</tr><br>
  <tr>- In your terminal, execute the following command: 
    <dt> 
  
    mvn clean install

  </dt>
  </tr>
  <tr>- After that, run the ProjectBdApplication.java file, found at the following path: project_bd/src/main/java/com/id/project_bd/ProjectBdApplication.java;</tr><br>
  <tr>- While the application is running, access the url http://localhost:8080/ in your browser.</tr>
</table>

# Developers
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/paixaoao">
        <img src="https://avatars.githubusercontent.com/u/126728380?v=4" width="100px;" alt="Foto Paixão"/><br>
        <sub>
          <b>Arthur Paixão</b>
        </sub>
      </a>
      <br>
      <sub>aptm@cesar.school</sub>
    </td>
    <td align="center">
      <a href="https://github.com/grossiter04">
        <img src="https://avatars.githubusercontent.com/u/116268469?v=4" width="100px;" alt="Foto Rossiter"/><br>
        <sub>
          <b>Gabriel Rossiter</b>
        </sub>
      </a>      
      <br>
      <sub>gsr@cesar.school</sub>
    </td>
    <td align="center">
      <a href="https://github.com/paulo-campos-57">
        <img src="https://avatars.githubusercontent.com/u/77108503?v=4" width="100px;" alt="Foto Paulo"/><br>
        <sub>
          <b>Paulo Campos</b>
        </sub>
      </a>      
      <br>
      <sub>pmc3@cesar.school</sub>
    </td>
  </tr>
</table>
