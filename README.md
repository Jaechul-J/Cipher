CeasarCipher is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. The encryption step performed by a Caesar cipher is often incorporated as part of more complex schemes, such as the Vigenère cipher, and still has modern application in the ROT13 system.

Summary : 

1. The CaesarCipher program first describes what it does.
2. It prompts the user, asking whether the user wants to encode or decode a message.
3. If the user does not respond with either encode or decode, the program displays the valid options to the user (as shown above) and then exits.
4. Otherwise, the program prompts the user for the string to either encode or decode.
5. Finally, rather than shifting according to a user-defined value, the program displays all 26 possible ways of encoding or decoding that string.

VigenereCipher

Summary :

The Vigenère Cipher is a substitution cipher like the Caesar Cipher. However, unlike the Caesar Cipher that has a fixed key, the Vigenère Cipher uses a keyword to shift the plain text. If the length of a keyword is shorter than the plain text, it replicates itself until it matches the length of the plain text.

