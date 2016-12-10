OrganikFreshShop
-----------------------------------------------------------------------------------------------------------------------------
Project demo website https://organikfreshshop.com cho đồ án môn học
-----------------------------------------------------------------------------------------------------------------------------
Nhóm sinh viên thực hiện :
-----------------------------------------------------------------------------------------------------------------------------
 - Nguyễn Viết Thành Sơn 
 - Đặng Trung Hiếu
 - Đỗ Đình Nam
 - Phạm Trung Tính
 - Bùi Đức Hưng
-----------------------------------------------------------------------------------------------------------------------------
Project sử dụng các frameworks sau : 
-----------------------------------------------------------------------------------------------------------------------------
- Spring-Security-3.2.5
- Spring-MVC-4.3.4
- Spring-Core-4.3.4
-----------------------------------------------------------------------------------------------------------------------------
Một số thư viện mở rộng :
-----------------------------------------------------------------------------------------------------------------------------
- Apache-Common-Upload-1.3.1
- Apache-Common-Validator-1.5.1
- Mariadb-Java-Client-1.5.5 1.5.5 
-----------------------------------------------------------------------------------------------------------------------------
- DBMS : MariaDB 10.1.11
- Webserver : Apache Tomcat 9
-----------------------------------------------------------------------------------------------------------------------------
Hướng dẫn build project : 
- Project có thể build bằng tay hoặc sử dung Apache Maven 3.0.5 
- Nếu sử dụng Maven : ( hướng dẫn trên intellJ idea 15 )
-----------------------------------------------------------------------------------------------------------------------------
- Step 1 : New Project -> Maven 
- Step 2 : chọn org.apache.maven.archtype:maven-archtype-webapp
- Step 3 : set up group id và artifactid
- Step 4 : set up các dependencies cho pom.xml như sau ( tốt nhất là chọn auto import cho Maven để intellJ tự import khi mình thêm các dependency ) :

    <dependencies>
 
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
 
        <!-- Servlet API -->
        <!-- http://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
 
        <!-- Jstl for jsp page -->
        <!-- http://mvnrepository.com/artifact/javax.servlet/jstl -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

 
        <!-- JSP API -->
        <!-- http://mvnrepository.com/artifact/javax.servlet.jsp/jsp-api -->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
            <scope>provided</scope>
        </dependency>
         
       <!-- Apache Commons FileUpload -->
       <!-- http://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
       <dependency>
           <groupId>commons-fileupload</groupId>
           <artifactId>commons-fileupload</artifactId>
           <version>1.3.1</version>
       </dependency>        
 
        <!-- Spring dependencies -->
        <!-- http://mvnrepository.com/artifact/org.springframework/spring-core -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.2.5.RELEASE</version>
        </dependency>
 
        <!-- http://mvnrepository.com/artifact/org.springframework/spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>4.2.5.RELEASE</version>
        </dependency>
 
        <!-- http://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>4.2.5.RELEASE</version>
        </dependency>
 
        <!-- http://mvnrepository.com/artifact/org.springframework/spring-orm -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>4.2.5.RELEASE</version>
        </dependency>
 
        <!-- Spring Security Artifacts - START -->
        <!-- http://mvnrepository.com/artifact/org.springframework.security/spring-security-web -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>4.0.4.RELEASE</version>
        </dependency>
 
        <!-- http://mvnrepository.com/artifact/org.springframework.security/spring-security-config -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>4.0.4.RELEASE</version>
        </dependency>
 
        <!-- http://mvnrepository.com/artifact/org.springframework.security/spring-security-taglibs -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-taglibs</artifactId>
            <version>4.0.4.RELEASE</version>
        </dependency>
         
        <!-- Spring Security Artifacts - END -->
 
        <!-- Hibernate -->
        <!-- http://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.1.0.Final</version>
        </dependency>
 
        <!-- http://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.1.0.Final</version>
        </dependency>
 
 
        <!-- http://mvnrepository.com/artifact/org.hibernate/hibernate-c3p0 -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-c3p0</artifactId>
            <version>5.1.0.Final</version>
        </dependency>
 
 
        <!-- MySQL JDBC driver -->
        <!-- http://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.34</version>
        </dependency>
 
        <!-- Oracle JDBC driver -->
        <dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc6</artifactId>
            <version>11.2.0.3</version>
        </dependency>
 
        <!-- SQLServer JDBC driver (JTDS) -->
        <!-- http://mvnrepository.com/artifact/net.sourceforge.jtds/jtds -->
        <dependency>
            <groupId>net.sourceforge.jtds</groupId>
            <artifactId>jtds</artifactId>
            <version>1.3.1</version>
        </dependency>
 
        <!-- Email validator,... -->
        <!-- http://mvnrepository.com/artifact/commons-validator/commons-validator -->
        <dependency>
            <groupId>commons-validator</groupId>
            <artifactId>commons-validator</artifactId>
            <version>1.5.0</version>
        </dependency>
 
    </dependencies>
    
  -step 5 : chờ thôi :) - thỉnh thoảng maven import rất lâu, cách 2 là build bằng tay ( clone project trên ) => để customize webserver và một số thư viện khác ( kiểu có thể tùy biến dùng Glassfish hoặc JBoss ..v.v )
  -----------------------------------------------------------------------------------------------------------------------------
    -Deploy lên web server , export project ra file "OrganicFreshShop.war" rồi đặt vào webapps của Tomcat , sau đó khởi động Tomcat  bằng lệnh : " user@user $ ~ /path/to/bin/Tomcat/../bin/catalina.sh start", nó hiện thế này là ok nhé ( có thể báo lỗi nên cần chage permission cho web server nhé ) :
    -----------------------------------------------------------------------------------------------------------------------------
    ->Using CATALINA_BASE:   /root/Web Server/Apache Tomcat/apache-tomcat-9.0.0.M10
    ->Using CATALINA_HOME:   /root/Web Server/Apache Tomcat/apache-tomcat-9.0.0.M10
    ->Using CATALINA_TMPDIR: /root/Web Server/Apache Tomcat/apache-tomcat-9.0.0.M10/temp
    ->Using JRE_HOME:        /usr
    ->Using CLASSPATH:       /root/Web Server/Apache Tomcat/apache-tomcat-9.0.0.M10/bin/bootstrap.jar:/root/Web Server/Apache Tomcat/apache-tomcat-9.0.0.M10/bin/tomcat-juli.jar
    ->Tomcat started.
    -----------------------------------------------------------------------------------------------------------------------------
    -Đường dẫn thay đổi theo localhost nhé ,bây giờ có thể test trên localhost qua URL : http://127.0.0.1:8080/OrganicFreshShop/index => OK thế là xong việc build project để code và deploy thử nghiệm trên Tomcat.
