# Circuit Breaker

El "Circuit Breaker" (Interruptor de Circuito) es un patrón de diseño utilizado en el desarrollo de software para mejorar la **tolerancia a fallos** y **la resiliencia** de los sistemas distribuidos. Este patrón se utiliza especialmente en arquitecturas de microservicios y sistemas distribuidos donde las dependencias externas pueden fallar y afectar el funcionamiento de todo el sistema.

El concepto del Circuit Breaker se basa en el interruptor de circuito eléctrico: cuando hay un problema con un componente externo (por ejemplo, una llamada a una API externa), el Circuit Breaker "abre el circuito", evitando que más llamadas se realicen a ese componente durante un período de tiempo definido. Esto evita la propagación de fallos y permite que el sistema se recupere de manera más eficaz.

Cuando el Circuit Breaker está en estado "abierto", las llamadas a la dependencia externa son interceptadas y se ejecuta una lógica de fallback (alternativa) en su lugar, como retornar un valor predeterminado o un mensaje de error. Después de un cierto tiempo de espera o un número determinado de intentos fallidos, el Circuit Breaker puede intentar nuevamente comunicarse con la dependencia externa para verificar si se ha recuperado.

## Beneficios

1. **Aislamiento de fallos**: Evita que los fallos en una dependencia externa afecten todo el sistema.
2. **Mejora de la resiliencia**: Ayuda al sistema a recuperarse de fallos de manera más rápida y eficiente.
3. **Prevención de la degradación del servicio**: Evita la sobrecarga de una dependencia externa que ya está experimentando problemas.

![Alt text](/esquema_del_ejemplo.png?raw=true "Optional Title")

