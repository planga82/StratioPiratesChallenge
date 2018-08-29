# Stratio Pirates Challenge

## Planteamiento funcional del reto

El sistema que se plantea en el reto tiene principalmente unos eventos que van sucediendo en el tiempo y necesitan ser almacenados para posteriormente ser consultados. Estos evento son la entrada o salida de un barco de un determinado puerto.

Tanto los barcos como los puertos tienen una determinada cantidad de monedas de oro y de barriles de ron. Cuando se produce un evento de entrada de un barco a un puerto, la cantidad de barriles y de monedas se suma a la cantidad que tenía el puerto. Cuando se produce un evento de salida de un barco de un puerto, la cantidad que transporta se resta de la del puerto.

Los servicios que se necesitan proporcionar deben proporcionar son tres:
* Listado de eventos en los que esta involucrado un barco pudiendo filtrar por tipo de evento(Entrada / Salida)
* Listado de eventos en los que esta involucado un puerto pudiendo filtrar por tipo de evento(Entrada / Salida)
* Consulta del stock de un determinado puerto en un momento dado.

Otro de los requerimientos del sistema consiste en que se pueda consultar la información que proporcionan los servicios desde cualqier puerto del mundo, para ello se va a emplear un sistema de palomas mensajeras de alta velocidad para intercambiar información entre los puertos.

Además otro requerimiento nos avisa de que la información puede ser robada de uno de los puertos, pero el sistema debe ser capaz de recuperarse de esos robos de información y seguir dando servicio. Para simplificar, considero "robo de información" al borrado de algún evento registrado en un puerto.


## Estructura del sistema

Bajo estos requerimientos, el sistema planteado se compone de los siguientes módulos.

* **Modulo principal**: Cada puerto tendra alojado un sistema que proporcionará los servicios indicados en el apartado anterior. Tendra un sistema de almacenamiento alojado en el puerto para la información que se almacena en el sistema. Se proporcionarán ademas los siguientes servicios adicionales:
	* Carga inicial del stock: Para realizar la carga inicial del sistema en el momento del arranque. este servicio permitirá la carga del stock del puerto en el momento del arranque del sistema.
	* Nuevo evento: Se proporcionará un servicio para que los piratas puedan alertar al sistema de que ha llegado o salido un barco.
	  
* **Modulo de consistecia**: Para poder cumpir los requerimientos de que el sistema proporcione la misma información en cualquier puerto del mundo y ademas se capaz de recuperarse ante robos de información, el sistema mantendrá la información replicada en todos los puertos
	* Replica de información: Cada vez que se produzca un evento en un puerto del mundo, este comunicará a traves de nuestro sistema de palomas de alta velocidad al resto de los puertos del mundo que este evento se ha producido, para que el resto de puertos lo almacenen tambien en sus sistema de almacenamiento. De esta manera, todos los puertos del mundo podrán responder de manera consistente una vez que esten sincronizados. Aunque evidentemente, en el tiempo que pasa entre que se produce el evento y se sincroniza en todos los puertos, el sistema no es perfectamente consistente y puede responder cosas diferentes dependiendo de a que puerto preguntes. Se controla ademas que la replica se ha producido correctamente en todos los puertos, de no se así se reintenta, y si tras x reintentos no se consigue, se almacena la información para notificarlo mas tarde.
	* Veríficación y recuperación ante robos: Existirá un proceso qu comprobará la consistencia de la información de todos los puertos. Cada cierto tiempo, este proceso pedírá e identificador de todos los eventos que tienen a todos los puertos, los validará unos contra otros para comprobar que no hay inconsistencias. En caso de haberlas, este proceso solicitará la información faltante a un puerto que la tenga y la actualizará en el puerto en la que la han robado.

## Solución técnica

El sistema se ha desarrollado en Java y usando Springboot. Cada uno de los servicios enumerados anteriormente se ha resuelto con servicios rest. La base de datos utilizada es H2, una implementación de una base de datos en memoria.

Cada puerto tendrá una aplicación levantada y se comunicarán entre ellas a traves de servicios rest también.

## Descripción del sistema

A continuación se pasa a describir en detalle los principales componentes técnicos del sistema y como se comportan.

* com.challenge.pirates.Application: Clase principal del sistema, con el main para arrancarla
* resources/application.properties: Propiedades principales para configurar el sistema.
* resources/Nodes.properties: Datos de todos los nodos que componen el sistema para poder intercomunicarse.
* com.challenge.pirates.controller: Paquete que contiene todos los servicios donde se pueden ver sus definiciones
* com.challenge.pirates.entities: Modelo de datos del sistema
* com.challenge.pirates.exceptions: Tratamiento de errores personalizado
* com.challenge.pirates.service: Clases que contienen la lógica de negocio.

## Cometarios de importancia

A continuación se detallan una serie de detalles a tener en cuenta del desarrollo.

* Test: La implementación de los test no esta completa, se han realizado unos pocos para el challenge, pero para un sistema real se deberían implementa todos de manera que hubiera la mayor cobertura de código posible.
* Validaciones webservice: Al igual que en los test, no se realiza una validación exhaustiva de los parámetros que pueden venir en los servicios web, para un sistema real si habría que realizarlo.
* Funciones transaccionales: Se ha usado la funcionalidad que proporciona springboot para que determinadas operaciones sean transaccionales de manera que de mantenga la consistencia del sistema.
* Actualizaciones asincronas: Para la replicación se han usado métodos asíncronos, de tal manera que no produzcan retrasos en la llamada principal en el momento de de realizar las réplicas entre todos los nodos.
* Procesos batch: os procesos batch descritos no estan implementados, pero si estan desarrollados los servicios que utilizarían. Los procesos batch son el de recuperación ante robos y el de reintento en diferido ante un fallo en la replica de información
* El sistema de logs y control de errores no esta depurado como en un sistema listo para producción, estan los minimos para el challenge.















