# Etapa 2: Ejecución
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el .jar construido desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expone el puerto 9080
EXPOSE 9080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]