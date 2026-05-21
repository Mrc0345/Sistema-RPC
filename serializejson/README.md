# Serialize JSON

Utilizando GSON

1. Criar projeto Maven
2. Adicionar dependência do pacote `gson` ao arquivo `pom.xml`

```xml
    <dependencies>
        <!-- Source: https://mvnrepository.com/artifact/com.google.code.gson/gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.13.2</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
```

3. Instalar dependência via IDE ou comando `mvn install`
4. Compilar projeto `mvn compile`
5. Executar.


### Dica
Para que o projeto gere um arquivo .jar para ser executado ou compartilhado, adicione a tag `build` ao seu `pom.xml` e execute o comando `mvn package`. Para executar utilize `java -jar target\serializejson-1.0-SNAPSHOT-jar-with-dependencies.jar`

```
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                        <configuration>
                            <archive>
                                <manifest>
                                    <mainClass>com.ramyres.Main</mainClass>
                                </manifest>
                            </archive>
                            <descriptorRefs>
                                <descriptorRef>jar-with-dependencies</descriptorRef>
                            </descriptorRefs>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```