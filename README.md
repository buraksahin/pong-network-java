Pong Game v1.0
==============

![alt tag](https://lh3.googleusercontent.com/XZtag4if3At2ZYSSZN4b1N_s0SFpSRwPNTeEH7yxqLPrNhU5aBDm6hhsP0AY9uMk85cSBiSBL5ipgHZFH9bmOj5rAAE4cVw2UvgeueRdEcQMMA6adoC4CoNl2OcePFFD7AQ0ef1mHDFAZsptvI9uQxD6eQOykP8n6M_CLu8LLwPZY8jPZT7Hf5Lapd-i26gPhO89Z1H7-Gljzmpxab9CtvJlL-L6qg0DTXRXGwFuokDNGLqgF7G9YIQJwT0TYfWQHqReRaiDP3GiCuSkaQ0_TdzvPkwoKBVbGjZ1uElUhO-Ik_pAWddprDA3mkvVxVXN8Gd-iR7jEV6q3iTjD4IBzBEwqxCEr56bZ5M37poYHnvTDPXtXfTfjmzCZKvI1gBV4kTiEDzKSEtypMq764cAvgbxfloIxhfHgIaOo8FiAISJcB8faOSGNCjEVTBlTYPqFeq84suCXxfrhD1wXSgYvp5UzQVws6vX8UHhFImuoTsoAu91iaaPraEAYE2Ob3PGNJfxzOha-jz5Xf-x9Bxtu83bRZWybcNnv44LaGwHtD-j6tDJAtAJSe-fG9TCTFak2pMgEOL2teJO2IfZZStXYs_qAlMW7yKlXikRVjGd3_Jeuyo=w660-h780-no)


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

Connection and Data Stream
---------------------------
Java network object serialization. 
An object stream cycle provides the connection which behind the server and client.

Game Playing
-------------

	Controls: 
		
		> Move Bar: Key Up / Key Down - Arrow Keys
		

