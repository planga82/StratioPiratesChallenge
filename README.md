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
	* Replica de información: Cada vez que se produzca un evento en un puerto del mundo, este comunicará a traves de nuestro sistema de palomas de alta velocidad al resto de los puertos del mundo que este evento se ha producido, para que el resto de puertos lo almacenen tambien en sus sistema de almacenamiento. De esta manera, 












