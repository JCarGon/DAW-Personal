# Explicación API Notes

Esta API está diseñada para consultar, crear, modificar y/o eliminar notas (archivo.note) mediante peticiones en un servidor creado con express. Dichas notas se crearán en el fichero './notes'.

> [!CAUTION]
> Para utilizar esta API necesitarás crear un archvo .env con variables de entorno, las cuales deberás contactar con el administrador de esta API, ya que encontrarás las variables necesarias en el archivo '.env.template', pero no encontrarás el contenido de las variables.

> [!IMPORTANT]
> Lo primero que se debe realizar antes de arrancar el proyecto para evitar problemas es instalar las dependencias necesarias, ejecutando el comando:
> ~~~
> npm install
> ~~~
>Hay veces que no las instala todas y hay que instalar alguna de manera concreta con:
> ~~~
> npm install 'dependency-name'
> ~~~

## Routes

- Las diferentes rutas de la API las podrás encontrar en './src/routes/index.js'.
- En el mismo directorio, encontrarás un archivo 'notes.js' que contiene las diferentes peticiones a los endpoints '/notes'.

> [!NOTE]
> Encontrarás ciertos métodos que requieren de autorización/autenticación.

Esta autorización/autenticación ha sido generada con JsonWebToken (JWT), utilizando también 'bcrypt' para encriptar y comparar contraseña entrante de la petición con contraseña encriptada.

## Middlewares

> [!NOTE]
> Los encontrarás en el directorio './src/middlewares/'.

Se han utilizado middlewares para:
- Comprobar si la petición lleva una password en la cabecera.
- Comprobar si esa password es la correcta.
- Autenticar el token con JWT (comprobar si ha sido generado correctamente y si sigue siendo válido).
- Control de error genérico para los Internal Servere Error (status code 500).
- Imprimir por consola la fecha en la que se ha hecho la petición, el tipo de petición realizada y el path al cual se ha realizado la petición.

## Peticiones

> [!IMPORTANT]
> En las peticiones solo se deberá inlcuir el nombre de la nota, no es necesario incluir la terminación/extensión del archivo '.note' (se le incorpora en la lógica de la petición).

En esta API podrás realizar las siguientes peticiones:
- Login para registrarte y obtener autenticación para ciertas peticiones.
- Listar las notas existentes en el directorio.
- Lista una nota concreta existente en el directorio con su contenido.
- Crear una nota.
- Editar una nota añadiendo contenido o sustituyéndolo al completo.
- Eliminar una nota.

La información sobre cada una de las peticiones que se pueden hacer a la API la encontrarás en el **swagger**, el cual:
- Está ubicado en './src/openapi/openapi.yml'.
- Una vez arrancado el servidor en local, deberás entrar a 'localhost:PORT/api-docs' (indicado en './src/loaders/express-loader.js').

## Lógica de peticiones

> [!NOTE]
> Los encontrarás en el directorio './src/controllers/'.

Dentro de este directorio encontraremos dos archivos:
- 'misc-controller.js': contiene la infocmación de los usuarios que pueden hacer login y la lógica de la petición de Login.
- 'note-controller.js': contiene la lógica de todas las peticiones que se pueden hacer a los diferentes endpoints relacionados con 'notes'.

## Postman collection

Encontrarás los archivos necesarios para importar, tanto la colección de postman con las peticiones creadas y listas para ejecutarse ('Notas.postman_collection.json'), como el archivo que contiene el entorno ('API-Notes.postman_environment') en la raíz del proyecto.
