# Historia de Usuario 1: Agregar Categorias de los productos

## Descripción
Esta rama contiene la implementación de la **Historia de Usuario 1 (HU1)** para el proyecto **Emazon**. La historia se centra en la funcionalidad que permite a un admin agregar una categoria.

## Funcionalidad
- Un Admin puede añadir una categoria.


## Estructura de Código
La implementación sigue los principios de la **arquitectura hexagonal** y **Atomic Design**. Los componentes están organizados de la siguiente manera:

- **Átomos**:
  - `Category`: Entidad que representa categoria de un producto.


- **Moléculas**:
  - `CategoryUsecase`: Servicio que maneja la lógica para permitir  agregar categorias.
  

## Configuración del Entorno
Para configurar y ejecutar esta rama localmente, sigue estos pasos:

1. **Clona el repositorio y cambia a la rama de la HU1**:
    ```bash
    git clone https://github.com/tu-usuario/tu-repo.git
    cd tu-repo
    git checkout feature/HU1-crear-categoria
    ```

2. **Instala las dependencias**:
    Asegúrate de que tienes [Gradle](https://gradle.org/) instalado en tu entorno.
    ```bash
    ./gradlew clean build
    ```

3. **Configura la base de datos**:
    Asegúrate de que la base de datos esté configurada correctamente en `src/main/resources/application.properties`. Para esta HU, se está utilizando una base de datos relacional MySql.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost/stock
    spring.datasource.username=root
    spring.datasource.password=password
    spring.flyway.enabled=true
    spring.flyway.locations=classpath:db/migration
    spring.flyway.baselineOnMigrate=true
    ```

4. **Ejecuta la aplicación**:
    ```bash
    ./gradlew bootRun
    ```

5. **Accede a la aplicación**:
   - Visita `http://localhost:8080` en tu navegador para acceder a la aplicación.
   - Navega a la página de detalles del producto para probar la funcionalidad de agregar al carrito.

## Tests Unitarios
Los tests unitarios para esta historia se encuentran en el paquete `src/test/java/com/emazon/`. Puedes ejecutar los tests con el siguiente comando:

```bash
./gradlew test
