# building my own web server from scratch... (using java)

## overview
What is required from a webserver?
 - A webserver is a application that opens up connections between clients and servers to communicate with each other
 - The language or the protocal it usees to communicate is HTTP
 - The method it uses to communicate using HTTP is through sockets (network sockets)
 - servers can vary from serving static files to serving simple messages 
 - web pages are served using html files...

## version-1
version-1 is a simple echo server sending bytes between the server and the client applications,
where the server simply repeats or echos what the client sends it...