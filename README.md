Pong Game v1.0
==============

Running
--------

(*) Only run Test.java (main class).
	
	*Create a server:

		> if player wants to create a new server: Press Key [S].
	
		> Enter a port number for connection.
	
		> Enter a player/user name.

		> Wait client other player/user to start game.

	*Connect a server:

		> if player wants to connect a server: Press Key [C].
		
		> Enter server IP address.

		> Enter server Port number.

		> Enter a player/user name.


Class Structures of the Game
-----------------------------

(*) Test.class: Main Class -> Main Menu for create a server or connect as client. 

(*) PongServer.class: Server class -> Create a server, render frames, gets inputs and sets
outputs, checking collisions and managing game network and objects.

(*) PongClient.java:  Client class -> Connecting to server, render frames, gets inputs and 
communicates with server.

(*) PlayerServer.java: Contains the player's properties, ball's properties and game score. 
This object is sent to the client by the server.

(*) PlayerClient.java: Contains the player's properties. This object is sent to the server 
by the client.


Game Playing
-------------

	Controls: 
		
		> Move Bar: Key Up / Key Down - Arrow Keys
