# BOTIQUIN-DE-CONFIANZA
Botiquín de Confianza — Descripción del proyecto
¿Qué es?
Es un sistema de gestión inteligente de medicamentos para un botiquín doméstico o pequeño, desarrollado en Java. Su propósito es eliminar los tres problemas clásicos de un botiquín sin control: medicamentos vencidos que nadie sacó, pastillas que se agotan sin que nadie lo note, y confusión entre presentaciones distintas del mismo medicamento.
El sistema sabe exactamente qué tiene, cuánto tiene de cada cosa, en qué orden debe usarse y cuándo necesita reponerse — sin que el usuario tenga que rastrear nada manualmente.

Cómo organiza los medicamentos
El sistema maneja los medicamentos en dos niveles anidados, como cajones dentro de cajones.
El primer nivel agrupa por marca o nombre genérico. Todo lo que es Dolex vive en un cajón llamado Dolex. Todo lo que es Amoxicilina vive en otro. Esto permite encontrar rápido lo que se busca.
El segundo nivel, dentro de cada cajón, separa por dosificación. El Dolex de 500 mg tiene su propia fila. El de 250 mg tiene la suya. El de 100 mg tiene la suya. Cada fila es completamente independiente: su propio inventario, su propio mínimo configurado y su propia alerta. Así nunca se confunde una dosis de adulto con una de niño.

Cómo maneja el orden de uso
Cada fila de medicamentos funciona como una cola FIFO — primero en entrar, primero en salir. Cuando se agregan pastillas nuevas, entran al final de la fila. Cuando se usa una, sale la que lleva más tiempo guardada. Esto garantiza automáticamente que los medicamentos más antiguos (y con fecha de vencimiento más próxima) se usen primero, sin que el usuario tenga que revisar fechas ni reorganizar nada.

Qué hace
Agregar medicamentos — El usuario indica el nombre, la dosificación y la cantidad. El sistema los coloca al final de la fila correcta. Si el medicamento o la presentación no existe todavía, el sistema crea el grupo automáticamente.
Usar medicamentos — El usuario indica qué necesita y cuántas unidades. El sistema saca exactamente esa cantidad desde el frente de la fila correspondiente (las más antiguas primero), verifica que haya suficiente stock antes de descontarlo, y al terminar compara el inventario restante contra el mínimo configurado.
Alertas de stock bajo — Cada presentación tiene un mínimo recomendado configurable. El sistema no interrumpe al usuario con alarmas inesperadas. El aviso aparece en dos momentos exactos: justo después de completar una acción (agregar o usar), y como recordatorio visible justo antes de que el usuario ejecute la siguiente acción. El flujo nunca se corta, pero el usuario siempre está informado.
Revisión general del botiquín — En cualquier momento el usuario puede pedir un reporte completo. El sistema recorre todo el inventario e informa qué medicamentos están por debajo de su mínimo, cuáles tienen unidades suficientes y cuántas unidades hay de cada presentación. Esta revisión también se ejecuta automáticamente cada vez que se elimina o consume un medicamento.
Control de vencimientos — Dado que la estructura FIFO garantiza que se use primero lo que entró primero, y cada medicamento almacena su fecha de vencimiento, el sistema puede detectar y advertir si el próximo en salir ya está vencido o próximo a vencer antes de entregarlo.

Lo que el sistema no hace (y por qué eso es una decisión correcta)
No tiene interfaz gráfica en esta versión. No conecta con bases de datos externas. No maneja usuarios ni roles. Esas son características de fases posteriores — la fase final que describes es un sistema de consola funcional y completo, donde toda la lógica de negocio está correctamente implementada. Eso es exactamente lo apropiado para un proyecto de estructuras de datos: demostrar que la lógica funciona antes de agregarle capas de presentación.
