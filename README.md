Pong Game v1.0
==============

Running
--------

(*) Only run Test.java (main class).
	
	Create a server:

		> if player wants to start a server: Press [S].
	
		> Enter a port number for start the server.
	
		> Enter a player/user name.

		> Waiting for client player/user.

	Connect a server:

		> if player wants to connect a server: Press [C].
		
		> Enter server's IP address.

		> Enter server's Port number.

		> Enter a player/user name.


Class Structures of the Game
-----------------------------

(*) Test.class: Main Class -> Main Menu for starting server or client player. 

(*) PongServer.class: Server class -> Starting server, render frames, gets inputs and sets
outputs, checking collisions and managing game network and objects.

(*) PongClient.java:  Client class -> Connecting a server, render frames, gets inputs and 
communicates with server.

(*) PlayerServer.java: Contains the player's properties, ball's properties and game score. 
This object is sent to the client by the server.

(*) PlayerClient.java: Contains the player's properties. This object is sent to the server 
by the client.


Game Playing
-------------

	Controls: 
		
		> Move bar: Up / Down - Arrow Keys
