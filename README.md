# :: Press Article REST API ::
## Description
The project was made by me using gradle to create any articles for newspapers or magazines. The application is possible to run on computers with JDK versions 8 or 11 installed. 

![spring](https://user-images.githubusercontent.com/73428356/184696142-0d2b37c6-3083-421a-af95-172cb5c1b24d.jpg)

## Technologies used
* Java 11
* Spring
* Hibernate
* Gradle
* Tests (Mockito)

## Endpoints
**1. Get all articles or one of them**
 ```
 > GET - method used to retrieve data from a server using an URL, which is a link that you type in your browser.
 ```
 **2. Add new article**
 ```
 > CREATE - method used to insert new data into the server, it can be data from the user registration.
 ```
 **3. Update**
 ```
 > PUT - method to modify the data stored on the server.
 ```
 **4. Remove an article from the list**
 ```
 > DELETE - method that removes the selected information from the server.
 ```
 
  My application includes such as: 
 * `/getArts` - return all sorted elements of list,  
 * `/getArt` - show one element of list,  
 * `/getArtsByWord` - returning a list of all press articles after the keyword contained in the title or content of the publication,
 * `/createArt` - it's possible to make an article using JSON with properties placed in the class,
 * `/updateArt` - update of the current article,
 * `/deleteArt` - if an article exists it's deleted.
